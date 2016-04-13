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

#include "AnalyzerBuilder.hpp"
#include <dmpl/gams/GAMSVisitors.hpp>
#include <boost/algorithm/string.hpp>
#include <vector>
#include <map>
#include <dmplc/dmpl-parser.hpp>

/*********************************************************************/
//-- utility functions
/*********************************************************************/
namespace
{
  /*******************************************************************/
  //-- return true if the argument function should not be declared or
  //-- defined.
  /*******************************************************************/
  bool skip_func(const dmpl::Func & function)
  {
    return (function->attrs.count("InitSim") == 0 && function->isExtern);
  }
  
  /*******************************************************************/
  //-- return fully expanded node name
  /*******************************************************************/
  std::string nodeName(const dmpl::Node &node)
  {
    return "node_" + node->name;
  }
  
  /*******************************************************************/
  //-- return fully expanded role name
  /*******************************************************************/
  std::string roleName(const dmpl::Node &node, const dmpl::Role &role)
  {
    return "node_" + node->name + "_role_" + role->name;
  }
  
  /*******************************************************************/
  //-- return fully expanded function name
  /*******************************************************************/
  std::string funcName(const dmpl::Node &node, const dmpl::Role &role, const dmpl::Func & func)
  {
    return "node_" + node->name + "_role_" + role->name + "_" + func->name;
  }

  /*******************************************************************/
  //-- return fully expanded remodify barriers function name
  /*******************************************************************/
  std::string remodifyBarriersName(const dmpl::Node &node, const dmpl::Role &role, const dmpl::Func & func)
  {
    return "node_" + node->name + "_role_" + role->name + "_" + func->name + "_REMODIFY_BARRIERS";
  }

  /*******************************************************************/
  //-- return fully expanded remodify globals function name
  /*******************************************************************/
  std::string remodifyGlobalsName(const dmpl::Node &node, const dmpl::Role &role, const dmpl::Func & func)
  {
    return "node_" + node->name + "_role_" + role->name + "_" + func->name + "_REMODIFY_GLOBALS";
  }

  /*******************************************************************/
  //-- return type of a variable. promote char to short since MADARA
  //-- does not supprt char currently.
  /*******************************************************************/
  std::string get_type_name(const dmpl::Var &var)
  {
    return (var->type->type == TCHAR) ? "short" : var->type->toString();
  }

  /*******************************************************************/
  //-- return type of a function. promote char to short since MADARA
  //-- does not supprt char currently.
  /*******************************************************************/
  std::string get_ret_type_name(const dmpl::Func &func)
  {
    return (func->retType->type == TCHAR) ? "short" : func->retType->toString();
  }

  /*******************************************************************/
  //-- print a set of variable declarations, and initialize them
  //-- appropriately if they are also parameters.
  /*******************************************************************/
  void print_vars(std::stringstream &buffer_, const dmpl::VarList & vars, bool isParam)
  {
    int i = 0;
    BOOST_FOREACH (const dmpl::Var & variable, vars) {
      buffer_ << "  " << get_type_name(variable);
      buffer_ << " " << variable->name;
      if(isParam) buffer_ << " = args[" << i << "].to_double()";
      buffer_ << ";\n";
      ++i;
    }
  }

  /*******************************************************************/
  //-- print statements initializing temporary variables of a function
  /*******************************************************************/
  void print_temp_inits(const dmpl::Func &func, const dmpl::Node &node,
                        dmpl::DmplBuilder & builder_, std::stringstream & buffer_)
  {
    for(const dmpl::Var & variable : func->temps) {
      if(variable->initFunc == NULL) continue;
      
      dmpl::madara::GAMSCompiler visitor (variable->initFunc, node, dmpl::Func(),
                                          builder_, buffer_, false, true);
      for (const dmpl::Stmt & statement : variable->initFunc->body)
        visitor.visit (statement);
    }
  }
}

/*********************************************************************/
//-- constructor
/*********************************************************************/
dmpl::gams::AnalyzerBuilder::AnalyzerBuilder (dmpl::DmplBuilder & builder,const std::string &target)
  : CodeGenerator(builder,target, dmpl::NON_RT, true) {}

/*********************************************************************/
//-- top level code generator
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build ()
{
  buffer_ << "//-- DMPLC Version: " << builder_.version << '\n';
  buffer_ << "//-- DMPLC Command Line: ";
  for(const std::string &c : builder_.cmdLine) buffer_ << ' ' << c;
  buffer_ << "\n\n";

  build_target_thunk ();
  build_header_includes ();

  // open dmpl namespace after including ALL libraries
  open_namespace ("dmpl");

  build_common_global_variables ();
  build_program_variables ();
  build_common_filters ();
  build_parse_args ();
  build_function_declarations ();
  build_gams_functions ();
  build_global_functions ();
  build_nodes ();

  // close dmpl namespace
  close_namespace ("dmpl");
  buffer_ << "using namespace dmpl;\n\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) compute_priorities ();
#endif
  build_main_function ();

  build_comment("//-- End of generated code", "\n", "", 0);
}

