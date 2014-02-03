#include <iostream>
#include "Function.h"

void
daig::Function::print (unsigned int indent)
{
  std::string spacer (indent, ' ');
  std::string spacer_2 (indent, ' ');

  std::cout << spacer;

  std::cout << this->name << ":\n";
  
  std::cout << spacer_2;
  std::cout << "parameters:";

  for (daig::Variables::iterator i = params.begin (); i != params.end (); ++i)
    i->second.print (2);

  std::cout << spacer_2;
  std::cout << "temp vars:";

  for (daig::Variables::iterator i = temps.begin (); i != temps.end (); ++i)
    i->second.print (2);

  std::cout << spacer_2;
  std::cout << "body:\n";
  BOOST_FOREACH(const Stmt &st,body) std::cout << st->toString () << "\n";
}
