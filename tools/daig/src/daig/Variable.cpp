#include <iostream>
#include <stdio.h>
#include <boost/foreach.hpp>
#include <boost/lexical_cast.hpp>
#include "Variable.h"

//constructor with name only -- assigns a default type and scope
daig::Variable::Variable(const std::string &n) 
  : name(n),type(daig::Type(new BaseType())),scope(0) {}

//constructor with name and dimensions -- assigns a default base type
//and scope
daig::Variable::Variable(const std::string &n,const std::list<int> &d) 
  : name(n),type(daig::Type(new BaseType(d))),scope(0) {}

//convert to string
std::string daig::Variable::toString() const
{
  std::string res = type->toString() + " " + name;
  BOOST_FOREACH(int d,type->dims) {
    res += "[" + ((d == -1) ? "#N" : boost::lexical_cast<std::string>(d)) + "]";
  }
  return res;
}

//print with indentation
void
daig::Variable::print (std::ostream &os,unsigned int indent)
{
  std::string spacer(indent, ' ');
  os << spacer << toString();
}

///return a copy but instantiate dimension #N with nodeNum
daig::Variable daig::Variable::instDim(size_t nodeNum) const
{
  Variable res = *this;
  res.type = res.type->instDim(nodeNum);
  return res;
}

///return a copy but change name to name+ext
daig::Variable daig::Variable::instName(std::string ext) const
{
  Variable res = *this;
  res.name = res.name + ext;
  return res;
}

///return a copy with one less dimension
daig::Variable daig::Variable::decrDim() const
{
  Variable res = *this;
  res.type = res.type->decrDim();
  return res;  
}
