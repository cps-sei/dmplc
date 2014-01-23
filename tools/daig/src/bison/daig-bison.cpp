#include <iostream>
#include "Program.h"

daig::Program *program;
extern int yyparse();

int main(int argc, char **argv)
{
    yyparse();
    return 0;
}
