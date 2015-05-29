/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

#if USE_MZSRM==1
extern "C" {
#include <stdio.h>
#include <jni.h>
}
#endif

#include "Sync_Builder.hpp"
#include <dmpl/gams/Function_Visitor.hpp>
#include <boost/algorithm/string.hpp>
#include <vector>
#include <map>
#include <dmplc/dmpl-parser.hpp>

dmpl::gams::Sync_Builder::Sync_Builder (dmpl::DmplBuilder & builder,
                                        const std::string &target, 
                                        SchedType & schedType,
                                        bool do_expect)
  : GAMS_Builder(builder,target, schedType, do_expect) {}

void
dmpl::gams::Sync_Builder::build ()
{
  build_header_includes ();
  build_target_thunk_includes ();
  // open dmpl namespace after including ALL libraries
  open_dmpl_namespace ();
  build_common_global_variables ();
  build_program_variables ();
  build_common_filters ();
  // build target thunk WITHOUT includes
  build_target_thunk ();
  build_parse_args ();
  build_functions_declarations ();
  build_gams_functions ();
  build_functions ();
  if(do_expect_)
  {
    build_expect_thread_declaration ();
    build_expect_thread_definition ();
  }
  build_algo_declaration ();
  build_algo_functions ();
  // close dmpl namespace
  close_dmpl_namespace ();
  buffer_ << "using namespace dmpl;\n";
#if USE_MZSRM==1
  if(schedType_ == MZSRM) compute_priorities ();
#endif
  build_main_function ();
}

void
dmpl::gams::Sync_Builder::build_header_includes ()
{
  buffer_ << "#include <string>\n";
  buffer_ << "#include <vector>\n";
  buffer_ << "#include <sstream>\n";
  buffer_ << "#include <fstream>\n";
  buffer_ << "#include <assert.h>\n";
  buffer_ << "#include <math.h>\n";
  buffer_ << "\n";
#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "extern \"C\" {\n";
    buffer_ << "#include <stdio.h>\n";
    buffer_ << "#include <stdlib.h>\n";
    buffer_ << "#include <time.h>\n";
    buffer_ << "#include <sched.h>\n";
    buffer_ << "#include <zsrm.h>\n";
    buffer_ << "}\n";
    buffer_ << "\n";
  }
#endif
  buffer_ << "#include \"madara/knowledge_engine/Knowledge_Base.h\"\n";
  buffer_ << "#include \"madara/knowledge_engine/Knowledge_Record.h\"\n";
  buffer_ << "#include \"madara/knowledge_engine/Functions.h\"\n";
  buffer_ << "#include \"madara/knowledge_engine/containers/Integer_Vector.h\"\n";
  buffer_ << "#include \"madara/knowledge_engine/containers/Double_Vector.h\"\n";
  buffer_ << "#include \"madara/knowledge_engine/containers/Vector_N.h\"\n";
  buffer_ << "#include \"madara/transport/Packet_Scheduler.h\"\n";
  buffer_ << "#include \"madara/threads/Threader.h\"\n";
  buffer_ << "#include \"madara/filters/Generic_Filters.h\"\n";
  buffer_ << "\n";
  buffer_ << "#define _GAMS_VREP_ 1\n";
  buffer_ << "#include \"gams/controllers/Base_Controller.h\"\n";
  buffer_ << "#include \"gams/algorithms/Base_Algorithm.h\"\n";
  buffer_ << "#include \"gams/variables/Sensor.h\"\n";
  buffer_ << "#include \"gams/platforms/Base_Platform.h\"\n";
  buffer_ << "#include \"gams/platforms/vrep/VREP_Base.h\"\n";
  buffer_ << "#include \"gams/variables/Algorithm.h\"\n";
  buffer_ << "#include \"gams/variables/Self.h\"\n";
  buffer_ << "#include \"gams/utility/GPS_Position.h\"\n";
  buffer_ << "\n";
  buffer_ << "#include \"dmpl/Reference.hpp\"\n";
  buffer_ << "#include \"dmpl/ArrayReference.hpp\"\n";
  if(do_expect_) {
    buffer_ << "extern \"C\" {\n";
    buffer_ << "#include <sys/time.h>\n";
    buffer_ << "}\n";
    buffer_ << "\n";
  }
}

void
dmpl::gams::Sync_Builder::build_target_thunk_includes ()
{
  const std::string include_lines = remove_include_lines_from_target_thunk ();
  buffer_ << include_lines << '\n';
}

void
dmpl::gams::Sync_Builder::build_common_global_variables ()
{
  buffer_ << "// typedefs\n";
  buffer_ << "typedef   Madara::Knowledge_Record::Integer   Integer;\n\n";
  buffer_ << "// namespace shortcuts\n";
  buffer_ << "namespace engine = Madara::Knowledge_Engine;\n";
  buffer_ << "namespace threads = Madara::Threads;\n\n";
  buffer_ << "namespace containers = engine::Containers;\n\n";
  buffer_ << "namespace controllers = gams::controllers;\n\n";
  buffer_ << "namespace platforms = gams::platforms;\n\n";
  buffer_ << "namespace variables = gams::variables;\n\n";
  buffer_ << "using containers::Reference;\n\n";
  buffer_ << "using containers::ArrayReference;\n\n";
  buffer_ << "using Madara::knowledge_cast;\n\n";
  buffer_ << "\n";
  buffer_ << "engine::Knowledge_Base knowledge;\n";
  buffer_ << "\n";

  buffer_ << "// Needed as a workaround for non-const-correctness in Madara; use carefully\n";
  buffer_ << "inline engine::Function_Arguments &__strip_const(const engine::Function_Arguments &c)\n";
  buffer_ << "{\n";
  buffer_ << "  return const_cast<engine::Function_Arguments &>(c);\n";
  buffer_ << "}\n";
  buffer_ << "\n";
  buffer_ << "inline engine::Function_Arguments &__chain_set(engine::Function_Arguments &c, int i, Madara::Knowledge_Record v)\n";
  buffer_ << "{\n";
  buffer_ << "  c[i] = v;\n";
  buffer_ << "  return c;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "// default transport variables\n";
  buffer_ << "std::string host (\"\");\n";
  buffer_ << "std::vector<std::string> platform_params;\n";
  buffer_ << "std::string platform_name (\"debug\");\n";
  buffer_ << "typedef void (*PlatformInitFn)(const std::vector<std::string> &, engine::Knowledge_Base &);\n";
  buffer_ << "typedef std::map<std::string, PlatformInitFn> PlatformInitFns;\n";
  buffer_ << "PlatformInitFns platform_init_fns;\n";
  buffer_ << "const std::string default_multicast (\"239.255.0.1:4150\");\n";
  buffer_ << "Madara::Transport::QoS_Transport_Settings settings;\n";
  buffer_ << "int write_fd (-1);\n";
  buffer_ << "ofstream expect_file;\n";
  buffer_ << "\n";

  buffer_ << "// Containers for commonly used variables\n";
  buffer_ << "// Global variables\n";
  //buffer_ << "containers::Integer_Array barrier;\n";
  buffer_ << "Reference<unsigned int> id(knowledge, \".id\");\n";
  buffer_ << "Reference<unsigned int>  num_processes(knowledge, \".num_processes\");\n";
  Node &node = builder_.program.nodes.begin()->second;
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
  {
    if (!f.second->isThread())
      continue;
    Attribute *attrBarSync = f.second->getAttribute("BarrierSync", 0);
    if(attrBarSync)
    {
      buffer_ << "ArrayReference<unsigned int, ";
      buffer_ << builder_.program.processes.size ();
      buffer_ << "> mbarrier_" << f.second->getName();
      buffer_ << "(knowledge, \"mbarrier_" << f.second->getName() << "\");\n";
    }
  }

  buffer_ << "double max_barrier_time (-1);\n";
  buffer_ << "engine::Knowledge_Update_Settings private_update (true);\n";
  buffer_ << "\n";
  buffer_ << "// number of participating processes\n";
  buffer_ << "unsigned int processes (";
  buffer_ << builder_.program.processes.size ();
  buffer_ << ");\n\n";
}

void
dmpl::gams::Sync_Builder::build_target_thunk (void)
{
  buffer_ << "// target (" << target_ << ") specific thunk\n";

  // we use target_ as a key to all related thunks
  Program::TargetType::const_iterator it =
    builder_.program.targets.find (target_);
  
  // if there was any such target, print it
  if (it != builder_.program.targets.end ())
  {
    buffer_ << it->second << "\n\n";
  }
}

void
dmpl::gams::Sync_Builder::build_common_filters (void)
{
}

void
dmpl::gams::Sync_Builder::build_common_filters_helper (
    const std::string filter_name,
    std::stringstream & filter_content)
{
  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << filter_name << " (Madara::Knowledge_Map & records,\n";
  buffer_ << "  const Madara::Transport::Transport_Context & context,\n";
  buffer_ << "  Madara::Knowledge_Engine::Variables & vars)\n";
  buffer_ << "{\n";
  buffer_ << "  Madara::Knowledge_Record result;\n";
  buffer_ << filter_content.str ();
  buffer_ << "  return result;\n";
  buffer_ << "}\n\n";
}

