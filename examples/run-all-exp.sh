#!/bin/bash

BRFMT="ExpName:Nodes:Rounds:CPLING-Time:Status"
BRUNCH="./brunch --cpu 100000 --mem 100000 --format $BRFMT"

#coll experiments
function do_coll {
    OUTD=brunch.out.coll.$1.$2
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for X in 4 7 10; do
                for R in 5 10 15 20 30 40 50; do
                    EXP="$EXP coll.$1.$X.$X:sync-coll-avoid.$1.dasl:$N:$R:--DX=$X--DY=$X$2"
                done
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi

}

#coll-opt experiments
function do_coll_opt {
    OUTD=brunch.out.coll.opt.$1.$2
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for X in 4 7 10; do
                for R in 5 10 15 20 30 40 50; do
                    EXP="$EXP coll.opt.$1.$X.$X:sync-coll-opt.$1.dasl:$N:$R:--DX=$X--DY=$X$2"
                done
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi

}

#mutex experiments
function do_mutex {
    OUTD=brunch.out.mutex.$1.$2
    if [ ! -e $OUTD ]; then 
        EXP=""
        for N in 2 4 6 8 10; do
            for R in 5 10 15 20 30 40 50 60 80 100; do
                EXP="$EXP mutex.$1:sync-mutex.$1.dasl:$N:$R:$2"
            done
        done
        $BRUNCH --out $OUTD $EXP -- ./run-exp.sh
    else
        echo "directory $OUTD exists .. skipping"
    fi

}

if [ "$#" == "0" ]; then
    do_coll ok --seq-sem
    do_coll bug1 --seq-sem 
    do_coll bug2 --seq-sem
    # do_coll_opt ok --seq-sem
    # do_coll_opt bug1 --seq-sem
    # do_coll_opt bug2 --seq-sem
    do_mutex ok --seq-sem
    do_mutex bug1 --seq-sem
    do_mutex bug2 --seq-sem
    do_mutex ok --seq-dbl
    do_mutex bug1 --seq-dbl
    do_mutex bug2 --seq-dbl
else
    $*
fi
