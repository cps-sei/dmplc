%{
#include <cstdio>
#include <list>
#include <map>
#include <string>
#include <boost/make_shared.hpp>
#include <boost/foreach.hpp>
#include "dmpl/Program.h"
#include "dmpl/Type.h"
#include "dmpl/Variable.h"
#include "dmpl/Expression.h"
#include "dmpl/Statement.h"
#include "dmpl/Function.h"
#include "dmpl/Node.h"
#include "DmplBuilder.hpp"
#include <math.h>
#

extern dmpl::DmplBuilder *builder; /* the dag builder */

extern int yylex();
void yyerror(const char *s) {
  printf("ERROR: %s. Rerun with --debug for more details\n", s);
  exit(1);
}

/** the current node being parsed */
/*dmpl::Node currNode;*/

/** a thunk */
std::string thunk;

#define printExpr(_x) if(builder->debug) printf("EXPR: %s\n",(_x)->toString().c_str())
#define MAKE_NULL(_res,_o) _res = new dmpl::Expr(new dmpl::CompExpr(_o)); printExpr(*_res)
#define MAKE_UN(_res,_o,_l) _res = new dmpl::Expr(new dmpl::CompExpr(_o,*_l)); delete _l; printExpr(*_res)
#define MAKE_BIN(_res,_o,_l,_r) _res = new dmpl::Expr(new dmpl::CompExpr(_o,*_l,*_r)); delete _l; delete _r; printExpr(*_res)
#define MAKE_TRI(_res,_o,_a,_b,_c) _res = new dmpl::Expr(new dmpl::CompExpr(_o,*_a,*_b,*_c)); delete _a; delete _b; delete _c; printExpr(*_res)
#define printStmt(_x) if(builder->debug) printf("STMT: %s\n",(_x)->toString().c_str())
%}

/* expect 3 shift reduce conflicts */
%expect 1

/* Represents the many different ways we can access our data */
%union {
    dmpl::Type *type;
    dmpl::Var *var;
    dmpl::VarList *varList;
    dmpl::LvalExpr *lvalExpr;
    dmpl::Expr *expr;
    dmpl::ExprList *exprlist;
    dmpl::Stmt *stmt;
    dmpl::StmtList *stmtList;
    dmpl::Attribute *attr;
    dmpl::Attributes *attrList;
    dmpl::Node *node;
    dmpl::Func *function;
    dmpl::Dims *dims;
    std::string *string;
    std::list<std::string> *strList;
    int token;
}

/* Define our terminal symbols (tokens). This should
   match our tokens.l lex file. We also define the node type
   they represent.
 */
%token <string> TIDENTIFIER TINTEGER TDOUBLE TATTRIBUTE
%token <string> TIF TREQUIRE TEXPECT
%token <token> TSEMICOLON TCONST TNODE
%token <token> TGLOBAL TLOCAL TALIAS TTARGET TTHUNK
%token <token> TBOOL TINT TDOUBLE_TYPE TVOID TCHAR TSIGNED TUNSIGNED
%token <token> TNODENUM TPRIVATE TEXTERN
%token <token> TELSE TFOR TWHILE
%token <token> TBREAK TCONTINUE TRETURN TEXO TEXH TEXL /*TPROGRAM*/
%token <token> /*TINIT TSAFETY*/ TFAN TFADNP TFAO TFAOL TFAOH
%token <token> TCEQ TCNE TCLT TCLE TCGT TCGE TEQUAL
%token <token> TLAND TLOR TLNOT TQUEST TCOLON
%token <token> TLPAREN TRPAREN TLBRACE TRBRACE 
%token <token> TLBRACKET TRBRACKET TCOMMA TDOT TAT
%token <token> TPLUS TMINUS TMUL TDIV TMOD
%token <token> TBWNOT TBWAND TBWOR TBWXOR TBWLSH TBWRSH
/*%token <token> TON_PRE_TIMEOUT TON_POST_TIMEOUT TON_RECV_FILTER
%token <token> TTRACK_LOCATIONS TSEND_HEARTBEATS
%token <token> TNODE_INIT TONCE_EVERY*/

/* Define the type of node our nonterminal symbols represent.
   The types refer to the %union declaration above. Ex: when
   we call an ident (defined by union type ident) we are really
   calling an (NIdentifier*). It makes the compiler happy.
 */