std::string
dmpl::gams::Sync_Builder::remove_include_lines_from_target_thunk (void)
{
  Program::TargetType::const_iterator it =
    builder_.program.targets.find (target_);

  if (it != builder_.program.targets.end ())
  {
    std::pair<std::string, std::string> blocks = split_include_and_non_include_blocks (it->second);
    builder_.program.targets[target_] = blocks.second;

    return blocks.first;
  }

  return "";
}

std::pair<std::string, std::string>
dmpl::gams::Sync_Builder::split_include_and_non_include_blocks (const std::string target_str)
{
  std::vector<std::string> all_lines;
  std::vector<std::string> include_lines;
  std::vector<std::string> non_include_lines;

  boost::split (all_lines, target_str, boost::is_any_of ("\n"));
  for (std::vector<std::string>::iterator it = all_lines.begin (); it != all_lines.end (); ++it)
  {
    std::string line = *it;
    if (line.find ("#include") == 0)
    {
      include_lines.push_back (line);
    }
    else
    {
      non_include_lines.push_back (line);
    }
  }

  // all lines starting with #include
  std::string include_str ("");
  for (std::vector<std::string>::iterator it = include_lines.begin (); it != include_lines.end (); ++it)
  {
    include_str += *it + "\n";
  }

  // all lines not starting with #include
  std::string non_include_str ("");
  for (std::vector<std::string>::iterator it = non_include_lines.begin (); it != non_include_lines.end (); ++it)
  {
    non_include_str += *it + "\n";
  }

  std::pair<std::string, std::string> blocks (include_str, non_include_str);
  return blocks;
}

void
dmpl::gams::Sync_Builder::build_program_variables ()
{
  buffer_ << "// Defining program-specific constants\n";
  
  Program::ConstDef & consts = builder_.program.constDef;
  for (Program::ConstDef::iterator i = consts.begin (); i != consts.end (); ++i)
  {
    buffer_ << "#define ";
    buffer_ << i->first;
    buffer_ << " ";
    buffer_ << i->second;
    buffer_ << "\n";
  }

  buffer_ << "\n";
  
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    buffer_ << "// Defining program-specific global variables\n";
    Vars & vars = n->second.globVars;
    for (Vars::iterator i = vars.begin (); i != vars.end (); ++i)
    {
      Var & var = i->second;
      var->type = var->type->incrDim(-1);
      build_program_variable (var);
    }
    
    buffer_ << "\n// Defining program-specific local variables\n";
    Vars & locals = n->second.locVars;
    for (Vars::iterator i = locals.begin (); i != locals.end (); ++i)
    {
      Var & var = i->second;
      build_program_variable (var);
    }
  }

  buffer_ << "\n";
}

namespace
{
  std::string get_type_name(const dmpl::Var &var)
  {
    if(var->type->type == TCHAR)
      return "short";
    else
      return var->type->toString();
  }
}

void
dmpl::gams::Sync_Builder::build_program_variable_init (
  const Var & var)
{
  if (var->type->dims.size () <= 1)
  {
    buffer_ << get_type_name(var) << " var_init_";
    buffer_ << var->name;
    if (var->type->type == TDOUBLE_TYPE)
      buffer_ << " (0.0);\n";
    else
      buffer_ << " (0);\n";
  }
}

