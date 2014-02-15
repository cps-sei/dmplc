#include "SyncSeq.hpp"

/*********************************************************************/
//run the sequentialization, generating a C program
/*********************************************************************/
void daig::SyncSeq::run()
{
  std::cout << "Sequentializing with " << nodeNum << " nodes ...\n";
  Program &prog = builder.program;
  
  //currently we support distributed programs with a single type of of
  //node only
  assert(prog.nodes.size() == 1 && "ERROR: multiple node types unsupported!");
  Node &node = prog.nodes.begin()->second;
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
