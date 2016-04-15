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
#include "SyncSeqDblIndParam.hpp"

/*********************************************************************/
//-- local stuff
/*********************************************************************/
namespace
{
  using namespace dmpl;
  
  //-- names of variables
  const std::string nodeIdsVarName = "nodeIds";
  const std::string nodeIdsVar = "nodeIds";
  const std::string nodeIdVar = "nodeId";
  const std::string idFunc = "__id";

  //-- function that returns nodeIds(i)
  dmpl::Expr nodeIds(int i)
  {
    ExprList idel = { Expr(new IntExpr(std::to_string(i))) };
    return Expr(new LvalExpr(nodeIdsVarName, idel));
  }

  //-- function that returns nodeIds(x)
  dmpl::Expr nodeIds(const std::string &x)
  {
    ExprList idel = { Expr(new LvalExpr(x)) };
    return Expr(new LvalExpr(nodeIdsVarName, idel));
  }
}

/*********************************************************************/
//constructor
/*********************************************************************/
dmpl::SyncSeqDblIndParam::SyncSeqDblIndParam(dmpl::DmplBuilder &b, const std::string &p, int r) 
  : SyncSeqDbl(b,p,r), cutoff(b.program.processes.size()) {}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createGlobVars()
{
  //instantiate node-global variables -- make two copies, one for
  //initial value for a round, and the other for the final value for a
  //round
  for(const auto &rg : relevantGlobs) {
    //-- process each relevant global var
    for(const Var &v : rg.second) {
      cprog.addGlobVar(v->instName(std::string("_i"))->incrDim(cutoff));
      cprog.addGlobVar(v->instName(std::string("_f"))->incrDim(cutoff));
    }

    //-- done
    break;
  }

  //instantiate node-local variables by adding _i for each node id i
  for(const auto &rl : relevantLocs) {
    for(const Var &v : rl.second)
      cprog.addGlobVar(v->incrDim(cutoff));
    
    //-- add non-deterministic id variables
    Var nodeIds(new Variable(nodeIdsVar,ucharType()));
    cprog.addGlobVar(nodeIds->incrDim(cutoff));
    Var nodeId(new Variable(nodeIdVar,ucharType()));
    cprog.addGlobVar(nodeId);

    //-- done
    break;
  }
}

/*********************************************************************/
//create functions that normalize node ids
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createNodeIdNormalizer()
{
  for(const Process &proc : builder.program.processes) {
    std::string funcName = idFunc + "_" + std::to_string(proc.id);
    dmpl::VarList fnParams = { Var(new Variable("x", dmpl::ucharType())) },fnTemps;

    //-- nodeIds[x] == nodeids[proc.id]
    Expr xeeq(new CompExpr(TCEQ, nodeIds("x"), nodeIds(proc.id)));

    //-- proc.id and 1-proc.id
    Expr ide(new IntExpr(std::to_string(proc.id)));
    Expr oide(new IntExpr(std::to_string(builder.program.processes.size() - 1 - proc.id)));

    //-- return x == nodeids[proc.id] ? proc.id : 1-proc.id
    Expr conde(new CompExpr(TQUEST, xeeq, ide, oide));
    StmtList fnBody = { Stmt(new RetStmt(conde)) };
    
    cprog.addFunction(Func(new Function(dmpl::ucharType(),funcName,fnParams,fnTemps,fnBody)));
  }
}

/*********************************************************************/
//create list of statements that copy new value of var into old value
//of var. append list of statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createCopyStmts(bool fwd,const Var &var,StmtList &res,ExprList indx)
{
  //non-array type
  if(var->type->dims.empty()) {
    Expr lhs(new LvalExpr(var->name + std::string(fwd ? "_f" : "_i"),indx));
    Expr rhs(new LvalExpr(var->name + std::string(fwd ? "_i" : "_f"),indx));
    Stmt stmt(new AsgnStmt(lhs,rhs));
    res.push_back(stmt);
  }
  else
  {
    //array type -- peel off the first dimension and iterate over it
    //recursively
    int dim = *(var->type->dims.begin());
    for(int i = 0;i < dim;++i) {
      ExprList newIndx = indx;
      newIndx.push_back(Expr(new IntExpr(std::to_string(i))));
      Var newVar = var->decrDim();
      createCopyStmts(fwd,newVar,res,newIndx);
    }
  }
}

