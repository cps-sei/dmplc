/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of->source code must retain the above copyright
 * notice, this list of->conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of->conditions and the following
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

 * 5. Redistributions of->any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of->Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of->the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of->the author(s) and do not necessarily
 * reflect the views of->the United States Department of->Defense.

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
#include "Function.h"

void
dmpl::Function::mergeWith (const Func &of, bool checkDecors)
{
  Function &f = *this;

  if (f.name == "")
    f.name = of->name;
  else if (of->name == "")
    /* do nothing */;
  else if (f.name != of->name)
    throw std::runtime_error("Cannot merge functions of differing names: " + f.name + " and " + of->name);

  if (f.retType.get() == NULL)
    f.retType = of->retType;
  else if (of->retType.get() != NULL && !f.retType->equals(of->retType))
    throw std::runtime_error("Cannot merge functions of differing return types: for " + f.name);

  if (f.params.size() == 0)
    f.params = of->params;
  else if (of->params.size() != 0)
    throw std::runtime_error("Cannot merge functions which both have parameters: for " + f.name);

  if (f.temps.size() == 0)
    f.temps = of->temps;
  else if (of->temps.size() != 0)
    throw std::runtime_error("Cannot merge functions which both have temporaries: for " + f.name);

  if (f.body.size() == 0)
    f.body = of->body;
  else if (of->body.size() != 0)
    throw std::runtime_error("Cannot merge functions which both have bodies: for " + f.name);

  if(checkDecors) {
    if(f.isExtern != of->isExtern)
      throw std::runtime_error("Declarations have differeing extern-ness: for " + f.name);
    if(f.isPure != of->isPure)
      throw std::runtime_error("Declarations have differeing pure-ity: for " + f.name);
  }

  BOOST_FOREACH(const Attributes::value_type &a, of->attrs)
  {
    if(f.attrs.count(a.second.name) == 0)
      f.attrs[a.second.name] = a.second;
    else if (f.attrs[a.second.name].paramList != a.second.paramList)
      throw std::runtime_error("Cannot merge functions with attributes of->differing parameters: @" + a.second.name + " in " + f.name);
  }
}

/*********************************************************************/
//print function
/*********************************************************************/
void
dmpl::Function::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  //-- print attributes
  for(const auto &a : attrs) os << spacer << '@' << a.second.toString() << ";\n";
  
  //-- print return type and name
  os << spacer << retType->toString() << " " << name << "(";

  //-- print parameters
  size_t count = 0;
  for (dmpl::VarList::iterator i = params.begin (); i != params.end (); ++i) {
    if(count) os << ",";
    os << (*i)->toString();
    count++;
  }

  os << ")\n";
  os << spacer << "{\n";

  //-- print temporary variables
  for (dmpl::Vars::iterator i = temps.begin (); i != temps.end (); ++i) {
    i->second->print (os,indent + 2);
    os << ";\n";
  }

  //-- print statements
  BOOST_FOREACH(const Stmt &st,body) st->print (os,indent + 2);

  os << spacer << "}\n\n";
}

/*********************************************************************/
//print function declaration
/*********************************************************************/
void
dmpl::Function::printDecl (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << retType->toString() << " " << name << "(";

  size_t count = 0;
  for (dmpl::VarList::iterator i = params.begin (); i != params.end (); ++i) {
    if(count) os << ",";
    os << (*i)->toString();
    count++;
  }

  os << ");\n";
}

dmpl::LvalExpr::Context
dmpl::LvalExpr::useSymbols(Context con)
{
  {
    Context con2 = con;
    con.isLHS = false;
    if(node)
    {
      node->useSymbols(con2);
      inherit(node);
    }
    BOOST_FOREACH(Expr e, indices)
    {
      e->useSymbols(con2);
      inherit(e);
    }
  }
  
  sym = con.findSym(var);
  if(sym)
    sym->use(shared_from_this(), con.isLHS, node != NULL, con.inExpect());
  Func func = std::dynamic_pointer_cast<Function>(sym);
  if(func)
  {
    Context con2 = con;
    con2.curFunc = func;
    con2.isLHS = false;
    func->useSymbols(con);
  }
  //else
    //std::cerr << "Couldn't find symbol: " << var << std::endl;
  return con;
}

/*
void
dmpl::Thread::analyze (const dmpl::Function &function)
{
  calledFuncs.insert(&function);
  BOOST_FOREACH(const Stmt &st, function.body) {
    analyze(st);
  }
}

void
dmpl::Thread::analyze (const dmpl::Stmt &statement)
{
}*/

/*********************************************************************/
//end of->file
/*********************************************************************/
