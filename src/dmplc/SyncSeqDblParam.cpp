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
#include "SyncSeqDblParam.hpp"

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

  //-- function that returns nodeIds(x)
  dmpl::Expr nodeIds(int i)
  {
    ExprList idel = { Expr(new IntExpr(std::to_string(i))) };
    return Expr(new LvalExpr(nodeIdsVarName, idel));
  }
}

/*********************************************************************/
//methods for GlobalTransformer
/*********************************************************************/

//add id to int mapping
void dmpl::syncseqdblparam::GlobalTransformer::addIdMap(const std::string &s,size_t i)
{
  idMap[s] = i;
}

//remove id to int mappiing
void dmpl::syncseqdblparam::GlobalTransformer::delIdMap(const std::string &s)
{
  idMap.erase(s);
}

/*********************************************************************/
//dispatchers for expressions
/*********************************************************************/

void dmpl::syncseqdblparam::GlobalTransformer::exitComp(dmpl::CompExpr &expr)
{
  if(expr.op == TNODENUM)
    throw std::runtime_error("ERROR: found unsupported #N dimension!!");
  else
    exprMap[hostExpr] = dmpl::Expr(new dmpl::CompExpr(expr.op,collect(expr.args)));
}

std::string dmpl::syncseqdblparam::GlobalTransformer::getNodeStr(const dmpl::LvalExpr &expr) const
{
  Expr nodeExpr = expr.node;
  try
  {
    int id = nodeExpr->requireInt();
    return boost::lexical_cast<std::string>(id);
  }
  catch(std::bad_cast)
  {
    try
    {
      const LvalExpr &nodeLVal = nodeExpr->requireLval();
      std::map<std::string,size_t>::const_iterator iit = idMap.find(nodeLVal.var);
      if(iit == idMap.end() || nodeLVal.node != NULL || nodeLVal.indices.size() > 0 )
      {
        std::cerr << "Error: bad @node specifier. Unknown identifier: " << nodeExpr->toString() << '\n';
        exit(1);
      }
      else
      {
        return boost::lexical_cast<std::string>(iit->second);
      }
    }
    catch(std::bad_cast)
    {
      std::cerr << "Error: bad @node specifier (" << nodeExpr->toString()
                << "); must be integer, or identifier" << std::endl;
      exit(1);
    }
  }
}

void dmpl::syncseqdblparam::GlobalTransformer::exitLval(dmpl::LvalExpr &expr)
{
  exprMap[hostExpr] = hostExpr;

  //substitute global variable name x with x_i
  std::string newName = expr.var;

  //handle assume and assert
  if(newName == "ASSUME") newName = "__CPROVER_assume";
  else if(newName == "ASSERT") newName = "assert";

  //handle global variables. make sure you get the right version (_i
  //or _f) depending on whether we are going forward or backward and
  //whether we are processing a constructor.
  Node &node = prog.nodes.begin()->second;  
  if(node->globVars.count(expr.var)) newName += (fwd || (func && func->name.empty()) ? "_i" : "_f");

  //substitute .id with its mapping in idMap
  std::map<std::string,size_t>::const_iterator iit = idMap.find(expr.var);
  newName = iit == idMap.end() ? newName : boost::lexical_cast<std::string>(iit->second);

  if(expr.node != NULL)
    newName = newName + "_" + getNodeStr(expr);

  exprMap[hostExpr] = dmpl::Expr(new dmpl::LvalExpr(newName,collect(expr.indices)));
  
  //std::cout << "**************************************\n";
  //std::cout << hostExpr->toString() << '\n';
  //std::cout << exprMap[hostExpr]->toString() << '\n';
}

/*********************************************************************/
//dispatchers for statements
/*********************************************************************/

void dmpl::syncseqdblparam::GlobalTransformer::exitPrivate(dmpl::PrivateStmt &stmt)
{
  stmtMap[hostStmt] = stmtMap[stmt.data];
}

