/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * comm_sim_multicast.h - Implements the communication interface using 
 * a multicast transport configured for simulating hardware.
 *********************************************************************/

#include "madara/knowledge_engine/Knowledge_Base.h"

// Defines the IP through which devices will communicate with the VRep plugin.
const std::string SIMULATED_HW_MULTICAST_ADDRESS ("239.255.0.2:4250");

// Domain for the simulation knowledge base..
const std::string VREP_DOMAIN ("v_rep");

// Queue length.
const int SIMULATION_TRANSPORT_QUEUE_LENGTH = 512000;

///////////////////////////////////////////////////////////////////////////////
// Sets up the knowledge base for this transport.
///////////////////////////////////////////////////////////////////////////////
Madara::Knowledge_Engine::Knowledge_Base* sim_setup_knowledge_base(int id, 
  bool enableLog)
{
    // Define the transport settings.
    Madara::Transport::Settings transportSettings;
    transportSettings.id = id;
    transportSettings.type = Madara::Transport::MULTICAST;
    transportSettings.hosts.resize(1);
    transportSettings.hosts[0] = SIMULATED_HW_MULTICAST_ADDRESS;
    transportSettings.domains = VREP_DOMAIN;
    transportSettings.queue_length = SIMULATION_TRANSPORT_QUEUE_LENGTH;
    transportSettings.delay_launch = true;
    
    // Setup a log for Madara.
    if(enableLog)
    {
        std::stringstream stream;
        stream << id;
        Madara::Knowledge_Engine::Knowledge_Base::log_level(10);
        Madara::Knowledge_Engine::Knowledge_Base::log_to_file(
          std::string("madara_sim_id_" + stream.str() + "_log.txt").c_str(), 
          false);
    }

    // Create the knowledge base.
    Madara::Knowledge_Engine::Knowledge_Base* knowledge = 
      new Madara::Knowledge_Engine::Knowledge_Base("", transportSettings);
    Madara::Knowledge_Record::set_precision(10);
    knowledge->print ("Knowledge base created.\n");

    // Activate the transport.
    knowledge->activate_transport();

    return knowledge;
}

///////////////////////////////////////////////////////////////////////////////
// Cleans up the simulated knowledge base.
///////////////////////////////////////////////////////////////////////////////
void sim_cleanup_knowledge_base(
  Madara::Knowledge_Engine::Knowledge_Base* knowledge)
{
    if(knowledge != NULL)
    {
        delete knowledge;
    }
}
