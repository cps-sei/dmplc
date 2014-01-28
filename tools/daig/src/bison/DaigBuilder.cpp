#include <stdio.h>
#include "DaigBuilder.hpp"

//the complete program
daig::Program *program;

//constant definitions, these are stored in this map, and then
//substituted during parsing
std::map<std::string,std::string> *constDef;

//debug flag
bool daigDebug;

//the parser routine
extern int yyparse();

//the file pointer for lex
extern FILE *yyin;

//run the parser
void DaigBuilder::run()
{
  ::program = &(this->program);
  ::constDef = &(this->constDef);
  ::daigDebug = debug;
  ::yyin = fopen(fileName.c_str(),"r");
  ::yyparse();
  fclose(::yyin);
}
