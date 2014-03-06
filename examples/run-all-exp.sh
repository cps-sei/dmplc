#!/bin/bash

#create the 
X="coll.ok.4.4:sync-coll-avoid.ok.dasl:2:6:--DX=4--DY=7"

BRFMT="ExpName:Nodes:Rounds:CBMC-Time:CPLING-Time"

./brunch --cpu 10000 --mem 5000 --format $BRFMT "$X" -- ./run-exp.sh
