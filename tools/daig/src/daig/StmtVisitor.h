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
    void visit(const Stmt &stmt);

    virtual void enterAtomic(const AtomicStmt &stmt) {}
    virtual void enterPrivate(const PrivateStmt &stmt) {}
    virtual void enterBlock(const BlockStmt &stmt) {}
    virtual void enterAsgn(const AsgnStmt &stmt) {}
    virtual void enterIT(const ITStmt &stmt) {}
    virtual void enterITE(const ITEStmt &stmt) {}
    virtual void enterFor(const ForStmt &stmt) {}
    virtual void enterWhile(const WhileStmt &stmt) {}
    virtual void enterBreak(const BreakStmt &stmt) {}
    virtual void enterCont(const ContStmt &stmt) {}
    virtual void enterRet(const RetStmt &stmt) {}
    virtual void enterRetVoid(const RetVoidStmt &stmt) {}
    virtual void enterCall(const CallStmt &stmt) {}
    virtual void enterFAN(const FANStmt &stmt) {}
    virtual void enterFADNP(const FADNPStmt &stmt) {}
    virtual void enterFAO(const FAOStmt &stmt) {}
    virtual void enterFAOL(const FAOLStmt &stmt) {}
    virtual void enterFAOH(const FAOHStmt &stmt) {}

    virtual void exitAtomic(const AtomicStmt &stmt) {}
    virtual void exitPrivate(const PrivateStmt &stmt) {}
    virtual void exitBlock(const BlockStmt &stmt) {}
    virtual void exitAsgn(const AsgnStmt &stmt) {}
    virtual void exitIT(const ITStmt &stmt) {}
    virtual void exitITE(const ITEStmt &stmt) {}
    virtual void exitFor(const ForStmt &stmt) {}
    virtual void exitWhile(const WhileStmt &stmt) {}
    virtual void exitBreak(const BreakStmt &stmt) {}
    virtual void exitCont(const ContStmt &stmt) {}
    virtual void exitRet(const RetStmt &stmt) {}
    virtual void exitRetVoid(const RetVoidStmt &stmt) {}
    virtual void exitCall(const CallStmt &stmt) {}
    virtual void exitFAN(const FANStmt &stmt) {}
    virtual void exitFADNP(const FADNPStmt &stmt) {}
    virtual void exitFAO(const FAOStmt &stmt) {}
    virtual void exitFAOL(const FAOLStmt &stmt) {}
    virtual void exitFAOH(const FAOHStmt &stmt) {}
  };
}

#endif // _DAIG_STMT_VISITOR_H_
