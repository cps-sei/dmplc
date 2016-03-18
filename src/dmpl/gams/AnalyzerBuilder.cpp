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
                        dmpl::DmplBuilder & builder_, std::stringstream & buffer_)
  {
    for(const dmpl::Var & variable : func->temps) {
      if(variable->initFunc == NULL) continue;
      
      dmpl::madara::GAMSCompiler visitor (variable->initFunc, node, dmpl::Func(),
                                          builder_, buffer_, false);
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
  buffer_ << "#include \"dmpl/CachedReference.hpp\"\n";
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
  buffer_ << "using containers::CachedReference;\n";
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

  build_comment("//-- default transport variables", "", "", 0);
  buffer_ << "std::string host (\"\");\n";
  buffer_ << "typedef void (*PlatformInitFn)(const std::vector<std::string> &, engine::KnowledgeBase &);\n";
  buffer_ << "typedef std::map<std::string, PlatformInitFn> PlatformInitFns;\n";
  buffer_ << "PlatformInitFns platform_init_fns;\n";
  buffer_ << "const std::string default_multicast (\"239.255.0.1:4150\");\n";
  buffer_ << "madara::transport::QoSTransportSettings settings;\n";
  buffer_ << "int write_fd (-1);\n";
  buffer_ << "ofstream expect_file;\n";
  buffer_ << "std::string node_name (\"none\");\n";
  buffer_ << "std::string role_name (\"none\");\n";
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
dmpl::gams::AnalyzerBuilder::build_program_variables ()
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
    build_program_variable_init (var);
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
    build_program_variable_init (var);
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
dmpl::gams::AnalyzerBuilder::build_program_variable_init (const Var & var)
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
//-- generate shared variables for a thread. scope = local/global/group
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_thread_variables (const Func &thread, const Vars & vars,
                                                 const std::string &scope)
{
  if(scope != "local" && scope != "global" && scope != "group")
    throw std::runtime_error("ERROR: illegal scope " + scope + " when declaring variables for thread " +
                             thread->name + "!!");

  build_comment("//-- Defining " + scope + " variables at scope of thread " + thread->name +
                "\n//-- Used to implement Read-Execute-Write semantics", "\n", "", 0);
  for (auto i : vars)
    build_thread_variable (thread, i.second);
}

/*********************************************************************/
//-- generate a shared variable for a thread
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_thread_variable (const Func &thread, const Var & var)
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
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-b\" || arg1 == \"--broadcast\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = madara::transport::BROADCAST;\n";
  buffer_ << "      }\n";
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-u\" || arg1 == \"--udp\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        settings.hosts.push_back (argv[i + 1]);\n";
  buffer_ << "        settings.type = madara::transport::UDP;\n";
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
  buffer_ << "        if(settings.id < 0 || settings.id >= " << numNodes () << ") {\n";
  buffer_ << "          std::cerr << \"ERROR: Invalid node id: \" << settings.id \n"
          << "                    << \"  valid range: [0, " << (numNodes () - 1)
          << "]\" << std::endl;\n";
  buffer_ << "          exit(1);\n";
  buffer_ << "        }\n";
  size_t procId = 0;
  for(const Process &proc : builder_.program.processes) {
    buffer_ << "        if(settings.id == " << procId << ") { node_name = \""
            << proc.getNode() << "\"; role_name = \"" << proc.getRole() << "\"; }\n";
    ++procId;
  }
  buffer_ << "      }\n";
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
  buffer_ << "      ++i;\n";
  buffer_ << "    }\n";
  buffer_ << "    else if (arg1 == \"-e\" || arg1 == \"--expect-log\")\n";
  buffer_ << "    {\n";
  buffer_ << "      if (i + 1 < argc)\n";
  buffer_ << "      {\n";
  buffer_ << "        expect_file.open(argv[i + 1], ios::out | ios::trunc);\n";
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
  buffer_ << "      madara_log (madara::logger::LOG_EMERGENCY, (LM_DEBUG, \n";
  buffer_ << "        \"\\nProgram summary for %s:\\n\\n\"\\\n";
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

/*********************************************************************/
//-- generate code to parse command line options for initializing a
//-- DMPL variable.
/*********************************************************************/
std::string
dmpl::gams::AnalyzerBuilder::build_parse_args (const std::string &var,
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
dmpl::gams::AnalyzerBuilder::build_function_declarations ()
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

      //-- declare functions to evaluate expect specifications
      if(do_expect_) build_expect_spec_declaration(r.second);
      
      close_namespace(roleName(n.second, r.second));
    }

    close_namespace(nodeName(n.second));
  }
}