void
dmpl::gams::Sync_Builder::build_program_variable (const Var & var)
{
#if 0
  // is this an array type?
  if (var->type->dims.size () == 1)
  {
    if (var->type->type == TINT)
    {
      buffer_ << "containers::Integer_Array ";
    }
    else if (var->type->type == TDOUBLE_TYPE)
    {
      buffer_ << "containers::Double_Array ";
    }
    else
    {
      // Default to integer array
      buffer_ << "containers::Integer_Array ";
    }
  }
  // multi-dimensional array type?
  else if (var->type->dims.size () > 1)
  {
    buffer_ << "containers::Array_N ";
  }
  // non-array type
#endif

  // is this an array type?
  if (var->type->dims.size () >= 1)
  {
    buffer_ << "ArrayReference<" << get_type_name(var);
    BOOST_FOREACH(int dim, var->type->dims)
    {
      buffer_ << ", ";
      if(dim > 0)
        buffer_ << dim;
      else
        buffer_ << builder_.program.processes.size ();
    }
    buffer_ << "> ";
  }
  else
  {
    buffer_ << "Reference<" << get_type_name(var) << "> ";
  }
  buffer_ << var->name;
  buffer_ << "(knowledge, \"";
  if(var->scope == Variable::LOCAL)
    buffer_ << ".";
  buffer_ << var->name << "\")";
  buffer_ << ";\n";

  build_program_variable_init (var);
  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_program_variables_bindings ()
{ 
  buffer_ << "  // Binding common variables\n";
  //buffer_ << "  barrier.set_name (\"mbarrier\", *knowledge, ";
  //buffer_ << builder_.program.processes.size ();
  //buffer_ << ");\n";

  //buffer_ << "  id.set_name (\".id\", knowledge);\n";
  //buffer_ << "  num_processes.set_name (\".processes\", knowledge);\n";
  buffer_ << "\n";

  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    buffer_ << "  // Binding program-specific global variables\n";
    Vars & vars = n->second.globVars;
    for (Vars::iterator i = vars.begin (); i != vars.end (); ++i)
    {
      Var & var = i->second;
      build_program_variable_binding (var);
    }
    
    buffer_ << "\n  // Binding program-specific local variables\n";
    Vars & locals = n->second.locVars;
    for (Vars::iterator i = locals.begin (); i != locals.end (); ++i)
    {
      Var & var = i->second;
      build_program_variable_binding (var);
    }
  }

  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_program_variable_binding (
  const Var & var)
{
#if 0
  // if scalar, already bound
  if (var->type->dims.size () > 0)
  {
    buffer_ << "  ";
    buffer_ << var->name;
    buffer_ << ".set_name (\"";

    // local variables will have a period in front of them
    if (var->scope == Variable::LOCAL)
      buffer_ << ".";

    buffer_ << var->name;
    buffer_ << "\", knowledge";

    // is this an array type?
    if (var->type->dims.size () == 1)
    {
      buffer_ << ", ";
      buffer_ << builder_.program.processes.size ();
    }

    buffer_ << ");\n";
  }
#endif

  build_program_variable_assignment (var);

  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_program_variable_assignment (
  const Var & var)
{
  // is this a GLOBAL scalar (i.e., 1-dimensional array)?
  if (var->scope == Variable::GLOBAL && var->type->dims.size () == 1)
  {
    buffer_ << "  " << var->name;
    buffer_ << "[settings.id] = var_init_";
    buffer_ << var->name;
    buffer_ << ";\n";
  }
  else if (var->type->dims.size () == 0)
  {
    buffer_ << "  " << var->name;
    buffer_ << " = ";
    buffer_ << "var_init_";
    buffer_ << var->name;
    buffer_ << ";\n";
  }
}

void
dmpl::gams::Sync_Builder::build_parse_args ()
{
  std::stringstream variable_help;

  buffer_ << "template < class ContainerT >\n";
  buffer_ << "void tokenize(const std::string& str, ContainerT& tokens,\n";
  buffer_ << "              const std::string& delimiters = \" \", bool trimEmpty = false)\n";
  buffer_ << "{\n";
  buffer_ << "   std::string::size_type pos, lastPos = 0;\n";
  buffer_ << "\n";
  buffer_ << "   typedef typename ContainerT::value_type value_type;\n";
  buffer_ << "   typedef typename ContainerT::size_type size_type;\n";
  buffer_ << "\n";
  buffer_ << "   while(true)\n";
  buffer_ << "   {\n";
  buffer_ << "      pos = str.find_first_of(delimiters, lastPos);\n";
  buffer_ << "      if(pos == std::string::npos)\n";
  buffer_ << "      {\n";
  buffer_ << "         pos = str.length();\n";
  buffer_ << "\n";
  buffer_ << "         if(pos != lastPos || !trimEmpty)\n";
  buffer_ << "            tokens.push_back(value_type(str.data()+lastPos,\n";
  buffer_ << "                  (size_type)pos-lastPos ));\n";
  buffer_ << "\n";
  buffer_ << "         break;\n";
  buffer_ << "      }\n";
  buffer_ << "      else\n";
  buffer_ << "      {\n";
  buffer_ << "         if(pos != lastPos || !trimEmpty)\n";
  buffer_ << "            tokens.push_back(value_type(str.data()+lastPos,\n";
  buffer_ << "                  (size_type)pos-lastPos ));\n";
  buffer_ << "      }\n";
  buffer_ << "\n";
  buffer_ << "      lastPos = pos + 1;\n";
  buffer_ << "   }\n";
  buffer_ << "}\n";
  buffer_ << "\n";
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
  buffer_ << "    else if (arg1 == \"-p\" || arg1 == \"--platform\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        tokenize(std::string(argv[i + 1]), platform_params, \":\");\n";
  buffer_ << "        platform_name = (platform_params[0]);\n";
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
  buffer_ << "    else if (arg1 == \"-mb\" || arg1 == \"--max-barrier-time\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> max_barrier_time;\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
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
  buffer_ << "    else if (arg1 == \"--drop-rate\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        double drop_rate;\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> drop_rate;\n";
  buffer_ << "        std::cerr << \"drop_rate: \" << drop_rate << std::endl;\n";
  //TODO: fix handling of packet drops in MADARA
  //buffer_ << "        Madara::Transport::Packet_Scheduler::drop_rate_override = drop_rate;\n";
  buffer_ << "        settings.update_drop_rate (drop_rate,\n";
  buffer_ << "          Madara::Transport::PACKET_DROP_PROBABLISTIC);\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-e\" || arg1 == \"--expect-log\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        expect_file.open(argv[i + 1], ios::out | ios::trunc);\n";
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
  buffer_ << "    else if (arg1 == \"--write-fd\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> write_fd;\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";

  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    buffer_ << "\n    // Providing init for global variables\n";
    Vars & vars = n->second.globVars;
    for (Vars::iterator i = vars.begin (); i != vars.end (); ++i)
    {
      Var& var = i->second;
      variable_help << build_parse_args (var);
    }
    
    buffer_ << "\n    // Providing init for local variables\n";
    Vars & locals = n->second.locVars;
    for (Vars::iterator i = locals.begin (); i != locals.end (); ++i)
    {
      Var& var = i->second;
      variable_help << build_parse_args (var);
    }
  }

  if (false)
  {
    buffer_ << "\n    // Providing init for VREP variables";
    buffer_ << "\n    else if (arg1 == \"-vq\" || arg1 == \"--vrep-quad\")";
    buffer_ << "\n    {";
    buffer_ << "\n       vrep_model = 1;";
    buffer_ << "\n    }";
    buffer_ << "\n    else if (arg1 == \"-va\" || arg1 == \"--vrep-ant\")";
    buffer_ << "\n    {";
    buffer_ << "\n       vrep_model = 2;";
    buffer_ << "\n    }";
    buffer_ << "\n    else if (arg1 == \"-vh\" || arg1 == \"--vrep-host\")";
    buffer_ << "\n    {";
    buffer_ << "\n      if (i + 1 < argc)";
    buffer_ << "\n      {";
    buffer_ << "\n        vrep_host = argv[i + 1];";
    buffer_ << "\n      }";
    buffer_ << "\n";
    buffer_ << "\n      ++i;";
    buffer_ << "\n    }";
    buffer_ << "\n    else if (arg1 == \"-vp\" || arg1 == \"--vrep-port\")";
    buffer_ << "\n    {";
    buffer_ << "\n      if (i + 1 < argc)";
    buffer_ << "\n      {";
    buffer_ << "\n        std::stringstream buffer (argv[i + 1]);";
    buffer_ << "\n        buffer >> vrep_port;";
    buffer_ << "\n      }";
    buffer_ << "\n";
    buffer_ << "\n      ++i;";
    buffer_ << "\n    }\n";
  }

  buffer_ << "    else\n";
  buffer_ << "    {\n";
  buffer_ << "      MADARA_DEBUG (MADARA_LOG_EMERGENCY, (LM_DEBUG, \n";
  buffer_ << "        \"\\nProgram summary for %s:\\n\\n\"\\\n";
  buffer_ << "        \" [-p|--platform type]     platform for loop (vrep, dronerk)\\n\"\\\n";
  buffer_ << "        \" [-b|--broadcast ip:port] the broadcast ip to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-d|--domain domain]     the knowledge domain to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-e|--expect-log file]   file to log variables related to 'expect' clauses\\n\"\\\n";
  buffer_ << "        \" [-f|--logfile file]      log to a file\\n\"\\\n";
  buffer_ << "        \" [-i|--id id]             the id of this agent (should be non-negative)\\n\"\\\n";
  buffer_ << "        \" [-l|--level level]       the logger level (0+, higher is higher detail)\\n\"\\\n";
  buffer_ << "        \" [-m|--multicast ip:port] the multicast ip to send and listen to\\n\"\\\n";
  buffer_ << "        \" [-mb|--max-barrier-time time] time in seconds to barrier for other processes\\n\"\\\n";
  buffer_ << "        \" [-o|--host hostname]     the hostname of this process (def:localhost)\\n\"\\\n";
  buffer_ << "        \" [-r|--reduced]           use the reduced message header\\n\"\\\n";
  buffer_ << "        \" [-u|--udp ip:port]       the udp ips to send to (first is self to bind to)\\n\"\\\n";

  buffer_ << variable_help.str ();

  if (false)
  {
    buffer_ << "        \" [-vq|--vrep-quad] use Quadricopter model in VREP (default)\\n\"\\\n";
    buffer_ << "        \" [-va|--vrep-ant] use Ant model in VREP\\n\"\\\n";
    buffer_ << "        \" [-vh|--vrep-host] sets the IP address of VREP\\n\"\\\n";
    buffer_ << "        \" [-vp|--vrep-port] sets the IP port of VREP\\n\"\\\n";
  }

  buffer_ << "        , argv[0]));\n";
  buffer_ << "      exit (0);\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n";
  buffer_ << "}\n\n";
}

std::string
dmpl::gams::Sync_Builder::build_parse_args (const Var& var)
{
  std::stringstream return_value;
  
  // we do not allow setting multi-dimensional vars from command line
  if (var->type->dims.size () <= 1)
  {
    buffer_ << "    else if (arg1 == \"--var_";
    buffer_ << var->name;
    buffer_ << "\")\n";
    buffer_ << "    {\n";
    buffer_ << "      if (i + 1 < argc)\n";
    buffer_ << "      {\n";
    buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
    buffer_ << "        buffer >> var_init_";
    buffer_ << var->name;
    buffer_ << ";\n";
    buffer_ << "      }\n";
    buffer_ << "      \n";
    buffer_ << "      ++i;\n";
    buffer_ << "    }\n";

    // build the help string
    return_value << "        \" [--var_";
    return_value << var->name;
    return_value << "] sets the initial value of a generated variable\\n\"\\\n";
  }

  return return_value.str ();
}

void
dmpl::gams::Sync_Builder::build_functions_declarations ()
{
  buffer_ << "// Forward declaring global functions\n\n";
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function_declaration (Node (), i->second);
  }
  
  buffer_ << "\n// Forward declaring node functions\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    Funcs & funcs = n->second.funcs;
    for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_function_declaration (n->second, i->second);
    }
  }

  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_refresh_modify_globals ()
{
  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << "REMODIFY_BARRIERS";
  buffer_ << " (engine::Function_Arguments &,\n";
  buffer_ << "  engine::Variables & vars)\n";
  buffer_ << "{\n";
  Node &node = builder_.program.nodes.begin()->second;
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
  {
    if (!f.second->isThread())
      continue;
    Attribute *attrBarSync = f.second->getAttribute("BarrierSync", 0);
    if(attrBarSync)
    {
      buffer_ << "  mbarrier_" << f.second->getName() << "[id].mark_modified();\n\n";
    }
  }
  buffer_ << "  return Integer (0);\n";
  buffer_ << "}\n\n";

  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << "REMODIFY_GLOBALS";
  buffer_ << " (engine::Function_Arguments & args,\n";
  buffer_ << "  engine::Variables & vars)\n";
  buffer_ << "{\n";
  
  buffer_ << "  // Remodifying common global variables\n";
  buffer_ << "  REMODIFY_BARRIERS(args, vars);\n";
  //buffer_ << "  barrier.set (*id, barrier[*id]);\n\n";

  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    buffer_ << "  // Remodifying program-specific global variables\n";
    Vars & vars = n->second.globVars;
    for (Vars::iterator i = vars.begin (); i != vars.end (); ++i)
    {
      Var & var = i->second;
      build_refresh_modify_global (var);
    }
  }
  
  buffer_ << "  return Integer (0);\n";
  buffer_ << "}\n\n";
}

void
dmpl::gams::Sync_Builder::build_refresh_modify_global (const Var & var)
{
#if 0
  // is this an array type?
  if (var->type->dims.size () == 1)
  {
    buffer_ << "  " << var->name;
    buffer_ << "[id].mark_modified();\n";
  }
  // is this an n-dimensional array type?
  else if (var->type->dims.size () > 1)
  {
    //by convention, a node owns all array elements where the last
    //index equals its id. we will create a set of nested for loops to
    //remodify all such elements
    std::vector<int> dims;
    BOOST_FOREACH(int i,var->type->dims) dims.push_back(i);

    //open for loops
    std::string index_str = "";
    for(int i = 0;i < dims.size () - 1;++i) {
      std::string spacer(2*i+2,' ');
      buffer_ << spacer << "for(Integer i" << i << " = 0;i" << i <<" < " 
              << dims[i] << "; ++i" << i << ") {\n";
      index_str += "i" + boost::lexical_cast<std::string>(i) + ", ";
    }

    std::string spacer(2*dims.size(),' ');
    buffer_ << spacer << "containers::Array_N::Index index (" << dims.size() << ");\n";
    for(int i = 0;i < dims.size () - 1;++i)
      buffer_ << spacer << "index[" << i << "] = i" << i << ";\n";
    buffer_ << spacer << "index[" << dims.size() - 1 << "] = id;\n";
    buffer_ << spacer << var->name << ".set (index, " << var->name << "(" << index_str << "id).to_integer ());\n";

    //close for loops
    for(int i = dims.size () - 2;i >= 0;--i) {
      std::string spacer(2*i+2,' ');
      buffer_ << spacer << "}\n";
    }

    // we currently have no way of specifying owned locations in an array
    buffer_ << "\n";
#endif
  if (var->scope == Variable::GLOBAL)
  {
    buffer_ << "  " << var->name << "[id].mark_modified();\n";
  }
  else
  {
    buffer_ << "  " << var->name << ".mark_modified()";
  }
}

void
dmpl::gams::Sync_Builder::build_functions (void)
{
  build_refresh_modify_globals ();

  buffer_ << "// Defining global functions\n\n";
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function (Node (), i->second);
  }

  buffer_ << "// Defining node functions\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    Funcs & funcs = n->second.funcs;
    for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_function (n->second, i->second);
    }
  }

  buffer_ << "\n";
}

