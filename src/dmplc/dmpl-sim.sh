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
DMPL_DEADLINE=1	# default deadline for purging MADARA messages older than 1 second

function usage {
    echo "Usage : dmpl-sim.sh [-args] file.mission"
    echo "  Optional Arguments:"
    echo "    -b | --force-build  Fully rebuild the cpp file, and recompile it"
    echo "    -B | --build-only   Only build the software, don't run the simulation"
    echo "    -d | --debug        Run with debug options (uses dmplc --debug, and gdb)"
    echo "   -nd | --node-debug   Run nodes with --debug option"
    echo "   -ts | --taskset      Bind each node to a specifi CPU"
    echo "    -h | --headless     Run V-REP in headless mode"
    echo '    -k | --deadline $DL Set deadline for dropping old messages (-1 disables)'
    echo "    -M | --manual-start Don't start the simulation automatically"
    echo '    -e | --expect $L    Evaluate expect specs using $L as log file'
    echo '    -p | --platform $P  Pass $P as the --platform option to the executable'
    echo '    -l | --log-level $L Pass $L as the -l option to the executable'
    echo "    -r | --realtime     Run V-REP in realtime mode"
    echo "    -R | --record       Run V-REP in recording mode"
    echo "    -G | --debug        Build node binaries with debug flag"
    echo "    -F | --fastdeploy   (re-)Deployed mission without compile or checks"
    echo "    -T | --timeset      use date over ssh to set date/time before deployment"
    echo "    -D | --deploy       Build nodes to distributed devices"
}

#flags
HEADLESS=0
DEPLOY=0
FASTDEPLOY=0
TIMESET=0
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
        -k|--deadline)
            shift
            DMPL_DEADLINE="$1"
            if [ -z "{$DMPL_DEADLINE}" ]; then
                echo "ERROR: No deadline specified!!"; usage; exit 1
            fi
            ;;
        -M|--manual-start)
            MANUALSTART=1
            ;;
        -r|--realtime)
            REALTIME=1
            ;;
        -D|--deploy)
            DEPLOY=1
            ;;
        -F|--fastdeploy)
            DEPLOY=1
            FASTDEPLOY=1
            ;;
        -T|--timeset)
            TIMESET=1
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

SSH_OPTS="-o PreferredAuthentications=publickey -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o LogLevel=quiet"

source $MISSION

if [ ${DEPLOY} -gt 0 ]; then
  deployfile=$(echo ${MISSION}|sed 's/.mission$/.deploy/g')
  if [ ! -f "${deployfile}" ]; then
    echo No .deploy file specified for ${MISSION}
    usage
    exit 1
  fi
  source ${deployfile}
  echo "Will deploy nodes to devices specified in ${deployfile}"
fi

#compute NODE_NUM
NODENUM=$(echo $ROLEDESC | awk -F':' '{out=$3; for(i=6;i<=NF;i=i+3){out=out"+"$i}; print out}' | bc -l)

VREP_GRACEFUL_EXIT=0
MISSION_EXIT=0
status_file=""

#map from node pids to command lines and node ids
declare -A pid2cmd
declare -A pid2node
declare -A device2pilot
declare -A device2commandnet
declare -A device2drivepath

MISSION_MCAST=239.255.0.0/24
MISSION_MDOMAIN=239.255.0.1:4150
if [ ${DEPLOY} -gt 0 ]; then
  #
  # determine which local net iface is used to get to the COMMAND_SUBNET
  # as the IP addr of that iface will be the IP addr VREP can accept connections
  #
  VREPSERVERIF=$(ip -o route get ${COMMAND_SUBNET}.0 | \
                egrep --only-matching "dev[[:space:]][[:alnum:]]*[[:space:]]" | \
                sed 's/dev //g')
  VREPSERVERIP=$(ifconfig -a ${VREPSERVERIF} | \
                grep "inet addr" | \
                cut -d: -f2 | cut -d\  -f1)
fi