/*********************************************************************/
//-- generate target thunks verbatim
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_target_thunk (void)
{
  build_comment("//-- begin target (" + target_ + ") specific thunk", "", "", 0);

  // we use target_ as a key to all related thunks
  Program::TargetType::const_iterator it =
    builder_.program.targets.find (target_);
  
  // if there was any such target, print it
  if (it != builder_.program.targets.end ())
    buffer_ << it->second << "\n\n";
  else
    buffer_ << "//-- no thunk for target (" << target_ << ")\n";

  build_comment("//-- end target (" + target_ + ") specific thunk", "", "\n", 0);
}

/*********************************************************************/
//-- generate header files
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_header_includes ()
{
  build_comment("//-- begin header files", "", "\n", 0);

  buffer_ << "#include <string>\n";
  buffer_ << "#include <vector>\n";
  buffer_ << "#include <sstream>\n";
  buffer_ << "#include <fstream>\n";
  buffer_ << "#include <cassert>\n";
  buffer_ << "#include <cmath>\n";
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
  buffer_ << "#include \"madara/knowledge/KnowledgeBase.h\"\n";
  buffer_ << "#include \"madara/knowledge/KnowledgeRecord.h\"\n";
  buffer_ << "#include \"madara/knowledge/Functions.h\"\n";
  buffer_ << "#include \"madara/transport/PacketScheduler.h\"\n";
  buffer_ << "#include \"madara/threads/Threader.h\"\n";
  buffer_ << "#include \"madara/filters/GenericFilters.h\"\n";
  buffer_ << "\n";
  buffer_ << "#define _GAMS_VREP_ 1\n";
  buffer_ << "#include \"gams/controllers/BaseController.h\"\n";
  buffer_ << "#include \"gams/algorithms/BaseAlgorithm.h\"\n";
  buffer_ << "#include \"gams/variables/Sensor.h\"\n";
  buffer_ << "#include \"gams/platforms/BasePlatform.h\"\n";
  buffer_ << "#include \"gams/platforms/vrep/VREPBase.h\"\n";
  buffer_ << "#include \"gams/platforms/vrep/VREPQuadLaser.h\"\n";
  buffer_ << "#include \"gams/variables/Self.h\"\n";
  buffer_ << "#include \"gams/utility/GPSPosition.h\"\n";
  buffer_ << "#include \"gams/utility/Rotation.h\"\n";
  buffer_ << "\n";
  buffer_ << "#include \"dmpl/Reference.hpp\"\n";
  buffer_ << "#include \"dmpl/ArrayReference.hpp\"\n";
  buffer_ << "#include \"dmpl/ProactiveStorage.hpp\"\n";
  buffer_ << "#include \"dmpl/LogAnalyzer.hpp\"\n";
  buffer_ << "#include \"dmpl/DefaultLogger.hpp\"\n";
  if(do_expect_) {
    buffer_ << "extern \"C\" {\n";
    buffer_ << "#include <sys/time.h>\n";
    buffer_ << "}\n";
    buffer_ << "\n";
  }

  build_comment("//-- end header files", "\n", "\n", 0);
}

