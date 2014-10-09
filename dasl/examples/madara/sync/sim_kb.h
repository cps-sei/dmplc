/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * sim_kb.h - Declares functions and variables used in a Knowledge Base
 * used to simulate a HW platform.
 *********************************************************************/

#ifndef _SIM_KB_H
#define _SIM_KB_H

#include "madara/knowledge_engine/Knowledge_Base.h"

#include <string>

// For the thermal buffer.
#define THERMAL_BUFFER_HEIGHT 8
#define THERMAL_BUFFER_WIDTH 8

// For GPS simulation, in meters.
#define VREP_DRONE_GPS_ACCURACY 0.3

// My id.
#define MV_MY_ID ".id"

// For simulation purposes.
#define MS_SIM_PREFIX           "sim"                   // Prefix used to disseminate local device variables for simulator.
#define MS_SIM_DEVICES_PREFIX   "sim.device."           // Prefix used to disseminate local device variables for simulator.
#define MS_SIM_CMD_SENT_ID      ".sent_command_id"      // Suffix used to indicate the id of the last command sent, to resend for lost ones.
#define MS_SIM_CMD_RCVD_ID      ".received_command_id"  // Suffix used to indicate the id of the command received, to resend for lost ones.

// Movement commands variables.
#define MV_MOVEMENT_REQUESTED   ".movement_command"                             // Internal command to tell that we want certain movement.
#define MV_MOVEMENT_CMD_ARG(i)  ".movement_command."  + std::string(i) + ""     // The i argument for the command, starting at i=0.

// Movement commands.
#define MO_MOVE_TO_GPS_CMD      "move_to_gps"           // Command used to tell drone to move to that a location.
#define MO_MOVE_TO_ALTITUDE_CMD "move_to_altitude"      // Command used to tell drone to move to a specific altitude.
#define MO_JUMP_TO_GPS_CMD      "jump_to_gps"           // Command used to tell drone to teleport to that location.
#define MO_LAND_CMD             "land"                  // Command used to tell drone to land at current location
#define MO_TAKEOFF_CMD          "takeoff"               // Command used to tell drone to takeoff

// Sensor variables - location.
#define MV_LATITUDE             ".location.latitude"    // Latitude.
#define MV_LONGITUDE            ".location.longitude"   // Longitude.
#define MV_ALTITUDE             ".location.altitude"    // Altitude.

// Sensor variables - thermal.
#define MV_SIM_THERMAL_BUFFER   ".thermal.buffer"       // A comma-separated stirng of thermal values.

// Sets up a knowledge base with a transport that is appropriate for HW simulation.
Madara::Knowledge_Engine::Knowledge_Base* sim_setup_knowledge_base(int id, bool enableLog);

// Cleans up a sim knowledge base.
void sim_cleanup_knowledge_base(Madara::Knowledge_Engine::Knowledge_Base* knowledge);

#endif
