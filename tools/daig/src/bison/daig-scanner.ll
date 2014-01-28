%{
#include <string>
#include <map>
#include "Program.h"
#include "daig-parser.hpp"
extern std::map<std::string,std::string> constDef;
#define PRINT_TOKEN printf("%s\n",yytext)
#define SAVE_TOKEN PRINT_TOKEN; yylval.string = new std::string(yytext, yyleng)
#define TOKEN(t) (yylval.token = t)
extern "C" int yywrap() { }
%}

%%

[ \t\n]                 ;
"MOC_SYNC"                  PRINT_TOKEN; return TOKEN(TMOCSYNC);
"MOC_ASYNC"                 PRINT_TOKEN; return TOKEN(TMOCASYNC);
"MOC_PSYNC"                 PRINT_TOKEN; return TOKEN(TMOCPSYNC);
"CONST"                     PRINT_TOKEN; return TOKEN(TCONST);
"NODE"                      PRINT_TOKEN; return TOKEN(TNODE);
"PUBLIC"                    PRINT_TOKEN; return TOKEN(TPUBLIC);
"PRIVATE"                   PRINT_TOKEN; return TOKEN(TPRIVATE);
"bool"                      PRINT_TOKEN; return TOKEN(TBOOL);
"int"                       PRINT_TOKEN; return TOKEN(TINT);
"void"                      PRINT_TOKEN; return TOKEN(TVOID);
"char"                      PRINT_TOKEN; return TOKEN(TCHAR);
"signed"                    PRINT_TOKEN; return TOKEN(TSIGNED);
"unsigned"                  PRINT_TOKEN; return TOKEN(TUNSIGNED);
"#N"                        PRINT_TOKEN; return TOKEN(TNODENUM);
"ATOMIC"                    PRINT_TOKEN; return TOKEN(TATOMIC);
"if"                        PRINT_TOKEN; return TOKEN(TIF);
"else"                      PRINT_TOKEN; return TOKEN(TELSE);
"for"                       PRINT_TOKEN; return TOKEN(TFOR);
"while"                     PRINT_TOKEN; return TOKEN(TWHILE);
"break"                     PRINT_TOKEN; return TOKEN(TBREAK);
"continue"                  PRINT_TOKEN; return TOKEN(TCONTINUE);
"return"                    PRINT_TOKEN; return TOKEN(TRETURN);
"PROGRAM"                   PRINT_TOKEN; return TOKEN(TPROGRAM);
"INIT"                      PRINT_TOKEN; return TOKEN(TINIT);
"SAFETY"                    PRINT_TOKEN; return TOKEN(TSAFETY);
"FORALL_NODE"               PRINT_TOKEN; return TOKEN(TFAN);
"FORALL_DISTINCT_NODE_PAIR" PRINT_TOKEN; return TOKEN(TFADNP);
"FORALL_OTHER"              PRINT_TOKEN; return TOKEN(TFAO);
"FORALL_OTHER_LOWER"        PRINT_TOKEN; return TOKEN(TFAOL);
"FORALL_OTHER_HIGHER"       PRINT_TOKEN; return TOKEN(TFAOH);
[a-zA-Z_][a-zA-Z0-9_]*  {
                          /** substitute constant definitions */
                          std::map<std::string,std::string>::const_iterator it = 
                            constDef.find(std::string(yytext));
                          if(it == constDef.end()) {
                            SAVE_TOKEN; return TIDENTIFIER;
                          }
                          yylval.string = new std::string(it->second);
                          printf("%s\n",yylval.string->c_str());
                          return TINTEGER;
                        }
[0-9]+\.[0-9]*          SAVE_TOKEN; return TDOUBLE;
[0-9]+                  SAVE_TOKEN; return TINTEGER;
"="                     PRINT_TOKEN; return TOKEN(TEQUAL);
"=="                    PRINT_TOKEN; return TOKEN(TCEQ);
"!="                    PRINT_TOKEN; return TOKEN(TCNE);
"<"                     PRINT_TOKEN; return TOKEN(TCLT);
"<="                    PRINT_TOKEN; return TOKEN(TCLE);
">"                     PRINT_TOKEN; return TOKEN(TCGT);
">="                    PRINT_TOKEN; return TOKEN(TCGE);
"&&"                    PRINT_TOKEN; return TOKEN(TLAND);
"||"                    PRINT_TOKEN; return TOKEN(TLOR);
"!"                     PRINT_TOKEN; return TOKEN(TLNOT);
"("                     PRINT_TOKEN; return TOKEN(TLPAREN);
")"                     PRINT_TOKEN; return TOKEN(TRPAREN);
"{"                     PRINT_TOKEN; return TOKEN(TLBRACE);
"}"                     PRINT_TOKEN; return TOKEN(TRBRACE);
"["                     PRINT_TOKEN; return TOKEN(TLBRACKET);
"]"                     PRINT_TOKEN; return TOKEN(TRBRACKET);
"."                     PRINT_TOKEN; return TOKEN(TDOT);
","                     PRINT_TOKEN; return TOKEN(TCOMMA);
"+"                     PRINT_TOKEN; return TOKEN(TPLUS);
"-"                     PRINT_TOKEN; return TOKEN(TMINUS);
"*"                     PRINT_TOKEN; return TOKEN(TMUL);
"/"                     PRINT_TOKEN; return TOKEN(TDIV);
";"                     PRINT_TOKEN; return TOKEN(TSEMICOLON);
"//".*\n
.                       printf("Unknown token <%s>!\n",yytext); yyterminate();

%%