bool skip_func(dmpl::Func & function)
{
  return (function->attrs.count("InitSim") == 0 && (function->isExtern ||
      function->attrs.count("INIT") > 0 || function->attrs.count("SAFETY") > 0 ||
      !function->usage_summary.anyNonExpect().any()));
}

void
dmpl::gams::Sync_Builder::build_function_declaration (
  const dmpl::Node & node, dmpl::Func & function)
{
  if (skip_func(function))
    return;

  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << node.name << "_" << function->name;
  buffer_ << " (engine::Function_Arguments & args, engine::Variables & vars);\n";
}

void
dmpl::gams::Sync_Builder::build_function (
  const dmpl::Node & node, dmpl::Func & function)
{
  if (skip_func(function))
    return;

  BOOST_FOREACH (Attributes::value_type & attr, function->attrs)
  {
    buffer_ << "// @" << attr.second.name;
    BOOST_FOREACH (Expr p, attr.second.paramList)
    {
      buffer_ << " " << p->toString();
    }
    buffer_ << "\n";
  }

  buffer_ << "Madara::Knowledge_Record\n";
  buffer_ << node.name << "_" << function->name;
  buffer_ << " (engine::Function_Arguments & args, engine::Variables & vars)\n";
  buffer_ << "{\n";
  buffer_ << "  // Declare local variables\n";
  
  //buffer_ << "  Integer result (0);\n";
  int i = 0;
  BOOST_FOREACH (Vars::value_type & variable, function->paramSet)
  {
    buffer_ << "  " << get_type_name(variable.second) << " ";
    buffer_ << variable.second->name;
    buffer_ << " = args[" << i << "].to_double();\n";
    buffer_ << ";\n";
    ++i;
  }
  BOOST_FOREACH (Vars::value_type & variable, function->temps)
  {
    buffer_ << "  " << get_type_name(variable.second);
    buffer_ << " " << variable.second->name;
    buffer_ << ";\n";
  }
  
  buffer_ << "\n";

  dmpl::madara::Function_Visitor visitor (function, node, builder_, buffer_, false);

  //transform the body of safety
  BOOST_FOREACH (const Stmt & statement, function->body)
  {
    visitor.visit (statement);
  }

  buffer_ << "\n  // Insert return statement, in case user program did not\n";
  buffer_ << "  return Integer(0);\n";
  buffer_ << "}\n\n";
}

void
dmpl::gams::Sync_Builder::build_gams_function (std::string &dmpl_name, std::string &gams_name, int nargs)
{
}

void
dmpl::gams::Sync_Builder::build_gams_functions ()
{
  buffer_ << "gams::platforms::Base *platform = NULL;\n";

  buffer_ << "int grid_x = 0, grid_y = 0;\n";
  buffer_ << "double grid_leftX = NAN, grid_rightX = NAN, grid_topY = NAN, grid_bottomY = NAN, grid_cellX = NAN, grid_cellY = NAN;\n";
  buffer_ << "void GRID_INIT(int x, int y, double leftX, double rightX, double topY, double bottomY)\n";
  buffer_ << "{\n";
  buffer_ << "  grid_x = x;\n";
  buffer_ << "  grid_y = y;\n";
  buffer_ << "  grid_leftX = leftX;\n";
  buffer_ << "  grid_rightX = rightX;\n";
  buffer_ << "  grid_topY = topY;\n";
  buffer_ << "  grid_bottomY = bottomY;\n";
  buffer_ << "  grid_cellX = (grid_rightX - grid_leftX) / (grid_x-1);\n";
  buffer_ << "  grid_cellY = (grid_bottomY - grid_topY) / (grid_y-1);\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void GRID_PLACE(int x, int y, double alt = 0.0)\n";
  buffer_ << "{\n";
  buffer_ << "  knowledge.set(\".initial_x\", grid_leftX + x * grid_cellX);\n";
  buffer_ << "  knowledge.set(\".initial_y\", grid_topY + y * grid_cellY);\n";
  buffer_ << "  knowledge.set(\".initial_alt\", alt);\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int GRID_MOVE(int x, int y, double alt = NAN, double epsilon = 0.1)\n";
  buffer_ << "{\n";
  buffer_ << "  int ret = platform->move(gams::utility::Position(grid_leftX + x * grid_cellX, grid_topY + y * grid_cellY, alt), epsilon);\n";
  //buffer_ << "  std::cerr << grid_leftX + x * grid_cellX << \"/\" << grid_topY + y * grid_cellY << std::endl;\n";
  //buffer_ << "  std::cerr << \"PLAT_MOVE \" << platform->get_name() << \" \" << ret << std::endl;\n";
  buffer_ << "  return ret != 2;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "double GET_X()\n";
  buffer_ << "{\n";
  buffer_ << "  gams::platforms::VREP_Base *vrep_platform = dynamic_cast<gams::platforms::VREP_Base *>(platform);\n";
  buffer_ << "  if(vrep_platform == NULL) return NAN;\n";
  buffer_ << "  gams::utility::Position pos = vrep_platform->get_vrep_position();\n";
  buffer_ << "  double x = pos.x;\n";
  buffer_ << "  return x;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "double GET_Y()\n";
  buffer_ << "{\n";
  buffer_ << "  gams::platforms::VREP_Base *vrep_platform = dynamic_cast<gams::platforms::VREP_Base *>(platform);\n";
  buffer_ << "  if(vrep_platform == NULL) return NAN;\n";
  buffer_ << "  gams::utility::Position pos = vrep_platform->get_vrep_position();\n";
  buffer_ << "  double y = pos.y;\n";
  buffer_ << "  return y;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "double GET_LAT()\n";
  buffer_ << "{\n";
  buffer_ << "  if(platform == NULL) return NAN;\n";
  buffer_ << "  gams::utility::Position *pos = platform->get_position();\n";
  buffer_ << "  double lat = pos->x;\n";
  buffer_ << "  delete pos;\n";
  buffer_ << "  return lat;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "double GET_LNG()\n";
  buffer_ << "{\n";
  buffer_ << "  if(platform == NULL) return NAN;\n";
  buffer_ << "  gams::utility::Position *pos = platform->get_position();\n";
  buffer_ << "  double lng = pos->y;\n";
  buffer_ << "  delete pos;\n";
  buffer_ << "  return lng;\n";
  buffer_ << "}\n";
  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_expect_thread_declaration (void)
{
  buffer_ << "class ExpectThread : public threads::Base_Thread\n";
  buffer_ << "{\n";
  buffer_ << "public:\n";
  buffer_ << "  Madara::Knowledge_Engine::Knowledge_Base *_knowledge;\n";
  buffer_ << "  ExpectThread (\n";
  buffer_ << "    ostream &o = std::cout\n";
  buffer_ << "  ) : out(o) {}\n";
  buffer_ << "  virtual void init (engine::Knowledge_Base & context);\n";
  buffer_ << "  virtual void run (void);\n";
  buffer_ << "  virtual void cleanup (void) {}\n";
  buffer_ << "protected:\n";
  buffer_ << "  ostream &out;\n";
  buffer_ << "};\n";
}

void
dmpl::gams::Sync_Builder::build_expect_thread_definition (void)
{
  buffer_ << "void ExpectThread::init (engine::Knowledge_Base & context)\n";
  buffer_ << "{\n";
  buffer_ << "  _knowledge = &context;\n";
  buffer_ << "  out << \"Seconds,Micros,Node,At,Variable,Value\" << std::endl;\n";
  buffer_ << "}\n";
  buffer_ << "\n";
  buffer_ << "void ExpectThread::run (void)\n";
  buffer_ << "{\n";
  buffer_ << "  timeval tv;\n";
  buffer_ << "  if(gettimeofday(&tv, NULL) != 0) {\n";
  buffer_ << "    tv.tv_sec = 0;\n";
  buffer_ << "    tv.tv_usec = 0;\n";
  buffer_ << "  }\n";

  Node &node = builder_.program.nodes.begin()->second;

  BOOST_FOREACH(Vars::value_type &it, node.locVars)
  {
    Var var = it.second;
    if(var->type->dims.size() != 0)
      continue;
    if(var->usage_summary.anyExpect().any())
    {
      buffer_ << "  out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << id << \",\";\n";
      buffer_ << "  out << \"." << var->getName() << ",\" << ::dmpl::" << var->getName() << ";\n";
      buffer_ << "  out << std::endl;\n\n";
    }
  }

  BOOST_FOREACH(Vars::value_type &it, node.globVars)
  {
    Var var = it.second;
    if(var->type->dims.size() != 1)
      continue;
    if(var->usage_summary.anyExpect().any())
    {
      for(int i = 0; i < builder_.program.processes.size(); i++)
      {
        buffer_ << "  out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << " << i << " << \",\";\n";
        buffer_ << "  out << \"" << var->getName() << ",\" << ::dmpl::" << var->getName() << "[" << i << "];\n";
        buffer_ << "  out << std::endl;\n\n";
      }
    }
  }

  BOOST_FOREACH(Funcs::value_type &it, builder_.program.funcs)
  {
    Func func = it.second;
    if(!func->isExtern || func->params.size() > 0 || func->retType->type == TVOID)
      continue;
    std::cerr << "External Function: " << func->getName() << std::endl;
    std::cerr << "  usage_summary: " << func->usage_summary << std::endl;
    std::cerr << "  expect: " << func->usage_summary.anyExpect() << std::endl;
    if(func->usage_summary.anyExpect().any())
    {
      buffer_ << "  out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << id << \",\";\n";
      buffer_ << "  out << \"" << func->getName() << ",\" << ::dmpl::" << func->getName() << "();\n";
      buffer_ << "  out << std::endl;\n\n";
    }
  }
  buffer_ << "}\n";
  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_algo_declaration ()
{
  buffer_ << "class Algo : public gams::algorithms::Base, protected threads::Base_Thread\n";
  buffer_ << "{\n";
  buffer_ << "public:\n";
  buffer_ << "  Algo (\n";
  buffer_ << "    unsigned period,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    unsigned priority,\n";
    buffer_ << "    unsigned criticality,\n";
    buffer_ << "    unsigned zsinst,\n";
  }
#endif

  buffer_ << "    const std::string &exec_func,\n";
  buffer_ << "    Madara::Knowledge_Engine::Knowledge_Base * knowledge = 0,\n";
  buffer_ << "    const std::string &platform_name = \"\",\n";
  buffer_ << "    variables::Sensors * sensors = 0,\n";
  buffer_ << "    variables::Self * self = 0);\n";
  buffer_ << "  ~Algo (void);\n";

  buffer_ << "  virtual int analyze (void);\n";
  buffer_ << "  virtual int plan (void);\n";
  buffer_ << "  virtual int execute (void);\n";

  buffer_ << "  virtual void init (engine::Knowledge_Base & context);\n";
  buffer_ << "  virtual void init_platform ();\n";
  buffer_ << "  virtual void run (void);\n";
  buffer_ << "  virtual void cleanup (void);\n";

  buffer_ << "  virtual void start (threads::Threader &threader);\n";

  buffer_ << "protected:\n";
  buffer_ << "  unsigned _period; //-- period in us\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  unsigned _priority; //-- priority, starting with 1 and moving up\n";
    buffer_ << "  unsigned _criticality; //-- criticality, starting with 1 and moving up\n";
    buffer_ << "  unsigned _zsinst; //-- zero-slack instant in ms\n";
  }
#endif

  buffer_ << "  controllers::Base loop;\n";
  buffer_ << "  engine::Knowledge_Base *knowledge_;\n";
  buffer_ << "  std::string _exec_func, _platform_name;\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  int sched; //-- the ZSRM scheduler handle\n";
    buffer_ << "  int rid;   //-- the ZSRM reservation id\n";
  }
