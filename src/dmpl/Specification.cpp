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

#include "Specification.hpp"
#include "Node.h"
#include "Function.h"

/*********************************************************************/
//-- compute set of functions called transitively
/*********************************************************************/
dmpl::AccessInfo dmpl::Specification::computeAccessInfo(const Role &role_)
{
  AccessInfo accInfo;
  
  //-- if the specification does not call a function, do nothing
  Func calledFunc = getFunc();
  if(calledFunc == NULL) return accInfo;
  
  FuncList allFuncs;
  if(role_) allFuncs = role_->allFuncsInScope();
  else {
    for(const auto &f : node->funcs) allFuncs.push_back(f.second);
  }

  accInfo.calledFuncs.insert(std::make_pair(calledFunc->name,calledFunc));
  Funcs frontier = accInfo.calledFuncs;
  while(!frontier.empty()) {
    Funcs newFront;
    for(const auto &f1 : frontier) {
      for(const auto &f2 : f1.second->accInfo.calledFuncs) {
    
        for(const auto &f3 : allFuncs) {
          if(!f3->equalType(*f2.second)) continue;
          
          //std::cout << "** Specification : " << name << " calls function "
          //<< f2.second->name << '\n';
          if(accInfo.calledFuncs.insert(std::make_pair(f3->name,f3)).second)
            newFront.insert(std::make_pair(f3->name,f3));
          break;
        }        
      }
    }
    frontier = newFront;
  }

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
  
  VarList allVars = role_ ? role_->allVarsInScope() : node->allVars();
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

  //-- all done
  return accInfo;
}

/*********************************************************************/
//-- needed for symbol usage analysis
/*********************************************************************/
dmpl::SymUserList dmpl::ExpectSpec::getParents(Context &con)
{
  SymUserList ret;
  ret.push_back(func);
  return ret;
}

/*********************************************************************/
//-- set function evaluating the property
/*********************************************************************/
void dmpl::ExpectSpec::setFunc()
{
  if(role == NULL) {
    func = node->findFunc(funcName);
    if(func == NULL)
      throw std::runtime_error("ERROR: function " + funcName + " for expect spec " +
                               name + " not found in node " + node->name + "!!");
    if(!func->isPure)
      throw std::runtime_error("ERROR: non-pure function " + funcName + " for expect spec " +
                               name + " in node " + node->name + "!!");    
  } else {
    func = role->findFunc(funcName);
    if(func == NULL)
      throw std::runtime_error("ERROR: function " + funcName + " for expect spec " +
                               name + " not found in role " + role->name +
                               " of node " + node->name + "!!");
    if(!func->isPure)
      throw std::runtime_error("ERROR: non-pure function " + funcName + " for expect spec " +
                               name + " in role " + role->name +
                               " of node " + node->name + "!!");
  }
}


/*********************************************************************/
//-- needed for symbol usage analysis
/*********************************************************************/
dmpl::SymUserList dmpl::RequireSpec::getParents(Context &con)
{
  SymUserList ret;
  ret.push_back(func);
  return ret;
}

/*********************************************************************/
//-- set function evaluating the property
/*********************************************************************/
void dmpl::RequireSpec::setFunc()
{
  if(role == NULL) {
    func = node->findFunc(funcName);
    if(func == NULL)
      throw std::runtime_error("ERROR: function " + funcName + " for require spec " +
                               name + " not found in node " + node->name + "!!");
    if(!func->isPure)
      throw std::runtime_error("ERROR: non-pure function " + funcName + " for require spec " +
                               name + " in node " + node->name + "!!");    
  } else {
    func = role->findFunc(funcName);
    if(func == NULL)
      throw std::runtime_error("ERROR: function " + funcName + " for require spec " +
                               name + " not found in role " + role->name +
                               " of node " + node->name + "!!");
    if(!func->isPure)
      throw std::runtime_error("ERROR: non-pure function " + funcName + " for require spec " +
                               name + " in role " + role->name +
                               " of node " + node->name + "!!");
  }
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
