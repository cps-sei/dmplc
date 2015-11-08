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


#include <iostream>
#include <boost/foreach.hpp>
#include "Node.h"
#include "Program.h"
#include "Function.h"
#include "../dmplc/dmpl-parser.hpp"

/*********************************************************************/
//methods for SanityChecker
/*********************************************************************/

//add id to int mapping
void dmpl::program::SanityChecker::addIdMap(const std::string &s,size_t i)
{
  if(idMap.count(s))
    throw std::runtime_error("ERROR: illegal scoping of id variable " + s + " in function " +
                             func->name + " in role " + (role ? role->name : "null") +
                             " in node " + (node ? node->name : "null") + "!!");
  idMap[s] = i;
}

//remove id to int mappiing
void dmpl::program::SanityChecker::delIdMap(const std::string &s)
{
  if(!idMap.count(s))
    throw std::runtime_error("ERROR: illegal scoping of id variable " + s + " in function " +
                             func->name + " in role " + (role ? role->name : "null") +
                             " in node " + (node ? node->name : "null") + "!!");

  idMap.erase(s);
}

/*********************************************************************/
//dispatchers for statements
/*********************************************************************/

void dmpl::program::SanityChecker::exitCall(dmpl::CallStmt &stmt) 
{ 
  //handle calls to ND(x) -- assign x non-deterministically
  CallExpr *expr = dynamic_cast<CallExpr*>(stmt.data.get());
  if(!expr) assert(0 && "ERROR: argument to call statement not a CallExpr!");
  if(expr->func->toString() == "ND") {
    if(expr->args.size() != 1)
      throw std::runtime_error("ERROR: call to ND in function " + func->name +
                               " in role " + (role ? role->name : "null") +
                               " in node " + (node ? node->name : "null") +
                               " does not have 1 argument!!");
  }
}

void dmpl::program::SanityChecker::exitFAN(dmpl::FANStmt &stmt) 
{ 
  addIdMap(stmt.id,0);
  visit(stmt.data);
  delIdMap(stmt.id);
}

void dmpl::program::SanityChecker::exitFADNP(dmpl::FADNPStmt &stmt) 
{ 
  addIdMap(stmt.id1,0);
  addIdMap(stmt.id2,0);
  visit(stmt.data);
  delIdMap(stmt.id1);
  delIdMap(stmt.id2);
}

/*********************************************************************/
//print the program to an output stream
/*********************************************************************/
void
dmpl::Program::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  //print target thunks
  BOOST_FOREACH(TargetType::value_type &tt,targets)
    os << spacer << "target " << tt.first << " %%{" << tt.second << "%%}\n";

  //print CONST definitions
  BOOST_FOREACH(ConstDef::value_type &cd,constDef)
    os << spacer << "const " << cd.first << " = " << cd.second << ";\n";
  os << '\n';

  //print external function declarations
  BOOST_FOREACH(dmpl::Funcs::value_type &v, funcs) {
    if(!v.second->isExtern) continue;
    os << spacer << "extern";
    v.second->printDecl(os, 1);
  }
  os << '\n';

  //print nodes
  for (dmpl::Nodes::iterator i = nodes.begin (); i != nodes.end (); ++i)
    i->second->print (os,indent);
  os << '\n';

  //print internal functions
  BOOST_FOREACH(dmpl::Funcs::value_type &v, funcs)
    if(!v.second->isExtern) v.second->print (os,indent);
}

/*********************************************************************/
//-- utility functions
/*********************************************************************/
namespace {

  /*******************************************************************/
  //-- extract the set of keys from a map
  /*******************************************************************/
  template<typename T1, typename T2>
  std::set<T1> key_set(const std::map<T1,T2> &arg)
  {
    std::set<T1> res;
    for(const auto &kv : arg) res.insert(kv.first);
    return res;
  }

  /*******************************************************************/
  //-- extract variable names
  /*******************************************************************/
  std::set<std::string> varNames(const dmpl::Vars &vars)
  {
    return key_set(vars);
  }

  /*******************************************************************/
  //-- extract record names
  /*******************************************************************/
  std::set<std::string> recNames(const dmpl::Records &recs)
  {
    return key_set(recs);
  }

  /*******************************************************************/
  //-- extract function names
  /*******************************************************************/
  std::set<std::string> funcNames(const dmpl::Funcs &funcs)
  {
    return key_set(funcs);
  }