%type <token> program constant node
%type <string> cond_kind stmt_name
%type <node> node_body
%type <varList> node_var
%type <function> procedure
%type <varList> global_var local_var
%type <token> dimension
%type <strList> target_id_list
%type <type> simp_type type
%type <lvalExpr> lval
%type <expr> expr
%type <exprlist> indices arg_list for_test
%type <stmt> stmt cond_stmt
%type <stmtList> stmt_list for_init for_update
%type <dims> dimensions
%type <var> var
%type <varList> var_list var_decl param_list var_decl_list
%type <attr> attr
%type <attrList> attr_list
%type <exprlist> attr_param_list

/* Operator precedence for ternary operators */
%left TQUEST TCOLON
/* Operator precedence for logical operators */
%left TLOR
%left TLAND
/* Operator precedence for bitwise operators */
%left TBWOR
%left TBWXOR
%left TBWAND
/* Operator precedence for comparison operators */
%left TCEQ TCNE
%left TCLT TCLE TCGT TCGE
/* Operator precedence for mathematical operators */
%left TBWLSH TBWRSH
%left TPLUS TMINUS
%left TMUL TDIV TMOD
/* precedence for logical not */
%right TLNOT TBWNOT
%left TAT

%start program

%%
program :
  program_element {}
| program program_element {}
;

program_element
  : target {}
  | constant {}
  | extern_fn_decl {}
  | node {}
  | procedure {
    builder->program.addFunction(*$1);
    delete $1;
  }
;

target :
  TTARGET target_id_list TTHUNK {
  BOOST_FOREACH(const std::string &t,*$2) builder->program.addTarget(t,thunk);
  delete $2;
}
;

target_id_list : TIDENTIFIER {
  $$ = new std::list<std::string>();
  $$->push_back(*$1); delete $1;
}
| target_id_list TCOMMA TIDENTIFIER {
  $$ = $1;
  $$->push_back(*$3); delete $3;
}
;

extern_fn_decl : TEXTERN type TIDENTIFIER TLPAREN param_list TRPAREN TSEMICOLON {
  dmpl::Func func = boost::make_shared<dmpl::Func::element_type>(*$2,*$3,*$5,dmpl::VarList(),dmpl::StmtList());
  func->isExtern = true;
  builder->program.addFunction(func);
  delete $2; delete $3; delete $5;
}
| attr_list TEXTERN type TIDENTIFIER TLPAREN param_list TRPAREN TSEMICOLON {
  dmpl::Func func = boost::make_shared<dmpl::Func::element_type>(*$3,*$4,*$6,dmpl::VarList(),dmpl::StmtList());
  func->isExtern = true;
  func->attrs = *$1;
  builder->program.addFunction(func);
  delete $1; delete $3; delete $4; delete $6;
}
;

constant : TCONST TIDENTIFIER TEQUAL TINTEGER TSEMICOLON {
  if(builder->program.constDef.find(*$2) == builder->program.constDef.end())
    builder->program.constDef[*$2] = *$4;
  delete $2; delete $4;
}
/** this is needed to handle constant definitions that have also been
supplied via the command line */
| TCONST TINTEGER TEQUAL TINTEGER TSEMICOLON {
  assert(0 && "ERROR: should not get here now that constants are not replaced by the lexer!!");
  delete $2; delete $4;
}
| TCONST TIDENTIFIER TEQUAL TDOUBLE TSEMICOLON {
  if(builder->program.constDef.find(*$2) == builder->program.constDef.end())
    builder->program.constDef[*$2] = *$4;
  delete $2; delete $4;
}
;

