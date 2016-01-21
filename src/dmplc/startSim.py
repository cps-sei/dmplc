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

# Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
# 1. Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following acknowledgments
# and disclaimers.
#
# 2. Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following
# disclaimer in the documentation and/or other materials provided
# with the distribution.
#
# 3. The names "Carnegie Mellon University," "SEI" and/or "Software
# Engineering Institute" shall not be used to endorse or promote
# products derived from this software without prior written
# permission. For written permission, please contact
# permission@sei.cmu.edu.
#
# 4. Products derived from this software may not be called "SEI" nor
# may "SEI" appear in their names without prior written permission of
# permission@sei.cmu.edu.
#
# 5. Redistributions of any form whatsoever must retain the following
# acknowledgment:
#
# This material is based upon work funded and supported by the
# Department of Defense under Contract No. FA8721-05-C-0003 with
# Carnegie Mellon University for the operation of the Software
# Engineering Institute, a federally funded research and development
# center.
#
# Any opinions, findings and conclusions or recommendations expressed
# in this material are those of the author(s) and do not necessarily
# reflect the views of the United States Department of Defense.
#
# NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
# ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
# BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
# LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
# EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
# MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
# RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
# INFRINGEMENT.
#
# This material has been approved for public release and unlimited
# distribution.
#
# DM-0002494

import sys
import vrep

ret=0
print 'Program started'
vrep.simxFinish(-1) # just in case, close all opened connections
clientID=vrep.simxStart('127.0.0.1',19001,True,True,5000,5)

# stuff to do in recording mode
if ((len(sys.argv) > 1) and (sys.argv[1] == "--record")):
    # disable model browser and scene hierarchy
    vrep.simxSetBooleanParameter(clientID,vrep.sim_boolparam_hierarchy_visible,0,vrep.simx_opmode_oneshot)
    vrep.simxSetBooleanParameter(clientID,vrep.sim_boolparam_browser_visible,0,vrep.simx_opmode_oneshot)

    # zoom out camera
    cam_x = float(sys.argv[2])
    cam_y = float(sys.argv[3])
    cam_z = float(sys.argv[4])
    (code, cameraID)=vrep.simxGetObjectHandle(clientID,"DefaultCamera#",vrep.simx_opmode_oneshot_wait)
    vrep.simxSetObjectPosition(clientID,cameraID,-1,(cam_x,cam_y,cam_z),vrep.simx_opmode_oneshot)

    # start recording
    vrep.simxSetBooleanParameter(clientID,vrep.sim_boolparam_video_recording_triggered,1,vrep.simx_opmode_oneshot)

if clientID!=-1:
    print 'Connected to remote API server'
    res=vrep.simxStartSimulation(clientID,vrep.simx_opmode_oneshot_wait)
    if res==vrep.simx_return_ok:
        print 'Simulation started'
    else:
        print 'Remote API function call returned with error code: ',res
        ret=1
    vrep.simxFinish(clientID)
else:
    print 'Failed connecting to remote API server'
print 'Program ended'
sys.exit(ret);
