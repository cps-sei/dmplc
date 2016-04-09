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
NODE_DEBUG=""

function usage {
    echo "Usage : dmpl-sim.sh [-args] file.mission"
    echo "  Optional Arguments:"
    echo "    -b | --force-build  Fully rebuild the cpp file, and recompile it"
    echo "    -B | --build-only   Only build the software, don't run the simulation"
    echo "    -d | --debug        Run with debug options (uses dmplc --debug, and gdb)"
    echo "   -nd | --node-debug   Run nodes with --debug option"
    echo "   -ts | --taskset      Bind each node to a specifi CPU"
    echo "    -h | --headless     Run V-REP in headless mode"
    echo "    -M | --manual-start Don't start the simulation automatically"
    echo '    -e | --expect $L    Evaluate expect specs using $L as log file'
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
TASKSET="0"

PLATFORM=vrep-uav::::0.1

argc=0

#get flags
while true; do
    case "$1" in
        -d|--debug)
            DEBUG=1
            ;;
        -nd|--node-debug)
            NODE_DEBUG="--debug"
            ;;
        -ts|--taskset)
            TASKSET="1"
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
        -e|--expect)
            shift
            OUTLOG="$1"
            if [ -z $OUTLOG ]; then
                echo "ERROR: No expect log file specified!!"; usage; exit 1
            fi
            ;;
        -p|--platform)
            shift
            PLATFORM="$1"
            if [ -z $PLATFORM ]; then
                echo "ERROR: No platform specified!!"; usage; exit 1
            fi
            ;;
        -l|--log-level)
            shift
            LOG_LEVEL="$1"
            if [ -z $LOG_LEVEL ]; then
                echo "ERROR: No log level specified!!"; usage; exit 1
            fi
            ;;
        "")
            break
            ;;
        *)
            case "$argc" in
                0)
                    MISSION="$1"
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
MISSION_EXIT=0
status_file=""

#map from node pids to command lines and node ids
declare -A pid2cmd
declare -A pid2node

