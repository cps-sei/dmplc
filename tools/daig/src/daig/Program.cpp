#include <iostream>
#include <boost/foreach.hpp>
#include "Node.h"
#include "Program.h"

void
daig::Program::print (unsigned int indent)
{
  std::string spacer (indent, ' ');

  std::cout << spacer << "Program::moc: " << moc.to_string_type () << "\n";

  std::cout << spacer << "Program::processes: " << processes.size() << "\n";
  BOOST_FOREACH(const Process &p,processes)
    std::cout << '\t' << p.getNode() << '(' << p.getId() << ")\n";

  std::cout << spacer << "Program::variables:\n";

  for (daig::Variables::iterator i = variables.begin ();
       i != variables.end (); ++i)
  {
    i->second.print (indent + 2);
  }
  
  for (daig::Nodes::iterator i = nodes.begin (); i != nodes.end (); ++i)
  {
    std::cout << spacer << "Program:node [" << i->second.name << "]:\n";
    i->second.print (indent + 2);
  }
  
  std::cout << spacer << "Program::functions:\n";

  for (daig::Functions::iterator i = functions.begin ();
       i != functions.end (); ++i)
  {
    i->second.print (indent + 2);
  }

}