/*********************************************************************/
//-- generate global variables needed for all DMPL programs
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_common_global_variables ()
{
  build_comment("//-- typedefs", "\n", "", 0);
  buffer_ << "typedef   madara::knowledge::KnowledgeRecord::Integer   Integer;\n\n";

  build_comment("//-- namespace shortcuts", "", "", 0);
  buffer_ << "namespace threads = madara::threads;\n";
  buffer_ << "namespace containers = engine::containers;\n";
  buffer_ << "namespace controllers = gams::controllers;\n";
  buffer_ << "namespace platforms = gams::platforms;\n";
  buffer_ << "namespace variables = gams::variables;\n";
  buffer_ << "\n";

  build_comment("//-- for readability so we don't have to use full namespaces", "", "", 0);
  buffer_ << "using containers::Reference;\n";
  buffer_ << "using containers::ArrayReference;\n";
  buffer_ << "using containers::StorageManager::Proactive;\n";
  buffer_ << "using madara::knowledge::knowledge_cast;\n";
  buffer_ << "using madara::knowledge::KnowledgeRecord;\n";
  buffer_ << "using madara::knowledge::KnowledgeMap;\n";
  buffer_ << "\n";

  build_comment("//-- declare knowledge base", "", "", 0);
  buffer_ << "engine::KnowledgeBase knowledge;\n";
  buffer_ << "\n";

  build_comment("//-- Needed as a workaround for non-const-correctness in Madara;\n"
                "//-- Use carefully", "", "", 0);
  buffer_ << "inline engine::FunctionArguments &__strip_const(const engine::FunctionArguments &c)\n";
  buffer_ << "{\n";
  buffer_ << "  return const_cast<engine::FunctionArguments &>(c);\n";
  buffer_ << "}\n";

  build_comment("//-- Needed to construct function arguments", "\n", "", 0);
  buffer_ << "inline engine::FunctionArguments &__chain_set(engine::FunctionArguments &c, int i, KnowledgeRecord v)\n";
  buffer_ << "{\n";
  buffer_ << "  c[i] = v;\n";
  buffer_ << "  return c;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  build_comment("//-- Variable to store node id", "", "", 0);
  //buffer_ << "containers::IntegerArray barrier;\n";
  buffer_ << "Reference<unsigned int> id(knowledge, \".id\");\n\n";

  //-- the map from role ids to variable names to ids of roles that
  //-- are in the same group
  //build_comment("//-- map from role ids to variables to roles that share same group", "", "", 0);
  //buffer_ << "//-- std::map< unsigned int,std::map< std::string,std::set<unsigned int> > > nodesInGroup;\n\n";

  build_comment("//-- number of participating processes", "", "", 0);
  buffer_ << "unsigned int processes (" << numNodes () << ");\n\n";
}

/*********************************************************************/
//-- generate program-specific global variables
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_program_variables ()
{
  //-- generate constants as #define statements
  build_comment("//-- Defining program-specific constants", "", "", 0);
  
  Program::ConstDef & consts = builder_.program.constDef;
  for (Program::ConstDef::const_iterator i = consts.begin (); i != consts.end (); ++i)
    buffer_ << "#define " << i->first << ' ' << i->second << '\n';


  //-- declare variables for extern functions called by the spec
  build_comment("//-- Begin defining variables for external functions", "\n", "", 0);
  BOOST_FOREACH(Funcs::value_type &it, builder_.program.funcs)
  {
    Func func = it.second;
    if(!func->isExtern || func->params.size() > 0 || func->retType->type == TVOID)
      continue;

    bool isSpecFunc = false;
    for(const Process &proc : builder_.program.processes) {
      for(const Spec &spec : proc.role->allSpecsInScope()) {
        ExpectSpec *es = dynamic_cast<ExpectSpec*>(spec.get());
        if(es == NULL) continue;

        if(es->func->equalType(*func)) { isSpecFunc = true; break; }          
        if(es->func->canCall(func, proc.role.get())) { isSpecFunc = true; break; }          
      }
      if(isSpecFunc) break;
    }

    if(isSpecFunc) {
      buffer_ << "ArrayReference<" << get_ret_type_name(func) << "," << numNodes () << "> ";
      buffer_ << "EXTERN_" << func->name << "(knowledge, \"";
      buffer_ << "EXTERN_" << func->name << "\");\n";
    }
  }
  
  //-- define variables for each node
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::const_iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    //-- generate node-level variables
    build_comment("//-- Begin defining variables for node " + n->second->name, "\n", "\n", 0);
    open_namespace(nodeName(n->second));
    build_node_variables(n->second, "global");
    build_node_variables(n->second, "group");
    build_node_variables(n->second, "local");

    //-- generate variables for roles
    for (const auto r : n->second->roles) {
      //-- generate role-level variables
      build_comment("//-- Begin defining variables for role " + r.second->name, "\n", "\n", 0);
      open_namespace(roleName(n->second, r.second));
      build_role_variables(r.second, "global");
      build_role_variables(r.second, "group");
      build_role_variables(r.second, "local");      
      buffer_ << '\n';
      
      close_namespace(roleName(n->second, r.second));
      build_comment("//-- End defining variables for role " + r.second->name, "", "", 0);
    }

    buffer_ << '\n';
    close_namespace(nodeName(n->second));
    build_comment("//-- End defining variables for node " + n->second->name, "", "", 0);
  }
}

