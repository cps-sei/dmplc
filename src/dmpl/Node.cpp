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
dmpl::Node::mergeWith(const Node &on)
{
  Node &n = *this;

  if (n.abstract && !on.abstract)
    n.abstract = false;

  if (n.name == "")
    n.name = on.name;
  else if (n.name != on.name)
    throw std::runtime_error("Cannot merge nodes of differing names: " + n.name + " and " + on.name);

  if (n.args.size() == 0)
    n.args = on.args;
  else if (!on.abstract && n.args != on.args)
    throw std::runtime_error("Cannot merge nodes which have different arguments: for " + n.name);

  BOOST_FOREACH(const Vars::value_type &v, on.globVars)
  {
    if(n.globVars.count(v.second->name) == 0)
      n.globVars[v.second->name] = v.second;
    else if(n.globVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging node globals: " + v.second->name + " in " + n.name);
  }

  BOOST_FOREACH(const Vars::value_type &v, on.locVars)
  {
    if(n.locVars.count(v.second->name) == 0)
      n.locVars[v.second->name] = v.second;
    else if(n.locVars[v.second->name]->type != v.second->type)
      throw std::runtime_error("Collision while merging node locals: " + v.second->name + " in " + n.name);
  }

  BOOST_FOREACH(const Funcs::value_type &f, on.funcs)
  {
    if(n.funcs.count(f.second->name) == 0)
      n.funcs[f.second->name] = f.second;
    else
      n.funcs[f.second->name]->mergeWith(f.second);
  }

  BOOST_FOREACH(const Attributes::value_type &a, on.attrs)
  {
    if(n.attrs.count(a.second.name) == 0)
      n.attrs[a.second.name] = a.second;
    else if (n.attrs[a.second.name].paramList != a.second.paramList)
      throw std::runtime_error("Cannot merge nodes with attributes of differing parameters: @" + a.second.name + " in " + n.name);
  }

  BOOST_FOREACH(const Specs::value_type &s, on.specs) {
    if(!specs.insert(s).second)
      throw std::runtime_error("ERROR: duplication specificaion " + s.first);
  }
}

/*********************************************************************/
//-- print a node to an output stream with indentation
/*********************************************************************/
void
dmpl::Node::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << "node " << name << "\n" << spacer << "{\n";  

  //-- group all variables by init functions, and then print groups
  //-- one by one. as a special case, if the initFunc is an empty
  //-- pointer then the variable is an input.
  std::map< dmpl::Func,std::set<dmpl::Var> > init2Vars;
  for (const auto &i : globVars) init2Vars[i.second->initFunc].insert(i.second);
  for (const auto &i : locVars) init2Vars[i.second->initFunc].insert(i.second);
  for (const auto &i : init2Vars) {
    //-- if input variable
    if(i.first.use_count() == 0) {
      for (const Var &v : i.second) {
        if(globVars.count(v->name))
          os << spacer << "  global " << v->toString() << " = extern;\n";
        else
          os << spacer << "  local " << v->toString() << " = extern;\n";
      }
      continue;
    }

    //-- otherwise, initialized variable
    os << spacer << "  initialize {\n";
      for (const Var &v : i.second) {
        if(globVars.count(v->name))
          os << spacer << "    global " << v->toString() << ";\n";
        else
          os << spacer << "    local " << v->toString() << ";\n";
      }
    os << spacer << "  } {\n";
    //-- print temporary variables in constructor
    for(const auto &tv : i.first->temps) {
      tv.second->print(os, indent+4);
      os << " = " << tv.second->initExpr()->toString() << ";\n";
    }
    //-- print statements in constructor
    for(const Stmt &st : i.first->body) st->print(os, indent+4);
    os << spacer << "  }\n\n";
  }

  for (dmpl::Funcs::iterator i = funcs.begin ();i != funcs.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  for (auto i = specs.begin ();i != specs.end (); ++i)
    i->second->print (os,indent+2);
  os << "\n";

  os << spacer << "}\n\n";
}

dmpl::Func
dmpl::Node::findFunc(const std::string& name) const
{
  Funcs::const_iterator ret = funcs.find(name);
  if(ret != funcs.end())
    return ret->second;
  return program->findFunc(name);
}


void
dmpl::Node::analyzeThreads()
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
