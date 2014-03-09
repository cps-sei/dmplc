#!/bin/bash

#resource limits
CORES=$(cat /proc/cpuinfo | grep processor | wc -l)
ulimit -t $(echo "$CORES * 3600" | bc)
ulimit -m $(echo "16 * 1024 * 1024" | bc) #4194304
ulimit -v $(echo "16 * 1024 * 1024" | bc) #4194304

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
/usr/bin/time -f "BRUNCH_STAT CPLING-Time %e" ./cbmc-plingeling.sh $TMPF.c &> $TMPF.out
cat $TMPF.out
if [ $(grep "s SATISFIABLE" $TMPF.out | wc -l) == "1" ]; then
    echo "BRUNCH_STAT Status BUG"
elif [ $(grep "s UNSATISFIABLE" $TMPF.out | wc -l) == "1" ]; then
    echo "BRUNCH_STAT Status OK"
else
    echo "BRUNCH_STAT Status UNK"
fi

