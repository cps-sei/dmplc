#!/bin/bash

DEBUG=0

function usage {
    echo "Usage : $0 file.mission [output.log]"
}

#flags
HEADLESS=0

#get flags
while true; do
  case "$1" in
  -h)
    HEADLESS=1
    ;;
  *)
    break
    ;;
  esac
  shift
done

#get inputs
MISSION="$1"
OUTLOG="$2"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

if [ "$#" -lt 1 -o "$#" -gt 2 ]; then
    usage
    exit 1
fi

. $MISSION

VREP_GRACEFUL_EXIT=0

status_file=""

function cleanup {
    echo "Cleaning up ..."
    [ -n "$status_file" ] && rm $status_file

    bin_count=`ps --no-headers -C "$BIN" | wc -l`

    #kill nodes and VREP
    killall $BIN vrep vrep.sh

    sleep 2

    killall gdb

    sleep 2

    killall -9 gdb $BIN vrep vrep.sh
    
    #restore the VREP system/settings.dat
    cp $SDF.saved.mcda-vrep $SDF

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

MAPFILE=$SCDIR/../../docs/tutorial/dart-${MAPNAME}.ttt

if [ ! -e "$MAPFILE" ]; then
    echo "Map file $MAPFILE does not exist!!"
    exit 1
fi

#compile tutorial 2

if [ "$MAPNAME" == "small" ]; then
    TopY=2.25
    LeftX=-2.25
    BottomY=-2.25
    RightX=2.25
elif [ "$MAPNAME" == "large" ]; then
    TopY=13
    LeftX=-12.5
    BottomY=-6
    RightX=6.5
fi

for file in `which dmplc` $DMPL $MISSION; do
if [ $file -nt ${BIN}.cpp ]; then
dmplc -e -n $NODENUM --DX $GRIDSIZE --DY $GRIDSIZE --DTopY $TopY --DBottomY $BottomY --DLeftX $LeftX --DRightX $RightX -g -o ${BIN}.cpp $DMPL
break
fi
done
if [ ${BIN}.cpp -nt ${BIN} ]; then
CFLAGS="-g -Og -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT -I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include"
LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
g++ $CFLAGS -o $BIN ${BIN}.cpp $LIBS
fi

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
for i in `seq 2 $((NODENUM + 1))`; do 
    echo "portIndex${i}_port                 = $PORT" >> $RAC
    echo "portIndex${i}_debug                = false" >> $RAC
    echo "portIndex${i}_syncSimTrigger       = true" >> $RAC
    echo "" >> $RAC
    PORT=$(expr $PORT + 1)
done

#cat $RAC

#save the VREP system/settings.dat
SDF=$VREP_ROOT/system/settings.dat
cp $SDF $SDF.saved.mcda-vrep
#start vrep
echo "starting VREP .. output is in $OUTDIR/vrep.out ..."

status_file=`tempfile`

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
START_TIME=`date +%s`
while [ "`grep STARTED $status_file | wc -l`" -lt 1 ]; do
  vrep_count=`ps --no-headers -C "vrep" | wc -l`
  cur_time=`date +%s`
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

#start the nodes
GDB=""
NUMCPU=$(grep -c ^processor /proc/cpuinfo)
[ "$DEBUG" -ne 0 ] && GDB="gdb -ex=r --args"
for x in `seq 1 $((NODENUM - 1))`; do
  echo $x
  args_var=ARGS_$x
  cpu_id=$(expr $x % $NUMCPU)
  args="$(eval echo \$$args_var)"
  ELOG=""
  [ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect${0}.log"
  taskset -c ${cpu_id} $GDB ./$BIN $ELOG --platform vrep::::0.1 --id $x $args &> $OUTDIR/node${x}.out &
done
ELOG=""
[ -n "$OUTLOG" ] && ELOG="-e $OUTDIR/expect0.log"
#gdb --args $GDB ./$BIN $ELOG --platform vrep::::0.1 --id 0 $ARGS_0 # &> $OUTDIR/node0.out &
taskset -c 0 $GDB ./$BIN $ELOG --platform vrep::::0.1 --id 0 $ARGS_0 &> $OUTDIR/node0.out &

printf "press Ctrl-C to terminate the simulation ..."

sleep 2

( cd $SCDIR; ./startSim.py )

SAFETY_TIME=240
START_TIME=`date +%s`
while [ "`grep COMPLETE $status_file | wc -l`" -lt 1 ]; do
  bin_count=`ps --no-headers -C "$BIN" | wc -l`
  vrep_count=`ps --no-headers -C "vrep" | wc -l`
  cur_time=`date +%s`
  if [ $((START_TIME + SAFETY_TIME)) -lt "$cur_time" ]; then
    echo Time limit exceeded\; crash assumed
    cleanup
    exit 1
  fi
  if [ "$bin_count" -ne $NODENUM ]; then
    echo A controller crashed!
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

VREP_GRACEFUL_EXIT=1
cleanup
