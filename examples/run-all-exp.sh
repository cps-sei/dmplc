#!/bin/bash

#create the 
X=" \
coll.ok.4.4:sync-coll-avoid.ok.dasl:2:6:--DX=4--DY=4 \
coll.bug1.4.4:sync-coll-avoid.ok.dasl:2:6:--DX=4--DY=4 \
coll.bug2.4.4:sync-coll-avoid.ok.dasl:2:6:--DX=4--DY=4 \
mutex.ok:sync-mutex.ok.dasl:5:10: \
mutex.bug1:sync-mutex.bug1.dasl:5:10: \
mutex.bug2:sync-mutex.bug2.dasl:5:10: \
"

BRFMT="ExpName:Nodes:Rounds:CBMC-Time:CPLING-Time"

./brunch --cpu 10000 --mem 5000 --format $BRFMT $X -- ./run-exp.sh
