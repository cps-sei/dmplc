#include <iostream>
#include <map>
#include <string>
#include "Program.h"

//the complete program
daig::Program *program;

//constant definitions, these are stored in this map, and then
//substituted during parsing
std::map<std::string,std::string> constDef;

extern int yyparse();

int main(int argc, char **argv)
{
  //create the program
  daig::Program _program;
  program = &_program;

  //parse the program file
  yyparse();

  //all done
  return 0;
}
