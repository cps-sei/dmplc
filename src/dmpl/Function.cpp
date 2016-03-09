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
//-- return true if this function calls the argument function
/*********************************************************************/
bool dmpl::AccessInfo::canCall(const Func &func) const
{
  for(const auto &f : calledFuncs)
    if(f.second->equalType(*func)) return true;
  return false;
}

/*********************************************************************/
//-- return the set of all accessed local variables
/*********************************************************************/
dmpl::Vars dmpl::AccessInfo::accessedLoc() const
{
  Vars res = readsLoc;
  res.insert(writesLoc.begin(), writesLoc.end());
  return res;
}

/*********************************************************************/
//-- return the set of all accessed global variables
/*********************************************************************/
dmpl::Vars dmpl::AccessInfo::accessedGlob() const
{
  Vars res = readsGlob;
  res.insert(writesGlob.begin(), writesGlob.end());
  return res;
}

/*********************************************************************/
//-- return the set of all accessed group variables
/*********************************************************************/
dmpl::Vars dmpl::AccessInfo::accessedGroup() const
{
  Vars res = readsGroup;
  res.insert(writesGroup.begin(), writesGroup.end());
  return res;
}

/*********************************************************************/
//-- return the set of all read variables
/*********************************************************************/
dmpl::Vars dmpl::AccessInfo::reads() const
{
  Vars res = readsGlob;
  res.insert(readsLoc.begin(), readsLoc.end());
  res.insert(readsGroup.begin(), readsGroup.end());
  return res;
}

/*********************************************************************/
//-- return the set of all written variables
/*********************************************************************/
dmpl::Vars dmpl::AccessInfo::writes() const
{
  Vars res = writesGlob;
  res.insert(writesLoc.begin(), writesLoc.end());
  res.insert(writesGroup.begin(), writesGroup.end());
  return res;
}

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

  if (f.params.empty()) setParams(of->params);
  else if (of->params.size() != 0)
    throw std::runtime_error("Cannot merge functions which both have parameters: for " + f.name);

  if (f.temps.empty()) setTemps(of->temps);
  else if (of->temps.size() != 0)
    throw std::runtime_error("Cannot merge functions which both have temporaries: for " + f.name);

  if (f.body.empty())
    f.body = of->body;
  else if (!of->body.empty())
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
  for(const dmpl::Var v : temps) v->printInit (os,indent + 2);

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
//-- compute set of functions called directly
/*********************************************************************/
void dmpl::Function::computeCalledDirect()
{
  //-- clear previous results
  accInfo.calledFuncs.clear();

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
      accInfo.calledFuncs.insert(std::make_pair(f->name,f));
      break;
    }
  }
}

/*********************************************************************/
//-- compute set of functions called transitively
/*********************************************************************/
void dmpl::Function::computeCalledTransitive()
{
  FuncList allFuncs;
  if(role) allFuncs = role->allFuncsInScope();
  else {
    for(const auto &f : node->funcs) allFuncs.push_back(f.second);
  }

  Funcs frontier = accInfo.calledFuncs;
  while(!frontier.empty()) {
    Funcs newFront;
    for(const auto &f1 : frontier) {
      for(const auto &f2 : f1.second->accInfo.calledFuncs) {
    
        for(const auto &f3 : allFuncs) {
          if(!f3->equalType(*f2.second)) continue;
          
          //std::cout << "** Function : " << name << " calls function "
          //<< f2.second->name << '\n';
          if(accInfo.calledFuncs.insert(std::make_pair(f3->name,f3)).second)
            newFront.insert(std::make_pair(f3->name,f3));
          break;
        }        
      }
    }
    frontier = newFront;
  }
}

/*********************************************************************/
//-- set accessed variables
/*********************************************************************/
void dmpl::Function::computeAccessed()
{
  //-- collect all symbols used by this function and all called
  //-- functions
  UsedSymbols aus = allUsedSymbols;
  for(const auto &f : accInfo.calledFuncs) {
    /*
    std::cout << "**** node " << node->name
              << " role " << (role ? role->name : "null")
              << " func " << name << " +++++ calls ++++>"
              << " node " << f.second->node->name
              << " role " << (f.second->role ? f.second->role->name : "null")
              << " func " << f.second->name << '\n';
    */
    aus.insert(aus.end(),f.second->allUsedSymbols.begin(),f.second->allUsedSymbols.end());
  }

  //-- clear previous results
  accInfo.clearAccessed();
  
  VarList allVars = role ? role->allVarsInScope() : node->allVars();
  std::set<std::string> processed;
  for(const auto &use : aus) {
    //-- skip duplicate symbols
    if(!processed.insert(use.sym->getName()).second) continue;
    
    //-- variables
    Var var = use.sym->asVar();
    if(var == NULL) continue;

    /*
    std::cout << "== node " << node->name
              << " role " << (role ? role->name : "null")
              << " func " << name << " accesses " << var->name << '\n';
    */
    
    for(const Var &v : allVars) {
      if(!(*v == *var)) continue;

      if(var->scope == Symbol::LOCAL) {
        if(use.info.anyWrite()) {
          accInfo.writesLoc.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " writes local " << var->name << '\n';
        }
        if(use.info.anyRead()) {
          accInfo.readsLoc.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " reads local " << var->name << '\n';
        }
      } else if(var->scope == Symbol::GLOBAL) {
        if(use.info.anyWrite()) {
          accInfo.writesGlob.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " writes global " << var->name << '\n';
        }
        if(use.info.anyRead()) {
          accInfo.readsGlob.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " reads global " << var->name << '\n';
        }
      } else if(var->scope == Symbol::GROUP) {
        if(use.info.anyWrite()) {
          accInfo.writesGroup.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " writes group " << var->name << '\n';
        }
        if(use.info.anyRead()) {
          accInfo.readsGroup.insert(std::make_pair(var->name,var));
          //std::cout << "** Function : " << name << " reads group " << var->name << '\n';
        }
      }
      break;
    }
  }
}

/*********************************************************************/
//end of file
/*********************************************************************/
