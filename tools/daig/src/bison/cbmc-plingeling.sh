#!/bin/bash
TMPF=$(mktemp)
echo "CNF file = "$TMPF.cnf
/home/chaki/stuff/cbmc/cbmc-4.7/cbmc --dimacs --outfile $TMPF.cnf $*
/home/chaki/stuff/plingeling/plingeling-aqw-27d9fd4-130429/binary/plingeling -t 4 $TMPF.cnf
