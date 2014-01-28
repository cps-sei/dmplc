%{
    #include <cstdio>
    #include <map>
    #include <string>
    #include "Program.h"
    extern std::map<std::string,std::string> constDef;
    extern daig::Program *program; /* the top level root node of our final AST */
    extern int yylex();
    void yyerror(const char *s) { printf("ERROR: %s\n", s); }
%}

/* expect 2 shift reduce conflicts */
%expect 2

/* Represents the many different ways we can access our data */
%union {
    std::string *string;
    int token;
}

/* Define our terminal symbols (tokens). This should
   match our tokens.l lex file. We also define the node type
   they represent.
 */
%token <string> TIDENTIFIER TINTEGER TDOUBLE
%token <token> TMOCSYNC TMOCASYNC TMOCPSYNC TSEMICOLON TCONST TNODE
%token <token> TPUBLIC TPRIVATE TBOOL TINT TVOID TNODENUM TATOMIC
%token <token> TIF TELSE TRETURN TPROGRAM TINIT TSAFETY TFAN TFADNP
%token <token> TCEQ TCNE TCLT TCLE TCGT TCGE TEQUAL
%token <token> TLAND TLOR TLNOT
%token <token> TLPAREN TRPAREN TLBRACE TRBRACE 
%token <token> TLBRACKET TRBRACKET TCOMMA TDOT
%token <token> TPLUS TMINUS TMUL TDIV

/* Define the type of node our nonterminal symbols represent.
   The types refer to the %union declaration above. Ex: when
   we call an ident (defined by union type ident) we are really
   calling an (NIdentifier*). It makes the compiler happy.
 */
%type <token> program moc const_list constant node node_body
%type <token> node_body_elem_list node_body_elem
%type <token> public_var private_var var_decl

/* Operator precedence for mathematical operators */
%left TPLUS TMINUS TMUL TDIV 
/* Operator precedence for comparison operators */
%left TCEQ TCNE TCLT TCLE TCGT TCGE
/* Operator precedence for logical operators */
%left TLAND TLOR
%right TLNOT

%start program

%%

program : moc const_list node prog_def init_def safety_def {};

moc : 
  TMOCSYNC TSEMICOLON { program->moc.set_type("SYNC"); }
| TMOCASYNC TSEMICOLON { program->moc.set_type("ASYNC"); }
| TMOCPSYNC TSEMICOLON { program->moc.set_type("PARTIAL"); }
;

const_list : {}
| constant {}
| const_list constant {}
;

constant : TCONST TLPAREN TIDENTIFIER TCOMMA TINTEGER TRPAREN TSEMICOLON {
  constDef[*$3] = *$5;
  delete $3; delete $5;
}
;

node : TNODE TIDENTIFIER TLPAREN TIDENTIFIER TRPAREN TLBRACE node_body TRBRACE {};

node_body : node_body_elem_list {};

node_body_elem_list :
  node_body_elem {}
| node_body_elem_list node_body_elem {}
;

node_body_elem :
  public_var {}
| private_var {}
| procedure {}
;

public_var : TPUBLIC TLPAREN var_decl TRPAREN TSEMICOLON {}
;

private_var : TPRIVATE TLPAREN var_decl TRPAREN TSEMICOLON {}
;

var_decl : type var_list {};

var_list : var {}
| var_list TCOMMA var {}
;

var : TIDENTIFIER {}
| TIDENTIFIER dimensions {}
;

dimensions : TLBRACKET dimension TRBRACKET {}
| dimensions TLBRACKET dimension TRBRACKET {}
;

dimension : TINTEGER {}
| TNODENUM {}
;

type : TBOOL {}
| TINT {}
| TVOID {}
;

procedure : type TIDENTIFIER TLPAREN param_list TRPAREN TLBRACE stmt_list TRBRACE {}
;

param_list : {}
| param_list TCOMMA type TIDENTIFIER {}
;

stmt_list : stmt {}
| stmt_list stmt {}
;

stmt : TATOMIC TLBRACE stmt_list TRBRACE {}
| TLBRACE stmt_list TRBRACE {}
| TIDENTIFIER TEQUAL expr TSEMICOLON {}
| TIDENTIFIER TDOT TIDENTIFIER TEQUAL expr TSEMICOLON {}
| TIF TLPAREN expr TRPAREN stmt {}
| TIF TLPAREN expr TRPAREN stmt TELSE stmt {}
| TRETURN expr TSEMICOLON {}
| TRETURN TSEMICOLON {}
| TIDENTIFIER TLPAREN arg_list TRPAREN TSEMICOLON {}
| TFAN TLPAREN TIDENTIFIER TRPAREN TLBRACE stmt_list TRBRACE {}
| TFADNP TLPAREN TIDENTIFIER TCOMMA TIDENTIFIER TRPAREN TLBRACE stmt_list TRBRACE {}
;

expr : TIDENTIFIER {}
| TIDENTIFIER TDOT TIDENTIFIER {}
| TIDENTIFIER indices {}
| TIDENTIFIER TDOT TIDENTIFIER indices {}
| TINTEGER {}
| expr TCEQ expr {}
| expr TCNE expr {}
| expr TCLT expr {}
| expr TCLE expr {}
| expr TCGT expr {}
| expr TCGE expr {}
| expr TPLUS expr {}
| expr TMINUS expr {}
| expr TMUL expr {}
| expr TDIV expr {}
| expr TLAND expr {}
| expr TLOR expr {}
| TLNOT expr {}
| TIDENTIFIER TLPAREN arg_list TRPAREN {} 
| TLPAREN expr TRPAREN {}
;

indices : TLBRACKET expr TRBRACKET {}
| indices TLBRACKET expr TRBRACKET {}
;

arg_list : {}
| expr {}
| arg_list TCOMMA expr {}
;

prog_def : TPROGRAM TEQUAL node_instances TSEMICOLON {}
;

node_instances : TIDENTIFIER TLPAREN TINTEGER TRPAREN {}
| node_instances TLOR TIDENTIFIER TLPAREN TINTEGER TRPAREN {}
;

init_def : TINIT TLBRACE stmt_list TRBRACE {}
;

safety_def : TSAFETY TLBRACE stmt_list TRBRACE {}
;
%%
