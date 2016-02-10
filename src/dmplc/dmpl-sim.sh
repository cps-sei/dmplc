#!/bin/bash

# Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
# 1. Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following acknowledgments
# and disclaimers.
#
# 2. Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following
# disclaimer in the documentation and/or other materials provided
# with the distribution.
#
# 3. The names "Carnegie Mellon University," "SEI" and/or "Software
# Engineering Institute" shall not be used to endorse or promote
# products derived from this software without prior written
# permission. For written permission, please contact
# permission@sei.cmu.edu.
#
# 4. Products derived from this software may not be called "SEI" nor
# may "SEI" appear in their names without prior written permission of
# permission@sei.cmu.edu.
#
# 5. Redistributions of any form whatsoever must retain the following
# acknowledgment:
#
# This material is based upon work funded and supported by the
# Department of Defense under Contract No. FA8721-05-C-0003 with
# Carnegie Mellon University for the operation of the Software
# Engineering Institute, a federally funded research and development
# center.
#
# Any opinions, findings and conclusions or recommendations expressed
# in this material are those of the author(s) and do not necessarily
# reflect the views of the United States Department of Defense.
#
# NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
# ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
# BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
# LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
# EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
# MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
# RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
# INFRINGEMENT.
#
# This material has been approved for public release and unlimited
# distribution.
#
# DM-0002494

DEBUG=0

function usage {
    echo "Usage : dmpl-sim.sh [-args] file.mission [output.log]"
    echo "  Optional Arguments:"
    echo "    -b | --force-build  Fully rebuild the cpp file, and recompile it"
    echo "    -B | --build-only   Only build the software, don't run the simulation"
    echo "    -d | --debug        Run with debug options (uses and dmplc --debug, and gdb)"
    echo "    -h | --headless     Run V-REP in headless mode"
    echo "    -M | --manual-start Don't start the simulation automatically"
    echo '    -p | --platform $P  Pass $P as the --platform option to the executable'
    echo '    -l | --log-level $L Pass $L as the -l option to the executable'
    echo "    -r | --realtime     Run V-REP in realtime mode"
    echo "    -R | --record       Run V-REP in recording mode"
    echo "    -G | --debug        Build node binaries with debug flag"
}

#flags
HEADLESS=0
REALTIME=0
FORCEBUILD=0
BUILDONLY=0
MANUALSTART=0
RECORD=""
DBGFLAGS="-O3"
LOG_LEVEL="0"

PLATFORM=vrep-uav::::0.1

argc=0

#get flags
while true; do
    case "$1" in
        -d|--debug)
            DEBUG=1
            ;;
        -b|--force-build)
            FORCEBUILD=1
            ;;
        -B|--build-only)
            BUILDONLY=1
            ;;
        -h|--headless)
            HEADLESS=1
            ;;
        -M|--manual-start)
            MANUALSTART=1
            ;;
        -r|--realtime)
            REALTIME=1
            ;;
        -R|--record)
            RECORD="--record"
            ;;
        -G|--debug)
            DBGFLAGS="-g -Og"
            ;;
        -p|--platform)
            shift
            PLATFORM="$1"
            ;;
        -l|--log-level)
            shift
            LOG_LEVEL="$1"
            ;;
        "")
            break
            ;;
        *)
            case "$argc" in
                0)
                    MISSION="$1"
                    ;;
                1)
                    OUTLOG="$1"
                    ;;
                *)
                    echo Unexpected argument: $1
                    usage
                    exit 1
            esac
            argc=$((argc+1))
            ;;
    esac
    shift
done

GDB=""
[ "$DEBUG" -eq 1 ] && GDB="gdb -ex=r --args"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

if [ -z "$MISSION" ]; then
    echo No .mission file specified
    usage
    exit 1
fi

. $MISSION

#compute NODE_NUM
NODENUM=$(echo $ROLEDESC | awk -F':' '{out=$3; for(i=6;i<=NF;i=i+3){out=out"+"$i}; print out}' | bc -l)

VREP_GRACEFUL_EXIT=0

status_file=""

