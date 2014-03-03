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

#takes three arguments -- an experiment name, a C file name and an
#expected result. runs cbmc on C file, compares result with expected,
#and prints message
function run_cbmc {
    cbmc $2 &> $TMPF2
    
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

    if [ "$3" == "$MCRES" ]; then
        printf "%-35s : PASSED\n" $1
    else
        printf "%-35s : FAILED - expected $3 got $MCRES\n" $1
    fi
}

#run a single regression test for verification. this function takes
#four arguments: the name of the DASL file, the number of nodes, the
#number of rounds of sequentialization, and the expected result
function verify {
    daslc $1 --seq=$2 --rounds=$3 --out=$TMPF1.c &> /dev/null
    run_cbmc "$1" $TMPF1.c "$4"
}

#run a single regression test for verification. this function takes
#four arguments: the name of the DASL file, the number of nodes, the
#number of rounds of sequentialization, and the expected result. this
#does sequentialization with no arrays
function verify_no_array {
    daslc $1 --seq=$2 --rounds=$3 --seq-no-array --out=$TMPF1.c &> /dev/null
    run_cbmc "${1}-no-arr" $TMPF1.c "$4"
}

#test parser
function test_parser {
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
}

#test verification with array-based sequentialization
function test_verif_array {
    echo "==== testing verifier with array sequentialization"
    verify sync-coll-avoid.ok.dasl 2 4 SUCCESS
    verify sync-coll-avoid.bug1.dasl 2 4 FAILURE
    verify sync-coll-avoid.bug2.dasl 2 4 FAILURE
    verify sync-mutex.ok.dasl 2 4 SUCCESS
    verify sync-mutex.bug1.dasl 2 4 FAILURE
    verify sync-mutex.bug2.dasl 2 4 FAILURE
}

#test verification with no-array-based sequentialization
function test_verif_no_array {
    echo "==== testing verifier with no-array sequentialization"
    verify_no_array sync-coll-avoid.ok.dasl 2 4 SUCCESS
    verify_no_array sync-coll-avoid.bug1.dasl 2 4 FAILURE
    verify_no_array sync-coll-avoid.bug2.dasl 2 4 FAILURE
    verify_no_array sync-mutex.ok.dasl 2 4 SUCCESS
    verify_no_array sync-mutex.bug1.dasl 2 4 FAILURE
    verify_no_array sync-mutex.bug2.dasl 2 4 FAILURE
}

#print usage and exit
function usage {
    echo "Usage : $0 <option>"
    echo "Options:"
    echo "     -a: all tests"
    echo "     -p: parser tests"
    echo "    -va: verification tests with array-sequentialization"
    echo "   -vna: verification tests with no-array-sequentialization"
    exit 1
}

if [ "$#" == "0" ]; then
    usage
elif [ "$1" == "-a" ]; then
    test_parser
    test_verif_array
    test_verif_no_array
elif [ "$1" == "-p" ]; then
    test_parser
elif [ "$1" == "-va" ]; then
    test_verif_array
elif [ "$1" == "-vna" ]; then
    test_verif_no_array
else
    usage
fi
