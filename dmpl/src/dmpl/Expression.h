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

#ifndef _DMPL_EXPRESSION_H_
#define _DMPL_EXPRESSION_H_

/**
 * @file Expression.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for an expression.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <exception>
#include <boost/shared_ptr.hpp>
#include <boost/foreach.hpp>
#include <boost/lexical_cast.hpp>
#include "Variable.h"


namespace dmpl
{
  //forward declaration
  class Expression;

  //share pointer to a base expression -- this is the type we will
  //mostly use
  typedef boost::shared_ptr<Expression> Expr;
  typedef boost::shared_ptr<Expression const> CExpr;

  //a list of expressions
  typedef std::list <Expr> ExprList;

  /*
  class BadExprType : public std::exception
  {
  public:
    BadExprType(const std::string &type) : _type(type) {}
    virtual const char * what() const throw() {
      return ("Expression not an " + type).c_str();
    }
  protected
    std::string _type;
  };
  */

  class LvalExpr;

  /**
    * @class Expression
    * @brief An abstract base class
    */
  class Expression : public SymbolUser
  {
  public:
    virtual std::string toString() const = 0;

    int requireInt() const;
    double requireDouble() const;
    LvalExpr &requireLval();
    const LvalExpr &requireLval() const;
  };

  //an integer expression
  class IntExpr : public Expression
  {
  public:
    int data;
    IntExpr(int d) : data(d) {}
    std::string toString() const { return boost::lexical_cast<std::string>(data); }
  };

  inline int Expression::requireInt() const
  {
    return dynamic_cast<const IntExpr &>(*this).data;
  }

  //a double expression
  class DoubleExpr : public Expression
  {
  public:
    double data;
    // special double value, e.g., NAN
    // use string to represent special value
    std::string special_data;
    bool is_special_data;
    DoubleExpr(double d) : data(d), is_special_data(false) {}
    DoubleExpr(std::string s) : special_data(s), is_special_data(true) {}
    std::string toString() const { if (is_special_data) return special_data;
                                 else return boost::lexical_cast<std::string>(data);}
  };

  inline double Expression::requireDouble() const
  {
    return dynamic_cast<const DoubleExpr &>(*this).data;
  }

  //an lvalue expression
  class LvalExpr : public Expression
  {
  public:
    //the base variable name -- this is always non-empty
    std::string var; 
    //the Var or Func object this references -- populated by symbolic analysis
    Sym sym;
    //an optional node id -- can be empty
    Expr node; 
    //a list of indices
    ExprList indices;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      if(node != NULL)
        ret.push_back(node);
      if(indices.size() > 0)
        ret.insert(ret.end(), indices.begin(), indices.end());
      return ret;
    }

    virtual Context useSymbols(const SymUser &self, Context con)
    {
      {
        Context con2 = con;
        con.isLHS = false;
        if(node)
        {
          node->useSymbols(node, con2);
          inherit(self, node);
        }
        BOOST_FOREACH(Expr e, indices)
        {
          e->useSymbols(e, con2);
          inherit(self, e);
        }
      }
      
      sym = con.findSym(var);
      if(sym)
        sym.use(self, con.isLHS, node != NULL, con.inExpect());
      return con;
    }

    LvalExpr(const std::string &v) : var(v) {}
    LvalExpr(const std::string &v,const Expr &n) : var(v), node(n) {}
    LvalExpr(const std::string &v,const ExprList &i) : var(v), indices(i) {}
    LvalExpr(const std::string &v,const Expr &n,const ExprList &i)
      : var(v), node(n), indices(i) {}
    std::string toString() const {
      std::string res = var;
      BOOST_FOREACH(const Expr &ep,indices) res += "[" + ep->toString() + "]";
      if(node != NULL) res += "@" + node->toString();
      return res;
    }
  };

  inline LvalExpr &Expression::requireLval()
  {
    return dynamic_cast<LvalExpr &>(*this);
  }

  inline const LvalExpr &Expression::requireLval() const
  {
    return dynamic_cast<const LvalExpr &>(*this);
  }

  //a complex expression
  class CompExpr : public Expression
  {
  public:
    int op;
    ExprList args;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.insert(ret.end(), args.begin(), args.end());
      return ret;
    }

    CompExpr(int o) : op(o) {}

    CompExpr(int o,const Expr &e) : op(o)
    { args.push_back(e); }

    CompExpr(int o,const Expr &e1,const Expr &e2) 
      : op(o)
    { args.push_back(e1); args.push_back(e2); }

    CompExpr(int o,const Expr &e1,const Expr &e2,const Expr &e3) 
      : op(o)
    { args.push_back(e1); args.push_back(e2); args.push_back(e3); }

    CompExpr(int o,const ExprList &a) : op(o),args(a) {}

    std::string opToString() const;
    std::string toString() const;
  };

  //an function call expression
  class CallExpr : public Expression
  {
  public:
    Expr func;
    ExprList args;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(func);
      ret.insert(ret.end(), args.begin(), args.end());
      return ret;
    }


    bool ignore_return;

    CallExpr(const Expr &f,const ExprList &a) : func(f),args(a),ignore_return(false) {}
    std::string toString() const {
      std::string res = func->toString() + "(";

      size_t count = 0;
      BOOST_FOREACH(const Expr &a,args) {
        if(count) res += ",";
        res += a->toString();
        ++count;
      }

      return res + ")";
    }
  };

  class SingleIDBinder : public SymbolBinder
  {
  public:
    std::string id;
    Var idVar;

    virtual Sym findSym(const std::string &name) const
    {
      if(idVar && idVar->name == name)
        return boost::static_pointer_cast<Sym::element_type>(idVar);
    }

    void reg(SymbolUser::Context &con)
    {
      con.addBinder(this);
    }

    SingleIDBinder(const std::string &name) : id(name), idVar(new Variable(name, intType())) {}
  };

  class DualIDBinder : public SymbolBinder
  {
  public:
    std::string id1, id2;
    Var id1Var, id2Var;

    virtual Sym findSym(const std::string &name) const
    {
      if(id1Var && id1Var->name == name)
        return boost::static_pointer_cast<Sym::element_type>(id1Var);
      if(id2Var && id2Var->name == name)
        return boost::static_pointer_cast<Sym::element_type>(id1Var);
    }

    void reg(SymbolUser::Context &con)
    {
      con.addBinder(this);
    }

    DualIDBinder(const std::string &name1, const std::string &name2) :
        id1(name1), id1Var(new Variable(name1, intType())),
        id2(name2), id2Var(new Variable(name2, intType())) {}
  };

  //an exists other expression
  class EXOExpr : public Expression, public SingleIDBinder
  {
  public:
    Expr arg;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      reg(con);
      ret.push_back(arg);
      return ret;
    }

    EXOExpr(const std::string &i,const Expr &a) : SingleIDBinder(i),arg(a) {}
    std::string toString() const {
      return "EXISTS_OTHER(" + id + "," + arg->toString() + ")";
    }
  };

  //an exists higher expression
  class EXHExpr : public Expression, public SingleIDBinder
  {
  public:
    Expr arg;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      reg(con);
      ret.push_back(arg);
      return ret;
    }

    EXHExpr(const std::string &i,const Expr &a) : SingleIDBinder(i),arg(a) {}
    std::string toString() const {
      return "EXISTS_HIGHER(" + id + "," + arg->toString() + ")";
    }
  };

  //an exists lower expression
  class EXLExpr : public Expression, public SingleIDBinder
  {
  public:
    Expr arg;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      reg(con);
      ret.push_back(arg);
      return ret;
    }

    EXLExpr(const std::string &i,const Expr &a) : SingleIDBinder(i),arg(a) {}
    std::string toString() const {
      return "EXISTS_LOWER(" + id + "," + arg->toString() + ")";
    }
  };

  typedef std::vector <int> Expressions;
}

#endif // _DMPL_EXPRESSION_H_
