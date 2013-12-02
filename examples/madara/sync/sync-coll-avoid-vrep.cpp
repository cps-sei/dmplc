
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <assert.h>
#include <math.h>

#include "ace/OS_NS_Thread.h"
#include "ace/Sched_Params.h"
#include "madara/knowledge_engine/Knowledge_Base.h"
#include "madara/utility/Utility.h"
#include "madara/filters/Generic_Filters.h"

#include "sync-coll-avoid-vrep.h"

// transport settings
std::string host ("");
const std::string default_multicast ("239.255.0.1:4150");
Madara::Transport::QoS_Transport_Settings settings;

// number of participating processes
Madara::Knowledge_Record::Integer processes (2);

// convenience variable for treating globals as locals
Madara::Knowledge_Engine::Eval_Settings es_treat_as_local (false, true);

// compiled init function
Madara::Knowledge_Engine::Compiled_Expression init_function_logic;

// rows and columns are set to y, x
Madara::Knowledge_Record::Integer cols (4), rows (4);

//degrees per metre
const double DPM = .00000899928005759539;
//error in metres that we allow
const double EIM = .1;

//talk to v-rep and make the drones move to x and y
void move_to(int x,int y)
{
  std::cout << "moving to (" << x << "," << y << ")\n";
  sim_platform_move_to_altitude(2.0);

  // remove platform specific sleep time and use the MADARA utility for sleep
  Madara::Utility::sleep (3.0);

  sim_platform_move_to_location(y * DPM, x * DPM, 2.0);

  //wait till we have 
  for(;;) {
    Madara::Utility::sleep (0.5);
    std::map<std::string, double> currLoc = sim_platform_read_gps();
    double _lat = currLoc["latitude"];
    double _long = currLoc["longitude"];
    if(fabs(_lat - y * DPM) / DPM < EIM &&
       fabs(_long - x * DPM) / DPM < EIM) break;
  }

  std::cout << "reached (" << x << "," << y << ")\n";
}

