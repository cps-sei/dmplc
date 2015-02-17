/**
 * Copyright (c) 2014 Carnegie Mellon University. All Rights Reserved.

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

 * DM-0001023
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
#include <boost/ref.hpp>
#include "Symbol.h"
#include "Variable.h"
#include "Statement.h"
#include "Attribute.h"


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

    virtual const std::string &getName() { return name; }

    ///Is this function EXTERN?
    bool isExtern;

    ///the return type of the function
    Type retType;

    virtual const Type &getType() { return retType; }

    virtual bool canWrite() { return false; }

    /**
     * The function parameters
     **/
    Vars params;
    
    ///function local variables -- we call them temporary variables
    ///since their scope is only the function body
    Vars temps;

    VarList writesTo;
    VarList readsFrom;

    // @ATTR(X, ...) attributes specified for this function
    Attributes attrs;

    /**
     * The function body
     **/
    StmtList body;

    virtual SymUserList getParents(Context con) {
      return SymUserList(body.begin(), body.end());
    }

    virtual bool recordUse() { return true; }

    Attribute *getSingleAttribute(const std::string &name)
    {
      int c = attrs.count(name);
      if (c == 0)
        return NULL;
      if (c != 1)
        throw std::runtime_error("Invalid @" + name + " attribute.");
      return &attrs[name];
    }

    bool isThread()
    {
      Attribute *a = getSingleAttribute("HERTZ");
      return a != NULL && a->requireSingleParam()->requireInt() > 0;
    }

    Var findVar(const std::string& name) const
    {
      Vars::const_iterator ret = temps.find(name);
      if(ret != temps.end())
        return ret->second;
      ret = params.find(name);
      if(ret != params.end())
        return ret->second;
      return Var();
    }

    //constructors
    Function() : isExtern(false) {}
    Function(const std::string &n)
      : name(n), isExtern(false) {}
    Function(const std::string &n, const Attributes &a)
      : name(n),attrs(a) {}
    Function(const Type &rt,const std::string &n,const VarList &p,
             const VarList &t,const StmtList &b,
             const Attributes &a = Attributes())
      : retType(rt),name(n),body(b),attrs(a),isExtern(false)
    {
      setParams(p);
      setTemps(t);
    }
    Function(const Type &rt,const std::string &n,const Vars &p,
             const Vars &t,const StmtList &b,
             const Attributes &a = Attributes())
      : retType(rt),name(n),body(b),attrs(a),params(p),temps(t),isExtern(false)
    { }

    void mergeWith (const Func &of);

    void setParams (const VarList &p)
    {
      doSetVars(p, params);
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
  private:
    void doSetVars (const VarList &vars, Vars &dest)
    {
      BOOST_FOREACH(const Var &v,vars) dest[v->name] = v;
    }
  };

  typedef std::map <std::string, Func> Funcs;
  typedef std::map <std::string, Function> Functions;

  inline Func Sym::asFunc()
  {
    return boost::dynamic_pointer_cast<Func::element_type>(*this);
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
