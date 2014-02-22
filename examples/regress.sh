#!/bin/bash
TMPF1=$(mktemp)
TMPF2=$(mktemp)

DASLC=../tools/daig/src/daslc/daslc

echo "testing daslc parsing and printing"
for i in sync-coll-avoid.ok.dasl \
    async-coll-avoid.dasl; do 
    $DASLC $i --print > $TMPF1
    $DASLC $TMPF1 --print > $TMPF2
    DIFF=$(diff $TMPF1 $TMPF2 | wc -l)
    if [ "$DIFF" == "0" ]; then
        echo "$(basename $i) PASSED"
    else
        echo "$(basename $i) FAILED"
    fi
done
