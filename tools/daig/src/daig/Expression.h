#ifndef _DAIG_EXPRESSION_H_
#define _DAIG_EXPRESSION_H_

/**
 * @file Expression.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for an expression.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <boost/foreach.hpp>

namespace daig
{
  //forward declaration
  class Expression;

  //shorthand
  typedef Expression Expr;

  //a list of expressions
  class ExprList : public std::list <Expr*>
  {
  public:
    ExprList() {}
    ExprList(const ExprList &rhs);
    ~ExprList();
    const ExprList &operator = (const ExprList &rhs);
  };

  /**
    * @class Expression
    * @brief An abstract base class
    */
  class Expression
  {
  public:
    virtual Expr *clone() const = 0;
    virtual std::string toString() const = 0;
  };

  //an integer expression
  class IntExpr : public Expr
  {
  public:
    int data;
    IntExpr(int d) : data(d) {}
    IntExpr(const IntExpr &rhs) : data(rhs.data) {}
    const IntExpr &operator = (const IntExpr &rhs) {
      data = rhs.data;
      return *this;
    }
    Expr *clone() const { return new IntExpr(data); }
    std::string toString() const {
      char buf[128];
      snprintf(buf,128,"%d",data);
      return std::string(buf);
    }
  };

  //an lvalue expression
  class LvalExpr : public Expr
  {
  public:
    //the base variable name -- this is always non-empty
    std::string var; 
    //an optional node id -- can be empty
    std::string node; 
    //a list of indices
    ExprList indices;

    LvalExpr(const std::string &v) : var(v) {}
    LvalExpr(const std::string &v,const std::string &n) : var(v), node(n) {}
    LvalExpr(const std::string &v,const ExprList &i) : var(v), indices(i) {}
    LvalExpr(const std::string &v,const std::string &n,const ExprList &i)
      : var(v), node(n), indices(i) {}
    LvalExpr(const LvalExpr &rhs) 
      : var(rhs.var), node(rhs.node),indices(rhs.indices) {}
    const LvalExpr &operator = (const LvalExpr &rhs) {
      if(&rhs == this) return *this;
      var = rhs.var;
      node = rhs.node;
      indices = rhs.indices;
      return *this;
    }
    Expr *clone() const { return new LvalExpr(var,node,indices); }
    std::string toString() const {
      std::string res = var;
      if(!node.empty()) res = res + "." + node;
      BOOST_FOREACH(const Expr *ep,indices) res = res + "[" + ep->toString() + "]";
      return res;
    }
  };

  //a complex expression
  class CompExpr : public Expr
  {
  public:
    int op;
    ExprList args;

    CompExpr(int o,const Expr &e) : op(o)
    { args.push_back(e.clone()); }

    CompExpr(int o,const Expr &e1,const Expr &e2) 
      : op(o)
    { args.push_back(e1.clone()); args.push_back(e2.clone()); }

    CompExpr(int o,const ExprList &a) : op(o),args(a) {}
    CompExpr(const CompExpr &rhs) : op(rhs.op), args(rhs.args) {}

    const CompExpr &operator = (const CompExpr &rhs) {
      if(&rhs == this) return *this;
      op = rhs.op;
      args = rhs.args;
      return *this;
    }
    Expr *clone() const { return new CompExpr(op,args); }
    std::string opToString() const;
    std::string toString() const {
      return "<COMPLEX-EXPR>";
    }
  };

  typedef std::vector <int> Expressions;
}

#endif // _DAIG_EXPRESSION_H_
