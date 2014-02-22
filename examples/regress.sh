#!/bin/bash
export PATH=$PATH:../tools/daig/src/daslc:/home/chaki/stuff/cbmc/cbmc-4.7
TMPF1=$(mktemp)
TMPF2=$(mktemp)

#ensures that the first argument is on the path
function ensure {
    X=$(which $1 | wc -l)
    if [ "$X" == "0" ]; then
        echo "ERROR: $1 not found on PATH"
        exit 1
    fi
}

#ensure key executables exist
ensure daslc
ensure cbmc

#run a single regression test for verification. this function takes
#four arguments: the name of the DASL file, the number of nodes, the
#number of rounds of sequentialization, and the expected result
function verify {
    daslc $1 --seq=$2 --rounds=$3 --out=$TMPF1.c &> /dev/null
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
        printf "%-30s : PASSED\n" $1
    else
        printf "%-30s : FAILED - expected $4 got $MCRES\n" $1
    fi
}

echo "==== testing daslc parsing and printing"
for i in sync-coll-avoid.ok.dasl sync-coll-avoid.bug1.dasl sync-coll-avoid.bug2.dasl \
    sync-mutex.ok.dasl async-coll-avoid.dasl; do 
    daslc $i --print > $TMPF1
    daslc $TMPF1 --print > $TMPF2
    DIFF=$(diff $TMPF1 $TMPF2 | wc -l)
    if [ "$DIFF" == "0" ]; then
        printf "%-30s : PASSED\n" $(basename $i)
    else
        printf "%-30s : FAILED\n" $(basename $i)
    fi
done

echo "==== testing verifier"
verify sync-coll-avoid.ok.dasl 2 4 SUCCESS
verify sync-coll-avoid.bug1.dasl 2 4 FAILURE
verify sync-coll-avoid.bug2.dasl 2 4 FAILURE
verify sync-mutex.ok.dasl 2 4 SUCCESS
