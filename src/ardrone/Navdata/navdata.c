#include <ardrone_tool/Navdata/ardrone_navdata_client.h>

#include <stdio.h>
#include "./navdata.h"

//-- define variables used to interface with DMPL
DmplArdrone dmplArdrone;

/* Initialization local variables before event loop  */
inline C_RESULT demo_navdata_client_init( void* data )
{
  return C_OK;
}

/* Receving navdata during the event loop */
inline C_RESULT demo_navdata_client_process( const navdata_unpacked_t* const navdata )
{
  const navdata_demo_t*nd = &navdata->navdata_demo;

  /*
  printf("=====================\nNavdata for flight demonstrations =====================\n\n");
  
  printf("Control state : %i\n",nd->ctrl_state);
  printf("Battery level : %i mV\n",nd->vbat_flying_percentage);
  printf("Orientation   : [Theta] %4.3f  [Phi] %4.3f  [Psi] %4.3f\n",nd->theta,nd->phi,nd->psi);
  printf("Altitude      : %i\n",nd->altitude);
  printf("Speed         : [vX] %4.3f  [vY] %4.3f  [vZPsi] %4.3f\n",nd->theta,nd->phi,nd->psi);
  
  
  //printf("\033[8A");
  */
  
  dmplArdrone.flying_state = ardrone_academy_navdata_get_flying_state(navdata);
  dmplArdrone.battery_level = nd->vbat_flying_percentage;
  dmplArdrone.altitude = nd->altitude;

  const navdata_vision_detect_t* pndvision = &navdata->navdata_vision_detect;
  dmplArdrone.nb_detected = pndvision->nb_detected;
  
  return C_OK;
}

/* Relinquish the local resources after the event loop exit */
inline C_RESULT demo_navdata_client_release( void )
{
  return C_OK;
}

/* Registering to navdata client */
BEGIN_NAVDATA_HANDLER_TABLE
  NAVDATA_HANDLER_TABLE_ENTRY(demo_navdata_client_init, demo_navdata_client_process, demo_navdata_client_release, NULL)
END_NAVDATA_HANDLER_TABLE

