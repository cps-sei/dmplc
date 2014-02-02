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
    std::cout << "CONST ";

  if (this->scope == LOCAL)
    std::cout << "LOCAL ";

  else
    std::cout << "GLOBAL ";

  std::cout << to_str_type () << " ";

  std::cout << this->name << " = " << this->value << "\n";
}

std::string
daig::Variable::to_str_type (void)
{
  std::string strtype = "ANY";

  if (type == INTEGER)
  {
    strtype = "INT";
  }
  else if (type == DOUBLE)
  {
    strtype = "DOUBLE";
  }
  else if (type == INTEGER_ARRAY)
  {
    strtype = "INTEGER_ARRAY";
  }
  else if (type == DOUBLE_ARRAY)
  {
    strtype = "DOUBLE_ARRAY";
  }
  else if (type == STRING)
  {
    strtype = "STRING";
  }
  else if (type == FILE)
  {
    strtype = "FILE";
  }

  return strtype;
}

void
daig::Variable::set_type (const std::string & strtype)
{
  if (strtype == "INT" || strtype == "INTEGER")
  {
    type = INTEGER;
  }
  else if (strtype == "DOUBLE")
  {
    type = DOUBLE;
  }
  else if (strtype == "INTEGER_ARRAY")
  {
    type = INTEGER_ARRAY;
  }
  else if (strtype == "DOUBLE_ARRAY")
  {
    type = DOUBLE_ARRAY;
  }
  else if (strtype == "STRING")
  {
    type = STRING;
  }
  else if (strtype == "FILE")
  {
    type = FILE;
  }
  else
  {
    type = ANY;
  }
}
