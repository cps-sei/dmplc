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
cp -a README.txt LICENSE.txt run.sh sync-coll-avoid.mcda \
    sync-coll-avoid.c $TMPD/$PN
(cd $TMPD; zip -r $PN.zip $PN)
echo "package $TMPD/$PN.zip created"


