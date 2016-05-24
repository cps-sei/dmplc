#include <ardrone_tool/Navdata/ardrone_navdata_client.h>

#include <stdio.h>
#include "./navdata.h"

//milli-degrees to radians
#define MDTORAD (M_PI/180000.0)

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

  //-- update ardrone state
  dmplArdrone.flying_state = ardrone_academy_navdata_get_flying_state(navdata);
  dmplArdrone.battery_level = nd->vbat_flying_percentage;
  dmplArdrone.altitude = nd->altitude;

  //-- update psi and initial psi
  dmplArdrone.psi = nd->psi;
  if(isnan(dmplArdrone.init_psi)) dmplArdrone.init_psi = nd->psi;
  
  //-- update odometry
  dmplArdrone.ndtime = navdata->navdata_time;
  int ndt_sec = (int)((navdata->navdata_time.time & TSECMASK) >> TSECDEC);
  int ndt_usec = (int)(navdata->navdata_time.time & TUSECMASK);
  double timestamp = ndt_sec + ndt_usec * 0.000001;

  if(!isnan(dmplArdrone.recv_time)) {
    double delta_t = timestamp - dmplArdrone.recv_time;
    dmplArdrone.odo_x += ((cos(nd->psi * MDTORAD) * nd->vx -
                           sin(nd->psi * MDTORAD) * -nd->vy) * delta_t) / 1000.0;
    dmplArdrone.odo_y += ((sin(nd->psi * MDTORAD) * nd->vx +
                           cos(nd->psi * MDTORAD) * -nd->vy) * delta_t) / 1000.0;
  }

  //-- update timestamp
  dmplArdrone.recv_time = timestamp;
  
  //-- updated number of tags detected
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

