#include <iostream>
#include "Variable.h"

//constructor with name only -- assigns a default type and scope
daig::Variable::Variable(const std::string &n) 
  : name(n),type(daig::Type(new BaseType())),scope(0) {}

//constructor with name and dimensions -- assigns a default base type
//and scope
daig::Variable::Variable(const std::string &n,const std::list<int> &d) 
  : name(n),type(daig::Type(new BaseType(d))),scope(0) {}

//print with indentation to stdout
void
daig::Variable::print (unsigned int indent)
{
  std::cout << std::string (indent, ' ');

  if (this->scope == LOCAL)
    std::cout << "LOCAL ";
  else
    std::cout << "GLOBAL ";

  std::cout << this->name << "\n";
}

