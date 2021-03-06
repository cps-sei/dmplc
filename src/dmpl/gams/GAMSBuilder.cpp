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

#include "GAMSBuilder.hpp"
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
    if(var->type->type == TCHAR)
      return "short";
    else
      return var->type->toString();
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
                        const dmpl::Func &thread, dmpl::DmplBuilder & builder_,
                        std::stringstream & buffer_, bool do_expect)
  {
    for(const dmpl::Var & variable : func->temps) {
      if(variable->initFunc == NULL) continue;
      
      dmpl::madara::GAMSCompiler visitor (variable->initFunc, node, thread,
                                          builder_, buffer_, do_expect, false);
      for (const dmpl::Stmt & statement : variable->initFunc->body)
        visitor.visit (statement);
    }
  }

  /*******************************************************************/
  //-- return the mission exit status variable
  /*******************************************************************/
  dmpl::Var missionExitStatus()
  {
    dmpl::Var mev(new dmpl::Variable(dmpl::missionExitStatusName));
    mev->scope = dmpl::Symbol::LOCAL; mev->type = dmpl::intType();
    return mev;
  }

  /*******************************************************************/
  //-- return the mission exit code variable
  /*******************************************************************/
  dmpl::Var missionExitCode()
  {
    dmpl::Var mev(new dmpl::Variable(dmpl::missionExitCodeName));
    mev->scope = dmpl::Symbol::LOCAL; mev->type = dmpl::intType();
    return mev;
  }
}

/*********************************************************************/
//-- constructor
/*********************************************************************/
dmpl::gams::GAMSBuilder::GAMSBuilder (dmpl::DmplBuilder & builder,
                                      const std::string &target,
                                      const int deadline,
                                      const SchedType & schedType,
                                      bool do_expect)
  : CodeGenerator(builder, target, schedType, do_expect), madara_deadline(deadline) {}

/*********************************************************************/
//-- top level code generator
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build ()
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
  build_algo_declaration ();
  build_algo_functions ();
  build_role2Id ();

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
dmpl::gams::GAMSBuilder::build_target_thunk (void)
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
dmpl::gams::GAMSBuilder::build_header_includes ()
{
  build_comment("//-- begin header files", "", "\n", 0);

  buffer_ << "#include <string>\n";
  buffer_ << "#include <vector>\n";
  buffer_ << "#include <sstream>\n";
  buffer_ << "#include <fstream>\n";
  buffer_ << "#include <exception>\n";
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
  buffer_ << "#include \"dmpl/CachedReference.hpp\"\n";
  buffer_ << "#include \"dmpl/ArrayReference.hpp\"\n";
  buffer_ << "#include \"dmpl/ProactiveStorage.hpp\"\n";
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
dmpl::gams::GAMSBuilder::build_common_global_variables ()
{
  build_comment("//-- typedefs", "\n", "", 0);
  buffer_ << "typedef   madara::knowledge::KnowledgeRecord::Integer   Integer;\n\n";

  build_comment("//-- namespace shortcuts", "", "", 0);
  buffer_ << "namespace engine = madara::knowledge;\n";
  buffer_ << "namespace threads = madara::threads;\n";
  buffer_ << "namespace containers = engine::containers;\n";
  buffer_ << "namespace controllers = gams::controllers;\n";
  buffer_ << "namespace platforms = gams::platforms;\n";
  buffer_ << "namespace variables = gams::variables;\n";
  buffer_ << "\n";

  build_comment("//-- for readability so we don't have to use full namespaces", "", "", 0);
  buffer_ << "using containers::Reference;\n";
  buffer_ << "using containers::ArrayReference;\n";
  buffer_ << "using containers::CachedReference;\n";
  buffer_ << "using containers::StorageManager::Proactive;\n";
  buffer_ << "using madara::knowledge::knowledge_cast;\n";
  buffer_ << "using madara::knowledge::KnowledgeRecord;\n";
  buffer_ << "using madara::knowledge::KnowledgeMap;\n";
  buffer_ << "\n";

  build_comment("//-- debug flag", "", "", 0);
  buffer_ << "bool debug = 0;\n";
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

  build_comment("//-- default transport variables", "", "", 0);
  buffer_ << "std::string host (\"\");\n";
  buffer_ << "std::vector<std::string> platform_params;\n";
  buffer_ << "std::string platform_name (\"debug\");\n";
  buffer_ << "typedef void (*PlatformInitFn)(const std::vector<std::string> &, engine::KnowledgeBase &, engine::KnowledgeMap &);\n";
  buffer_ << "typedef std::map<std::string, PlatformInitFn> PlatformInitFns;\n";
  buffer_ << "PlatformInitFns platform_init_fns;\n";
  buffer_ << "const std::string default_multicast (\"239.255.0.1:4150\");\n";
  buffer_ << "madara::transport::QoSTransportSettings settings;\n";
  buffer_ << "int write_fd (-1);\n";
  buffer_ << "ofstream expect_file;\n";
  buffer_ << "std::string node_name (\"none\");\n";
  buffer_ << "std::string role_name (\"none\");\n";
  buffer_ << "struct JobAbortException : public std::exception {};\n";
  buffer_ << "\n";

  build_comment("//-- Containers for commonly used global variables", "", "", 0);
  //buffer_ << "containers::IntegerArray barrier;\n";
  buffer_ << "Reference<unsigned int> id(knowledge, \".id\");\n";
  buffer_ << "Reference<unsigned int>  num_processes(knowledge, \".num_processes\");\n";
  buffer_ << "engine::KnowledgeUpdateSettings private_update (true);\n\n";

  buffer_ << "//-- used to synchronize and make sure that all nodes are up\n";
  buffer_ << "ArrayReference<unsigned int, " << numNodes () << "> startSync(knowledge, \"startSync\");\n";
  buffer_ << "Reference<unsigned int> syncPhase(knowledge, \".syncPhase\");\n\n";

  buffer_ << "KnowledgeRecord\n"
          << "sync_inputs (engine::FunctionArguments & args, engine::Variables & vars)\n"
          << "{\n"
          << "  std::string syncStr(\"REMODIFY_INPUT_GLOBALS () ; startSync.{.id} = .syncPhase\");\n"
          << "  knowledge.evaluate (syncStr);\n"
          << "  return Integer(0);\n"
          << "}\n";

  //-- define barrier variables for all synchronous threads
  build_comment("//-- barrier variables", "\n", "", 0);

  //-- collect all synchronous threads
  std::set<std::string> syncThreads;
  for (const auto &n : builder_.program.nodes) {
    for (const auto &thread : n.second->threads) {
      if(thread->getAttribute("BarrierSync", 0) == NULL) continue;
      syncThreads.insert(thread->name);
    }
    
    for (const auto &r : n.second->roles) {
      for (const auto &thread : r.second->threads) {
        if(r.second->getAttribute(thread,"BarrierSync", 0) == NULL) continue;
        syncThreads.insert(thread->name);
      }
    }
  }

  //-- generate barrier variables
  for(const std::string &st : syncThreads) {
    buffer_ << "ArrayReference<unsigned int, " << numNodes () << "> mbarrier_" << st;
    buffer_ << "(knowledge, \"mbarrier_" << st << "\");\n";
  }
  buffer_ << "\n";

  //-- declare map from synchronous thread names and node ids to ids
  //-- of the other nodes that this thread must synchronize with
  build_comment("//-- map from synchronous threads to synchronous partner node ids", "", "", 0);
  buffer_ << "std::map< std::string,std::map< size_t,std::set<size_t> > > syncPartnerIds;\n\n";
  
  //-- generate function from node ids and role names to node ids
  build_comment("//-- function from node ids and role names to node ids", "", "", 0);
  buffer_ << "size_t role2Id(size_t nodeId, const std::string &roleName);\n\n";

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
dmpl::gams::GAMSBuilder::build_program_variables ()
{
  //-- generate constants as #define statements
  build_comment("//-- Defining program-specific constants", "", "", 0);
  
  Program::ConstDef & consts = builder_.program.constDef;
  for (Program::ConstDef::const_iterator i = consts.begin (); i != consts.end (); ++i)
    buffer_ << "#define " << i->first << ' ' << i->second << '\n';

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

      //-- generate thread-read-execute-write variables
      for (const Func &thread : r.second->threads) {
        build_thread_variables(thread, thread->accessedLoc(r.second.get()), "local");
        build_thread_variables(thread, thread->accessedGlob(r.second.get()), "global");
        build_thread_variables(thread, thread->accessedGroup(r.second.get()), "group");
      }
      
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
dmpl::gams::GAMSBuilder::build_node_variables (const Node &node, const std::string &scope)
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
    build_program_variable_init (var);
  }

  //-- declare mission exit variables
  if(do_expect_ && scope == "local") {
    build_program_variable_decl (missionExitStatus());
    build_program_variable_decl (missionExitCode());
  }
}

/*********************************************************************/
//-- declare and initialize role variables. scope = local/global/group
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_role_variables (const Role &role, const std::string &scope)
{
  if(scope != "local" && scope != "global" && scope != "group")
    throw std::runtime_error("ERROR: illegal scope " + scope + " when declaring variables for role " +
                             role->name + "!!");
  
  build_comment("//-- Defining " + scope + " variables at role scope", "\n", "", 0);

  Vars & vars = (scope == "global") ? role->globVars :
    (scope == "local" ? role->locVars : role->groupVars);

  for (Vars::const_iterator i = vars.begin (); i != vars.end (); ++i) {
    const Var & var = i->second;
    if(scope != "local") var->type = var->type->incrDim(-1);
    if(var->isOverride) continue;
    build_program_variable_decl (var);
    build_program_variable_init (var);
  }
}

/*********************************************************************/
//-- declare a DMPL program specific global variable
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_program_variable_decl (const Var & var)
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
    buffer_ << "Reference<" << get_type_name(var) << "> ";
  }
  buffer_ << var->name;
  buffer_ << "(knowledge, \"";
  if(var->scope == Variable::LOCAL)
    buffer_ << ".";
  buffer_ << var->name << "\")";
  buffer_ << ";\n";
}

