#!/bin/bash
rm -f *log.txt
cp *.lua $VREP_HOME

SCENE_DIR=`pwd`

cd $VREP_HOME

sh ./vrep.sh $SCENE_DIR/sync-coll-avoid.ttt
