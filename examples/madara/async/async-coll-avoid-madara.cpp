
#include <string>
#include <vector>
#include <iostream>
#include <sstream>
#include <assert.h>

#include "ace/OS_NS_Thread.h"
#include "ace/Sched_Params.h"
#include "madara/knowledge_engine/Knowledge_Base.h"
#include "madara/filters/Generic_Filters.h"

// transport settings
std::string host ("");
const std::string default_multicast ("239.255.0.1:4150");
Madara::Transport::QoS_Transport_Settings settings;

// number of participating processes
Madara::Knowledge_Record::Integer processes (2);

// convenience variable for treating globals as locals
Madara::Knowledge_Engine::Eval_Settings es_treat_as_local (false, true);

// compiled init function
Madara::Knowledge_Engine::Compiled_Expression init_function_logic,
  reset_responses_at_current_location, reset_future_responses,
  count_finished_logic, refresh_status_logic, next_xy_logic, execute_logic,
  synchronize_barrier;

// rows and columns are set to y, x
Madara::Knowledge_Record::Integer cols (4), rows (4);

// variable references for quick access within functions
Madara::Knowledge_Engine::Variable_Reference x_ref, xp_ref, y_ref, yp_ref,
  id_ref;

// settings for keeping all changes local
Madara::Knowledge_Engine::Knowledge_Update_Settings local_changes_only (true);

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
  return vars.evaluate (refresh_status_logic);
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
  return vars.evaluate (next_xy_logic);
}

Madara::Knowledge_Record
RESPOND (Madara::Knowledge_Engine::Function_Arguments & args,
         Madara::Knowledge_Engine::Variables & vars)
{
  Madara::Knowledge_Record result;

  if (args.size () > 1)
  {
    // if the variable name begins with "request."
    if (Madara::Utility::begins_with (args[1].to_string (), "request."))
    {
      // tokenize the string by "."
      std::vector <std::string> splitters, tokens, pivot_list;
      splitters.push_back (".");

      Madara::Utility::tokenizer (
        args[1].to_string (), splitters, tokens, pivot_list);

      if (tokens.size () == 4)
      {
        // we're interested in the requester id in "request.idp.x.y"
        Madara::Knowledge_Record id_str (tokens[1]),
          xo_str (tokens[2]), yo_str (tokens[3]);
        Madara::Knowledge_Record::Integer requester_id = id_str.to_integer ();
        
        // build the response var name "request.idp.x.y.id"
        std::stringstream response_var_name;
        response_var_name << args[1].to_string ();
        response_var_name << ".";
        response_var_name << vars.get (id_ref).to_string ();

        /**
          * We could handle the requirements in many ways here. We'll
          * simply update the knowledge base with the reply for this message,
          * which will result in an update being sent whenever we execute our
          * next knowledge.evaluate, knowledge.set, or knowledge.evaluate.
          *
          * However, we could also handle this immediately by sending out
          * responses by pushing "var name" and then the var value onto the
          * args list
          **/

        // if the requester id is greater than ours
        if      (requester_id > settings.id)
        {
          if (xo_str.to_string () == vars.get (x_ref).to_string () &&
              yo_str.to_string () == vars.get (y_ref).to_string ())
          {
            // reject because we are already here
            vars.set (response_var_name.str (),
              Madara::Knowledge_Record::Integer (-1));
          }
          else
          {
            // otherwise, accept because we have no conflict
            vars.set (response_var_name.str (),
              Madara::Knowledge_Record::Integer (1));
          }
        }
        // else if requester id is less than ours
        else if (requester_id < settings.id)
        {
          /**
           * I assume the semantics are that we are resetting all grant and
           * reject messages at our location, not just granted messages
           **/
          vars.evaluate (reset_responses_at_current_location);

          if (
               // if the request is for our current location
               (xo_str.to_string () == vars.get (x_ref).to_string () &&
                yo_str.to_string () == vars.get (y_ref).to_string ())

                // or it is at our future, locked location
                ||
               (xo_str.to_string () == vars.get (xp_ref).to_string () &&
                yo_str.to_string () == vars.get (yp_ref).to_string ())
              )
          {
            std::stringstream buffer;
            buffer << "RESPONSE: sending ";
            buffer << response_var_name.str ();
            buffer << "=";
            buffer << -1;
            buffer << "\n";
            
            vars.print (buffer.str ());
            // reject because we are already here
            vars.set (response_var_name.str (),
              Madara::Knowledge_Record::Integer (-1));
          }
          else
          {
            std::stringstream buffer;
            buffer << "RESPONSE: sending ";
            buffer << response_var_name.str ();
            buffer << "=";
            buffer << 1;
            buffer << "\n";
            
            vars.print (buffer.str ());
            // otherwise, accept because we have no conflict
            vars.set (response_var_name.str (),
              Madara::Knowledge_Record::Integer (1));
          }
        }
        // we do not respond to messages from ourself (requester_id == id)
      }
    }

    result = args[0];
  }
  
  return result;
}