#endif

  buffer_ << "};\n";
  buffer_ << "\n";
  buffer_ << "class SyncAlgo : public Algo\n";
  buffer_ << "{\n";
  buffer_ << "public:\n";
  buffer_ << "  SyncAlgo (\n";
  buffer_ << "    unsigned period,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    unsigned priority,\n";
    buffer_ << "    unsigned criticality,\n";
    buffer_ << "    unsigned zsinst,\n";
  }
#endif

  buffer_ << "    const std::string &exec_func,\n";
  buffer_ << "    Madara::Knowledge_Engine::Knowledge_Base * knowledge = 0,\n";
  buffer_ << "    const std::string &platform_name = \"\",\n";
  buffer_ << "    variables::Sensors * sensors = 0,\n";
  buffer_ << "    variables::Self * self = 0);\n";
  buffer_ << "  ~SyncAlgo (void);\n";
  buffer_ << "  virtual int analyze (void);\n";
  buffer_ << "  virtual int plan (void);\n";
  buffer_ << "  virtual int execute (void);\n";

  buffer_ << "  virtual void init (engine::Knowledge_Base & context);\n";
  buffer_ << "  virtual void run (void);\n";
  buffer_ << "  virtual void cleanup (void);\n";
  buffer_ << "protected:\n";
  buffer_ << "  int phase;\n";
  buffer_ << "  std::string mbarrier;\n";
  buffer_ << "  Madara::Knowledge_Engine::Wait_Settings wait_settings;\n";
  buffer_ << "  engine::Compiled_Expression round_logic;\n";
  buffer_ << "  std::map <std::string, bool>  barrier_send_list;\n";
  buffer_ << "  std::stringstream barrier_string, barrier_data_string, barrier_sync;\n";
  buffer_ << "  engine::Compiled_Expression barrier_logic;\n";
  buffer_ << "  engine::Compiled_Expression barrier_data_logic;\n";
  buffer_ << "  engine::Compiled_Expression barrier_sync_logic;\n";
  buffer_ << "};\n";
  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::build_algo_functions ()
{
  buffer_ << "Algo::Algo (\n";
  buffer_ << "    unsigned period,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    unsigned priority,\n";
    buffer_ << "    unsigned criticality,\n";
    buffer_ << "    unsigned zsinst,\n";
  }
#endif

  buffer_ << "    const std::string &exec_func,\n";
  buffer_ << "    Madara::Knowledge_Engine::Knowledge_Base * knowledge,\n";
  buffer_ << "    const std::string &platform_name,\n";
  buffer_ << "    variables::Sensors * sensors,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    variables::Self * self) : sched(0), rid(0),\n";
    buffer_ << "      loop(*knowledge), _platform_name(platform_name),\n";
  }
  else
#endif
  {
    buffer_ << "    variables::Self * self) : loop(*knowledge), _platform_name(platform_name),\n";
  }

  buffer_ << "      Base (knowledge, 0, sensors, self), knowledge_(knowledge),\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "      _period(period),\n";
    buffer_ << "      _priority(priority), _criticality(criticality),\n";
    buffer_ << "      _zsinst(zsinst), _exec_func(exec_func)\n";
  }
  else
#endif
  {
    buffer_ << "            _period(period), _exec_func(exec_func)\n";
  }

  buffer_ << "{\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "Algo::~Algo (void)\n";
  buffer_ << "{\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int Algo::analyze (void)\n";
  buffer_ << "{\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int Algo::plan (void)\n";
  buffer_ << "{\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void Algo::init (engine::Knowledge_Base & context)\n";
  buffer_ << "{\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  loop.init_vars (settings.id, processes);\n";
    buffer_ << "  if(_platform_name != \"\") init_platform ();\n";
    buffer_ << "  loop.init_algorithm (this);\n";
    buffer_ << "\n";
    buffer_ << "  //-- set thread affinity\n";
    buffer_ << "  cpu_set_t cpuset;\n";
    buffer_ << "  CPU_ZERO(&cpuset);\n";
    buffer_ << "  CPU_SET(0, &cpuset);\n";
    buffer_ << "  pthread_t current_thread = pthread_self();\n";
    buffer_ << "  if(pthread_setaffinity_np(current_thread, sizeof(cpu_set_t), &cpuset))\n";
    buffer_ << "    assert(0 && \"ERROR: could not set thread CPU affinity!!\");\n";
    buffer_ << "\n";
    buffer_ << "  //-- connect to the scheduler\n";
    buffer_ << "  if ((sched = zs_open_sched()) == -1){\n";
    buffer_ << "    printf(\"error opening the scheduler\\n\");\n";
    buffer_ << "    assert(0 && \"ERROR: could not open ZSRM scheduler!!\");\n";
    buffer_ << "  }\n";
    buffer_ << "\n";
    buffer_ << "  //-- setup reserve\n";
    buffer_ << "  struct zs_reserve_params cpuattr1;\n";
    buffer_ << "  cpuattr1.period.tv_sec = _period / 1000000;\n";
    buffer_ << "  cpuattr1.period.tv_nsec= (_period % 1000000) * 1000;\n";
    buffer_ << "  cpuattr1.reserve_type = CRITICALITY_RESERVE;\n";
    buffer_ << "  cpuattr1.criticality = _criticality;\n";
    buffer_ << "  cpuattr1.priority = _priority;\n";
    buffer_ << "  cpuattr1.zs_instant.tv_sec=_zsinst / 1000000;\n";
    buffer_ << "  cpuattr1.zs_instant.tv_nsec=(_zsinst % 1000000) * 1000;\n";
    buffer_ << "  //-- remove the following two lines. experimental.\n";
    buffer_ << "  //cpuattr1.response_time_instant.tv_sec = 4;\n";
    buffer_ << "  //cpuattr1.response_time_instant.tv_nsec =0;\n";
    buffer_ << "  cpuattr1.enforcement_mask=0;\n";
    buffer_ << "  rid = zs_create_reserve(sched, &cpuattr1);\n";
    buffer_ << "  if(rid == -1)\n";
    buffer_ << "    assert(0 && \"error creating ZSRM reserve ...\");\n";
    buffer_ << "\n";
    buffer_ << "  //-- attach reservation\n";
    buffer_ << "  if(zs_attach_reserve(sched, rid, syscall(SYS_gettid)) == -1)\n";
    buffer_ << "    assert(0 && \"error attaching ZSRM reserve ...\");\n";
  }
  else
