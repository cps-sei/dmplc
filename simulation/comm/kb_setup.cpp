/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * kb_setup.cpp - Implements setting up a knowledge base.
 *********************************************************************/

#include "kb_setup.h"
#include <string>
#include <sstream>

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Sets up a knowledge base.
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
Madara::Knowledge_Engine::Knowledge_Base* setup_knowledge_base(int id, bool enableLog, Madara::Transport::Settings transportSettings)
{
    // Set the transport id as the given id.
    transportSettings.id = id;
    
    // Setup a log for Madara.
    if(enableLog)
    {
        std::stringstream stream;
        stream << id;
        Madara::Knowledge_Engine::Knowledge_Base::log_to_file(std::string("madara_id_" + stream.str() + "_log.txt").c_str(), false);
    }

    // Name the host based on the id.
    char host[30];
    sprintf(host, "device%d", id);
    
    // Create the knowledge base.
    Madara::Knowledge_Engine::Knowledge_Base* knowledge = new Madara::Knowledge_Engine::Knowledge_Base(host, transportSettings);
    Madara::Knowledge_Record::set_precision(10);
    knowledge->print ("Knowledge base created.\n");

    return knowledge;
}
