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

#include <boost/lexical_cast.hpp>
#include "dmpl/Type.h"
#include "dmpl/Variable.h"
#include "dmpl/Expression.h"
#include "dmpl/Statement.h"
#include "dmpl/Function.h"
#include "dmpl/Node.h"
#include "dmpl-parser.hpp"
#include "SyncSeqDblInd.hpp"

/*********************************************************************/
//constructor
/*********************************************************************/
dmpl::SyncSeqDblInd::SyncSeqDblInd(dmpl::DmplBuilder &b, const std::string &p, int r) 
  : SyncSeqDbl(b,p,r) {}

/*********************************************************************/
//-- call the function that asserts the safety properties
/*********************************************************************/
void dmpl::SyncSeqDblInd::callFunction(const std::string &funcName,StmtList &body)
{
  Expr callExpr(new LvalExpr(funcName));
  Stmt callStmt(new CallStmt(callExpr,dmpl::ExprList()));
  body.push_back(callStmt);
}

/*********************************************************************/
//-- call round functions of each node once
/*********************************************************************/
void dmpl::SyncSeqDblInd::callRoundFuncs(StmtList &body)
{
  for(const auto &pr : relevantThreads) {
    //call the _fwd version of the ROUND function of the node. this
    //copies from _i to _f
    std::string callNameFwd = pr.first.getNode() + "__" + pr.second->name + "_" + 
      boost::lexical_cast<std::string>(pr.first.id) + "_fwd";
    callFunction(callNameFwd,body);
  }
}

