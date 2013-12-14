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
  std::cout << "args:";

  for (unsigned int i = 0; i < args.size (); ++i)
  {
    std::cout << args[i]->to_string ();

    if (i != args.size () - 1)
      std::cout << ", ";
  }

  std::cout << "\n";
  std::cout << spacer_2;

  std::cout << "body:\n" << this->body.to_string () << "\n";
}