[ ${DEPLOY} -gt 0 ] && PLATFORM=$(echo $PLATFORM | sed "s/::/:${VREPSERVERIP}:/")
#
# tell remote node where DART HOME is which should
# become the basis for 'vrep' and 'dmplc' HOMEs
#
# this field is not yet supported in init_vrep() (gen'ed from dmplc)
#
[ ${DEPLOY} -gt 0 ] && PLATFORM=$(echo $PLATFORM:$(realpath ${GAMS_ROOT}/resources/vrep))

function setpilots() {
  for d in $(seq 0 $(($NODENUM-1))); do
    _v=$(echo ${DEVICES[${d}]}|cut -d: -f1)
    if [ -z "${_v}" ]; then
       echo malformed field in DEVICES[${d}], found "${DEVICES[${d}]}"
       exit 1
    fi
    device2pilot[${d}]=${_v}
  done
}

function setcommandnet() {
  for d in $(seq 0 $(($NODENUM-1))); do
    _v=$(echo ${DEVICES[${d}]}|cut -d: -f2)
    if [ -z "${_v}" ]; then
       echo malformed field in DEVICES[${d}], found "${DEVICES[${d}]}"
       exit 1
    fi
    device2commandnet[${d}]=${_v}
  done
}

function setdrivepath() {
  for d in $(seq 0 $(($NODENUM-1))); do
    _v=$(echo ${DEVICES[${d}]}|cut -d: -f3)
    if [ -z "${_v}" ]; then
       echo malformed field in DEVICES[${d}], found "${DEVICES[${d}]}"
       exit 1
    fi
    device2drivepath[${d}]=${_v}
  done
}

function setdatetime_ssh() {
  for d in $(seq 0 $(($NODENUM-1))); do
    if [ "${device2commandnet[${d}]}" = "${VREPSERVERIP}" ]; then
      echo "matched ip address"
      continue
    fi
    _epochseconds=$(date +%s)
    ssh ${SSH_OPTS} \
      ${device2pilot[${d}]}@${device2commandnet[${d}]} \
      "sudo /bin/date --set=@${_epochseconds}"
    [ ! "${?}" = "0" ] && \
      echo "add/append '%sudo   ALL=(ALL) NOPASSWD: /bin/date' to ${device2pilot[${d}]}@${device2commandnet[${d}]}:/etc/sudoers" && \
    _rc=${?}
  done
}

function test_missionsubnet() {
  if [ "${COMMAND_SUBNET}" = "${MISSION_SUBNET}" ]; then
    # subnets are the same no need to test
    return
  fi

  _out=0
  for d in $(seq 0 $(($NODENUM-1))); do
    ssh ${SSH_OPTS} \
      ${device2pilot[${d}]}@${device2commandnet[${d}]} \
      "ifconfig -a | grep ${MISSION_SUBNET}"
    [ ! "${?}" = "0" ] && \
      echo "mission subnet: ${MISSION_SUBNET} does not appear to exist at ${device2commandnet[${d}]}" && _out=$((_out+1))
  done

  [ ${_out} -gt 0 ] && echo ${_out} out of ${NODENUM} not on ${MISSION_SUBNET} && exit -1
  return
}