/*********************************************************************/
//-- initialize a DMPL program specific global variable
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_program_variable_init (const Var & var)
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

/*********************************************************************/
//-- generate network filters for MADARA
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_common_filters (void)
{
}

/*********************************************************************/
//-- generate helper function for MADARA network filters
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_common_filters_helper (
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
//-- generate shared variables for a thread. scope = local/global/group
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_thread_variables (const Func &thread, const Vars & vars,
                                                 const std::string &scope)
{
  if(scope != "local" && scope != "global" && scope != "group")
    throw std::runtime_error("ERROR: illegal scope " + scope + " when declaring variables for thread " +
                             thread->name + "!!");

  build_comment("//-- Defining " + scope + " variables at scope of thread " + thread->name +
                "\n//-- Used to implement Read-Execute-Write semantics", "\n", "", 0);
  for (auto i : vars)
    build_thread_variable (thread, i.second);

  //-- declare mission exit variable
  if(do_expect_ && scope == "local") {
    build_thread_variable (thread, missionExitStatus());
    build_thread_variable (thread, missionExitCode());
  }
}

/*********************************************************************/
//-- generate a shared variable for a thread
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_thread_variable (const Func &thread, const Var & var)
{
  // is this an array type?
  if (var->type->dims.size () >= 1)
  {
    buffer_ << "ArrayReference<Proactive<" << get_type_name(var);
    buffer_ << ", CachedReference>";
    BOOST_FOREACH(int dim, var->type->dims)
    {
      buffer_ << ", " << (dim > 0 ? dim : numNodes ());
    }
    buffer_ << "> ";
  }
  else
  {
    buffer_ << "CachedReference<" << get_type_name(var) << "> ";
  }
  buffer_ << "thread" << thread->threadID << "_" << var->name;
  buffer_ << "(knowledge, \"";
  if(var->scope == Variable::LOCAL)
    buffer_ << ".";
  buffer_ << var->name << "\")";
  buffer_ << ";\n";
}

/*********************************************************************/
//-- generate code to initialize the role2Ids map
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_init_role_id ()
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
dmpl::gams::GAMSBuilder::build_init_nodes_in_group ()
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
dmpl::gams::GAMSBuilder::build_constructors ()
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
dmpl::gams::GAMSBuilder::build_program_variable_assignment (const Var & var)
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
dmpl::gams::GAMSBuilder::build_parse_args ()
{
  //-- we use this to build up the help message
  std::stringstream variable_help;

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
  buffer_ << "    if (arg1 == \"-m\" || arg1 == \"--multicast\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = madara::transport::MULTICAST;\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-p\" || arg1 == \"--platform\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        tokenize(std::string(argv[i + 1]), platform_params, \":\");\n";
  buffer_ << "        platform_name = (platform_params[0]);\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-b\" || arg1 == \"--broadcast\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = madara::transport::BROADCAST;\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-u\" || arg1 == \"--udp\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = madara::transport::UDP;\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-o\" || arg1 == \"--host\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "        host = argv[i + 1];\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-d\" || arg1 == \"--domain\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc) {\n";
  buffer_ << "        settings.write_domain = argv[i + 1];\n";
  buffer_ << "        settings.add_read_domain(argv[i + 1]);\n";
  buffer_ << "      } else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-i\" || arg1 == \"--id\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> settings.id;\n";
  buffer_ << "        if(settings.id < 0 || settings.id >= " << numNodes () << ") {\n";
  buffer_ << "          std::cerr << \"ERROR: Invalid node id: \" << settings.id \n"
          << "                    << \"  valid range: [0, " << (numNodes () - 1)
          << "]\" << std::endl;\n";
  buffer_ << "          ::exit(1);\n";
  buffer_ << "        }\n";
  size_t procId = 0;
  for(const Process &proc : builder_.program.processes) {
    buffer_ << "        if(settings.id == " << procId << ") { node_name = \""
            << proc.getNode() << "\"; role_name = \"" << proc.getRole() << "\"; }\n";
    ++procId;
  }
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-l\" || arg1 == \"--level\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        int log_level = 0;\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> log_level;\n";
  buffer_ << "        madara::logger::global_logger->set_level(log_level);\n";
  buffer_ << "        gams::loggers::global_logger->set_level(log_level);\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
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
  //buffer_ << "        madara::transport::PacketScheduler::drop_rate_override = drop_rate;\n";
  buffer_ << "        settings.update_drop_rate (drop_rate,\n";
  buffer_ << "          madara::transport::PACKET_DROP_PROBABLISTIC);\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-e\" || arg1 == \"--expect-log\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        expect_file.open(argv[i + 1], ios::out | ios::trunc);\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-f\" || arg1 == \"--logfile\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        ::madara::logger::global_logger->clear();\n";
  buffer_ << "        ::madara::logger::global_logger->add_file(argv[i + 1]);\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-r\" || arg1 == \"--reduced\")\n";
  buffer_ << "    {\n";
  buffer_ << "      settings.send_reduced_message_header = true;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-dbg\" || arg1 == \"--debug\")\n";
  buffer_ << "    {\n";
  buffer_ << "      dmpl::debug = true;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"--write-fd\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  buffer_ << "        buffer >> write_fd;\n";
  buffer_ << "      }\n";
  buffer_ << "      else goto WRONG_ARG;\n";
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

  //-- now create parser for each variable
  for(const auto &i : inputVars) {
    buffer_ << "\n    //-- Providing init for input variable " << i.first << "\n";
    variable_help << build_parse_args (i.first, i.second);
  }

  if (false)
  {
    buffer_ << "\n    //-- Providing init for VREP variables";
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

  buffer_ << "      WRONG_ARG:\n"
          << "      std::cerr << \"Illegal argument : \" << arg1 << '\\n'" << '\n'
          << "                << \"Usage : \" << argv[0] << \" <options> <dmpl-file>\\n\"\n"
          << "                << \"Options :\\n\" <<\n"
          << "        \" [-p|--platform type]     platform for loop (vrep, dronerk)\\n\"\\\n"
          << "        \" [-b|--broadcast ip:port] the broadcast ip to send and listen to\\n\"\\\n"
          << "        \" [-d|--domain domain]     the knowledge domain to send and listen to\\n\"\\\n"
          << "        \" [-e|--expect-log file]   file to log variables related to 'expect' clauses\\n\"\\\n"
          << "        \" [-f|--logfile file]      log to a file\\n\"\\\n"
          << "        \" [-i|--id id]             the id of this agent (should be non-negative)\\n\"\\\n"
          << "        \" [-l|--level level]       the logger level (0+, higher is higher detail)\\n\"\\\n"
          << "        \" [-m|--multicast ip:port] the multicast ip to send and listen to\\n\"\\\n"
          << "        \" [-mb|--max-barrier-time time] time in seconds to barrier for other processes\\n\"\\\n"
          << "        \" [-o|--host hostname]     the hostname of this process (def:localhost)\\n\"\\\n"
          << "        \" [-r|--reduced]           use the reduced message header\\n\"\\\n"
          << "        \" [-dbg|--debug]           print debug messages\\n\"\\\n"
          << "        \" [-u|--udp ip:port]       the udp ips to send to (first is self to bind to)\\n\"\\\n";

  buffer_ << variable_help.str ();

  if (false)
  {
    buffer_ << "        \" [-vq|--vrep-quad] use Quadricopter model in VREP (default)\\n\"\\\n";
    buffer_ << "        \" [-va|--vrep-ant] use Ant model in VREP\\n\"\\\n";
    buffer_ << "        \" [-vh|--vrep-host] sets the IP address of VREP\\n\"\\\n";
    buffer_ << "        \" [-vp|--vrep-port] sets the IP port of VREP\\n\"\\\n";
  }

  buffer_ << "        ;\n";
  buffer_ << "      ::exit (1);\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n";
  buffer_ << "}\n";
  
  build_comment("//-- helper function to check validity of supplied arguments", "\n", "", 0);
  buffer_ << "void check_argument_sanity()\n";
  buffer_ << "{\n";
  for (auto & n : builder_.program.nodes) {
    for(auto & r : n.second->roles)
      buffer_ << "  if(node_name == \"" << n.second->name << "\" && role_name == \""
              << r.second->name << "\") return;\n";
  }  
  buffer_ << "  throw std::runtime_error(\"ERROR : illegal node and role combination : (\"\n"
          << "                           + node_name + \" , \" + role_name + \")\");\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- generate code to parse command line options for initializing a
//-- DMPL variable.
/*********************************************************************/
std::string
dmpl::gams::GAMSBuilder::build_parse_args (const std::string &var,
                                            const std::list<std::pair<Node,Role>> &roles)
{
  std::stringstream return_value;
  
  // we do not allow setting multi-dimensional vars from command line
  buffer_ << "    else if (arg1 == \"--var_" << var << "\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        std::stringstream buffer (argv[i + 1]);\n";
  size_t count = 0;
  for(const auto &nr : roles) {
    //-- create appropriate namespace based on variable scope
    std::string ns = nodeName(nr.first);
    if(nr.first->findVar(var) == NULL) ns += "::" + roleName(nr.first,nr.second);
    
    buffer_ << "        " << (count ? "else if" : "if")
            << "(node_name == \"" << nr.first->name << "\" && role_name == \""
            << nr.second->name << "\")\n";
    buffer_ << "          buffer >> " << ns << "::var_init_" << var << ";\n";
    count++;
  }
  buffer_ << "        else throw std::runtime_error\n"
          << "             (\"ERROR : no input variable "
          << var << " for node and role combination : (\"\n"
          << "              + node_name + \" , \" + role_name + \")\");\n";
  buffer_ << "      }\n";
  buffer_ << "      \n";
  buffer_ << "      else goto WRONG_ARG;\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  
  // build the help string
  return_value << "        \" [--var_";
  return_value << var;
  return_value << "] sets the initial value of variable " << var << "\\n\"\\\n";

  return return_value.str ();
}

/*********************************************************************/
//-- generate function declarations.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_function_declarations ()
{
  build_comment("//-- Forward declaring global functions", "", "", 0);
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    build_function_declaration (NULL, i->second);
  
  build_comment("//-- Forward declaring node and role functions", "\n", "", 0);
  Nodes & nodes = builder_.program.nodes;
  for (const auto &n : nodes)
  {
    open_namespace(nodeName(n.second));

    //-- process roles
    for(const auto &r : n.second->roles) {
      build_comment("//-- Declaring functions for role " + r.second->name, "\n", "\n", 0);
      open_namespace(roleName(n.second, r.second));

      //-- declare serial functions for the role with NULL thread.
      build_function_declarations_for_thread(Func(), r.second->serialFunctions());

      //-- declare functions for all threads
      for (Func thread : r.second->threads)
        build_function_declarations_for_thread(thread, thread->getAccessInfo(r.second.get()).calledFuncs);

      //-- declare expect thread
      if(do_expect_) build_expect_thread_declaration(r.second);
      
      close_namespace(roleName(n.second, r.second));
    }

    close_namespace(nodeName(n.second));
  }
}

/*********************************************************************/
//-- build function declarations for a thread
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_function_declarations_for_thread (const Func & thread,
                                                                 const Funcs & funcs)
{
  //-- NULL thread. needed for serial functions.
  if(thread == NULL) {
    for (auto i : funcs) build_function_declaration (thread, i.second);
    return;
  }

  //-- declare thread entry function
  build_function_declaration (thread, Func());
  
  //-- declare the thread function
  build_function_declaration (thread, thread);

  //-- declare other functions called by the thread
  for (auto i : funcs) {
    if(!thread->canCall(i.second,thread->role.get())) continue;
    
    //-- sanity check: threads cannot be called as functions
    if(i.second->isThread())
      throw std::runtime_error("ERROR: thread " + thread->name + " calls thread " +
                               i.second->name + " as a function!!");
    
    build_function_declaration (thread, i.second);
  }
}

/*********************************************************************/
//-- generate function declaration
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_function_declaration (const Func & thread, const Func & function)
{
  //-- if function is NULL, declare the thread entry function, as well
  //-- as the PULL and PUSH functions for referenced variables.
  if(function == NULL) {
    buffer_ << "KnowledgeRecord\n"
            << "thread" << thread->threadID
            << "_PULL (engine::FunctionArguments & args, engine::Variables & vars);\n";
    buffer_ << "KnowledgeRecord\n"
            << "thread" << thread->threadID
            << "_PUSH (engine::FunctionArguments & args, engine::Variables & vars);\n";
    buffer_ << "KnowledgeRecord\n"
            << "thread" << thread->threadID
            << " (engine::FunctionArguments & args, engine::Variables & vars);\n";
    return;
  }
  
  if (skip_func(function)) return;

  buffer_ << "KnowledgeRecord\n";
  if(thread) buffer_ << "thread" << thread->threadID << "_";
  else buffer_ << "base_";
  buffer_ << function->name;
  buffer_ << " (engine::FunctionArguments & args, engine::Variables & vars);\n";
}

/*********************************************************************/
//-- generate class for the expect thread
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_expect_thread_declaration (const Role &role)
{
  build_comment("//-- Thread class to monitor for expect statements", "\n", "\n", 0);
  buffer_ << "class ExpectThread : public threads::BaseThread\n";
  buffer_ << "{\n";
  buffer_ << "public:\n";
  buffer_ << "  madara::knowledge::KnowledgeBase *_knowledge;\n";
  buffer_ << "  ExpectThread (\n";
  buffer_ << "    ostream &o = std::cout\n";
  buffer_ << "  ) : out(o) {}\n";
  buffer_ << "  virtual void init (engine::KnowledgeBase & context);\n";
  buffer_ << "  virtual void run (void);\n";
  buffer_ << "  virtual void cleanup (void) {}\n";
  buffer_ << "protected:\n";
  buffer_ << "  ostream &out;\n";
  buffer_ << "};\n";
}

/*********************************************************************/
//-- generate functions and variables used to interact with GAMS
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_gams_functions ()
{
  build_comment("//-- GAMS variables and functions", "\n", "\n", 0);
  buffer_ << "#include \"dmpl/PlatformGAMS.hpp\"\n";
}

/*********************************************************************/
//-- generate functions at the global scope
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_global_functions (void)
{
  build_comment("//-- Defining global functions", "\n", "\n", 0);
  Funcs & funcs = builder_.program.funcs;
  for (Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
  {
    build_function (NULL, Node (), i->second);
  }
}

/*********************************************************************/
//-- generate code for nodes
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_nodes (void)
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

      //-- build input global modifiers
      build_refresh_modify_input_globals(n->second, r.second);
      
      //-- build global and barrier modifiers for synchronous threads
      for (Func thread : r.second->threads) {
        if(r.second->getAttribute(thread,"BarrierSync", 0) == NULL) continue;
        build_refresh_modify_globals(n->second, r.second, thread);
      }
      
      //-- build serial functions for the role with NULL thread.
      build_functions_for_thread(Func(), n->second, r.second->serialFunctions());
      
      //-- build functions for all threads
      for (Func thread : r.second->threads)
        build_functions_for_thread(thread, n->second, thread->getAccessInfo(r.second.get()).calledFuncs);

      //-- build expect thread class methods
      if(do_expect_) build_expect_thread_definition (r.second);

      //-- build constructors for the role
      build_comment("//-- Begin constructors for role " + r.second->name, "", "", 0);
      
      //-- generator constructors and initial value checkers for
      //-- variables
      for(auto &v : r.second->allVarsInScope()) build_constructor_for_variable(v, n->second);
      
      //-- generator constructors and initial value checkers for
      //-- records
      for(auto &rec : r.second->allRecordsInScope()) {
        if(rec->initFunc != NULL && !rec->initFunc->body.empty()) {
          buffer_ << "void initialize_" << rec->name << " ()\n{\n";
          buffer_ << "  engine::Variables vars;\n";
          print_vars(buffer_, rec->initFunc->temps, false);
          print_temp_inits(rec->initFunc, n->second, Func(), builder_, buffer_, do_expect_); 
          
          //-- transform statements
          dmpl::madara::GAMSCompiler visitor (rec->initFunc, n->second, Func(),
                                              builder_, buffer_, do_expect_, false);
          for (const Stmt & statement : rec->initFunc->body)
            visitor.visit (statement);
          buffer_ << "}\n";
        }
        
        if(rec->assumeFunc != NULL && !rec->assumeFunc->body.empty()) {
          buffer_ << "int check_init_" << rec->name << " ()\n{\n";
          print_vars(buffer_, rec->assumeFunc->temps, false);
          print_temp_inits(rec->assumeFunc, n->second, Func(), builder_, buffer_, do_expect_); 
        
          //-- transform statements
          dmpl::madara::GAMSCompiler visitor (rec->assumeFunc, n->second, Func(),
                                              builder_, buffer_, do_expect_, false);
          for (const Stmt & statement : rec->assumeFunc->body)
            visitor.visit (statement);
          buffer_ << "}\n";
        }
      }
      
      //-- generate the role level constructor
      buffer_ << "void constructor ()\n{\n";

      //-- sort variables and records by read-write dependency analysis
      std::map<size_t,Var> sortedVars;
      std::map<size_t,Record> sortedRecs;
      r.second->orderVarsRecords(sortedVars, sortedRecs);

      //-- invoke constructors in the computed dependency order
      for(size_t i = 0; i < sortedVars.size() + sortedRecs.size(); ++i) {
        //-- if the next one is a variable
        if(sortedVars.find(i) != sortedVars.end()) {
          const Var &var = sortedVars[i];

          if(var->isInput)
            buffer_ << "  if(!check_init_" << var->name
                    << " ()) throw std::runtime_error(\"ERROR: illegal initial value of variable "
                    << var->name << "\");\n";
          else
            buffer_ << "  initialize_" << var->name << " ();\n";
        }

        //-- if the next one is a record
        else if(sortedRecs.find(i) != sortedRecs.end()) {
          const Record &rec = sortedRecs[i];

          if(rec->initFunc != NULL && !rec->initFunc->body.empty())
            buffer_ << "  initialize_" << rec->name << " ();\n";
        
          if(rec->assumeFunc != NULL && !rec->assumeFunc->body.empty())
            buffer_ << "  if(!check_init_" << rec->name
                    << " ()) throw std::runtime_error(\"ERROR: illegal initial value of record "
                    << rec->name << "\");\n";
        }
      }
      
      //-- initialize mission exit variables
      if(do_expect_) {
        buffer_ << "  " << missionExitStatus()->name << " = 0;\n";
        buffer_ << "  " << missionExitCode()->name << " = 0;\n";
      }
      
      buffer_ << "}\n\n";
      
      close_namespace(roleName(n->second, r.second));
    }

    close_namespace(nodeName(n->second));
    build_comment("//-- End node " + n->second->name, "\n", "\n", 0);
  }

  buffer_ << "\n";
}

/*********************************************************************/
//-- generate constructor for a variable
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_constructor_for_variable (Var &v, Node &node)
{
  buffer_ << (v->isInput ? "int check_init_" : "void initialize_") << v->name << " ()\n{\n";
  buffer_ << "  engine::Variables vars;\n";
  
  //-- bind initial value for inputs
  if(v->isInput) build_program_variable_assignment(v);
  
  //-- generate constructor if one was defined
  if(v->initFunc != NULL) {
    print_vars(buffer_, v->initFunc->temps, false);
    print_temp_inits(v->initFunc, node, Func(), builder_, buffer_, do_expect_); 
    
    //-- transform statements
    dmpl::madara::GAMSCompiler visitor (v->initFunc, node, Func(),
                                        builder_, buffer_, do_expect_, false);
    for (const Stmt & statement : v->initFunc->body)
      visitor.visit (statement);
  }
  //-- if no constructor was defined and this is an input variable, return 1
  else if(v->isInput) buffer_ << "  return 1;\n";
  
  buffer_ << "}\n";
}

/*********************************************************************/
//-- generate functions that remodify input global shared variables to
//-- force retransmit by MADARA.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_refresh_modify_input_globals (const Node &node, const Role &role)
{
  build_comment("//-- Remodify input global shared variables to force MADARA retransmit", "\n", "", 0);
  buffer_ << "KnowledgeRecord\n";
  buffer_ << "REMODIFY_INPUT_GLOBALS";
  buffer_ << " (engine::FunctionArguments & args,\n";
  buffer_ << "  engine::Variables & vars)\n";
  buffer_ << "{\n";
  
  buffer_ << "  // Remodifying role-specific global and group variables\n";
  for(const auto &gv : role->allVarsInScope())
    if(gv->isInput && (gv->scope == Symbol::GLOBAL || gv->scope == Symbol::GROUP))
      build_refresh_modify_global (node, gv);
    
  buffer_ << "  return Integer (0);\n";
  buffer_ << "}\n";
}

/*********************************************************************/
//-- generate functions that remodify global shared and barrier
//-- variables to force retransmit by MADARA.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_refresh_modify_globals (const Node &node, const Role &role,
                                                        const Func &thread)
{
  build_comment("//-- Remodify barries variables to force MADARA retransmit", "\n", "", 0);
  buffer_ << "KnowledgeRecord\n";
  buffer_ << "REMODIFY_BARRIERS_" << thread->name;
  buffer_ << " (engine::FunctionArguments &,\n";
  buffer_ << "  engine::Variables & vars)\n";
  buffer_ << "{\n";
  buffer_ << "  mark_modified(mbarrier_" << thread->name << "[id]);\n";
  buffer_ << "  return Integer (0);\n";
  buffer_ << "}\n";

  build_comment("//-- Remodify global shared variables to force MADARA retransmit", "\n", "", 0);
  buffer_ << "KnowledgeRecord\n";
  buffer_ << "REMODIFY_GLOBALS_" << thread->name;
  buffer_ << " (engine::FunctionArguments & args,\n";
  buffer_ << "  engine::Variables & vars)\n";
  buffer_ << "{\n";
  
  buffer_ << "  // Remodifying common global variables\n";
  buffer_ << "  REMODIFY_BARRIERS_" << thread->name << " (args, vars);\n";
  //buffer_ << "  barrier.set (*id, barrier[*id]);\n\n";

  buffer_ << "  // Remodifying thread-specific global variables\n";
  for(const auto &gv : thread->getAccessInfo(role.get()).writesGlob)
    build_refresh_modify_global (node, gv.second);

  buffer_ << "  // Remodifying thread-specific group variables\n";
  for(const auto &gv : thread->getAccessInfo(role.get()).writesGroup)
    build_refresh_modify_global (node, gv.second);
    
  buffer_ << "  return Integer (0);\n";
  buffer_ << "}\n";
}

