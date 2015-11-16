#!/bin/bash

##generate code and check against correct output
function test_code_gen {
    DMPL="$1"
    ROLES="$2"
    printf "code gen     %30s : " "$DMPL"
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.cpp"
    OUT2="$BN.cpp.saved"
    rm -f $OUT1
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -g -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##sequentialize and check against correct output
function test_seq {
    DMPL="$1"
    ROLES="$2"
    printf "sequentialize%30s : " "$DMPL"
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    OUT2="$BN.c.saved"
    rm -f $OUT1
    dmplc --roles $ROLES -r 5 -s -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##parse a file and output. then parse this output and output
##again. the two outputs should be identical.
function test_double_parse {
    DMPL="$1"
    ROLES="$2"
    printf "double parse %30s : " "$DMPL"
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.1.dmpl"
    OUT2="$BN.2.dmpl"
    rm -f $OUT1 $OUT2
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT1 $DMPL &> /dev/null
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT2 $OUT1 &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

test_double_parse test-example-01a.dmpl uav:Uav:3
test_double_parse test-example-01b.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-01.dmpl uav:Leader:1:uav:Protector:4
test_double_parse test-example-05.dmpl uav:Leader:1:uav:Protector:4
test_code_gen test-example-01a.dmpl uav:Uav:3
test_seq test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