node : TNODE TIDENTIFIER TLPAREN TIDENTIFIER TRPAREN TLBRACE node_body TRBRACE {
  $7->name = *$2;
  $7->args.push_back(*$4);
  builder->program.addNode(*$7);
  delete $2; delete $4; delete $7;
}
| attr_list TNODE TIDENTIFIER TLPAREN TIDENTIFIER TRPAREN TLBRACE node_body TRBRACE {
  $8->name = *$3;
  $8->args.push_back(*$5);
  $8->attrs = *$1;
  builder->program.addNode(*$8);
  delete $1; delete $3; delete $5; delete $8;
}
| TNODE TIDENTIFIER TLBRACE node_body TRBRACE {
  $4->name = *$2;
  $4->abstract = true;
  builder->program.addNode(*$4);
  delete $2; delete $4;
}
| attr_list TNODE TIDENTIFIER TLBRACE node_body TRBRACE {
  $5->name = *$3;
  $5->attrs = *$1;
  $5->abstract = true;
  builder->program.addNode(*$5);
  delete $1; delete $3; delete $5;
}
| TNODE TIDENTIFIER TSEMICOLON {
  builder->program.addNode(dmpl::Node(*$2, true));
}
| attr_list TNODE TIDENTIFIER TSEMICOLON {
  builder->program.addNode(dmpl::Node(*$3, *$1, true));
}
;

node_body:
  node_var {
    $$ = new dmpl::Node();
    $$->addVar(*$1);
    delete $1;
}
| node_body node_var {
    $1->addVar(*$2);
    delete $2;
}
| procedure {
    $$ = new dmpl::Node();
    $$->addFunction(*$1);
    delete $1;
}
| node_body procedure {
    $1->addFunction(*$2);
    delete $2;
}
| cond_stmt {
    $$ = new dmpl::Node();
    $$->addStatement(*$1);
    delete $1;
}
| node_body cond_stmt {
    $1->addStatement(*$2);
    delete $2;
}
;

node_var : global_var{
  $$ = $1;
}
| local_var {
  $$ = $1;
}

global_var : TGLOBAL var_decl TSEMICOLON {
  BOOST_FOREACH(dmpl::Var &v, *$2)
  {
    v->scope = dmpl::Variable::GLOBAL;
  }
  $$ = $2;
}
;

local_var : TLOCAL var_decl TSEMICOLON {
  BOOST_FOREACH(dmpl::Var &v, *$2)
  {
    v->scope = dmpl::Variable::LOCAL;
  }
  $$ = $2;
}
;

var_decl : type var_list {
  $$ = new dmpl::VarList();
  BOOST_FOREACH(const dmpl::Var &v,*$2) {
    dmpl::Type t = boost::make_shared<dmpl::BaseType>(**$1);
    t->dims = v->type->dims;
    dmpl::Var newVar = boost::make_shared<dmpl::Var::element_type>(*v);
    newVar->type = t;//dmpl::Type(t);
    $$->push_back(newVar);
  }
  delete $1; delete $2;
};

var_list : var {
  $$ = new dmpl::VarList(); $$->push_back(*$1); delete $1;
}
| var_list TCOMMA var { $$ = $1; $$->push_back(*$3); delete $3; }
;

var : TIDENTIFIER { $$ = new dmpl::Var(boost::make_shared<dmpl::Var::element_type>(*$1)); delete $1; }
| TIDENTIFIER dimensions {
  $$ = new dmpl::Var(boost::make_shared<dmpl::Var::element_type>(*$1,*$2)); 
  delete $1; delete $2;
}
;

dimensions : TLBRACKET dimension TRBRACKET {
  $$ = new dmpl::Dims(); $$->push_back($2);
}
| dimensions TLBRACKET dimension TRBRACKET { $$ = $1; $$->push_back($3); }
;

/* NODENUM is indicated by dimension -1 */
dimension : TINTEGER { $$ = atoi($1->c_str()); delete $1; }
| TNODENUM { $$ = -1; }
| TIDENTIFIER {
  std::map<std::string,std::string>::const_iterator it = 
    builder->program.constDef.find(*$1);
  $$ = atoi(it->second.c_str());
  delete $1;
}
;

type : simp_type { $$ = $1; }
| TSIGNED simp_type { $$ = $2; (*$$)->setQual(TSIGNED); }
| TUNSIGNED simp_type { $$ = $2; (*$$)->setQual(TUNSIGNED); }
;

simp_type : TBOOL { $$ = new dmpl::Type(dmpl::boolType()); }
| TINT { $$ = new dmpl::Type(dmpl::intType()); }
| TDOUBLE_TYPE { $$ = new dmpl::Type(dmpl::doubleType()); }
| TVOID { $$ = new dmpl::Type(dmpl::voidType()); }
| TCHAR { $$ = new dmpl::Type(dmpl::charType()); }
;