/*********************************************************************/
//-- generate functions that remodifies a global shared variable to
//-- force retransmit by MADARA.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_refresh_modify_global (const Node &node, const Var & var)
{
  if (var->scope == Variable::GLOBAL || var->scope == Variable::GROUP)
  {
    buffer_ << "  mark_modified(" << var->name << "[id]);\n";
  }
  else
  {
    throw std::runtime_error("ERROR: cannot modify non-global/group variable " + var->name + "!!");
    buffer_ << "  mark_modified(" << var->name << ")";
  }
}

/*********************************************************************/
//-- generate code to pull/push all necessary variables at the
//-- start/end of each thread function (i.e., job)
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_push_pull(const Func &thread, bool push)
{
  buffer_ << "  //-- " << (push?"Push":"Pull") << " all referenced locals/globals\n";
  buffer_ << "  {\n";
  buffer_ << "    madara::knowledge::ContextGuard guard(knowledge);\n";

  //push-pull locals
  for(const auto &var : thread->accessedLoc(thread->role.get())) {
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << var.first << ");" << std::endl;
  }

  //-- push-pull mission exit variables
  if(do_expect_) {
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << missionExitStatus()->name << ");" << std::endl;
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << missionExitCode()->name << ");" << std::endl;
  }

  //push-pull globals
  for(const auto &var : thread->accessedGlob(thread->role.get())) {
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << var.first << (push?"[id]":"") << ");" << std::endl;
  }

  //push-pull group variables
  for(const auto &var : thread->accessedGroup(thread->role.get())) {
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << var.first << (push?"[id]":"") << ");" << std::endl;
  }

  buffer_ << "  }\n";
}

