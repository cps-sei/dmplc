#!/bin/bash
TMPF1=$(mktemp)
TMPF2=$(mktemp)

for i in ../../../../examples/sync-coll-avoid.mcda \
    ../../../../examples/async-coll-avoid.mcda; do 
    echo "== $i"
    ./daslc $i --print > $TMPF1
    ./daslc $TMPF1 --print > $TMPF2
    diff $TMPF1 $TMPF2
done
