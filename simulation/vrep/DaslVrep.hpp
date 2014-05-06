#ifndef __DASL_VREP_HPP__
#define __DASL_VREP_HPP__

extern "C" {
#include "extApi.h"
}

/*********************************************************************/
//the main class to interact with the VREP simulator
/*********************************************************************/
class DaslVrep
{
private:
  //the client id
  simxInt clientId;
public:
  //constructors
  DaslVrep();

  simxInt connect();
  void disconnect();
  simxInt createNode();
  simxInt destroyNode(const simxInt nodeId);
  simxInt getNumObjects();
  simxInt getPingTime();
  simxInt moveNode(simxInt nodeId,simxFloat x,simxFloat y,simxFloat z);
};

#endif //__DASL_VREP_HPP__

/*********************************************************************/
//end of file
/*********************************************************************/
