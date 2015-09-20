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
  BOOST_FOREACH(const Vars::value_type &v, on->globVars)
  {
    if(n.globVars.count(v.second->name) == 0)
      n.globVars[v.second->name] = v.second;
    else if(n.globVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging node globals: " + v.second->name + " in " + n.name);
  }

  //-- merge local vars
  BOOST_FOREACH(const Vars::value_type &v, on->locVars)
  {
    if(n.locVars.count(v.second->name) == 0)
      n.locVars[v.second->name] = v.second;
    else if(n.locVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging node locals: " + v.second->name + " in " + n.name);
  }

  //-- merge functions
  BOOST_FOREACH(const Funcs::value_type &f, on->funcs)
  {
    if(n.funcs.count(f.second->name) == 0)
      n.funcs[f.second->name] = f.second;
    else
      n.funcs[f.second->name]->mergeWith(f.second);
  }

  //-- merge attributes
  BOOST_FOREACH(const Attributes::value_type &a, on->attrs)
  {
    if(n.attrs.count(a.second.name) == 0)
      n.attrs[a.second.name] = a.second;
    else if (n.attrs[a.second.name].paramList != a.second.paramList)
      throw std::runtime_error("Cannot merge nodes with attributes of differing parameters: @" + a.second.name + " in " + n.name);
  }

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

  //-- group all variables by their record names
  std::map< std::string,std::set<dmpl::Var> > rec2Vars;
  for (const auto &i : globVars) rec2Vars[i.second->record].insert(i.second);
  for (const auto &i : locVars) rec2Vars[i.second->record].insert(i.second);
  for (const auto &r2v : rec2Vars) {
    std::string varSpacer = spacer;

    //-- begin record
    if(!r2v.first.empty()) {
      os << spacer << "  record " << r2v.first << " {\n";
      varSpacer += "  ";
    }

    //-- process each variable in the record
    for(const Var &v : r2v.second) {
      //-- process an input variable
      if(v->isInput) {
        if(v->getScope() == dmpl::Variable::GLOBAL)
          os << varSpacer << "  global " << v->toString() << " = extern;\n";
        else
          os << varSpacer << "  local " << v->toString() << " = extern;\n";
        continue;
      }

      //-- process non-initialized variable
      if(v->initFunc == NULL) {
        if(v->getScope() == dmpl::Variable::GLOBAL)
          os << varSpacer << "  global " << v->toString() << ";\n";
        else
          os << varSpacer << "  local " << v->toString() << ";\n";
        continue;
      }

      //-- process initialized variable
      if(v->getScope() == dmpl::Variable::GLOBAL)
        os << varSpacer << "  global " << v->toString() << " = {\n";
      else
        os << varSpacer << "  local " << v->toString() << " = {\n";

      //-- print temporary variables in constructor
      for(const auto &tv : v->initFunc->temps)
        tv.second->printInit(os, r2v.first.empty() ? indent+4 : indent+6);

      //-- print statements in constructor
      for(const Stmt &st : v->initFunc->body)
        st->print(os, r2v.first.empty() ? indent+4 : indent+6);
      os << varSpacer << "  };\n\n";
    }

    //-- end record
    if(!r2v.first.empty()) {
      const Record &r = records[r2v.first];
      if(r->initFunc == NULL) os << spacer << "  }\n\n";
      else {
        os << spacer << "  } = {\n";

        //-- print temporary variables in constructor
        for(const auto &tv : r->initFunc->temps) tv.second->printInit(os, indent+4);

        //-- print statements in constructor
        for(const Stmt &st : r->initFunc->body) st->print(os, indent+4);

        os << spacer << "  }\n\n";
      }
    }
  }

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

dmpl::Func
dmpl::BaseNode::findFunc(const std::string& name) const
{
  Funcs::const_iterator ret = funcs.find(name);
  if(ret != funcs.end())
    return ret->second;
  return program->findFunc(name);
}


void
dmpl::BaseNode::analyzeThreads()
{
  threads.clear();
  int curID = 0;
  BOOST_FOREACH(const Funcs::value_type &f, funcs)
  {
    const Func &func = f.second;
    if(func->isThread())
    {
      func->threadID = curID;
      ++curID;
      threads.push_back(func);
    }
  }
  SymbolUser::analyzeSymbolUsage(*this);
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
