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

#ifndef _DMPL_NODE_H_
#define _DMPL_NODE_H_

/**
 * @file Node.h
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
#include "Role.h"
#include "Specification.hpp"
#include "Record.hpp"

namespace dmpl
{
  //-- forward declarations
  class Program;

  /**
    * @class Node
    * @brief Represents a process in a distributed program
    */
  class BaseNode : public HasAttributes
  {
  public:    
    /// Owning Program object
    Program *program;

    /**
     * The node name
     **/
    std::string name;

    virtual std::string getName() const { return name; }

    ///the node arguments
    std::vector<std::string> args;

    ///map from names to roles
    Roles roles;

    ///id variable (named by the single entry in args).
    Var idVar;

    ///true if this is an abstract node definition (no function bodies)
    bool abstract;

    /**
     * list of global variables
     **/
    Vars globVars;

    ///list of local variables
    Vars locVars;

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

    ///constructors
    BaseNode(bool abst = false) : program(NULL), abstract(abst) {}
    BaseNode(const std::string &n, bool abst = false)
      : program(NULL), name(n), abstract(abst) {}
    BaseNode(const std::string &n, const Attributes& a, bool abst = false)
      : program(NULL), name(n), HasAttributes(a), abstract(abst) {}

    void initArgs()
    {
      if(idVar == NULL && args.size() == 1)
      {
        idVar = std::make_shared<Var::element_type>(args[0], intType());
        idVar->scope = Variable::SELF_ID;
      }
      else
      {
        throw std::runtime_error("Node must have exactly one parameter (its id)");
      }
    }

    //-- find variable with given name. return empty variable if no
    //-- such variable found.
    Var findVar(const std::string& name) const
    {
      if(idVar && idVar->name == name) return idVar;

      Vars::const_iterator ret = locVars.find(name);
      if(ret != locVars.end()) return ret->second;

      ret = globVars.find(name);
      if(ret != globVars.end()) return ret->second;

      return Var();
    }

    Func findFunc(const std::string& name) const;

    //-- find symbol with given name. return empty symbol if no such
    //-- symbol found.
    Sym findSym(const std::string& name) const
    {
      Var v = findVar(name);
      if(v) return Sym(std::static_pointer_cast<Sym::element_type>(v));

      Func f = findFunc(name);
      if(f) return Sym(std::static_pointer_cast<Sym::element_type>(f));

      return Sym();
    }

    ///clear the node -- reset it to an empty node
    void clear()
    {
      name.clear(); args.clear(); 
      globVars.clear(); locVars.clear();
      funcs.clear(); attrs.clear();
    }

    ///add a block of variables, with scope already set
    void addVarBlock(const VarList &vb)
    {
      BOOST_FOREACH(const Var &v,vb) {
        Vars &vars = v->scope == Variable::LOCAL ? locVars : globVars;
        assert(vars.count(v->name) == 0 && "ERROR: variable redeclared!!");
        vars[v->name] = v;
      }
    }

    ///add a record
    void addRecord(const Record &r)
    {
      records.insert(std::make_pair(r->name,r));
      BOOST_FOREACH(const Var &v,r->vars) {
        Vars &vars = v->scope == Variable::LOCAL ? locVars : globVars;
        assert(vars.count(v->name) == 0 && "ERROR: variable redeclared!!");
        vars[v->name] = v;
      }
    }

    ///add a function
    void addFunction(const Func &f)
    {
      auto it = funcs.find(f->name);
      if(it == funcs.end()) funcs.insert(std::make_pair(f->name, f));
      else it->second->mergeWith(f);
    }

    ///add a role
    void addRole(const Role &r)
    {
      auto it = roles.find(r->name);
      if(it == roles.end()) roles.insert(std::make_pair(r->name, r));
      else it->second->mergeWith(r);
    }

    ///add a specification
    void addSpecification(const Spec &s)
    {
      if(!specs.insert(std::make_pair(s->name,s)).second)
        throw std::runtime_error("ERROR: duplicate specificaion " + s->name);
    }

    ///return true if the argument is the name of a defined DMPL function of this node
    bool isFunction(const std::string &fn)
    {
      return funcs.count(fn) > 0;
    }

    void mergeWith(const Node &on);

    void analyzeThreads();

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);
  };


  /**
   * A mapping of node types to node definitions
   **/
  typedef std::map <std::string, Node> Nodes;
}

#endif // _DMPL_NODE_H_