function test_passwdless_ssh() {

  for d in $(seq 0 $(($NODENUM-1))); do
    echo testing for ssh to: ${device2pilot[${d}]}@${device2commandnet[${d}]}
    #
    # test for authorized_keys on deployment device and correct drivepath
    #
    ssh ${SSH_OPTS} \
      ${device2pilot[${d}]}@${device2commandnet[${d}]} \
      "ls -ld ${device2drivepath[${d}]}/setenv.sh >/dev/null 2>&1"
    _rc=${?}
    #
    [ "${_rc}" = "255" ] && \
      echo "host not found -OR- add/append .ssh/id_rsa.pub to ${device2pilot[${d}]}@${device2commandnet[${d}]}:.ssh/authorized_keys" && \
      exit
    #
    [ "${_rc}" = "2" ] && \
      echo "the DART file '${device2drivepath[${d}]}/setenv.sh' was not found at ${device2pilot[${d}]}@${device2commandnet[${d}]}" && \
      exit
    #
    [ ! "${_rc}" = "0" ] && \
      echo "${_rc}: something else failed when communicating with ${device2pilot[${d}]}@${device2commandnet[${d}]}, please send the error report in /tmp/darterror${$}.txt" && \
      set > /tmp/darterror${$}.txt && \
      exit
    #
    # test to see that ID on deployment device can manipulate route table
    # MADARA multicast message must be routed to the network_if used for the mission
    #
    ssh ${SSH_OPTS} \
      ${device2pilot[${d}]}@${device2commandnet[${d}]} \
      "sudo route -n >/dev/null"
    [ ! "${?}" = "0" ] && \
      echo "add/append '%sudo   ALL=(ALL) NOPASSWD: /sbin/route' to ${device2pilot[${d}]}@${device2commandnet[${d}]}:/etc/sudoers" && \
      exit
  done
}

[ ${DEPLOY} -gt 0 ] && setpilots && setcommandnet && setdrivepath 

[ ${FASTDEPLOY} -eq 0 -a ${DEPLOY} -gt 0 ] && test_passwdless_ssh && echo done test of passwdless ssh test

[ ${TIMESET} -gt 0 -a ${DEPLOY} -gt 0 ] && setdatetime_ssh

[ ${DEPLOY} -gt 0 ] && test_missionsubnet

function dmplc-build-device() {
  #
  # TBD: VREPSERVERIP will be used to build the local node
  # so ignore that particular node for this purpose
  #
  for d in $(seq 0 $(($NODENUM-1))); do
    if [ "${device2commandnet[${d}]}" = "${VREPSERVERIP}" ]; then
      continue
    fi
    devindex=${d}
    echo ${devindex} && return
  done
  echo ""
}

function launch() {
  #
  # runs a command in a screen session as a daemon and routes output to log file
  #
  cp /dev/null $OUTDIR/${1}.out
  echo ${2} | sed 's/\$/\\$/g' > /tmp/remote.${1}.cmd
  screen -dmS ${1} \
    sh -c \
    "pwd >$OUTDIR/${1}.out 2>&1; $(cat /tmp/remote.${1}.cmd) >>$OUTDIR/${1}.out 2>&1"
}

function deploymentwait() {
  if [ ${DEPLOY} -gt 0 ]; then
    # build nodesup logic in karl
    echo ".nodes.ready = 0 ;>" >  /tmp/nodesup.krl
    echo "startSync.0 >= 2 &&" >> /tmp/nodesup.krl 

    for x in $(seq 1 $((NODENUM - 1))); do
      cat <<__KARLSCRIPT >> /tmp/nodesup.krl
  startSync.${x} >= 2 &&
__KARLSCRIPT
    done

    echo "  1 == 1 => .nodes.ready = 1 ;>" >> /tmp/nodesup.krl
    echo "(.nodes.ready > 0)" >> /tmp/nodesup.krl

    scp ${SSH_OPTS} \
      /tmp/nodesup.krl \
      ${device2pilot[0]}@${device2commandnet[0]}:/tmp/nodesup.krl

    ssh ${SSH_OPTS} \
      ${device2pilot[0]}@${device2commandnet[0]} \
      "source ${device2drivepath[0]}/setenv.sh; \
       karl -m ${MISSION_MDOMAIN} -i /tmp/nodesup.krl -y 10 -ky  -w 30000 -c > /tmp/karl.out 2>&1"
  fi
}

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

    #count number of alive local nodes
    bin_count=0
    for k in "${!pid2cmd[@]}"; do
        kill -0 $k &> /dev/null
        if [ "$?" == "0" ]; then bin_count=$(expr $bin_count + 1); fi
    done
    
    #kill off remote nodes!
    [ ${DEPLOY} -gt 0 ] && for k in $(seq 0 $(($NODENUM-1))); do
	  echo node running at device: ${device2commandnet[${k}]}, killing...
	  ssh ${SSH_OPTS} ${device2pilot[${k}]}@${device2commandnet[${k}]} "killall ${BIN}; sudo route del -net ${MISSION_MCAST}"
	done

    #kill local nodes and VREP
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
    
    #
    # do this locally as well, node 0 is always here
    # SAH: will not always be true
    # TBD: should only need to be done if any node is deployed here (locally with VREP)
    #
    [ ${DEPLOY} -gt 0 ] && sudo route del -net ${MISSION_MCAST}

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
                rm -f $OUT_FILE
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
DMPLC_OPTS="-g -dl ${DMPL_DEADLINE}"
[ -n "$OUTLOG" ] && DMPLC_OPTS="$DMPLC_OPTS -e"
compile_dmpl $CPP_FILE "$DMPLC_OPTS" $DMPL &
wait
[ ! -f $CPP_FILE ] && cleanup
if [ -n "$OUTLOG" ]; then
    compile_dmpl $ANALYZE_FILE "-a" $DMPL &
    wait
    [ ! -f $ANALYZE_FILE ] && cleanup
