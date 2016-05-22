#ifndef _NAVDATA_H_
#define _NAVDATA_H_

#include <ardrone_tool/Navdata/ardrone_navdata_client.h>

//-- variables used to interface with DMPL
typedef struct
{
  //-- the flying state
  FLYING_STATE flying_state;
  int battery_level;
  int altitude;
  int nb_detected;
} DmplArdrone;

#endif // _NAVDATA_H_
