#!/bin/bash
TMPF=$(mktemp) && rm -f $TMPF
CORES=$(cat /proc/cpuinfo | grep processor | wc -l)
echo "CNF file = "$TMPF.cnf

function ensure {
    X=$(which $1)
    if [ x"$X" == "x" ]; then
        echo "$1 not found, make sure it is on your path"
        exit 1
    fi
}

ensure cbmc
ensure plingeling

cbmc --dimacs --outfile $TMPF.cnf $*
plingeling -t $CORES $TMPF.cnf
