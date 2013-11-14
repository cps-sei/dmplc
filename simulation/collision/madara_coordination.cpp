/*********************************************************************
* madara_coordination.c - Implementation of the Coordination interface
* using Madara.
*********************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <sstream>
#include <string>
#include <math.h>

#ifndef WIN32
  #include <unistd.h>
#endif

#include "coordination.h"
#include "comm.h"
#include "madara/knowledge_engine/Knowledge_Base.h"

Madara::Knowledge_Engine::Knowledge_Base* knowledge;

// Function to convert from int to std::string. Needed in VS2010 since it 
// doesn't have an int version of to_string.
// Note that in g++ this requires compiling withthe -std=gnu++0x flag.
#define INT_TO_STRING(x) std::to_string(static_cast<long long>(x))

///////////////////////////////////////////////////////////////////////////////
// Visual rep.
///////////////////////////////////////////////////////////////////////////////
void moveTo(int x, int y)
{
  knowledge->set(knowledge->expand_statement("agent{.id}.loc.x"), 
    (Madara::Knowledge_Record::Integer) x);
  knowledge->set(knowledge->expand_statement("agent{.id}.loc.y"), 
    (Madara::Knowledge_Record::Integer) y);
}

///////////////////////////////////////////////////////////////////////////////
// Visual rep.
///////////////////////////////////////////////////////////////////////////////
void showGrid(int numRows, int numCols)
{
  int currRow=0, currCol=0;
  char grid[3][3] = {};

  /* Start with an empty grid. */
  memset(grid, '.', numRows*numCols);

  int posdrone1x = knowledge->get("agent0.loc.x").to_integer();
  int posdrone1y = knowledge->get("agent0.loc.y").to_integer();
  int posdrone2x = knowledge->get("agent1.loc.x").to_integer();
  int posdrone2y = knowledge->get("agent1.loc.y").to_integer();

  /* Marc the drones in the grid. */
  if(posdrone1x >= 0 && posdrone1y >= 0 && 
    posdrone1x < numRows && posdrone1y < numCols)
  {
    grid[posdrone1x][posdrone1y] = '0';
  }
  if(posdrone2x >= 0 && posdrone2y >= 0 && 
    posdrone2x < numRows && posdrone2y < numCols)
  {
    grid[posdrone2x][posdrone2y] = '1';
  }

  /* Print the grid. */
  printf("\n**************************\n");
  for(currRow=0; currRow<numRows; currRow++)
  {
    for(currCol=0; currCol<numCols; currCol++)
    {
      printf(" %c\t", grid[currRow][currCol]);
    }
    printf("\n\n");
  }
  printf("\n**************************\n");
}

///////////////////////////////////////////////////////////////////////////////
// Util function for sleeping.
///////////////////////////////////////////////////////////////////////////////
void sleepForMilliseconds(int milliseconds)
{
#ifdef WIN32
  Sleep(milliseconds);
#else
  usleep(milliseconds*1000);
#endif
}

int m_numCols = 0;
int m_numRows = 0;

