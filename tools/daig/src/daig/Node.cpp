#include "Node.h"
#include <iostream>

void
daig::Node::print (unsigned int level)
{
  std::cout << "Node::global_variables:\n";

  for (daig::Variables::iterator i = globVars.begin ();
       i != globVars.end (); ++i)
  {
    i->second.print (2);
  }

  std::cout << "Node::local_variables:\n";

  for (daig::Variables::iterator i = locVars.begin ();
       i != locVars.end (); ++i)
  {
    i->second.print (2);
  }
  
  std::cout << "Node::functions:\n";

  for (daig::Functions::iterator i = functions.begin ();
       i != functions.end (); ++i)
  {
    i->second.print (2);
  }
}
