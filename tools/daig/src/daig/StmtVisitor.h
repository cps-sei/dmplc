#ifndef _DAIG_STMT_VISITOR_H_
#define _DAIG_STMT_VISITOR_H_

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
#include "Statement.h"

namespace daig
{
  /**
    * @class StmtVisitor
    * @brief Encapsulates a statement visitor definition
    */
  class StmtVisitor
  {
  public:
    //the stmt being visited currently
    Stmt host;

    void visit(const Stmt &stmt);

    virtual void enterAtomic(AtomicStmt &stmt) {}
    virtual void exitAtomic(AtomicStmt &stmt) {}
    virtual void enterPrivate(PrivateStmt &stmt) {}
    virtual void exitPrivate(PrivateStmt &stmt) {}
    virtual void enterBlock(BlockStmt &stmt) {}
    virtual void exitBlock(BlockStmt &stmt) {}
    virtual void enterAsgn(AsgnStmt &stmt) {}
    virtual void exitAsgn(AsgnStmt &stmt) {}
    virtual void enterIT(ITStmt &stmt) {}
    virtual void exitIT(ITStmt &stmt) {}
    virtual void enterITE(ITEStmt &stmt) {}
    virtual void exitITE(ITEStmt &stmt) {}
    virtual void enterFor(ForStmt &stmt) {}
    virtual void exitFor(ForStmt &stmt) {}
    virtual void enterWhile(WhileStmt &stmt) {}
    virtual void exitWhile(WhileStmt &stmt) {}
    virtual void enterBreak(BreakStmt &stmt) {}
    virtual void exitBreak(BreakStmt &stmt) {}
    virtual void enterCont(ContStmt &stmt) {}
    virtual void exitCont(ContStmt &stmt) {}
    virtual void enterRet(RetStmt &stmt) {}
    virtual void exitRet(RetStmt &stmt) {}
    virtual void enterRetVoid(RetVoidStmt &stmt) {}
    virtual void exitRetVoid(RetVoidStmt &stmt) {}
    virtual void enterCall(CallStmt &stmt) {}
    virtual void exitCall(CallStmt &stmt) {}
    virtual void enterFAN(FANStmt &stmt) {}
    virtual void exitFAN(FANStmt &stmt) {}
    virtual void enterFADNP(FADNPStmt &stmt) {}
    virtual void exitFADNP(FADNPStmt &stmt) {}
    virtual void enterFAO(FAOStmt &stmt) {}
    virtual void exitFAO(FAOStmt &stmt) {}
    virtual void enterFAOL(FAOLStmt &stmt) {}
    virtual void exitFAOL(FAOLStmt &stmt) {}
    virtual void enterFAOH(FAOHStmt &stmt) {}
    virtual void exitFAOH(FAOHStmt &stmt) {}
  };
}

#endif // _DAIG_STMT_VISITOR_H_
