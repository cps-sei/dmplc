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

#ifndef __DMPL_PLATFORM_GAMS_HPP__
#define __DMPL_PLATFORM_GAMS_HPP__

/********************************************************************/
//-- GAMS variables
/********************************************************************/
gams::platforms::Base_Platform *platform = NULL;
int grid_x = 0, grid_y = 0, grid_z = 0;
double grid_leftX = NAN, grid_rightX = NAN;
double grid_topY = NAN, grid_bottomY = NAN;
double grid_topZ = NAN, grid_bottomZ = NAN;
double grid_cellX = NAN, grid_cellY = NAN, grid_cellZ = NAN;

/********************************************************************/
//-- GAMS functions
/********************************************************************/
void GRID_INIT()
{
  grid_x = X;
  grid_y = Y;
  grid_z = Z;
  grid_leftX = LeftX;
  grid_rightX = RightX;
  grid_topY = TopY;
  grid_bottomY = BottomY;
  grid_topZ = TopZ;
  grid_bottomZ = BottomZ;
  grid_cellX = (grid_rightX - grid_leftX) / (grid_x-1);
  grid_cellY = (grid_bottomY - grid_topY) / (grid_y-1);
  grid_cellZ = (grid_bottomZ - grid_topZ) / (grid_z-1);
}

void GRID_PLACE(int x, int y, int z)
{
  knowledge.set(".initial_x", grid_leftX + x * grid_cellX);
  knowledge.set(".initial_y", grid_topY + y * grid_cellY);
  knowledge.set(".initial_alt", grid_topZ + z * grid_cellZ);
}

int GRID_MOVE(int x, int y, int z, double epsilon = 0.1)
{
  int ret = platform->move(gams::utility::Position(grid_leftX + x * grid_cellX, grid_topY + y * grid_cellY, grid_topZ + z * grid_cellZ), epsilon);
  return ret != 2;
}

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

double GET_LAT()
{
  if(platform == NULL) return NAN;
  gams::utility::Position *pos = platform->get_position();
  double lat = pos->x;
  delete pos;
  return lat;
}

double GET_LNG()
{
  if(platform == NULL) return NAN;
  gams::utility::Position *pos = platform->get_position();
  double lng = pos->y;
  delete pos;
  return lng;
}

int ROTATE(double angle)
{
  std::cout << "Rotate: " << angle << std::endl;
  int ret = platform->rotate(gams::utility::Axes(0, 0, angle));
  std::cout << "Rotate ret: " << ret << std::endl;
  return ret != 2;
}

#endif //__DMPL_PLATFORM_GAMS_HPP__

/********************************************************************/
//-- end of file
/********************************************************************/
