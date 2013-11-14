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

#include "comm.h"
#include "kb_setup.h"

#ifdef WIN32
//#define WIN_MULTICAST
#endif

#ifdef WIN_MULTICAST
  // Only include the custom transport for Windows if we need it, such as when we are in a VRep plugin.
  #include "Windows_Multicast_Transport.h"
#endif

// Defines the IP through which devices on the network will communicate with each other.
static std::string MULTICAST_ADDRESS = "239.255.0.1:4150";

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Sets up the knowledge base for this transport.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
Madara::Knowledge_Engine::Knowledge_Base* comm_setup_knowledge_base(int id, bool enableLog)
{
    // Define the transport.
    Madara::Transport::Settings transportSettings;
    transportSettings.hosts.resize (1);
    transportSettings.hosts[0] = MULTICAST_ADDRESS;
    transportSettings.delay_launch = true;
    transportSettings.queue_length = 512000;

    // Setup the actual transport type.
#ifndef WIN_MULTICAST
    // In Linux, or Windows outside of V-Rep, we can use the default Mulitcast transport.
    transportSettings.type = Madara::Transport::MULTICAST;
#endif
   
    // Create the knowledge base.
    Madara::Knowledge_Engine::Knowledge_Base* knowledge = setup_knowledge_base(id, enableLog, transportSettings);

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
