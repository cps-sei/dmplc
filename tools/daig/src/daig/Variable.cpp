#include <iostream>
#include "Variable.h"

daig::Variable::Variable ()
{

}

void
daig::Variable::print (unsigned int indent)
{
  std::cout << std::string (indent, ' ');
  if (this->classifiers & CONST_VAR)
  {
    std::cout << "CONST ";
  }
  std::cout << this->name << " = " << this->value << "\n";
}