procedure : type TIDENTIFIER TLPAREN param_list TRPAREN TLBRACE var_decl_list stmt_list TRBRACE {
  /** set scope of parameters and temporary variables */
  BOOST_FOREACH(dmpl::Var &v,*$4) v->scope = dmpl::Variable::PARAM;
  BOOST_FOREACH(dmpl::Var &v,*$7) v->scope = dmpl::Variable::TEMP;
  /** create and add function to the node */
  $$ = new dmpl::Func(boost::make_shared<dmpl::Func::element_type>(*$1,*$2,*$4,*$7,*$8));
  delete $1; delete $2; delete $4; delete $7; delete $8;       
}
| attr_list type TIDENTIFIER TLPAREN param_list TRPAREN TLBRACE var_decl_list stmt_list TRBRACE {
  /** set scope of parameters and temporary variables */
  BOOST_FOREACH(dmpl::Var &v,*$5) v->scope = dmpl::Variable::PARAM;
  BOOST_FOREACH(dmpl::Var &v,*$8) v->scope = dmpl::Variable::TEMP;
  /** create and add function to the node */
  $$ = new dmpl::Func(boost::make_shared<dmpl::Func::element_type>(*$2,*$3,*$5,*$8,*$9,*$1));
  delete $2; delete $3; delete $5; delete $8; delete $9; delete $1;
}
| TIDENTIFIER TLPAREN TRPAREN TSEMICOLON {
  $$ = new dmpl::Func(boost::make_shared<dmpl::Func::element_type>(*$1));
  delete $1;
}
| attr_list TIDENTIFIER TLPAREN TRPAREN TSEMICOLON {
  $$ = new dmpl::Func(boost::make_shared<dmpl::Func::element_type>(*$2, *$1));
  delete $1; delete $2;
}
;

attr_list : attr {
  $$ = new dmpl::Attributes();
  (*$$)[$1->name] = *$1;
}
| attr_list attr {
  $$ = $1;
  (*$$)[$2->name] = *$2;
}
;

attr : TATTRIBUTE {
  $$ = new dmpl::Attribute($1->substr(1));
}
| TATTRIBUTE TLPAREN attr_param_list TRPAREN {
  if($3 == 0)
    $$ = new dmpl::Attribute($1->substr(1));
  else
  {
    $$ = new dmpl::Attribute($1->substr(1), *$3);
    delete $3;
  }
}
;

attr_param_list : { $$ = new dmpl::ExprList(); }
| expr { $$ = new dmpl::ExprList(); $$->push_back(*$1); }
| arg_list TCOMMA expr {
  $$ = $1;
  $$->push_back(*$3);
}
;

param_list : { $$ = new dmpl::VarList(); }
| type var {
  $$ = new dmpl::VarList();
  dmpl::BaseType *t = new dmpl::BaseType(**$1);
  t->dims = (*$2)->type->dims;
  dmpl::Var newVar(*$2);
  newVar->type = dmpl::Type(t);
  $$->push_back(newVar);
  delete $1; delete $2;
}
| param_list TCOMMA type var {
  $$ = $1;
  dmpl::BaseType *t = new dmpl::BaseType(**$3);
  t->dims = (*$4)->type->dims;
  dmpl::Var newVar(*$4);
  newVar->type = dmpl::Type(t);
  $$->push_back(newVar);
  delete $3; delete $4;
}
;

var_decl_list : { $$ = new dmpl::VarList(); }
| var_decl_list var_decl TSEMICOLON {
  $$ = $1; $$->insert($$->end(),$2->begin(),$2->end());
  delete $2;
}
;

stmt_list : stmt { $$ = new dmpl::StmtList(); $$->push_back(*$1); delete $1; }
| stmt_list stmt { $$ = $1; $$->push_back(*$2); delete $2; }
;

cond_kind : TIF {} | TREQUIRE {} | TEXPECT {} ;

