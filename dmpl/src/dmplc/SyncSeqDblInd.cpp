/**
 * Copyright (c) 2014 Carnegie Mellon University. All Rights Reserved.

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

 * DM-0001023
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
    exprMap[hostExpr] = Expr(new IntExpr(nodeNum));
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
        std::cerr << "Error: bad @node specifier. Unknown identifier: " << nodeExpr->toString() << std::endl;
        exit(1);
      }
      else
      {
        return boost::lexical_cast<std::string>(iit->second);
      }
    }
    catch(std::bad_cast)
    {
      std::cerr << "Error: bad @node specifier (" << nodeExpr->toString() << "); must be integer, or identifier" << std::endl;
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
  if(node.globVars.count(expr.var)) newName += "_i";

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
    const Expr &arg = exprMap[*(expr->args.begin())];
    Expr ndfn = syncSeq.createNondetFunc(arg);
    Expr ndcall(new CallExpr(ndfn,ExprList()));
    stmtMap[hostStmt] = Stmt(new AsgnStmt(arg,ndcall));
    return;
  }

  stmtMap[hostStmt] = Stmt(new CallStmt(exprMap[stmt.data]));
}

void dmpl::syncseqdblind::GlobalTransformer::exitFAN(dmpl::FANStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  for(size_t i = 0;i < nodeNum;++i) {
    addIdMap(stmt.id,i);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

void dmpl::syncseqdblind::GlobalTransformer::exitFADNP(dmpl::FADNPStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  for(size_t i1 = 0;i1 < nodeNum;++i1) {
    for(size_t i2 = i1+1;i2 < nodeNum;++i2) {
      addIdMap(stmt.id1,i1);
      addIdMap(stmt.id2,i2);
      visit(stmt.data);
      sl.push_back(stmtMap[stmt.data]);
      delIdMap(stmt.id1);
      delIdMap(stmt.id2);
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
  Node &node = prog.nodes.begin()->second;

  //handle function call -- change name if the function is defined at top-level
  if(inCall && prog.isInternalFunction(newName)) 
    newName += (std::string("_") + (fwd ? "fwd" : "bwd"));
  //handle function call -- change name if the function is defined in node
  else if(inCall && node.isFunction(newName)) 
    newName = (node.name + "__" + newName + "_" + boost::lexical_cast<std::string>(nodeId) +
                "_" + (fwd ? "fwd" : "bwd"));
  else
  {
    bool isGlob = node.globVars.count(expr.var) > 0;
    bool isLoc = node.locVars.count(expr.var) > 0;

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
    //if(node.locVars.count(expr.var))
      //newName += "_" + boost::lexical_cast<std::string>(nodeId);

    //substitute .id with its mapping in idMap
    std::map<std::string,size_t>::const_iterator iit = idMap.find(expr.var);
    newName = iit == idMap.end() ? newName : boost::lexical_cast<std::string>(iit->second);

    if(isGlob || isLoc) 
    {
      if(expr.node != NULL)
        newName = newName + "_" + getNodeStr(expr);
      else
        newName += "_" + boost::lexical_cast<std::string>(nodeId);
    }
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
  for(size_t i = 0;i < nodeNum;++i) {
    if(i == nodeId) continue;
    addIdMap(expr.id,i);
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
    exprMap[shost] = Expr(new dmpl::IntExpr(0));
}

//compute disjunction over all higher node ids
void dmpl::syncseqdblind::NodeTransformer::exitEXH(dmpl::EXHExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(size_t i = nodeId+1;i < nodeNum;++i) {
    addIdMap(expr.id,i);
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
    exprMap[shost] = Expr(new dmpl::IntExpr(0));
}

//compute disjunction over all lower node ids
void dmpl::syncseqdblind::NodeTransformer::exitEXL(dmpl::EXLExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(size_t i = 0;i < nodeId;++i) {
    addIdMap(expr.id,i);
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
    exprMap[shost] = Expr(new dmpl::IntExpr(0));
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

  for(size_t i = 0;i < nodeNum;++i) {
    if(i == nodeId) continue;
    addIdMap(stmt.id,i);
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

  for(size_t i = 0;i < nodeId;++i) {
    addIdMap(stmt.id,i);
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

  for(size_t i = nodeId+1;i < nodeNum;++i) {
    addIdMap(stmt.id,i);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new dmpl::BlockStmt(sl));
}

/*********************************************************************/
//constructor
/*********************************************************************/
dmpl::SyncSeqDblInd::SyncSeqDblInd(dmpl::DmplBuilder &b,int r) 
  : builder(b),roundNum(r)
{
  nodeNum = builder.program.processes.size();
}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void dmpl::SyncSeqDblInd::createGlobVars()
{
  Node &node = builder.program.nodes.begin()->second;

  //instantiate node-global variables by replacing dimension #N with
  //nodeNum -- make two copies, one for initial value for a round, and
  //the other for the final value for a round
  dmpl::VarList gvars;
  BOOST_FOREACH(Vars::value_type &v,node.globVars) {
    gvars.push_back(v.second->instDim(nodeNum));
  }
  BOOST_FOREACH(const Var &v,gvars) {
    for(size_t i = 0;i < nodeNum;++i) {
      cprog.addGlobVar(v->instName(std::string("_i_") + boost::lexical_cast<std::string>(i)));
      cprog.addGlobVar(v->instName(std::string("_f_") + boost::lexical_cast<std::string>(i)));
    }
  }

  //instantiate node-local variables by adding _i for each node id i
  BOOST_FOREACH(Vars::value_type &v,node.locVars) {
    for(size_t i = 0;i < nodeNum;++i) {
      cprog.addGlobVar(v.second->instName(std::string("_") + 
                                         boost::lexical_cast<std::string>(i)));
    }
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
      newIndx.push_back(Expr(new IntExpr(i)));
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
  Node &node = builder.program.nodes.begin()->second;
  dmpl::VarList fnParams,fnTemps;

  //create the copier from _f to _i
  StmtList fnBody1;
  for(size_t i = 0;i < nodeNum;++i) {
    BOOST_FOREACH(Vars::value_type &v,node.globVars) {
      Var var = v.second->instDim(nodeNum);
      createCopyStmts(0,var,fnBody1,ExprList(),i);
    }
  }

  Func func1(new Function(dmpl::voidType(),"round_bwd_copier",fnParams,fnTemps,fnBody1));
  cprog.addFunction(func1);

  //create the copier from _i to _f
  StmtList fnBody2;
  for(size_t i = 0;i < nodeNum;++i) {
    BOOST_FOREACH(Vars::value_type &v,node.globVars) {
      Var var = v.second->instDim(nodeNum);
      createCopyStmts(1,var,fnBody2,ExprList(),i);
    }
  }

  Func func2(new Function(dmpl::voidType(),"round_fwd_copier",fnParams,fnTemps,fnBody2));
  cprog.addFunction(func2);
}

/*********************************************************************/
//create the main function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createMainFunc()
{
  dmpl::VarList mainParams,mainTemps;
  StmtList mainBody;

  {
    //add call to INIT()
    Expr callExpr1(new LvalExpr("__INIT"));
    Stmt callStmt1(new CallStmt(callExpr1,dmpl::ExprList()));
    mainBody.push_back(callStmt1);
    
    //-- add call to SAFETY()
    Expr callExpr2(new LvalExpr("__SAFETY"));
    Stmt callStmt2(new CallStmt(callExpr2,dmpl::ExprList()));
    mainBody.push_back(callStmt2);
    
    //-- add call to HAVOC()
    Expr callExpr3(new LvalExpr("__HAVOC"));
    Stmt callStmt3(new CallStmt(callExpr3,dmpl::ExprList()));
    mainBody.push_back(callStmt3);
    
    //-- add call to ASSUME()
    Expr callExpr4(new LvalExpr("__ASSUME"));
    Stmt callStmt4(new CallStmt(callExpr4,dmpl::ExprList()));
    mainBody.push_back(callStmt4);

    //-- call forward round copier
    Expr callExpr5(new LvalExpr("round_fwd_copier"));
    Stmt callStmt5(new CallStmt(callExpr5,dmpl::ExprList()));
    mainBody.push_back(callStmt5);

    //-- find the ROUND functions
    Func roundFunc;
    const Node &node = builder.program.nodes.begin()->second;
    BOOST_FOREACH(const Funcs::value_type &f, node.funcs) {
      int barSync = f.second->attrs.count("BARRIER_SYNC");
      if(barSync < 1)
        continue;
      else if(barSync > 1)
        std::cerr << "Warning: function " << f.second->name <<
          " has more than one @BARRIER_SYNC attribute" << std::endl;
      if(roundFunc != NULL) {
        std::cerr << "Warning: function " << roundFunc->name << " is not the " <<
          "only @BARRIER_SYNC function; also found: " << f.second->name <<
          " which will be ignored." << std::endl;
      }
      roundFunc = f.second;
    }

    if(roundFunc == NULL) {
      std::cerr << "Error: no @BARRIER_SYNC function found." << std::endl;
      exit(1);
    }

    //call ROUND function of each node -- forward version
    for(size_t i = 0;i < nodeNum;++i) {
      //call the _fwd version of the ROUND function of the node. this
      //copies from _i to _f
      std::string callNameFwd = node.name + "__" + roundFunc->name + "_" + 
        boost::lexical_cast<std::string>(i) + "_fwd";
      Expr callExprFwd(new LvalExpr(callNameFwd));
      Stmt callStmtFwd(new CallStmt(callExprFwd,dmpl::ExprList()));
      mainBody.push_back(callStmtFwd);
    }

    //call backward round copier
    Expr callExpr6(new LvalExpr("round_bwd_copier"));
    Stmt callStmt6(new CallStmt(callExpr6,dmpl::ExprList()));
    mainBody.push_back(callStmt6);

    //call SAFETY()
    mainBody.push_back(callStmt2);
  }
  
  Func mainFunc(new Function(dmpl::intType(),"main",mainParams,mainTemps,mainBody));
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//create the INIT() function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createInit()
{
  StmtList initFnBody;

  BOOST_FOREACH(Funcs::value_type &f, builder.program.funcs) {
    if(f.second->isExtern == true)
      continue;
      
    int init = f.second->attrs.count("INIT");
    if(init < 1)
      continue;
    else if(init > 1)
      std::cerr << "Warning: function " << f.second->name <<
        " has more than one @INIT attribute" << std::endl;

    dmpl::VarList fnParams,fnTemps;
    StmtList fnBody;

    //create parameters
    BOOST_FOREACH(Vars::value_type &v,f.second->params)
      fnParams.push_back(v.second);

    //create temporary variables
    BOOST_FOREACH(Vars::value_type &v,f.second->temps)
      fnTemps.push_back(v.second);

    //transform the body of init
    BOOST_FOREACH(const Stmt &st,f.second->body) {
      syncseqdblind::GlobalTransformer gt(*this,builder.program,nodeNum);
      gt.visit(st);
      fnBody.push_back(gt.stmtMap[st]);
    }

    std::string fname = "__INIT_" + f.second->name;
    Func func(new Function(dmpl::voidType(),fname,fnParams,fnTemps,fnBody));
    cprog.addFunction(func);

    Expr callExpr(new LvalExpr(fname));
    Stmt callStmt(new CallStmt(callExpr,dmpl::ExprList()));
    initFnBody.push_back(callStmt);
  }

  dmpl::VarList fnParams, fnTemps;

  Func func(new Function(dmpl::voidType(),"__INIT",fnParams,fnTemps,initFnBody));
  cprog.addFunction(func);
}

/*********************************************************************/
//create the SAFETY() function
/*********************************************************************/
void dmpl::SyncSeqDblInd::createSafety()
{
  StmtList safetyFnBody;

  BOOST_FOREACH(Funcs::value_type &f, builder.program.funcs) {
    if(f.second->isExtern == true)
      continue;

    int safety = f.second->attrs.count("SAFETY");
    if(safety < 1)
      continue;
    else if(safety > 1)
      std::cerr << "Warning: function " << f.second->name <<
        " has more than one @SAFETY attribute" << std::endl;

    dmpl::VarList fnParams,fnTemps;
    StmtList fnBody;
    //create parameters
    BOOST_FOREACH(Vars::value_type &v,f.second->params)
      fnParams.push_back(Var(new Variable(*v.second)));

    //create temporary variables
    BOOST_FOREACH(Vars::value_type &v,f.second->temps)
      fnTemps.push_back(Var(new Variable(*v.second)));

    //transform the body of safety
    BOOST_FOREACH(const Stmt &st,f.second->body) {
      syncseqdblind::GlobalTransformer gt(*this,builder.program,nodeNum);
      gt.visit(st);
      fnBody.push_back(gt.stmtMap[st]);
    }

    std::string fname = "__SAFETY_" + f.second->name;
    Func func(new Function(dmpl::voidType(), fname, fnParams,fnTemps,fnBody));
    cprog.addFunction(func);

    Expr callExpr(new LvalExpr(fname));
    Stmt callStmt(new CallStmt(callExpr,dmpl::ExprList()));
    safetyFnBody.push_back(callStmt);
  }

  dmpl::VarList fnParams, fnTemps;

  Func func(new Function(dmpl::voidType(),"__SAFETY",fnParams,fnTemps,safetyFnBody));
  cprog.addFunction(func);
}

/*********************************************************************/
//create the functions for nodes
/*********************************************************************/
void dmpl::SyncSeqDblInd::createNodeFuncs()
{
  Node &node = builder.program.nodes.begin()->second;
  for(size_t i = 0;i < nodeNum;++i) {
    BOOST_FOREACH(Funcs::value_type &f,node.funcs) {
      dmpl::VarList fnParams,fnTemps;

      //create parameters
      BOOST_FOREACH(Vars::value_type &v,f.second->params)
        fnParams.push_back(v.second);

      //create temporary variables
      BOOST_FOREACH(Vars::value_type &v,f.second->temps)
        fnTemps.push_back(v.second);

      //create the forward version
      {
        StmtList fnBody;

        BOOST_FOREACH(const Stmt &st,f.second->body) {
          syncseqdblind::NodeTransformer nt(*this,builder.program,nodeNum,i,true);
          std::string nodeId = *node.args.begin();
          nt.addIdMap(nodeId,i);
          nt.visit(st);
          nt.delIdMap(nodeId);
          fnBody.push_back(nt.stmtMap[st]);
        }
        
        std::string fnName = node.name + "__" + f.second->name + "_" + 
          boost::lexical_cast<std::string>(i) + "_fwd";
        Func func(new Function(f.second->retType,fnName,fnParams,fnTemps,fnBody));
        cprog.addFunction(func);
      }

      //create the backward version
      {
        StmtList fnBody;

        BOOST_FOREACH(const Stmt &st,f.second->body) {
          syncseqdblind::NodeTransformer nt(*this,builder.program,nodeNum,i,false);
          std::string nodeId = *node.args.begin();
          nt.addIdMap(nodeId,i);
          nt.visit(st);
          nt.delIdMap(nodeId);
          fnBody.push_back(nt.stmtMap[st]);
        }
        
        std::string fnName = node.name + "__" + f.second->name + "_" + 
          boost::lexical_cast<std::string>(i) + "_bwd";
        Func func(new Function(f.second->retType,fnName,fnParams,fnTemps,fnBody));
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
dmpl::Expr dmpl::SyncSeqDblInd::createNondetFunc(const Expr &expr)
{
  const LvalExpr *lve = dynamic_cast<LvalExpr*>(expr.get());
  assert(lve && "ERROR: can only create nondet function for LvalExpr");
  return Expr(new LvalExpr("nondet_" + lve->var));
}

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


    Func func(new Function(ef.second->retType,ef.second->name,ef.second->params,fnTemps,fnBody));
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
            << nodeNum << " nodes ...\n";

  //copy over constants
  cprog.constDef = builder.program.constDef;

  createGlobVars();
  processExternFuncs();
  createRoundCopier();
  createMainFunc();
  createInit();
  createSafety();
  createNodeFuncs();

  //instantiate functions
}

/*********************************************************************/
//end of file
/*********************************************************************/