///////////////////////////////////////////////////////////////////////////////
// Sets up the communications platform (ie, Madara).
///////////////////////////////////////////////////////////////////////////////
void setup_kb(int id, int numberOfAgents, int numberOfRows, int numberOfCols)
{
  // Setup the knowledge base (using a multicast transport).
  knowledge = comm_setup_knowledge_base(id, true);

  knowledge->set (".id", (Madara::Knowledge_Record::Integer) id);
  knowledge->set (".agents", 
    (Madara::Knowledge_Record::Integer) numberOfAgents);
  knowledge->set (".nodes", 
    (Madara::Knowledge_Record::Integer) numberOfCols*numberOfRows);
  knowledge->set (knowledge->expand_statement("agent{.id}.present"), 
    (Madara::Knowledge_Record::Integer) 1);

  m_numCols = numberOfCols;
  m_numRows = numberOfRows;

  //return knowledge;
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void lock_resource(std::string resource)
{
  Madara::Knowledge_Engine::Wait_Settings wait_settings;
  wait_settings.poll_frequency = 1;
  wait_settings.max_wait_time = 100.0;

  // Calling this method will reevaluate its predicate continously until the 
  // final condition is true.
  // External variables (we assume they were set before):
  //  .id     > our id.
  //  .agents > the total amount of agents in the system.
  //  .nodes  > the total amount of resource nodes in the system.
  //
  // Main variables (values we change and that are propagated):
  //  MUTEX.{resource}.{requester}           = #clock ()
  //  MUTEX.{resource}.{requester}.{granter} = MUTEX.{resource}.{requester}
  //  .oks_received      > how many oks node x have received for a request
  //  .agent{x}.got_lock > whether we got the lock or not
  //

  // Request the resource lock.
  // Note that we use #get_clock()+1 instead of simply #get_clock() to avoid
  // having 0 as a valid ticket/timestamp value. Since variables are also
  // initialized to 0 by default, we reserve 0 to check if something has not
  // ben set, so we need it to be an invalid ticket/timestamp value.
  knowledge->print("Requesting lock for resource " + 
                   resource + " from id {.id}!\n\n");
  knowledge->evaluate(
    "MUTEX." + resource + ".{.id} = #get_clock()+1; "
    "#print('Ticket: {MUTEX." + resource + ".{.id}}\n'");

  // Wait till we get it.
  bool sucess = false;
  while(!sucess)
  {
    int expValue = knowledge->wait(
      // Just state info.
      "#print('\n*******************\n');>"
      "#print('Number of agents: {.agents}; nodes: {.nodes};');>"
      "#print('curr clock: ' + #get_clock() + '\n');>"
      "#print('Id {.id} requesting lock for " + resource + 
             " with ticket {MUTEX." + resource + ".{.id}}\n');>"
      "#print('Id 0 present: {agent0.present}\n');>"
      "#print('Id 1 present: {agent1.present}\n');>"

      // My locks:
      "#print('My locks: \n');>"
      ".r [0->.nodes) "
      "("
        "(MUTEX.{.r}.{.id} != 0) => "
        "("
          "#print('-Node {.r} = with ticket {MUTEX.{.r}.{.id}}');"
          "#print(' (granted? {MUTEX.{.r}.{.id}.granted})\n');"
        ")"
      ") ;>"
      "#print('(no more locks)\n');>"

      // NOTE: this should be a filter, to run in a separate thread.
      // Check for new lock requests, for all resources.
      ".r [0->.nodes) "
      "("
        // Check for all agents that may have requested that resource 
        // (basically the queue).
        //"#print('For resource {.r}.\n');"
        ".i [0->.agents) "
        "("
          // Check to see if it is a new request. For it to be a new 
          // request, it needs to be a request (ie, have a value),
          // and we should not have replied to it before (ie, we have not 
          // set a value or a previous clock as the granter).
          "((MUTEX.{.r}.{.i} != 0) && (MUTEX.{.r}.{.i}.{.id} < MUTEX.{.r}.{.i}))"
          " => "
          "("
            // Send a reply with a timestamp.
            "#print('Id {.id} Replying to id {.i} for lock on res {.r}.\n');"
            "MUTEX.{.r}.{.i}.{.id} = #get_clock()+1;"
          ")"
        ")"
      ");>"

      // Loop to check how many oks we have received, checking the ok variables 
      // from each agent.
      ".oks_received = 0 ;>"
      ".i [0->.agents) "
      "("
        // Check to count how many agents have granted our lock (by replying with
        // a timestamp greater than our request timestamp).
        "(MUTEX." + resource + ".{.id}.{.i} >= MUTEX." + resource + ".{.id}) =>"
            "++.oks_received;"
      ") ;>"
      " #print('Oks for me: {.oks_received} \n');>"

      // Check if our request is at the head of the queue, if we received all 
      // replies.
      ".agent{.id}.got_lock=0;>"
      "(.oks_received != .agents) => #print('Still waiting for replies.\n');>"
      "(.oks_received == .agents) => "
      "("
        // Check if our request is the oldest one.
        ".areWeOldest = 1;"
        ".i [0->.agents) "
        "("
          // Check the queue for this resource, see if there is any request for 
          // it that is earlier than or equal to ours.
          "((MUTEX." + resource + ".{.i} != 0) && .areWeOldest) =>"
          "("
            // If there is a request for the same resource with a smaller 
            // timestamp, it means we are not the oldest (head of the queue).
            "#print('Comparing {MUTEX." + resource + ".{.i}} < {MUTEX." + 
                     resource + ".{.id}}\n');"
            "(MUTEX." + resource + ".{.i} < MUTEX." + resource + ".{.id}) =>"
            "("
              "#print('We are not oldest...\n');"
              ".areWeOldest = 0;"
            ");"

            // Check the case when the timestamps are equal, and break the tie 
            // by id.
            "((MUTEX." + resource + ".{.i} == MUTEX." + resource + ".{.id}) "
              " && (.i < .id)) =>"
            "("
              // If there is a request for the same resource with the same 
              // timestamp and with smaller id, they win, we are not the oldest.
              ".areWeOldest = 0;"
            ");"
          ")"
        ");"

        // If we are the oldest, that means that we got the lock.
        "(.areWeOldest == 1) => "
        "("
          ".agent{.id}.got_lock = 1;"
          "MUTEX." + resource + ".{.id}.granted = 1;"
        ")"
      ");>"

      // Check if all agents have received oks from all others.
      // We will repeate the evaluation of this whole predicate until it is true.
      ".agent{.id}.got_lock"
      , wait_settings).to_integer();

    if(expValue == 1)
    {
      knowledge->print("\nLock for resource "+
                       resource+" granted to id {.id}!\n\n");
      sucess = true;
    }
    else
    {
      knowledge->print("\nTimeout waiting for lock; return: " + 
                       INT_TO_STRING(expValue) + "\n");
      knowledge->print("Trying again.\n");
    }

    knowledge->print_knowledge();
  }

  // To simulate a step.
  sleepForMilliseconds(1000);
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void release_resource(std::string resource)
{
  knowledge->print("Releasing lock for resource " + 
                   resource + " granted to id {.id}\n\n");
  knowledge->evaluate(
    // Clear our request, since we are releasing it now, and indicate we no 
    // longer have a lock.
    "MUTEX." + resource + ".{.id} = 0;"
    "MUTEX." + resource + ".{.id}.granted = 0;"
    );
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
std::string nodeResourceName(crdtype x, crdtype y)
{
  std::string resource = INT_TO_STRING(x*m_numCols+y);
  return resource;
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
std::string edgeResourceName(crdtype from_x, crdtype from_y, 
  crdtype to_x, crdtype to_y)
{
  // Ensure that the name of the edge is always the same (it is not directed, 
  // the edge resource is the same seen from both ways).
  std::string resource = "";
  if(from_x < to_x)
  {
    resource = INT_TO_STRING(from_x) + "," + INT_TO_STRING(from_y)+ "-" + 
               INT_TO_STRING(to_x)+ "," + INT_TO_STRING(to_y);
  }
  else
  {
    resource = INT_TO_STRING(to_x) + "," + INT_TO_STRING(to_y)+ "-" + 
               INT_TO_STRING(from_x)+ "," + INT_TO_STRING(from_y);
  }
  return resource;
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void lock_node(crdtype x, crdtype y)
{
  std::string resource = nodeResourceName(x, y);
  lock_resource(resource);
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void lock_edge(crdtype from_x, crdtype from_y, crdtype to_x,crdtype to_y)
{    
  std::string resource = edgeResourceName(from_x, from_y, to_x, to_y);
  lock_resource(resource);
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void release_node(crdtype x,crdtype y)
{
  std::string resource = nodeResourceName(x, y);
  release_resource(resource);
}

///////////////////////////////////////////////////////////////////////////////
//
///////////////////////////////////////////////////////////////////////////////
void release_edge(crdtype from_x, crdtype from_y, crdtype to_x,crdtype to_y)
{
  std::string resource = edgeResourceName(from_x, from_y, to_x, to_y);
  release_resource(resource);
}
