#include <iostream>
#include <boost/foreach.hpp>
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
    char buf[128];
    if(d == -1) snprintf(buf,128,"[#N]");
    else snprintf(buf,128,"[%d]",d);
    res += std::string(buf);
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

