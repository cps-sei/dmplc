#!/bin/bash

if [ "$#" == "0" ]; then
    echo "Usage : $0 <brunch.out-folder>"
    echo "New stats file will be brunch.out-folder/new_stats.csv"
    exit 1
fi

cp $1/stats $1/stats.csv
TMPF=$(mktemp)
echo "Vars,Clauses" > $TMPF
for i in $(cat $1/stats | grep -v ExpName); do 
    X=$(echo $i | awk -F',' '{print $1}')
    Y=$(echo $i | awk -F',' '{print $2}')
    Z=$(echo $i | awk -F',' '{print $3}')
    F=$(ls $1/${X}*:${Y}:${Z}:*.stdout)
    cat $F | grep "c 1 S" | head -n1 | awk '{print $5","$6}' >> $TMPF
done
paste -d ',' $1/stats $TMPF > $1/new_stats.csv
rm $TMPF
cat $1/new_stats.csv