cond_stmt : cond_kind stmt_name TLPAREN expr TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$2, *$1, *$4, *$6));
  delete $1; delete $2; delete $4; delete $6; printStmt(*$$);
}
| cond_kind stmt_name TLPAREN expr TRPAREN TSEMICOLON {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$2, *$1, *$4));
  delete $1; delete $2; delete $4; printStmt(*$$);
}
| cond_kind stmt_name TLPAREN expr TRPAREN TELSE stmt {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$2, *$1, *$4, NULL, *$7));
  delete $1; delete $2; delete $4; delete $7; printStmt(*$$);
}
| cond_kind stmt_name TLPAREN expr TRPAREN stmt TELSE stmt {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$2, *$1, *$4, *$6, *$8));
  delete $1; delete $2; delete $4; delete $6; delete $8; printStmt(*$$);
}
;

stmt_name : { $$ = new std::string(); }
| TIDENTIFIER {
  $$ = $1;
}
;

stmt : TPRIVATE stmt { $$ = new dmpl::Stmt(new dmpl::PrivateStmt(*$2)); delete $2; }
| TLBRACE stmt_list TRBRACE { $$ = new dmpl::Stmt(new dmpl::BlockStmt(*$2)); delete $2; }
| lval TEQUAL expr TSEMICOLON { 
  $$ = new dmpl::Stmt(new dmpl::AsgnStmt(dmpl::Expr($1),*$3));
  delete $3;
}
| TWHILE stmt_name TLPAREN expr TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::WhileStmt(*$2, *$4,*$6));
  delete $2; delete $4; delete $6;
}
| TFOR stmt_name TLPAREN for_init TSEMICOLON for_test TSEMICOLON for_update TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::ForStmt(*$2, *$4,*$6,*$8,*$10));
  delete $2; delete $4; delete $6; delete $8; delete $10;
}
| cond_stmt {
  $$ = $1;
}
| TBREAK TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::BreakStmt()); }
| TCONTINUE TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::ContStmt()); }
| TRETURN expr TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::RetStmt(*$2)); delete $2; }
| TRETURN TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::RetVoidStmt()); }
| TIDENTIFIER TLPAREN arg_list TRPAREN TSEMICOLON {
  $$ = new dmpl::Stmt(new dmpl::CallStmt(dmpl::Expr(new dmpl::LvalExpr(*$1)), *$3));
  delete $3;
  //$$ = new dmpl::Stmt(new dmpl::CallExpr(dmpl::Expr($1),*$3));
  //delete $3; printExpr(*$$);
}
| TFAN TLPAREN TIDENTIFIER TRPAREN stmt { 
  $$ = new dmpl::Stmt(new dmpl::FANStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFADNP TLPAREN TIDENTIFIER TCOMMA TIDENTIFIER TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::FADNPStmt(*$3,*$5,*$7));
  delete $3; delete $5; delete $7;
}
| TFAO TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::FAOStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFAOL TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::FAOLStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFAOH TLPAREN TIDENTIFIER TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::FAOHStmt(*$3,*$5));
  delete $3; delete $5;
}
;

lval : TIDENTIFIER { 
  $$ = new dmpl::LvalExpr(*$1);
  delete $1; printExpr($$);
}
| TIDENTIFIER TAT expr {
  $$ = new dmpl::LvalExpr(*$1,*$3);
  delete $1; delete $3; printExpr($$);
}
| TIDENTIFIER TATTRIBUTE {
  $$ = new dmpl::LvalExpr(*$1,dmpl::Expr(new dmpl::LvalExpr($2->substr(1))));
  delete $1; delete $2; printExpr($$);
}
| TIDENTIFIER indices {
  $$ = new dmpl::LvalExpr(*$1,*$2);
  delete $1; delete $2; printExpr($$);
}
| TIDENTIFIER indices TAT expr {
  $$ = new dmpl::LvalExpr(*$1,*$4,*$2);
  delete $1; delete $2; delete $4; printExpr($$);
}
| TIDENTIFIER indices TATTRIBUTE {
  $$ = new dmpl::LvalExpr(*$1,dmpl::Expr(new dmpl::LvalExpr($3->substr(1))), *$2);
  delete $1; delete $2; delete $3; printExpr($$);
}
;

