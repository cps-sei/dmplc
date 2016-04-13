#!/bin/bash

ARGS="$*"

#return 1 if this is a valid test
function valid_test {
    [ -z "$ARGS" ] && echo 1 && return
    for i in $ARGS; do
        [ "$i" == "$1" ] && echo 1 && return
    done
    echo 0
}

##generate code and check against correct output
function test_code_gen {
    TESTID="$1"
    DMPL="$2"
    OPTS="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "code gen     %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.cpp"
    OUT2="$BN.cpp.saved"
    rm -f $OUT1
    dmplc $OPTS --cube-grid 10 --map small -g -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##generate log analyzer and check against correct output
function test_analyzer {
    TESTID="$1"
    DMPL="$2"
    OPTS="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "analyzer     %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.analyzer.cpp"
    OUT2="$BN.analyzer.cpp.saved"
    rm -f $OUT1
    dmplc $OPTS --cube-grid 10 --map small -a -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##generate code and compile
function test_build {
    TESTID="$1"
    MISSION="$2"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "build        %5s %30s : " $TESTID $(basename $MISSION)
    (cd $(dirname $MISSION); \
    dmpl-sim.sh -b -e /dev/null -B $(basename $MISSION) &> /dev/null; \
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi)
}

##sequentialize and check against correct output
function test_seq {
    TESTID="$1"
    DMPL="$2"
    ROLES="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "sequentialize%5s %30s : " $TESTID $(basename $DMPL)
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
    TESTID="$1"
    DMPL="$2"
    ROLES="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "seq ind      %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.ind.c"
    OUT2="$BN.ind.c.saved"
    rm -f $OUT1
    dmplc --cube-grid 10 --roles $ROLES -r 0 -si -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##sequentialize for parameterized verification and check against
##correct output
function test_seq_param {
    TESTID="$1"
    DMPL="$2"
    ROLES="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "seq param %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    OUT2="$BN.c.saved"
    rm -f $OUT1
    dmplc --cube-grid 10 --roles $ROLES -r 5 -sp -rp NoCollision -o $OUT1 $DMPL &> /dev/null
    diff $OUT1 $OUT2 &> /dev/null
    if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##parse a file and output. then parse this output and output
##again. the two outputs should be identical.
function test_double_parse {
    TESTID="$1"
    DMPL="$2"
    OPTS="$3"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "double parse %5s %30s : " $TESTID $(basename $DMPL)
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
    TESTID="$1"
    DMPL="$2"
    OPTS="$3"
    ROLES="$4"
    OUTPUT="$5"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "verification %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --cube-grid 5 -r 5 -s -rp NoCollision -o $OUT1 $DMPL $OPTS &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

##verify inductively and check against expected output
function test_verif_ind {
    TESTID="$1"
    DMPL="$2"
    OPTS="$3"
    ROLES="$4"
    OUTPUT="$5"
    [ $(valid_test $TESTID) == "0" ] && return
    printf "induct verif %5s %30s : " $TESTID $(basename $DMPL)
    BN=$(basename $DMPL .dmpl)
    OUT1="$BN.c"
    rm -f $OUT1
    dmplc --roles $ROLES --cube-grid 5 -r 0 -si -rp NoCollision -o $OUT1 $DMPL $OPTS &> /dev/null
    OUT2=$(cbmc $OUT1 2>&1 | grep VERIFICATION | awk '{print $2}')
    if [ "$OUT2" == "$OUTPUT" ]; then echo "SUCCESS"; else echo "FAILURE"; fi
}

#role descriptors for various examples
EX02ROLES="uav:Leader:1:uav:ProtectorSE:1"

#double parse tests
test_double_parse DP1 test-example-01a.dmpl ""
test_double_parse DP2 test-example-01b.dmpl ""
test_double_parse DP3 test-example-01c.dmpl ""
test_double_parse DP4 test-example-01d.dmpl ""
test_double_parse DP5 test-example-01e.dmpl ""
test_double_parse DP6 test-example-01f.dmpl ""
test_double_parse DP7 test-example-01g.dmpl ""
test_double_parse DP8 test-01.dmpl ""
test_double_parse DP9 test-example-02a.dmpl ""
test_double_parse DP10 test-example-02b.dmpl ""
test_double_parse DP11 test-example-05.dmpl ""
test_double_parse DP12 test-example-09a.dmpl ""
test_double_parse DP13 test-example-09c.dmpl ""
test_double_parse DP14 test-example-09d.dmpl ""
test_double_parse DP15 ../../docs/tutorial/example-01.dmpl ""
test_double_parse DP16 ../../docs/tutorial/example-01.bug1.dmpl ""
test_double_parse DP17 ../../docs/tutorial/example-01.bug2.dmpl ""
test_double_parse DP18 ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl
test_double_parse DP19 ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl
test_double_parse DP20 ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl
test_double_parse DP21 ../../docs/tutorial/example-05/dmpl/example-05.dmpl ../../docs/tutorial/example-05/dmpl/example-05-AADL.dmpl
test_double_parse DP22 ../../docs/tutorial/example-07/dmpl/example-07-2.dmpl
test_double_parse DP23 ../../docs/tutorial/example-09.dmpl ""
test_double_parse DP24 ../../docs/tutorial/example-09a.dmpl ""
test_double_parse DP25 ../../docs/tutorial/example-09b.dmpl ""
test_double_parse DP26 ../../docs/tutorial/example-09c.dmpl ""
test_double_parse DP27 ../../docs/tutorial/example-09d.dmpl ""
test_double_parse DP28 ../../docs/tutorial/example-09e.dmpl ""
test_double_parse DP29 ../../docs/tutorial/example-10.dmpl ""
test_double_parse DP30 test-example-01h.dmpl ""
test_double_parse DP31 test-example-01i.dmpl ""

#code generation tests
test_code_gen CG1 test-example-01a.dmpl "--roles uav:Uav:3"
test_code_gen CG2 test-example-01e.dmpl "--roles uav:Uav1:2:uav:Uav2:1:uav:Uav3:1"
test_code_gen CG3 test-example-01g.dmpl "--roles uav:Uav:3"
test_code_gen CG4 test-example-02a.dmpl "--roles uav:Leader:1:uav:Protector:4"
test_code_gen CG5 test-example-02b.dmpl "--roles uav:Leader:1:uav:Protector:4"
test_code_gen CG6 test-example-02c.dmpl "--roles uav:ProtectorNW:1:uav:Leader:1:uav:ProtectorSE:1:uav:ProtectorSW:1:uav:ProtectorNE:1"
test_code_gen CG7 test-example-09a.dmpl "--roles uav:Leader:1:uav:Protector:4:uav:Leader:1:uav:Protector:4 --groups coordinator+eastern=1:eastern=4:coordinator+western=1:western=4 --var-groups x1+y1+x2+y2=coordinator:lock+lx+ly+init=eastern+western"
test_code_gen CG8 test-example-09c.dmpl "--roles uav:Leader:1:uav:Protector:4:uav:Leader:1:uav:Protector:4 --groups coordinator+eastern=1:eastern=4:coordinator+western=1:western=4 --var-groups reg_x+reg_y+reg_rad+waypointArrival=coordinator:lock+lx+ly+init=eastern+western"
test_code_gen CG9 test-example-09d.dmpl "-e --roles uav:Leader:1:uav:Protector:4:uav:Leader:1:uav:Protector:4 --groups coordinator+eastern=1:eastern=4:coordinator+western=1:western=4 --var-groups reg_x+reg_y+reg_rad+waypointArrival=coordinator:lock+lx+ly+init=eastern+western"

#analyzer generation tests
test_analyzer TA1 test-example-02-expect.dmpl "--roles uav:Protector:4:uav:Leader:1"
test_analyzer TA2 test-example-09d.dmpl "--roles uav:Leader:1:uav:Protector:4:uav:Leader:1:uav:Protector:4 --groups coordinator+eastern=1:eastern=4:coordinator+western=1:western=4 --var-groups reg_x+reg_y+reg_rad+waypointArrival=coordinator:lock+lx+ly+init=eastern+western"

#test building
COUNT=1
for i in ../../docs/tutorial/*.mission ../../docs/tutorial/example-05/dmpl/*.mission ; do
    test_build BD${COUNT} $i
    COUNT=$((COUNT + 1))
done

#sequentialization tests
test_seq SQ1 test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_seq SQ2 test-example-05b.dmpl uav:Leader:1:uav:Protector:4
test_seq SQ3 test-example-01f.dmpl uav:Uav1:1:uav:Uav2:1
test_seq SQ4 test-example-01g.dmpl uav:Uav:3

#inductive sequentialization tests
test_seq_ind SI1 test-example-01c.dmpl uav:Uav1:2:uav:Uav2:1
test_seq_ind SI2 test-example-05b.dmpl uav:Leader:1:uav:Protector:4
test_seq_ind SI3 test-example-01f.dmpl uav:Uav1:1:uav:Uav2:1
test_seq_ind SI4 test-example-01g.dmpl uav:Uav:3

#parameterized sequentialization tests
test_seq_param SP1 test-example-01h.dmpl uav:Uav:2
test_seq_param SP2 test-example-01i.dmpl uav:Uav:2

#verification tests
test_verif VF1 ../../docs/tutorial/example-01.dmpl "" uav:Uav:2 SUCCESSFUL
test_verif VF2 ../../docs/tutorial/example-01.bug1.dmpl "" uav:Uav:2 FAILED
test_verif VF3 ../../docs/tutorial/example-01.bug2.dmpl "" uav:Uav:2 FAILED
test_verif VF4 ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES SUCCESSFUL
test_verif VF5 ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES FAILED
test_verif VF6 ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif VF7 ../../docs/tutorial/example-04.dmpl ../../docs/tutorial/example-04-AADL.dmpl uav:Leader:1:uav:Protector:1 FAILED
test_verif VF8 ../../docs/tutorial/example-01-hybrid.dmpl ../../docs/tutorial/example-01-hybrid-controller.dmpl uav:Uav:2 SUCCESSFUL

#inductive verification tests
test_verif_ind VI1 ../../docs/tutorial/example-01.dmpl uav:Uav:2 SUCCESSFUL
test_verif_ind VI2 ../../docs/tutorial/example-01.bug1.dmpl uav:Uav:2 FAILED
test_verif_ind VI3 ../../docs/tutorial/example-01.bug2.dmpl uav:Uav:2 FAILED
test_verif_ind VI4 ../../docs/tutorial/example-02.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES SUCCESSFUL
test_verif_ind VI5 ../../docs/tutorial/example-02.bug1.dmpl ../../docs/tutorial/example-02-AADL.dmpl $EX02ROLES FAILED
test_verif_ind VI6 ../../docs/tutorial/example-03.dmpl ../../docs/tutorial/example-03-AADL.dmpl uav:Leader:1:uav:Protector:1 SUCCESSFUL
test_verif_ind VI7 ../../docs/tutorial/example-04.dmpl ../../docs/tutorial/example-04-AADL.dmpl uav:Leader:1:uav:Protector:1 FAILED
test_verif_ind VI8 ../../docs/tutorial/example-01-hybrid.dmpl ../../docs/tutorial/example-01-hybrid-controller.dmpl uav:Uav:2 SUCCESSFUL