function cleanup {
    echo "Cleaning up ..."
    [ -n "$status_file" ] && rm $status_file
    
    bin_count=$(ps --no-headers -C "$BIN" | wc -l)

    #kill nodes and VREP
    killall $BIN vrep vrep.sh

    sleep 2

    killall gdb

    sleep 2
    
    killall -9 gdb $BIN vrep vrep.sh
    
    #restore the VREP system/settings.dat
    if [ -f $SDF.saved.mcda-vrep ]; then cp $SDF.saved.mcda-vrep $SDF; fi
    
    echo $bin_count  $NODENUM $VREP_GRACEFUL_EXIT
    if [ "$bin_count" -eq $NODENUM ] && [ "$VREP_GRACEFUL_EXIT" -ge 1 ]; then
        #collate output log
        if [ -n "$OUTLOG" ]; then
            $SCDIR/expect_merge.py $EXPECT_LOG_PERIOD $OUTDIR/expect*.log > $OUTLOG
        fi
    else
        echo "Something crashed; aborting logging"
        if [ -n "$OUTLOG" ]; then
            rm $OUTLOG
        fi
        exit 1
    fi
    
    #all done
    exit 0
}

trap "cleanup" SIGINT SIGTERM SIGHUP

INIT_PORT="19905"

if [ "$REALTIME" -eq 1 ]; then
    MAPFILE=$SCDIR/../../docs/tutorial/dart-${MAPNAME}-rt.ttt
else
    MAPFILE=$SCDIR/../../docs/tutorial/dart-${MAPNAME}.ttt
fi

if [ ! -e "$MAPFILE" ]; then
    echo "Map file $MAPFILE does not exist!!"
    exit 1
fi

#set camera position for record depending on map-type
if [ ! -z "$RECORD" ]; then
    if [ "$MAPNAME" == "small-obstacle" ]; then
        RECORD="$RECORD -0.0499 -6.4213 6.3789"
    else
        RECORD="$RECORD 0.0421 -0.2489 11.2217"
    fi
fi

#compile tutorial 2

MAPSIZE=$(echo $MAPNAME | cut -f1 -d'-')

CPP_FILE=${MISSION}_${BIN}.cpp
DMPLC_FLAGS="-g --roles $ROLEDESC --cube-grid $GRIDSIZE --map $MAPSIZE"
[ ! -z "$GROUPDESC" ] && DMPLC_FLAGS+=" --groups $GROUPDESC"
[ ! -z "$VARGROUPS" ] && DMPLC_FLAGS+=" --var-groups $VARGROUPS"
[ "$DEBUG" -eq 1 ] && DMPLC_FLAGS="$DMPLC_FLAGS --debug"
[ -n "$OUTLOG" ] && DMPLC_FLAGS="$DMPLC_FLAGS -e"

#generate code with dmplc
for file in $(which dmplc) $DMPL $MISSION; do
    if [ $FORCEBUILD -eq 1 ] || [ $file -nt $CPP_FILE ]; then
        echo "dmplc $DMPLC_FLAGS -o $CPP_FILE $DMPL"
        $GDB dmplc $DMPLC_FLAGS -o $CPP_FILE $DMPL
        if [ "$?" != "0" ]; then
            echo "ERROR: dmplc failed on $DMPL!!"
            exit 1
        fi
        break
    fi
done

#compile with g++
if [ $CPP_FILE -nt ${BIN} ]; then
    CFLAGS="$DBGFLAGS -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT "
    CFLAGS+="-I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include -Wno-deprecated-declarations"
    LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
    echo "g++ $CFLAGS -o $BIN $CPP_FILE $LIBS"
    g++ $CFLAGS -o $BIN $CPP_FILE $LIBS

    if [ "$?" != "0" ]; then
        echo "ERROR: g++ failed on $CPP_FILE!!"
        exit 1
    fi
fi

[ "$BUILDONLY" -eq 1 ] && exit 0

#create the output directory and get its realpath
rm -fr $OUTDIR; mkdir $OUTDIR
OUTDIR=$(realpath $OUTDIR)

#save old and create new VREP remoteApiConnections.txt file
RAC=$VREP_ROOT/remoteApiConnections.txt
if [ -e $RAC ]; then
    rm -f $RAC.saved.mcda-vrep
    mv $RAC $RAC.saved.mcda-vrep
fi
touch $RAC
echo "portIndex1_port                 = 19001" >> $RAC
echo "portIndex1_debug                = false" >> $RAC
echo "portIndex1_syncSimTrigger       = true" >> $RAC
echo "" >> $RAC
PORT=$INIT_PORT
for i in $(seq 2 $((NODENUM + 1))); do 
    echo "portIndex${i}_port                 = $PORT" >> $RAC
    echo "portIndex${i}_debug                = false" >> $RAC
    echo "portIndex${i}_syncSimTrigger       = true" >> $RAC
    echo "" >> $RAC
    PORT=$(expr $PORT + 1)
done

#cat $RAC

