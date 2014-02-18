#!/bin/bash
TMPF=$(mktemp)
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
plingeling -t 4 $TMPF.cnf
