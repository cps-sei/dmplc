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

#ifndef _DMPL_ROLE_H_
#define _DMPL_ROLE_H_

/**
 * @file Role.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains the definition of a role.
 **/

#include <vector>
#include <map>
#include <string>
#include <memory>
#include "Function.h"
#include "Variable.h"
#include "Attribute.h"
#include "Specification.hpp"
#include "Record.hpp"
#include "NodeRole.hpp"

namespace dmpl
{
  /**
   * @class IdSpec
   * Contains info from ID-based specializations (a block with a role and id
   * keyword). Only attributes can be specialized based on ID.
   **/
  class IdSpec : public HasAttributes
  {
  public:
    /// Owning Role object
    Role *role;

    int id;

    /// Sym this is associated with; NULL to associate with owning Role itself
    Sym sym;

    IdSpec(int id) : role(NULL), sym(Sym()), id(id), HasAttributes() {}
    IdSpec(int id, const Attributes &attrs)
      : role(NULL), sym(Sym()), id(id), HasAttributes(attrs) {}

    IdSpec(const Sym &sym, int id) : role(NULL), sym(sym), id(id), HasAttributes() {}
    IdSpec(const Sym &sym, int id, const Attributes &attrs)
      : role(NULL), sym(sym), id(id), HasAttributes(attrs) {}
  };

  typedef std::vector<IdSpec> IdSpecs;

  /**
    * @class BaseRole
    * @brief Represents a node's particular role; use the Role typedef
    */
  class BaseRole : public NodeRole, public std::enable_shared_from_this<BaseRole>
  {
  public:    
    /// Owning Node object
    Node node;

    ///constructors
    BaseRole(bool abst = false) : NodeRole(abst) {}
    BaseRole(const std::string &n, bool abst = false) : NodeRole(n,abst) {}
    BaseRole(const std::string &n, const Attributes& a, bool abst = false) : NodeRole(n,a,abst) {}

    //-- return a description of the role
    std::string getDesc() const { return "role " + name; }
    
    //-- return all local, global and group variables in scope, i.e.,
    //-- including the parent node as well.
    VarList allVarsInScope() const;

    //-- return all variables and records in order of dependency. V1
    //-- appears after V2 if the constructor of V1 reads V2.
    void orderVarsRecords(std::map<size_t,Var> &sortedVars,
                          std::map<size_t,Record> &sortedRecs) const;

    //-- return all records in scope, i.e., including the parent node
    //-- as well.
    RecordList allRecordsInScope() const;

    //-- return list of all functions in scope, either in this role or
    //-- in parent node
    FuncList allFuncsInScope() const;

    //-- return list of all initializer constructors in scope, either
    //-- in this role or in parent node
    FuncList allInitConsInScope() const;

    //-- return list of all assume constructors in scope, either in
    //-- this role or in parent node
    FuncList allAssumeConsInScope() const;
    
    //-- find function with given name. either in this role or at the
    //-- node level.
    Func findFunc(const std::string& name) const;

    ///return a pointer to the attribute with given name and number of
    ///arguments in the given function. if the function itself does
    ///not have the attributed, then look in the function it inherits
    ///(if any) from in the parent node. return NULL if no such
    ///attribute found.
    const Attribute *getAttribute(const Func &func, const std::string &name,
                                  int expectedArgs) const;

    ///find the platform initialzer function in this role or in the
    ///parent node
    Func findPlatformInitializer();

    ///returns true if this role overrides function with given name
    bool overridesFunction(const std::string &fn)
    {
      const auto &f = funcs.find(fn);
      return (f != funcs.end()) && f->second->isOverride;
    }
    
    ///merge with another role
    void mergeWith(const Role &on);

    //-- returns true if the argument is a serial function for this role
    bool isSerialFunction(const Func &func) const;
    
    //-- return the set of functions that are called before threads
    //-- are spawned, e.g., the platform initializer, and functions
    //-- called from constructors.
    Funcs serialFunctions() const;

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);
  };
}

#endif // _DMPL_ROLE_H_
