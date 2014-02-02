#ifndef _DAIG_STATEMENT_H_
#define _DAIG_STATEMENT_H_

/**
 * @file Stmt.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for statements.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <boost/shared_ptr.hpp>
#include <boost/foreach.hpp>
#include "Expression.h"

namespace daig
{
  //forward declaration
  class Statement;

  //share pointer to a base statement -- this is the type we will
  //mostly use
  typedef boost::shared_ptr<Statement> Stmt;

  //a list of expressions
  typedef std::list <Stmt> StmtList;

  /**
    * @class Statement
    * @brief An abstract base class for all statements
    */
  class Statement
  {
  public:
    virtual std::string toString() const = 0;
  };

  //an atomic statement
  class AtomicStmt : public Statement
  {
  public:
    Stmt data;
    AtomicStmt(const Stmt &d) : data(d) {}
    std::string toString() const {
      return "ATOMIC { " + data->toString() + " }";
    }
  };

  //a private statement
  class PrivateStmt : public Statement
  {
  public:
    Stmt data;
    PrivateStmt(const Stmt &d) : data(d) {}
    std::string toString() const {
      return "PRIVATE { " + data->toString() + " }";
    }
  };

  //a block statement -- consists of a list of sub-statements
  class BlockStmt : public Statement
  {
  public:
    StmtList args;

    BlockStmt(const StmtList &a) : args(a) {}
    std::string toString() const { 
      std::string res = "{ ";
      BOOST_FOREACH(const Stmt &st,args) res += st->toString();
      return res + " }";
    }
  };

  //an assignment statement
  class AsgnStmt : public Statement
  {
  public:
    LvalExpr lhs;
    Expr rhs;

    AsgnStmt(const LvalExpr &l,const Expr &r) : lhs(l),rhs(r) {}
    std::string toString() const { return lhs.toString() + " = " + rhs->toString() + ";"; }
  };

  //an if-then statement
  class ITStmt : public Statement
  {
  public:
    Expr cond;
    Stmt tbranch;

    ITStmt(const Expr &c,const Stmt &tb) : cond(c),tbranch(tb) {}
    std::string toString() const { 
      return "if(" + cond->toString() + ")" + tbranch->toString(); 
    }
  };

  //an if-then-else statement
  class ITEStmt : public Statement
  {
  public:
    Expr cond;
    Stmt tbranch,ebranch;

    ITEStmt(const Expr &c,const Stmt &tb,const Stmt &eb) 
      : cond(c),tbranch(tb),ebranch(eb) {}
    std::string toString() const { 
      return "if(" + cond->toString() + ")" + tbranch->toString() + " else " +
        ebranch->toString(); 
    }
  };

  //a for statement
  class ForStmt : public Statement
  {
  public:
    StmtList init,update;
    ExprList test;
    Stmt body;

    ForStmt(const StmtList &i,const ExprList &t,const StmtList &u,const Stmt &b) 
      : init(i),update(u),test(t),body(b) {}
    std::string toString() const { 
      std::string res = "for(";
      BOOST_FOREACH(const Stmt &s,init) res += s->toString();
      BOOST_FOREACH(const Expr &e,test) res += e->toString() + ";";
      BOOST_FOREACH(const Stmt &s,update) res += s->toString();
      return res + ")" + body->toString(); 
    }
  };

  //a while statement
  class WhileStmt : public Statement
  {
  public:
    Expr cond;
    Stmt body;

    WhileStmt(const Expr &c,const Stmt &b) : cond(c),body(b) {}
    std::string toString() const { 
      return "while(" + cond->toString() + ")" + body->toString(); 
    }
  };

  //a break statement
  class BreakStmt : public Statement
  {
  public:
    std::string toString() const { return "break;"; }
  };

  //a continue statement
  class ContStmt : public Statement
  {
  public:
    std::string toString() const { return "continue;"; }
  };

  //a return statement
  class RetStmt : public Statement
  {
  public:
    Expr retVal;

    RetStmt(const Expr &rv) : retVal(rv) {}
    std::string toString() const { return "return " + retVal->toString() + ";"; }
  };

  //a void return statement
  class RetVoidStmt : public Statement
  {
  public:
    std::string toString() const { return "return;"; }
  };

  //a function call statement whose return value is discarded
  class CallStmt : public Statement
  {
  public:
    CallExpr data;

    CallStmt(const Expr &f,const ExprList &a) : data(f,a) {}
    std::string toString() const { return data.toString(); } 
  };

  //for-all-node statement
  class FANStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;
    FANStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FOR_ALL_NODE (" + id + ") " + data->toString();
    }
  };

  //for-all-distinct-node-pair statement
  class FADNPStmt : public Statement
  {
  public:
    std::string id1,id2;
    Stmt data;
    FADNPStmt(const std::string &i1,const std::string &i2,const Stmt &d) 
      : id1(i1),id2(i2),data(d) {}
    std::string toString() const {
      return "FOR_ALL_DISTINCT_NODE_PAIR (" + id1 + "," + id2 + ") " + data->toString();
    }
  };

  //for-all-other statement
  class FAOStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;
    FAOStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FOR_ALL_OTHER (" + id + ") " + data->toString();
    }
  };

  //for-all-other-lower statement
  class FAOLStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;
    FAOLStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FOR_ALL_OTHER_LOWER (" + id + ") " + data->toString();
    }
  };

  //for-all-other-higher statement
  class FAOHStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;
    FAOHStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FOR_ALL_OTHER_HIGHER (" + id + ") " + data->toString();
    }
  };
}

#endif // _DAIG_STATEMENT_H_