/*********************************************************************/
//create the main function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createMainFunc()
{
  dmpl::VarList mainParams,mainTemps;
  StmtList mainBody;

  //add call to INIT() and SAFETY()
  callFunction("__INIT",mainBody);
  callFunction("__SAFETY_fwd",mainBody);

  //-- for K-induction, generate additional rounds and SAFETY checks
  if(roundNum > 0) {
    for(size_t i = 0;i < roundNum;++i) {
      callFunction("round_fwd_copier",mainBody);
      callRoundFuncs(mainBody);
      callFunction("round_bwd_copier",mainBody);
      callFunction("__SAFETY_fwd",mainBody);
    }
  }
  
  //-- add call to HAVOC(), ASSUME(), forward_copier(), round
  //-- functions, backward copier(), and SAFETY(). for K-induction you
  //-- have to do this K+1 times with as ASSUME() after the first K
  //-- times, and SAFETY() after the last one.
  callFunction("__HAVOC",mainBody);
  if(roundNum > 0) {
    for(size_t i = 0;i < roundNum;++i) {
      callFunction("__ASSUME",mainBody);
      callFunction("round_fwd_copier",mainBody);
      callRoundFuncs(mainBody);
      callFunction("round_bwd_copier",mainBody);
    }
  }
  callFunction("__ASSUME",mainBody);
  callFunction("round_fwd_copier",mainBody);
  callRoundFuncs(mainBody);
  callFunction("round_bwd_copier",mainBody);
  callFunction("__SAFETY_fwd",mainBody);
  
  Func mainFunc(new Function(dmpl::intType(),"main",mainParams,mainTemps,mainBody));
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//create the ASSUME() function. this is identical to SAFETY() with
//each call to assert replaced by __CPROVER_assume().
/*********************************************************************/
void dmpl::SyncSeqDblInd::createAssume()
{
  //-- call SAFETY function and assume it returns true  
  std::string fname = "__SAFETY_" + property + "_fwd";
  StmtList assumeFnBody;
  Expr callExpr(new LvalExpr(fname));
  callExpr = Expr(new CallExpr(callExpr, dmpl::ExprList()));
  dmpl::ExprList args = {callExpr};
  callExpr = Expr(new CallExpr(Expr(new LvalExpr("__CPROVER_assume")), args));
  Stmt callStmt(new CallStmt(callExpr));
  assumeFnBody.push_back(callStmt);

  dmpl::VarList fnParams,fnTemps;
  Func assumeFunc(new Function(dmpl::voidType(),"__ASSUME",fnParams,fnTemps,assumeFnBody));
  cprog.addFunction(assumeFunc);
}

/*********************************************************************/
//create the HAVOC() function. this assigns non-deterministic values
//to all local shared variables and initial values of global shared
//variables.
/*********************************************************************/
void dmpl::SyncSeqDblInd::createHavoc()
{
  Node &node = builder.program.nodes.begin()->second;
  StmtList havocFnBody;
  dmpl::VarList fnParams, fnTemps;

  //-- create havoc for local and global variables
  for(const auto &rl: relevantLocs) {
    for(const Var &v: rl.second) {
      createHavocStmts(false, true, v, havocFnBody, ExprList(), rl.first.id);
    }
    for(const Var &v: relevantGlobs[rl.first]) {
      createHavocStmts(true, true, v, havocFnBody, ExprList(), rl.first.id);
    }
  }

  Func func(new Function(dmpl::voidType(),"__HAVOC",fnParams,fnTemps,havocFnBody));
  cprog.addFunction(func);
}

/*********************************************************************/
//create the functions for nodes
/*********************************************************************/
void dmpl::SyncSeqDblInd::createNodeFuncs()
{
  //-- go over each process
  for(const auto &pr : relevantThreads) {
    //-- collect functions
    FuncList funcs = { pr.second };
    funcs.insert(funcs.end(), relevantFuncs[pr.first].begin(), relevantFuncs[pr.first].end());

    //-- process each function
    Node &node = pr.first.role->node;
    for(const Func &f : funcs) {
      dmpl::VarList fnParams,fnTemps;

      //create parameters
      fnParams = f->params;

      //create temporary variables
      BOOST_FOREACH(Vars::value_type &v,f->temps)
        fnTemps.push_back(v.second);

      //create the forward version
      {
        StmtList fnBody;

        BOOST_FOREACH(const Stmt &st,f->body) {
          syncseqdblind::NodeTransformer nt(*this,builder.program,pr.first,true,f);
          std::string nodeId = *node->args.begin();
          nt.addIdMap(nodeId,pr.first.id);
          nt.visit(st);
          nt.delIdMap(nodeId);
          fnBody.push_back(nt.stmtMap[st]);
        }
        
        std::string fnName = node->name + "__" + f->name + "_" + 
          boost::lexical_cast<std::string>(pr.first.id) + "_fwd";
        Type retType = f->retType->isThread() ? voidType() : f->retType;
        Func func(new Function(retType,fnName,fnParams,fnTemps,fnBody));
        cprog.addFunction(func);
      }
    }
  }
}

/*********************************************************************/
//run the sequentialization, generating a C program
/*********************************************************************/
void dmpl::SyncSeqDblInd::run()
{
  std::cout << "Sequentializing for inductive check with double-buffering and " 
            << builder.program.processes.size() << " processes ...\n";

  //-- add command line as header
  std::string header = "//-- DMPLC Version: " + builder.version + "\n";
  header += "//-- DMPLC Command Line:";
  for(const std::string &c : builder.cmdLine) header += std::string(" ") + c;
  cprog.addHeader(header + "\n");

  //copy over constants
  cprog.constDef = builder.program.constDef;
  cprog.constDef["true"] = "1";
  cprog.constDef["false"] = "0";

  //-- create the property relevant variables and functions
  computeRelevant();

  createGlobVars();
  processExternFuncs();
  createRoundCopier();
  createMainFunc();
  createInit();
  createSafety();
  createAssume();
  createHavoc();
  createNodeFuncs();

  //-- add end of file footer
  cprog.addFooter("//---------------------------------------------------------\n");
  cprog.addFooter("//-- end of file\n");
  cprog.addFooter("//---------------------------------------------------------\n");
}

/*********************************************************************/
//end of file
/*********************************************************************/