function cleanup {
    echo "Cleaning up ..."

    #if the status file has not been created, kill all child processes
    #and exit
    if [ -z "$status_file" ]; then
        for p in $(pstree -pal $$ | cut -d, -f2 | cut -d' ' -f1 | grep -v "$$$"); do
            kill $p &> /dev/null
        done
        exit 1
    fi

    #remove status file
    [ -n "$status_file" ] && rm $status_file

    #count number of alive nodes
    bin_count=0
    for k in "${!pid2cmd[@]}"; do
        kill -0 $k &> /dev/null
        if [ "$?" == "0" ]; then bin_count=$(expr $bin_count + 1); fi
    done
    
    #kill nodes and VREP
    for p in $(pstree -pal $$ | cut -d, -f2 | cut -d' ' -f1 | grep -v "$$$"); do
        kill $p &> /dev/null
    done

    #if kill did not work, try kill -9
    if [ $(pstree -pal $$ | cut -d, -f2 | cut -d' ' -f1 | grep -v "$$$" | wc -l) != "0" ]; then
        for p in $(pstree -pal $$ | cut -d, -f2 | cut -d' ' -f1 | grep -v "$$$"); do
            kill -9 $p &> /dev/null
        done
    fi
    
    #restore the VREP system/settings.dat
    [ -f $SDF.saved.mcda-vrep ] && cp $SDF.saved.mcda-vrep $SDF
    
    echo "alive_nodes=$bin_count, total_nodes=$NODENUM, vrep_graceful_exit=$VREP_GRACEFUL_EXIT ..."
    [ "$MISSION_EXIT" == "1" ] && bin_count=$NODENUM
    if [ "$bin_count" -eq $NODENUM ] && [ "$VREP_GRACEFUL_EXIT" -ge 1 ]; then
        #collate output log
        if [ -n "$OUTLOG" ]; then
            echo "collating and analyzing expect log ..."
            $SCDIR/expect_merge.py $EXPECT_LOG_PERIOD $OUTDIR/expect*.log > $OUTLOG
            ./${BIN}_analyze < $OUTLOG &> $OUTLOG.analyze
        fi
    else
        [ "$bin_count" -ne $NODENUM ] && echo "A node crashed; aborting logging"
        [ "$VREP_GRACEFUL_EXIT" -lt 1 ] && echo "VREP crashed; aborting logging"
        echo "Something crashed; aborting logging"
        [ -n "$OUTLOG" ] && rm -f $OUTLOG
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
[ ! -z "$RECORD" ] && [ -z "$REC_CAM_POS" ] && \
    echo "ERROR: cannot record .. no REC_CAM_POS specified in mission file ..." && \
    exit 1
[ ! -z "$RECORD" ] && RECORD="$RECORD $REC_CAM_POS"

MAPSIZE=$(echo $MAPNAME | cut -f1 -d'-')
CPP_FILE=${MISSION}_${BIN}.cpp
ANALYZE_FILE=${MISSION}_${BIN}_analyze.cpp

#function to compile DMPL file with dmplc. takes three arguments --
#the output C++ file, options to dmplc, and the DMPL file.
function compile_dmpl {
    OUT_FILE="$1" && shift && OPTS="$1" && shift && IN_FILE="$*"

    DMPLC_FLAGS="$OPTS --roles $ROLEDESC --map $MAPSIZE"
    [ ! -z "$GRIDSIZE" ] && GRID_X=$GRIDSIZE && GRID_Y=$GRIDSIZE && GRID_Z=$GRIDSIZE
    DMPLC_FLAGS+=" --grid-x $GRID_X --grid-y $GRID_Y --grid-z $GRID_Z"
    [ ! -z "$GROUPDESC" ] && DMPLC_FLAGS+=" --groups $GROUPDESC"
    [ ! -z "$VARGROUPS" ] && DMPLC_FLAGS+=" --var-groups $VARGROUPS"

    #generate code with dmplc
    for file in $(which dmplc) $IN_FILE $MISSION; do
        if [ $FORCEBUILD -eq 1 ] || [ $file -nt $OUT_FILE ]; then
            echo "dmplc $DMPLC_FLAGS -o $OUT_FILE $IN_FILE"
            $GDB dmplc $DMPLC_FLAGS -o $OUT_FILE $IN_FILE
            if [ "$?" != "0" ]; then
                echo "ERROR: dmplc failed on $IN_FILE!!"
                cleanup
            fi
            break
        fi
    done
}

#compile with dmplc
if [ ! -z "$PRE_DMPLC_CMD" ]; then
    $PRE_DMPLC_CMD &
    wait
fi
DMPLC_OPTS="-g"
[ -n "$OUTLOG" ] && DMPLC_OPTS="$DMPLC_OPTS -e"
compile_dmpl $CPP_FILE "$DMPLC_OPTS" $DMPL &
wait
if [ -n "$OUTLOG" ]; then
    compile_dmpl $ANALYZE_FILE "-a" $DMPL &
    wait
fi

#function to compile CPP file with g++. takes two arguments -- the
#output executable and the CPP file.
function compile_cpp {
    OUT_FILE="$1" && IN_FILE="$2"
    if [ $IN_FILE -nt ${OUT_FILE} ]; then
        CFLAGS="$DBGFLAGS -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT "
        CFLAGS+="-I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include -Wno-deprecated-declarations"
        LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
        echo "g++ $CFLAGS -o $OUT_FILE $IN_FILE $LIBS"
        g++ $CFLAGS -o $OUT_FILE $IN_FILE $LIBS
        
        if [ "$?" != "0" ]; then
            echo "ERROR: g++ failed on $IN_FILE!!"
            cleanup
        fi
    fi
}

#compile with g++
compile_cpp ${BIN} $CPP_FILE &
wait
if [ -n "$OUTLOG" ]; then
    compile_cpp ${BIN}_analyze $ANALYZE_FILE &
    wait
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

#create temp file to record VREP status
status_file=$(mktemp /tmp/dmpl-sim.sh.XXXXXXXX)
[ ! -f $status_file ] && echo "ERROR: couldn't create temp file!!" && cleanup

function run_vrep()
{
    cd $VREP_ROOT
    if [ "$HEADLESS" -eq 1 ]; then
        xvfb-run --auto-servernum --server-num=1 -s "-screen 0 640x480x24" ./vrep.sh "-g$MISSION_TIME" "-g$1" -h -q "-b$DMPL_ROOT/src/vrep/timer.lua" $MAPFILE &> $OUTDIR/vrep.out &
    else
        ./vrep.sh "-g$MISSION_TIME" "-g$1" -q "-b$DMPL_ROOT/src/vrep/timer.lua" $MAPFILE &> $OUTDIR/vrep.out &
    fi
    cd - >& /dev/null
}

run_vrep "$status_file"
sleep 1

#wait for vrep to fire up properly
SAFETY_TIME=30
START_TIME=$(date +%s)
while [ "$(grep STARTED $status_file | wc -l)" -lt 1 ]; do
    cur_time=$(date +%s)
    if [ $((START_TIME + SAFETY_TIME)) -lt "$cur_time" ]; then
        echo "VREP start time limit exceeded\; VREP crash assumed!"
        cleanup
        exit 1
    fi
    vrep_count=$(pstree -pal $$ | grep "vrep," | wc -l)
    if [ "$vrep_count" -lt 1 ]; then
        echo "VREP crashed!"
        cleanup
        exit 1
    fi
    sleep 0.2
done

#cat $status_file
echo "VREP fired up properly .. now starting nodes ..."

#restore old VREP remoteApiConnections.txt file
mv $RAC.saved.mcda-vrep $RAC

#start the nodes
[ ! -z "$PRE_SIM_CMD" ] && $PRE_SIM_CMD
NUMCPU=$(grep -c ^processor /proc/cpuinfo)
for x in $(seq 1 $((NODENUM - 1))); do
    args_var=ARGS_$x
    eargs_var=EARGS_$x
    cpu_id=$(expr $x % $NUMCPU)
    args="$(eval echo \$$args_var) $(eval echo \$$eargs_var)"
    ELOG=""
    [ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect${x}.log"
    cmd="$GDB ./$BIN $ELOG --platform $PLATFORM --id $x -l $LOG_LEVEL $NODE_DEBUG $args"
    if [ "$TASKSET" == "1" ]; then
        taskset -c ${cpu_id} $cmd &> $OUTDIR/node${x}.out &
    else
        $cmd &> $OUTDIR/node${x}.out &
    fi
    pid=$!
    echo "started node $x pid=$pid : cmd=$cmd"
    pid2cmd[$pid]="$cmd"
    pid2node[$pid]="$x"
done
ELOG=""
[ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect0.log"
#gdb --args $GDB ./$BIN $ELOG --platform $PLATFORM --id 0 $ARGS_0 # &> $OUTDIR/node0.out &
cmd="$GDB ./$BIN $ELOG --platform $PLATFORM --id 0 -l $LOG_LEVEL $NODE_DEBUG $ARGS_0"
if [ "$TASKSET" == "1" ]; then
    taskset -c 0 $cmd &> $OUTDIR/node0.out &
else
    $cmd &> $OUTDIR/node0.out &
fi
pid=$!
echo "started node 0 pid=$pid : cmd=$cmd" 
pid2cmd[$pid]="$cmd"
pid2node[$pid]="0"

printf "press Ctrl-C to terminate the simulation ..."

if [ "$DEBUG" -eq 1 ]; then
    sleep 5
else
    sleep 2
fi

[ "$MANUALSTART" -ne 1 ] && ( cd $SCDIR; ./startSim.py $RECORD )

if [ -z $MISSION_TIME ]; then SAFETY_TIME=240; else SAFETY_TIME=$MISSION_TIME; fi
START_TIME=$(date +%s)
while [ "$(grep COMPLETE $status_file | wc -l)" -lt 1 ]; do
    #check for timeout
    cur_time=$(date +%s)
    if [ $((START_TIME + SAFETY_TIME)) -lt "$cur_time" ]; then
        echo "Time limit exceeded\; crash assumed ..."
        cleanup
        exit 1
    fi

    #check if all nodes are alive
    for k in "${!pid2cmd[@]}"; do
        srch="node ${pid2node[$k]} exited mission with code "
        mission_exit=$(grep "$srch" $OUTDIR/node${pid2node[$k]}.out | wc -l)
        [ "$mission_exit" != "0" ] && MISSION_EXIT=1 && VREP_GRACEFUL_EXIT=1 && cleanup
        kill -0 $k &> /dev/null
        if [ "$?" != "0" ]; then
            mission_exit=$(grep "$srch" $OUTDIR/node${pid2node[$k]}.out | wc -l)
            [ "$mission_exit" != "0" ] && MISSION_EXIT=1 && VREP_GRACEFUL_EXIT=1 && cleanup
            echo "Node ${pid2node[$k]} crashed!"
            echo "Node id = ${pid2node[$k]} : pid = $k : cmd = ${pid2cmd[$k]}"
            cleanup
            exit 1
        fi
    done

    #check if VREP is alive
    vrep_count=$(pstree -pal $$ | grep "vrep," | wc -l)
    if [ "$vrep_count" -lt 1 ]; then
        echo "VREP crashed!"
        cleanup
        exit 1
    fi
    sleep 0.2
done

VREP_GRACEFUL_EXIT=1
cleanup
