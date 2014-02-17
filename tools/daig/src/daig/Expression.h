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
#include <boost/shared_ptr.hpp>
#include <boost/foreach.hpp>
#include <boost/lexical_cast.hpp>

namespace daig
{
  //forward declaration
  class Expression;

  //share pointer to a base expression -- this is the type we will
  //mostly use
  typedef boost::shared_ptr<Expression> Expr;

  //a list of expressions
  typedef std::list <Expr> ExprList;

  /**
    * @class Expression
    * @brief An abstract base class
    */
  class Expression
  {
  public:
    virtual std::string toString() const = 0;
  };

  //an integer expression
  class IntExpr : public Expression
  {
  public:
    int data;
    IntExpr(int d) : data(d) {}
    std::string toString() const { return boost::lexical_cast<std::string>(data); }
  };

  //an lvalue expression
  class LvalExpr : public Expression
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
    std::string toString() const {
      std::string res = var;
      if(!node.empty()) res += "." + node;
      BOOST_FOREACH(const Expr &ep,indices) res += "[" + ep->toString() + "]";
      return res;
    }
  };

  //a complex expression
  class CompExpr : public Expression
  {
  public:
    int op;
    ExprList args;

    CompExpr(int o,const Expr &e) : op(o)
    { args.push_back(e); }

    CompExpr(int o,const Expr &e1,const Expr &e2) 
      : op(o)
    { args.push_back(e1); args.push_back(e2); }

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

    CallExpr(const Expr &f,const ExprList &a) : func(f),args(a) {}
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

  typedef std::vector <int> Expressions;
}

#endif // _DAIG_EXPRESSION_H_
