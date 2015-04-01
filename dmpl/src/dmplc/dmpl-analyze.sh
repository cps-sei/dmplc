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
    echo Node,Predicate > $INLOG
    echo 0,REACHED_END_AND_RISK_INTEGRAL >> $INLOG
    echo 1,REACHED_END_AND_RISK_INTEGRAL >> $INLOG
    echo 2,REACHED_END_AND_RISK_INTEGRAL >> $INLOG
    echo 3,REACHED_END_AND_RISK_INTEGRAL >> $INLOG
    echo 4,REACHED_END_AND_RISK_INTEGRAL >> $INLOG
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


dmplc -a -n $NODENUM --DX $GRIDSIZE --DY $GRIDSIZE -o ${BIN}-analyze.cpp $DMPL
CFLAGS="-g -Og -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT -I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include"
LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
g++ $CFLAGS -o $BIN-analyze ${BIN}-analyze.cpp $LIBS

cat $INLOG | ./$BIN-analyze "$@" > $OUTLOG
