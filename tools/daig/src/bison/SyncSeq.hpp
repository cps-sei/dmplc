//a class for sequentializing DAIG into a C program

#ifndef __SYNC_SEQ_HPP__
#define __SYNC_SEQ_HPP__

#include <iostream>
#include "DaigBuilder.hpp"
#include "CProgram.h"
#include "Visitor.h"

namespace daig {

  /*******************************************************************/
  //a visitor that transforms statements
  /*******************************************************************/
  struct GlobalStmtTransformer : public Visitor
  {
    //the number of nodes
    size_t nodeNum;

    //map from variables to constants for substitution
    std::map<std::string,size_t> substMap;

    //map from statements to the result of transforming them
    std::map<Stmt,Stmt> res;

    //constructors
    GlobalStmtTransformer(size_t n) : nodeNum(n) {}

    //update substitution mapping
    void addSubst(const std::string &s,size_t i);
    void delSubst(const std::string &s);

    //dispatchers
    void exitAtomic(AtomicStmt &stmt);
    void exitPrivate(PrivateStmt &stmt);
    void exitBlock(BlockStmt &stmt);
    void exitAsgn(AsgnStmt &stmt);
    void exitIT(ITStmt &stmt);
    void exitITE(ITEStmt &stmt);
    void exitFor(ForStmt &stmt);
    void exitWhile(WhileStmt &stmt);
    void exitBreak(BreakStmt &stmt);
    void exitCont(ContStmt &stmt);
    void exitRet(RetStmt &stmt);
    void exitRetVoid(RetVoidStmt &stmt);
    void exitCall(CallStmt &stmt);
    bool enterFAN(FANStmt &stmt) { return false; }
    void exitFAN(FANStmt &stmt);
    bool enterFADNP(FADNPStmt &stmt) { return false; }
    void exitFADNP(FADNPStmt &stmt);
    void exitFAO(FAOStmt &stmt);
    void exitFAOL(FAOLStmt &stmt);
    void exitFAOH(FAOHStmt &stmt);
  };

  /*******************************************************************/
  //sequentializer for synchronous
  /*******************************************************************/
  class SyncSeq
  {
  public:
    DaigBuilder &builder;
    size_t nodeNum;
    CProgram cprog;

    SyncSeq(DaigBuilder &b,size_t n);
    void createGlobVars();
    void createCopyStmts(const Variable &var,StmtList &res,ExprList indx);
    void createRoundCopier();
    void createMainFunc();
    void createInit();
    void createSafety();
    void run();
    void printProgram(std::ostream &os);
  };
} //namespace daig

#endif //__SYNC_SEQ_HPP__
