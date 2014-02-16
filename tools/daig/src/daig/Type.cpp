#include <assert.h>
#include <boost/foreach.hpp>
#include "Type.h"
#include "Variable.h"
#include "Expression.h"
#include "Statement.h"
#include "../bison/daig-parser.hpp"

/*********************************************************************/
//return basic types
/*********************************************************************/
daig::Type daig::voidType() { return Type(new daig::BaseType(TVOID)); }
daig::Type daig::intType() { return Type(new daig::BaseType(TINT)); }
daig::Type daig::charType() { return Type(new daig::BaseType(TCHAR)); }
daig::Type daig::boolType() { return Type(new daig::BaseType(TBOOL)); }

/*********************************************************************/
///convert base type to string
/*********************************************************************/
std::string daig::BaseType::toString() const
{
  std::string res;

  if(qual == TSIGNED) res = "signed ";
  else if(qual == TUNSIGNED) res = "unsigned ";
  else assert(qual == 0 && "ERROR : illegal type qualifier");

  if(type == TVOID) res += "void";
  else if(type == TBOOL) res += "_Bool";
  else if(type == TINT) res += "int";
  else if(type == TCHAR) res += "char";
  else assert(0 && "ERROR : illegal simple type");

  return res;
}

/*********************************************************************/
///print the type with appropriate indentation
/*********************************************************************/
void daig::BaseType::print (std::ostream &os,unsigned int indent)
{
  os << std::string(' ',indent) << toString();
}

/*********************************************************************/
///return a copy but instantiate dimension #N with nodeNum
/*********************************************************************/
daig::Type daig::BaseType::instDim(size_t nodeNum)
{
  BaseType *res = new BaseType(*this);

  BOOST_FOREACH(int &i,res->dims)
    if(i == -1) i = static_cast<int>(nodeNum);

  return Type(res);
}

///return a copy with one less dimension
daig::Type daig::BaseType::decrDim()
{
  BaseType *res = new BaseType(*this);
  assert(!res->dims.empty() && "ERROR: cannot decrease dimensions of non-array type!");
  res->dims.pop_front();
  return Type(res);
}

/*********************************************************************/
//end of file
/*********************************************************************/
