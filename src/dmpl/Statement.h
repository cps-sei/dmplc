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

#ifndef _DMPL_STATEMENT_H_
#define _DMPL_STATEMENT_H_

/**
 * @file Stmt.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for statements.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <memory>
#include <boost/foreach.hpp>
#include "Attribute.h"
#include "Expression.h"
#include "Symbol.h"


namespace dmpl
{
  //forward declaration
  class Statement;

  //share pointer to a base statement -- this is the type we will
  //mostly use
  typedef std::shared_ptr<Statement> Stmt;

  //a list of statements
  typedef std::list <Stmt> StmtList;

  ///check if the argument is a BlockStmt
  bool isBlock(const Stmt &stmt);

  /**
    * @class Statement
    * @brief An abstract base class for all statements
    */
  class Statement : public SymbolUser, public HasAttributes
  {
  public:
    virtual std::string toString() const = 0;
    virtual void print (std::ostream &os,unsigned int indent) const = 0;
  };

  //a private statement
  class PrivateStmt : public Statement
  {
  public:
    Stmt data;
    PrivateStmt(const Stmt &d) : data(d) {}
    std::string toString() const {
      return "PRIVATE " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "PRIVATE\n";
      data->print(os,isBlock(data) ? indent : indent + 2);
    }
  };

  //a block statement -- consists of a list of sub-statements
  class BlockStmt : public Statement
  {
  public:
    StmtList data;

    BlockStmt(const StmtList &d) : data(d) {}
    std::string toString() const { 
      std::string res = "{ ";
      BOOST_FOREACH(const Stmt &st,data) res += st->toString();
      return res + " }";
    }

    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "{\n";
      BOOST_FOREACH(const Stmt &st,data) st->print(os,indent+2);
      os << spacer << "}\n";
    }

    virtual SymUserList getParents(Context &con) {
      return SymUserList(data.begin(), data.end());
    }
  };

  //an assignment statement
  class AsgnStmt : public Statement
  {
  public:
    Expr lhs,rhs;

    AsgnStmt(const Expr &l,const Expr &r) : lhs(l),rhs(r) {}
    
    std::string toString() const
    { 
      return lhs->toString() + " = " + rhs->toString(); 
    }

    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << lhs->toString() << " = " << rhs->toString() << ";\n";
    }

    //-- symbol usage analysis
    virtual Context useSymbols(Context con);
  };

  //an if-then statement
  class CondStmt : public Statement
  {
  public:
    Expr cond;
    Stmt tbranch,ebranch;

    CondStmt(const Expr &c, const Stmt &tb) : cond(c),tbranch(tb),ebranch() {}
    CondStmt(const Expr &c, const Stmt &tb, const Stmt &eb)
      : cond(c),tbranch(tb),ebranch(eb) {}

    std::string toString() const
    { 
      return std::string("if (") + cond->toString() + ")" +
        (tbranch ? tbranch->toString() : "") +
        (ebranch ? " else " + tbranch->toString() : "") +
        (!ebranch && !tbranch ? ";" : ""); 
    }

    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "if (" + cond->toString() + ")" << std::endl;
      if(tbranch != NULL)
      {
        tbranch->print(os,isBlock(tbranch) ? indent : indent+2); 
      }
      else
      {
        os << "{ /* Do Nothing */ }" << std::endl;
      }
      if(ebranch != NULL)
      {
        os << spacer << "else\n";
        ebranch->print(os,isBlock(ebranch) ? indent : indent+2); 
      }
    }

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(cond);
      if(tbranch != NULL)
        ret.push_back(tbranch);
      if(ebranch != NULL)
        ret.push_back(ebranch);
      return ret;
    }
  };

  typedef std::shared_ptr<CondStmt> CStmt;

  //an if-then-else statement
  /*
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
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "if (" + cond->toString() + ")\n";
      tbranch->print(os,isBlock(tbranch) ? indent : indent+2); 
      os << spacer << "else\n";
      ebranch->print(os,isBlock(ebranch) ? indent : indent+2); 
    }
  };
  */

  //a for statement
  class ForStmt : public Statement
  {
  public:
    StmtList init,update;
    ExprList test;
    Stmt body;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.insert(ret.end(), init.begin(), init.end());
      ret.insert(ret.end(), update.begin(), update.end());
      ret.insert(ret.end(), test.begin(), test.end());
      ret.push_back(body);
      return ret;
    }

    ForStmt(const StmtList &i,const ExprList &t,const StmtList &u,const Stmt &b) 
      : init(i),update(u),test(t),body(b) {}
    std::string toString() const { 
      std::string res = "for (";
      BOOST_FOREACH(const Stmt &s,init) res += s->toString();
      BOOST_FOREACH(const Expr &e,test) res += e->toString() + ";";
      BOOST_FOREACH(const Stmt &s,update) res += s->toString();
      return res + ")" + body->toString(); 
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "for (";
      size_t count = 0;
      BOOST_FOREACH(const Stmt &s,init) {        
        os << (count ? "," : "") << s->toString();
        ++count;
      }
      os << ";";

      if(test.empty()) os << ";";
      else if(test.size() == 1) os << (*(test.begin()))->toString() + ";";
      else assert(0 && "ERROR: multiple test conditions in for statement");

      if(update.size() <= 1)
        BOOST_FOREACH(const Stmt &s,update) os << s->toString();
      else assert(0 && "ERROR: multiple update statements in for statement");

      os << ")\n";
      body->print(os,isBlock(body) ? indent : indent+2);      
    }
  };

  //a while statement
  class WhileStmt : public Statement
  {
  public:
    Expr cond;
    Stmt body;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(cond);
      ret.push_back(body);
      return ret;
    }

    WhileStmt(const Expr &c,const Stmt &b) : cond(c),body(b) {}
    std::string toString() const { 
      return "while (" + cond->toString() + ")" + body->toString(); 
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "while (" << cond->toString() << ")\n";
      body->print(os,isBlock(body) ? indent : indent+2);      
    }
  };

  //a break statement
  class BreakStmt : public Statement
  {
  public:
    std::string toString() const { return "break;"; }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "break;\n";
    }
  };

  //a continue statement
  class ContStmt : public Statement
  {
  public:
    std::string toString() const { return "continue;"; }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "continue;\n";
    }
  };

  //a return statement
  class RetStmt : public Statement
  {
  public:
    Expr retVal;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(retVal);
      return ret;
    }

    RetStmt(const Expr &rv) : retVal(rv) {}
    std::string toString() const { return "return " + retVal->toString() + ";"; }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "return " << retVal->toString() << ";\n";
    }
  };

  //a void return statement
  class RetVoidStmt : public Statement
  {
  public:
    std::string toString() const { return "return;"; }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "return;\n";
    }
  };

  //a function call statement whose return value is discarded
  class CallStmt : public Statement
  {
  public:
    Expr data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    //caller must ensure that d is a CallExpr
    CallStmt(const Expr &d) : data(d) {}

    CallStmt(const Expr &f,const ExprList &a) : data(new CallExpr(f,a)) {}
    std::string toString() const { return data->toString(); }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << data->toString() << ";\n";
    }
  };

  //for-all-node statement
  class FANStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    FANStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FORALL_NODE (" + id + ") " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "FORALL_NODE(" << id << ")\n";
      data->print(os,isBlock(data) ? indent : indent+2);
    }
  };

  //for-all-distinct-node-pair statement
  class FADNPStmt : public Statement
  {
  public:
    std::string id1,id2;
    Stmt data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    FADNPStmt(const std::string &i1,const std::string &i2,const Stmt &d) 
      : id1(i1),id2(i2),data(d) {}
    std::string toString() const {
      return "FORALL_DISTINCT_NODE_PAIR (" + id1 + "," + id2 + ") " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "FORALL_DISTINCT_NODE_PAIR(" 
         << id1 << "," << id2 << ")\n";
      data->print(os,isBlock(data) ? indent : indent+2);
    }
  };

  //for-all-other statement
  class FAOStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    FAOStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FORALL_OTHER (" + id + ") " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "FORALL_OTHER(" << id << ")\n";
      data->print(os,isBlock(data) ? indent : indent+2);
    }
  };

  //for-all-other-lower statement
  class FAOLStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    FAOLStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FORALL_OTHER_LOWER (" + id + ") " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "FORALL_OTHER_LOWER(" << id << ")\n";
      data->print(os,isBlock(data) ? indent : indent+2);
    }
  };

  //for-all-other-higher statement
  class FAOHStmt : public Statement
  {
  public:
    std::string id;
    Stmt data;

    virtual SymUserList getParents(Context &con) {
      SymUserList ret;
      ret.push_back(data);
      return ret;
    }

    FAOHStmt(const std::string &i,const Stmt &d) : id(i),data(d) {}
    std::string toString() const {
      return "FORALL_OTHER_HIGHER (" + id + ") " + data->toString();
    }
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "FORALL_OTHER_HIGHER(" << id << ")\n";
      data->print(os,isBlock(data) ? indent : indent+2);
    }
  };
}

#endif // _DMPL_STATEMENT_H_
