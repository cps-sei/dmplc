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


//a class for sequentializing DMPL into a C program -- this version
//uses two copies of the global variables, but does not copy between
//them. instead it uses them alternatively. it supports unbounded
//verification by checking whether the safety property to be verified
//is inductive across each round of execution.

#ifndef __SYNC_SEQ_DBL_IND_HPP__
#define __SYNC_SEQ_DBL_IND_HPP__

#include <iostream>
#include "DmplBuilder.hpp"
#include "dmpl/CProgram.h"
#include "CopyVisitor.hpp"

namespace dmpl {

  //forward declaration
  class SyncSeqDblInd;

  //new namespace to avoid name collisions
  namespace syncseqdblind {

    /*****************************************************************/
    //a visitor that transforms at the global level
    /*****************************************************************/
    struct GlobalTransformer : public CopyVisitor
    {
      ///reference to callee class for callbacks
      SyncSeqDblInd &syncSeq;

      //the DASL program being transformed
      dmpl::Program &prog;

      //map from variables to constants for substitution
      std::map<std::string,size_t> idMap;

      //constructors
      GlobalTransformer(SyncSeqDblInd &ss,dmpl::Program &p) 
        : syncSeq(ss),prog(p) {}

      //update substitution mapping
      void addIdMap(const std::string &s,size_t i);
      void delIdMap(const std::string &s);

      //dispatchers
      void exitLval(LvalExpr &expr);
      void exitComp(CompExpr &expr);
      void exitPrivate(PrivateStmt &stmt);
      void exitCall(CallStmt &stmt);
      bool enterFAN(FANStmt &stmt) { return false; }
      void exitFAN(FANStmt &stmt);
      bool enterFADNP(FADNPStmt &stmt) { return false; }
      void exitFADNP(FADNPStmt &stmt);

      std::string getNodeStr(const LvalExpr &expr) const;
    };

    /*****************************************************************/
    //a visitor that transforms at the node level
    /*****************************************************************/
    struct NodeTransformer : public GlobalTransformer
    {
      ///the process being transformed
      Process proc;

      //flags to indicate whether we are processing a function call, or
      //lhs of an assignment
      bool inCall, inLhs;

      //direction -- true if forward, false if backward
      bool fwd;

      NodeTransformer(SyncSeqDblInd &ss,Program &p,const Process &pr,bool f)
        : GlobalTransformer(ss,p),proc(pr),inCall(0),inLhs(0),fwd(f) {}

      void exitLval(LvalExpr &expr);
      bool enterCall(CallExpr &expr) { return false; }
      void exitCall(CallExpr &expr);
      bool enterEXO(EXOExpr &expr) { return false; }
      void exitEXO(EXOExpr &expr);
      bool enterEXH(EXHExpr &expr) { return false; }
      void exitEXH(EXHExpr &expr);
      bool enterEXL(EXLExpr &expr) { return false; }
      void exitEXL(EXLExpr &expr);
      bool enterAsgn(AsgnStmt &stmt) { return false; }
      void exitAsgn(AsgnStmt &stmt);
      bool enterFAO(FAOStmt &stmt) { return false; }
      void exitFAO(FAOStmt &stmt);
      bool enterFAOL(FAOLStmt &stmt) { return false; }
      void exitFAOL(FAOLStmt &stmt);
      bool enterFAOH(FAOHStmt &stmt) { return false; }
      void exitFAOH(FAOHStmt &stmt);
    };

  } //namespace syncseqdblind

  /*******************************************************************/
  //sequentializer for synchronous
  /*******************************************************************/
  class SyncSeqDblInd
  {
  public:
    DmplBuilder &builder;  //-- the builder containing parsed DMPL file
    std::string property;  //-- the name of target require property
    int roundNum;          //-- the number of rounds
    CProgram cprog;        //-- the generated C program

    //-- map from processes to local and global variables that are
    //-- relevant to the target property
    std::map<Process,VarSet> relevantGlobs;
    std::map<Process,VarSet> relevantLocs;

    //-- map from processes to threads that are relevant to the target
    //-- property
    std::map<Process,Func> relevantThreads;

    //-- map from processes to functions that are relevant to the
    //-- target property
    std::map<Process,std::set<Func>> relevantFuncs;

    //-- map from processes to local and global variables that must be
    //-- havoced, i.e., variables written by other threads and
    //-- accessed by this process
    std::map<Process,VarSet> havocGlobs;
    std::map<Process,VarSet> havocLocs;
    
    //-- set of variables for which non-det functions have been created
    std::set<std::string> nondetFuncs;

    SyncSeqDblInd(DmplBuilder &b, const std::string &p, int r);

    //-- compute relevant variables and functions for each process
    void computeRelevant();
    
    void createGlobVars();
    void createCopyStmts(bool fwd,const Var &var,StmtList &res,ExprList indx,int node);
    void createRoundCopier();
    void callFunction(const std::string &funcName,StmtList &body);
    void callRoundFuncs(Func &roundFunc,StmtList &body);
    void createMainFunc();
    Stmt createInitVar(const Var &var, const Process &proc);
    void createInit();
    void createSafety();
    void createAssume();
    void createNDAssignStmts(bool isGlob,const Var &var,StmtList &res,ExprList indx,int pid);
    void createHavoc();
    void createNodeFuncs();
    Expr createNondetFunc(const Expr &expr, const Type &type);
    void processExternFuncs();
    void run();
  };
} //namespace dmpl

#endif //__SYNC_SEQ_DBL_IND_HPP__