#endif
  {
    buffer_ << "  loop.init_vars (settings.id, processes);\n";
    buffer_ << "  if(_platform_name != \"\") init_platform ();\n";
    buffer_ << "  loop.init_algorithm (this);\n";
  }

  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void Algo::run (void)\n";
  buffer_ << "{\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  for(;;) {\n";
    buffer_ << "    //-- wait for next period\n";
    buffer_ << "    if (zs_wait_next_period(sched, rid) < 0){\n";
    buffer_ << "      printf(\"wait next period returned negative\\n\");\n";
    buffer_ << "      if (errno == EINTR){\n";
    buffer_ << "        printf(\"signal interruption!!\\n\");\n";
    buffer_ << "      }\n";
    buffer_ << "    }\n";
    buffer_ << "\n";
    buffer_ << "    //-- run job\n";
    buffer_ << "    loop.run_once();\n";
    buffer_ << "  }\n";
  }
  else
#endif
  {
    buffer_ << "  loop.run_once(); \n";
  }

  buffer_ << "}\n";
  buffer_ << "\n";
    
  buffer_ << "void Algo::init_platform ()\n";
  buffer_ << "{\n";
  buffer_ << "  loop.init_platform (_platform_name);\n";
  buffer_ << "  platform = loop.get_platform();\n";
  //buffer_ << "  std::cout << \"Platform init\" << std::endl;\n";
  buffer_ << "}\n";
  buffer_ << "\n";
    
  buffer_ << "void Algo::cleanup (void)\n";
  buffer_ << "{\n";
  buffer_ << "}\n";
  buffer_ << "\n";
    
  buffer_ << "void Algo::start (threads::Threader &threader)\n";
  buffer_ << "{\n";
  buffer_ << "  std::cout << \"Starting thread: \" << _exec_func << \" at period \" << _period << \" us\" << std::endl;\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  threader.run(_exec_func, this);\n";
  }
  else
#endif
  {
    buffer_ << "  double hertz = 1000000.0 / _period;\n";
    buffer_ << "  threader.run(hertz, _exec_func, this);\n";
  }

  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int Algo::execute (void)\n";
  buffer_ << "{\n";
  buffer_ << "  knowledge_->evaluate (_exec_func + \"()\");\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "SyncAlgo::SyncAlgo (\n";
  buffer_ << "    unsigned period,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    unsigned priority,\n";
    buffer_ << "    unsigned criticality,\n";
    buffer_ << "    unsigned zsinst,\n";
  }
#endif

  buffer_ << "    const std::string &exec_func,\n";
  buffer_ << "    Madara::Knowledge_Engine::Knowledge_Base * knowledge,\n";
  buffer_ << "    const std::string &platform_name,\n";
  buffer_ << "    variables::Sensors * sensors,\n";
  buffer_ << "    variables::Self * self) : phase(0), mbarrier(\"mbarrier_\" + exec_func),\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "      Algo (period, priority, criticality, zsinst,\n";
    buffer_ << "            exec_func, knowledge, platform_name, sensors, self)\n";
  }
  else
#endif
  {
    buffer_ << "      Algo (period, exec_func, knowledge, platform_name, sensors, self)\n";
  }

  buffer_ << "{\n";

  buffer_ << "  wait_settings.max_wait_time = 0;\n";
  buffer_ << "  wait_settings.poll_frequency = .1;\n\n";

  buffer_ << "  round_logic = knowledge_->compile (\n";

  buffer_ << "    knowledge_->expand_statement (_exec_func + \" (); ++\" + mbarrier + \".{.id}\"));\n";

  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "SyncAlgo::~SyncAlgo (void)\n";
  buffer_ << "{\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void SyncAlgo::init (engine::Knowledge_Base & context)\n";
  buffer_ << "{\n";
  //
  // build the barrier string  
  buffer_ << "  bool started = false;\n\n";

  buffer_ << "  barrier_send_list [knowledge_->expand_statement (";
  buffer_ << "\"\" + mbarrier + \".{.id}\")] = true;\n\n";
  
  buffer_ << "  barrier_string << \"REMODIFY_BARRIERS () ;> \";\n";
  buffer_ << "  barrier_data_string << \"REMODIFY_GLOBALS () ;> \";\n";
  buffer_ << "  barrier_sync << \"\" + mbarrier + \".\";\n";
  buffer_ << "  barrier_sync << settings.id;\n";
  buffer_ << "  barrier_sync << \" = (\" + mbarrier + \".\";\n";
  buffer_ << "  barrier_sync << settings.id;\n\n";
  buffer_ << "  // create barrier check for all lower ids\n";
  buffer_ << "  for (unsigned int i = 0; i < settings.id; ++i)\n";
  buffer_ << "  {\n";
  buffer_ << "    if (started)\n";
  buffer_ << "    {\n";
  buffer_ << "      barrier_string << \" && \";\n";
  buffer_ << "      barrier_data_string << \" && \";\n";
  buffer_ << "    }\n\n";

  buffer_ << "    barrier_string << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_string << i;\n";
  buffer_ << "    barrier_string << \" >= \" + mbarrier + \".\";\n";
  buffer_ << "    barrier_string << settings.id;\n";
  buffer_ << "    barrier_data_string << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << i;\n";
  buffer_ << "    barrier_data_string << \" >= \" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << settings.id;\n";
  buffer_ << "    barrier_sync << \" ; \";\n";
  buffer_ << "    barrier_sync << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_sync << i;\n\n";
  buffer_ << "    if (!started)\n";
  buffer_ << "      started = true;\n";
  buffer_ << "  }\n\n";
  buffer_ << "  // create barrier check for all higher ids\n";
  buffer_ << "  for (int64_t i = settings.id + 1; i < processes; ++i)\n";
  buffer_ << "  {\n";
  buffer_ << "    if (started)\n";
  buffer_ << "    {\n";
  buffer_ << "      barrier_string << \" && \";\n";
  buffer_ << "      barrier_data_string << \" && \";\n";
  buffer_ << "    }\n\n";

  buffer_ << "    barrier_string << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_string << i;\n";
  buffer_ << "    barrier_string << \" >= \" + mbarrier + \".\";\n";
  buffer_ << "    barrier_string << settings.id;\n";
  buffer_ << "    barrier_data_string << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << i;\n";
  buffer_ << "    barrier_data_string << \" >= \" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << settings.id;\n";
  buffer_ << "    barrier_sync << \" ; \";\n";
  buffer_ << "    barrier_sync << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_sync << i;\n\n";
  buffer_ << "    if (!started)\n";
  buffer_ << "      started = true;\n";
  buffer_ << "  }\n\n";
  buffer_ << "  barrier_sync << \")\";\n";
  buffer_ << '\n';

  buffer_ << "  // Compile frequently used expressions\n";

  buffer_ << "  std::cout << \"barrier_string: \" << barrier_string.str() << std::endl;\n";

  buffer_ << "  barrier_logic = knowledge_->compile (barrier_string.str ());\n";
  buffer_ << "  barrier_data_logic = knowledge_->compile (barrier_data_string.str ());\n";
  buffer_ << "  barrier_sync_logic = knowledge_->compile (barrier_sync.str ());\n";

  buffer_ << "  Algo::init(context);\n";
  
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void SyncAlgo::run (void)\n";

  buffer_ << "{\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM)
  {
    buffer_ << "  for(;;) {\n";
  }
  else
#endif
  {
    buffer_ << "  {\n";
  }

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    //-- wait for next period\n";
    buffer_ << "    if (zs_wait_next_period(sched, rid) < 0) {\n";
    buffer_ << "      printf(\"wait next period returned negative\\n\");\n";
    buffer_ << "      if (errno == EINTR) {\n";
    buffer_ << "        printf(\"signal interruption!!\\n\");\n";
    buffer_ << "      }\n";
    buffer_ << "    }\n";
    buffer_ << "\n"; 
  }
