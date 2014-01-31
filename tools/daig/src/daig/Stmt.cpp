#include <assert.h>
#include <boost/foreach.hpp>
#include "Stmt.h"

//copy constructor
daig::StmtList::StmtList(const StmtList &rhs)
{
  BOOST_FOREACH(Stmt *sp,rhs) push_back(sp->clone());
}

//destructor
daig::StmtList::~StmtList()
{
  BOOST_FOREACH(Stmt *sp,*this) delete sp;
}

//assignment operator
const daig::StmtList &daig::StmtList::operator = (const daig::StmtList &rhs)
{
  if(&rhs == this) return *this;
  BOOST_FOREACH(Stmt *sp,*this) delete sp;
  clear();
  BOOST_FOREACH(Stmt *sp,rhs) push_back(sp->clone());
}

