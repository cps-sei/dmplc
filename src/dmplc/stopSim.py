#!/usr/bin/python
# Copyright 2006-2014 Dr. Marc Andreas Freese. All rights reserved. 
# marc@coppeliarobotics.com
# www.coppeliarobotics.com
# 
# -------------------------------------------------------------------
# This file is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
# 
# You are free to use/modify/distribute this file for whatever purpose!
# -------------------------------------------------------------------
#
# This file was automatically created for V-REP release V3.1.1 on March 26th 2014

# Make sure to have the server side running in V-REP: 
# in a child script of a V-REP scene, add following command
# to be executed just once, at simulation start:
#
# simExtRemoteApiStart(19999)
#
# then start simulation, and run this program.
#
# IMPORTANT: for each successful call to simxStart, there
# should be a corresponding call to simxFinish at the end!

import sys
import vrep

ret=0
print 'Program started'
vrep.simxFinish(-1) # just in case, close all opened connections
clientID=vrep.simxStart('127.0.0.1',19001,True,True,5000,5)
if clientID!=-1:
    print 'Connected to remote API server'
    res=vrep.simxStopSimulation(clientID,vrep.simx_opmode_oneshot_wait)
    if res==vrep.simx_return_ok:
        print 'Simulation stopped'
    else:
        print 'Remote API function call returned with error code: ',res
        ret=1
    vrep.simxFinish(clientID)
else:
    print 'Failed connecting to remote API server'
print 'Program ended'
sys.exit(ret);
