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
  //-- if the specification does not call a function directly, then
  //-- nothing is accessed
  Func calledFunc = getFunc();
  if(calledFunc == NULL) return AccessInfo();

  //-- populate called functions with the function called directly
  return calledFunc->getAccessInfo(role_.get());
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
