/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * comm_multicast.h - Implements the communication interface using the
 * default multicast transport.
 *********************************************************************/

//#include "platforms/comm/comm.h"
//#include "platforms/comm/kb_setup.h"

#ifdef WIN_MULTICAST
  // Only include the custom transport for Windows if we need it, such as when we are in a VRep plugin.
  #include "transport/WindowsMulticastTransport/Windows_Multicast_Transport.h"
#endif

/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * kb_setup.cpp - Implements setting up a knowledge base.
 *********************************************************************/

//#include "kb_setup.h"
#include "madara/knowledge_engine/Knowledge_Base.h"
#include <string>
#include <sstream>
// Defines the IP through which devices on the network will communicate with each other.
const std::string SIMULATED_HW_MULTICAST_ADDRESS ("239.255.0.2:4250");

// Domain.
const std::string VREP_DOMAIN ("v_rep");

// Queue length.
const int SIMULATION_TRANSPORT_QUEUE_LENGTH = 512000;

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Sets up a knowledge base.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
static Madara::Knowledge_Engine::Knowledge_Base* sim_setup_knowledge_base(int id, bool enableLog, Madara::Transport::Settings transportSettings)
{
    // Set the transport id as the given id.
    transportSettings.id = id;
    
    // Setup a log for Madara.
    if(enableLog)
    {
        std::stringstream stream;
        stream << id;
        Madara::Knowledge_Engine::Knowledge_Base::log_level(10);
        Madara::Knowledge_Engine::Knowledge_Base::log_to_file(std::string("madara_sim_id_" + stream.str() + "_log.txt").c_str(), false);
    }
    
    // Create the knowledge base.
    Madara::Knowledge_Engine::Knowledge_Base* knowledge = new Madara::Knowledge_Engine::Knowledge_Base("", transportSettings);
    Madara::Knowledge_Record::set_precision(10);
    knowledge->print ("Knowledge base created.\n");

    return knowledge;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Sets up the knowledge base for this transport.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
Madara::Knowledge_Engine::Knowledge_Base* sim_comm_setup_knowledge_base(int id, bool enableLog)
{
    // Define the transport settings.
    Madara::Transport::Settings transportSettings;
    transportSettings.hosts.resize(1);
    transportSettings.hosts[0] = SIMULATED_HW_MULTICAST_ADDRESS;
    transportSettings.id = id;
    transportSettings.domains = VREP_DOMAIN;
    transportSettings.queue_length = SIMULATION_TRANSPORT_QUEUE_LENGTH;
    transportSettings.delay_launch = true;

    // Setup the actual transport type.
#ifndef WIN_MULTICAST
    // In Linux, or Windows outside of V-Rep, we can use the default Mulitcast transport.
    transportSettings.type = Madara::Transport::MULTICAST;
#endif
   
    // Create the knowledge base.
    Madara::Knowledge_Engine::Knowledge_Base* knowledge = sim_setup_knowledge_base(id, enableLog, transportSettings);

#ifdef WIN_MULTICAST
    // In Windows with V-Rep we need a custom transport to avoid crashes due to incompatibilities between Win V-Rep and ACE.
    knowledge->attach_transport(new Windows_Multicast_Transport (knowledge->get_id (),
                                  knowledge->get_context (), transportSettings, true));
#else
    // Activate the transport.
    knowledge->activate_transport();
#endif

    return knowledge;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Cleans up the simulated knowledge base.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
void sim_comm_cleanup_knowledge_base(Madara::Knowledge_Engine::Knowledge_Base* knowledge)
{
    if(knowledge != NULL)
    {
        delete knowledge;
    }
}

#include "platform_vrep.cpp"
