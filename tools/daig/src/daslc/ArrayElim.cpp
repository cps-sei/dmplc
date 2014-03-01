#include <boost/lexical_cast.hpp>
#include "daig/Type.h"
#include "daig/Variable.h"
#include "daig/Expression.h"
#include "daig/Statement.h"
#include "daig-parser.hpp"
#include "ArrayElim.hpp"

/*********************************************************************/
//constructor
/*********************************************************************/
daig::ArrayElim::ArrayElim(CProgram &ip) : inProg(ip) {}

/*********************************************************************/
//run the array eliminator -- construct the output program
/*********************************************************************/
void daig::ArrayElim::run()
{
  outProg = inProg;
}

/*********************************************************************/
//end of file
/*********************************************************************/
