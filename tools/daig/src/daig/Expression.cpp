#include <assert.h>
#include <boost/foreach.hpp>
#include "Type.h"
#include "Variable.h"
#include "Expression.h"
#include "Statement.h"
#include "daslc/daig-parser.hpp"

/*********************************************************************/
//convert an operator to string
/*********************************************************************/
std::string daig::CompExpr::opToString() const
{
  switch(op) {
  case TMINUS : return "-";
  case TPLUS : return "+";
  case TCEQ : return "==";
  case TCNE : return "!=";
  case TCLT : return "<";
  case TCLE : return "<=";
  case TCGT : return ">";
  case TCGE : return ">=";
  case TMUL : return "*";
  case TDIV : return "/";
  case TLAND : return "&&";
  case TLOR : return "||";
  case TLNOT : return "!";
  default: assert(0 && "ERROR : unknown operator!!");
  }
  return "";
}

/*********************************************************************/
//convert complex expression to string
/*********************************************************************/
std::string daig::CompExpr::toString() const
{
  assert(!args.empty());

  if(args.size() == 1) {
    ExprList::const_iterator it = args.begin();
    return opToString() + (*it)->toString();
  }

  if(args.size() == 2) {
    ExprList::const_iterator it = args.begin();
    std::string res = (*it)->toString();
    for(++it;it != args.end();++it)
      res += opToString() + (*it)->toString();
    return res;
  }

  assert(0 && "ERROR: unknown COMPLEX expression!!");

  return "";
}

/*********************************************************************/
//end of file
/*********************************************************************/
