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
#include <stdio.h>
#include <boost/foreach.hpp>
#include "Variable.h"
#include "Function.h"
#include "Node.h"
#include "Role.h"

/*********************************************************************/
//constructors
/*********************************************************************/
//constructor with name only -- assigns a default type and scope
dmpl::Variable::Variable(const std::string &n) 
  : name(n),type(dmpl::Type(new BaseType())),scope(0),isInput(false),isOverride(false) {}

//constructor with name and type -- assigns a default scope
dmpl::Variable::Variable(const std::string &n,const dmpl::Type &t) 
  : name(n),type(t),scope(0),isInput(false),isOverride(false) {}

//constructor with name and dimensions -- assigns a default base type
//and scope
dmpl::Variable::Variable(const std::string &n,const Dims &d) 
  : name(n),type(dmpl::Type(new BaseType(d))),scope(0),isInput(false),isOverride(false) {}

/*********************************************************************/
///convert to string
/*********************************************************************/
std::string dmpl::Variable::toString() const
{
  std::string res = type->toString() + " " + (isInput ? "input " : "") + name;
  BOOST_FOREACH(int d,type->dims) {
    res += "[" + ((d == -1) ? "#N" : std::to_string(d)) + "]";
  }
  return res;
}

/*********************************************************************/
///print with indentation
/*********************************************************************/
void
dmpl::Variable::print (std::ostream &os,unsigned int indent)
{
  std::string spacer(indent, ' ');
  os << spacer << toString();
}

/*********************************************************************/
///print with indentation and initialization, if any
/*********************************************************************/
void
dmpl::Variable::printInit (std::ostream &os,unsigned int indent)
{
  std::string spacer(indent, ' ');

  //-- print scope and variable
  if(scope == GLOBAL)
    os << spacer << (isOverride && record.empty() ? "override " : "") << "global " << toString();
  else if(scope == LOCAL)
    os << spacer << (isOverride && record.empty() ? "override " : "") << "local " << toString();
  else if(scope == GROUP)
    os << spacer << (isOverride && record.empty() ? "override " : "") << "group " << toString();
  else
    os << spacer << toString();

  //-- print initializer
  if(initFunc != NULL) {
    Expr ie = isInput ? assumeExpr() : initExpr();
    if (ie != NULL) os << ' ' << (isInput ? '~' : '=') << ' ' << ie->toString() << ";\n";
    else {
      os << ' ' << (isInput ? '~' : '=') << " {\n";

      //-- print temporary variables in constructor
      for(const Var &tv : initFunc->temps) tv->printInit(os, indent+2);

      //-- print statements in constructor
      for(const Stmt &st : initFunc->body) st->print(os, indent+2);

      os << spacer << "};\n";
    }
  } else os << ";\n";
}

/*********************************************************************/
///print in C syntax, e.g., no input keyword
/*********************************************************************/
void
dmpl::Variable::printC (std::ostream &os,unsigned int indent)
{
  std::string res(indent, ' ');

  res += type->toString() + " " + name;
  BOOST_FOREACH(int d,type->dims) {
    res += "[" + ((d == -1) ? "#N" : std::to_string(d)) + "]";
  }
  
  os << res;
}

/*********************************************************************/
///return a copy but instantiate dimension #N with nodeNum
/*********************************************************************/
dmpl::Var dmpl::Variable::instDim(size_t nodeNum) const
{
  Var res(new Variable(*this));
  res->type = res->type->instDim(nodeNum);
  return res;
}

/*********************************************************************/
///return a copy but change name to name+ext
/*********************************************************************/
dmpl::Var dmpl::Variable::instName(std::string ext) const
{
  Var res(new Variable(*this));
  res->name = res->name + ext;
  return res;
}

/*********************************************************************/
///return a copy with one less dimension
/*********************************************************************/
dmpl::Var dmpl::Variable::decrDim() const
{
  Var res(new Variable(*this));
  res->type = res->type->decrDim();
  return res;  
}

/*********************************************************************/
///return a copy with one more dimension (added at front)
/*********************************************************************/
dmpl::Var dmpl::Variable::incrDim(int d) const
{
  Var res(new Variable(*this));
  res->type = res->type->incrDim(d);
  return res;  
}

/*********************************************************************/
///return the initial expression
/*********************************************************************/
dmpl::Expr dmpl::Variable::initExpr() const
{
  if(initFunc->body.size() != 1) return Expr();
  const Stmt &s = *(initFunc->body.begin());
  const AsgnStmt *asgn = dynamic_cast<const AsgnStmt*>(&*s);
  if(!asgn) return Expr();
  if(asgn->lhs->toString() != name) return Expr();
  return asgn->rhs;
}

/*********************************************************************/
///return the constraining expression of an input variable
/*********************************************************************/
dmpl::Expr dmpl::Variable::assumeExpr() const
{
  if(initFunc->body.size() != 1) return Expr();
  const Stmt &s = *(initFunc->body.begin());
  const RetStmt *ret = dynamic_cast<const RetStmt*>(&*s);
  return ret ? ret->retVal : Expr();
}

/*********************************************************************/
///check sanity of constructor
/*********************************************************************/
void dmpl::Variable::checkConstructorSanity(const Node &node, const Role &role) const
{
  if(initFunc == NULL) return;

  //-- for non-input variables
  if(!isInput) {
    for(const auto &v : initFunc->getAccessInfo(role.get()).writesLoc) {
      if(!(*v.second == *this))
        throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                                 " of node " + node->name + " constructor of variable " +
                                 name + " writes to local variable " + v.first);
    }
    for(const auto &v : initFunc->getAccessInfo(role.get()).writesGlob) {
      if(!(*v.second == *this))
        throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                                 " of node " + node->name + " constructor of variable " +
                                 name + " writes to global variable " + v.first);
    }
    for(const auto &v : initFunc->getAccessInfo(role.get()).writesGroup) {
      if(!(*v.second == *this))
        throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                                 " of node " + node->name + " constructor of variable " +
                                 name + " writes to group variable " + v.first);
    }
  }
  //-- for input variables
  else {
    if(!initFunc->getAccessInfo(role.get()).writesLoc.empty())
      throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                               " of node " + node->name + " assume function of variable " +
                               name + " writes to local variable " +
                               initFunc->getAccessInfo(role.get()).writesLoc.begin()->first);
    if(!initFunc->getAccessInfo(role.get()).writesGlob.empty())
      throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                               " of node " + node->name + " assume function of variable " +
                               name + " writes to global variable " +
                               initFunc->getAccessInfo(role.get()).writesGlob.begin()->first);
    if(!initFunc->getAccessInfo(role.get()).writesGroup.empty())
      throw std::runtime_error("ERROR: in role " + (role == NULL ? "null" : role->name) +
                               " of node " + node->name + " assume function of variable " +
                               name + " writes to group variable " +
                               initFunc->getAccessInfo(role.get()).writesGroup.begin()->first);
  }
}

/*********************************************************************/
//end of file
/*********************************************************************/
