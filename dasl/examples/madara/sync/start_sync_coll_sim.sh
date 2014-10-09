#!/bin/bash
SCENE_DIR=`pwd`
cd $VREP_HOME
sh ./vrep.sh $SCENE_DIR/sync-coll-avoid.ttt
