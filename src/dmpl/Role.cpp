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

#include "Role.h"
#include "Program.h"
#include <iostream>

/*********************************************************************/
//-- return all local and global variables in scope, i.e., including
//-- the parent node as well.
/*********************************************************************/
dmpl::VarList dmpl::BaseRole::allVarsInScope() const
{  
  //-- collect all variables from this role
  Vars allVars = locVars;
  allVars.insert(globVars.begin(), globVars.end());

  //-- add variables declared in parent node
  allVars.insert(node->locVars.begin(), node->locVars.end());
  allVars.insert(node->globVars.begin(), node->globVars.end());
  
  VarList res;
  for(const auto &v : allVars) res.push_back(v.second);
  return res;
}


/*********************************************************************/
//-- return all records in scope, i.e., including the parent node as
//-- well.
/*********************************************************************/
dmpl::RecordList dmpl::BaseRole::allRecordsInScope() const
{
  //-- collect all records from this role
  Records allRecs = records;

  //-- add variables declared in parent node
  allRecs.insert(node->records.begin(), node->records.end());
  
  RecordList res;
  for(const auto &r : allRecs) res.push_back(r.second);
  return res;
}

/*********************************************************************/
//-- return list of all functions in scope, either in this role or in
//-- parent node
/*********************************************************************/
dmpl::FuncList dmpl::BaseRole::allFuncsInScope() const
{
  //-- collect all non-overridden funcs from this role
  Funcs allFuncs;
  for(const auto &f : funcs)
    if(!f.second->isOverride) allFuncs.insert(f);
  
  //-- add all functions from the parent
  allFuncs.insert(node->funcs.begin(), node->funcs.end());

  //-- create result and return
  FuncList res;
  for(const auto &f : allFuncs) res.push_back(f.second);
  return res;
}

/*********************************************************************/
//-- find function with given name. either in this role or at the node
//-- level.
/*********************************************************************/
dmpl::Func
dmpl::BaseRole::findFunc(const std::string& name) const
{
  Funcs::const_iterator ret = funcs.find(name);
  if(ret != funcs.end()) return ret->second;
  return node->findFunc(name);
}

/*********************************************************************/
///return a pointer to the attribute with given name and number of
///arguments in the given function. if the function itself does not
///have the attributed, then look in the function it inherits (if any)
///from in the parent node. return NULL if no such attribute found.
/*********************************************************************/
const dmpl::Attribute *dmpl::BaseRole::getAttribute(const Func &func, const std::string &name,
                                                    int expectedArgs) const
{
  const Attribute *res = func->getAttribute(name, expectedArgs);
  if(res) return res;
  
  if(!func->isPrototype) return NULL;
  
  const auto &it = node->funcs.find(func->name);
  if(it == node->funcs.end()) return NULL;
  
  return it->second->getAttribute(name, expectedArgs);
}

/*********************************************************************/
///find the platform initialzer function in this role
/*********************************************************************/
dmpl::Func dmpl::BaseRole::findPlatformInitializer()
{
  Func res;

  //-- first check the role
  for(auto &f : funcs) {
    if(getAttribute(f.second, "InitSim", 0) != NULL) {
      if(res == NULL) {
        if(f.second->isThread())
          throw std::runtime_error("ERROR: role " + name + " in node " + node->name +
                                   " has thread " + f.second->name +
                                   " as platform initialization function!!");
        res = f.second;
      } else throw std::runtime_error("ERROR: role " + name + " in node " + node->name +
                                    " has multiple platform initialization functions: " +
                                    res->name + " and " + f.second->name + "!!");
    }
  }

  //-- all done
  return res;
}

/*********************************************************************/
//-- merge with another role
/*********************************************************************/
void
dmpl::BaseRole::mergeWith(const Role &other)
{
  BaseRole &oth = *other;

  //-- merge abstract
  if (abstract && !oth.abstract)
    abstract = false;

  //-- merge name
  if (name == "")
    name = oth.name;
  else if (name != oth.name)
    throw std::runtime_error("Cannot merge roles of differing names: " + name + " and " + oth.name);

  //-- merge global vars
  BOOST_FOREACH(const Vars::value_type &v, oth.globVars)
  {
    if(globVars.count(v.second->name) == 0)
      globVars[v.second->name] = v.second;
    else if(globVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging role globals: " + v.second->name + " in " + name);
  }

  //-- merge local vars
  BOOST_FOREACH(const Vars::value_type &v, oth.locVars)
  {
    if(locVars.count(v.second->name) == 0)
      locVars[v.second->name] = v.second;
    else if(locVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging role locals: " + v.second->name + " in " + name);
  }

  //-- merge functions
  BOOST_FOREACH(const Funcs::value_type &f, oth.funcs)
  {
    if(funcs.count(f.second->name) == 0)
      funcs[f.second->name] = f.second;
    else
      funcs[f.second->name]->mergeWith(f.second);
  }

  //-- merge attributes
  BOOST_FOREACH(const Attributes::value_type &a, oth.attrs)
  {
    if(attrs.count(a.second.name) == 0)
      attrs[a.second.name] = a.second;
    else if (attrs[a.second.name].paramList != a.second.paramList)
      throw std::runtime_error("Cannot merge role with attributes of differing parameters: @" + a.second.name + " in " + name);
  }

  //-- merge specifications
  BOOST_FOREACH(const Specs::value_type &s, oth.specs) {
    if(!specs.insert(s).second)
      throw std::runtime_error("ERROR: duplicate specificaion " + s.first);
  }
}

/*********************************************************************/
//-- returns true if the argument is a serial function for this role
/*********************************************************************/
bool dmpl::BaseRole::isSerialFunction(const Func &func) const
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

  //-- not a serial function
  return false;
}

/*********************************************************************/
//-- return the set of functions that are called before threads are
//-- spawned, e.g., the platform initializer, and functions called
//-- from constructors.
/*********************************************************************/
dmpl::Funcs dmpl::BaseRole::serialFunctions() const
{
  Funcs res;

  for(const auto &f : funcs)
    if(isSerialFunction(f.second)) res.insert(f);

  return res;
}

/*********************************************************************/
//-- print with indentation
/*********************************************************************/
void
dmpl::BaseRole::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << "role " << name << "\n" << spacer << "{\n";
  
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

  //-- print specifications
  for (auto i = specs.begin ();i != specs.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  os << spacer << "}\n\n";
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
