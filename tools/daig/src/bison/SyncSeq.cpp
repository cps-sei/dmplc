#include <boost/lexical_cast.hpp>
#include "Type.h"
#include "Variable.h"
#include "Expression.h"
#include "Statement.h"
#include "daig-parser.hpp"
#include "SyncSeq.hpp"

/*********************************************************************/
//methods for GlobalTransformer
/*********************************************************************/

//add id to int mapping
void daig::GlobalTransformer::addIdMap(const std::string &s,size_t i)
{
  if(idMap.count(s)) {
    std::cerr << "ERROR: substitution mapping for " << s << " exists already!!\n";
    assert(0);
  }
  idMap[s] = i;
}

//remove id to int mappiing
void daig::GlobalTransformer::delIdMap(const std::string &s)
{
  if(!idMap.count(s)) {
    std::cerr << "ERROR: substitution mapping for " << s << " doesn't exist!!\n";
    assert(0);
  }
  idMap.erase(s);
}

//collect results for an expr list
daig::ExprList daig::GlobalTransformer::collect(const ExprList &el)
{
  daig::ExprList res;
  BOOST_FOREACH(const daig::Expr &e,el) res.push_back(exprMap[e]);
  return res;
}

//collect results for an stmt list
daig::StmtList daig::GlobalTransformer::collect(const StmtList &sl)
{
  daig::StmtList res;
  BOOST_FOREACH(const daig::Stmt &s,sl) res.push_back(stmtMap[s]);
  return res;
}

/*********************************************************************/
//dispatchers for expressions
/*********************************************************************/

void daig::GlobalTransformer::exitInt(daig::IntExpr &expr)
{
  exprMap[hostExpr] = hostExpr;
}

void daig::GlobalTransformer::exitLval(daig::LvalExpr &expr)
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

  iit = idMap.find(expr.node);
  newName = iit == idMap.end() ? newName : 
    newName + "_" + boost::lexical_cast<std::string>(iit->second);

  exprMap[hostExpr] = daig::Expr(new daig::LvalExpr(newName,collect(expr.indices)));
  
  //std::cout << "**************************************\n";
  //std::cout << hostExpr->toString() << '\n';
  //std::cout << exprMap[hostExpr]->toString() << '\n';
}

void daig::GlobalTransformer::exitComp(daig::CompExpr &expr)
{
  exprMap[hostExpr] = daig::Expr(new daig::CompExpr(expr.op,collect(expr.args)));
}

void daig::GlobalTransformer::exitCall(daig::CallExpr &expr)
{
  exprMap[hostExpr] = daig::Expr(new daig::CallExpr(exprMap[expr.func],
                                                    collect(expr.args)));
}

/*********************************************************************/
//dispatchers for statements
/*********************************************************************/

void daig::GlobalTransformer::exitAtomic(daig::AtomicStmt &stmt)
{
  stmtMap[hostStmt] = stmtMap[stmt.data];
}

void daig::GlobalTransformer::exitPrivate(daig::PrivateStmt &stmt)
{
  stmtMap[hostStmt] = stmtMap[stmt.data];
}

void daig::GlobalTransformer::exitBlock(daig::BlockStmt &stmt)
{
  stmtMap[hostStmt] = Stmt(new BlockStmt(collect(stmt.data)));
}

void daig::GlobalTransformer::exitAsgn(daig::AsgnStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new AsgnStmt(exprMap[stmt.lhs],exprMap[stmt.rhs]));

  //std::cout << "**************************************\n";
  //hostStmt->print(std::cout,0);
  //stmtMap[hostStmt]->print(std::cout,0);
}

void daig::GlobalTransformer::exitIT(daig::ITStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new ITStmt(exprMap[stmt.cond], stmtMap[stmt.tbranch]));
}

void daig::GlobalTransformer::exitITE(daig::ITEStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new ITEStmt(exprMap[stmt.cond], stmtMap[stmt.tbranch], 
                                       stmtMap[stmt.ebranch]));
}

void daig::GlobalTransformer::exitFor(daig::ForStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new ForStmt(collect(stmt.init),collect(stmt.test),
                                       collect(stmt.update),stmtMap[stmt.body]));
}

void daig::GlobalTransformer::exitWhile(daig::WhileStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new WhileStmt(exprMap[stmt.cond],stmtMap[stmt.body]));
}