/*********************************************************************/
//-- build function declarations for a thread
/*********************************************************************/
void
dmpl::gams::AnalyzerBuilder::build_function_declarations_for_thread (const Func & thread,
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
dmpl::gams::AnalyzerBuilder::build_function_declaration (const Func & thread, const Func & function)
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

    specFuncs.insert(es->func);
    for(const Func &func: role->allFuncsInScope())
      if(es->func->canCall(func, role.get()))
        specFuncs.insert(func);
  }
  
  for(const Func &func : specFuncs) {
    buffer_ << "bool " << func->name << " ();\n";
  }
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
    build_function (NULL, Node (), i->second);
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

      //-- generate functions to evaluate expect specifications
      if(do_expect_) build_expect_spec_definition (r.second);

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
          print_temp_inits(rec->initFunc, n->second, builder_, buffer_); 
          
          //-- transform statements
          dmpl::madara::GAMSCompiler visitor (rec->initFunc, n->second, Func(),
                                              builder_, buffer_, false);
          for (const Stmt & statement : rec->initFunc->body)
            visitor.visit (statement);
          buffer_ << "}\n";
        }
        
        if(rec->assumeFunc != NULL && !rec->assumeFunc->body.empty()) {
          buffer_ << "int check_init_" << rec->name << " ()\n{\n";
          print_vars(buffer_, rec->assumeFunc->temps, false);
          print_temp_inits(rec->assumeFunc, n->second, builder_, buffer_); 
        
          //-- transform statements
          dmpl::madara::GAMSCompiler visitor (rec->assumeFunc, n->second, Func(),
                                              builder_, buffer_, false);
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
dmpl::gams::AnalyzerBuilder::build_constructor_for_variable (Var &v, Node &node)
{
  buffer_ << (v->isInput ? "int check_init_" : "void initialize_") << v->name << " ()\n{\n";
  buffer_ << "  engine::Variables vars;\n";
  
  //-- bind initial value for inputs
  if(v->isInput) build_program_variable_assignment(v);
  
  //-- generate constructor if one was defined
  if(v->initFunc != NULL) {
    print_vars(buffer_, v->initFunc->temps, false);
    print_temp_inits(v->initFunc, node, builder_, buffer_); 
    
    //-- transform statements
    dmpl::madara::GAMSCompiler visitor (v->initFunc, node, Func(),
                                        builder_, buffer_, false);
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
dmpl::gams::AnalyzerBuilder::build_refresh_modify_input_globals (const Node &node, const Role &role)
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
dmpl::gams::AnalyzerBuilder::build_refresh_modify_globals (const Node &node, const Role &role,
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
dmpl::gams::AnalyzerBuilder::build_refresh_modify_global (const Node &node, const Var & var)
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
dmpl::gams::AnalyzerBuilder::build_push_pull(const Func &thread, bool push)
{
  buffer_ << "  //-- " << (push?"Push":"Pull") << " all referenced locals/globals\n";
  buffer_ << "  {\n";
  buffer_ << "    madara::knowledge::ContextGuard guard(knowledge);\n";

  //push-pull locals
  for(const auto &var : thread->accessedLoc(thread->role.get())) {
    buffer_ << "    " << (push?"push":"pull") << "(thread" << thread->threadID << "_"
            << var.first << ");" << std::endl;
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
dmpl::gams::AnalyzerBuilder::build_functions_for_thread (
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
dmpl::gams::AnalyzerBuilder::build_function (
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
    //-- call main thread function
    buffer_ << "  //-- call thread function\n";
    buffer_ << "  thread" << thread->threadID << "_";
    buffer_ << thread->name << "(args, vars);\n\n";

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
  print_temp_inits(actualFunc, node, builder_, buffer_); 
  buffer_ << "\n";

  buffer_ << "\n  //-- Begin function body\n";
  dmpl::madara::GAMSCompiler visitor (actualFunc, node, thread, builder_, buffer_, false);

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

    specFuncs.insert(es->func);
    for(const Func &func: role->allFuncsInScope())
      if(es->func->canCall(func, role.get()))
        specFuncs.insert(func);
  }
  
  for(const Func &func : specFuncs) {
    buffer_ << "bool " << func->name << " ()\n";
    buffer_ << "{\n";

    dmpl::madara::GAMSCompiler visitor (func, role->node, Func(), builder_, buffer_, true);
    BOOST_FOREACH (const Stmt & statement, func->body)
      visitor.visit (statement);
  
    buffer_ << "}\n\n";
  }
}

/*********************************************************************/
//-- generate the role2Id function
/*********************************************************************/
void dmpl::gams::AnalyzerBuilder::build_role2Id ()
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

  // set the values for id and processes
  buffer_ << "  //-- Initialize commonly used local variables\n";  
  buffer_ << "  num_processes = processes;\n";
  buffer_ << "\n";

  Node &node = builder_.program.nodes.begin()->second;
  buffer_ << "  LogAnalyzer analyzer(std::cin, knowledge);\n";

  buffer_ << "  std::cout << \"Time,Name,Node,Value\" << std::endl;\n";
  buffer_ << "  for(;;) {\n";
  buffer_ << "    bool done = !analyzer.next_step();\n";
  buffer_ << "    bool value = 0;\n";
  buffer_ << "    int total_so_far = 0, count_so_far = 0;\n";

  for(const Process &proc : builder_.program.processes) {
    for(const Spec &spec : proc.role->allSpecsInScope()) {
      AtEndSpec *aes= dynamic_cast<AtEndSpec*>(spec.get());
      if(aes) {
        buffer_ << "    id = " << proc.id << ";\n";
        buffer_ << "    value = " << nodeName(proc.role->node) << "::"
                << roleName(proc.role->node,proc.role) << "::" << aes->func->name << "();\n";
        buffer_ << "    knowledge.set(\"AtEnd_RESULT." << proc.id << "."
                << aes->name << "\", Integer(value?1:0));\n";
        continue;
      }
      AtLeastSpec *als= dynamic_cast<AtLeastSpec*>(spec.get());
      if(als) {
        buffer_ << "    id = " << proc.id << ";\n";
        buffer_ << "    value = " << nodeName(proc.role->node) << "::"
                << roleName(proc.role->node,proc.role) << "::" << als->func->name << "();\n";
        buffer_ << "    total_so_far = knowledge.get(\"AtLeast_TOTAL." << proc.id << "."
                << als->name << "\").to_integer();\n";
        buffer_ << "    count_so_far = knowledge.get(\"AtLeast_COUNT." << proc.id << "."
                << als->name << "\").to_integer();\n";
        buffer_ << "    knowledge.set(\"AtLeast_TOTAL." << proc.id << "."
                << als->name << "\", total_so_far + Integer(value?1:0));\n";
        buffer_ << "    knowledge.set(\"AtLeast_COUNT." << proc.id << "."
                << als->name << "\", Integer(count_so_far + 1));\n";
        continue;
      }
    }
  }

  buffer_ << "    if(done) break;\n";
  buffer_ << "  }\n";

  buffer_ << "  {\n";
  buffer_ << "    bool value = 0;\n";
  buffer_ << "    double total = 0.0, count = 0.0;\n";
  for(const Process &proc : builder_.program.processes) {
    for(const Spec &spec : proc.role->allSpecsInScope()) {
      AtEndSpec *aes= dynamic_cast<AtEndSpec*>(spec.get());
      if(aes) {
        buffer_ << "    value = knowledge.get(\"AtEnd_RESULT." << proc.id << "."
                << aes->name << "\").to_integer() == 1;\n";
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