/*********************************************************************/
//-- declare and initialize node variables. scope = local/global/group
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_node_variables (const Node &node, const std::string &scope)
{
  if(scope != "local" && scope != "global" && scope != "group")
    throw std::runtime_error("ERROR: illegal scope " + scope + " when declaring variables for node " +
                             node->name + "!!");
  
  build_comment("//-- Defining " + scope + " variables at node scope", "\n", "", 0);

  Vars & vars = (scope == "global") ? node->globVars :
    (scope == "local" ? node->locVars : node->groupVars);

  for (Vars::const_iterator i = vars.begin (); i != vars.end (); ++i) {
    const Var & var = i->second;
    if(scope != "local") var->type = var->type->incrDim(-1);
    build_program_variable_decl (var);
  }
}

/*********************************************************************/
//-- declare and initialize role variables. scope = local/global/group
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_role_variables (const Role &role, const std::string &scope)
{
  if(scope != "local" && scope != "global" && scope != "group")
    throw std::runtime_error("ERROR: illegal scope " + scope + " when declaring variables for role " +
                             role->name + "!!");
  
  build_comment("//-- Defining " + scope + " variables at role scope", "\n", "", 0);

  Vars & vars = (scope == "global") ? role->globVars :
    (scope == "local" ? role->locVars : role->groupVars);

  for (Vars::const_iterator i = vars.begin (); i != vars.end (); ++i) {
    const Var & var = i->second;
    if(var->isOverride) continue;
    if(scope != "local") var->type = var->type->incrDim(-1);
    build_program_variable_decl (var);
  }
}

/*********************************************************************/
//-- declare a DMPL program specific global variable
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_program_variable_decl (const Var & var)
{
  // is this an array type?
  if (var->type->dims.size () >= 1)
  {
    buffer_ << "ArrayReference<" << get_type_name(var);
    BOOST_FOREACH(int dim, var->type->dims)
    {
      buffer_ << ", " << (dim > 0 ? dim : numNodes ());
    }
    buffer_ << "> ";
  }
  else
  {
    buffer_ << "ArrayReference<" << get_type_name(var)
            << ", " << numNodes () << "> ";
  }
  buffer_ << var->name;
  buffer_ << "(knowledge, \"";
  if(var->scope == Variable::LOCAL)
    buffer_ << ".";
  buffer_ << var->name << "\")";
  buffer_ << ";\n";
}

/*********************************************************************/
//-- generate network filters for MADARA
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_common_filters (void)
{
}

