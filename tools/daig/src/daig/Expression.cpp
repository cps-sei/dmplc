#include <assert.h>
#include <boost/foreach.hpp>
#include "Expression.h"
#include "../bison/daig-parser.hpp"

//copy constructor
daig::ExprList::ExprList(const ExprList &rhs)
{
  BOOST_FOREACH(Expression *ep,rhs) push_back(ep->clone());
}

//destructor
daig::ExprList::~ExprList()
{
  BOOST_FOREACH(Expression *ep,*this) delete ep;
}

//assignment operator
const daig::ExprList &daig::ExprList::operator = (const daig::ExprList &rhs)
{
  if(&rhs == this) return *this;
  BOOST_FOREACH(Expression *ep,*this) delete ep;
  clear();
  BOOST_FOREACH(Expression *ep,rhs) push_back(ep->clone());
}

//convert an operator to string
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
}

//convert complex expression to string
std::string daig::CompExpr::toString() const
{
  assert(!args.empty());

  if(op == TFUNCALL) {
    ExprList::const_iterator it = args.begin();
    std::string res = (*it)->toString() + "(";
    ++it;
    if(it == args.end()) return res + ")";
    res = res + (*it)->toString();
    for(++it;it != args.end();++it)
      res = res + "," + (*it)->toString();
    return res + ")";
  }

  if(args.size() == 1) {
    ExprList::const_iterator it = args.begin();
    return opToString() + (*it)->toString();
  }

  if(args.size() == 2) {
    ExprList::const_iterator it = args.begin();
    std::string res = (*it)->toString();
    for(++it;it != args.end();++it)
      res = res + opToString() + (*it)->toString();
    return res;
  }

  assert(0 && "ERROR: unknown COMPLEX expression!!");
}
