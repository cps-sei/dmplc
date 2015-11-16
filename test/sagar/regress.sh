#!/bin/bash

# printf "testing %35s : " "test-example-01.dmpl"
# rm -f test-example-01.cpp
# dmplc -n 3 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 \
#       --DRightX 2.25 -g -o test-example-01.cpp test-example-01.dmpl &> /dev/null
# diff test-example-01.cpp test-example-01.cpp.saved &> /dev/null
# if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi

##generate code and check against correct output
function test_code_gen {
    DMPL="$1"
    ROLES="$2"
    printf "code gen     %30s : " "$DMPL"
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.cpp"
    OUT2="$BN.cpp.saved"
    rm -f $OUT1
    dmplc --roles $2 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -g -o $OUT1 $DMPL &> /dev/null
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
    dmplc --roles $2 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT1 $DMPL &> /dev/null
    dmplc --roles $2 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT2 $OUT1 &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

test_double_parse test-example-01a.dmpl uav:Uav:3
test_double_parse test-example-01b.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-01.dmpl uav:Leader:1:uav:Protector:4
test_double_parse test-example-05.dmpl uav:Leader:1:uav:Protector:4
test_code_gen test-example-01a.dmpl uav:Uav:3
