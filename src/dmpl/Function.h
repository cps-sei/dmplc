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

#ifndef _DMPL_FUNCTION_H_
#define _DMPL_FUNCTION_H_

/**
 * @file Function.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for function definitions.
 **/

#include <vector>
#include <map>
#include <set>
#include <string>
#include "Symbol.h"
#include "Variable.h"
#include "Statement.h"
#include "Attribute.h"
#include "Specification.hpp"
#include "../dmplc/dmpl-parser.hpp"


namespace dmpl
{
  /**
    * @class Function
    * @brief Represents a function definition
    */
  class Function : public Symbol, public SymbolUser
  {
  public:
    /**
     * The name of the function
     **/
    std::string name;

    virtual std::string getName() const { return name; }

    ///Is this function EXTERN?
    bool isExtern;

    ///Is this function PURE? i.e., no side effects (but may read MADARA vars)
    bool isPure;

    ///Is this just a prototype without a body
    bool isPrototype;

    ///Is the function overriding another
    bool isOverride;

    ///the return type of the function
    Type retType;

    ///each thread function gets a unique id; all thread IDs are contiguous,
    //starting with 0. A non-thread function has id -1
    int threadID;

    //-- the node and role which this function belongs to. these are
    //-- assigned after parsing.
    Node node;
    Role role;
    
    virtual const Type &getType() { return retType; }

    /**
     * The function parameters. we maintain both a list because order
     * matters and a set for quick lookup.
     **/
    VarList params;
    Vars paramSet;
    
    ///function local variables -- we call them temporary variables
    ///since their scope is only the function body
    Vars temps;

    //VarList writesTo;
    //VarList readsFrom;

    /**
     * The function body
     **/
    StmtList body;

    virtual SymUserList getParents(Context &con);

    virtual bool recordUse() { return true; }
    
    //-- return true if this function is a thread
    bool isThread()
    {
      return retType->type == TTHREAD;
    }

    //-- find temporay or parameter variable with given name. return
    //-- NULL variable if no such variable exists.
    Var findVar(const std::string& name) const
    {
      Vars::const_iterator ret = temps.find(name);
      if(ret != temps.end()) return ret->second;

      ret = paramSet.find(name);
      if(ret != paramSet.end()) return ret->second;

      return Var();
    }

    //constructors
    Function()
      : isExtern(false), isPure(false), isPrototype(false), isOverride(false), threadID(-1) {}
    Function(const std::string &n)
      : name(n), isExtern(false), isPure(false), isPrototype(false), isOverride(false), threadID(-1) {}
    Function(const std::string &n, const Attributes &a)
      : name(n), Symbol(a), isOverride(false), threadID(-1) {}
    Function(const Type &rt,const std::string &n,const VarList &p,
             const VarList &t,const StmtList &b,
             const Attributes &a = Attributes())
      : retType(rt), name(n), body(b), Symbol(a), isExtern(false),
      isPure(false), isPrototype(false), isOverride(false), threadID(-1)
    {
      setParams(p);
      setTemps(t);
    }
    Function(const Type &rt,const std::string &n,const Vars &p,
             const Vars &t,const StmtList &b,
             const Attributes &a = Attributes())
      : retType(rt), name(n), body(b), Symbol(a), paramSet(p), temps(t),
      isExtern(false), isPure(false), isPrototype(false), isOverride(false), threadID(-1)
    {
      BOOST_FOREACH(const Vars::value_type &v,p) { params.push_back(v.second); }
    }

    void mergeWith (const Func &of, bool checkDecors = true);

    void setParams (const VarList &p)
    {
      params = p;
      doSetVars(p, paramSet);
    }

    void setTemps (const VarList &t)
    {
      doSetVars(t, temps);
    }

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);

    ///print just the function declaration
    void printDecl (std::ostream &os,unsigned int indent);    

    //-- return a string representation. just the name.
    std::string toString() const { return "function : " + name; }

    //-- compare with another function in terms of name and types
    //-- (return as well as parameter)
    bool equalType(const Function &rhs) const
    {
      //-- compare name, return type, and number of parameters
      if(name != rhs.name) return false;
      if(!(*retType == *(rhs.retType))) return false;
      if(params.size() != rhs.params.size()) return false;

      //-- compare parameter types
      auto it1 = params.begin(), it2 = rhs.params.begin();
      for(;it1 != params.end();++it1, ++it2)
        if(!(*((*it1)->type) == *((*it2)->type))) return false;

      return true;
    }
    
  private:
    void doSetVars (const VarList &vars, Vars &dest)
    {
      BOOST_FOREACH(const Var &v,vars) dest[v->name] = v;
    }
  };

  typedef std::map <std::string, Func> Funcs;
  typedef std::map <std::string, Function> Functions;

  inline Func Symbol::asFunc()
  {
    return std::dynamic_pointer_cast<Func::element_type>(shared_from_this());
  }

  /*
  class Thread
  {
  public:
    const Function &startFunc;

    std::set <const Function *> calledFuncs;
    std::set <const Variable *> readVars;
    std::set <const Variable *> writeVars;

    Thread(const Function &f) : startFunc(f)
    {
      analyze(f);
    }
  private:
    void analyze(const Function &function);
    void analyze(const Stmt &statement);
    void analyze(const Expr &expression);
  };

  typedef std::map <std::string, Thread> Threads;*/
}

#endif // _DMPL_FUNCTION_H_
