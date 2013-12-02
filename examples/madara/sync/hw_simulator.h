/*********************************************************************
* Usage of this software requires acceptance of the SMASH-CMU License,
* which can be found at the following URL:
*
* https://code.google.com/p/smash-cmu/wiki/License
*********************************************************************/

/*********************************************************************
 * hw_simulator.h - A hardware simulator that connects to VREP for the actual
 * simulation.
 *********************************************************************/

#ifndef _HW_SIMULATOR_H
#define _HW_SIMULATOR_H

#include <string>
#include <map>

// Setup functions.
void sim_setup(int id);
bool sim_cleanup();

// Movement functions.
void sim_platform_takeoff();
void sim_platform_land();
void sim_platform_move_to_location(double lat, double lon, double alt);
void sim_platform_move_to_altitude(double alt);

// Sensor functions.
bool sim_platform_init_sensor_functions();
void sim_platform_read_thermal(double buffer[8][8]);
std::map<std::string, double> sim_platform_read_gps();
double sim_platform_get_altitude();
double sim_platform_get_gps_accuracy();

#endif _SIMULATOR_H
