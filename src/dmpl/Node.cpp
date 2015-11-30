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

#include "Node.h"
#include "Program.h"
#include <iostream>

/*********************************************************************/
///find the platform initialzer function in this role or in the parent
///node
/*********************************************************************/
dmpl::Func dmpl::BaseNode::findPlatformInitializer()
{
  Func res;

  for(auto &f : funcs) {
    if(f.second->getAttribute("InitSim", 0) != NULL) {
      if(res == NULL) {
        if(f.second->isThread())
          throw std::runtime_error("ERROR: node " + name +
                                   " has thread " + f.second->name +
                                   " as platform initialization function!!");
        res = f.second;
      } else throw std::runtime_error("ERROR: node " + name +
                                      " has multiple platform initialization functions: " +
                                      res->name + " and " + f.second->name + "!!");
    }
  }
  
  return res;
}

/*********************************************************************/
//-- merge with another node
/*********************************************************************/
void
dmpl::BaseNode::mergeWith(const Node &on)
{
  BaseNode &n = *this;

  //-- merge abstract
  if (n.abstract && !on->abstract)
    n.abstract = false;

  //-- merge name
  if (n.name == "")
    n.name = on->name;
  else if (n.name != on->name)
    throw std::runtime_error("Cannot merge nodes of differing names: " + n.name + " and " + on->name);

  //-- marge args
  if (n.args.size() == 0)
    n.args = on->args;
  else if (!on->abstract && n.args != on->args)
    throw std::runtime_error("Cannot merge nodes which have different arguments: for " + n.name);

  //-- merge global vars
  addVars(on->globVars);

  //-- merge local vars
  addVars(on->locVars);
  
  //-- merge records
  BOOST_FOREACH(const Records::value_type &r, on->records) addRecord(r.second);

  //-- merge functions
  BOOST_FOREACH(const Funcs::value_type &f, on->funcs)
  {
    if(n.funcs.count(f.second->name) == 0)
      n.funcs[f.second->name] = f.second;
    else
      n.funcs[f.second->name]->mergeWith(f.second);
  }

  //-- merge attributes
  if(!mergeAttributes(*on))
    throw std::runtime_error("Cannot merge attributes of node " + name + "!!");

  //-- merge roles
  BOOST_FOREACH(const Roles::value_type &r, on->roles) addRole(r.second);

  //-- merge specifications
  BOOST_FOREACH(const Specs::value_type &s, on->specs) {
    if(!specs.insert(s).second)
      throw std::runtime_error("ERROR: duplicate specificaion " + s.first);
  }
}