void dmpl::syncseqdblparam::GlobalTransformer::exitCall(dmpl::CallStmt &stmt) 
{ 
  //handle calls to ND(x) -- assign x non-deterministically
  CallExpr *expr = dynamic_cast<CallExpr*>(stmt.data.get());
  if(expr->func->toString() == "ND") {
    throw std::runtime_error("ERROR: found call to unsupported function ND()!!");
    /*
    const Expr &arg = exprMap[*(expr->args.begin())];
    Expr ndfn = syncSeq.createNondetFunc(arg);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    stmtMap[hostStmt] = Stmt(new AsgnStmt(arg,ndcall));
    */
    return;
  }

  stmtMap[hostStmt] = Stmt(new CallStmt(exprMap[stmt.data]));
}

void dmpl::syncseqdblparam::GlobalTransformer::exitFAN(dmpl::FANStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  for(const auto &pr : syncSeq.relevantThreads) {
    syncseqdblparam::NodeTransformer nt(syncSeq,prog,pr.first,fwd,func);
    nt.idMap = idMap;
    nt.addIdMap(stmt.id,pr.first.id);
    nt.visit(stmt.data);
    sl.push_back(nt.stmtMap[stmt.data]);
    nt.delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

void dmpl::syncseqdblparam::GlobalTransformer::exitFADNP(dmpl::FADNPStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  auto it1 = syncSeq.relevantThreads.begin();
  for(;it1 != syncSeq.relevantThreads.end();++it1) {
    auto it2 = it1; ++it2;
    for(;it2 != syncSeq.relevantThreads.end();++it2) {
      syncseqdblparam::NodeTransformer nt(syncSeq,prog,it1->first,fwd,func);
      nt.idMap = idMap;
      nt.addIdMap(stmt.id1,it1->first.id);
      nt.addIdMap(stmt.id2,it2->first.id);
      nt.visit(stmt.data);
      sl.push_back(nt.stmtMap[stmt.data]);
      nt.delIdMap(stmt.id1);
      nt.delIdMap(stmt.id2);
    }
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

/*********************************************************************/
//methods for NodeTransformer
/*********************************************************************/

void dmpl::syncseqdblparam::NodeTransformer::exitLval(dmpl::LvalExpr &expr)
{
  exprMap[hostExpr] = hostExpr;

  //substitute global variable name x with x_i
  std::string newName = expr.var;

  //assumes a single node
  Node &node = proc.role->node;

  //create the string for the nodeId part of the expression, if any
  std::string nodeIdStr = (expr.node != NULL) ? getNodeStr(expr)
    : boost::lexical_cast<std::string>(proc.id);

  //handle assume and assert
  if(newName == "ASSUME") newName = "__CPROVER_assume";
  else if(newName == "ASSERT") newName = "assert";

  //handle function call -- change name if the function is defined at top-level
  else if(inCall && prog.isInternalFunction(newName)) 
    newName += (std::string("_") + (fwd ? "fwd" : "bwd"));
  //handle function call -- change name if the function is defined in node
  else if(inCall && node->hasFunction(newName)) 
    newName = (node->name + "__" + newName + "_" + nodeIdStr + "_" + (fwd ? "fwd" : "bwd"));
  else
  {
    bool isGlob = node->globVars.find(expr.var) != node->globVars.end() ||
      proc.role->globVars.find(expr.var) != proc.role->globVars.end();
    bool isLoc = node->locVars.find(expr.var) != node->locVars.end() ||
      proc.role->locVars.find(expr.var) != proc.role->locVars.end();

    //handle global variables -- distinguishing between lhs of
    //assignments and other cases, and between forward and backward
    //versions, as well as whether we are processing a constructor.
    if(isGlob) {
      if(func && func->name.empty()) newName += "_i";
      else if(fwd) {
        if(inLhs) newName += "_f";
        else newName += "_i";
      } else {
        if(inLhs) newName += "_i";
        else newName += "_f";
      }
    }

    //handle local variables
    //if(node->locVars.count(expr.var))
      //newName += "_" + boost::lexical_cast<std::string>(nodeId);

    //substitute .id with its mapping in idMap
    std::map<std::string,size_t>::const_iterator iit = idMap.find(expr.var);
    newName = iit == idMap.end() ? newName : boost::lexical_cast<std::string>(iit->second);

    if(isGlob || isLoc) newName += "_" + nodeIdStr;
  }

  exprMap[hostExpr] = dmpl::Expr(new dmpl::LvalExpr(newName,collect(expr.indices)));
  
  //std::cout << "**************************************\n";
  //std::cout << hostExpr->toString() << '\n';
  //std::cout << exprMap[hostExpr]->toString() << '\n';
}

void dmpl::syncseqdblparam::NodeTransformer::exitCall(dmpl::CallExpr &expr) 
{
  Expr shost = hostExpr;

  //-- handle calls to EXIT()
  if(expr.func->toString() == "EXIT") {
    Expr exitFunc(new LvalExpr("exit"));
    Expr exitArg(new IntExpr("0"));
    ExprList exitArgs = {exitArg};
    exprMap[shost] = Expr(new CallExpr(exitFunc, exitArgs));
    return;
  }
  
  //-- handle calls to PRINT()
  if(expr.func->toString() == "PRINT") {
    exprMap[shost] = Expr(new CallExpr(expr.func, ExprList()));
    return;
  }
  
  inCall = true;
  visit(expr.func);
  inCall = false;
  BOOST_FOREACH(Expr &e,expr.args) visit(e);
  exprMap[shost] = dmpl::Expr(new dmpl::CallExpr(exprMap[expr.func],collect(expr.args)));
}

//compute disjunction over all other node ids
void dmpl::syncseqdblparam::NodeTransformer::exitEXO(dmpl::EXOExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first == proc) continue;
    addIdMap(expr.id,pr.first.id);
    visit(expr.arg);
    delIdMap(expr.id);
    if(exprMap[shost].get()) 
      exprMap[shost] = 
        dmpl::Expr(new dmpl::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "0"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new dmpl::IntExpr("0"));
}

//compute disjunction over all higher node ids
void dmpl::syncseqdblparam::NodeTransformer::exitEXH(dmpl::EXHExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first.id <= proc.id) continue;
    addIdMap(expr.id,pr.first.id);
    visit(expr.arg);
    delIdMap(expr.id);
    if(exprMap[shost].get()) 
      exprMap[shost] = 
        dmpl::Expr(new dmpl::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "0"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new dmpl::IntExpr("0"));
}

//compute disjunction over all lower node ids
void dmpl::syncseqdblparam::NodeTransformer::exitEXL(dmpl::EXLExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first.id >= proc.id) continue;
    addIdMap(expr.id,pr.first.id);
    visit(expr.arg);
    delIdMap(expr.id);
    if(exprMap[shost].get()) 
      exprMap[shost] = 
        dmpl::Expr(new dmpl::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "0"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new dmpl::IntExpr("0"));
}

void dmpl::syncseqdblparam::NodeTransformer::exitAsgn(dmpl::AsgnStmt &stmt)
{
  Stmt shost = hostStmt;

  bool tempParam = false;
  const LvalExpr &lval = stmt.lhs->requireLval();
  if(func) {
    if(func->tempSet.find(lval.var) != func->tempSet.end()) tempParam = true;
    else if(func->paramSet.find(lval.var) != func->paramSet.end()) tempParam = true;
  }
  
  //-- if the lhs is not spec relevant, then turn this into a NOP
  if(!tempParam && !syncSeq.isRelevantVar(proc,stmt.lhs)) {
    stmtMap[shost] = dmpl::Stmt(new dmpl::BlockStmt(StmtList()));
    return;
  }

  inLhs = true; visit(stmt.lhs); inLhs = false;
  visit(stmt.rhs);
  stmtMap[shost] = dmpl::Stmt(new dmpl::AsgnStmt(exprMap[stmt.lhs],exprMap[stmt.rhs]));
}

void dmpl::syncseqdblparam::NodeTransformer::exitFAO(dmpl::FAOStmt &stmt)
{
  Stmt shost = hostStmt;
  StmtList sl;

  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first == proc) continue;
    addIdMap(stmt.id,pr.first.id);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

void dmpl::syncseqdblparam::NodeTransformer::exitFAOL(dmpl::FAOLStmt &stmt)
{
  Stmt shost = hostStmt;
  StmtList sl;

  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first.id >= proc.id) continue;
    addIdMap(stmt.id,pr.first.id);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

void dmpl::syncseqdblparam::NodeTransformer::exitFAOH(dmpl::FAOHStmt &stmt)
{
  Stmt shost = hostStmt;
  StmtList sl;

  for(const auto &pr : syncSeq.relevantThreads) {
    if(pr.first.id <= proc.id) continue;
    addIdMap(stmt.id,pr.first.id);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

/*********************************************************************/
//constructor
/*********************************************************************/
dmpl::SyncSeqDblParam::SyncSeqDblParam(dmpl::DmplBuilder &b, const std::string &p, int r) 
  : SyncSeqDbl(b,p,r), cutoff(b.program.processes.size()) {}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void dmpl::SyncSeqDblParam::createGlobVars()
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
//create list of statements that copy new value of var into old value
//of var. append list of statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblParam::createCopyStmts(bool fwd,const Var &var,StmtList &res,ExprList indx)
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
      newIndx.push_back(Expr(new IntExpr(boost::lexical_cast<std::string>(i))));
      Var newVar = var->decrDim();
      createCopyStmts(fwd,newVar,res,newIndx);
    }
  }
}