Madara::Knowledge_Record
RESET_FUTURES_LOCALLY (Madara::Knowledge_Engine::Function_Arguments &,
               Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (reset_future_responses, local_changes_only);
}

Madara::Knowledge_Record
EXECUTE (Madara::Knowledge_Engine::Function_Arguments &,
         Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (execute_logic);
}

// count the number of finished processes
Madara::Knowledge_Record
COUNT_FINISHED (Madara::Knowledge_Engine::Function_Arguments &,
                Madara::Knowledge_Engine::Variables & vars)
{
  return vars.evaluate (count_finished_logic);
}

void compile_expressions (Madara::Knowledge_Engine::Knowledge_Base & knowledge)
{
  knowledge.print ("compiling init logic...\n");
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
  
  knowledge.print ("compiling count_finished logic...\n");
  count_finished_logic = knowledge.compile (
    ".finished = 0 ;> "
    ".i [0->.n)"
    "  ("
    "    (x_{.i} == xf_{.i} && y_{.i} == yf_{.i}) => (++.finished)"
    "  ) ;> "
    ".finished"
  );
  
  knowledge.print ("compiling execute logic...\n");
  execute_logic = knowledge.compile (
    // is state_{.id} equal to NEXT?
    "(state_{.id} == 'NEXT' =>\n"
    "  (\n"
    "    #print ('  Handling state == NEXT\n');\n"
    "    !(x_{.id} == xf_{.id} && y_{.id} == yf_{.id}) =>\n"
    "      (\n"
    "        NEXT_XY ();\n"
    "        RESET_FUTURES_LOCALLY ();\n"
    "        state_{.id} = 'WAITING'\n"
    "      )\n"
    "  )\n"
    // or
    ") ||\n"
    // is state_{.id} equal to WAITING?
    "(state_{.id} == 'WAITING' =>\n"
    "  (\n"
    "    #print ('  Handling state == WAITING\n');\n"

         // resend the request
    "    request.{.id}.{xp_{.id}}.{yp_{.id}} = 1;\n"
    "    request.{.id}.{xp_{.id}}.{yp_{.id}}.{.id} = 1;\n"

         // count the rejects and absents
    "    .rejects = .absents = 0;\n"
    "    .i [0->.n) "
    "    (\n"
    "       (request.{.id}.{xp_{.id}}.{yp_{.id}}.{.i} == 0 => ++.absents) ||\n"
    "       (request.{.id}.{xp_{.id}}.{yp_{.id}}.{.i} == -1 => ++.rejects)\n"
    "    );\n"
    "    #print ('  Inside of WAITING, .absents={.absents}, .rejects={.rejects}\n');\n"
         // if we had rejects, reset to NEXT state
    "    (\n"
    "      //.rejects => state_{.id} = 'NEXT'\n"
    "    )\n"
    "    ||"
         // or if we have all votes in and no rejects
    "    (\n"
    "      !.absents => state_{.id} = 'MOVE'\n"
    "    )\n"
    "    \n"
    "  )\n"
    ") ||\n"
    // is state_{.id} equal to MOVE?
    "(state_{.id} == 'MOVE' =>\n"
    "  (\n"
    "    #print ('  Handling state == MOVE\n');\n"
    //"     #rand_int (0, 5) == 0 =>"
    "    (\n"
    "      lock_{.id}[x_{.id} * Y + y_{.id}] = 0;\n"
    "      x_{.id} = xp_{.id};\n"
    "      y_{.id} = yp_{.id};\n"
    "      state_{.id} = 'NEXT'\n"
    "    )\n"
    "  )\n"
    ")"
  );
  
  knowledge.print ("compiling next_xy logic...\n");
  next_xy_logic = knowledge.compile (
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
  
  knowledge.print ("compiling refresh_status logic...\n");
  refresh_status_logic = knowledge.compile (
    "x_{.id} = x_{.id};"
    "y_{.id} = y_{.id};"
    "lock_{.id} = lock_{.id};"
    "xf_{.id} = xf_{.id};"
    "yf_{.id} = yf_{.id};"
    "b_{.id} = b_{.id};"
  );
  
  knowledge.print ("compiling reset_responses_at_current_location logic...\n");
  // compile reset logic which needs to be fast during receive messages
  reset_responses_at_current_location = knowledge.compile (
    // for all i from 0 to number of processes
    ".i [0->.n)\n"
    "(\n"
    // if request is not reset, then reset it
    "  request.{.i}.{x_{.id}}.{y_{.id}}.{.id} =>\n"
    "    request.{.i}.{x_{.id}}.{y_{.id}}.{.id} = 0\n"
    ")"
  );
  
  knowledge.print ("compiling reset_future_responses logic...\n");
  // compile reset logic for responses for requests to future location
  reset_future_responses = knowledge.compile (
    // for all i from 0 to number of processes
    ".i [0->.n)\n"
    "(\n"
    // if request is not reset, then reset it
    "  request.{.id}.{xp_{.id}}.{yp_{.id}}.{.i} =>\n"
    "    request.{.id}.{xp_{.id}}.{yp_{.id}}.{.i} = 0\n"
    ")"
  );
  
  knowledge.print ("compiling synchronize_barriers logic...\n");
  synchronize_barrier = knowledge.compile (
    "b_{.id} = (b_0 ; b_1)"
  );
}

void define_functions (Madara::Knowledge_Engine::Knowledge_Base & knowledge)
{
  knowledge.define_function ("INIT", INIT);
  knowledge.define_function ("REFRESH_STATUS", REFRESH_STATUS);
  knowledge.define_function ("NEXT_XY", NEXT_XY);
  knowledge.define_function ("EXECUTE", EXECUTE);
  knowledge.define_function ("COUNT_FINISHED", COUNT_FINISHED);
  knowledge.define_function ("PRINT_BOARD", PRINT_BOARD);
  knowledge.define_function ("RESPOND", RESPOND);
  knowledge.define_function ("RESET_FUTURES_LOCALLY", RESET_FUTURES_LOCALLY);
}

void get_variable_refs (Madara::Knowledge_Engine::Knowledge_Base & knowledge)
{
  id_ref = knowledge.get_ref (".id");
  x_ref = knowledge.get_ref (knowledge.expand_statement ("x_{.id}"));
  y_ref = knowledge.get_ref (knowledge.expand_statement ("y_{.id}"));
  xp_ref = knowledge.get_ref (knowledge.expand_statement ("xp_{.id}"));
  yp_ref = knowledge.get_ref (knowledge.expand_statement ("yp_{.id}"));
}

int main (int argc, char ** argv)
{
  ACE_TRACE (ACE_TEXT ("main"));
  
  settings.type = Madara::Transport::MULTICAST;

  // use ACE real time scheduling class
  //int prio  = ACE_Sched_Params::next_priority
  //  (ACE_SCHED_FIFO,
  //   ACE_Sched_Params::priority_max (ACE_SCHED_FIFO),
  //   ACE_SCOPE_THREAD);
  //ACE_OS::thr_setprio (prio);

  // handle any command line arguments
  handle_arguments (argc, argv);

  if (settings.hosts.size () == 0)
  {
    // setup default transport as multicast
    settings.hosts.push_back (default_multicast);
  }
  
  settings.queue_length = 100000;
  //settings.add_receive_filter (Madara::Filters::log_aggregate);
  settings.add_receive_filter (Madara::Knowledge_Record::ALL_TYPES, RESPOND);
  //settings.add_send_filter (Madara::Filters::log_aggregate);

  Madara::Knowledge_Engine::Wait_Settings wait_settings;
  wait_settings.max_wait_time = 10;
  wait_settings.poll_frequency = .1;
  //wait_settings.pre_print_statement = "PRE: Barriers: b_0 = {b_0}, b_1 = {b_1}\n";
  //wait_settings.post_print_statement = "POST: Barriers: b_0 = {b_0}, b_1 = {b_1}\n";

  // create the knowledge base with the transport settings
  Madara::Knowledge_Engine::Knowledge_Base knowledge (host, settings);

  // define functions we will use in MADARA
  define_functions (knowledge);

  // define constants that will never change and do not disseminate them
  knowledge.set (".id", Madara::Knowledge_Record::Integer (settings.id));
  knowledge.set (".n", processes);
  knowledge.set ("X", cols, es_treat_as_local);
  knowledge.set ("Y", rows, es_treat_as_local);
  
  // grab variable references for quick variable lookups in functions
  get_variable_refs (knowledge);

  std::string barrier_string = "REFRESH_STATUS () ;> b_1 >= b_0";

  if (settings.id != 0)
  {
    barrier_string = "REFRESH_STATUS () ;> b_0 >= b_1";
  }

  // compile all expressions
  compile_expressions (knowledge);

  // keep a send list with only the barrier information for safe rounds
  std::map <std::string, bool>  barrier_send_list;
  barrier_send_list [knowledge.expand_statement ("b_{.id}")] = true;
  
  std::string post_print = "b_0 ({b_0}) == b_1 ({b_1})\n";

  // call the init function and initialize barrier
  knowledge.evaluate ("INIT (); ++b_{.id}", wait_settings);
  knowledge.print ("INIT: {x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");

  while (knowledge.evaluate (
    "COUNT_FINISHED () == 2 || finished_0 || finished_1").is_false ())
  {
    //print the board
    knowledge.evaluate ("PRINT_BOARD ()");

    knowledge.print ("{b_{.id}}: Executing round: "
      "{x_{.id}}.{y_{.id}} -> {xf_{.id}}.{yf_{.id}}.\n");

    // perform the round logic
    knowledge.evaluate (
      "EXECUTE (); ++b_{.id}", wait_settings);

    Madara::Utility::sleep (0.1);
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