#endif

  buffer_ << "    // Pre-round barrier increment\n";
  //buffer_ << "  std::cout << \"SyncAlgo::run phase \" << phase << std::endl;;\n";
  buffer_ << "    if(phase == 0)\n";
  buffer_ << "    {\n";
  buffer_ << "      wait_settings.send_list = barrier_send_list; \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = true; \n";
  buffer_ << "      knowledge_->evaluate (\"++\" + mbarrier + \".{.id}\", wait_settings); \n";
  buffer_ << "      phase++;\n";
  buffer_ << "    }\n";

  buffer_ << "    if(phase == 1)\n";
  buffer_ << "    {\n";
  buffer_ << "      // remodify our globals and send all updates \n";
  buffer_ << "      wait_settings.send_list.clear (); \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = false; \n";
  buffer_ << "      // first barrier for new data from previous round \n";
  buffer_ << "      if(knowledge_->evaluate (barrier_data_logic, wait_settings).to_integer()) \n";
  buffer_ << "        phase++;\n";
  buffer_ << "    }\n";

  buffer_ << "    if(phase == 2)\n";
  buffer_ << "    {\n";
  buffer_ << "      // Send only barrier information \n";
  buffer_ << "      wait_settings.send_list = barrier_send_list; \n";
  buffer_ << "      // Execute main user logic \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = true; \n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM)
  {
    buffer_ << "      loop.run_once();\n";
  }
  else
#endif
  {
    buffer_ << "      Algo::run(); \n";
  }

  buffer_ << "      phase++;\n";
  buffer_ << "    }\n";

  buffer_ << "    if(phase == 3)\n";
  buffer_ << "    {\n";
  buffer_ << "      // second barrier for waiting on others to finish round \n";
  buffer_ << "      // Increment barrier and only send barrier update \n";
  buffer_ << "      wait_settings.send_list = barrier_send_list; \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = false; \n";
  buffer_ << "      if(knowledge_->evaluate (barrier_logic, wait_settings).to_integer()) \n";
  buffer_ << "        phase = 0;\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n";
  //buffer_ << "  loop.run_once(barrier_logic, barrier_send_list, wait_settings);\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "void SyncAlgo::cleanup (void)\n";
  buffer_ << "{\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int SyncAlgo::analyze (void)\n";
  buffer_ << "{\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int SyncAlgo::plan (void)\n";
  buffer_ << "{\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  buffer_ << "int SyncAlgo::execute (void)\n";
  buffer_ << "{\n";
  buffer_ << "  knowledge_->evaluate (round_logic, wait_settings);\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
  buffer_ << "\n";
}

void
dmpl::gams::Sync_Builder::compute_priorities ()
{
  Node &node = builder_.program.nodes.begin()->second;

  //-- assign priorities rate monotonically
  std::multimap<int,std::string> period2Func;
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
    {
      if (f.second->attrs.count("Period") == 0)
        continue;
      if (f.second->attrs.count("Period") != 1 || f.second->attrs["Period"].paramList.size() != 1)
        throw std::runtime_error("Invalid @Period attribute.");

      //-- get the period, in us
      int period = f.second->attrs["Period"].paramList.front()->requireInt();
      period2Func.insert(std::pair<int,std::string>(period, f.second->name));
    }

  unsigned nextPrio = 1;
  for(std::map<int,std::string>::const_reverse_iterator i = period2Func.rbegin(), e = period2Func.rend(); i != e; ++i) {
    funcPrios[i->second] = nextPrio++;
  }

  //-- get the criticalities from the dmpl file. also compute the
  //-- maximum criticality
  unsigned maxCrit = 0;
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
    {
      if (f.second->attrs.count("Criticality") == 0)
        continue;
      if (f.second->attrs.count("Criticality") != 1 || f.second->attrs["Criticality"].paramList.size() != 1)
        throw std::runtime_error("Invalid @Criticality attribute.");

      //-- get the criticality
      funcCrits[f.second->name] = f.second->attrs["Criticality"].paramList.front()->requireInt();
      if(maxCrit < funcCrits[f.second->name]) maxCrit = funcCrits[f.second->name];
    }

#if USE_MZSRM==1
  //-- now run the schedulability analysis to compute zero slack
  //-- instants. this requires interacting with Java since the tool is
  //-- written in Java.

  //-- create the string argument to the scheduler
  std::string jvmArg;
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
    {
      if (f.second->attrs.count("Period") == 0)
        continue;

      std::string arg = f.second->name;
      arg += ":" + boost::lexical_cast<std::string>(f.second->attrs["Period"].paramList.front()->requireInt());
      arg += ":" + boost::lexical_cast<std::string>(f.second->attrs["WCExecTimeOverload"].paramList.front()->requireInt());
      arg += ":" + boost::lexical_cast<std::string>(f.second->attrs["WCExecTimeNominal"].paramList.front()->requireInt());
      arg += ":" + boost::lexical_cast<std::string>(maxCrit + 1 - f.second->attrs["Criticality"].paramList.front()->requireInt());
      arg += ":" + boost::lexical_cast<std::string>(nextPrio - funcPrios[f.second->name]);

      if(jvmArg.empty()) jvmArg = arg;
      else jvmArg += "," + arg;
    }

  JavaVM *jvm = NULL;       /* denotes a Java VM */
  JNIEnv *env = NULL;       /* pointer to native method interface */
  JavaVMInitArgs vm_args; /* JDK/JRE 6 VM initialization arguments */
  JavaVMOption* options = new JavaVMOption[1];
  std::string classPath("-Djava.class.path=/usr/lib/java:");
  classPath += std::string(getenv("MZSRM_ROOT")) + "/zsrmscheduler";
  options[0].optionString = (char*)classPath.c_str();
  vm_args.version = JNI_VERSION_1_6;
  vm_args.nOptions = 1;
  vm_args.options = options;
  vm_args.ignoreUnrecognized = false;
  /* load and initialize a Java VM, return a JNI interface
   * pointer in env */
  JNI_CreateJavaVM(&jvm, (void**)&env, &vm_args);
  delete options;
  /* invoke the Main.test method using the JNI */
  jclass cls = env->FindClass("edu/cmu/sei/ZeroSlackRM/ZSRMScheduler");
  assert(cls && "ERROR: could not load ZSRMScheduler class!!");
  //-- get method id
  jmethodID mid = env->GetStaticMethodID(cls, "computeZSInstants", "(Ljava/lang/String;)Ljava/lang/String;");
  assert(mid && "ERROR: could not get method id for computeZSInstants!!");
  //-- call method
  jobject rv = env->CallStaticObjectMethod(cls, mid, env->NewStringUTF(jvmArg.c_str()));
  const char *strReturn = env->GetStringUTFChars((jstring)rv, 0);
  //std::cout << strReturn << '\n';
  //-- parse return value and set zero slack instants
  char *start = (char*) strReturn;
  for(;;) {
    char *next = strstr(start, ",");
    if(next == NULL) next = start + strlen(start);
    char *split = strstr(start, ":");
    assert(split);
    std::string fname(start, split-start);
    std::string zsi(split+1, next-(split+1));
    //std::cout << fname << ":" << zsi << '\n';
    funcZsinsts[fname] = atoi(zsi.c_str());
    if(next == start + strlen(start)) break;
    else start = next+1;
  }

  /* We are done. */
  jvm->DestroyJavaVM();
#endif
}

