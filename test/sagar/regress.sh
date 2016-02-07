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
    dmplc --roles $ROLES --cube-grid 10 --map small -g -o $OUT1 $DMPL &> /dev/null
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
    dmplc --cube-grid 10 --roles $ROLES -r 5 -s -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##sequentialize inductively and check against correct output
function test_seq_ind {
    DMPL="$1"
    ROLES="$2"
    printf "seq ind      %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.ind.c"
    OUT2="$BN.ind.c.saved"
    rm -f $OUT1
    dmplc --cube-grid 10 --roles $ROLES -r 0 -si -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##parse a file and output. then parse this output and output
##again. the two outputs should be identical.
function test_double_parse {
    DMPL="$1"
    OPTS="$2"
    printf "double parse %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.1.dmpl"
    OUT2="$BN.2.dmpl"
    rm -f $OUT1 $OUT2
    dmplc -p -o $OUT1 $DMPL $OPTS &> /dev/null
    dmplc -p -o $OUT2 $OUT1 $OPTS &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##verify and check against expected output
function test_verif {
    DMPL="$1"
    OPTS="$2"
    ROLES="$3"
    OUTPUT="$4"
    printf "verification %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --cube-grid 5 -r 5 -s -rp NoCollision -o $OUT1 $DMPL $OPTS &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##verify inductively and check against expected output
function test_verif_ind {
    DMPL="$1"
    OPTS="$2"
    ROLES="$3"
    OUTPUT="$4"
    printf "induct verif %30s : " $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --cube-grid 5 -r 0 -si -rp NoCollision -o $OUT1 $DMPL $OPTS &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

#role descriptors for various examples
EX02ROLES="uav:Leader:1:uav:ProtectorSE:1"

#if arguments were passed, they refer to a specific test. just run that.
if [ "$#" -gt "0" ]; then
    $*
    exit $?
fi

#double parse tests
test_double_parse test-example-01a.dmpl ""
test_double_parse test-example-01b.dmpl ""
test_double_parse test-example-01c.dmpl ""
test_double_parse test-example-01d.dmpl ""
test_double_parse test-example-01e.dmpl ""
test_double_parse test-example-01f.dmpl ""
test_double_parse test-01.dmpl ""
test_double_parse test-example-02a.dmpl ""
test_double_parse test-example-02b.dmpl ""
test_double_parse test-example-05.dmpl ""
test_double_parse ../../docs/tutorial/example-01.dmpl ""
test_double_parse ../../docs/tutorial/example-01.bug1.dmpl ""
test_double_parse ../../docs/tutorial/example-01.bug2.dmpl ""
test_double_parse ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl
test_double_parse ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl
test_double_parse ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl
test_double_parse ../../docs/tutorial/example-05/dmpl/example-05.dmpl ../../docs/tutorial/example-05/dmpl/example-05-AADL.dmpl
test_double_parse ../../docs/tutorial/example-07/dmpl/example-07-2.dmpl

#code generation tests
test_code_gen test-example-01a.dmpl uav:Uav:3
test_code_gen test-example-01e.dmpl uav:Uav1:2:uav:Uav2:1:uav:Uav3:1
test_code_gen test-example-02a.dmpl uav:Leader:1:uav:Protector:4
test_code_gen test-example-02b.dmpl uav:Leader:1:uav:Protector:4

#test building
for i in ../../docs/tutorial/*.mission ../../docs/tutorial/example-05/dmpl/*.mission ; do
    test_build $i
done

#sequentialization tests
test_seq test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_seq test-example-05b.dmpl uav:Leader:1:uav:Protector:4
test_seq test-example-01f.dmpl uav:Uav1:1:uav:Uav2:1

#inductive sequentialization tests
test_seq_ind test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_seq_ind test-example-05b.dmpl uav:Leader:1:uav:Protector:4
test_seq_ind test-example-01f.dmpl uav:Uav1:1:uav:Uav2:1

#verification tests
test_verif ../../docs/tutorial/example-01.dmpl "" uav:Uav:2 SUCCESSFUL
test_verif ../../docs/tutorial/example-01.bug1.dmpl "" uav:Uav:2 FAILED
test_verif ../../docs/tutorial/example-01.bug2.dmpl "" uav:Uav:2 FAILED
test_verif ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES SUCCESSFUL
test_verif ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES FAILED
test_verif ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif ../../docs/tutorial/example-04.dmpl ../../docs/tutorial/example-04-AADL.dmpl uav:Leader:1:uav:Protector:1 FAILED

#inductive verification tests
test_verif_ind ../../docs/tutorial/example-01.dmpl uav:Uav:2 SUCCESSFUL
test_verif_ind ../../docs/tutorial/example-01.bug1.dmpl uav:Uav:2 FAILED
test_verif_ind ../../docs/tutorial/example-01.bug2.dmpl uav:Uav:2 FAILED
test_verif_ind ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES SUCCESSFUL
test_verif_ind ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES FAILED
test_verif_ind ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif_ind ../../docs/tutorial/example-04.dmpl ../../docs/tutorial/example-04-AADL.dmpl uav:Leader:1:uav:Protector:1 FAILED
