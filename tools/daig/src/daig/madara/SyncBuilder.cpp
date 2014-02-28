#include "SyncBuilder.hpp"

daig::madara::SyncBuilder::SyncBuilder (daig::DaigBuilder & builder)
  : builder_ (builder)
{

}

void
daig::madara::SyncBuilder::build ()
{
  // check if we have a valid model of computation
  std::string moc = builder_.program.moc.to_string_type ();
  if (moc != "SYNC" && moc != "MOC_SYNC")
  {
    buffer_ << "ERROR: The MADARA SyncBuilder class only supports the ";
    buffer_ << "synchronous model of computation.\n";
    return;
  }

  // build the header includes
  build_header_includes ();
  build_common_global_variables ();
  build_parse_args ();
  build_functions_declarations ();
  build_functions ();
  build_main_function ();
}

void
daig::madara::SyncBuilder::build_header_includes ()
{
  buffer_ << "#include <string>\n";
  buffer_ << "#include <vector>\n";
  buffer_ << "#include <sstream>\n";
  buffer_ << "#include <assert.h>\n";
  buffer_ << "\n";
  buffer_ << "#include \"madara/knowledge_engine/Knowledge_Base.h\"\n\n";
}

void
daig::madara::SyncBuilder::build_common_global_variables ()
{
  buffer_ << "// default transport variables\n";
  buffer_ << "std::string host (\"\");\n";
  buffer_ << "const std::string default_multicast (\"239.255.0.1:4150\")\n";
  buffer_ << "Madara::Transport::QoS_Transport_Settings settings;\n";
  buffer_ << "\n";
  buffer_ << "// number of participating processes\n";
  buffer_ << "Madara::Knowledge_Record::Integer processes (2);\n\n";
}

void
daig::madara::SyncBuilder::build_parse_args ()
{
  buffer_ << "// handle arguments from the command line\n";
  buffer_ << "void handle_arguments (int argc, char ** argv)\n";
  buffer_ << "{\n";
  buffer_ << "  for (int i = 1; i < argc; ++i)\n";
  buffer_ << "  {\n";
  buffer_ << "    std::string arg1 (argv[i]);\n";
  buffer_ << "\n";
  buffer_ << "    if (arg1 == \"-m\" || arg1 == \"--multicast\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = Madara::Transport::MULTICAST;\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-b\" || arg1 == \"--broadcast\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = Madara::Transport::BROADCAST;\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-u\" || arg1 == \"--udp\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = Madara::Transport::UDP;\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-o\" || arg1 == \"--host\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "        host = argv[i + 1];\n";
  buffer_ << "        \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-d\" || arg1 == \"--domain\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "        settings.domains = argv[i + 1];\n";
  buffer_ << "        \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-i\" || arg1 == \"--id\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> settings.id;\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-l\" || arg1 == \"--level\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> MADARA_debug_level;\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-p\" || arg1 == \"--drop-rate\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        double drop_rate;\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> drop_rate;\n";
  buffer_ << "        \n";
  buffer_ << "        settings.update_drop_rate (drop_rate,\n";
  buffer_ << "          Madara::Transport::PACKET_DROP_DETERMINISTIC);\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-f\" || arg1 == \"--logfile\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        Madara::Knowledge_Engine::Knowledge_Base::log_to_file (argv[i + 1]);\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-r\" || arg1 == \"--reduced\")\n";
  buffer_ << "    {\n";
  buffer_ << "      settings.send_reduced_message_header = true;\n";
  buffer_ << "    }\n";
  buffer_ << "    else\n";
  buffer_ << "    {\n";
  buffer_ << "      MADARA_DEBUG (MADARA_LOG_EMERGENCY, (LM_DEBUG, \n";
  buffer_ << "        \"\\nProgram summary for %s:\\n\\n\"\\\n";
  buffer_ << "        \" [-b|--broadcast ip:port] the broadcast ip to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-d|--domain domain]     the knowledge domain to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-f|--logfile file]      log to a file\\n\"\\\n";
  buffer_ << "        \" [-i|--id id]             the id of this agent (should be non-negative)\\n\"\\\n";
  buffer_ << "        \" [-l|--level level]       the logger level (0+, higher is higher detail)\\n\"\\\n";
  buffer_ << "        \" [-m|--multicast ip:port] the multicast ip to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-o|--host hostname]     the hostname of this process (def:localhost)\\n\"\\\n";
  buffer_ << "        \" [-r|--reduced]           use the reduced message header\\n\"\\\n";
  buffer_ << "        \" [-u|--udp ip:port]       the udp ips to send to (first is self to bind to)\\n\"\\\n";
  buffer_ << "        \" [-x|--cols num_cols]     setup a board with num_cols number of columns\\n\"\\\n";
  buffer_ << "        \" [-y|--rows num_rows]     setup a board with num_rows number of rows\\n\"\\\n";
  buffer_ << "        , argv[0]));\n";
  buffer_ << "      exit (0);\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n";
  buffer_ << "}\n\n";
}

