#!/bin/bash

#source the verif file
source $1

CFILE="$(basename $1)_$VERIF_NAME.c"

#create the DMPLC command line
CMD="dmplc --roles $ROLEDESC --cube-grid $GRIDSIZE -r $ROUNDS"
CMD+=" -rp $PROPERTY -o $CFILE $DMPL"
if [ "$VERIF" == "bounded" ]; then
    CMD+=" -s"
elif [ "$VERIF" == "inductive" ]; then
    CMD+=" -si"
else
    echo "ERROR: illegal verification type $VERIF!!" && \
        echo "ERROR: legal values are bounded and inductive!!" && exit 1
fi

$CMD &> /dev/null
if [ "$?" != "0" ]; then
    echo "ERROR: dmplc failed on $DMPL!!"
    echo "Command Line: $CMD"
    exit 1
fi

printf "verification %30s : " $VERIF_NAME

CMD="cbmc $CFILE"
#echo $CMD
RES=$($CMD 2>&1 | grep VERIFICATION | awk '{print $2}')

if [ "$RES" == "$OUT" ]; then
    echo "$RES (expected)"
else
    echo "$RES (unexpected)"
fi

