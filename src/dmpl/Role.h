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
 * This file contains the definition of a node/process.
 **/

#include <vector>
#include <map>
#include <string>
#include <memory>
#include "Function.h"
#include "Variable.h"
#include "Attribute.h"
#include "Specification.hpp"

namespace dmpl
{
  class Node;

  class RoleClass;

  typedef std::shared_ptr<RoleClass> Role;

  typedef std::vector<Role> Roles;

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
    * @class RoleClass
    * @brief Represents a node's particular role; use the Role typedef
    */
  class RoleClass : public HasAttributes, public std::enable_shared_from_this<RoleClass>
  {
  public:    
    /// Owning Node object
    Node *node;

    /**
     * The role name
     **/
    std::string name;

    virtual std::string getName() const { return name; }

    ///true if this is an abstract role definition (no function bodies)
    bool abstract;

    /**
     * list of global variables
     **/
    Vars globVars;

    ///list of local variables
    Vars locVars;
    
    /**
     * A map of function names to function definitions
     **/
    Funcs funcs;

    /**
     * A list of functions that are threads. Each thread gets a unique index
     **/
    std::vector<Func> threads;

    ///map from names to specifications (expect or require) declared
    ///at node level
    Specs specs;

    ///constructors
    RoleClass(bool abst = false) : node(NULL), abstract(abst) {}
    RoleClass(const std::string &n, bool abst = false)
        : node(NULL), name(n), abstract(abst) {}
    RoleClass(const std::string &n, const Attributes& a, bool abst = false)
        : node(NULL), name(n), HasAttributes(a), abstract(abst) {}

    Var findVar(const std::string& name) const
    {
      Vars::const_iterator ret = locVars.find(name);
      if(ret != locVars.end())
        return ret->second;
      ret = globVars.find(name);
      if(ret != globVars.end())
        return ret->second;
      return Var();
    }

    Func findFunc(const std::string& name) const;

    Sym findSym(const std::string& name) const
    {
      Var v = findVar(name);
      if(v)
        return Sym(std::static_pointer_cast<Sym::element_type>(v));
      Func f = findFunc(name);
      if(f)
        return Sym(std::static_pointer_cast<Sym::element_type>(f));
      return Sym();
    }

    ///clear the role -- reset it to an empty role
    void clear()
    {
      name.clear();
      globVars.clear(); locVars.clear();
      funcs.clear(); attrs.clear();
    }

    ///add a global variable
    void addGlobalVar(const VarList &vl)
    {
      BOOST_FOREACH(const Var &v,vl) {
        assert(globVars.count(v->name) == 0 && "ERROR: global variable redeclared!!");
        globVars[v->name] = v;
        globVars[v->name]->scope = Variable::GLOBAL;
      }
    }

    ///add a local variable
    void addLocalVar(const VarList &vl)
    {
      BOOST_FOREACH(const Var &v,vl) {
        assert(locVars.count(v->name) == 0 && "ERROR: loc variable redeclared!!");
        locVars[v->name] = v;
        locVars[v->name]->scope = Variable::LOCAL;
      }
    }

    ///add variables, with scope already set
    void addVar(const VarList &v1)
    {
      BOOST_FOREACH(const Var &v,v1) {
        Vars &vars = v->scope == Variable::LOCAL ? locVars : globVars;
        assert(vars.count(v->name) == 0 && "ERROR: variable redeclared!!");
        vars[v->name] = v;
      }
    }

    ///add a function
    void addFunction(const Func &f)
    {
      if(funcs.count(f->name) > 0) {
        Func &of = funcs[f->name];
        of->mergeWith(f);
      }
      else
      {
        funcs[f->name] = f;
      }
    }

    ///add a specification
    void addSpecification(const Spec &s)
    {
      auto it = specs.find(s->name);
      assert(it == specs.end() && "ERROR: duplicate specification with same name!!");
      specs.emplace(s->name,s);
    }

    ///return true if the argument is the name of a defined DMPL function of this node
    bool isFunction(const std::string &fn)
    {
      return funcs.count(fn) > 0;
    }

    void mergeWith(const Role &on);

    void analyzeThreads();

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);
  };
}

#endif // _DMPL_ROLE_H_
