#!/bin/bash

#check arguments
if [ "$#" != "1" ]; then
    echo "Usage : $0 X"
    echo "    X = package name. will be created as X.zip"
    exit 1
fi

PN="$1"
TMPD=$(mktemp -d)
mkdir $TMPD/$PN
cp -a README.txt ../LICENSE.txt cbmc-plingeling.sh run-all-exp.sh \
run-exp.sh ../tools/daig/src/daslc/daslc brunch \
/home/chaki/stuff/madara/madara/libMADARA.so.6.2.3 \
/home/chaki/stuff/madara/ace/ACE_wrappers/ace/libACE.so.6.2.3 \
sync-coll-3d-opt.*dasl sync-coll-avoid.*.dasl \
sync-mutex.*.dasl gen-tables.sh \
/home/chaki/stuff/docs/mcda-models14/results.xlsx $TMPD/$PN
mkdir $TMPD/$PN/results
for i in coll coll.3d.opt mutex; do
    cp -a results/brunch.out.${i}.ok* results/brunch.out.${i}.bug* $TMPD/$PN/results
done
(cd $TMPD; zip -r $PN.zip $PN)
echo "package $TMPD/$PN.zip created"
