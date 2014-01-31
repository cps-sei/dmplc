#ifndef _DAIG_STMT_H_
#define _DAIG_STMT_H_

/**
 * @file Stmt.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for statements.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <boost/foreach.hpp>

namespace daig
{
  //forward declaration
  class Stmt;

  //a list of statements
  class StmtList : public std::list <Stmt*>
  {
  public:
    StmtList() {}
    StmtList(const StmtList &rhs);
    ~StmtList();
    const StmtList &operator = (const StmtList &rhs);
  };

  /**
    * @class Stmt
    * @brief An abstract base class for all statements
    */
  class Stmt
  {
  public:
    virtual Stmt *clone() const = 0;
    virtual std::string toString() const = 0;
  };

  //an integer expression
  class IntStmt : public Stmt
  {
  public:
    int data;
    IntStmt(int d) : data(d) {}
    IntStmt(const IntStmt &rhs) : data(rhs.data) {}
    const IntStmt &operator = (const IntStmt &rhs) {
      data = rhs.data;
      return *this;
    }
    Stmt *clone() const { return new IntStmt(data); }
    std::string toString() const {
      char buf[128];
      snprintf(buf,128,"%d",data);
      return std::string(buf);
    }
  };

  //an lvalue expression
  class LvalStmt : public Stmt
  {
  public:
    //the base variable name -- this is always non-empty
    std::string var; 
    //an optional node id -- can be empty
    std::string node; 
    //a list of indices
    StmtList indices;

    LvalStmt(const std::string &v) : var(v) {}
    LvalStmt(const std::string &v,const std::string &n) : var(v), node(n) {}
    LvalStmt(const std::string &v,const StmtList &i) : var(v), indices(i) {}
    LvalStmt(const std::string &v,const std::string &n,const StmtList &i)
      : var(v), node(n), indices(i) {}
    LvalStmt(const LvalStmt &rhs) 
      : var(rhs.var), node(rhs.node),indices(rhs.indices) {}
    const LvalStmt &operator = (const LvalStmt &rhs) {
      if(&rhs == this) return *this;
      var = rhs.var;
      node = rhs.node;
      indices = rhs.indices;
      return *this;
    }
    Stmt *clone() const { return new LvalStmt(var,node,indices); }
    std::string toString() const {
      std::string res = var;
      if(!node.empty()) res = res + "." + node;
      BOOST_FOREACH(const Stmt *ep,indices) res = res + "[" + ep->toString() + "]";
      return res;
    }
  };

  //a complex expression
  class CompStmt : public Stmt
  {
  public:
    int op;
    StmtList args;

    CompStmt(int o,const Stmt &e) : op(o)
    { args.push_back(e.clone()); }

    CompStmt(int o,const Stmt &e1,const Stmt &e2) 
      : op(o)
    { args.push_back(e1.clone()); args.push_back(e2.clone()); }

    CompStmt(int o,const StmtList &a) : op(o),args(a) {}
    CompStmt(const CompStmt &rhs) : op(rhs.op), args(rhs.args) {}

    const CompStmt &operator = (const CompStmt &rhs) {
      if(&rhs == this) return *this;
      op = rhs.op;
      args = rhs.args;
      return *this;
    }
    Stmt *clone() const { return new CompStmt(op,args); }
    std::string opToString() const;
    std::string toString() const;
  };
}

#endif // _DAIG_STMT_H_