/*********************************************************************/
//create one function that copies global variables from _i to _f
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createRoundCopier()
{
  dmpl::VarList fnParams,fnTemps;
  StmtList fnBody1,fnBody2;
  
  for(const auto &rg : relevantGlobs) {
    for(const Var &v : rg.second) {
      //create the copier from _f to _i
      createCopyStmts(false,v->incrDim(cutoff),fnBody1,ExprList());
      //create the copier from _i to _f
      createCopyStmts(true,v->incrDim(cutoff),fnBody2,ExprList());
    }
  }

  cprog.addFunction(Func(new Function(dmpl::voidType(),"round_bwd_copier",fnParams,fnTemps,fnBody1)));
  cprog.addFunction(Func(new Function(dmpl::voidType(),"round_fwd_copier",fnParams,fnTemps,fnBody2)));
}

/*********************************************************************/
//-- call round functions of each node once
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::callRoundFuncs(StmtList &body)
{
  for(const auto &pr : relevantThreads) {
    //call the _fwd version of the ROUND function of the node. this
    //copies from _i to _f
    std::string callNameFwd = pr.first.getNode() + "__" + pr.second->name + "_" + 
      std::to_string(pr.first.id) + "_fwd";
    callFunction(callNameFwd,body);
  }
}

/*********************************************************************/
//create the main function
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createMainFunc()
{
  dmpl::VarList mainParams,mainTemps;
  StmtList mainBody;

  //initialize nodeIds
  Expr ndfn = createNondetFunc(Expr(new LvalExpr(nodeIdsVar)), ucharType());
  Expr ndcall(new CallExpr(ndfn,ExprList()));
  for(int i = 0;i < cutoff;++i)
    mainBody.push_back(Stmt(new AsgnStmt(nodeIds(i), ndcall)));

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
void dmpl::SyncSeqDblIndParam::createAssume()
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
//create list of statements that havoc a variable. append list of
//statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createHavocStmts(bool isGlob,bool fwd,const Var &var,
                                                StmtList &res,ExprList indx,int pid)
{
  //non-array type
  if(var->type->dims.empty()) {
    Expr varExpr(new LvalExpr(var->name + std::string(isGlob ? (fwd ? "_i" : "_f") : ""),indx));
    Expr ndfn = createNondetFunc(varExpr, var->type);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    res.push_back(Stmt(new AsgnStmt(varExpr,ndcall)));
  }
  else
  {
    //array type -- peel off the first dimension and iterate over it
    //recursively
    int dim = *(var->type->dims.begin());
    for(int i = 0;i < dim;++i) {
      ExprList newIndx = indx;
      newIndx.push_back(Expr(new IntExpr(std::to_string(i))));
      Var newVar = var->decrDim();
      createHavocStmts(isGlob,fwd,newVar,res,newIndx,pid);
    }
  }
}

/*********************************************************************/
//create the HAVOC() function. this assigns non-deterministic values
//to all local shared variables and initial values of global shared
//variables.
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createHavoc()
{
  Node &node = builder.program.nodes.begin()->second;
  StmtList havocFnBody;
  dmpl::VarList fnParams, fnTemps;

  //-- create havoc for local and global variables
  for(const auto &rl: relevantLocs) {
    for(const Var &v: rl.second) {
      createHavocStmts(false, true, v->incrDim(cutoff), havocFnBody, ExprList(), rl.first.id);
    }
    for(const Var &v: relevantGlobs[rl.first]) {
      createHavocStmts(true, true, v->incrDim(cutoff), havocFnBody, ExprList(), rl.first.id);
    }
  }

  Func func(new Function(dmpl::voidType(),"__HAVOC",fnParams,fnTemps,havocFnBody));
  cprog.addFunction(func);
}

/*********************************************************************/
//create the functions for nodes
/*********************************************************************/
void dmpl::SyncSeqDblIndParam::createNodeFuncs()
{
  //-- go over each process
  for(const auto &pr : relevantThreads) {
    //-- collect functions, but skip constructors
    FuncList funcs = { pr.second };
    for(const Func & f : relevantFuncs[pr.first])
      if(!f->name.empty()) funcs.push_back(f);

    //-- process each function
    Node &node = pr.first.role->node;
    for(const Func &f : funcs) {
      dmpl::VarList fnParams,fnTemps;

      //create parameters and temporary variables
      fnParams = f->params;
      fnTemps = f->temps;

      //create the forward version
      {
        StmtList fnBody;

        BOOST_FOREACH(const Stmt &st,f->body) {
          NodeTrans nt = getNodeTrans(*this,builder.program,pr.first,true,f);
          std::string nodeId = *node->args.begin();
          nt->addIdMap(nodeId,pr.first.id);
          nt->visit(st);
          nt->delIdMap(nodeId);
          fnBody.push_back(nt->stmtMap[st]);
        }
        
        std::string fnName = node->name + "__" + f->name + "_" + 
          std::to_string(pr.first.id) + "_fwd";
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
void dmpl::SyncSeqDblIndParam::run()
{
  std::cout << "Sequentializing for inductive parameterized check with double-buffering and " 
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
  createNodeIdNormalizer();
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
