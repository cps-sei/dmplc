#include "Node.h"
#include <iostream>

void
daig::Node::print (unsigned int level)
{
  std::cout << "Node::variables:\n";

  for (daig::Variables::iterator i = variables.begin ();
       i != variables.end (); ++i)
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