/*********************************************************************/
//-- generate code for all functions specific to a thread
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_functions_for_thread (
  const Func& thread, const dmpl::Node & node, const dmpl::Funcs & funcs)
{
  //-- NULL thread. needed for serial functions.
  if(thread == NULL) {
    for(const auto &f : funcs) build_function (thread, node, f.second);
    return;
  }
  
  //-- generate the thread entry function
  build_function (thread, node, Func());

  //-- generate the thread function
  build_function (thread, node, thread);

  //-- generate other functions called by the thread
  for(const auto &f : funcs) {
    if(thread->canCall(f.second,thread->role.get()))
      build_function (thread, node, f.second);
  }
}
 
/*********************************************************************/
//-- generate code for a function
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_function (
  const Func& thread, const dmpl::Node & node, const dmpl::Func & function)
{
  if (function != NULL && skip_func(function)) return;

  //-- if we are generating the thread entry function, then generate
  //-- the PULL and PUSH functions as well
  if(function == NULL) {
    buffer_ << "KnowledgeRecord\n";
    buffer_ << "thread" << thread->threadID;
    buffer_ << "_PULL (engine::FunctionArguments & args, engine::Variables & vars)\n";
    buffer_ << "{\n";
    build_push_pull(thread, false);
    buffer_ << "  return Integer(0);\n";
    buffer_ << "}\n\n";
    buffer_ << "KnowledgeRecord\n";
    buffer_ << "thread" << thread->threadID;
    buffer_ << "_PUSH (engine::FunctionArguments & args, engine::Variables & vars)\n";
    buffer_ << "{\n";
    build_push_pull(thread, true);
    buffer_ << "  return Integer(0);\n";
    buffer_ << "}\n\n";
  }

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
  if(function == NULL) {
    buffer_ << "thread" << thread->threadID;
  } else {
    if(thread) buffer_ << "thread" << thread->threadID << "_";
    else buffer_ << "base_";
    buffer_ << function->name;
  }
  buffer_ << " (engine::FunctionArguments & args, engine::Variables & vars)\n";
  buffer_ << "{\n";

  //-- if function is NULL, generate the thread entry function
  if(function == NULL) {
    //-- check mission exit status. if set, return.
    if(do_expect_) {
      buffer_ << "  //-- check mission exit status\n";
      buffer_ << "  if (" << missionExitStatus()->name << " != 0) return Integer(0);\n\n";
    }
    
    //-- call main thread function
    buffer_ << "  //-- call thread function\n";
    buffer_ << "  try {\n";
    buffer_ << "    thread" << thread->threadID << "_";
    buffer_ << thread->name << "(args, vars);\n";
    buffer_ << "  } catch (JobAbortException &ex) {}\n\n";

    //-- dummy return statement
    buffer_ << "  return Integer(0);\n";
    buffer_ << "}\n\n";
    return;
  }

  //-- inherited prototype functions expand out to the the base version
  Func actualFunc = function->isPrototype ? node->findFunc(function->name) : function;
  
  buffer_ << "\n  //-- Declare local (parameter and temporary) variables\n";
  print_vars(buffer_, actualFunc->params, true);
  print_vars(buffer_, actualFunc->temps, false);
  print_temp_inits(actualFunc, node, thread, builder_, buffer_, do_expect_); 
  buffer_ << "\n";

  buffer_ << "\n  //-- Begin function body\n";
  dmpl::madara::GAMSCompiler visitor (actualFunc, node, thread, builder_, buffer_, do_expect_, false);

  //transform the body of safety
  BOOST_FOREACH (const Stmt & statement, actualFunc->body)
  {
    visitor.visit (statement);
  }

  //-- record the set of referred roles
  if(!visitor.refRoles.empty()) {
    if(thread->role == NULL)
      throw std::runtime_error("ERROR: non-role thread " + thread->name + " in node " +
                               node->name + " refers to role " + (*visitor.refRoles.begin()));
    rolesRefRoles[thread->role->name].insert(visitor.refRoles.begin(), visitor.refRoles.end());
  }

  buffer_ << "\n  //-- Insert return statement, in case user program did not\n";
  buffer_ << "  return Integer(0);\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- generate methods of expect thread
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_expect_thread_definition (const Role &role)
{
  build_comment("//-- Methods for thread class to monitor for expect statements", "\n", "\n", 0);

  //-- generate function run once for initialization
  buffer_ << "void ExpectThread::init (engine::KnowledgeBase & context)\n";
  buffer_ << "{\n";
  buffer_ << "  _knowledge = &context;\n";
  buffer_ << "  out << \"Seconds,Micros,Node,At,Variable,Value\" << std::endl;\n";
  buffer_ << "}\n";
  buffer_ << "\n";

  //-- generate function run periodically
  buffer_ << "void ExpectThread::run (void)\n";
  buffer_ << "{\n";
  buffer_ << "  timeval tv;\n";
  buffer_ << "  if(gettimeofday(&tv, NULL) != 0) {\n";
  buffer_ << "    tv.tv_sec = 0;\n";
  buffer_ << "    tv.tv_usec = 0;\n";
  buffer_ << "  }\n";

  buffer_ << "  {\n";
  buffer_ << "    madara::knowledge::ContextGuard guard(knowledge);\n";

  //-- process all expect specs to compute the set of variables used by them
  VarSet expectVars;
  for(const Spec &spec : role->allSpecsInScope()) {
    //-- skip non-expect specifications
    ExpectSpec *esp = dynamic_cast<ExpectSpec*>(spec.get());
    if(esp == NULL) continue;

    //-- process all variables
    AccessInfo accInfo = esp->computeAccessInfo(role);
    for(const auto &var : accInfo.reads()) expectVars.insert(var.second);
    for(const auto &var : accInfo.writes()) expectVars.insert(var.second);
  }
  
  //-- dump variables used by expect specs
  for(const Var &var : expectVars) {
    //-- get the namespace
    std::string ns = "::dmpl::" + nodeName(role->node) + "::";
    if(!role->node->hasVar(var)) ns += roleName(role->node, role) + "::";
    
    //-- dump local variable
    if(var->scope == Variable::LOCAL) {
      if(var->type->dims.size() != 0) continue;
      buffer_ << "    out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << id << \",\";\n";
      buffer_ << "    out << \"." << var->getName() << ",\" << " << ns << var->getName() << ";\n";
      buffer_ << "    out << std::endl;\n";
      continue;
    }

    //-- dump global and group variables. we only dump for the indices
    //-- correspondig to other nodes that can overlap with this node
    //-- via this variable.
    if(var->type->dims.size() != 1) continue;
    for(const Process &proc : builder_.program.procsWithRole(role->name)) {
      buffer_ << "    if (settings.id == " << proc.id << ") {\n";

      std::set<dmpl::NodeId> on = builder_.program.overlappingNodes(proc, var->name);
      on.insert(proc.id);
      
      for(dmpl::NodeId i : on) {
        buffer_ << "      out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << "
                << i << " << \",\";\n";
        buffer_ << "      out << \"" << var->getName() << ",\" << " << ns << var->getName() << "[" << i << "];\n";
        buffer_ << "      out << std::endl;\n";
      }
      buffer_ << "    }\n";
    }
  }
  
  //-- dump pure extern functions with no arguments used by expect specs
  BOOST_FOREACH(Funcs::value_type &it, builder_.program.funcs)
  {
    Func func = it.second;
    if(!func->isExtern || func->params.size() > 0 || func->retType->type == TVOID)
      continue;

    //-- check if function called by expect spec
    bool usedExpect = false;
    for(const Spec &spec : role->allSpecsInScope()) {
      ExpectSpec *esp = dynamic_cast<ExpectSpec*>(spec.get());
      if(esp == NULL) continue;

      //-- find the appropriate expect function for this role
      AccessInfo accInfo = esp->computeAccessInfo(role);

      //std::cout << "role : " << role->name << " spec : " << spec->name << " funcs : ";
      //for(const auto &f : accInfo.calledFuncs) std::cout << f.second->name << ' ';
      //std::cout << '\n';
      
      if(accInfo.canCall(func)) { usedExpect = true; break; }
    }

    //-- skip functions not called by expect spec
    if(!usedExpect) continue;
      
    //std::cerr << "External Function: " << func->getName() << std::endl;
    //std::cerr << "  usage_summary: " << func->usage_summary << std::endl;
    //std::cerr << "  expect: " << func->usage_summary.anyExpect() << std::endl;
    buffer_ << "    out << tv.tv_sec << \",\" << tv.tv_usec << \",\" << id << \",\" << id << \",\";\n";
    buffer_ << "    out << \"EXTERN_" << func->getName() << ",\" << ::" << func->getName() << "();\n";
    buffer_ << "    out << std::endl;\n";
  }

  //-- check if mission ended
  buffer_ << "    if(" << nodeName(role->node) << "::" << missionExitStatus()->name
          << " != 0) {\n";
  buffer_ << "      std::cerr << \"expect logger: node \" << id << \" exited mission with code \" << "
          << nodeName(role->node) << "::" << missionExitCode()->name << " << '\\n';\n";
  buffer_ << "      ::exit (0);\n";
  buffer_ << "    }\n";
  
  
  buffer_ << "  }\n";
  buffer_ << "}\n";
  buffer_ << "\n";
}

/*********************************************************************/
//-- generate algorithm and synchronous algorithm classes.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_algo_declaration ()
{
  build_comment("//-- Class that encapsulates a periodic thread", "", "\n", 0);
  buffer_ << "class Algo : public gams::algorithms::BaseAlgorithm, protected threads::BaseThread\n";
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
  buffer_ << "    madara::knowledge::KnowledgeBase * knowledge = 0,\n";
  buffer_ << "    const std::string &platform_name = \"\",\n";
  buffer_ << "    const engine::KnowledgeMap *platform_args = NULL,\n";
  buffer_ << "    variables::Sensors * sensors = 0,\n";
  buffer_ << "    variables::Self * self = 0);\n";
  buffer_ << "  ~Algo (void);\n";

  buffer_ << "  virtual int analyze (void);\n";
  buffer_ << "  virtual int plan (void);\n";
  buffer_ << "  virtual int execute (void);\n";

  buffer_ << "  virtual void init (engine::KnowledgeBase & context);\n";
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

  buffer_ << "  controllers::BaseController loop;\n";
  buffer_ << "  engine::KnowledgeBase *knowledge_;\n";
  buffer_ << "  std::string _exec_func, _platform_name;\n";
  buffer_ << "  const engine::KnowledgeMap *_platform_args;\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "  int sched; //-- the ZSRM scheduler handle\n";
    buffer_ << "  int rid;   //-- the ZSRM reservation id\n";
  }
#endif

  buffer_ << "};\n";

  build_comment("//-- Class that encapsulates a synchronous periodic thread", "\n", "\n", 0);
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
  buffer_ << "    const std::string &thread_name,\n";
  buffer_ << "    madara::knowledge::KnowledgeBase * knowledge = 0,\n";
  buffer_ << "    const std::string &platform_name = \"\",\n";
  buffer_ << "    const engine::KnowledgeMap *platform_args = NULL,\n";
  buffer_ << "    variables::Sensors * sensors = 0,\n";
  buffer_ << "    variables::Self * self = 0);\n";
  buffer_ << "  ~SyncAlgo (void);\n";
  buffer_ << "  virtual int analyze (void);\n";
  buffer_ << "  virtual int plan (void);\n";
  buffer_ << "  virtual int execute (void);\n";

  buffer_ << "  virtual void init (engine::KnowledgeBase & context);\n";
  buffer_ << "  virtual void run (void);\n";
  buffer_ << "  virtual void cleanup (void);\n";
  buffer_ << "protected:\n";
  buffer_ << "  int phase;\n";
  buffer_ << "  std::string mbarrier;\n";
  buffer_ << "  madara::knowledge::WaitSettings wait_settings;\n";
  buffer_ << "  engine::CompiledExpression round_logic;\n";
  buffer_ << "  std::stringstream barrier_data_string;\n";
  buffer_ << "  engine::CompiledExpression barrier_data_logic;\n";
  buffer_ << "};\n";
  buffer_ << "\n";
}

