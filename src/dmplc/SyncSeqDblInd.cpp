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
  callFunction("__SAFETY",mainBody);

  //-- for K-induction, generate additional rounds and SAFETY checks
  if(roundNum > 0) {
    for(size_t i = 0;i < roundNum;++i) {
      callFunction("round_fwd_copier",mainBody);
      callRoundFuncs(mainBody);
      callFunction("round_bwd_copier",mainBody);
      callFunction("__SAFETY",mainBody);
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
  callFunction("__SAFETY",mainBody);
  
  Func mainFunc(new Function(dmpl::intType(),"main",mainParams,mainTemps,mainBody));
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//create the INIT() function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createInit()
{
  StmtList fnBody;
  //-- create initializers for local variables
  for(const auto &rl: relevantLocs) {
    //-- collect the local and global variables, and sort them into
    //-- input and non-input
    VarSet inputVars, nonInputVars;
    for(const Var &v: rl.second) {
      if(v->isInput) inputVars.insert(v);
      else nonInputVars.insert(v);
    }
    for(const Var &v: relevantGlobs[rl.first]) {
      if(v->isInput) inputVars.insert(v);
      else nonInputVars.insert(v);
    }

    //-- generate INIT for input vars 
    for(const Var &v: inputVars) {
      if(v->initFunc == NULL) continue;
      fnBody.push_back(createInitVar(v, rl.first));
    }
    //-- generate INIT for non-input vars 
    for(const Var &v: nonInputVars) {
      if(v->initFunc == NULL) continue;
      fnBody.push_back(createInitVar(v, rl.first));
    }
  }

  //-- also assume that the property holds after initialization
  std::string fname = "__SAFETY_" + property;
  Expr callExpr(new LvalExpr(fname));
  callExpr = Expr(new CallExpr(callExpr, dmpl::ExprList()));
  dmpl::ExprList args = {callExpr};
  callExpr = Expr(new CallExpr(Expr(new LvalExpr("__CPROVER_assume")), args));
  Stmt callStmt(new CallStmt(callExpr));
  fnBody.push_back(callStmt);

  dmpl::VarList fnParams, fnTemps;
  Func func(new Function(dmpl::voidType(),"__INIT",fnParams,fnTemps,fnBody));
  cprog.addFunction(func);
}

/*********************************************************************/
//create the SAFETY() function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createSafety()
{
  const Node &node = builder.program.nodes.begin()->second;
  Func propFunc = node->getRequireFunc(property);

  //-- create the require property function
  dmpl::VarList fnParams = propFunc->params,fnTemps;
  for(const auto &v : propFunc->temps) fnTemps.push_back(v.second);
  
  //transform the body of safety
  StmtList fnBody;
  BOOST_FOREACH(const Stmt &st,propFunc->body) {
    syncseqdblind::GlobalTransformer gt(*this,builder.program,propFunc);
    gt.visit(st);
    fnBody.push_back(gt.stmtMap[st]);
  }
  
  std::string fname = "__SAFETY_" + property;
  Func func(new Function(propFunc->retType, fname, fnParams, fnTemps, fnBody));
  cprog.addFunction(func);

  //-- create the SAFETY function and call the property function  
  StmtList safetyFnBody;
  Expr callExpr(new LvalExpr(fname));
  callExpr = Expr(new CallExpr(callExpr, dmpl::ExprList()));
  dmpl::ExprList args = {callExpr};
  callExpr = Expr(new CallExpr(Expr(new LvalExpr("assert")), args));
  Stmt callStmt(new CallStmt(callExpr));
  safetyFnBody.push_back(callStmt);

  fnParams.clear(); fnTemps.clear();
  Func safetyFunc(new Function(dmpl::voidType(),"__SAFETY",fnParams,fnTemps,safetyFnBody));
  cprog.addFunction(safetyFunc);
}

/*********************************************************************/
//create the ASSUME() function. this is identical to SAFETY() with
//each call to assert replaced by __CPROVER_assume().
/*********************************************************************/
void dmpl::SyncSeqDblInd::createAssume()
{
  //-- call SAFETY function and assume it returns true  
  std::string fname = "__SAFETY_" + property;
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
//create list of statements that assign a non-deterministic value to
//old value of var. append list of statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblInd::createHavocStmts(bool isGlob,const Var &var,StmtList &res,
                                           ExprList indx,int pid)
{
  //non-array type
  if(var->type->dims.empty()) {
    std::string pidStr = boost::lexical_cast<std::string>(pid);
    Expr lhs(new LvalExpr(var->name + std::string(isGlob ? "_i_" : "_") + pidStr,indx));
    Expr ndfn = createNondetFunc(lhs, var->type);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    Stmt stmt(new AsgnStmt(lhs,ndcall));
    res.push_back(stmt);
  }
  else
  {
    //array type -- peel off the first dimension and iterate over it
    //recursively
    int dim = *(var->type->dims.begin());
    for(int i = 0;i < dim;++i) {
      ExprList newIndx = indx;
      newIndx.push_back(Expr(new IntExpr(boost::lexical_cast<std::string>(i))));
      Var newVar = var->decrDim();
      createHavocStmts(isGlob,newVar,res,newIndx,pid);
    }
  }
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
      createHavocStmts(false, v, havocFnBody, ExprList(), rl.first.id);
    }
    for(const Var &v: relevantGlobs[rl.first]) {
      createHavocStmts(true, v, havocFnBody, ExprList(), rl.first.id);
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
//create a nondet function for the type of the argument
//expression. add its declaration to the C program if a new function
//was created
/*********************************************************************/
dmpl::Expr dmpl::SyncSeqDblInd::createNondetFunc(const Expr &expr, const Type &type)
{
  const LvalExpr *lve = dynamic_cast<LvalExpr*>(expr.get());
  assert(lve && "ERROR: can only create nondet function for LvalExpr");

  std::string fnName = "nondet_" + lve->var;
  
  if(nondetFuncs.insert(lve->var).second) {
    dmpl::VarList fnParams,fnTemps;
    StmtList fnBody;
    Func func(new Function(type,fnName,fnParams,fnTemps,fnBody));
    func->isPrototype = true;
    cprog.addFunction(func);
  }
  
  return Expr(new LvalExpr(fnName));
}

/*********************************************************************/
//-- process external function declarations
/*********************************************************************/
void dmpl::SyncSeqDblInd::processExternFuncs()
{
  BOOST_FOREACH(dmpl::Funcs::value_type &ef, builder.program.funcs)
  {
    if(ef.second->isExtern == false)
      continue;
    int rets = ef.second->attrs.count("ASSUME_RETURN");
    if(rets < 1) {
      cprog.funcs[ef.second->name] = Func(new Function(*ef.second));
      continue;
    }
    else if(rets > 1)
      std::cerr << "Warning: function " << ef.second->name <<
        " has more than one @ASSUME_RETURN attribute" << std::endl;
    dmpl::Attribute attr = ef.second->attrs["ASSUME_RETURN"];

    int params = attr.paramList.size();

    dmpl::StmtList fnBody;
    dmpl::Vars fnTemps;

    if(params == 1) {
      Expr expr = attr.paramList.front();

      Stmt ret(new RetStmt(expr));

      fnBody.push_back(ret);
    } else if(params == 2) {
      Expr varExpr = attr.paramList.front();
      LvalExpr var = varExpr->requireLval();
      Expr condExpr = *(++attr.paramList.begin());

      if(var.node != NULL || var.indices.size() > 0) {
        std::cerr << "Error: function " << ef.second->name <<
          " has an @ASSUME_RETURN attribute with an invalid variable specified (" <<
          var.toString() << ")" << std::endl;;
        exit(1);
      }

      fnTemps[var.var] = Var(new Variable(var.var, ef.second->retType));

      Expr call(new CallExpr(Expr(new LvalExpr(std::string("nondet_") + ef.second->name)), ExprList()));
      Stmt assign(new AsgnStmt(varExpr, call));
      fnBody.push_back(assign);

      ExprList assumeArgs;
      assumeArgs.push_back(condExpr);
      Stmt assume(new CallStmt(Expr(new LvalExpr("__CPROVER_assume")), assumeArgs));
      fnBody.push_back(assume);

      Stmt ret(new RetStmt(varExpr));
      fnBody.push_back(ret);
    } else {
      std::cerr << "Error: function " << ef.second->name <<
        " has an @ASSUME_RETURN attribute with " << attr.paramList.size() <<
        " parameters (expected 1: expression; or 2: variable, conditional)." << std::endl;
      exit(1);
    }


    Func func(new Function(ef.second->retType,ef.second->name,ef.second->paramSet,fnTemps,fnBody));
    func->isExtern = true;
    cprog.addFunction(func);
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
