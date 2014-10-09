#!/bin/bash

#check arguments
if [ "$#" != "3" ]; then
    echo "Usage : $0 X Y R"
    echo "    X = number of X coordinates in grid"
    echo "    Y = number of Y coordinates in grid"
    echo "    R = number of rounds"
    exit 1
fi

#check for cbmc
CBMC=$(which cbmc)
if [ "x$CBMC" == "x" ]; then
    echo "no cbmc found on PATH"
    exit 1
fi

#check for plingeling
PLING=$(which plingeling)
if [ "x$PLING" == "x" ]; then
    echo "no plingeling found on PATH"
    exit 1
fi

cbmc sync-coll-avoid.c -DR=$3 --dimacs --outfile sync-coll-avoid.$3.dimacs
echo "==================================================================="
plingeling sync-coll-avoid.$3.dimacs
