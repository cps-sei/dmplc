#include <boost/lexical_cast.hpp>
#include "SyncSeq.hpp"

/*********************************************************************/
//constructor
/*********************************************************************/
daig::SyncSeq::SyncSeq(daig::DaigBuilder &b,size_t n) : builder(b),nodeNum(n) 
{
  Program &prog = builder.program;
  assert(prog.nodes.size() == 1 && "ERROR: multiple node types unsupported!");
}

/*********************************************************************/
//create the global variables
/*********************************************************************/
void daig::SyncSeq::createGlobVars()
{
  Program &prog = builder.program;
  Node &node = prog.nodes.begin()->second;

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
//create the main function
/*********************************************************************/
void daig::SyncSeq::createMainFunc()
{
  std::list<daig::Variable> mainParams,mainTemps;
  StmtList mainBody,roundBody;
  for(size_t i = 0;i < nodeNum;++i) {
    std::string callName = std::string("ROUND_") + boost::lexical_cast<std::string>(i);
    Expr callExpr(new LvalExpr(callName));
    Stmt callStmt(new CallStmt(callExpr,daig::ExprList()));
    roundBody.push_back(callStmt);
  }
  Stmt forBody(new BlockStmt(roundBody));
  mainBody.push_back(Stmt(new ForStmt(StmtList(),ExprList(),StmtList(),forBody)));

  Function mainFunc(daig::voidType(),"main",mainParams,mainTemps,mainBody);
  cprog.addFunction(mainFunc);
}

/*********************************************************************/
//run the sequentialization, generating a C program
/*********************************************************************/
void daig::SyncSeq::run()
{
  std::cout << "Sequentializing with " << nodeNum << " nodes ...\n";

  //create global variables
  createGlobVars();

  //create the main function
  createMainFunc();

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