void
daig::madara::SyncBuilder::build_functions_declarations ()
{
  buffer_ << "// Forward declaring global functions\n\n";
  Functions & funcs = builder_.program.funcs;
  for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function_declaration (i->second);
  }
  
  buffer_ << "\n// Forward declaring node functions\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    Functions & funcs = n->second.funcs;
    for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_function_declaration (i->second);
    }
  }

  buffer_ << "\n";
}

void
daig::madara::SyncBuilder::build_functions ()
{
  buffer_ << "// Defining global functions\n\n";
  Functions & funcs = builder_.program.funcs;
  for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function (i->second);
  }


  buffer_ << "// Defining node functions\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    Functions & funcs = n->second.funcs;
    for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_function (i->second);
    }
  }

  buffer_ << "\n";
}

void
daig::madara::SyncBuilder::build_function_declaration (
  daig::Function & function)
{
  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << function.name << " ";
  buffer_ << "(Madara::Knowledge_Engine::Function_Arguments & args,\n";
  buffer_ << "  Madara::Knowledge_Engine::Variables & vars);\n";
}

void
daig::madara::SyncBuilder::build_function (
  daig::Function & function)
{
  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << function.name << " ";
  buffer_ << "(Madara::Knowledge_Engine::Function_Arguments & args,\n";
  buffer_ << "  Madara::Knowledge_Engine::Variables & vars)\n";
  buffer_ << "{\n";
  buffer_ << "  return 0.0\n";
  buffer_ << "}\n\n";
}


void
daig::madara::SyncBuilder::build_main_function ()
{
  buffer_ << "int main (int argc, char ** argv)\n";
  buffer_ << "{\n";
  buffer_ << "  settings.type = Madara::Transport::MULTICAST;\n";
  buffer_ << "\n";
  buffer_ << "  // handle any command line arguments\n";
  buffer_ << "  handle_arguments (argc, argv);\n";
  buffer_ << "\n";
  buffer_ << "  if (settings.hosts.size () == 0)\n";
  buffer_ << "  {\n";
  buffer_ << "    // setup default transport as multicast\n";
  buffer_ << "    settings.hosts.push_back (default_multicast);\n";
  buffer_ << "  }\n\n";
  
  buffer_ << "  settings.queue_length = 100000;\n\n";

  buffer_ << "  Madara::Knowledge_Engine::Wait_Settings wait_settings;\n";
  buffer_ << "  wait_settings.max_wait_time = 10;\n";
  buffer_ << "  wait_settings.poll_frequency = .1;\n\n";

  buffer_ << "  // create the knowledge base with the transport settings\n";
  buffer_ << "  Madara::Knowledge_Engine::Knowledge_Base knowledge (host, settings);\n\n";

  build_main_define_functions ();

  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
}

void
daig::madara::SyncBuilder::build_main_define_functions ()
{
  buffer_ << "  // Defining global functions for MADARA\n\n";
  Functions & funcs = builder_.program.funcs;
  for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_main_define_function (i->second);
  }
  
  buffer_ << "\n";

  buffer_ << "  // Defining node functions for MADARA\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    Functions & funcs = n->second.funcs;
    for (Functions::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_main_define_function (i->second);
    }
  }

  buffer_ << "\n";
}


void
daig::madara::SyncBuilder::build_main_define_function (daig::Function & function)
{
  buffer_ << "  knowledge.define_function (\"";
  buffer_ << function.name;
  buffer_ << "\", ";
  buffer_ << function.name;
  buffer_ << ");\n";
}

void
daig::madara::SyncBuilder::clear_buffer ()
{
  buffer_.str ("");
}

void
daig::madara::SyncBuilder::print (std::ostream & os)
{
  os << buffer_.str ();
}