void daig::GlobalTransformer::exitBreak(daig::BreakStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void daig::GlobalTransformer::exitCont(daig::ContStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void daig::GlobalTransformer::exitRet(daig::RetStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new RetStmt(exprMap[stmt.retVal]));
}

void daig::GlobalTransformer::exitRetVoid(daig::RetVoidStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void daig::GlobalTransformer::exitCall(daig::CallStmt &stmt) 
{ 
  stmtMap[hostStmt] = Stmt(new CallStmt(exprMap[stmt.data]));
}

void daig::GlobalTransformer::exitFAN(daig::FANStmt &stmt) 
{ 
  Stmt shost = hostStmt;
  StmtList sl;

  for(size_t i = 0;i < nodeNum;++i) {
    addIdMap(stmt.id,i);
    visit(stmt.data);
    sl.push_back(stmtMap[stmt.data]);
    delIdMap(stmt.id);
  }

  stmtMap[shost] = Stmt(new daig::BlockStmt(sl));
}

void daig::GlobalTransformer::exitFADNP(daig::FADNPStmt &stmt) 
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

  stmtMap[shost] = Stmt(new daig::BlockStmt(sl));
}

void daig::GlobalTransformer::exitFAO(daig::FAOStmt &stmt) 
{ 
  stmtMap[hostStmt] = hostStmt; 
}

void daig::GlobalTransformer::exitFAOL(daig::FAOLStmt &stmt) 
{ stmtMap[hostStmt] = hostStmt; }

void daig::GlobalTransformer::exitFAOH(daig::FAOHStmt &stmt) 
{ stmtMap[hostStmt] = hostStmt; }

/*********************************************************************/
//methods for NodeTransformer
/*********************************************************************/

void daig::NodeTransformer::exitLval(daig::LvalExpr &expr)
{
  exprMap[hostExpr] = hostExpr;

  //substitute global variable name x with x_i
  std::string newName = expr.var;

  //handle function call
  if(inCall) newName += ("_" + boost::lexical_cast<std::string>(nodeId));

  //handle global variables -- distinguishing between lhs of
  //assignments and other cases
  Node &node = prog.nodes.begin()->second;
  if(node.globVars.count(expr.var)) {
    if(inLhs) newName += "_f";
    else newName += "_i";
  }

  //substitute .id with its mapping in idMap
  std::map<std::string,size_t>::const_iterator iit = idMap.find(expr.var);
  newName = iit == idMap.end() ? newName : boost::lexical_cast<std::string>(iit->second);

  iit = idMap.find(expr.node);
  newName = iit == idMap.end() ? newName : 
    newName + "_" + boost::lexical_cast<std::string>(iit->second);

  exprMap[hostExpr] = daig::Expr(new daig::LvalExpr(newName,collect(expr.indices)));
  
  //std::cout << "**************************************\n";
  //std::cout << hostExpr->toString() << '\n';
  //std::cout << exprMap[hostExpr]->toString() << '\n';
}

void daig::NodeTransformer::exitCall(daig::CallExpr &expr) 
{
  Expr shost = hostExpr;
  inCall = true;
  visit(expr.func);
  inCall = false;
  BOOST_FOREACH(Expr &e,expr.args) visit(e);
  exprMap[shost] = daig::Expr(new daig::CallExpr(exprMap[expr.func],collect(expr.args)));
}

//compute disjunction over all other node ids
void daig::NodeTransformer::exitEXO(daig::EXOExpr &expr)
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
        daig::Expr(new daig::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "1"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new daig::IntExpr(1));
}