/*********************************************************************/
//create one function that copies global variables from _i to _f
/*********************************************************************/
void dmpl::SyncSeqDblParam::createRoundCopier()
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
//create the main function
/*********************************************************************/
void dmpl::SyncSeqDblParam::createMainFunc()
{
  dmpl::VarList mainParams,mainTemps;
  StmtList mainBody,roundBody;

  //call SAFETY_fwd()
  Expr callExpr1fwd(new LvalExpr("__SAFETY_fwd"));
  Stmt callStmt1fwd(new CallStmt(callExpr1fwd,dmpl::ExprList()));
  roundBody.push_back(callStmt1fwd);

  //call forward round copier
  Expr callExpr4(new LvalExpr("round_fwd_copier"));
  Stmt callStmt4(new CallStmt(callExpr4,dmpl::ExprList()));
  roundBody.push_back(callStmt4);

  //call ROUND function of each node -- forward version
  for(const auto &pr : relevantThreads) {
    //call the _fwd version of the ROUND function of the node. this
    //copies from _i to _f
    std::string callNameFwd = pr.first.getNode() + "__" + pr.second->name + "_" + 
      boost::lexical_cast<std::string>(pr.first.id) + "_fwd";
    Expr callExprFwd(new LvalExpr(callNameFwd));
    Stmt callStmtFwd(new CallStmt(callExprFwd,dmpl::ExprList()));
    roundBody.push_back(callStmtFwd);
  }

  //call SAFETY_bwd()
  Expr callExpr1bwd(new LvalExpr("__SAFETY_bwd"));
  Stmt callStmt1bwd(new CallStmt(callExpr1bwd,dmpl::ExprList()));
  roundBody.push_back(callStmt1bwd);

  //call backward round copier
  Expr callExpr2(new LvalExpr("round_bwd_copier"));
  Stmt callStmt2(new CallStmt(callExpr2,dmpl::ExprList()));
  roundBody.push_back(callStmt2);

  //call ROUND function of each node -- backward version
  for(const auto &pr : relevantThreads) {
    //call the _bwd version of the ROUND function of the node. this
    //copies from _f to _i
    std::string callNameBwd = pr.first.getNode() + "__" + pr.second->name + "_" + 
      boost::lexical_cast<std::string>(pr.first.id) + "_bwd";
    Expr callExprBwd(new LvalExpr(callNameBwd));
    Stmt callStmtBwd(new CallStmt(callExprBwd,dmpl::ExprList()));
    roundBody.push_back(callStmtBwd);
  }

  //initialize nodeIds
  for(int i = 0;i < cutoff;++i)
    mainBody.push_back(Stmt(new AsgnStmt(nodeIds(i), Expr(new IntExpr(std::to_string(i))))));
  
  //add call to INIT()
  Expr callExpr3(new LvalExpr("__INIT"));
  Stmt callStmt3(new CallStmt(callExpr3,dmpl::ExprList()));
  mainBody.push_back(callStmt3);

  //if number of rounds not specified, add an infinite loop
  if(roundNum == -1) {
    Stmt forBody(new BlockStmt(roundBody));
    mainBody.push_back(Stmt(new ForStmt(StmtList(),ExprList(),StmtList(),forBody)));
  }
  //otherwise statically unroll the loop roundNum times and the call
  //SAFETY again one more time
  else {
    for(int i = 0;i < roundNum / 2;++i)
      mainBody.insert(mainBody.end(),roundBody.begin(),roundBody.end());
    
    //call SAFETY_fwd()
    mainBody.push_back(callStmt1fwd);

    //if roundNum is odd
    if(roundNum % 2) {
      //call forward copier
      mainBody.push_back(callStmt4);

      //call ROUND function of each node, but just the fwd
      //version. this takes care of the case when roundNum is odd
      for(const auto &pr : relevantThreads) {
        //call the _fwd version of the ROUND function of the
        //node. this copies from _i to _f
        std::string callNameFwd = pr.first.getNode() + "__" + pr.second->name + "_" + 
          boost::lexical_cast<std::string>(pr.first.id) + "_fwd";
        Expr callExprFwd(new LvalExpr(callNameFwd));
        Stmt callStmtFwd(new CallStmt(callExprFwd,dmpl::ExprList()));
        mainBody.push_back(callStmtFwd);
      }

      //call SAFETY_bwd
      mainBody.push_back(callStmt1bwd);
    }
  }

  Func mainFunc(new Function(dmpl::intType(),"main",mainParams,mainTemps,mainBody));
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//-- create the INIT function for a variable, given a process
//-- id. return a statement that calls the function, or assumes it if
//-- the variable is an input.
/*********************************************************************/
dmpl::Stmt dmpl::SyncSeqDblParam::createConstructor(const std::string &name,
                                               const Type &type, bool isInput,
                                               const Func &initFunc, const Process &proc)
{
  Node &node = proc.role->node;
  dmpl::VarList fnParams, fnTemps;

  if(initFunc != NULL) {
    fnParams = initFunc->params;
    fnTemps = initFunc->temps;
  }
  
  StmtList initFnBody;
  std::string initFnName = "__INIT_" + name + "_" + boost::lexical_cast<std::string>(proc.id);

  //-- if the variable is an input, assign it non-deterministically
  if(!type->isVoid() && isInput) {
    Expr varExpr(new LvalExpr(name));
    Expr ndfn = createNondetFunc(varExpr, type);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    Stmt ndAsgn(new AsgnStmt(varExpr,ndcall));    
    syncseqdbl::NodeTransformer nt(*this,builder.program,proc,false,initFunc);
    std::string nodeId = *node->args.begin();
    nt.addIdMap(nodeId,proc.id);
    nt.visit(ndAsgn);
    nt.delIdMap(nodeId);
    initFnBody.push_back(nt.stmtMap[ndAsgn]);
  }

  //-- initialize _i version
  if(initFunc != NULL) {
    BOOST_FOREACH(const Stmt &st,initFunc->body) {
      syncseqdbl::NodeTransformer nt(*this,builder.program,proc,false,initFunc);
      std::string nodeId = *node->args.begin();
      nt.addIdMap(nodeId,proc.id);
      nt.visit(st);
      nt.delIdMap(nodeId);
      initFnBody.push_back(nt.stmtMap[st]);
    }
  }
  
  Func func(new Function(isInput ? intType() : voidType(), initFnName,
                         fnParams, fnTemps, initFnBody));
  cprog.addFunction(func);

  //-- create a call to the function and return it
  Expr callExpr(new LvalExpr(initFnName));
  callExpr = Expr(new CallExpr(callExpr, dmpl::ExprList()));
  if(isInput) {
    dmpl::ExprList args = {callExpr};
    callExpr = Expr(new CallExpr(Expr(new LvalExpr("__CPROVER_assume")), args));
  }
  return Stmt(new CallStmt(callExpr));
}

/*********************************************************************/
//create the INIT() function
/*********************************************************************/
void dmpl::SyncSeqDblParam::createInit()
{
  StmtList fnBody;
  //-- create initializers for local and global variables
  for(const Process &proc : builder.program.processes) {
    //-- sort variables and records by read-write dependency analysis
    std::map<size_t,Var> sortedVars;
    std::map<size_t,Record> sortedRecs;
    proc.role->orderVarsRecords(sortedVars, sortedRecs);

    //-- invoke constructors in the computed dependency order
    for(size_t i = 0; i < sortedVars.size() + sortedRecs.size(); ++i) {
      //-- if the next one is a variable
      if(sortedVars.find(i) != sortedVars.end()) {
        const Var &var = sortedVars[i];
        if(!isRelevantVar(proc, var->name)) continue;
        fnBody.push_back(createConstructor(var->name, var->type, var->isInput,
                                           var->initFunc, proc));
      }
      
      //-- if the next one is a record
      //SC: we are ignoring records for now. must fix this.
      else if(sortedRecs.find(i) != sortedRecs.end()) {
        const Record &rec = sortedRecs[i];

        if(rec->initFunc != NULL && !rec->initFunc->body.empty() &&
           relevantFuncs[proc].find(rec->initFunc) != relevantFuncs[proc].end())
          fnBody.push_back(createConstructor(rec->name + "_init", voidType(), false,
                                             rec->initFunc, proc));
        
        if(rec->assumeFunc != NULL && !rec->assumeFunc->body.empty() &&
           relevantFuncs[proc].find(rec->assumeFunc) != relevantFuncs[proc].end())
          fnBody.push_back(createConstructor(rec->name + "_assume", voidType(), true,
                                             rec->assumeFunc, proc));
      }
    }
  }

  //-- also assume that the property holds after initialization
  std::string fname = "__SAFETY_" + property + "_fwd";
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
//create the SAFETY() function in forward or backward direction
/*********************************************************************/
void dmpl::SyncSeqDblParam::createSafetyFwdBwd(bool fwd)
{
  const Node &node = builder.program.nodes.begin()->second;
  Func propFunc = node->getRequireFunc(property);

  //-- create the require property function
  dmpl::VarList fnParams = propFunc->params,fnTemps = propFunc->temps;
  
  //transform the body of safety
  StmtList fnBody;
  BOOST_FOREACH(const Stmt &st,propFunc->body) {
    syncseqdbl::GlobalTransformer gt(*this,builder.program,fwd,propFunc);
    gt.visit(st);
    fnBody.push_back(gt.stmtMap[st]);
  }
  
  std::string fname = "__SAFETY_" + property + (fwd ? "_fwd" : "_bwd");
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
  Func safetyFunc(new Function(dmpl::voidType(),
                               std::string("__SAFETY") + (fwd ? "_fwd" : "_bwd"),
                               fnParams,fnTemps,safetyFnBody));
  cprog.addFunction(safetyFunc);
}

/*********************************************************************/
//create the SAFETY() functions in both directions
/*********************************************************************/
void dmpl::SyncSeqDblParam::createSafety()
{
  createSafetyFwdBwd(true);
  createSafetyFwdBwd(false);
}

/*********************************************************************/
//create list of statements that havoc a variable. append list of
//statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblParam::createHavocStmts(bool isGlob,bool fwd,const Var &var,
                                        StmtList &res,ExprList indx,int pid)
{
  //non-array type
  if(var->type->dims.empty()) {
    std::string pidStr = boost::lexical_cast<std::string>(pid);
    Expr varExpr(new LvalExpr(var->name +
                              std::string(isGlob ? (fwd ? "_i_" : "_f_") : "_")  +
                              pidStr,indx));
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
      newIndx.push_back(Expr(new IntExpr(boost::lexical_cast<std::string>(i))));
      Var newVar = var->decrDim();
      createHavocStmts(isGlob,fwd,newVar,res,newIndx,pid);
    }
  }
}