/*********************************************************************/
//-- generate algorithm and synchronous algorithm class methods.
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_algo_functions ()
{
  build_comment("//-- Begin Algo class methods", "\n", "\n", 0);

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
  buffer_ << "    madara::knowledge::KnowledgeBase * knowledge,\n";
  buffer_ << "    const std::string &platform_name,\n";
  buffer_ << "    const engine::KnowledgeMap *platform_args,\n";
  buffer_ << "    variables::Sensors * sensors,\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "    variables::Self * self) : sched(0), rid(0),\n";
    buffer_ << "      loop(*knowledge), _platform_name(platform_name), _platform_args(platform_args),\n";
  }
  else
#endif
  {
    buffer_ << "    variables::Self * self) : loop(*knowledge),\n";
    buffer_ << "      _platform_name(platform_name), _platform_args(platform_args),\n";
  }

  buffer_ << "      BaseAlgorithm (knowledge, 0, sensors, self), knowledge_(knowledge),\n";

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

  buffer_ << "void Algo::init (engine::KnowledgeBase & context)\n";
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
  buffer_ << "  loop.init_platform (_platform_name, *_platform_args);\n";
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
  buffer_ << "  if (dmpl::debug)\n";
  buffer_ << "    std::cout << \"Executing thread: \" << _exec_func << \" at period \" << _period << \" us\" << std::endl;\n";
  buffer_ << "  knowledge_->evaluate (_exec_func + \"_PULL ()\");\n";
  buffer_ << "  knowledge_->evaluate (_exec_func + \"()\");\n";
  buffer_ << "  knowledge_->evaluate (_exec_func + \"_PUSH ()\");\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";

  build_comment("//-- End Algo class methods", "\n", "\n", 0);

  build_comment("//-- Begin SyncAlgo class methods", "", "\n", 0);
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
  buffer_ << "    const std::string &thread_name,\n";
  buffer_ << "    madara::knowledge::KnowledgeBase * knowledge,\n";
  buffer_ << "    const std::string &platform_name,\n";
  buffer_ << "    const engine::KnowledgeMap *platform_args,\n";
  buffer_ << "    variables::Sensors * sensors,\n";
  buffer_ << "    variables::Self * self) : phase(0), mbarrier(\"mbarrier_\" + thread_name),\n";

