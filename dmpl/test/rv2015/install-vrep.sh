#!/bin/bash

if [ -f /tmp/V-REP_PRO_EDU_V3_1_3_rev2b_64_Linux.tar.gz ]; then
    cp /tmp/V-REP_PRO_EDU_V3_1_3_rev2b_64_Linux.tar.gz .
else
    wget http://coppeliarobotics.com/V-REP_PRO_EDU_V3_1_3_rev2b_64_Linux.tar.gz
fi

mkdir vrep
tar xfz V-REP_PRO_EDU_V3_1_3_rev2b_64_Linux.tar.gz -C vrep  --strip-components 1
cd $DMPL_ROOT/src/dmplc
cp $VREP_ROOT/programming/remoteApiBindings/lib/lib/64Bit/remoteApi.so .
cp $VREP_ROOT/programming/remoteApiBindings/python/python/vrep.py .
cp $VREP_ROOT/programming/remoteApiBindings/python/python/vrepConst.py .