for_init : {}
| lval TEQUAL expr {
  $$ = new dmpl::StmtList();
  $$->push_back(dmpl::Stmt(new dmpl::AsgnStmt(dmpl::Expr($1),*$3)));
  delete $3;
}
| for_init TCOMMA lval TEQUAL expr {
  $$ = $1;
  $$->push_back(dmpl::Stmt(new dmpl::AsgnStmt(dmpl::Expr($3),*$5)));
  delete $5;
}
;

for_test : { $$ = new dmpl::ExprList(); }
| expr { $$ = new dmpl::ExprList(); $$->push_back(*$1); delete $1; }
;

for_update : {  $$ = new dmpl::StmtList(); }
| lval TEQUAL expr {
  $$ = new dmpl::StmtList();
  $$->push_back(dmpl::Stmt(new dmpl::AsgnStmt(dmpl::Expr($1),*$3)));
  delete $3;
}
;

expr : lval { $$ = new dmpl::Expr($1); printExpr(*$$); }
| TINTEGER { 
  $$ = new dmpl::Expr(new dmpl::IntExpr(atoi($1->c_str()))); 
  delete $1; printExpr(*$$); 
}
| TDOUBLE {
  if (*$1 == "NAN") $$ = new dmpl::Expr(new dmpl::DoubleExpr(*$1)); 
  else $$ = new dmpl::Expr(new dmpl::DoubleExpr(atof($1->c_str())));
  delete $1; printExpr(*$$);
}
| TNODENUM { MAKE_NULL($$,$1); }
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
| expr TMOD expr { MAKE_BIN($$,$2,$1,$3); }
| expr TLAND expr { MAKE_BIN($$,$2,$1,$3); }
| expr TLOR expr { MAKE_BIN($$,$2,$1,$3); }
| expr TBWAND expr { MAKE_BIN($$,$2,$1,$3); }
| expr TBWOR expr { MAKE_BIN($$,$2,$1,$3); }
| expr TBWXOR expr { MAKE_BIN($$,$2,$1,$3); }
| expr TBWLSH expr { MAKE_BIN($$,$2,$1,$3); }
| expr TBWRSH expr { MAKE_BIN($$,$2,$1,$3); }
| expr TQUEST expr TCOLON expr { MAKE_TRI($$,$2,$1,$3,$5); }
| TLNOT expr { MAKE_UN($$,$1,$2); }
| TBWNOT expr { MAKE_UN($$,$1,$2); }
| TIDENTIFIER TLPAREN arg_list TRPAREN { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1)),*$3));
  delete $1; delete $3; printExpr(*$$);
} 
| TIDENTIFIER TLPAREN arg_list TRPAREN TAT expr { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1, *$6)),*$3));
  delete $1; delete $3; delete $6; printExpr(*$$);
} 
| TIDENTIFIER TLPAREN arg_list TRPAREN TATTRIBUTE { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(
    dmpl::Expr(new dmpl::LvalExpr(*$1, dmpl::Expr(new dmpl::LvalExpr($5->substr(1))))),*$3));
  delete $1; delete $3; delete $5; printExpr(*$$);
} 
| TEXO TLPAREN TIDENTIFIER TCOMMA expr TRPAREN {
  $$ = new dmpl::Expr(new dmpl::EXOExpr(*$3,dmpl::Expr(*$5)));
  delete $3; delete $5;
}
| TEXH TLPAREN TIDENTIFIER TCOMMA expr TRPAREN {
  $$ = new dmpl::Expr(new dmpl::EXHExpr(*$3,dmpl::Expr(*$5)));
  delete $3; delete $5;
}
| TEXL TLPAREN TIDENTIFIER TCOMMA expr TRPAREN {
  $$ = new dmpl::Expr(new dmpl::EXLExpr(*$3,dmpl::Expr(*$5)));
  delete $3; delete $5;
}
| TLPAREN expr TRPAREN { $$ = $2; }
;

indices : TLBRACKET expr TRBRACKET {
  $$ = new dmpl::ExprList();
  $$->push_back(*$2);
}
| indices TLBRACKET expr TRBRACKET {
  $$ = $1;
  $$->push_back(*$3);
}
;

arg_list : { $$ = new dmpl::ExprList(); }
| expr { $$ = new dmpl::ExprList(); $$->push_back(*$1); }
| arg_list TCOMMA expr {
  $$ = $1;
  $$->push_back(*$3);
}
;
%%