/*********************************************************************/
//-- generate helper function for MADARA network filters
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_common_filters_helper (
    const std::string filter_name,
    std::stringstream & filter_content)
{
  buffer_ << "KnowledgeRecord\n";
  buffer_ << filter_name << " (KnowledgeMap & records,\n";
  buffer_ << "  const madara::transport::TransportContext & context,\n";
  buffer_ << "  madara::knowledge::Variables & vars)\n";
  buffer_ << "{\n";
  buffer_ << "  KnowledgeRecord result;\n";
  buffer_ << filter_content.str ();
  buffer_ << "  return result;\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- generate code to initialize the role2Ids map
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_init_role_id ()
{
  const Program &prog = builder_.program;
  build_comment("//-- Initializing the role2Id map", "", "", 2);
  for(const auto &rr : rolesRefRoles) {
    std::set<Process> procs = prog.procsWithRole(rr.first);
    for(const Process &proc : procs) {
      for(const std::string &rp : rr.second) {
        std::set<Process> refProcs = prog.getRefProcs(proc,rp);
        if(refProcs.empty())
          throw std::runtime_error("ERROR: role " + rp + " referred by role " + rr.first +
                                   " is empty, i.e., not instantiated by any node!!");
        if(refProcs.size() > 1)
          throw std::runtime_error("ERROR: role " + rp + " referred by role " + rr.first +
                                   " is ambiguous, i.e., instantiated by multiple nodes!!");
        buffer_ << "  role2Id[" << proc.id << "][\"" << rp << "\"] = " << refProcs.begin()->id << ";\n";
      }
    }
  }
}

/*********************************************************************/
//-- generate code to initialize the nodesInGroup map
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_init_nodes_in_group ()
{
  const Program &prog = builder_.program;
  build_comment("//-- Initializing the nodesInGroup map", "\n", "", 2);
  for(const auto &v1 : prog.nodesInGroup) {
    for(const auto &v2 : v1.second) {
      std::string init;
      for(const auto &v3 : v2.second) {
        init += std::to_string(v3) + ",";
      }
      buffer_ << "  //-- nodesInGroup[" << v1.first << "][\"" << v2.first << "\"] = {" << init << "};\n";      
    }
  }
}

/*********************************************************************/
//-- generate constructor invocation for all program variables
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_constructors ()
{ 
  build_comment("//-- Invoking constructors", "\n", "", 2);
  for (auto & n : builder_.program.nodes) {
    for(auto & r : n.second->roles)
      buffer_ << "  if(node_name == \"" << n.second->name << "\" && role_name == \""
              << r.second->name << "\") " << nodeName(n.second) << "::"
              << roleName(n.second, r.second) << "::constructor ();\n";
  }  
  buffer_ << "\n";
}

/*********************************************************************/
//-- generate code to assign initial value to a variable.
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_program_variable_assignment (const Var & var)
{
  // is this a global/group scalar (i.e., 1-dimensional array)?
  if ((var->scope == Variable::GLOBAL || var->scope == Variable::GROUP) && var->type->dims.size () == 1)
    buffer_ << "  " << var->name << "[id] = var_init_" << var->name << ";\n";
  // otherwise for local variables
  else if (var->type->dims.size () == 0)
    buffer_ << "  " << var->name << " = var_init_" << var->name << ";\n";
}

/*********************************************************************/
//-- generate method to parse command line arguments
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_parse_args ()
{
  //-- generate code to initialze common variables from the command
  //-- line
  build_comment("//-- helper tokenizer method to handle command line arguments", "\n", "", 0);
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

  build_comment("//-- handle arguments from the command line", "\n", "", 0);
  buffer_ << "void handle_arguments (int argc, char ** argv)\n";
  buffer_ << "{\n";
  buffer_ << "  for (int i = 1; i < argc; ++i)\n";
  buffer_ << "  {\n";
  buffer_ << "    std::string arg1 (argv[i]);\n";
  buffer_ << "\n";
  buffer_ << "    if (arg1 == \"-l\" || arg1 == \"--level\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        int log_level = 0;\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> log_level;\n";
  buffer_ << "        madara::logger::global_logger->set_level(log_level);\n";
  buffer_ << "        gams::loggers::global_logger->set_level(log_level);\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-f\" || arg1 == \"--logfile\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        ::madara::logger::global_logger->clear();\n";
  buffer_ << "        ::madara::logger::global_logger->add_file(argv[i + 1]);\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";

  /*******************************************************************/
  //-- generate code for initializing DMPL variables from the command
  //-- line.
  /*******************************************************************/

  //-- create a map from variables to nodes and roles for which they are inputs
  std::map<std::string,std::list<std::pair<Node,Role>>> inputVars;
  for(const auto &n : builder_.program.nodes) {
    //-- process each role
    for (auto & r : n.second->roles) {
      //-- a variable is an input if 
      for (auto & var : r.second->allVarsInScope())
        if(var->isInput) {
          //-- sanity check : array input variables disallowed
          if ((var->scope == Symbol::LOCAL && var->type->dims.size () > 0) ||
              (var->scope == Symbol::GLOBAL && var->type->dims.size () > 1) ||
              (var->scope == Symbol::GROUP && var->type->dims.size () > 1))
            throw std::runtime_error("ERROR: illegal array input variable " + var->name +
                                     " in role " + r.second->name +
                                     " in node " + n.second->name + "!!");

          //-- insert into list
          inputVars[var->name].push_back(std::make_pair(n.second, r.second));
        }
    }
  }

  buffer_ << "    else\n";
  buffer_ << "    {\n";
  buffer_ << "      madara_log (madara::logger::LOG_EMERGENCY, (LM_DEBUG, \n";
  buffer_ << "        \"\\nProgram summary for %s:\\n\\n\"\\\n";
  buffer_ << "        \" [-f|--logfile file]      log to a file\\n\"\\\n";
  buffer_ << "        \" [-l|--level level]       the logger level (0+, higher is higher detail)\\n\"\\\n";

  buffer_ << "        , argv[0]));\n";
  buffer_ << "      exit (0);\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- generate function declarations.
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_function_declarations ()
{
  build_comment("//-- Forward declaring global functions", "", "", 0);
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    build_function_declaration (i->second);
  
  build_comment("//-- Forward declaring node and role functions", "\n", "", 0);
  Nodes & nodes = builder_.program.nodes;
  for (const auto &n : nodes)
  {
    open_namespace(nodeName(n.second));

    //-- process roles
    for(const auto &r : n.second->roles) {
      build_comment("//-- Declaring functions for role " + r.second->name, "\n", "\n", 0);
      open_namespace(roleName(n.second, r.second));

      //-- declare functions to evaluate expect specifications
      build_expect_spec_declaration(r.second);
      
      close_namespace(roleName(n.second, r.second));
    }

    close_namespace(nodeName(n.second));
  }
}

/*********************************************************************/
//-- generate function declaration
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_function_declaration (const Func & function)
{
  if (skip_func(function)) return;

  buffer_ << "KnowledgeRecord\n";
  buffer_ << function->name;
  buffer_ << " (engine::FunctionArguments & args, engine::Variables & vars);\n";
}

/*********************************************************************/
//-- declare functions to evaluate expect specifications
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_expect_spec_declaration (const Role &role)
{
  //-- collect all functions called by the expect specification
  FuncSet specFuncs;
  for(const Spec &spec : role->allSpecsInScope()) {
    ExpectSpec *es = dynamic_cast<ExpectSpec*>(spec.get());
    if(es == NULL) continue;

    for(const Func &func: role->allFuncsInScope())
      if(es->func->equalType(*func) || es->func->canCall(func, role.get()))
        specFuncs.insert(func);
  }
  
  for(const Func &func : specFuncs) build_function_declaration (func);
}

/*********************************************************************/
//-- generate functions and variables used to interact with GAMS
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_gams_functions ()
{
  build_comment("//-- GAMS variables and functions", "\n", "\n", 0);
  buffer_ << "#include \"dmpl/PlatformGAMS.hpp\"\n";
}

/*********************************************************************/
//-- generate functions at the global scope
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_global_functions (void)
{
  build_comment("//-- Defining global functions", "\n", "\n", 0);
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function (Node (), i->second);
  }
}

/*********************************************************************/
//-- generate code for nodes
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_nodes (void)
{
  Nodes & nodes = builder_.program.nodes;
  for (Nodes::iterator n = nodes.begin (); n != nodes.end (); ++n)
  {
    build_comment("//-- Begin node " + n->second->name, "\n", "\n", 0);
    open_namespace(nodeName(n->second));
    
    //-- process roles
    for(const auto &r : n->second->roles) {
      build_comment("//-- Defining functions for role " + r.second->name, "\n", "\n", 0);
      open_namespace(roleName(n->second, r.second));

      //-- generate functions to evaluate expect specifications
      build_expect_spec_definition (r.second);

      close_namespace(roleName(n->second, r.second));
    }

    close_namespace(nodeName(n->second));
    build_comment("//-- End node " + n->second->name, "\n", "\n", 0);
  }

  buffer_ << "\n";
}

/*********************************************************************/
//-- generate code for a function
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_function (const dmpl::Node & node, const dmpl::Func & function)
{
  if (function != NULL && skip_func(function)) return;

  //-- print attributes
  if(function != NULL) {
    BOOST_FOREACH (Attributes::value_type & attr, function->attrs)
      {
        buffer_ << "//-- @" << attr.second.name;
        BOOST_FOREACH (Expr p, attr.second.paramList)
          buffer_ << " " << p->toString();
        buffer_ << "\n";
      }
  }

  //-- function header
  buffer_ << "KnowledgeRecord\n";
  buffer_ << function->name;
  buffer_ << " (engine::FunctionArguments & args, engine::Variables & vars)\n";
  buffer_ << "{\n";

  //-- inherited prototype functions expand out to the the base version
  Func actualFunc = function->isPrototype ? node->findFunc(function->name) : function;
  
  buffer_ << "\n  //-- Declare local (parameter and temporary) variables\n";
  print_vars(buffer_, actualFunc->params, true);
  print_vars(buffer_, actualFunc->temps, false);
  print_temp_inits(actualFunc, node, builder_, buffer_); 
  buffer_ << "\n";

  buffer_ << "\n  //-- Begin function body\n";
  dmpl::madara::GAMSCompiler visitor (actualFunc, node, Func(), builder_, buffer_, false, true);

  //transform the body of safety
  BOOST_FOREACH (const Stmt & statement, actualFunc->body)
  {
    visitor.visit (statement);
  }

  buffer_ << "\n  //-- Insert return statement, in case user program did not\n";
  buffer_ << "  return Integer(0);\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- generate functions to evaluate expect specifications
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_expect_spec_definition (const Role &role)
{
  //-- collect all functions called by the expect specification
  FuncSet specFuncs;
  for(const Spec &spec : role->allSpecsInScope()) {
    ExpectSpec *es = dynamic_cast<ExpectSpec*>(spec.get());
    if(es == NULL) continue;

    for(const Func &func: role->allFuncsInScope())
      if(es->func->equalType(*func) || es->func->canCall(func, role.get()))
        specFuncs.insert(func);
  }
  
  for(const Func &func : specFuncs) build_function(role->node, func);
}

/*********************************************************************/
//-- compute priorities and criticalities of threads
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::compute_priorities ()
{
  Node &node = builder_.program.nodes.begin()->second;

  //-- assign priorities rate monotonically
  std::multimap<int,std::string> period2Func;
  BOOST_FOREACH(Funcs::value_type &f, node->funcs)
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
  BOOST_FOREACH(Funcs::value_type &f, node->funcs)
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
  BOOST_FOREACH(Funcs::value_type &f, node->funcs)
    {
      if (f.second->attrs.count("Period") == 0)
        continue;

      std::string arg = f.second->name;
      arg += ":" + std::to_string(f.second->attrs["Period"].paramList.front()->requireInt());
      arg += ":" + std::to_string(f.second->attrs["WCExecTimeOverload"].paramList.front()->requireInt());
      arg += ":" + std::to_string(f.second->attrs["WCExecTimeNominal"].paramList.front()->requireInt());
      arg += ":" + std::to_string(maxCrit + 1 - f.second->attrs["Criticality"].paramList.front()->requireInt());
      arg += ":" + std::to_string(nextPrio - funcPrios[f.second->name]);

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
  JNICreateJavaVM(&jvm, (void**)&env, &vm_args);
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

/*********************************************************************/
//-- generate the main function
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_main_function ()
{
  build_comment("//-- Helper function to convert objects to strings", "\n", "\n", 0);
  buffer_ << "template<class T> std::string to_string(const T &in)\n";
  buffer_ << "{\n";
  buffer_ << "  std::stringstream ss;\n";
  buffer_ << "  ss << in;\n";
  buffer_ << "  return ss.str();\n";
  buffer_ << "}\n";

  build_comment("//-- The main function. This is where everything starts.", "\n", "\n", 0);
  buffer_ << "int main (int argc, char ** argv)\n";
  buffer_ << "{\n";
  buffer_ << "  //-- handle any command line arguments and check their sanity\n";
  buffer_ << "  handle_arguments (argc, argv);\n";
  buffer_ << "\n";

  Node &node = builder_.program.nodes.begin()->second;
  buffer_ << "  LogAnalyzer analyzer(std::cin, knowledge);\n";

  buffer_ << "  std::cout << \"Time,Name,Node,Value\" << std::endl;\n";
  buffer_ << "  for(;;) {\n";
  buffer_ << "    engine::FunctionArguments args;\n";
  buffer_ << "    engine::Variables vars;\n";
  buffer_ << "    bool done = !analyzer.next_step();\n";
  buffer_ << "    double value = 0.0;\n";
  buffer_ << "    double total_so_far = 0.0, count_so_far = 0.0;\n";

  for(const Process &proc : builder_.program.processes) {
    for(const Spec &spec : proc.role->allSpecsInScope()) {
      AtEndSpec *aes= dynamic_cast<AtEndSpec*>(spec.get());
      if(aes) {
        buffer_ << "    id = " << proc.id << ";\n";
        buffer_ << "    value = " << nodeName(proc.role->node) << "::"
                << roleName(proc.role->node,proc.role) << "::" << aes->func->name
                << "(args,vars).to_double();\n";
        buffer_ << "    knowledge.set(\"AtEnd_RESULT." << proc.id << "."
                << aes->name << "\", value);\n";
        continue;
      }
      AtLeastSpec *als= dynamic_cast<AtLeastSpec*>(spec.get());
      if(als) {
        buffer_ << "    id = " << proc.id << ";\n";
        buffer_ << "    value = " << nodeName(proc.role->node) << "::"
                << roleName(proc.role->node,proc.role) << "::" << als->func->name
                << "(args,vars).to_double();\n";
        buffer_ << "    total_so_far = knowledge.get(\"AtLeast_TOTAL." << proc.id << "."
                << als->name << "\").to_double();\n";
        buffer_ << "    count_so_far = knowledge.get(\"AtLeast_COUNT." << proc.id << "."
                << als->name << "\").to_double();\n";
        buffer_ << "    knowledge.set(\"AtLeast_TOTAL." << proc.id << "."
                << als->name << "\", total_so_far + value);\n";
        buffer_ << "    knowledge.set(\"AtLeast_COUNT." << proc.id << "."
                << als->name << "\", count_so_far + 1);\n";
        continue;
      }
    }
  }

  buffer_ << "    if(done) break;\n";
  buffer_ << "  }\n";

  buffer_ << "  {\n";
  buffer_ << "    double value = 0.0, total = 0.0, count = 0.0;\n";
  for(const Process &proc : builder_.program.processes) {
    for(const Spec &spec : proc.role->allSpecsInScope()) {
      AtEndSpec *aes= dynamic_cast<AtEndSpec*>(spec.get());
      if(aes) {
        buffer_ << "    value = knowledge.get(\"AtEnd_RESULT." << proc.id << "."
                << aes->name << "\").to_double();\n";
        buffer_ << "    std::cout << \"AtEnd," << aes->name
                << "," << proc.id << ",\" << value << std::endl;" << std::endl;
        continue;
      }
      AtLeastSpec *als= dynamic_cast<AtLeastSpec*>(spec.get());
      if(als) {
        buffer_ << "    total = knowledge.get(\"AtLeast_TOTAL." << proc.id << "."
                << als->name << "\").to_double();\n";
        buffer_ << "    count = knowledge.get(\"AtLeast_COUNT." << proc.id << "."
                << als->name << "\").to_double();\n";
        buffer_ << "    value = (total / count) >= " << als->threshold << ";\n";
        buffer_ << "    std::cout << \"AtLeast," << als->name
                << "," << proc.id << ",\" << value << std::endl;" << std::endl;
        continue;
      }
    }
  }
  buffer_ << "  }\n";
  
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
}

/*********************************************************************/
//-- generate code to define functions within MADARA
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_main_define_functions ()
{
  buffer_ << "  //-- Defining thread functions for MADARA\n";
  for (const auto &n : builder_.program.nodes)
    for (const auto &r : n.second->roles) {
      //-- remodify role-specific input globals
      buffer_ << "  if(node_name == \"" << n.second->name << "\" && role_name == \""
              << r.second->name << "\")\n";
      buffer_ << "    knowledge.define_function (\"REMODIFY_INPUT_GLOBALS\",\n";
      buffer_ << "                                " << nodeName(n.second) << "::"
              << roleName(n.second, r.second) << "::REMODIFY_INPUT_GLOBALS";
      buffer_ << ");\n";

      //-- remodify thread-specific barriers and globals
      for (const auto &thread : r.second->threads)
        build_main_define_function (n.second, r.second, thread);
    }
  buffer_ << "\n";
}

/*********************************************************************/
//-- generate code to define a thread function within MADARA
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_main_define_function (const Node & node, const Role &role,
                                                      const Func & thread)
{
  if(role->getAttribute(thread,"BarrierSync", 0) != NULL) {
    //-- remodify barriers
    buffer_ << "  knowledge.define_function (\"" << remodifyBarriersName(node, role, thread) << "\",\n";
    buffer_ << "                              " << nodeName(node) << "::"
            << roleName(node, role) << "::REMODIFY_BARRIERS_" << thread->name;
    buffer_ << ");\n";
    
    //-- remodify globals
    buffer_ << "  knowledge.define_function (\"" << remodifyGlobalsName(node, role, thread) << "\",\n";
    buffer_ << "                              " << nodeName(node) << "::"
            << roleName(node, role) << "::REMODIFY_GLOBALS_" << thread->name;
    buffer_ << ");\n";
  }

  //-- define thread PULL function
  buffer_ << "  knowledge.define_function (\"" << funcName(node, role, thread) << "_PULL\",\n";
  buffer_ << "                              " << nodeName(node) << "::"
          << roleName(node, role) << "::thread" << thread->threadID;
  buffer_ << "_PULL);\n";

  //-- define thread PUSH function
  buffer_ << "  knowledge.define_function (\"" << funcName(node, role, thread) << "_PUSH\",\n";
  buffer_ << "                              " << nodeName(node) << "::"
          << roleName(node, role) << "::thread" << thread->threadID;
  buffer_ << "_PUSH);\n";

  //-- define thread entry function
  buffer_ << "  knowledge.define_function (\"" << funcName(node, role, thread) << "\",\n";
  buffer_ << "                              " << nodeName(node) << "::"
          << roleName(node, role) << "::thread" << thread->threadID;
  buffer_ << ");\n";
}

/*********************************************************************/
//-- clear the buffer
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::clear_buffer ()
{
  buffer_.str ("");
}

/*********************************************************************/
//-- print the buffer
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::print (std::ostream & os)
{
  os << buffer_.str ();
}

/*********************************************************************/
//-- generate code to open dmpl namespace
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::open_namespace (const std::string &ns)
{
  buffer_ << "// begin " << ns << " namespace\n";
  buffer_ << "namespace " << ns << "\n";
  buffer_ << "{\n";
}

/*********************************************************************/
//-- generate code to close dmpl namespace
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::close_namespace (const std::string &ns)
{
  buffer_ << "} // end " << ns << " namespace\n";
  buffer_ << "\n";
}
 
/*********************************************************************/
//-- Build a comment with prefix and suffix
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_comment (const std::string &comment, const std::string &prefix,
                                         const std::string &suffix, size_t indent)
{
  std::string spacer(indent, ' ');
  std::string commentMarker = "/" + std::string(68-indent,'*') + "/";
  buffer_ << prefix << spacer << commentMarker << '\n' << spacer << comment << '\n'
          << spacer << commentMarker << suffix << '\n';
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
