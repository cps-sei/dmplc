%{
#include <cstdio>
#include <map>
#include <string>
#include "Type.h"
#include "Expression.h"
#include "Statement.h"
#include "DaigBuilder.hpp"
extern daig::DaigBuilder *builder; /* the dag builder */
extern int yylex();
void yyerror(const char *s) { printf("ERROR: %s\n", s); }
#define printExpr(_x) if(builder->debug) printf("EXPR: %s\n",(_x)->toString().c_str())
#define MAKE_UN(_res,_o,_l) _res = new daig::Expr(new daig::CompExpr(_o,*_l)); delete _l; printExpr(*_res)
#define MAKE_BIN(_res,_o,_l,_r) _res = new daig::Expr(new daig::CompExpr(_o,*_l,*_r)); delete _l; delete _r; printExpr(*_res)
#define printStmt(_x) if(builder->debug) printf("STMT: %s\n",(_x)->toString().c_str())
%}

/* expect 2 shift reduce conflicts */
%expect 2

/* Represents the many different ways we can access our data */
%union {
    daig::Type *type;
    daig::LvalExpr *lvalExpr;
    daig::Expr *expr;
    daig::ExprList *exprlist;
    daig::Stmt *stmt;
    daig::StmtList *stmtList;
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
%type <type> simp_type type
%type <lvalExpr> lval
%type <expr> expr
%type <exprlist> indices arg_list for_test
%type <stmt> stmt
%type <stmtList> stmt_list for_init for_update

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

type : simp_type { $$ = $1; }
| TSIGNED simp_type { $$ = $2; (*$$)->setQual(TSIGNED); }
| TUNSIGNED simp_type { $$ = $2; (*$$)->setQual(TUNSIGNED); }
;

simp_type : TBOOL { $$ = new daig::Type(new daig::BaseType(TBOOL)); }
| TINT { $$ = new daig::Type(new daig::BaseType(TINT)); }
| TVOID { $$ = new daig::Type(new daig::BaseType(TVOID)); }
| TCHAR { $$ = new daig::Type(new daig::BaseType(TCHAR)); }
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

stmt_list : stmt { $$ = new daig::StmtList(); $$->push_back(*$1); delete $1; }
| stmt_list stmt { $$ = $1; $$->push_back(*$2); delete $2; }
;

stmt : TATOMIC stmt { $$ = new daig::Stmt(new daig::AtomicStmt(*$2)); delete $2; }
| TPRIVATE stmt { $$ = new daig::Stmt(new daig::PrivateStmt(*$2)); delete $2; }
| TLBRACE stmt_list TRBRACE { $$ = new daig::Stmt(new daig::BlockStmt(*$2)); delete $2; }
| lval TEQUAL expr TSEMICOLON { 
  $$ = new daig::Stmt(new daig::AsgnStmt(*$1,*$3));
  delete $1; delete $3;
}
| TIF TLPAREN expr TRPAREN stmt {
  $$ = new daig::Stmt(new daig::ITStmt(*$3,*$5));
  delete $3; delete $5; printStmt(*$$);
}
| TIF TLPAREN expr TRPAREN stmt TELSE stmt {
  $$ = new daig::Stmt(new daig::ITEStmt(*$3,*$5,*$7));
  delete $3; delete $5; delete $7; printStmt(*$$);
}
| TWHILE TLPAREN expr TRPAREN stmt {
  $$ = new daig::Stmt(new daig::WhileStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFOR TLPAREN for_init TSEMICOLON for_test TSEMICOLON for_update TRPAREN stmt {
  $$ = new daig::Stmt(new daig::ForStmt(*$3,*$5,*$7,*$9));
  delete $3; delete $5; delete $7; delete $9;
}
| TBREAK TSEMICOLON { $$ = new daig::Stmt(new daig::BreakStmt()); }
| TCONTINUE TSEMICOLON { $$ = new daig::Stmt(new daig::ContStmt()); }
| TRETURN expr TSEMICOLON { $$ = new daig::Stmt(new daig::RetStmt(*$2)); delete $2; }
| TRETURN TSEMICOLON { $$ = new daig::Stmt(new daig::RetVoidStmt()); }
| lval TLPAREN arg_list TRPAREN TSEMICOLON {
  $$ = new daig::Stmt(new daig::CallStmt(daig::Expr($1), *$3));
  delete $3;
}
| TFAN TLPAREN TIDENTIFIER TRPAREN stmt { 
  $$ = new daig::Stmt(new daig::FANStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFADNP TLPAREN TIDENTIFIER TCOMMA TIDENTIFIER TRPAREN stmt {
  $$ = new daig::Stmt(new daig::FADNPStmt(*$3,*$5,*$7));
  delete $3; delete $5; delete $7;
}
| TFAO TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new daig::Stmt(new daig::FAOStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFAOL TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new daig::Stmt(new daig::FAOLStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFAOH TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new daig::Stmt(new daig::FAOHStmt(*$3,*$5));
  delete $3; delete $5;
}
;

lval : TIDENTIFIER { 
  $$ = new daig::LvalExpr(*$1);
  delete $1; printExpr($$);
}
| TIDENTIFIER TDOT TIDENTIFIER {
  $$ = new daig::LvalExpr(*$1,*$3);
  delete $1; delete $3; printExpr($$);
}
| TIDENTIFIER indices {
  $$ = new daig::LvalExpr(*$1,*$2);
  delete $1; delete $2; printExpr($$);
}
| TIDENTIFIER TDOT TIDENTIFIER indices {
  $$ = new daig::LvalExpr(*$1,*$3,*$4);
  delete $1; delete $3; delete $4; printExpr($$);
}
;

for_init : {}
| lval TEQUAL expr {
  $$ = new daig::StmtList();
  $$->push_back(daig::Stmt(new daig::AsgnStmt(*$1,*$3)));
  delete $1; delete $3;
}
| for_init TCOMMA lval TEQUAL expr {
  $$ = $1;
  $$->push_back(daig::Stmt(new daig::AsgnStmt(*$3,*$5)));
  delete $3; delete $5;
}
;

for_test : { $$ = new daig::ExprList(); }
| expr { $$ = new daig::ExprList(); $$->push_back(*$1); delete $1; }
;

for_update : {  $$ = new daig::StmtList(); }
| lval TEQUAL expr {
  $$ = new daig::StmtList();
  $$->push_back(daig::Stmt(new daig::AsgnStmt(*$1,*$3)));
  delete $1; delete $3;
}
;

expr : lval { $$ = new daig::Expr($1); printExpr(*$$); }
| TINTEGER { 
  $$ = new daig::Expr(new daig::IntExpr(atoi($1->c_str()))); 
  delete $1; printExpr(*$$); 
}
| TMINUS expr { MAKE_UN($$,$1,$2); }
| TPLUS expr { MAKE_UN($$,$1,$2); }
| expr TCEQ expr { MAKE_BIN($$,$2,$1,$3); }
| expr TCNE expr { MAKE_BIN($$,$2,$1,$3); }
| expr TCLT expr { MAKE_BIN($$,$2,$1,$3); }
| expr TCLE expr { MAKE_BIN($$,$2,$1,$3); }
| expr TCGT expr { MAKE_BIN($$,$2,$1,$3); }
| expr TCGE expr { MAKE_BIN($$,$2,$1,$3); }
| expr TPLUS expr { MAKE_BIN($$,$2,$1,$3); }
| expr TMINUS expr { MAKE_BIN($$,$2,$1,$3); }
| expr TMUL expr { MAKE_BIN($$,$2,$1,$3); }
| expr TDIV expr { MAKE_BIN($$,$2,$1,$3); }
| expr TLAND expr { MAKE_BIN($$,$2,$1,$3); }
| expr TLOR expr { MAKE_BIN($$,$2,$1,$3); }
| TLNOT expr { MAKE_UN($$,$1,$2); }
| lval TLPAREN arg_list TRPAREN { 
  $$ = new daig::Expr(new daig::CallExpr(daig::Expr($1),*$3));
  delete $3; printExpr(*$$);
} 
| TLPAREN expr TRPAREN { $$ = $2; }
;

indices : TLBRACKET expr TRBRACKET {
  $$ = new daig::ExprList();
  $$->push_back(*$2);
}
| indices TLBRACKET expr TRBRACKET {
  $$ = $1;
  $$->push_back(*$3);
}
;

arg_list : { $$ = new daig::ExprList(); }
| expr { $$ = new daig::ExprList(); $$->push_back(*$1); }
| arg_list TCOMMA expr {
  $$ = $1;
  $$->push_back(*$3);
}
;

prog_def : TPROGRAM TEQUAL node_instances TSEMICOLON {}
;

node_instances : TIDENTIFIER TLPAREN TINTEGER TRPAREN {
  builder->program.processes.push_back(daig::Process(*$1,atoi($3->c_str())));
  delete $1; delete $3;
}
| node_instances TLOR TIDENTIFIER TLPAREN TINTEGER TRPAREN {
  builder->program.processes.push_back(daig::Process(*$3,atoi($5->c_str())));
  delete $3; delete $5;
}
;

init_def : TINIT TLBRACE stmt_list TRBRACE {}
;

safety_def : TSAFETY TLBRACE stmt_list TRBRACE {}
;
%%
