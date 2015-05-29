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

#ifndef __DASL_VREP_HPP__
#define __DASL_VREP_HPP__

#include <map>
#include <vector>
#include "dmpl/MCDA_Export.h"

extern "C" {
#include "extApi.h"
}

/*********************************************************************/
//the main class to interact with the VREP simulator. this is an
//abstract base class. it must be extended for each type of model.
/*********************************************************************/
class MCDA_Export DmplVrep
{
protected:
  //the client id
  simxInt clientId;

  //X and Y dimensions
  simxInt xdim,ydim;

  //the floor center coordinate in VREP
  simxFloat floorCenter[3];

  //the min and max X and Y coordinates of the floor in VREP
  simxFloat minx,maxx,miny,maxy;

  //map from nodes created to their target objects
  std::map<simxInt,simxInt> node2Targets;

  //map from nodes to waypoint locations
  typedef std::map<simxInt,std::vector<simxFloat> > TargetMap;
  TargetMap node2Waypoint;

  //map from nodes to the position of their targets
  TargetMap node2TargetPos;

  //debug flag
  bool debug;

  //return true if the argument node is close enough to its target
  bool nodeAtTarget(simxInt nodeId);

  //return true if the argument node's target is close enought to its
  //waypoint
  bool targetAtWaypoint(simxInt nodeId);

  //create node given a model file
  simxInt createNode(const std::string &modelFile);

public:
  //constructors
  DmplVrep() {}
  DmplVrep(simxInt _xdim,simxInt _ydim);

  simxInt connect(simxChar *ipAddr,simxInt port);
  void disconnect();
  void setDebug(const bool d);
  virtual simxInt createNode() = 0;
  simxInt destroyNode(const simxInt nodeId);
  simxInt getNumObjects();
  simxInt getPingTime();
  virtual simxInt placeNodeAt(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
  virtual simxInt moveNodeTo(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z) = 0;
  virtual simxInt getTargetHandle(simxInt nodeId) = 0;
  simxInt startSim();
  simxInt pauseSim();
  simxInt stopSim();
};

/*********************************************************************/
//the subclass of DmplVrep corresponding to a quadrirotor model.
/*********************************************************************/
class MCDA_Export QuadriRotor : public DmplVrep
{
public:
  QuadriRotor() {}
  QuadriRotor(simxInt _xdim,simxInt _ydim) : DmplVrep(_xdim,_ydim) {}
  simxInt createNode();
  simxInt getTargetHandle(simxInt nodeId);
  simxInt placeNodeAt(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
  simxInt moveNodeTo(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
};

/*********************************************************************/
//the subclass of DmplVrep corresponding to an ant model.
/*********************************************************************/
class MCDA_Export TrackerAnt : public DmplVrep
{
private:
  const static double antZ;
public:
  TrackerAnt() {}
  TrackerAnt(simxInt _xdim,simxInt _ydim) : DmplVrep(_xdim,_ydim) {}
  simxInt createNode();
  simxInt getTargetHandle(simxInt nodeId);
  simxInt placeNodeAt(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
  simxInt moveNodeTo(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
};

#endif //__DASL_VREP_HPP__

/*********************************************************************/
//end of file
/*********************************************************************/