/*********************************************************************/
//create the HAVOC() function. this assigns non-deterministic values
//to all local and global shared variables that must be havoced.
/*********************************************************************/
void dmpl::SyncSeqDblParam::createHavoc()
{
  //-- create both forward and backward versions
  for(int fwd = 0;fwd < 2;++fwd) {
    Node &node = builder.program.nodes.begin()->second;
    StmtList havocFnBody;
    dmpl::VarList fnParams, fnTemps;
    
    //-- havoc locals
    for(const auto &hl : havocLocs) {
      for(const Var &v : hl.second) {
        createHavocStmts(false, fwd, v, havocFnBody, ExprList(), hl.first.id);
      }
    }
    
    //-- havoc globals
    for(const auto &hg : havocGlobs) {
      for(const Var &v : hg.second) {
        createHavocStmts(true, fwd, v, havocFnBody, ExprList(), hg.first.id);
      }
    }

    std::string fnName = std::string("__HAVOC_") + (fwd ? "fwd" : "bwd");
    Func func(new Function(dmpl::voidType(),fnName,fnParams,fnTemps,havocFnBody));
    cprog.addFunction(func);
  }
}

/*********************************************************************/
//create the functions for nodes
/*********************************************************************/
void dmpl::SyncSeqDblParam::createNodeFuncs()
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

      //create the forward and backward version
      for(int fwd = 0; fwd < 2; ++fwd) {
        StmtList fnBody;

        //-- if this is the thread, havoc variables
        if(f->equalType(*pr.second)) callFunction(std::string("__HAVOC_") + (fwd ? "fwd" : "bwd"), fnBody);
        
        BOOST_FOREACH(const Stmt &st,f->body) {
          syncseqdbl::NodeTransformer nt(*this,builder.program,pr.first,fwd,f);
          std::string nodeId = *node->args.begin();
          nt.addIdMap(nodeId,pr.first.id);
          nt.visit(st);
          nt.delIdMap(nodeId);
          fnBody.push_back(nt.stmtMap[st]);
        }
        
        std::string fnName = node->name + "__" + f->name + "_" + 
          boost::lexical_cast<std::string>(pr.first.id) + (fwd ? "_fwd" : "_bwd");
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
dmpl::Expr dmpl::SyncSeqDblParam::createNondetFunc(const Expr &expr, const Type &type)
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
void dmpl::SyncSeqDblParam::processExternFuncs()
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
void dmpl::SyncSeqDblParam::run()
{
  std::cout << "Sequentializing with double-buffering and 2 processes "
            << "for paramaterized verification ...\n";

  //-- add command line as header
  std::string header = "//-- DMPLC Version: " + builder.version + "\n";
  header += "//-- DMPLC Command Line:";
  for(const std::string &c : builder.cmdLine) header += std::string(" ") + c;
  cprog.addHeader(header + "\n");
  
  //-- copy over constants
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
