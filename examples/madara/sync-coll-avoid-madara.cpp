
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <assert.h>

#include "madara/knowledge_engine/Knowledge_Base.h"

// transport settings
std::string host ("");
const std::string default_multicast ("239.255.0.1:4150");
Madara::Transport::QoS_Transport_Settings settings;

// number of participating processes
Madara::Knowledge_Record::Integer processes (2);

// convenience variable for treating globals as locals
Madara::Knowledge_Engine::Eval_Settings es_treat_as_local (false, true);

// handle arguments from the command line
void handle_arguments (int argc, char ** argv)
{
  for (int i = 1; i < argc; ++i)
  {
    std::string arg1 (argv[i]);

    if (arg1 == "-m" || arg1 == "--multicast")
    {
      if (i + 1 < argc)
        settings.hosts[0] = argv[i + 1];

      ++i;
    }
    else if (arg1 == "-o" || arg1 == "--host")
    {
      if (i + 1 < argc)
        host = argv[i + 1];

      ++i;
    }
    else if (arg1 == "-d" || arg1 == "--domain")
    {
      if (i + 1 < argc)
        settings.domains = argv[i + 1];

      ++i;
    }
    else if (arg1 == "-i" || arg1 == "--id")
    {
      if (i + 1 < argc)
      {
        std::stringstream buffer (argv[i + 1]);
        buffer >> settings.id;
      }

      ++i;
    }
    else if (arg1 == "-l" || arg1 == "--level")
    {
      if (i + 1 < argc)
      {
        std::stringstream buffer (argv[i + 1]);
        buffer >> MADARA_debug_level;
      }

      ++i;
    }
    else if (arg1 == "-p" || arg1 == "--drop-rate")
    {
      if (i + 1 < argc)
      {
        double drop_rate;
        std::stringstream buffer (argv[i + 1]);
        buffer >> drop_rate;
        
        settings.update_drop_rate (drop_rate,
          Madara::Transport::PACKET_DROP_DETERMINISTIC);
      }

      ++i;
    }
    else if (arg1 == "-f" || arg1 == "--logfile")
    {
      if (i + 1 < argc)
      {
        Madara::Knowledge_Engine::Knowledge_Base::log_to_file (argv[i + 1]);
      }

      ++i;
    }
    else if (arg1 == "-r" || arg1 == "--reduced")
    {
      settings.send_reduced_message_header = true;
    }
    else
    {
      MADARA_DEBUG (MADARA_LOG_EMERGENCY, (LM_DEBUG, 
        "\nProgram summary for %s:\n\n" \
        "  Test the collision avoidance protocol with multicast transport."
        "\n\n" \
        " [-o|--host hostname]     the hostname of this process (def:localhost)\n" \
        " [-m|--multicast ip:port] the multicast ip to send and listen to\n" \
        " [-d|--domain domain]     the knowledge domain to send and listen to\n" \
        " [-i|--id id]             the id of this agent (should be non-negative)\n" \
        " [-l|--level level]       the logger level (0+, higher is higher detail)\n" \
        " [-f|--logfile file]      log to a file\n" \
        " [-r|--reduced]           use the reduced message header\n" \
        "\n",
        argv[0]));
      exit (0);
    }
  }
}

// initialization method
Madara::Knowledge_Record
INIT (Madara::Knowledge_Engine::Function_Arguments &,
      Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (
    "state_{.id} = 'NEXT';"
    "x_{.id} = #rand_int (0, X);"
    "y_{.id} = #rand_int (0, Y);"
    "lock_{.id}[x_{.id} * Y + y_{.id}] = 1;"
    "xf_{.id} = #rand_int (0, X);"
    "yf_{.id} = #rand_int (0, Y)"
  );
}

// refresh status during barrier, in case of intermittent connections
Madara::Knowledge_Record
REFRESH_STATUS (Madara::Knowledge_Engine::Function_Arguments &,
                Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (
    "x_{.id} = x_{.id};"
    "y_{.id} = y_{.id};"
    "lock_{.id} = lock_{.id};"
    "xf_{.id} = xf_{.id};"
    "yf_{.id} = yf_{.id};"
    "b_{.id} = b_{.id};"
  );
}

// 
Madara::Knowledge_Record
CHECK_SAFETY (Madara::Knowledge_Engine::Function_Arguments &,
              Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate ("x_0 != x_1 || y_0 != y_1");
}

  
Madara::Knowledge_Record
NEXT_XY (Madara::Knowledge_Engine::Function_Arguments &,
         Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (
    "xp_{.id} = x_{.id};"
    "yp_{.id}  = y_{.id};"
    "(x_{.id} < xf_{.id} => (xp_{.id} = x_{.id} + 1))"
    "||"
    "(x_{.id} > xf_{.id} => (xp_{.id} = x_{.id} - 1))"
    "||"
    "(y_{.id} < yf_{.id} => (yp_{.id} = y_{.id} + 1))"
    "||"
    "(yp_{.id} = y_{.id} - 1)"
  );
}

