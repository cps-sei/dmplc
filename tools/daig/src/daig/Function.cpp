#include <iostream>
#include "Function.h"

/*********************************************************************/
//print function
/*********************************************************************/
void
daig::Function::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << retType->toString() << " " << name << "(";

  size_t count = 0;
  for (daig::Variables::iterator i = params.begin (); i != params.end (); ++i) {
    if(count) os << ",";
    os << i->second.toString();
    count++;
  }

  os << ")\n";
  os << spacer << "{\n";
  
  for (daig::Variables::iterator i = temps.begin (); i != temps.end (); ++i) {
    i->second.print (os,indent + 2);
    os << ";\n";
  }

  BOOST_FOREACH(const Stmt &st,body) {
    st->print (os,indent + 2);
  }

  os << spacer << "}\n\n";
}

/*********************************************************************/
//print function declaration
/*********************************************************************/
void
daig::Function::printDecl (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << retType->toString() << " " << name << "(";

  size_t count = 0;
  for (daig::Variables::iterator i = params.begin (); i != params.end (); ++i) {
    if(count) os << ",";
    os << i->second.toString();
    count++;
  }

  os << ");\n";
}

/*********************************************************************/
//end of file
/*********************************************************************/