fi

function compile_cpp_on_node() {
  # pick a device to build the mission on
  _di=$(dmplc-build-device)
  [ -z "${_di}" ] && echo "running locally, no remote compilation necessary" && return
  echo deviceindex: ${_di}

  # copy/rsync
  echo copying files
  rsync -avz \
    -e "ssh ${SSH_OPTS}" \
    --progress ${DMPL} ${MISSION} \
    ${device2pilot[${_di}]}@${device2commandnet[${_di}]}:$(ssh ${SSH_OPTS} ${device2pilot[${_di}]}@${device2commandnet[${_di}]} "source ${device2drivepath[${_di}]}/setenv.sh; echo \$DMPL_ROOT/docs/tutorial/")

  echo remotely building
  #
  # -B build only; -b force build (may not need -b here)
  #
  ssh ${SSH_OPTS} \
    ${device2pilot[${_di}]}@${device2commandnet[${_di}]} \
    "source ${device2drivepath[${_di}]}/setenv.sh; cd \$DMPL_ROOT/docs/tutorial; pwd; dmpl-sim.sh -k ${DMPL_DEADLINE} -B -b ${MISSION};"

  [ ! "${?}" = "0" ] && \
    echo "remote build at ${device2pilot[${_di}]}@${device2commandnet[${_di}]} failed...stopping remote deployment and mission" && \
    exit

  echo replicating binary to other nodes
  scp ${SSH_OPTS} \
    ${device2pilot[${_di}]}@${device2commandnet[${_di}]}:$(ssh ${SSH_OPTS} ${device2pilot[${_di}]}@${device2commandnet[${_di}]} "source ${device2drivepath[${_di}]}/setenv.sh; echo \$DMPL_ROOT/docs/tutorial/")/${BIN} \
    /tmp/${BIN}.node-compiled

  for d in $(seq 0 $(($NODENUM-1))); do
    #
    # skip 'this' node
    #
    if [ "${device2commandnet[${d}]}" = "${VREPSERVERIP}" ]; then
      echo "matched ip address"
      continue
    fi
    scp ${SSH_OPTS} \
      /tmp/${BIN}.node-compiled \
      ${device2pilot[${d}]}@${device2commandnet[${d}]}:$(ssh ${SSH_OPTS} ${device2pilot[${d}]}@${device2commandnet[${d}]} "source ${device2drivepath[${d}]}/setenv.sh; echo \$DMPL_ROOT/docs/tutorial/")${BIN}
    ssh ${SSH_OPTS} \
      ${device2pilot[${d}]}@${device2commandnet[${d}]} \
      "source ${device2drivepath[${d}]}/setenv.sh; md5sum \$DMPL_ROOT/docs/tutorial/${BIN}"
  done

  echo remote build and deployment done.
}

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
            rm -f $OUT_FILE
            cleanup
        fi
    fi
}

