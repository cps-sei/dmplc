%{
    #include <cstdio>
    #include <map>
    #include <string>
    #include "DaigBuilder.hpp"
    extern daig::DaigBuilder *builder; /* the dag builder */
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
%token <token> TGLOBAL TLOCAL TBOOL TINT TVOID TCHAR TSIGNED TUNSIGNED
%token <token> TNODENUM TATOMIC TPRIVATE
%token <token> TIF TELSE TFOR TWHILE
%token <token> TBREAK TCONTINUE TRETURN TPROGRAM TINIT TSAFETY
%token <token> TFAN TFADNP TFAO TFAOL TFAOH
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
  TMOCSYNC TSEMICOLON { builder->program.moc.set_type("SYNC"); }
| TMOCASYNC TSEMICOLON { builder->program.moc.set_type("ASYNC"); }
| TMOCPSYNC TSEMICOLON { builder->program.moc.set_type("PARTIAL"); }
;

const_list : {}
| constant {}
| const_list constant {}
;

constant : TCONST TLPAREN TIDENTIFIER TCOMMA TINTEGER TRPAREN TSEMICOLON {
  builder->constDef[*$3] = *$5;
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

public_var : TGLOBAL TLPAREN var_decl TRPAREN TSEMICOLON {}
;

private_var : TLOCAL TLPAREN var_decl TRPAREN TSEMICOLON {}
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

type : base_type {}
| TSIGNED base_type {}
| TUNSIGNED base_type {}
;

base_type : TBOOL {}
| TINT {}
| TVOID {}
| TCHAR {}
;

procedure : type TIDENTIFIER TLPAREN param_list TRPAREN TLBRACE var_decl_list stmt_list TRBRACE {}
;

param_list : {}
| type TIDENTIFIER {}
| param_list TCOMMA type TIDENTIFIER {}
;

var_decl_list : {}
| var_decl_list var_decl TSEMICOLON {}
;

stmt_list : stmt {}
| stmt_list stmt {}
;

stmt : TATOMIC stmt {}
| TPRIVATE stmt {}
| TLBRACE stmt_list TRBRACE {}
| lval TEQUAL expr TSEMICOLON {}
| TIF TLPAREN expr TRPAREN stmt {}
| TIF TLPAREN expr TRPAREN stmt TELSE stmt {}
| TWHILE TLPAREN expr TRPAREN stmt {}
| TFOR TLPAREN for_init TSEMICOLON for_test TSEMICOLON for_update TRPAREN stmt {}
| TBREAK TSEMICOLON {}
| TCONTINUE TSEMICOLON {}
| TRETURN expr TSEMICOLON {}
| TRETURN TSEMICOLON {}
| TIDENTIFIER TLPAREN arg_list TRPAREN TSEMICOLON {}
| TFAN TLPAREN TIDENTIFIER TRPAREN stmt {}
| TFADNP TLPAREN TIDENTIFIER TCOMMA TIDENTIFIER TRPAREN stmt {}
| TFAO TLPAREN TIDENTIFIER TRPAREN stmt {}
| TFAOL TLPAREN TIDENTIFIER TRPAREN stmt {}
| TFAOH TLPAREN TIDENTIFIER TRPAREN stmt {}
| TFOR
;

lval : TIDENTIFIER {}
| TIDENTIFIER TDOT TIDENTIFIER {}
| TIDENTIFIER indices {}
| TIDENTIFIER TDOT TIDENTIFIER indices {}
;

for_init : {}
| lval TEQUAL expr {}
| for_init TCOMMA TIDENTIFIER TEQUAL expr {}
;

for_test : {}
| expr {}
;

for_update : {}
| lval TEQUAL expr {}
;

expr : lval {}
| TINTEGER {}
| TMINUS TINTEGER {}
| TPLUS TINTEGER {}
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
