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

#include "dmpl/Type.h"
#include "dmpl/Variable.h"
#include "dmpl/Expression.h"
#include "dmpl/Statement.h"
#include "dmpl/Function.h"
#include "dmpl/Node.h"
#include "dmpl-parser.hpp"
#include "CopyVisitor.hpp"

/*********************************************************************/
//collect results for an expr list
/*********************************************************************/
dmpl::ExprList dmpl::CopyVisitor::collect(const ExprList &el)
{
  dmpl::ExprList res;
  BOOST_FOREACH(const dmpl::Expr &e,el) res.push_back(exprMap[e]);
  return res;
}

/*********************************************************************/
//collect results for an stmt list
/*********************************************************************/
dmpl::StmtList dmpl::CopyVisitor::collect(const StmtList &sl)
{
  dmpl::StmtList res;
  BOOST_FOREACH(const dmpl::Stmt &s,sl) res.push_back(stmtMap[s]);
  return res;
}

/*********************************************************************/
//dispatchers for expressions
/*********************************************************************/

void dmpl::CopyVisitor::exitInt(dmpl::IntExpr &expr)
{
  exprMap[hostExpr] = hostExpr;
}

void dmpl::CopyVisitor::exitDouble(dmpl::DoubleExpr &expr)
{
  exprMap[hostExpr] = hostExpr;
}

void dmpl::CopyVisitor::exitLval(dmpl::LvalExpr &expr)
{
  exprMap[hostExpr] = hostExpr;
}

void dmpl::CopyVisitor::exitComp(dmpl::CompExpr &expr)
{
  exprMap[hostExpr] = dmpl::Expr(new dmpl::CompExpr(expr.op,collect(expr.args)));
}

void dmpl::CopyVisitor::exitCall(dmpl::CallExpr &expr)
{
  exprMap[hostExpr] = dmpl::Expr(new dmpl::CallExpr(exprMap[expr.func],
                                                    collect(expr.args)));
}

void dmpl::CopyVisitor::exitEXO(dmpl::EXOExpr &expr)
{
  exprMap[hostExpr] = dmpl::Expr(new dmpl::EXOExpr(expr.id,exprMap[expr.arg]));
}

void dmpl::CopyVisitor::exitEXH(dmpl::EXHExpr &expr)
{
  exprMap[hostExpr] = dmpl::Expr(new dmpl::EXHExpr(expr.id,exprMap[expr.arg]));
}

void dmpl::CopyVisitor::exitEXL(dmpl::EXLExpr &expr)
{
  exprMap[hostExpr] = dmpl::Expr(new dmpl::EXLExpr(expr.id,exprMap[expr.arg]));
}

/*********************************************************************/
//dispatchers for statements
/*********************************************************************/

void dmpl::CopyVisitor::exitPrivate(dmpl::PrivateStmt &stmt)
{
  stmtMap[hostStmt] = Stmt(new dmpl::PrivateStmt(stmtMap[stmt.data]));
}

void dmpl::CopyVisitor::exitBlock(dmpl::BlockStmt &stmt)
{
  stmtMap[hostStmt] = Stmt(new BlockStmt(collect(stmt.data)));
}

void dmpl::CopyVisitor::exitAsgn(dmpl::AsgnStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new AsgnStmt(exprMap[stmt.lhs],exprMap[stmt.rhs]));

  //std::cout << "**************************************\n";
  //hostStmt->print(std::cout,0);
  //stmtMap[hostStmt]->print(std::cout,0);
}

void dmpl::CopyVisitor::exitCond(dmpl::CondStmt &stmt) 
{ 
  if(stmt.ebranch)
  {
    stmtMap[hostStmt] = Stmt(new CondStmt(exprMap[stmt.cond], stmtMap[stmt.tbranch], 
                                          stmtMap[stmt.ebranch]));
  }
  else
  {
    stmtMap[hostStmt] = Stmt(new CondStmt(exprMap[stmt.cond], stmtMap[stmt.tbranch]));
  }
}

void dmpl::CopyVisitor::exitFor(dmpl::ForStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new ForStmt(collect(stmt.init),collect(stmt.test),
                                       collect(stmt.update),stmtMap[stmt.body]));
}

void dmpl::CopyVisitor::exitWhile(dmpl::WhileStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new WhileStmt(exprMap[stmt.cond],stmtMap[stmt.body]));
}

void dmpl::CopyVisitor::exitBreak(dmpl::BreakStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void dmpl::CopyVisitor::exitCont(dmpl::ContStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void dmpl::CopyVisitor::exitRet(dmpl::RetStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new RetStmt(exprMap[stmt.retVal]));
}

void dmpl::CopyVisitor::exitRetVoid(dmpl::RetVoidStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void dmpl::CopyVisitor::exitCall(dmpl::CallStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new CallStmt(exprMap[stmt.data]));
}

void dmpl::CopyVisitor::exitFAN(dmpl::FANStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new FANStmt(stmt.id,stmtMap[stmt.data]));
}

void dmpl::CopyVisitor::exitFADNP(dmpl::FADNPStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new FADNPStmt(stmt.id1,stmt.id2,stmtMap[stmt.data]));
}

void dmpl::CopyVisitor::exitFAO(dmpl::FAOStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new FAOStmt(stmt.id,stmtMap[stmt.data]));
}

void dmpl::CopyVisitor::exitFAOL(dmpl::FAOLStmt &stmt) 
{
  stmtMap[hostStmt] = Stmt(new FAOLStmt(stmt.id,stmtMap[stmt.data]));
}

void dmpl::CopyVisitor::exitFAOH(dmpl::FAOHStmt &stmt) 
{
  stmtMap[hostStmt] = Stmt(new FAOHStmt(stmt.id,stmtMap[stmt.data]));
}

/*********************************************************************/
//end of file
/*********************************************************************/
