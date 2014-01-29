#include <boost/foreach.hpp>
#include "Expression.h"

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
  return "<OP>";
}