  /*******************************************************************/
  //-- return a common string between two sets. empty string if the
  //-- two sets are disjoint.
  /*******************************************************************/
  std::string commonStr(const std::set<std::string> &ss1, const std::set<std::string> &ss2)
  {
    for(const auto &s1 : ss1) {
      const auto it = ss2.find(s1);
      if(it != ss2.end()) return s1;
    }
    
    return std::string();
  }
}

/*********************************************************************/
//-- fill in various details of the program that could not be done
//-- during parse time
/*********************************************************************/
void dmpl::Program::complete()
{
  //-- add nodes and roles to functions
  for(auto &n : nodes) {
    for(auto &f : n.second->funcs) f.second->node = n.second;

    for(auto &r : n.second->roles)
      for(auto &f : r.second->funcs) {
        f.second->node = n.second;
        f.second->role = r.second;
      }
  }
  
  //-- add nodes to specifications
  for(auto &n : nodes) {
    for(auto &sp : n.second->specs) {
      sp.second->node = n.second;

      ExpectSpec *ep = static_cast<ExpectSpec*>(sp.second.get());
      if(ep) {
        ep->func = n.second->findFunc(ep->funcName);
        if(ep->func == NULL)
          throw std::runtime_error("ERROR: function " + ep->funcName + " for expect spec " +
                                   ep->name + " not found in node " + n.second->name + "!!");
        continue;
      }
      
      RequireSpec *rp = static_cast<RequireSpec*>(sp.second.get());
      if(rp) {
        rp->func = n.second->findFunc(rp->funcName);
        if(rp->func == NULL)
          throw std::runtime_error("ERROR: function " + rp->funcName + " for require spec " +
                                   rp->name + " not found in node " + n.second->name + "!!");
        continue;
      }
    }
  }
}

/*********************************************************************/
//-- sanity check a set of functions
/*********************************************************************/
void dmpl::Program::sanityCheckFuncs(const Funcs &arg)
{
  BOOST_FOREACH(const Funcs::value_type &v,arg) {
    BOOST_FOREACH(Stmt &s, v.second->body) {
      dmpl::program::SanityChecker sc(*this, v.second);
      if(v.second->node != NULL) sc.addIdMap(*(v.second->node->args.begin()), 0);
      sc.visit(s);
    }
  }
}