//compute disjunction over all higher node ids
void daig::NodeTransformer::exitEXH(daig::EXHExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(size_t i = nodeId+1;i < nodeNum;++i) {
    addIdMap(expr.id,i);
    visit(expr.arg);
    delIdMap(expr.id);
    if(exprMap[shost].get()) 
      exprMap[shost] = 
        daig::Expr(new daig::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "1"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new daig::IntExpr(1));
}

//compute disjunction over all lower node ids
void daig::NodeTransformer::exitEXL(daig::EXLExpr &expr)
{
  Expr shost = hostExpr;
  exprMap[shost] = Expr();
  for(size_t i = 0;i < nodeId;++i) {
    addIdMap(expr.id,i);
    visit(expr.arg);
    delIdMap(expr.id);
    if(exprMap[shost].get()) 
      exprMap[shost] = 
        daig::Expr(new daig::CompExpr(TLOR,exprMap[shost],exprMap[expr.arg]));
    else
      exprMap[shost] = exprMap[expr.arg];
  }

  //turn empty disjunct into "1"
  if(!exprMap[shost].get())
    exprMap[shost] = Expr(new daig::IntExpr(1));
}

void daig::NodeTransformer::exitAsgn(daig::AsgnStmt &stmt)
{
  Stmt shost = hostStmt;
  inLhs = true; visit(stmt.lhs); inLhs = false;
  visit(stmt.rhs);
  stmtMap[shost] = daig::Stmt(new daig::AsgnStmt(exprMap[stmt.lhs],exprMap[stmt.rhs]));
}

/*********************************************************************/
//constructor
/*********************************************************************/
daig::SyncSeq::SyncSeq(daig::DaigBuilder &b,size_t n) : builder(b),nodeNum(n) 
{
  Program &prog = builder.program;
  assert(prog.nodes.size() == 1 && "ERROR: only node type supported!");
}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void daig::SyncSeq::createGlobVars()
{
  Node &node = builder.program.nodes.begin()->second;

  //instantiate node-global variables by replacing dimension #N with
  //nodeNum -- make two copies, one for initial value for a round, and
  //the other for the final value for a round
  std::list<Variable> gvars;
  BOOST_FOREACH(Variables::value_type &v,node.globVars) {
    gvars.push_back(v.second.instDim(nodeNum));
  }
  BOOST_FOREACH(const Variable &v,gvars) {
    cprog.addGlobVar(v.instName("_i"));
    cprog.addGlobVar(v.instName("_f"));
  }

  //instantiate node-local variables by adding _i for each node id i
  BOOST_FOREACH(Variables::value_type &v,node.locVars) {
    for(size_t i = 0;i < nodeNum;++i)
      cprog.addGlobVar(v.second.instName(std::string("_") + 
                                         boost::lexical_cast<std::string>(i)));
  }
}

/*********************************************************************/
//create list of statements that copy new value of var into old value
//of var. append list of statements to res.
/*********************************************************************/
void daig::SyncSeq::createCopyStmts(const Variable &var,StmtList &res,ExprList indx)
{
  //non-array type
  if(var.type->dims.empty()) {
    Expr lhs(new LvalExpr(var.name + "_i",indx));
    Expr rhs(new LvalExpr(var.name + "_f",indx));
    Stmt stmt(new AsgnStmt(lhs,rhs));
    res.push_back(stmt);
    return;
  }

  //array type -- peel off the first dimension and iterate over it
  //recursively
  int dim = *(var.type->dims.begin());
  for(int i = 0;i < dim;++i) {
    ExprList newIndx = indx;
    newIndx.push_back(Expr(new IntExpr(i)));
    Variable newVar = var.decrDim();
    createCopyStmts(newVar,res,newIndx);
  }
}

/*********************************************************************/
//create function that copies global variables back at the end of a
//round
/*********************************************************************/
void daig::SyncSeq::createRoundCopier()
{
  Node &node = builder.program.nodes.begin()->second;
  std::list<daig::Variable> fnParams,fnTemps;
  StmtList fnBody;

  BOOST_FOREACH(Variables::value_type &v,node.globVars) {
    Variable var = v.second.instDim(nodeNum);
    createCopyStmts(var,fnBody,ExprList());
  }

  Function func(daig::voidType(),"round_copier",fnParams,fnTemps,fnBody);
  cprog.addFunction(func);
}

/*********************************************************************/
//create the main function
/*********************************************************************/
void daig::SyncSeq::createMainFunc()
{
  std::list<daig::Variable> mainParams,mainTemps;
  StmtList mainBody,roundBody;

  //call SAFETY()
  Expr callExpr1(new LvalExpr("SAFETY"));
  Stmt callStmt1(new CallStmt(callExpr1,daig::ExprList()));
  roundBody.push_back(callStmt1);

  //call ROUND function of each node
  for(size_t i = 0;i < nodeNum;++i) {
    std::string callName = std::string("ROUND_") + boost::lexical_cast<std::string>(i);
    Expr callExpr(new LvalExpr(callName));
    Stmt callStmt(new CallStmt(callExpr,daig::ExprList()));
    roundBody.push_back(callStmt);
  }

  //call round copier
  Expr callExpr2(new LvalExpr("round_copier"));
  Stmt callStmt2(new CallStmt(callExpr2,daig::ExprList()));
  roundBody.push_back(callStmt2);

  //add call to INIT()
  Expr callExpr3(new LvalExpr("INIT"));
  Stmt callStmt3(new CallStmt(callExpr3,daig::ExprList()));
  mainBody.push_back(callStmt3);

  //add the for statement
  Stmt forBody(new BlockStmt(roundBody));
  mainBody.push_back(Stmt(new ForStmt(StmtList(),ExprList(),StmtList(),forBody)));

  Function mainFunc(daig::voidType(),"main",mainParams,mainTemps,mainBody);
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//create the INIT() function
/*********************************************************************/
void daig::SyncSeq::createInit()
{
  std::list<daig::Variable> fnParams,fnTemps;
  StmtList fnBody;

  //if no INIT() defined, create an empty one
  daig::Functions::iterator fit = builder.program.funcs.find("INIT");
  if(fit == builder.program.funcs.end()) {
    std::cout << "node does not have a INIT function, creating an empty one ...\n";
    Function func(daig::voidType(),"INIT",fnParams,fnTemps,fnBody);
    cprog.addFunction(func);
    return;
  }

  //transform the body of init
  BOOST_FOREACH(const Stmt &st,fit->second.body) {
    GlobalTransformer gt(builder.program,nodeNum);
    gt.visit(st);
    fnBody.push_back(gt.stmtMap[st]);
  }

  Function func(daig::voidType(),"INIT",fnParams,fnTemps,fnBody);
  cprog.addFunction(func);
}

/*********************************************************************/
//create the SAFETY() function
/*********************************************************************/
void daig::SyncSeq::createSafety()
{
  Node &node = builder.program.nodes.begin()->second;
  std::list<daig::Variable> fnParams,fnTemps;
  StmtList fnBody;

  //if no SAFETY() defined, create an empty one
  daig::Functions::iterator fit = builder.program.funcs.find("SAFETY");
  if(fit == builder.program.funcs.end()) {
    std::cout << "node does not have a SAFETY function, creating an empty one ...\n";
    Function func(daig::voidType(),"SAFETY",fnParams,fnTemps,fnBody);
    cprog.addFunction(func);
    return;
  }

  //transform the body of safety
  BOOST_FOREACH(const Stmt &st,fit->second.body) {
    GlobalTransformer gt(builder.program,nodeNum);
    gt.visit(st);
    fnBody.push_back(gt.stmtMap[st]);
  }

  Function func(daig::voidType(),"SAFETY",fnParams,fnTemps,fnBody);
  cprog.addFunction(func);
}

/*********************************************************************/
//create the functions for nodes
/*********************************************************************/
void daig::SyncSeq::createNodeFuncs()
{
  Node &node = builder.program.nodes.begin()->second;
  for(size_t i = 0;i < nodeNum;++i) {
    BOOST_FOREACH(Functions::value_type &f,node.funcs) {
      std::list<daig::Variable> fnParams,fnTemps;
      StmtList fnBody;

      BOOST_FOREACH(const Stmt &st,f.second.body) {
        NodeTransformer nt(builder.program,nodeNum,i);

        //currently, nodes have just one parameter -- its id
        assert(node.args.size() == 1 && "ERROR: node must have one id!");
        std::string nodeId = *node.args.begin();
        nt.addIdMap(nodeId,i);
        nt.visit(st);
        nt.delIdMap(nodeId);
        fnBody.push_back(nt.stmtMap[st]);
      }

      std::string fnName = f.second.name + "_" + boost::lexical_cast<std::string>(i);
      Function func(daig::voidType(),fnName,fnParams,fnTemps,fnBody);
      cprog.addFunction(func);
    }
  }
}

/*********************************************************************/
//run the sequentialization, generating a C program
/*********************************************************************/
void daig::SyncSeq::run()
{
  std::cout << "Sequentializing with " << nodeNum << " nodes ...\n";

  createGlobVars();
  createRoundCopier();
  createMainFunc();
  createInit();
  createSafety();
  createNodeFuncs();

  //instantiate functions
}

/*********************************************************************/
//print the sequentialized program
/*********************************************************************/
void daig::SyncSeq::printProgram(std::ostream &os)
{
  cprog.print(os,0);
}

/*********************************************************************/
//end of file
/*********************************************************************/