Madara::Knowledge_Record
EXECUTE (Madara::Knowledge_Engine::Function_Arguments &,
         Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (
    // is state_{.id} equal to NEXT?
    "(state_{.id} == 'NEXT' => "
    "  ("
    "    #print ('  Handling state == NEXT\n');"
    "    !(x_{.id} == xf_{.id} && y_{.id} == yf_{.id}) =>"
    "      ("
    "        NEXT_XY ();"
    "        state_{.id} = 'REQUEST'"
    "      )"
    "  )"
    // or
    ") ||"
    // is state_{.id} equal to REQUEST?
    "(state_{.id} == 'REQUEST' => "
    "  ("
    "    #print ('  Handling state == REQUEST\n');"
    "    !lock_0[xp_{.id} * Y + yp_{.id}] && !lock_1[xp_{.id} * Y + yp_{.id}]"
    "      =>"
    "      ("
    "        lock_{.id}[xp_{.id} * Y + yp_{.id}] = 1;"
    "        state_{.id} = 'WAITING'"
    "      )"
    "  )"
    ") ||"
    // is state_{.id} equal to WAITING?
    "(state_{.id} == 'WAITING' => "
    "  ("
    "    #print ('  Handling state == WAITING\n');"
    "    !(.id == 0 && lock_1[xp_0 * Y + yp_0])"
    "      =>"
    "      ("
    "        state_{.id} = 'MOVE'"
    "      )"
    "  )"
    ") ||"
    // is state_{.id} equal to MOVE?
    "(state_{.id} == 'MOVE' => "
    "  ("
    "    #print ('  Handling state == MOVE\n');"
    //"     #rand_int (0, 5) == 0 =>"
    "    ("
    "      lock_{.id}[x_{.id} * Y + y_{.id}] = 0;"
    "      x_{.id} = xp_{.id};"
    "      y_{.id} = yp_{.id};"
    "      state_{.id} = 'NEXT'"
    "    )"
    "  )"
    ")"
  );
}

// count the number of finished processes
Madara::Knowledge_Record
COUNT_FINISHED (Madara::Knowledge_Engine::Function_Arguments &,
                Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (
    ".finished = 0 ;> "
    ".i [0->.n)"
    "  ("
    "    (x_{.i} == xf_{.i} && y_{.i} == yf_{.i}) => (++.finished)"
    "  ) ;> "
    ".finished"
  );
}

int main (int argc, char ** argv)
{
  settings.hosts.push_back (default_multicast);

  // handle any command line arguments
  handle_arguments (argc, argv);

  settings.type = Madara::Transport::MULTICAST;
  
  Madara::Knowledge_Engine::Wait_Settings wait_settings;
  wait_settings.max_wait_time = 10;
  wait_settings.poll_frequency = 0.001;
  //wait_settings.pre_print_statement = "PRE: Barriers: b_0 = {b_0}, b_1 = {b_1}\n";
  //wait_settings.post_print_statement = "POST: Barriers: b_0 = {b_0}, b_1 = {b_1}\n";

  // create the knowledge base with the transport settings
  Madara::Knowledge_Engine::Knowledge_Base knowledge (host, settings);

  // define functions we will use in MADARA
  knowledge.define_function ("INIT", INIT);
  knowledge.define_function ("REFRESH_STATUS", REFRESH_STATUS);
  knowledge.define_function ("NEXT_XY", NEXT_XY);
  knowledge.define_function ("EXECUTE", EXECUTE);
  knowledge.define_function ("COUNT_FINISHED", COUNT_FINISHED);

  // define constants that will never change and do not disseminate them
  knowledge.set (".id", Madara::Knowledge_Record::Integer (settings.id));
  knowledge.set (".n", processes);
  knowledge.set ("X", Madara::Knowledge_Record::Integer (4),
                 es_treat_as_local);
  knowledge.set ("Y", Madara::Knowledge_Record::Integer (4),
                 es_treat_as_local);
  
  // keep a send list with only the barrier information for safe rounds
  std::map <std::string, bool>  barrier_send_list;
  barrier_send_list [knowledge.expand_statement ("b_{.id}")] = true;
  
  // call the init function and initialize barrier
  knowledge.evaluate ("INIT (); ++b_{.id}", wait_settings);
  knowledge.print ("INIT: {x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");


  while (knowledge.evaluate ("COUNT_FINISHED ()").to_integer () != 2)
  {
    knowledge.print ("Starting a fresh loop (.finished == {.finished})...\n");

    // enable sending all updated variables
    wait_settings.send_list.clear ();
    
    knowledge.print ("{b_{.id}}: BARRIER on updating round info...\n");

    // Barrier and send all updates
    knowledge.wait ("REFRESH_STATUS () ;> b_0 == b_1 ", wait_settings);

    // start round and only send barrier variable updates
    wait_settings.send_list = barrier_send_list;
    
    knowledge.print ("{b_{.id}}: Executing round: "
      "{x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");

    // perform the round logic
    knowledge.evaluate ("EXECUTE (); ++b_{.id}", wait_settings);
    
    knowledge.print ("{b_{.id}}: BARRIER on end of round...\n");

    // wait for other processes to get through execute round and do not
    // send updates to anything except barrier variable
    knowledge.wait ("REFRESH_STATUS () ;> b_0 == b_1 ", wait_settings);

    // update barrier variable
    knowledge.evaluate ("++b_{.id}", wait_settings);
  }
  
  // enable sending all updated variables
  wait_settings.send_list.clear ();
    
  // update barrier variable
  knowledge.wait ("REFRESH_STATUS () ;> "
    "finished_{.id} = 1;> finished_0 == finished_1 ", wait_settings);


  return 0;
}