#include <iostream>
#include "Node.h"
#include "Program.h"

void
daig::Program::print (unsigned int indent)
{
  std::string spacer (indent, ' ');

  std::cout << spacer << "Program::moc: " << moc.to_string_type () << "\n";
  std::cout << spacer << "Program::processes: " << processes << "\n";
  std::cout << spacer << "Program::variables:\n";

  for (daig::Variables::iterator i = variables.begin ();
       i != variables.end (); ++i)
  {
    i->second.print (indent + 2);
  }
  
  std::cout << spacer << "Program::functions:\n";

  for (daig::Functions::iterator i = functions.begin ();
       i != functions.end (); ++i)
  {
    i->second.print (indent + 2);
  }
  
  for (unsigned i = 0;
    i < nodes.size (); ++i)
  {
    std::cout << spacer << "Program:nodes[" << i << "]:\n";
    nodes[i].print (indent + 2);
  }

}
