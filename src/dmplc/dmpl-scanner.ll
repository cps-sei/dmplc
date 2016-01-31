/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

%{
#include <string>
#include <map>
#include "dmpl/Type.h"
#include "dmpl/Expression.h"
#include "dmpl/Statement.h"
#include "dmpl/Specification.hpp"
#include "DmplBuilder.hpp"
#include "dmpl-parser.hpp"
extern dmpl::DmplBuilder *builder; /* the dmpl builder */
#define PRINT_TOKEN if(builder->debug) printf("%s\n",yytext)
#define SAVE_TOKEN PRINT_TOKEN; yylval.string = new std::string(yytext, yyleng)
#define TOKEN(t) (yylval.token = t)
extern std::string thunk;
extern "C" int yywrap() { return 1; }
%}

%x IN_COMMENT IN_THUNK

%%
"/*"             { BEGIN(IN_COMMENT); }
<IN_COMMENT>"*/" { BEGIN(INITIAL); }
<IN_COMMENT>\n   { }
<IN_COMMENT>.    { }
"%%{"            { thunk.clear(); BEGIN(IN_THUNK); }
<IN_THUNK>"%%}"  { BEGIN(INITIAL); return TOKEN(TTHUNK); }
<IN_THUNK>\n     { 
                   thunk.push_back(yytext[0]); 
                   if(builder->debug) printf("thunk = {%s}\n",thunk.c_str());
                 }
<IN_THUNK>.      { 
                   thunk.push_back(yytext[0]);
                   if(builder->debug) printf("thunk = {%s}\n",thunk.c_str());
                 }
[ \t\n]                     ;
"CONST"                     PRINT_TOKEN; return TOKEN(TCONST);
"const"                     PRINT_TOKEN; return TOKEN(TCONST);
"NODE"                      PRINT_TOKEN; return TOKEN(TNODE);
"node"                      PRINT_TOKEN; return TOKEN(TNODE);
"role"                      PRINT_TOKEN; return TOKEN(TROLE);
"GLOBAL"                    PRINT_TOKEN; return TOKEN(TGLOBAL);
"global"                    PRINT_TOKEN; return TOKEN(TGLOBAL);
"LOCAL"                     PRINT_TOKEN; return TOKEN(TLOCAL);
"local"                     PRINT_TOKEN; return TOKEN(TLOCAL);
"group"                     PRINT_TOKEN; return TOKEN(TGROUP);
"TARGET"                    PRINT_TOKEN; return TOKEN(TTARGET);
"target"                    PRINT_TOKEN; return TOKEN(TTARGET);
"_Bool"                     PRINT_TOKEN; return TOKEN(TBOOL);
"bool"                      PRINT_TOKEN; return TOKEN(TBOOL);
"int"                       PRINT_TOKEN; return TOKEN(TINT);
"double"                    PRINT_TOKEN; return TOKEN(TDOUBLE_TYPE);
"void"                      PRINT_TOKEN; return TOKEN(TVOID);
"char"                      PRINT_TOKEN; return TOKEN(TCHAR);
"signed"                    PRINT_TOKEN; return TOKEN(TSIGNED);
"unsigned"                  PRINT_TOKEN; return TOKEN(TUNSIGNED);
"#N"                        PRINT_TOKEN; return TOKEN(TNODENUM);
"EXTERN"                    PRINT_TOKEN; return TOKEN(TEXTERN);
"extern"                    PRINT_TOKEN; return TOKEN(TEXTERN);
"PURE"                      PRINT_TOKEN; return TOKEN(TPURE);
"pure"                      PRINT_TOKEN; return TOKEN(TPURE);
"thread"                    PRINT_TOKEN; return TOKEN(TTHREAD);
"override"                  PRINT_TOKEN; return TOKEN(TOVERRIDE);
"record"                    PRINT_TOKEN; return TOKEN(TRECORD);
"input"                     PRINT_TOKEN; return TOKEN(TINPUT);
"if"                        SAVE_TOKEN; return TIF;
"require"                   SAVE_TOKEN; return TREQUIRE;
"expect"                    SAVE_TOKEN; return TEXPECT;
"else"                      PRINT_TOKEN; return TOKEN(TELSE);
"for"                       PRINT_TOKEN; return TOKEN(TFOR);
"while"                     PRINT_TOKEN; return TOKEN(TWHILE);
"break"                     PRINT_TOKEN; return TOKEN(TBREAK);
"continue"                  PRINT_TOKEN; return TOKEN(TCONTINUE);
"return"                    PRINT_TOKEN; return TOKEN(TRETURN);
"EXISTS_OTHER"              PRINT_TOKEN; return TOKEN(TEXO);
"EXISTS_HIGHER"             PRINT_TOKEN; return TOKEN(TEXH);
"EXISTS_LOWER"              PRINT_TOKEN; return TOKEN(TEXL);
"exists_other"              PRINT_TOKEN; return TOKEN(TEXO);
"exists_higher"             PRINT_TOKEN; return TOKEN(TEXH);
"exists_lower"              PRINT_TOKEN; return TOKEN(TEXL);
"FORALL_NODE"               PRINT_TOKEN; return TOKEN(TFAN);
"FORALL_DISTINCT_NODE_PAIR" PRINT_TOKEN; return TOKEN(TFADNP);
"FORALL_OTHER"              PRINT_TOKEN; return TOKEN(TFAO);
"FORALL_OTHER_LOWER"        PRINT_TOKEN; return TOKEN(TFAOL);
"FORALL_OTHER_HIGHER"       PRINT_TOKEN; return TOKEN(TFAOH);
"forall_node"               PRINT_TOKEN; return TOKEN(TFAN);
"forall_distinct_node_pair" PRINT_TOKEN; return TOKEN(TFADNP);
"forall_other"              PRINT_TOKEN; return TOKEN(TFAO);
"forall_other_lower"        PRINT_TOKEN; return TOKEN(TFAOL);
"forall_other_higher"       PRINT_TOKEN; return TOKEN(TFAOH);
"at_end"                    PRINT_TOKEN; return TOKEN(TATEND);
"at_least"                  PRINT_TOKEN; return TOKEN(TATLEAST);
"id"                        PRINT_TOKEN; return TID;
"NAN"                       SAVE_TOKEN; return TDOUBLE;
[0-9]+\.[0-9]*              SAVE_TOKEN; return TDOUBLE;
[0-9]+                      SAVE_TOKEN; return TINTEGER;
  /* [a-zA-Z_][a-zA-Z0-9_]*(::[a-zA-Z_][a-zA-Z0-9_]*)+  SAVE_TOKEN; return TNAMESPACE; */