#if USE_MZSRM==1
  if(schedType_ == MZSRM) {
    buffer_ << "      Algo (period, priority, criticality, zsinst,\n";
    buffer_ << "            exec_func, knowledge, platform_name, platform_args, sensors, self)\n";
  }
  else
#endif
  {
    buffer_ << "      Algo (period, exec_func, knowledge, platform_name, platform_args, sensors, self)\n";
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

  buffer_ << "void SyncAlgo::init (engine::KnowledgeBase & context)\n";
  buffer_ << "{\n";
  //
  // build the barrier string  
  buffer_ << "  bool started = false;\n\n";

  buffer_ << "  barrier_data_string << _exec_func << \"_REMODIFY_GLOBALS () ;> \";\n";
  buffer_ << "  // create barrier check for partner ids\n";
  buffer_ << "  for (size_t i : syncPartnerIds[_exec_func][settings.id])\n";
  buffer_ << "  {\n";
  buffer_ << "    if (started)\n";
  buffer_ << "    {\n";
  buffer_ << "      barrier_data_string << \" && \";\n";
  buffer_ << "    }\n\n";

  buffer_ << "    barrier_data_string << \"\" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << i;\n";
  buffer_ << "    barrier_data_string << \" >= \" + mbarrier + \".\";\n";
  buffer_ << "    barrier_data_string << settings.id;\n";
  buffer_ << "    if (!started)\n";
  buffer_ << "      started = true;\n";
  buffer_ << "  }\n\n";

  buffer_ << "  // take care of the case when there are no partner ids\n";
  buffer_ << "  if (syncPartnerIds[_exec_func][settings.id].empty()) {\n"
          << "    barrier_data_string << \"1\";\n"
          << "  }\n\n";

  buffer_ << "  // Compile frequently used expressions\n";
  buffer_ << "  barrier_data_logic = knowledge_->compile (barrier_data_string.str ());\n";

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
  buffer_ << "      // Execute main user logic \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = true; \n";
  buffer_ << "      knowledge_->evaluate (_exec_func + \"_PULL ()\", wait_settings); \n";

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
  buffer_ << "      wait_settings.send_list.clear (); \n";
  buffer_ << "      wait_settings.delay_sending_modifieds = false; \n";
  buffer_ << "      if(knowledge_->evaluate (barrier_data_logic, wait_settings).to_integer()) {\n";
  buffer_ << "        wait_settings.delay_sending_modifieds = true; \n";
  buffer_ << "        knowledge_->evaluate (_exec_func + \"_PUSH ()\", wait_settings); \n";
  buffer_ << "        phase = 0;\n";
  buffer_ << "      }\n";
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
  buffer_ << "  if (dmpl::debug)\n";
  buffer_ << "    std::cout << \"Executing thread: \" << _exec_func << \" at period \" << _period << \" us\" << std::endl;\n";
  buffer_ << "  knowledge_->evaluate (round_logic, wait_settings);\n";
  buffer_ << "  return 0;\n";
  buffer_ << "}\n";

  build_comment("//-- End SyncAlgo class methods", "\n", "", 0);
}

