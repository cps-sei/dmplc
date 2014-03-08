#!/bin/bash

#resource limits
ulimit -t 3600
ulimit -m 16777216 #4194304
ulimit -v 16777216 #4194304

#check usage
if [ "$#" != "1" ]; then
    echo "Usage: $0 A:B:C:D:E"
    echo "   A = experiment name"
    echo "   B = DASL filename"
    echo "   C = number of nodes"
    echo "   D = number of rounds"
    echo "   E = daslc arguments"
    exit 1
fi

#parse the argument
EXPN=$(echo "$1" | awk -F ':' '{print $1}')
echo "BRUNCH_STAT ExpName $EXPN"
DFILE=$(echo "$1" | awk -F ':' '{print $2}')
echo "BRUNCH_STAT DaslFile $DFILE"
NODES=$(echo "$1" | awk -F ':' '{print $3}')
echo "BRUNCH_STAT Nodes $NODES"
ROUNDS=$(echo "$1" | awk -F ':' '{print $4}')
echo "BRUNCH_STAT Rounds $ROUNDS"
DARGS=$(echo "$1" | awk -F ':' '{print $5}' | sed 's/--/ --/g')

TMPF=$(mktemp)
daslc $DFILE --seq=$NODES --rounds=$ROUNDS $DARGS --seq-sem --out=$TMPF.c
#/usr/bin/time -f "BRUNCH_STAT CBMC-Time %e" cbmc $TMPF.c
/usr/bin/time -f "BRUNCH_STAT CPLING-Time %e" ./cbmc-plingeling.sh $TMPF.c
