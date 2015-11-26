#!/bin/bash

declare -a CMDS
source $1
printf "verification %30s : " $VERIF_NAME

for CMD in "${CMDS[@]}"
do
    RES=$($CMD 2>&1 | grep VERIFICATION | awk '{print $2}')
done

if [ "$RES" == "$OUT" ]; then
    echo "$RES (expected)"
else
    echo "$RES (unexpected)"
fi