/*********************************************************************/
//-- generate the role2Id function
/*********************************************************************/
void dmpl::gams::GAMSBuilder::build_role2Id ()
{
  buffer_ << "size_t role2Id(size_t nodeId, const std::string &roleName)\n";
  buffer_ << "{\n";
  const Program &prog = builder_.program;
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

        buffer_ << "  if(nodeId == " << proc.id << " && roleName == \"" << rp << "\") return "
                << refProcs.begin()->id << ";\n";
      }
    }
  }
  buffer_ << "  throw std::runtime_error(\"ERROR: role2Id called with illegal arguments \""
          << " + std::to_string(nodeId) + \" and \" + roleName + \"!!\");\n";
  buffer_ << "}\n\n";
}

/*********************************************************************/
//-- compute priorities and criticalities of threads
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::compute_priorities ()
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
dmpl::gams::GAMSBuilder::build_main_function ()
{
  build_comment("//-- Helper function to convert objects to strings", "\n", "\n", 0);
  buffer_ << "template<class T> std::string to_string(const T &in)\n";
  buffer_ << "{\n";
  buffer_ << "  std::stringstream ss;\n";
  buffer_ << "  ss << in;\n";
  buffer_ << "  return ss.str();\n";
  buffer_ << "}\n";

  build_comment("//-- Initialize VREP", "\n", "\n", 0);
  buffer_ << "void init_vrep(const std::vector<std::string> &params, engine::KnowledgeBase &knowledge, engine::KnowledgeMap &platform_args)\n";
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
  buffer_ << "    knowledge.set(\".vrep_max_delta\", params[4]);\n";
  buffer_ << "  else\n";
  buffer_ << "    knowledge.set(\".vrep_max_delta\", 0.4);\n";

  buffer_ << "  if(params.size() >= 6 && params[5].size() > 0)\n";
  buffer_ << "    platform_args[\"resource_dir\"] = params[5];\n";

  buffer_ << "  knowledge.set(\".vrep_max_rotate_delta\", M_PI/32.0);\n";
  buffer_ << "  knowledge.set(\".vrep_move_thread_rate\", \"0\");\n";
  buffer_ << "  knowledge.set(\"vrep_ready\", \"1\");\n";
  buffer_ << "}\n";

  build_comment("//-- The main function. This is where everything starts.", "\n", "\n", 0);
  buffer_ << "int main (int argc, char ** argv)\n";
  buffer_ << "{\n";
  //buffer_ << "  madara::utility::set_log_level(madara::utility::LOG_DETAILED_TRACE);\n";
  //buffer_ << "  madara::utility::set_log_level(madara::utility::LOG_MAJOR_DEBUG_INFO);\n";
  buffer_ << "  settings.type = madara::transport::MULTICAST;\n";
  //buffer_ << "  settings.type = madara::transport::BROADCAST;\n";
  buffer_ << "  platform_init_fns[\"vrep\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-uav\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-quad\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-heli\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-ant\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-uav-laser\"] = init_vrep;\n";
  buffer_ << "  platform_init_fns[\"vrep-quad-laser\"] = init_vrep;\n";
  buffer_ << "\n";
  buffer_ << "  //-- handle any command line arguments and check their sanity\n";
  buffer_ << "  handle_arguments (argc, argv);\n";
  buffer_ << "  check_argument_sanity ();\n";
  buffer_ << "\n";
  buffer_ << "  if (settings.hosts.size () == 0)\n";
  buffer_ << "  {\n";
  buffer_ << "    //-- setup default transport as multicast\n";
  buffer_ << "    settings.hosts.push_back (default_multicast);\n";
  //buffer_ << "    settings.hosts.push_back (\"127.0.0.1:4150\");\n";
  buffer_ << "    if (dmpl::debug) {\n";
  buffer_ << "      settings.add_receive_filter (madara::filters::log_aggregate);\n";
  buffer_ << "      settings.add_send_filter (madara::filters::log_aggregate);\n";
  buffer_ << "    }\n";
  buffer_ << "  }\n\n";
  
  buffer_ << "  settings.queue_length = 1000000;\n";
  if(madara_deadline >= 0)
    buffer_ << "  settings.set_deadline(" << madara_deadline << ");\n\n";

  buffer_ << "  //-- configure the knowledge base with the transport settings\n";
  buffer_ << "  knowledge.attach_transport(host, settings);\n\n";

  // set the values for id and processes
  buffer_ << "  //-- Initialize commonly used local variables\n";  
  buffer_ << "  id = settings.id;\n";
  buffer_ << "  num_processes = processes;\n";
  buffer_ << "\n";

  build_constructors ();
  build_main_define_functions ();

  buffer_ << "  //-- Synchronize to make sure all nodes are up\n";
  buffer_ << "  knowledge.define_function (\"sync_inputs\", dmpl::sync_inputs);\n"
          << "  threads::Threader threader(knowledge);\n"
          << "  Algo *syncInputsAlgo = new Algo(1000000, \"sync_inputs\", &knowledge);\n"
          << "  syncInputsAlgo->start(threader);\n"
          << "  {\n"
          << "    syncPhase = 1;\n"
          << "    for(;;) {\n"
          << "      size_t flag = 1;\n"
          << "      for(size_t i = 0;i < " << numNodes() << "; ++i)\n"
          << "        if(startSync[i] < syncPhase) { flag = 0; break; }\n"
          << "      if(flag) break;\n"
          << "      sleep(0.2);\n"
          << "    }\n"
          << "    syncPhase = 2;\n"
          << "    for(;;) {\n"
          << "      size_t flag = 1;\n"
          << "      for(size_t i = 0;i < " << numNodes() << "; ++i)\n"
          << "        if(startSync[i] < syncPhase) { flag = 0; break; }\n"
          << "      if(flag) break;\n"
          << "      sleep(0.2);\n"
          << "    }\n"
          << "  }\n\n";
  
  buffer_ << "  //-- Initializing platform\n";
  buffer_ << "  engine::KnowledgeMap platform_args;\n";
  buffer_ << "  PlatformInitFns::iterator init_fn = platform_init_fns.find(platform_name);\n";
  buffer_ << "  if(init_fn != platform_init_fns.end())\n";
  buffer_ << "    init_fn->second(platform_params, knowledge, platform_args);\n";
  buffer_ << "  else\n";
  buffer_ << "    init_vrep(platform_params, knowledge, platform_args);\n";

  //-- generate simulation initialization
  buffer_ << "\n  //-- Initializing simulation\n";
  for (const auto &n : builder_.program.nodes) {
    for (const auto &r : n.second->roles) {
      buffer_ << "  if(node_name == \"" << n.second->name << "\" && role_name == \""
              << r.second->name << "\") {\n";
      Func platInit = r.second->findPlatformInitializer();

      if(platInit == NULL)
        throw std::runtime_error("ERROR: role " + r.second->name + " in node " +
                                 n.second->name + " has no platform initializer function!!");

      buffer_ << "    knowledge.define_function (\"initialize_platform\", "
              << nodeName(n.second) << "::" << roleName(n.second, r.second)
              << "::base_" << platInit->name << ");\n";

      buffer_ << "  }\n";
    }
  }
  buffer_ << "  knowledge.evaluate(\"initialize_platform ()\");\n";
  //buffer_ << "  knowledge.set(\"S\" + to_string(settings.id) + \".init\", \"1\");\n";

  buffer_ << "\n  //-- Creating algorithms\n";
  buffer_ << "  std::vector<Algo *> algos;\n";
  buffer_ << "  Algo *algo;\n";
  if(do_expect_) buffer_ << "  threads::BaseThread *expect_thread = NULL;\n";

  for (const auto &n : builder_.program.nodes)
    for (const auto &r : n.second->roles)
      build_algo_creation(n.second, r.second);
  
  buffer_ << "\n  //-- start threads and simulation\n";
  buffer_ << "  for(int i = 0; i < algos.size(); i++)\n";
  buffer_ << "    algos[i]->start(threader);\n";
  
  buffer_ << "  std::stringstream buffer;\n";
  buffer_ << "  buffer << \"(vrep_ready = 1) && (S\" << id << \".init = S\" << id << \".init) && S0.init\";\n";
  buffer_ << "  for(unsigned int i = 1; i < num_processes; ++i)\n";
  buffer_ << "    buffer << \" && S\" << i << \".init\";\n";
  buffer_ << "  std::string expression = buffer.str ();\n";
  buffer_ << "  madara::knowledge::CompiledExpression compiled;\n";
  buffer_ << "  compiled = knowledge.compile (expression);\n";
  buffer_ << "  std::cerr << \"waiting for \" << num_processes << \" agent(s) to come online...\" << std::endl;\n";
  buffer_ << "  knowledge.wait (compiled);\n";
  buffer_ << "\n";

  buffer_ << "  knowledge.set(\"begin_sim\", \"1\");\n";

  buffer_ << "  std::cerr << \"*** AGENT \" << id << \" READY ***\" << std::endl;\n";
  
  if(do_expect_)
    buffer_ << "  if(expect_thread) threader.run(5.0, \"expect_thread\", expect_thread);\n";

  buffer_ << "\n  //-- wait for all threads to terminate\n";
  buffer_ << "  threader.wait();\n";

  buffer_ << "  return 0;\n";
  buffer_ << "}\n";
}