// handle arguments from the command line
void handle_arguments (int argc, char ** argv)
{
  for (int i = 1; i < argc; ++i)
  {
    std::string arg1 (argv[i]);
    
    if (arg1 == "-m" || arg1 == "--multicast")
    {
      if (i + 1 < argc)
      {
        settings.hosts.push_back (argv[i + 1]);
        settings.type = Madara::Transport::MULTICAST;
      }
      ++i;
    }
    else if (arg1 == "-b" || arg1 == "--broadcast")
    {
      if (i + 1 < argc)
      {
        settings.hosts.push_back (argv[i + 1]);
        settings.type = Madara::Transport::BROADCAST;
      }
      ++i;
    }
    else if (arg1 == "-u" || arg1 == "--udp")
    {
      if (i + 1 < argc)
      {
        settings.hosts.push_back (argv[i + 1]);
        settings.type = Madara::Transport::UDP;
      }
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
    else if (arg1 == "-x" || arg1 == "--cols")
    {
      if (i + 1 < argc)
      {
        std::stringstream buffer (argv[i + 1]);
        buffer >> cols;
      }

      ++i;
    }
    else if (arg1 == "-y" || arg1 == "--rows")
    {
      if (i + 1 < argc)
      {
        std::stringstream buffer (argv[i + 1]);
        buffer >> rows;
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
        " [-b|--broadcast ip:port] the broadcast ip to send and listen to\n" \
        " [-d|--domain domain]     the knowledge domain to send and listen to\n" \
        " [-f|--logfile file]      log to a file\n" \
        " [-i|--id id]             the id of this agent (should be non-negative)\n" \
        " [-l|--level level]       the logger level (0+, higher is higher detail)\n" \
        " [-m|--multicast ip:port] the multicast ip to send and listen to\n" \
        " [-o|--host hostname]     the hostname of this process (def:localhost)\n" \
        " [-r|--reduced]           use the reduced message header\n" \
        " [-u|--udp ip:port]       the udp ips to send to (first is self to bind to)\n" \
        " [-x|--cols num_cols]     setup a board with num_cols number of columns\n" \
        " [-y|--rows num_rows]     setup a board with num_rows number of rows\n" \
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
  return vars.evaluate (init_function_logic);
}

//print the board and the drone's location
Madara::Knowledge_Record
PRINT_BOARD (Madara::Knowledge_Engine::Function_Arguments &,
             Madara::Knowledge_Engine::Variables & vars)
{
  int X = vars.get ("X").to_integer ();
  int Y = vars.get ("Y").to_integer ();
  int x_0 = vars.get ("x_0").to_integer ();
  int x_1 = vars.get ("x_1").to_integer ();
  int y_0 = vars.get ("y_0").to_integer ();
  int y_1 = vars.get ("y_1").to_integer ();
  
  // print horizontal separator
  vars.print (" ", 0);
  for (int x = 0; x < X; ++x)
    vars.print ("--- ", 0);
  vars.print ("\n", 0);

  // for each row
  for(int y = 0; y < Y; ++y)
  {
    vars.print ("|", 0);

    // separate each entry by a |
    for (int x = 0; x < X; ++x)
    {
      if (x == x_0 && y == y_0)
        vars.print (" 0 |", 0);
      else if (x == x_1 && y == y_1)
        vars.print (" 1 |", 0);
      else 
        vars.print ("   |", 0);
    }

    // print a newline and spacer
    vars.print ("\n", 0);
    vars.print (" ", 0);

    // print horizontal separator
    for (int x = 0; x < X; ++x)
      vars.print ("--- ", 0);

    vars.print ("\n", 0);
  }

  return 0.0;
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
MOVETO (Madara::Knowledge_Engine::Function_Arguments &,
        Madara::Knowledge_Engine::Variables & vars)
{
  //move to next location
  move_to(vars.evaluate(vars.expand_statement ("xp_{.id}")).to_integer(),
          vars.evaluate(vars.expand_statement ("yp_{.id}")).to_integer());
  return 0.0;
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
    "      MOVETO ();"
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
  ACE_TRACE (ACE_TEXT ("main"));
  
  settings.type = Madara::Transport::MULTICAST;

  // use ACE real time scheduling class
  int prio  = ACE_Sched_Params::next_priority
    (ACE_SCHED_FIFO,
     ACE_Sched_Params::priority_max (ACE_SCHED_FIFO),
     ACE_SCOPE_THREAD);
  ACE_OS::thr_setprio (prio);

  // handle any command line arguments
  handle_arguments (argc, argv);

  if (settings.hosts.size () == 0)
  {
    // setup default transport as multicast
    settings.hosts.push_back (default_multicast);
  }

  //initiate connection with the simulator
  sim_setup(settings.id);

  settings.queue_length = 100000;
  //settings.add_receive_filter (Madara::Filters::log_aggregate);
  //settings.add_send_filter (Madara::Filters::log_aggregate);

  Madara::Knowledge_Engine::Wait_Settings wait_settings;
  wait_settings.max_wait_time = 10;
  wait_settings.poll_frequency = .1;
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
  knowledge.define_function ("PRINT_BOARD", PRINT_BOARD);
  knowledge.define_function ("MOVETO", MOVETO);

  // define constants that will never change and do not disseminate them
  knowledge.set (".id", Madara::Knowledge_Record::Integer (settings.id));
  knowledge.set (".n", processes);
  knowledge.set ("X", cols, es_treat_as_local);
  knowledge.set ("Y", rows, es_treat_as_local);
  
  std::string barrier_string = "REFRESH_STATUS () ;> b_1 >= b_0";

  if (settings.id != 0)
  {
    barrier_string = "REFRESH_STATUS () ;> b_0 >= b_1";
  }

  //side 0
  if(settings.id == 0) {
    init_function_logic = knowledge.compile (
      "state_{.id} = 'NEXT';"
      "x_{.id} = 0;\n"
      "y_{.id} = 4;\n"
      "xf_{.id} = 9;\n"
      "yf_{.id} = 4;\n"
      "lock_{.id}[x_{.id} * Y + y_{.id}] = 1"
    );
  }
  //side 1
  else {
    init_function_logic = knowledge.compile (
      "state_{.id} = 'NEXT';"
      "x_{.id} = 5;\n"
      "y_{.id} = 9;\n"
      "xf_{.id} = 5;\n"
      "yf_{.id} = 0;\n"
      "lock_{.id}[x_{.id} * Y + y_{.id}] = 1"
    );
  }

#if 0
  init_function_logic = knowledge.compile (
    "state_{.id} = 'NEXT';"
    ".side = #rand_int (0, 4);"
    "(.side == 0 =>\n"
    "  (\n"
    "    x_{.id} = 0;\n"
    "    y_{.id} = #rand_int (0, Y - 1)\n"
    "  )\n"
    ") ||\n"
    "(.side == 1 =>\n"
    "  (\n"
    "    x_{.id} = #rand_int (0, X - 1);\n"
    "    y_{.id} = 0\n"
    "  )\n"
    ") ||\n"
    "(.side == 2 =>\n"
    "  (\n"
    "    y_{.id} = #rand_int (0, Y - 1);\n"
    "    x_{.id} = X - 1\n"
    "  )\n"
    ") ||\n"
    "(.side == 3 =>\n"
    "  (\n"
    "    x_{.id} = #rand_int (0, X - 1);\n"
    "    y_{.id} = Y - 1\n"
    "  )\n"
    ");\n"
    ".side = #rand_int (0, 4);"
    "(.side == 0 =>\n"
    "  (\n"
    "    xf_{.id} = 0;\n"
    "    yf_{.id} = #rand_int (0, Y - 1, false)\n"
    "  )\n"
    ") ||\n"
    "(.side == 1 =>\n"
    "  (\n"
    "    xf_{.id} = #rand_int (0, X - 1, false);\n"
    "    yf_{.id} = 0\n"
    "  )\n"
    ") ||\n"
    "(.side == 2 =>\n"
    "  (\n"
    "    yf_{.id} = #rand_int (0, Y - 1, false);\n"
    "    xf_{.id} = X - 1\n"
    "  )\n"
    ") ||\n"
    "(.side == 3 =>\n"
    "  (\n"
    "    xf_{.id} = #rand_int (0, X - 1, false);\n"
    "    yf_{.id} = Y - 1\n"
    "  )\n"
    ");\n"
    "lock_{.id}[x_{.id} * Y + y_{.id}] = 1"
    );
#endif

  // keep a send list with only the barrier information for safe rounds
  std::map <std::string, bool>  barrier_send_list;
  barrier_send_list [knowledge.expand_statement ("b_{.id}")] = true;
  
  std::string post_print = "b_0 ({b_0}) == b_1 ({b_1})\n";

  // call the init function and initialize barrier
  knowledge.evaluate ("INIT (); ++b_{.id}", wait_settings);
  knowledge.print ("INIT: {x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");  

  //move drone to initial location
  move_to(knowledge.get(knowledge.expand_statement ("x_{.id}")).to_integer(),
          knowledge.get(knowledge.expand_statement ("y_{.id}")).to_integer());

  while (knowledge.evaluate (
    "COUNT_FINISHED () == 2 || finished_0 || finished_1").is_false ())
  {
    knowledge.print (
      "Starting a fresh loop (.finished == {.finished})...\n");

    // enable sending all updated variables
    wait_settings.send_list.clear ();
    //wait_settings.post_print_statement = post_print;
    
    knowledge.print (
      "{b_{.id}}: BARRIER on updating round info (...\n");

    // Barrier and send all updates
    knowledge.wait (barrier_string, wait_settings);

    knowledge.evaluate ("b_{.id} = (b_0 ; b_1)");

    //wait_settings.post_print_statement = "";

    //print the board
    knowledge.evaluate ("PRINT_BOARD ()");

    // start round and only send barrier variable updates
    wait_settings.send_list = barrier_send_list;
    
    knowledge.print ("{b_{.id}}: Executing round: "
      "{x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");

    // perform the round logic
    knowledge.evaluate (
      "EXECUTE (); ++b_{.id}", wait_settings);
    
    knowledge.print ("{b_{.id}}: BARRIER on end of round...\n");
    
    //wait_settings.post_print_statement = post_print;

    // wait for other processes to get through execute round and do not
    // send updates to anything except barrier variable
    knowledge.wait (barrier_string, wait_settings);
    
    knowledge.evaluate ("b_{.id} = (b_0 ; b_1)");

    // update barrier variable
    knowledge.evaluate ("++b_{.id}", wait_settings);
  }
  
  // enable sending all updated variables
  wait_settings.send_list.clear ();
    
  knowledge.print ("{b_{.id}}: Reached final location: "
    "{x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");

  // update barrier variable
  knowledge.wait ("REFRESH_STATUS () ;> "
    "finished_{.id} = 1;> finished_0 == finished_1 ", wait_settings);

  //print the board
  knowledge.print ("\n*****Final board*****.\n");
  knowledge.evaluate ("PRINT_BOARD ()");

  return 0;
}
