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

#ifndef _DMPL_NODEROLE_HPP_
#define _DMPL_NODEROLE_HPP_

/**
 * @file Node.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains the definition of a base class of nodes and roles.
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

namespace dmpl
{
  //-- forward declarations
  class Program;

  /**
    * @class NodeRole
    * @brief A base class for nodes and roles. This eliminates lots of
    * duplicated code between BaseNode and BaseRole since the two
    * classes represent similar concepts and hence have lots of common
    * fields and methods.
    */
  class NodeRole : public HasAttributes
  {
  public:
    //-- constructors
    NodeRole(bool abs = false) : abstract(abs) {}
    NodeRole(const std::string &n, bool abs = false) : name(n), abstract(abs) {}
    NodeRole(const std::string &n,const Attributes& a, bool abs = false)
      : name(n), HasAttributes(a), abstract(abs) {}

    /**
     * The role name
     **/
    std::string name;

    //-- return the name
    virtual std::string getName() const { return name; }

    //-- return a description of the node/role
    virtual std::string getDesc() const = 0;
    
    ///true if this is an abstract node definition (no function bodies)
    bool abstract;

    /**
     * list of global variables
     **/
    Vars globVars;

    ///list of local variables
    Vars locVars;

    ///list of group variables
    Vars groupVars;

    /**
     * records
     **/
    Records records;
    
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

    //-- return all local, global and group variables declared in this node/role
    virtual VarList allVars() const
    {
      VarList res;
      for(const auto &v : globVars) res.push_back(v.second);
      for(const auto &v : locVars) res.push_back(v.second);
      for(const auto &v : groupVars) res.push_back(v.second);
      return res;
    }
    
    //-- find variable with given name. return empty variable if no
    //-- such variable found.
    virtual Var findVar(const std::string& name) const
    {
      Vars::const_iterator ret = locVars.find(name);
      if(ret != locVars.end()) return ret->second;

      ret = globVars.find(name);
      if(ret != globVars.end()) return ret->second;

      ret = groupVars.find(name);
      if(ret != groupVars.end()) return ret->second;

      return Var();
    }

    //-- return true iff the node has a variable with the same name,
    //-- type and scope
    virtual bool hasVar(const Var &var) const
    {
      Var v = findVar(var->name);
      return v && (*v == *var);
    }
    
    //-- find record with given name. return empty record if no such
    //-- record found.
    virtual Record findRecord(const std::string& name) const
    {
      auto it = records.find(name);
      return it == records.end() ? Record() : it->second;
    }

    //-- return true iff the node has a record with the same name, and
    //-- same set of variables.
    virtual bool hasRecord(const Record &rec)
    {
      Record r = findRecord(rec->name);
      return r && (*r == *rec);
    }
    
    //-- return the list of all functions, including constructors
    virtual FuncList allFuncs() const;

    //-- find function with given name. either in this node or at the
    //-- program level.
    virtual Func findFunc(const std::string& name) const = 0;

    //-- find symbol with given name. return empty symbol if no such
    //-- symbol found.
    virtual Sym findSym(const std::string& name) const
    {
      Var v = findVar(name);
      if(v) return Sym(std::static_pointer_cast<Sym::element_type>(v));

      Record r = findRecord(name);
      if(r) return Sym(std::static_pointer_cast<Sym::element_type>(r));

      Func f = findFunc(name);
      if(f) return Sym(std::static_pointer_cast<Sym::element_type>(f));

      return Sym();
    }

    ///clear the role -- reset it to an empty role
    virtual void clear()
    {
      name.clear();
      globVars.clear(); locVars.clear(); groupVars.clear();
      funcs.clear(); attrs.clear();
    }

    ///add a variable with scope already set
    virtual void addVar(const Var &v)
    {
      std::string vscope =v->scopeStr();

      Vars &vars = (vscope == "local") ? locVars : ((vscope == "global") ? globVars : groupVars);

      if(!vars.insert(std::make_pair(v->name,v)).second) {
        throw std::runtime_error("ERROR: " + vscope + " variable " + v->name +
                                 " redeclared by " + getDesc() + "!!");
      }
    }
    
    ///add a block of variables, with scope already set
    virtual void addVarBlock(const VarList &vb)
    {
      BOOST_FOREACH(const Var &v,vb) addVar(v);
    }

    ///add variables from a map, with scope already set
    virtual void addVars(const Vars &vars)
    {
      for(const auto v : vars) addVar(v.second);
    }

    ///add a record
    virtual void addRecord(const Record &r)
    {
      if(!records.insert(std::make_pair(r->name,r)).second)
        throw std::runtime_error("ERROR: record " + r->name + " redeclared by " + getDesc() + "!!");
    }

    ///add a function
    virtual void addFunction(const Func &f)
    {
      auto it = funcs.find(f->name);
      if(it == funcs.end()) funcs.insert(std::make_pair(f->name, f));
      else it->second->mergeWith(f);
    }

    ///add a specification
    virtual void addSpecification(const Spec &s)
    {
      if(!specs.insert(std::make_pair(s->name,s)).second)
        throw std::runtime_error("ERROR: duplicate specificaion " + s->name);
    }

    ///return true if the argument is the name of a defined DMPL
    ///function of this node
    virtual bool hasFunction(const std::string &fn) const
    {
      return funcs.find(fn) != funcs.end();
    }
  };

}

#endif // _DMPL_NODEROLE_HPP_