/*********************************************************************/
//-- generate code to create functions for a role
/*********************************************************************/
void dmpl::gams::GAMSBuilder::build_algo_creation (const Node &node, const Role &role)
{
  buffer_ << "  if(node_name == \"" << node->name << "\" && role_name == \""
          << role->name << "\") {\n";

  //-- initialize synchronization partners
  Program &prog = builder_.program;
  //-- consider all processes that can instantiate this role
  for(const Process &proc : prog.procsWithRole(role->name)) {
    //-- consider all threads
    for(const auto &thread : role->threads) {
      //-- skip asynchronous threads
      const Attribute *syncAttr = role->getAttribute(thread, "BarrierSync", 0);      
      if(!syncAttr) continue;

      //-- compute the set of all nodes that overlap via global and
      //-- group vars
      std::set<NodeId> on;
      for(const auto &v : thread->accessedGlob(role.get())) {
        std::set<NodeId> onv = prog.overlappingNodes(proc, v.first);
        on.insert(onv.begin(), onv.end());
      }
      for(const auto &v : thread->accessedGroup(role.get())) {
        std::set<NodeId> onv = prog.overlappingNodes(proc, v.first);
        on.insert(onv.begin(), onv.end());
      }
      on.erase(proc.id);

      if(on.empty())
        std::cerr << "WARNING: synchronous thread " << thread->name
                  << " in role " << role->name << " in node " << node->name
                  << " does not synchronize with any other node!!\n";
      
      buffer_ << "    syncPartnerIds[\"" << funcName(node, role, thread) << "\"][" << proc.id << "] = {";
      size_t start = 0;
      for(NodeId i : on) buffer_ << (start++ ? "," : "") << i;
      buffer_ << "};\n";
    }
  }
  
  Func platformFunction;
  for(const auto &thread : role->threads) {
    const Attribute *periodAttr = role->getAttribute(thread, "Period", 1);
    if(!periodAttr)
      throw std::runtime_error("ERROR: thread " + thread->name + " in role " + role->name +
                               " in node " + node->name + " has no period!!");
    int period = periodAttr->paramList.front()->requireInt();
    
#if USE_MZSRM==1
    //-- get the priority, criticality, and zero slack instant
    unsigned priority = funcPrios[thread->name];
    unsigned criticality = funcCrits[thread->name];
    unsigned zsinst = funcZsinsts[thread->name];
#endif
    
    const Attribute *contAttr = role->getAttribute(thread, "PlatformController", 0);
    if(contAttr) {
      if (platformFunction == NULL) platformFunction = thread;
      else
        throw std::runtime_error("ERROR: threads " + thread->name + " and " + platformFunction->name +
                                 " in role " + role->name + " in node " + node->name +
                                 " both have PlatformController attributes!!");
    }
    
    const Attribute *syncAttr = role->getAttribute(thread, "BarrierSync", 0);
    //-- for synchronous function
    if(syncAttr) {
#if USE_MZSRM==1
      if(schedType_ == MZSRM) {
        if (platformFunction == thread)
          buffer_ << "    algo = new SyncAlgo("
                  << period << ", " << priority << ", " 
                  << criticality << ", " << zsinst << ", \"" << funcName(node, role, thread)
                  << "\", \"" << thread->name 
                  << "\", &knowledge, platform_name, &platform_args);\n";
        else
          buffer_ << "    algo = new SyncAlgo("
                  << period << ", " << priority << ", " 
                  << criticality << ", " << zsinst << ", \"" << funcName(node, role, thread)
                  << "\", \"" << thread->name 
                  << "\", &knowledge);\n";
      }
      else
#endif
        {
          if (platformFunction == thread)
            buffer_ << "    algo = new SyncAlgo(" << period << ", \"" << funcName(node, role, thread)
                    << "\", \"" << thread->name 
                    << "\", &knowledge, platform_name, &platform_args);\n";
          else
            buffer_ << "    algo = new SyncAlgo(" << period << ", \"" << funcName(node, role, thread)
                    << "\", \"" << thread->name 
                    << "\", &knowledge);\n";
        }
    }
    //-- for asynchronous function
    else {
#if USE_MZSRM==1
      if(schedType_ == MZSRM) {
        if (platformFunction == thread)
          buffer_ << "    algo = new Algo(" << period << ", " 
                  << period << ", " << priority << ", " 
                  << criticality << ", " << zsinst << ", \"" << funcName(node, role, thread)
                  << "\", &knowledge, platform_name, &platform_args);\n";
        else
          buffer_ << "    algo = new Algo(" << period << ", "
                  << period << ", " << priority << ", " 
                  << criticality << ", " << zsinst << ", \"" << funcName(node, role, thread)
                  << "\", &knowledge);\n";
      }
      else
#endif
        {
          if (platformFunction == thread)
            buffer_ << "    algo = new Algo(" << period << ", \"" << funcName(node, role, thread)
                    << "\", &knowledge, platform_name, &platform_args);\n";
          else
            buffer_ << "    algo = new Algo(" << period << ", \"" << funcName(node, role, thread)
                    << "\", &knowledge);\n";
        }
    }    
    buffer_ << "    algos.push_back(algo);\n";
  }

  if(do_expect_)
    buffer_ << "    expect_thread = new " << nodeName(node) << "::" << roleName(node,role)
            << "::ExpectThread(expect_file.is_open() ? expect_file : std::cout);\n";
  
  buffer_ << "  }\n";

  if (platformFunction == NULL)
    throw std::runtime_error("ERROR: no threads in role " + role->name + " in node " + node->name +
                             " have PlatformController attributes!!");
}

/*********************************************************************/
//-- generate code to define functions within MADARA
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_main_define_functions ()
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
dmpl::gams::GAMSBuilder::build_main_define_function (const Node & node, const Role &role,
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
dmpl::gams::GAMSBuilder::clear_buffer ()
{
  buffer_.str ("");
}

/*********************************************************************/
//-- print the buffer
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::print (std::ostream & os)
{
  os << buffer_.str ();
}

/*********************************************************************/
//-- generate code to open dmpl namespace
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::open_namespace (const std::string &ns)
{
  buffer_ << "// begin " << ns << " namespace\n";
  buffer_ << "namespace " << ns << "\n";
  buffer_ << "{\n";
}

/*********************************************************************/
//-- generate code to close dmpl namespace
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::close_namespace (const std::string &ns)
{
  buffer_ << "} // end " << ns << " namespace\n";
  buffer_ << "\n";
}
 
/*********************************************************************/
//-- Build a comment with prefix and suffix
/*********************************************************************/
void
dmpl::gams::GAMSBuilder::build_comment (const std::string &comment, const std::string &prefix,
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