#compile with g++
compile_cpp ${BIN} $CPP_FILE &
wait
[ ! -f ${BIN} ] && cleanup
if [ -n "$OUTLOG" ]; then
    compile_cpp ${BIN}_analyze $ANALYZE_FILE &
    wait
    [ ! -f ${BIN}_analyze ] && cleanup
fi

[ ${FASTDEPLOY} -eq 0 -a ${DEPLOY} -gt 0 ] \
   && compile_cpp_on_node ${BIN} $CPP_FILE

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
      if [ ${DEPLOY} -gt 0 ]; then
        echo deploying node ${x} to ${device2pilot[${x}]}@${device2commandnet[${x}]}

        launch \
          "node${x}" \
          "ssh ${SSH_OPTS} \
            ${device2pilot[${x}]}@${device2commandnet[${x}]} \
            \"source ${device2drivepath[${x}]}/setenv.sh; \
            cd \$DMPL_ROOT/docs/tutorial; \
            pwd; \
            sudo route add -net ${MISSION_MCAST} dev \
              \$(ifconfig -a | grep --before-context=2 inet\ addr:${MISSION_SUBNET} | egrep --only-matching "^[[:alnum:]]?*"); \
            ${cmd}\" "
      else
        $cmd &> $OUTDIR/node${x}.out &
      fi
    fi
    if [ ${DEPLOY} -gt 0 ]; then
      pid=$(screen -ls|grep node${x}|cut -d. -f1)
      while [ -z "${pid}" ]; do
        echo race condition: pid empty, retrying...; sleep 0.5
        pid=$(screen -ls|grep node${x}|cut -d. -f1)
      done
    else
      pid=$!
      echo "started node $x pid=$pid : cmd=$cmd"
    fi
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
    if [ ${DEPLOY} -gt 0 ]; then
      x=0
      echo deploying node ${x} to ${device2pilot[${x}]}@${device2commandnet[${x}]}
      launch \
        "node${x}" \
        "ssh ${SSH_OPTS} \
          ${device2pilot[${x}]}@${device2commandnet[${x}]} \
          \"source ${device2drivepath[${x}]}/setenv.sh; \
          cd \$DMPL_ROOT/docs/tutorial; \
          pwd; \
          sudo route add -net ${MISSION_MCAST} dev \
          \$(ifconfig -a | grep --before-context=2 inet\ addr:${MISSION_SUBNET} | egrep --only-matching "^[[:alnum:]]?*"); \
          ${cmd}\" "
    else
      $cmd &> $OUTDIR/node0.out &
    fi
fi
if [ ${DEPLOY} -gt 0 ]; then
  pid=$(screen -ls|grep node${x}|cut -d. -f1)
else
  pid=$!
  echo "started node 0 pid=$pid : cmd=$cmd"
fi
pid2cmd[$pid]="$cmd"
pid2node[$pid]="0"

printf "press Ctrl-C to terminate the simulation ..."

function localwait() {
  KARLFILE=`tempfile` || return 1
  karl -m $MISSION_MDOMAIN -y 10 -c -w 30 "begin_sim == 1" -s $KARLFILE
  if grep "begin_sim=\"1\"" $KARLFILE; then
    rm $KARLFILE
    return 0
  else
    rm $KARLFILE
    return 1
  fi
}

[ ${DEPLOY} -gt 0 ] && deploymentwait || localwait

[ "$MANUALSTART" -ne 1 ] && ( cd $SCDIR; ./startSim.py $RECORD )

if [ -z $MISSION_TIME ]; then SAFETY_TIME=240; else SAFETY_TIME=$MISSION_TIME; fi

echo "Mission time is ${MISSION_TIME}"

echo pid2cmd: ${!pid2cmd[@]}
echo pid2node: ${!pid2node[@]}

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
