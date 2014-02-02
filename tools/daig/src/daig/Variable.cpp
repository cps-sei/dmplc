#include <iostream>
#include "Variable.h"

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