void
dmpl::gams::Sync_Builder::build_main_function ()
{
  buffer_ << "template<class T> std::string to_string(const T &in)\n";
  buffer_ << "{\n";
  buffer_ << "  std::stringstream ss;\n";
  buffer_ << "  ss << in;\n";
  buffer_ << "  return ss.str();\n";
  buffer_ << "}\n";
  buffer_ << "\n";
  buffer_ << "void init_vrep(const std::vector<std::string> &params, engine::Knowledge_Base &knowledge)\n";
  buffer_ << "{\n";
  buffer_ << "  if(params.size() >= 2 && params[1].size() > 0)\n";
  buffer_ << "    knowledge.set(\".vrep_host\", params[1]);\n";
  buffer_ << "  else\n";
  buffer_ << "    knowledge.set(\".vrep_host\", \"127.0.0.1\");\n";
  buffer_ << "  if(params.size() >= 3 && params[2].size() > 0)\n";
  buffer_ << "    knowledge.set(\".vrep_port\", params[2]);\n";
  buffer_ << "  else\n";
  buffer_ << "    knowledge.set(\".vrep_port\", to_string(19905+settings.id));\n";
  buffer_ << "  if(params.size() >= 4 && params[3].size() > 0)\n";
  buffer_ << "    knowledge.set(\".vrep_sw_position\", params[3]);\n";
  buffer_ << "  else\n";
  buffer_ << "    knowledge.set(\".vrep_sw_position\", \"40.4464255,-79.9499426\");\n";
  buffer_ << "  if(params.size() >= 5 && params[4].size() > 0)\n";
  buffer_ << "    knowledge.set(\".move_speed\", params[4]);\n";
  buffer_ << "  else\n";
  buffer_ << "    knowledge.set(\".move_speed\", \"0.4\");\n";
  buffer_ << "  knowledge.set(\"vrep_ready\", \"1\");\n";
  buffer_ << "}\n";
  buffer_ << "\n";
  buffer_ << "int main (int argc, char ** argv)\n";
  buffer_ << "{\n";
  //buffer_ << "  Madara::Utility::set_log_level(Madara::Utility::LOG_DETAILED_TRACE);\n";
  //buffer_ << "  Madara::Utility::set_log_level(Madara::Utility::LOG_MAJOR_DEBUG_INFO);\n";
  buffer_ << "  settings.type = Madara::Transport::MULTICAST;\n";
  //buffer_ << "  settings.type = Madara::Transport::BROADCAST;\n";
  buffer_ << "  platform_init_fns[\"vrep\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-uav\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-heli\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-ant\"] = init_vrep;\n";
  buffer_ << "\n";
  buffer_ << "  // handle any command line arguments\n";
  buffer_ << "  handle_arguments (argc, argv);\n";
  buffer_ << "\n";
  buffer_ << "  if (settings.hosts.size () == 0)\n";
  buffer_ << "  {\n";
  buffer_ << "    // setup default transport as multicast\n";
  buffer_ << "    settings.hosts.push_back (default_multicast);\n";
  //buffer_ << "    settings.hosts.push_back (\"127.0.0.1:4150\");\n";
  buffer_ << "    settings.add_receive_filter (Madara::Filters::log_aggregate);\n";
  buffer_ << "    settings.add_send_filter (Madara::Filters::log_aggregate);\n";
  buffer_ << "  }\n\n";
  
  buffer_ << "  settings.queue_length = 1000000;\n\n";
  buffer_ << "  settings.set_deadline(1);\n\n";


#if 0
  //-- if either callbacks or heartbeats
  if(!builder_.program.callbacks.empty()) {
    buffer_ << "  // add commonly used filters\n";
    buffer_ << "  settings.add_send_filter (add_auxiliaries);\n";

    if (builder_.program.callbackExists ("on_receive_filter"))
      {
        buffer_ << "  // add user-defined receive filter\n";
        std::string usr_filter =
          builder_.program.getCallback ("on_receive_filter");
        buffer_ << "  settings.add_receive_filter (" <<
          usr_filter << ");\n";
      }

    buffer_ << "  settings.add_receive_filter (set_heartbeat);\n";
    buffer_ << "  settings.add_receive_filter (remove_auxiliaries);\n";
    buffer_ << "\n";
  }
#endif

  buffer_ << "  // configure the knowledge base with the transport settings\n";
  buffer_ << "  knowledge.attach_transport(host, settings);\n\n";

  Node &node = builder_.program.nodes.begin()->second;

  buffer_ << "  // NODE: " << node.name << "\n";
  BOOST_FOREACH (Attributes::value_type & attr, node.attrs)
    {
      buffer_ << "  // @" << attr.second.name;
      BOOST_FOREACH (Expr p, attr.second.paramList)
        {
          buffer_ << " " << p->toString();
        }
      buffer_ << "\n";
    }


  build_program_variables_bindings ();
  build_main_define_functions ();

  // set the values for id and processes
  buffer_ << "  // Initialize commonly used local variables\n";  
  buffer_ << "  id = settings.id;\n";
  buffer_ << "  num_processes = processes;\n";
  buffer_ << "  if(id < 0 || id >= processes) {\n";
  buffer_ << "    std::cerr << \"Invalid node id: \" << settings.id << \"  valid range: [0, \" << processes - 1 << \"]\" << std::endl;\n";
  buffer_ << "    exit(1);\n";
  buffer_ << "  }\n";

  buffer_ << "  PlatformInitFns::iterator init_fn = platform_init_fns.find(platform_name);\n";
  buffer_ << "  if(init_fn != platform_init_fns.end())\n";
  buffer_ << "    init_fn->second(platform_params, knowledge);\n";


  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
    {
      if (f.second->attrs.count("InitSim") == 1)
        {
          buffer_ << "  knowledge.evaluate(\"" << f.second->name << "()\");\n";
        }
    }
  //buffer_ << "  knowledge.set(\"S\" + to_string(settings.id) + \".init\", \"1\");\n";

  buffer_ << "  threads::Threader threader(knowledge);\n";

  Func platformFunction;
  buffer_ << "  std::vector<Algo *> algos;\n";
  buffer_ << "  Algo *algo;\n\n";
  BOOST_FOREACH(Funcs::value_type &f, node.funcs)
    {
      if (!f.second->isThread())
        continue;
      int period;
      if (f.second->attrs.count("Period") == 0)
        period = 100000; // Default to 10 Hz
      else if (f.second->attrs.count("Period") != 1 || f.second->attrs["Period"].paramList.size() != 1)
        throw std::runtime_error("Invalid @Period attribute.");
      else
        period = f.second->attrs["Period"].paramList.front()->requireInt(); //-- get the period, in us


#if USE_MZSRM==1
      //-- get the priority, criticality, and zero slack instant
      unsigned priority = funcPrios[f.second->name];
      unsigned criticality = funcCrits[f.second->name];
      unsigned zsinst = funcZsinsts[f.second->name];
#endif

      if (f.second->attrs.count("PlatformController") == 1)
        {
          if (platformFunction == NULL)
            {
              platformFunction = f.second;
            }
          else
            {
              throw std::runtime_error("Multiple @PLATFORM_CONTROLLER functions are not supported.");
            }
        }

      //-- for synchronous function
      if (f.second->attrs.count("BarrierSync") == 1)
        {
#if USE_MZSRM==1
          if(schedType_ == MZSRM) {
            if (platformFunction == f.second)
              buffer_ << "  algo = new SyncAlgo("
                      << period << ", " << priority << ", " 
                      << criticality << ", " << zsinst << ", \"" << f.second->name 
                      << "\", &knowledge, platform_name);\n";
            else
              buffer_ << "  algo = new SyncAlgo("
                      << period << ", " << priority << ", " 
                      << criticality << ", " << zsinst << ", \"" << f.second->name 
                      << "\", &knowledge);\n";
          }
          else
#endif
          {
            if (platformFunction == f.second)
              buffer_ << "  algo = new SyncAlgo(" << period << ", \"" << f.second->name << "\", &knowledge, platform_name);\n";
            else
              buffer_ << "  algo = new SyncAlgo(" << period << ", \"" << f.second->name << "\", &knowledge);\n";
          }
        }
      //-- for asynchronous function
      else
        {
#if USE_MZSRM==1
          if(schedType_ == MZSRM) {
            if (platformFunction == f.second)
              buffer_ << "  algo = new Algo(" << period << ", " 
                      << period << ", " << priority << ", " 
                      << criticality << ", " << zsinst << ", \"" << f.second->name 
                      << "\", &knowledge, platform_name);\n";
            else
              buffer_ << "  algo = new Algo(" << period << ", "
                      << period << ", " << priority << ", " 
                      << criticality << ", " << zsinst << ", \"" << f.second->name 
                      << "\", &knowledge);\n";
          }
          else
#endif
          {
            if (platformFunction == f.second)
              buffer_ << "  algo = new Algo(" << period << ", \"" << f.second->name << "\", &knowledge, platform_name);\n";
            else
              buffer_ << "  algo = new Algo(" << period << ", \"" << f.second->name << "\", &knowledge);\n";
          }
        }
      buffer_ << "  algos.push_back(algo);\n\n";
    }

  buffer_ << "  for(int i = 0; i < algos.size(); i++)\n";
  buffer_ << "    algos[i]->start(threader);\n";

  buffer_ << "  knowledge.set(\"begin_sim\", \"1\");\n";

  if(do_expect_)
  {
    buffer_ << "  threader.run(5.0, \"expect_thread\", new ExpectThread(expect_file.is_open()?expect_file:std::cout));\n";
  }

  buffer_ << "  threader.wait();\n";

  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
}

void
dmpl::gams::Sync_Builder::build_main_define_functions ()
{
  buffer_ << "  // Defining common functions\n\n";

  buffer_ << "  knowledge.define_function (\"REMODIFY_BARRIERS\", ";
  buffer_ << "REMODIFY_BARRIERS);\n\n";

  buffer_ << "  knowledge.define_function (\"REMODIFY_GLOBALS\", ";
  buffer_ << "REMODIFY_GLOBALS);\n\n";

  buffer_ << "  // Defining global functions for MADARA\n\n";
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    {
      build_main_define_function (Node (), i->second);
    }
  
  buffer_ << "\n";

  buffer_ << "  // Defining node functions for MADARA\n\n";
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
    {
      Funcs & funcs = n->second.funcs;
      for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
        {
          build_main_define_function (n->second, i->second);
        }
    }

  buffer_ << "\n";
}


void
dmpl::gams::Sync_Builder::build_main_define_function (const Node & node,
                                                      Func & function)
{
  if (!(skip_func(function)))
    {
      buffer_ << "  knowledge.define_function (\"";
      buffer_ << function->name;
      buffer_ << "\", ";
      buffer_ << node.name << "_" << function->name;
      buffer_ << ");\n";
    }
}

void
dmpl::gams::Sync_Builder::clear_buffer ()
{
  buffer_.str ("");
}

void
dmpl::gams::Sync_Builder::print (std::ostream & os)
{
  os << buffer_.str ();
}

void
dmpl::gams::Sync_Builder::open_dmpl_namespace ()
{
  buffer_ << "// begin dmpl namespace\n";
  buffer_ << "namespace dmpl\n";
  buffer_ << "{\n";
}

void
dmpl::gams::Sync_Builder::close_dmpl_namespace ()
{
  buffer_ << "} // end dmpl namespace\n";
  buffer_ << "\n";
}
