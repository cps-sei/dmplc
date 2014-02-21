#include "Node.h"
#include <iostream>

void
daig::Node::print (std::ostream &os,unsigned int indent)
{
  std::string spacer (indent, ' ');

  os << spacer << "NODE " << name << "(";
  size_t count = 0;
  BOOST_FOREACH(const std::string &a,args) {
    os << (count ? "," : "") << a;
    count++;
  }
  os << ")\n" << spacer << "{\n";  

  for (daig::Variables::iterator i = globVars.begin ();i != globVars.end (); ++i)
    os << spacer << "  GLOBAL " << i->second.toString() << ";\n";
  os << "\n";

  for (daig::Variables::iterator i = locVars.begin ();i != locVars.end (); ++i)
    os << spacer << "  LOCAL " << i->second.toString() << ";\n";
  os << "\n";

  for (daig::Functions::iterator i = funcs.begin ();i != funcs.end (); ++i)
    i->second.print (os,indent+2);
  os << "\n";

  os << spacer << "}\n\n";


  /*
  std::cout << "Node::global_variables:\n";

  for (daig::Variables::iterator i = globVars.begin ();i != globVars.end (); ++i)
    i->second.print (2);

  std::cout << "Node::local_variables:\n";

  for (daig::Variables::iterator i = locVars.begin ();i != locVars.end (); ++i)
    i->second.print (2);
  
  std::cout << "Node::functions:\n";

  for (daig::Functions::iterator i = funcs.begin ();i != funcs.end (); ++i)
    i->second.print (2);
  */
}
