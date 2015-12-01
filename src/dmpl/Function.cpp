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
#include "Node.h"
#include "Role.h"

/*********************************************************************/
//-- return the set of parents needed for symbol usage analysis
/*********************************************************************/
dmpl::SymUserList dmpl::Function::getParents(dmpl::Function::Context &con)
{
  return SymUserList(body.begin(), body.end());
}

/*********************************************************************/
//-- merge with another function, potentially checking consistency of
//-- attributes and types.
/*********************************************************************/
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
  else if (of->retType.get() != NULL && !(*(f.retType) == *(of->retType)))
    throw std::runtime_error("Cannot merge functions of differing return types (" +
                             f.retType->toString() + "," + of->retType->toString() + ") for " + f.name);

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

  //-- merge attributes
  if(!mergeAttributes(*of))
    throw std::runtime_error("Cannot merge attributes of function " + name + "!!");
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
  os << spacer << (isOverride ? "override " : "") << (isPure ? "pure " : "")
     << retType->toString() << " " << name;

  //-- handle non-thread function
  if(!retType->isThread()) {
    os << "(";

    //-- print parameters
    size_t count = 0;
    for (dmpl::VarList::iterator i = params.begin (); i != params.end (); ++i) {
      if(count) os << ",";
      os << (*i)->toString();
      count++;
    }

    os << ")";
  }

  if(isPrototype) { os << ";\n"; return; }
  else os << "\n";
  
  os << spacer << "{\n";

  //-- print temporary variables
  for (dmpl::Vars::iterator i = temps.begin (); i != temps.end (); ++i)
    i->second->printInit (os,indent + 2);

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

  os << spacer << (isExtern ? "extern " : "") << retType->toString() << " " << name;

  //-- handle thread function
  if(retType->isThread()) { os << ";\n"; return; }

  //-- handle normal function
  os << "(";

  size_t count = 0;
  for (dmpl::VarList::iterator i = params.begin (); i != params.end (); ++i) {
    if(count) os << ",";
    os << (*i)->toString();
    count++;
  }

  os << ");\n";
}

/*********************************************************************/
//-- set called functions
/*********************************************************************/
void dmpl::Function::computeCalled()
{
  //-- clear previous results
  calledFuncs.clear();

  FuncList allFuncs;
  if(role) allFuncs = role->allFuncsInScope();
  else {
    for(const auto &f : node->funcs) allFuncs.push_back(f.second);
  }
  
  std::set<std::string> processed;
  for(const auto &use : allUsedSymbols) {
    //-- skip duplicate symbols
    if(!processed.insert(use.sym->getName()).second) continue;

    //-- functions
    Func func = use.sym->asFunc();
    if(func == NULL)  continue;
    
    for(const auto &f : allFuncs) {
      if(!f->equalType(*func)) continue;
      
      //std::cout << "** Function : " << name << " calls function "
      //<< func->name << '\n';
      calledFuncs.push_back(f);
      break;
    }
  }
}

/*********************************************************************/
//-- set accessed variables
/*********************************************************************/
void dmpl::Function::computeAccessed(FuncSet &visited)
{
  //-- recursive process called functions and inherit, and collect
  //-- called functions
  FuncSet newCalled;
  newCalled.insert(calledFuncs.begin(), calledFuncs.end());
  for(const Func &f : calledFuncs) {
    if(visited.insert(f).second) f->computeAccessed(visited);
    inherit(f);
    newCalled.insert(f->calledFuncs.begin(), f->calledFuncs.end());
  }

  //-- update called functions
  calledFuncs.clear();
  calledFuncs.insert(calledFuncs.end(), newCalled.begin(), newCalled.end());
  
  //-- clear previous results
  writesLoc.clear(); writesGlob.clear();
  readsLoc.clear(); readsGlob.clear();
  
  VarList allVars = role ? role->allVarsInScope() : node->allVars();
  std::set<std::string> processed;
  for(const auto &use : allUsedSymbols) {
    //-- skip duplicate symbols
    if(!processed.insert(use.sym->getName()).second) continue;
    
    //-- variables
    Var var = use.sym->asVar();
    if(var == NULL) continue;

    for(const Var &v : allVars) {
      if(!(*v == *var)) continue;

      if(var->scope == Symbol::LOCAL) {
        if(use.info.anyWrite()) {
          writesLoc.push_back(var);
          //std::cout << "** Function : " << name << " writes local " << var->name << '\n';
        }
        if(use.info.anyRead()) {
          readsLoc.push_back(var);
          //std::cout << "** Function : " << name << " reads local " << var->name << '\n';
        }
      } else if(var->scope == Symbol::GLOBAL) {
        if(use.info.anyWrite()) {
          writesGlob.push_back(var);
          //std::cout << "** Function : " << name << " writes global " << var->name << '\n';
        }
        if(use.info.anyRead()) {
          readsGlob.push_back(var);
          //std::cout << "** Function : " << name << " reads global " << var->name << '\n';
        }
      }
      break;
    }
  }
}

/*********************************************************************/
//end of file
/*********************************************************************/
