#ifndef _DAIG_VISITOR_H_
#define _DAIG_VISITOR_H_

/**
 * @file CProgram.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for a base visitor over
 * statements
 **/

#include <list>
#include <map>
#include <string>
#include "Expression.h"
#include "Statement.h"

namespace daig
{
  /**
    * @class Visitor
    * @brief Encapsulates a statement visitor definition
    */
  class Visitor
  {
  public:
    //the stmt/expression being visited currently
    Stmt hostStmt;
    Expr hostExpr;

    void visit(const Expr &expr);
    void visit(const Stmt &stmt);

    virtual bool enterInt(IntExpr &expr) { return true; }
    virtual void exitInt(IntExpr &expr) {}
    virtual bool enterLval(LvalExpr &expr) { return true; }
    virtual void exitLval(LvalExpr &expr) {}
    virtual bool enterComp(CompExpr &expr) { return true; }
    virtual void exitComp(CompExpr &expr) {}
    virtual bool enterCall(CallExpr &expr) { return true; }
    virtual void exitCall(CallExpr &expr) {}

    virtual bool enterAtomic(AtomicStmt &stmt) { return true; }
    virtual void exitAtomic(AtomicStmt &stmt) {}
    virtual bool enterPrivate(PrivateStmt &stmt) { return true; }
    virtual void exitPrivate(PrivateStmt &stmt) {}
    virtual bool enterBlock(BlockStmt &stmt) { return true; }
    virtual void exitBlock(BlockStmt &stmt) {}
    virtual bool enterAsgn(AsgnStmt &stmt) { return true; }
    virtual void exitAsgn(AsgnStmt &stmt) {}
    virtual bool enterIT(ITStmt &stmt) { return true; }
    virtual void exitIT(ITStmt &stmt) {}
    virtual bool enterITE(ITEStmt &stmt) { return true; }
    virtual void exitITE(ITEStmt &stmt) {}
    virtual bool enterFor(ForStmt &stmt) { return true; }
    virtual void exitFor(ForStmt &stmt) {}
    virtual bool enterWhile(WhileStmt &stmt) { return true; }
    virtual void exitWhile(WhileStmt &stmt) {}
    virtual bool enterBreak(BreakStmt &stmt) { return true; }
    virtual void exitBreak(BreakStmt &stmt) {}
    virtual bool enterCont(ContStmt &stmt) { return true; }
    virtual void exitCont(ContStmt &stmt) {}
    virtual bool enterRet(RetStmt &stmt) { return true; }
    virtual void exitRet(RetStmt &stmt) {}
    virtual bool enterRetVoid(RetVoidStmt &stmt) { return true; }
    virtual void exitRetVoid(RetVoidStmt &stmt) {}
    virtual bool enterCall(CallStmt &stmt) { return true; }
    virtual void exitCall(CallStmt &stmt) {}
    virtual bool enterFAN(FANStmt &stmt) { return true; }
    virtual void exitFAN(FANStmt &stmt) {}
    virtual bool enterFADNP(FADNPStmt &stmt) { return true; }
    virtual void exitFADNP(FADNPStmt &stmt) {}
    virtual bool enterFAO(FAOStmt &stmt) { return true; }
    virtual void exitFAO(FAOStmt &stmt) {}
    virtual bool enterFAOL(FAOLStmt &stmt) { return true; }
    virtual void exitFAOL(FAOLStmt &stmt) {}
    virtual bool enterFAOH(FAOHStmt &stmt) { return true; }
    virtual void exitFAOH(FAOHStmt &stmt) {}
  };
}

#endif // _DAIG_VISITOR_H_
