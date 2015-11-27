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
//methods for GlobalTransformer
/*********************************************************************/

//add id to int mapping
void dmpl::syncseqdblind::GlobalTransformer::addIdMap(const std::string &s,size_t i)
{
  idMap[s] = i;
}

//remove id to int mappiing
void dmpl::syncseqdblind::GlobalTransformer::delIdMap(const std::string &s)
{
  idMap.erase(s);
}

/*********************************************************************/
//dispatchers for expressions
/*********************************************************************/

void dmpl::syncseqdblind::GlobalTransformer::exitComp(dmpl::CompExpr &expr)
{
  if(expr.op == TNODENUM)
    throw std::runtime_error("ERROR: found unsupported #N dimension!!");
  else
    exprMap[hostExpr] = dmpl::Expr(new dmpl::CompExpr(expr.op,collect(expr.args)));
}

std::string dmpl::syncseqdblind::GlobalTransformer::getNodeStr(const dmpl::LvalExpr &expr) const
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

void dmpl::syncseqdblind::GlobalTransformer::exitLval(dmpl::LvalExpr &expr)
{
  exprMap[hostExpr] = hostExpr;

  //substitute global variable name x with x_i
  std::string newName = expr.var;

  //handle assume and assert
  if(newName == "ASSUME") newName = "__CPROVER_assume";
  else if(newName == "ASSERT") newName = "assert";

  //handle global variables
  Node &node = prog.nodes.begin()->second;
  if(node->globVars.count(expr.var)) newName += "_i";

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

void dmpl::syncseqdblind::GlobalTransformer::exitPrivate(dmpl::PrivateStmt &stmt)
{
  stmtMap[hostStmt] = stmtMap[stmt.data];
}

void dmpl::syncseqdblind::GlobalTransformer::exitCall(dmpl::CallStmt &stmt) 
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

void dmpl::syncseqdblind::GlobalTransformer::exitFAN(dmpl::FANStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  for(const auto &pr : syncSeq.relevantThreads) {
    syncseqdblind::NodeTransformer nt(syncSeq,prog,pr.first,true);
    nt.idMap = idMap;
    nt.addIdMap(stmt.id,pr.first.id);
    nt.visit(stmt.data);
    sl.push_back(nt.stmtMap[stmt.data]);
    nt.delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

void dmpl::syncseqdblind::GlobalTransformer::exitFADNP(dmpl::FADNPStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  auto it1 = syncSeq.relevantThreads.begin();
  for(;it1 != syncSeq.relevantThreads.end();++it1) {
    auto it2 = it1; ++it2;
    for(;it2 != syncSeq.relevantThreads.end();++it2) {
      syncseqdblind::NodeTransformer nt(syncSeq,prog,it1->first,true);
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

void dmpl::syncseqdblind::NodeTransformer::exitLval(dmpl::LvalExpr &expr)
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
  else if(newName == "ASSERT")
    newName = "assert";
  //handle function call -- change name if the function is defined at top-level
  else if(inCall && prog.isInternalFunction(newName)) 
    newName += (std::string("_") + (fwd ? "fwd" : "bwd"));
  //handle function call -- change name if the function is defined in node
  else if(inCall && node->hasFunction(newName)) 
    newName = (node->name + "__" + newName + "_" + nodeIdStr + "_" + (fwd ? "fwd" : "bwd"));
  else
  {
    bool isGlob = node->globVars.count(expr.var) > 0;
    bool isLoc = node->locVars.count(expr.var) > 0;

    //handle global variables -- distinguishing between lhs of
    //assignments and other cases, and between forward and backward
    //versions
    if(isGlob) {
      if(fwd) {
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

void dmpl::syncseqdblind::NodeTransformer::exitCall(dmpl::CallExpr &expr) 
{
  Expr shost = hostExpr;
  inCall = true;
  visit(expr.func);
  inCall = false;
  BOOST_FOREACH(Expr &e,expr.args) visit(e);
  exprMap[shost] = dmpl::Expr(new dmpl::CallExpr(exprMap[expr.func],collect(expr.args)));
}

//compute disjunction over all other node ids
void dmpl::syncseqdblind::NodeTransformer::exitEXO(dmpl::EXOExpr &expr)
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
void dmpl::syncseqdblind::NodeTransformer::exitEXH(dmpl::EXHExpr &expr)
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
void dmpl::syncseqdblind::NodeTransformer::exitEXL(dmpl::EXLExpr &expr)
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

void dmpl::syncseqdblind::NodeTransformer::exitAsgn(dmpl::AsgnStmt &stmt)
{
  Stmt shost = hostStmt;
  inLhs = true; visit(stmt.lhs); inLhs = false;
  visit(stmt.rhs);
  stmtMap[shost] = dmpl::Stmt(new dmpl::AsgnStmt(exprMap[stmt.lhs],exprMap[stmt.rhs]));
}

void dmpl::syncseqdblind::NodeTransformer::exitFAO(dmpl::FAOStmt &stmt)
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

void dmpl::syncseqdblind::NodeTransformer::exitFAOL(dmpl::FAOLStmt &stmt)
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

void dmpl::syncseqdblind::NodeTransformer::exitFAOH(dmpl::FAOHStmt &stmt)
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
dmpl::SyncSeqDblInd::SyncSeqDblInd(dmpl::DmplBuilder &b, const std::string &p, int r) 
  : builder(b), property(p), roundNum(r) {}

/*********************************************************************/
//-- compute property relevant variables and functions for each
//-- process
/*********************************************************************/
void dmpl::SyncSeqDblInd::computeRelevant()
{
  //-- iterate over all program processes
  for(const Process &proc : builder.program.processes) {
    //-- compute the property function
    Func propFunc = proc.role->node->getRequireFunc(property);
    if(propFunc == NULL) {
      std::cout << "WARNING: role " << proc.role->name << " does not have require specification named "
                << property << " : skipping ...\n";
      continue;
    }

    //-- compute the set of local and global variables read by the
    //-- spec function
    VarSet specVars;
    specVars.insert(propFunc->readsLoc.begin(), propFunc->readsLoc.end());
    specVars.insert(propFunc->readsGlob.begin(), propFunc->readsGlob.end());

    //-- compute threads that write to variables read by the spec
    for(Func f : proc.role->threads) {
      for(const Var &v : specVars) {
        if(!f->canWrite(v)) continue;
        //std::cout << "relevant thread : " << f->name << '\n';

        if(proc.role->getAttribute(f, "BarrierSync", 0) == NULL)
          throw std::runtime_error("ERROR: role " + proc.role->name + " in node " +
                                   proc.role->node->name + " has asynchronous thread " +
                                   f->name + " relevant to require property " + property + "!!");
        
        if(relevantThreads[proc] != NULL)
          throw std::runtime_error("ERROR: role " + proc.role->name + " in node " +
                                   proc.role->node->name + " has multiple threads (" +
                                   relevantThreads[proc]->name + " and " + f->name +
                                   ") relevant to require property " + property + "!!");
        
        //-- currently we only support inherited threads
        if(!f->isPrototype)
          throw std::runtime_error("ERROR: role " + proc.role->name + " in node " +
                                   proc.role->node->name + " has non-inherited thread " +
                                   f->name + " relevant to require property " + property + "!!");

        //-- actually store the inherited function
        f = proc.role->node->findFunc(f->name);        
        relevantThreads[proc] = f;
        break;
      }
    }

    //-- sanity check
    if(relevantThreads.find(proc) == relevantThreads.end()) continue;

    //-- make variables read by relevant threads also spec relevant
    Func thread = relevantThreads[proc];
    if(thread != NULL) {
      specVars.insert(thread->readsLoc.begin(), thread->readsLoc.end());
      specVars.insert(thread->readsGlob.begin(), thread->readsGlob.end());
    }
    
    //-- go over each function in the role and collect the ones that
    //-- write to a
    for(const Func &f : proc.role->allFuncsInScope()) {
      //-- skip threads and the property function itself
      if(f->isThread() || f == propFunc) continue;

      for(const Var &v : specVars) {
        if(!f->canWrite(v)) continue;
        //std::cout << "relevant function : " << f->name << '\n';
        relevantFuncs[proc].insert(f);
        break;
      }
    }

    //-- make variables read by relevant threads also spec relevant
    for(const Func &f : relevantFuncs[proc]) {
      specVars.insert(f->readsLoc.begin(), f->readsLoc.end());
      specVars.insert(f->readsGlob.begin(), f->readsGlob.end());
    }

    //-- assign relevant local and global variables
    for(const Var &v : specVars) {
      if(v->scope == Symbol::LOCAL) relevantLocs[proc].insert(v);
      else if(v->scope == Symbol::GLOBAL) relevantGlobs[proc].insert(v);
    }

    //-- assign havoc locals
    for(const Var &lv : relevantLocs[proc]) {
      for(Func f : proc.role->threads) {
        if(f->equalType(*relevantThreads[proc])) continue;
        if(!f->canWrite(lv)) continue;
        havocLocs[proc].insert(lv);
        break;
      }
    }

    //-- assign havoc locals
    for(const Var &gv : relevantGlobs[proc]) {
      for(Func f : proc.role->threads) {
        if(f->equalType(*relevantThreads[proc])) continue;
        if(!f->canWrite(gv)) continue;
        havocGlobs[proc].insert(gv);
        break;
      }
    }
  }

  //-- sanity check
  if(relevantFuncs.empty())
    throw std::runtime_error("ERROR: no relevant functions found for property " +
                             property + "!!");
}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void dmpl::SyncSeqDblInd::createGlobVars()
{
  //instantiate node-global variables -- make two copies, one for
  //initial value for a round, and the other for the final value for a
  //round
  for(const auto &rg : relevantGlobs) {
    //-- process each relevant global var
    for(const Var &v : rg.second) {
      cprog.addGlobVar(v->instName(std::string("_i_") + boost::lexical_cast<std::string>(rg.first.id)));
      cprog.addGlobVar(v->instName(std::string("_f_") + boost::lexical_cast<std::string>(rg.first.id)));
    }
  }

  //instantiate node-local variables by adding _i for each node id i
  for(const auto &rl : relevantLocs) {
    for(const Var &v : rl.second)
      cprog.addGlobVar(v->instName(std::string("_") + 
                                   boost::lexical_cast<std::string>(rl.first.id)));
  }
}

/*********************************************************************/
//create list of statements that copy new value of var into old value
//of var. append list of statements to res.
/*********************************************************************/
void dmpl::SyncSeqDblInd::createCopyStmts(bool fwd,const Var &var,StmtList &res,ExprList indx,int node)
{
  //non-array type
  if(var->type->dims.empty()) {
    std::string n = boost::lexical_cast<std::string>(node);
    Expr lhs(new LvalExpr(var->name + std::string(fwd ? "_f_" : "_i_") + n,indx));
    Expr rhs(new LvalExpr(var->name + std::string(fwd ? "_i_" : "_f_")  + n,indx));
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
      createCopyStmts(fwd,newVar,res,newIndx,node);
    }
  }
}

/*********************************************************************/
//create one function that copies global variables from _i to _f
/*********************************************************************/
void dmpl::SyncSeqDblInd::createRoundCopier()
{
  dmpl::VarList fnParams,fnTemps;
  StmtList fnBody1,fnBody2;
  
  for(const auto &rg : relevantGlobs) {
    for(const Var &v : rg.second) {
      //create the copier from _f to _i
      createCopyStmts(false,v,fnBody1,ExprList(),rg.first.id);
      //create the copier from _i to _f
      createCopyStmts(true,v,fnBody2,ExprList(),rg.first.id);
    }
  }

  cprog.addFunction(Func(new Function(dmpl::voidType(),"round_bwd_copier",fnParams,fnTemps,fnBody1)));
  cprog.addFunction(Func(new Function(dmpl::voidType(),"round_fwd_copier",fnParams,fnTemps,fnBody2)));
}

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
//-- create the INIT function for a variable, given a process
//-- id. return a statement that calls the function, or assumes it if
//-- the variable is an input.
/*********************************************************************/
dmpl::Stmt dmpl::SyncSeqDblInd::createInitVar(const Var &var, const Process &proc)
{
  Node &node = proc.role->node;
  dmpl::VarList fnParams = var->initFunc->params,fnTemps;
  for(const auto &v : var->initFunc->temps) fnTemps.push_back(v.second);
  
  StmtList initFnBody;
  std::string initFnName = "__INIT_" + var->name + "_" + boost::lexical_cast<std::string>(proc.id);

  //-- if the variable is an input, assign it non-deterministically
  if(var->isInput) {
    Expr varExpr(new LvalExpr(var->name + "_" + boost::lexical_cast<std::string>(proc.id)));
    Expr ndfn = createNondetFunc(varExpr, var->type);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    initFnBody.push_back(Stmt(new AsgnStmt(varExpr,ndcall)));
  }

  //-- initialize _i version
  BOOST_FOREACH(const Stmt &st,var->initFunc->body) {
    syncseqdblind::NodeTransformer nt(*this,builder.program,proc,false);
    std::string nodeId = *node->args.begin();
    nt.addIdMap(nodeId,proc.id);
    nt.visit(st);
    nt.delIdMap(nodeId);
    initFnBody.push_back(nt.stmtMap[st]);
  }

  //-- for global variables, also initialize _f version
  if(var->scope == Symbol::GLOBAL) {
    BOOST_FOREACH(const Stmt &st,var->initFunc->body) {
      syncseqdblind::NodeTransformer nt(*this,builder.program,proc,true);
      std::string nodeId = *node->args.begin();
      nt.addIdMap(nodeId,proc.id);
      nt.visit(st);
      nt.delIdMap(nodeId);
      initFnBody.push_back(nt.stmtMap[st]);
    }
  }
      
  Func func(new Function(var->initFunc->retType,initFnName,fnParams,fnTemps,initFnBody));
  cprog.addFunction(func);

  //-- create a call to the function and return it
  Expr callExpr(new LvalExpr(initFnName));
  callExpr = Expr(new CallExpr(callExpr, dmpl::ExprList()));
  if(var->isInput) {
    dmpl::ExprList args = {callExpr};
    callExpr = Expr(new CallExpr(Expr(new LvalExpr("__CPROVER_assume")), args));
  }
  return Stmt(new CallStmt(callExpr));
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
    syncseqdblind::GlobalTransformer gt(*this,builder.program);
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
          syncseqdblind::NodeTransformer nt(*this,builder.program,pr.first,true);
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
  std::string header = "//-- DMPLC Command Line:";
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
