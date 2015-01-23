/**
 * Copyright (c) 2014 Carnegie Mellon University. All Rights Reserved.

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

 * DM-0001023
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
  if(idMap.count(s)) {
    std::cerr << "ERROR: substitution mapping for " << s << " exists already!!\n";
    assert(0);
  }
  idMap[s] = i;
}

//remove id to int mappiing
void dmpl::program::SanityChecker::delIdMap(const std::string &s)
{
  if(!idMap.count(s)) {
    std::cerr << "ERROR: substitution mapping for " << s << " doesn't exist!!\n";
    assert(0);
  }
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
    assert(expr->args.size() == 1 && 
           "ERROR: call to ND() must have one argument!");
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

dmpl::Program::Program ()
  : trackLocations (false), sendHeartbeats (false), period(0)
{}

dmpl::Program::~Program () {}

/*********************************************************************/
//print the program to an output stream
/*********************************************************************/
void
dmpl::Program::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  //print target thunks
  BOOST_FOREACH(TargetType::value_type &tt,targets)
    os << spacer << "TARGET " << tt.first << " %%{" << tt.second << "%%}\n";

  //print CONST definitions
  BOOST_FOREACH(ConstDef::value_type &cd,constDef)
    os << spacer << "CONST " << cd.first << " = " << cd.second << ";\n";
  os << '\n';

  //print external function declarations
  BOOST_FOREACH(dmpl::Funcs::value_type &v, funcs) {
    if(v.second->isExtern == false)
      continue;
    os << spacer << "EXTERN";
    v.second->printDecl(os, 1);
  }
  os << '\n';

  //print nodes
  for (dmpl::Nodes::iterator i = nodes.begin (); i != nodes.end (); ++i)
    i->second.print (os,indent);

  //print program definition
  os << spacer << "PROGRAM = ";
  size_t count = 0;
  BOOST_FOREACH(const Process &p,processes) {
    if(count) os << " || ";
    os << p.getNode() << '(' << p.getId() << ")";
    ++count;
  }
  os << ";\n\n";

  //print functions like INIT and safety
  for (dmpl::Funcs::iterator i = funcs.begin (); i != funcs.end (); ++i)
    i->second->print (os,indent);
}

/*********************************************************************/
//check various sanity conditions
/*********************************************************************/
void
dmpl::Program::sanityCheck()
{
  //only one type of node
  assert(nodes.size() == 1 && "ERROR: only a single node type supported!");

  //check global functions
  BOOST_FOREACH(Funcs::value_type &v,funcs) {
    BOOST_FOREACH(Stmt &s, v.second->body) {
      dmpl::program::SanityChecker sc(*this);
      sc.visit(s);
    }
  }

  //nodes have just one parameter -- its id
  Node &node = nodes.begin()->second;
  assert(node.args.size() == 1 && "ERROR: node must have one id!");
  node.initArgs();
  const std::string &nodeId = *(node.args.begin());

  //check node functions
  BOOST_FOREACH(Funcs::value_type &v,node.funcs) {
    BOOST_FOREACH(Stmt &s, v.second->body) {
      dmpl::program::SanityChecker sc(*this);
      sc.addIdMap(nodeId,0);
      sc.visit(s);
    }
  }

#if 0
  //check node global variables
  BOOST_FOREACH(Vars::value_type &v,node.globVars) {
    //non-array types of global variables are illegal
    assert(!v.second->type->dims.empty() && 
           "ERROR: all global variables must be of array type");

    //last dimension of global variables must be #N
    assert(*(v.second->type->dims.rbegin()) == -1 &&
           "ERROR: last dimension of global variables must be #N");
  }
#endif

#if 0
  // if track locations is set, then add the x, y, z variables to
  // declarations
  if (trackLocations)
  {
    std::vector<std::string> vars;
    vars.push_back ("x");
    vars.push_back ("y");
    vars.push_back ("z");
    
    // x, y, z are 1 dimensional arrays of length nodes.size ()
    BOOST_FOREACH(std::string & var_name, vars) {
      // we blow away any existing var.name and prefer our version
      dmpl::BaseType *t = new dmpl::BaseType(TINT);
      //-- set the dimension to -1 since this will be replaced by the
      //-- number of nodes later on
      t->dims.push_back(-1);
      dmpl::Var var (new dmpl::Variable(var_name, dmpl::Type(t)));
      var.scope = Variable::GLOBAL;
      node.globVars[var.name] = var;
    }
  }

  if (sendHeartbeats)
  {
    dmpl::BaseType *t = new dmpl::BaseType(TINT);
    //-- set the dimension to -1 since this will be replaced by the
    //-- number of nodes later on
    t->dims.push_back(-1);
    dmpl::Variable var ("heartbeats", dmpl::Type(t));
    var.scope = Variable::LOCAL;
    node.locVars[var.name] = var;
  }
#endif
}

/*********************************************************************/
//end of file
/*********************************************************************/

