/*********************************************************************
 * Usage of this software requires acceptance of the SMASH-CMU License,
 * which can be found at the following URL:
 *
 * https://code.google.com/p/smash-cmu/wiki/License
 *********************************************************************/

/*********************************************************************
 * comm.h - Sets up a communication platform thorugh a Knowledge Base.
 *********************************************************************/

#ifndef _COMM_H
#define _COMM_H

#include "madara/knowledge_engine/Knowledge_Base.h"

// Sets up a knowledge base with a transport that is appropriate for this platform.
Madara::Knowledge_Engine::Knowledge_Base* comm_setup_knowledge_base(int id, bool enableLog);

#endif