[a-zA-Z_][a-zA-Z0-9_]*  {
                          /** substitute constant definitions */
                          /*std::map<std::string,std::string>::const_iterator it = 
                            builder->program.constDef.find(std::string(yytext));
                          if(it == builder->program.constDef.end()) {*/
                            SAVE_TOKEN; return TIDENTIFIER;
                          /*}
                          yylval.string = new std::string(it->second);
                          if(builder->debug) printf("%s\n",yylval.string->c_str());
                          return TINTEGER;*/
                        }
"@"                     PRINT_TOKEN; return TOKEN(TAT);
@[a-zA-Z_][a-zA-Z0-9_]* SAVE_TOKEN; return TATTRIBUTE;
"="                     PRINT_TOKEN; return TOKEN(TEQUAL);
"=="                    PRINT_TOKEN; return TOKEN(TCEQ);
"=>"                    PRINT_TOKEN; return TOKEN(TIMPLIES);
"!="                    PRINT_TOKEN; return TOKEN(TCNE);
"<"                     PRINT_TOKEN; return TOKEN(TCLT);
"<="                    PRINT_TOKEN; return TOKEN(TCLE);
">"                     PRINT_TOKEN; return TOKEN(TCGT);
">="                    PRINT_TOKEN; return TOKEN(TCGE);
"&&"                    PRINT_TOKEN; return TOKEN(TLAND);
"||"                    PRINT_TOKEN; return TOKEN(TLOR);
"!"                     PRINT_TOKEN; return TOKEN(TLNOT);
"?"                     PRINT_TOKEN; return TOKEN(TQUEST);
":"                     PRINT_TOKEN; return TOKEN(TCOLON);
"("                     PRINT_TOKEN; return TOKEN(TLPAREN);
")"                     PRINT_TOKEN; return TOKEN(TRPAREN);
"{"                     PRINT_TOKEN; return TOKEN(TLBRACE);
"}"                     PRINT_TOKEN; return TOKEN(TRBRACE);
"["                     PRINT_TOKEN; return TOKEN(TLBRACKET);
"]"                     PRINT_TOKEN; return TOKEN(TRBRACKET);
"::"                    PRINT_TOKEN; return TOKEN(TDCOLON);
","                     PRINT_TOKEN; return TOKEN(TCOMMA);
"+"                     PRINT_TOKEN; return TOKEN(TPLUS);
"-"                     PRINT_TOKEN; return TOKEN(TMINUS);
"*"                     PRINT_TOKEN; return TOKEN(TMUL);
"/"                     PRINT_TOKEN; return TOKEN(TDIV);
"%"                     PRINT_TOKEN; return TOKEN(TMOD);
"~"                     PRINT_TOKEN; return TOKEN(TBWNOT);
"&"                     PRINT_TOKEN; return TOKEN(TBWAND);
"|"                     PRINT_TOKEN; return TOKEN(TBWOR);
"^"                     PRINT_TOKEN; return TOKEN(TBWXOR);
"<<"                    PRINT_TOKEN; return TOKEN(TBWLSH);
">>"                    PRINT_TOKEN; return TOKEN(TBWRSH);
";"                     PRINT_TOKEN; return TOKEN(TSEMICOLON);
"//".*\n
.                       printf("Unknown token <%s>!\n",yytext); yyterminate();

%%