/*********************************************************************/
//-- print a node to an output stream with indentation
/*********************************************************************/
void
dmpl::BaseNode::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << "node " << name << "\n" << spacer << "{\n";
  
  //-- print all variables not inside records
  for (const auto &i : globVars) {
    if(i.second->record.empty()) i.second->printInit(os, indent+2);
  }
  for (const auto &i : locVars) {
    if(i.second->record.empty()) i.second->printInit(os, indent+2);
  }

  //-- print all records
  for (const auto &i : records) i.second->print(os, indent+2);

  //-- print functions
  for (dmpl::Funcs::iterator i = funcs.begin ();i != funcs.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  //-- print roles
  for (dmpl::Roles::iterator i = roles.begin ();i != roles.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  //-- print specifications
  for (auto i = specs.begin ();i != specs.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  os << spacer << "}\n\n";
}

/*********************************************************************/
//-- find function with given name. either in this node or at the
//-- program level.
/*********************************************************************/
dmpl::Func
dmpl::BaseNode::findFunc(const std::string& name) const
{
  Funcs::const_iterator ret = funcs.find(name);
  if(ret != funcs.end()) return ret->second;
  return program->findFunc(name);
}

/*********************************************************************/
//-- assign ids to threads and do symbol usage analysis
/*********************************************************************/
void
dmpl::BaseNode::analyzeThreads()
{
  threads.clear();
  int curID = 0;

  //-- go over each function and identify threads
  BOOST_FOREACH(const Funcs::value_type &f, funcs)
  {
    const Func &func = f.second;

    //-- ignore non-thread functions
    if(!func->isThread()) continue;

    //-- assign fresh ID to thread functions
    func->threadID = curID;
    ++curID;
    threads.push_back(func);
  }

  //-- process each role
  for(auto &r : roles) {
    Role &role = r.second;
    role->threads.clear();
    for(const Funcs::value_type &f : role->funcs) {
      const Func &func = f.second;

      //-- ignore non-thread functions
      if(!func->isThread()) {
        //-- sanity check. if the parent node contains a function with
        //-- same name then it must not be a thread and this one must
        //-- override.
        Func nodeFunc = findFunc(func->name);
        if(nodeFunc == NULL) {
          if(func->isOverride)
            throw std::runtime_error("ERROR: role " + role->name + " cannot override function " +
                                     func->name + " since parent node " + name +
                                     " has no function with same name!!");
          continue;
        }
        
        if(nodeFunc->isThread())
          throw std::runtime_error("ERROR: role " + role->name + " declares function " +
                                   func->name + " but parent node " + name +
                                   " has thread with same name!!");
        if(!func->isOverride)
          throw std::runtime_error("ERROR: role " + role->name + " must override function " +
                                   func->name + " since parent node " + name +
                                   " has function with same name!!");

        if(!func->equalType(*nodeFunc))
          throw std::runtime_error("ERROR: role " + role->name + " declares function " +
                                   func->name + " but parent node " + name +
                                   " has function with same name but different type!!");
        
        continue;
      }
      
      //-- assign new thread functions fresh id
      const auto it = funcs.find(func->name);
      if(it == funcs.end()) {
        func->threadID = curID;
        ++curID;
        role->threads.push_back(func);
        continue;
      }

      //-- now we have a function with same name in parent node

      //-- sanity check -- function in node should also be a thread
      const Func &nodeFunc = it->second;
      if(!nodeFunc->isThread())
        throw std::runtime_error("ERROR: role " + role->name + " declares thread " + func->name +
                                 " but parent node " + name +
                                 " has non-thread function with same name!!");

      //-- if this thread is not a prototype, it must override
      if(!func->isPrototype && !func->isOverride)
        throw std::runtime_error("ERROR: role " + role->name + " must override non-prototype thread " +
                                 func->name + " since parent node " + name +
                                 " has thread with same name!!");

      //-- assign this thread same threadID as the one in node
      func->threadID = nodeFunc->threadID;
      role->threads.push_back(func);
    }
  }
}

/*********************************************************************/
//-- returns true if the argument is a serial function for this role
/*********************************************************************/
bool dmpl::BaseNode::isSerialFunction(const Func &func) const
{
  //-- add simulation initializers
  if(func->getAttribute("InitSim",0)) return true;

  //-- look for functions called by variable constructors
  for(const Var &v : allVars())
    if(v->initFunc != NULL && v->initFunc->canCall(func)) return true;

  //-- look for functions called by variable constructors
  for(const auto &r : records) {
    if(r.second->initFunc != NULL && r.second->initFunc->canCall(func))
      return true;
    if(r.second->assumeFunc != NULL && r.second->assumeFunc->canCall(func))
      return true;
  }

  //-- check roles
  for(const auto &r : roles)
    if(!r.second->overridesFunction(func->name) && r.second->isSerialFunction(func))
      return true;

  //-- not a serial function
  return false;
}

/*********************************************************************/
//-- return the set of functions that are called before threads are
//-- spawned, e.g., the platform initializer, and functions called
//-- from constructors.
/*********************************************************************/
dmpl::Funcs dmpl::BaseNode::serialFunctions() const
{
  Funcs res;

  for(const auto &f : funcs)
    if(isSerialFunction(f.second)) res.insert(f);

  return res;
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
