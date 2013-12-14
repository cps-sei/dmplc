#include <iostream>
#include "Function.h"

void
daig::Function::print (unsigned int indent)
{
  std::cout << std::string (indent, ' ');

  std::cout << this->name << " = " << this->body.to_string () << "\n";
}