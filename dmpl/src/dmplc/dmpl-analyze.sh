#!/bin/bash

DEBUG=1

function usage {
    echo "Usage : $0 file.mission input.log output.log"
}

#get inputs
MISSION="$1"
INLOG="$2"
OUTLOG="$3"

if [ "$#" == "2" ]; then
  if [ "$MISSION" = "exp1.mission" ]; then
    for at_least in 25 50 62 75 82 90 95; do
      for thresh in 02 05 08 10 15 20 25 30 40 50 60 70 80 90 95; do
        echo 0,COVERAGE_${at_least}_${thresh} >> $INLOG
      done
    done
  else
    echo Node,Predicate > $INLOG
    echo 0,REACHED_END >> $INLOG
  fi
    exit 0
elif [ "$#" -lt "3" ]; then
    usage
    exit 1
fi

shift
shift
shift

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

. $MISSION


for file in `which dmplc` $DMPL; do
if [ $file -nt ${BIN}-analyze.cpp ]; then
dmplc -a -n $NODENUM --DX $GRIDSIZE --DY $GRIDSIZE -o ${BIN}-analyze.cpp $DMPL
fi
done
if [ ${BIN}-analyze.cpp -nt ${BIN}-analyze ]; then
CFLAGS="-fno-var-tracking -fno-var-tracking-assignments -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT -I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include"
LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
g++ $CFLAGS -o $BIN-analyze ${BIN}-analyze.cpp $LIBS
fi

cat $INLOG | ./$BIN-analyze "$@" > $OUTLOG
