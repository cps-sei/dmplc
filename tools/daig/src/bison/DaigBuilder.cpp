#include <stdio.h>
#include "DaigBuilder.hpp"

//pointer to the builder to be passed to the parser and lexer
daig::DaigBuilder *builder = NULL;

//the parser routine
extern int yyparse();

//the file pointer for lex
extern FILE *yyin;

//run the parser
void daig::DaigBuilder::run()
{
  ::builder = this;
  ::yyin = fopen(fileName.c_str(),"r");
  ::yyparse();
  fclose(::yyin);
  program.print(2);
}