/*********************************************************************/
//check various sanity conditions
/*********************************************************************/
void
dmpl::Program::sanityCheck()
{
  //only one type of node
  assert(nodes.size() == 1 && "ERROR: only a single node type supported!");

  //nodes have just one parameter -- its id
  Node &node = nodes.begin()->second;
  assert(node->args.size() == 1 && "ERROR: node must have one id!");
  node->initArgs();

  //check global functions
  sanityCheckFuncs(funcs);

  //check node and role functions
  for(auto &n : nodes) {
    sanityCheckFuncs(n.second->funcs);
    for(auto &r : n.second->roles) sanityCheckFuncs(r.second->funcs);
  }

  //-- local and global variables must have distinct names
  std::string cv = commonStr(varNames(node->locVars), varNames(node->globVars));
  if(!cv.empty())
    throw std::runtime_error("ERROR: Node " + node->name + " declares variable " + cv +
                             " as both local and global!!");

  //-- records and variables should have distinct names
  cv = commonStr(varNames(node->locVars), recNames(node->records));
  if(!cv.empty())
    throw std::runtime_error("ERROR : Node " + node->name + " declares " + cv +
                             " as both record and local variable!!\n");
  cv = commonStr(varNames(node->globVars), recNames(node->records));
  if(!cv.empty())
    throw std::runtime_error("ERROR : Node " + node->name + " declares " + cv +
                             " as both record and global variable!!\n");

  //-- functions and variables should have distinct names
  cv = commonStr(varNames(node->locVars), funcNames(node->funcs));
  if(!cv.empty())
    throw std::runtime_error("ERROR : Node " + node->name + " declares " + cv +
                             " as both function and local variable!!\n");
  cv = commonStr(varNames(node->globVars), funcNames(node->funcs));
  if(!cv.empty())
    throw std::runtime_error("ERROR : Node " + node->name + " declares " + cv +
                             " as both function and global variable!!\n");

  //-- functions and record should have distinct names
  cv = commonStr(recNames(node->records), funcNames(node->funcs));
  if(!cv.empty())
    throw std::runtime_error("ERROR : Node " + node->name + " declares " + cv +
                             " as both function and record!!\n");

  //-- check name distinctness for roles
  for(const auto &r : node->roles) {
    //-- local and global variables must have distinct names
    cv = commonStr(varNames(r.second->locVars), varNames(r.second->globVars));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares variable " + cv + " as both local and global!!");

    //-- records and variables should have distinct names
    cv = commonStr(varNames(r.second->locVars), recNames(r.second->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares " + cv + " as both record and local variable!!\n");
    cv = commonStr(varNames(r.second->globVars), recNames(r.second->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares " + cv + " as both record and global variable!!\n");

    //-- functions and variables should have distinct names
    cv = commonStr(varNames(r.second->locVars), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares " + cv + " as both function and local variable!!\n");
    cv = commonStr(varNames(r.second->globVars), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares " + cv + " as both function and global variable!!\n");

    //-- functions and record should have distinct names
    cv = commonStr(recNames(r.second->records), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " inside node " + node->name +
                               " declares " + cv + " as both function and record!!\n");

    //-- functions and local variables in node and role should have
    //-- distinct names and vice-versa
    cv = commonStr(varNames(node->locVars), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both function and local variable!!\n");
    cv = commonStr(varNames(r.second->locVars), funcNames(node->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both function and local variable!!\n");

    //-- functions and global variables in node and role should have
    //-- distinct names and vice-versa
    cv = commonStr(varNames(node->globVars), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both function and global variable!!\n");
    cv = commonStr(varNames(r.second->globVars), funcNames(node->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both function and global variable!!\n");

    //-- records and local variables in node and role should have
    //-- distinct names and vice-versa
    cv = commonStr(varNames(node->locVars), recNames(r.second->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both record and local variable!!\n");
    cv = commonStr(varNames(r.second->locVars), recNames(node->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both record and local variable!!\n");

    //-- records and global variables in node and role should have
    //-- distinct names and vice-versa
    cv = commonStr(varNames(node->globVars), recNames(r.second->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both record and global variable!!\n");
    cv = commonStr(varNames(r.second->globVars), recNames(node->records));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declare " + cv + " as both record and global variable!!\n");

    //-- functions and records in node and role should have distinct
    //-- names and vice-versa
    cv = commonStr(recNames(node->records), funcNames(r.second->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declares " + cv + " as both function and record!!\n");
    cv = commonStr(recNames(r.second->records), funcNames(node->funcs));
    if(!cv.empty())
      throw std::runtime_error("ERROR: Role " + r.second->name + " and node " + node->name +
                               " declares " + cv + " as both function and record!!\n");
  }
  
  //-- roles must override only variables, records, and functions that
  //-- belong to the node. they cannot redeclare such variables,
  //-- records and functions without overriding them.
  for(const auto &r : node->roles) {
    //-- check global variables
    for(const auto &v : r.second->globVars) {
      if(v.second->isOverride && !node->hasVar(v.second))
        throw std::runtime_error("Role " + r.second->name +
                                 " cannot override (missing or wrong type in parent node " +
                                 node->name + ") global variable " + v.second->name + "!!");
      if(!v.second->isOverride && node->findVar(v.second->name))
        throw std::runtime_error("Role " + r.second->name +
                                 " cannot declare without override global variable " +
                                 v.second->name + "!!");
    }
    //-- check local variables
    for(const auto &v : r.second->locVars) {
      if(v.second->isOverride && !node->hasVar(v.second))
        throw std::runtime_error("Role " + r.second->name +
                                 " cannot override (missing or wrong type in parent node " +
                                 node->name + ") local variable " + v.second->name + "!!");
      if(!v.second->isOverride && node->findVar(v.second->name))
        throw std::runtime_error("Role " + r.second->name +
                                 " cannot declare without override local variable " +
                                 v.second->name + "!!");
    }
    //-- check records
    for(const auto &rec : r.second->records) {
      if(rec.second->isOverride && !node->hasRecord(rec.second))
        throw std::runtime_error("Role " + r.second->name +
                                 " cannot override (field mismatch) record " + rec.second->name + "!!");
      if(!rec.second->isOverride && node->hasRecord(rec.second))
        throw std::runtime_error("Role " + r.second->name +
                                 " must override record " + rec.second->name + "!!");
    }
  }
}

/*********************************************************************/
//-- extract threads from functions, assign threadIDs, and compute
//-- their symbol usage.
/*********************************************************************/
void
dmpl::Program::analyzeThreads()
{
  BOOST_FOREACH(Nodes::value_type &node, nodes)
    node.second->analyzeThreads();
}

/*********************************************************************/
//-- compute symbol usage of nodes and their components.
/*********************************************************************/
void
dmpl::Program::analyzeSymbolUsage()
{
  BOOST_FOREACH(Nodes::value_type &node, nodes)
    SymbolUser::analyzeSymbolUsage(*(node.second));
}

/*********************************************************************/
//end of file
/*********************************************************************/

