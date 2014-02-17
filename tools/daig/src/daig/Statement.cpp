#include <assert.h>
#include <boost/foreach.hpp>
#include "Statement.h"

/*********************************************************************/
//return true if this is a BlockStmt
/*********************************************************************/
bool daig::isBlock(const daig::Stmt &stmt)
{
  return dynamic_cast<BlockStmt*>(&*stmt) != NULL;
}

/*********************************************************************/
//end of file
/*********************************************************************/