#save the VREP system/settings.dat
SDF=$VREP_ROOT/system/settings.dat
if [ -f $SDF ]; then cp $SDF $SDF.saved.mcda-vrep; fi
#start vrep
echo "starting VREP .. output is in $OUTDIR/vrep.out ..."

status_file=$(tempfile)

function run_vrep()
{
    cd $VREP_ROOT
    if [ "$HEADLESS" -eq 1 ]; then
        xvfb-run --auto-servernum --server-num=1 -s "-screen 0 640x480x24" ./vrep.sh "-g$MISSION_TIME" "-g$1" -h -q "-b$DMPL_ROOT/src/vrep/timer.lua" $MAPFILE &> $OUTDIR/vrep.out
    else
        ./vrep.sh "-g$MISSION_TIME" "-g$1" -q "-b$DMPL_ROOT/src/vrep/timer.lua" $MAPFILE &> $OUTDIR/vrep.out
    fi
}

(run_vrep "$status_file" &)

sleep 1

SAFETY_TIME=30
START_TIME=$(date +%s)
while [ "$(grep STARTED $status_file | wc -l)" -lt 1 ]; do
    vrep_count=$(ps --no-headers -C "vrep" | wc -l)
    cur_time=$(date +%s)
    if [ $((START_TIME + SAFETY_TIME)) -lt "$cur_time" ]; then
        echo Time limit exceeded\; crash assumed
        cleanup
        exit 1
    fi
    if [ "$vrep_count" -lt 1 ]; then
        echo VREP crashed!
        cleanup
        exit 1
    fi
    sleep 0.2
done

cat $status_file

#restore old VREP remoteApiConnections.txt file
mv $RAC.saved.mcda-vrep $RAC

#map from node pids to command lines
declare -A pid2cmd

#start the nodes
NUMCPU=$(grep -c ^processor /proc/cpuinfo)
[ "$DEBUG" -eq 1 ] && NODE_DEBUG="--debug"
for x in $(seq 1 $((NODENUM - 1))); do
    echo $x
    args_var=ARGS_$x
    cpu_id=$(expr $x % $NUMCPU)
    args="$(eval echo \$$args_var)"
    ELOG=""
    [ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect${0}.log"
    cmd="$GDB ./$BIN $ELOG --platform $PLATFORM --id $x -l $LOG_LEVEL $NODE_DEBUG $args"
    taskset -c ${cpu_id} $cmd &> $OUTDIR/node${x}.out &
    pid=$!
    echo "started pid=$pid : cmd=$cmd"
    pid2cmd[$pid]="$cmd"
done
ELOG=""
[ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect0.log"
#gdb --args $GDB ./$BIN $ELOG --platform $PLATFORM --id 0 $ARGS_0 # &> $OUTDIR/node0.out &
cmd="$GDB ./$BIN $ELOG --platform $PLATFORM --id 0 -l $LOG_LEVEL $NODE_DEBUG $ARGS_0"
taskset -c 0 $cmd &> $OUTDIR/node0.out &
pid=$!
echo "started pid=$pid : cmd=$cmd" 
pid2cmd[$pid]="$cmd"

printf "press Ctrl-C to terminate the simulation ..."

if [ "$DEBUG" -eq 1 ]; then
    sleep 5
else
    sleep 2
fi

[ "$MANUALSTART" -ne 1 ] && ( cd $SCDIR; ./startSim.py $RECORD )

SAFETY_TIME=240
START_TIME=$(date +%s)
while [ "$(grep COMPLETE $status_file | wc -l)" -lt 1 ]; do
    bin_count=$(ps --no-headers -C "$BIN" | wc -l)
    vrep_count=$(ps --no-headers -C "vrep" | wc -l)
    cur_time=$(date +%s)

    #check for timeout
    if [ $((START_TIME + SAFETY_TIME)) -lt "$cur_time" ]; then
        echo Time limit exceeded\; crash assumed
        cleanup
        exit 1
    fi

    #check if all nodes are alive
    for k in "${!pid2cmd[@]}"
    do
        node_alive=$(ps --no-headers ax | awk '{print $1}' | grep "${k}$" | wc -l)
        if [ "$node_alive" == "0" ]; then
            echo A controller crashed!
            echo "pid = $k : cmd = ${pid2cmd[$k]}"
            cleanup
            exit 1
        fi
    done

    #check if VREP is alive
    if [ "$vrep_count" -lt 1 ]; then
        echo VREP crashed!
        cleanup
        exit 1
    fi
    sleep 0.2
done

VREP_GRACEFUL_EXIT=1
cleanup
