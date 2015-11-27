#!/bin/bash

##generate code and check against correct output
function test_code_gen {
    DMPL="$1"
    ROLES="$2"
    printf "code gen     %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.cpp"
    OUT2="$BN.cpp.saved"
    rm -f $OUT1
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -g -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##generate code and compile
function test_build {
    MISSION="$1"
    printf "build        %30s : " $(basename $MISSION)
    (cd $(dirname $MISSION); \
    dmpl-sim.sh -b -B $(basename $MISSION) &> /dev/null; \
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi)
}

##sequentialize and check against correct output
function test_seq {
    DMPL="$1"
    ROLES="$2"
    printf "sequentialize%30s : " $(basename $DMPL)
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
    printf "double parse %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.1.dmpl"
    OUT2="$BN.2.dmpl"
    rm -f $OUT1 $OUT2
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT1 $DMPL &> /dev/null
    dmplc --roles $ROLES --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -p -o $OUT2 $OUT1 &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##verify and check against expected output
function test_verif {
    DMPL="$1"
    ROLES="$2"
    OUTPUT="$3"
    printf "verification %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --DX 5 --DY 5 -r 5 -s -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##verify inductively and check against expected output
function test_verif_ind {
    DMPL="$1"
    ROLES="$2"
    OUTPUT="$3"
    printf "induct verif %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --DX 5 --DY 5 -r 0 -si -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

#double parse tests
test_double_parse test-example-01a.dmpl uav:Uav:3
test_double_parse test-example-01b.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_double_parse test-01.dmpl uav:Leader:1:uav:Protector:4
test_double_parse test-example-02.dmpl uav:Leader:1:uav:Protector:4
test_double_parse test-example-05.dmpl uav:Leader:1:uav:Protector:4
test_double_parse ../../docs/tutorial/example-01.dmpl uav:Uav:3
test_double_parse ../../docs/tutorial/example-01.bug1.dmpl uav:Uav:3
test_double_parse ../../docs/tutorial/example-01.bug2.dmpl uav:Uav:3
test_double_parse ../../docs/tutorial/example-02.dmpl uav:Leader:1:uav:Protector:4
test_double_parse ../../docs/tutorial/example-02.bug1.dmpl uav:Leader:1:uav:Protector:4
test_double_parse ../../docs/tutorial/example-03.dmpl uav:Leader:1:uav:Protector:8
test_double_parse ../../docs/tutorial/example-05/dmpl/example-05.dmpl uav:Leader:1:uav:Protector:4
test_double_parse ../../docs/tutorial/example-07/dmpl/example-07-2.dmpl uav:Tile:9

#code generation tests
test_code_gen test-example-01a.dmpl uav:Uav:3
test_code_gen test-example-02.dmpl uav:Leader:1:uav:Protector:4

#test building
for i in ../../docs/tutorial/*.mission ../../docs/tutorial/example-05/dmpl/*.mission ; do
    test_build $i
done

#sequentialization tests
test_seq test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1

#verification tests
test_verif ../../docs/tutorial/example-01.dmpl uav:Uav:2 SUCCESSFUL
test_verif ../../docs/tutorial/example-01.bug1.dmpl uav:Uav:2 FAILED
test_verif ../../docs/tutorial/example-01.bug2.dmpl uav:Uav:2 FAILED
test_verif ../../docs/tutorial/example-02.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif ../../docs/tutorial/example-02.bug1.dmpl uav:Leader:1:uav:Protector:1 FAILED
test_verif ../../docs/tutorial/example-03.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL

#inductive verification tests
test_verif_ind ../../docs/tutorial/example-01.dmpl uav:Uav:2 SUCCESSFUL
test_verif_ind ../../docs/tutorial/example-01.bug1.dmpl uav:Uav:2 FAILED
test_verif_ind ../../docs/tutorial/example-01.bug2.dmpl uav:Uav:2 FAILED
test_verif_ind ../../docs/tutorial/example-02.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif_ind ../../docs/tutorial/example-02.bug1.dmpl uav:Leader:1:uav:Protector:1 FAILED
test_verif_ind ../../docs/tutorial/example-03.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL

