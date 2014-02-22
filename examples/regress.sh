#!/bin/bash
TMPF1=$(mktemp)
TMPF2=$(mktemp)

DASLC=../tools/daig/src/daslc/daslc

#run a single regression test for verification. this function takes
#four arguments: the name of the DASL file, the number of nodes, the
#number of rounds of sequentialization, and the expected result
function verify {
    $DASLC $1 --seq=$2 --rounds=$3 --out=$TMPF1.c &> /dev/null
    cbmc $TMPF1.c &> $TMPF2
    
    #compute model checking result
    MCRES=$(grep "^VERIFICATION SUCCESSFUL" $TMPF2 | wc -l)
    if [ "$MCRES" == "1" ]; then
        MCRES="SUCCESS"
    else
        MCRES=$(grep "^VERIFICATION FAILED" $TMPF2 | wc -l)
        if [ "$MCRES" == "1" ]; then
            MCRES="FAILURE"
        else
            MCRES="UNKNOWN"
        fi
    fi

    if [ "$4" == "$MCRES" ]; then
        echo "$1 : PASSED"
    else
        echo "$1 : FAILED - expected $4 got $MCRES"
    fi
}

echo "==== testing daslc parsing and printing"
for i in sync-coll-avoid.ok.dasl \
    async-coll-avoid.dasl; do 
    $DASLC $i --print > $TMPF1
    $DASLC $TMPF1 --print > $TMPF2
    DIFF=$(diff $TMPF1 $TMPF2 | wc -l)
    if [ "$DIFF" == "0" ]; then
        echo "$(basename $i) : PASSED"
    else
        echo "$(basename $i) : FAILED"
    fi
done

echo "==== testing verifier"
verify sync-coll-avoid.ok.dasl 2 4 SUCCESS
verify sync-coll-avoid.bug1.dasl 2 4 FAILURE
verify sync-coll-avoid.bug2.dasl 2 4 FAILURE
