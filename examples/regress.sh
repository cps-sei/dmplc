#!/bin/bash
TMPF1=$(mktemp)
TMPF2=$(mktemp)

echo "testing daslc parsing and printing"
for i in ../../../../examples/sync-coll-avoid.mcda \
    ../../../../examples/async-coll-avoid.mcda; do 
    ./daslc $i --print > $TMPF1
    ./daslc $TMPF1 --print > $TMPF2
    DIFF=$(diff $TMPF1 $TMPF2 | wc -l)
    if [ "$DIFF" == "0" ]; then
        echo "$(basename $i) PASSED"
    else
        echo "$(basename $i) FAILED"
    fi
done
