#!/bin/bash

printf "testing %35s : " "example-01.dmpl"
rm -f example-01.cpp
dmplc -n 3 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 \
      --DRightX 2.25 -g -o example-01.cpp example-01.dmpl &> /dev/null
diff example-01.cpp example-01.cpp.saved &> /dev/null
if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi

##parse a file and output. then parse this output and output
##again. the two outputs should be identical.
function test_double_parse {
    DMPL="$1"
    printf "double parse %30s : " "$DMPL"
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.1.dmpl"
    OUT2="$BN.2.dmpl"
    rm -f $OUT1 $OUT2
    dmplc -n 3 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT1 $DMPL &> /dev/null
    dmplc -n 3 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT2 $OUT1 &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

test_double_parse example-01.dmpl
test_double_parse test-01.dmpl
test_double_parse example-05.dmpl
