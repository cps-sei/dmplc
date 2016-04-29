/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

#ifndef __DMPL_PLATFORM_ARDRONE_HPP__
#define __DMPL_PLATFORM_ARDRONE_HPP__

extern "C" {
#include "ardrone_api.h"
#include <ardrone_tool/UI/ardrone_input.h>
#include <ardrone_tool/ardrone_tool_configuration.h>
#include <config_keys.h>
#include "ardrone_testing_tool.h"
}

/********************************************************************/
//-- ARDRONE variables
/********************************************************************/

/********************************************************************/
//-- ARDRONE functions
/********************************************************************/

//-- the ardrone_tool thread
pthread_t ardrone_thread;

//-- arguments passed to the ardrone_tool thread
char *ardrone_args[] = { (char*)"PlatformARDrone", (char*)"-ip", (char*)"192.168.1.1" };

/**
 * Call before simulation start, and before calling GRID_PLACE, to initialize
 * needed globals.
 **/
void GRID_INIT()
{
  pthread_create(&ardrone_thread, NULL, ardrone_testing_tool_main, ardrone_args);
}

/**
 * Call before simulation start to initialize where the platform
 * should spawn. This is a no-op for ARDRONE since this will be done
 * manually.
 *
 * @param x the x coordinate
 * @param y the y coordinate
 * @param z the altitude
 **/
void GRID_PLACE(double x, double y, double z)
{
}

/**
 * Make the drone takeoff
 **/
void GRID_TAKEOFF()
{
  ardrone_tool_set_ui_pad_start(1);
  sleep(3);
  int detectType = CAD_TYPE_ORIENTED_COCARDE_BW;
  ARDRONE_TOOL_CONFIGURATION_ADDEVENT(detect_type, &detectType, NULL);
  int fMode = FLYING_MODE_HOVER_ON_TOP_OF_ORIENTED_ROUNDEL;  
  ARDRONE_TOOL_CONFIGURATION_ADDEVENT(flying_mode, &fMode, NULL);
}

/**
 * Call after simulation is done, mainly to land the drone properly.
 **/
void GRID_LAND()
{
  ardrone_tool_set_ui_pad_start(0);
}

/**
 * Call after GRID_LAND() to do other cleanup.
 **/
void GRID_REMOVE()
{
  pthread_cancel(ardrone_thread);
}

/**
 * Command platform to move to grid location X, Y, Z
 * 
 * @param x the x coordinate (left/right from default V-REP perspective)
 * @param y the y coordinate (up/down from default V-REP perspective)
 * @param z the altitude
 * @param epsilon distance in meters to consider "good enough" for ending movement
 *
 * @return true if the platform is still moving, false otherwise
 **/
int GRID_MOVE(double x, double y, double z, double epsilon = 0.1)
{
  return 0;
}

//-- the following four variables and two functions provide an
//-- alternate API for moving a node. you first call GRID_SETPOINT()
//-- and then repeatedly call GRID_ARRIVED(). they are built on top of
//-- GRID_MOVE(). the four variables are used to record the arguments
//-- to be passed to GRID_MOVE().
double GRID_MOVE_x = 0;
double GRID_MOVE_y = 0;
double GRID_MOVE_z = 0;
double GRID_MOVE_epsilon = 0;

void GRID_SETPOINT(double x, double y, double z, double epsilon = 0.1)
{
  GRID_MOVE_x = x;
  GRID_MOVE_y = y;
  GRID_MOVE_z = z;
  GRID_MOVE_epsilon = epsilon;
  GRID_MOVE(GRID_MOVE_x,GRID_MOVE_y,GRID_MOVE_z,GRID_MOVE_epsilon);
}

int GRID_ARRIVED()
{
  return !GRID_MOVE(GRID_MOVE_x,GRID_MOVE_y,GRID_MOVE_z,GRID_MOVE_epsilon);
}

#if 0
double GET_X()
{
  return 0;
}

double GET_Y()
{
  return 0;
}

double GET_Z()
{
  return 0;
}
#endif

/// Returns the size of a grid cell in the X-dimension
double GET_CELL_SIZE_X()
{
  return 0;
}

/// Returns the size of a grid cell in the Y-dimension
double GET_CELL_SIZE_Y()
{
  return 0;
}

/// Returns the size of a grid cell in the Z-dimension
double GET_CELL_SIZE_Z()
{
  return 0;
}

/// Returns latitude
double GET_LAT()
{
  return 0;
}

/// Returns longitude
double GET_LNG()
{
  return 0;
}

/// Returns altitude
double GET_ALT()
{
  return 0;
}

/**
 * Rotate platform around Z axis, 
 * @param angle in degrees, where positive is counter-clockwise as viewed from
 *         above, and zero is along X-axis in positive direction
 * @param epsilon angle in degrees to accept as "close enough" to finish rotating
 * 
 * @return true if platform is still rotating, false if not.
 **/
int ROTATE(double angle, double epsilon = 5)
{
  return 0;
}


/**
 * Detect whether the platform as a range finder sensor, such as a laser
 * range finder.
 *
 * @return true, if the platform has a range finder sensor, and thus GET_RANGE
 *         will work. Otherwise, return false.
 **/
int HAS_RANGE()
{
  return 0;
}

/**
 * Gets the distance read by the range finder sensor, if there is one.
 *
 * @return if there is no sensor, returns NAN. Else, if something is detected,
 *         returns the distance to it in meters. Else, returns the maximum
 *         possible detection distance (for this particular sensor) in meters,
 *         as a negative value.
 **/
double GET_RANGE()
{
  return 0;
}

/**
 * Gets the angle the range finder sensor is at relative to front of the
 * platform.
 *
 * @return angle in degrees, where positive is counter-clockwise as viewed from
 *         above. Returns NAN if platform has no such sensor.
 **/
double GET_RANGE_ANGLE()
{
  return 0;
}

/**
 * Gets the altitude read by the altitude sensor, if there is one.
 *
 * @return if there is no sensor, returns NAN. Else, if something is detected,
 *         returns the distance to it in meters. Else, returns the maximum
 *         possible detection distance (for this particular sensor) in meters,
 *         as a negative value.
 **/
double GET_SENSED_ALT()
{
  return 0;
}

/**
 * Gets the color read by the color sensor, if there is one.
 *
 * @return if there is no sensor, returns -1. Else, if something is
 *         detected, returns its color as RGB.
 **/
unsigned int GET_COLOR()
{
  return 0;
}

/**
 * Sets the color of the agent, if possible
 *
 **/
void SET_COLOR(unsigned int color)
{
}

#endif //__DMPL_PLATFORM_ARDRONE_HPP__

/********************************************************************/
//-- end of file
/********************************************************************/
