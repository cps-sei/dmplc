#!/bin/bash

BRFMT="ExpName:Nodes:Rounds:CPLING-Time:Status"
BRUNCH="./brunch --cpu 100000 --mem 100000 --format $BRFMT"

#coll-ok experiments
function do_coll_ok {
    OUTD=brunch.out.coll.ok
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for X in 4 7 10; do
                for R in 5 10 15 20 30 40 50; do
                    EXP="$EXP coll.ok.$X.$X:sync-coll-avoid.ok.dasl:$N:$R:--DX=$X--DY=$X"
                done
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi

}

#coll-bug1 experiments
function do_coll_bug1 {
    OUTD=brunch.out.coll.bug1
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for X in 4 7 10; do
                for R in 5 10 15 20 30 40 50; do
                    EXP="$EXP coll.bug1.$X.$X:sync-coll-avoid.bug1.dasl:$N:$R:--DX=$X--DY=$X"
                done
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi
}

#coll-bug2 experiments
function do_coll_bug2 {
    OUTD=brunch.out.coll.bug2
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for X in 4 7 10; do
                for R in 5 10 15 20 30 40 50; do
                    EXP="$EXP coll.bug2.$X.$X:sync-coll-avoid.bug2.dasl:$N:$R:--DX=$X--DY=$X"
                done
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi
}

do_coll_ok
do_coll_bug1
do_coll_bug2
