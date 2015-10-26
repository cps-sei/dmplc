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

%code top {
#include <cstdio>
#include <list>
#include <map>
#include <string>
#include <memory>
#include <boost/foreach.hpp>
#include "dmpl/Program.h"
#include "dmpl/Type.h"
#include "dmpl/Variable.h"
#include "dmpl/Expression.h"
#include "dmpl/Statement.h"
#include "dmpl/Function.h"
#include "dmpl/Node.h"
#include "dmpl/Specification.hpp"
#include "dmpl/Record.hpp"
#include "DmplBuilder.hpp"
#include <math.h>
#

extern dmpl::DmplBuilder *builder; /* the DMPL program builder */

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
}

%code {
void apply_fn_decors(dmpl::Func func, std::list<int> decors)
{
  BOOST_FOREACH(int decor, decors)
  {
    switch(decor)
    {
    case TEXTERN:
      func->isExtern = true;
      break;
    case TPURE:
      func->isPure = true;
      break;
    default:
      printf("ERROR: unknown function decorator token #%i\n", decor);
    };
  }
}
}

/* expect 1 shift reduce conflict */
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
    dmpl::Spec *spec;
    dmpl::Role *role;
    dmpl::Record *record;
    std::string *string;
    std::list<std::string> *strList;
    int token;
    std::list<int> *tokenList;
}

/* Define our terminal symbols (tokens). This should match our
   dmpl-scanner.ll lex file. We also define the node type they
   represent.  */
%token <string> TIDENTIFIER TINTEGER TDOUBLE TATTRIBUTE
%token <string> TIF TREQUIRE TEXPECT TATEND TATLEAST
%token <token> TSEMICOLON TCONST TNODE TROLE TINPUT
%token <token> TGLOBAL TLOCAL TALIAS TTARGET TTHUNK TID
%token <token> TBOOL TINT TDOUBLE_TYPE TVOID TCHAR TSIGNED TUNSIGNED
%token <token> TNODENUM TEXTERN TTHREAD TPURE TOVERRIDE TRECORD
%token <token> TELSE TFOR TWHILE
%token <token> TBREAK TCONTINUE TRETURN TEXO TEXH TEXL
%token <token> TFAN TFADNP TFAO TFAOL TFAOH
%token <token> TCEQ TCNE TCLT TCLE TCGT TCGE TEQUAL
%token <token> TLAND TLOR TLNOT TQUEST TCOLON
%token <token> TLPAREN TRPAREN TLBRACE TRBRACE 
%token <token> TLBRACKET TRBRACKET TCOMMA TDCOLON TAT
%token <token> TPLUS TMINUS TMUL TDIV TMOD TIMPLIES
%token <token> TBWNOT TBWAND TBWOR TBWXOR TBWLSH TBWRSH

/* Define the type of node our nonterminal symbols represent.
   The types refer to the %union declaration above. Ex: when
   we call an ident (defined by union type ident) we are really
   calling an (NIdentifier*). It makes the compiler happy.
 */
%type <string> int_const double_const
%type <token> program constant
%type <role> role role_no_attr role_body
%type <node> node_body node_no_attr node
%type <varList> node_var_init node_var_init_list var_block
%type <record> record_block record
%type <function> procedure proc_no_attr fn_body fn_prototype_no_decors fn_prototype
%type <token> dimension
%type <tokenList> fn_decors
%type <strList> target_id_list
%type <type> simp_type type fn_type
%type <lvalExpr> lval
%type <expr> call_expr expr
%type <exprlist> indices arg_list for_test
%type <stmt> stmt cond_stmt cond_stmt_no_attr
%type <stmtList> stmt_list for_init for_update
%type <dims> dimensions
%type <spec> spec_no_attr specification
%type <var> var var_asgn
%type <varList> var_asgn_list var_init
%type <varList> param_list var_init_list
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
program : {}
| program program_element {}
;

program_element
  : target {}
  | constant {}
  | node {
    builder->program.addNode(*$1);
    delete $1;
  }
  | procedure {
    builder->program.addFunction(*$1);
    delete $1;
  }
;

target : TTARGET target_id_list TTHUNK {
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

constant : TCONST TIDENTIFIER TEQUAL int_const TSEMICOLON {
  if(builder->program.constDef.find(*$2) == builder->program.constDef.end())
    builder->program.constDef[*$2] = *$4;
  delete $2; delete $4;
}
| TCONST TIDENTIFIER TEQUAL double_const TSEMICOLON {
  if(builder->program.constDef.find(*$2) == builder->program.constDef.end())
    builder->program.constDef[*$2] = *$4;
  delete $2; delete $4;
}
;

int_const : TINTEGER { $$ = $1; }
| TPLUS TINTEGER { $$ = $2; }
| TMINUS TINTEGER { $$ = $2; *$$ = "-" + *$$; }
;

double_const : TDOUBLE { $$ = $1; }
| TPLUS TDOUBLE { $$ = $2; }
| TMINUS TDOUBLE { $$ = $2; *$$ = "-" + *$$; }
;

node : node_no_attr { $$ = $1; }
| attr_list node_no_attr {
  $$ = $2;
  (*$$)->attrs = *$1;
  delete $1;
}
;

node_no_attr : TNODE TIDENTIFIER TLBRACE node_body TRBRACE {
  (*$4)->name = *$2;
  (*$4)->args.push_back("id");
  $$ = $4;
  delete $2;
}
| TNODE TIDENTIFIER TSEMICOLON {
  $$ = new dmpl::Node(new dmpl::BaseNode(*$2, true));
  delete $2;
}
;

specification : spec_no_attr { $$ = $1; }
| attr_list spec_no_attr {
  $$ = $2;
  (*$$)->attrs = *$1;
  delete $1;
}
;

spec_no_attr : TEXPECT TIDENTIFIER TCOLON TATEND TIMPLIES TIDENTIFIER TSEMICOLON {
  $$ = new dmpl::Spec(new dmpl::AtEndSpec(*$2,*$6));
  delete $2; delete $6;
}
| TEXPECT TIDENTIFIER TCOLON TATLEAST double_const TIMPLIES TIDENTIFIER TSEMICOLON {
  $$ = new dmpl::Spec(new dmpl::AtLeastSpec(*$2,*$7,*$5));
  delete $2; delete $5; delete $7;
}
| TREQUIRE TIDENTIFIER TCOLON TIDENTIFIER TIMPLIES TIDENTIFIER TSEMICOLON {
  $$ = new dmpl::Spec(new dmpl::RequireSpec(*$2,*$4,*$6));
  delete $2; delete $4; delete $6;
}
;

node_body : {
  $$ = new dmpl::Node(new dmpl::BaseNode());
}
| node_body var_block {
  (*$1)->addVarBlock(*$2);
  $$ = $1;
  delete $2;
}
| node_body record_block {
  (*$1)->addRecord(*$2);
  $$ = $1;
  delete $2;
}
| node_body procedure {
  (*$1)->addFunction(*$2);
  $$ = $1;
  delete $2;
}
| node_body role {
  (*$2)->node = *$1;
  (*$1)->addRole(*$2);
  $$ = $1;
  delete $2;
}
| node_body specification {
  (*$1)->addSpecification(*$2);
  $$ = $1;
  delete $2;
}
;

role : role_no_attr { $$ = $1; }
| attr_list role_no_attr {
  $$ = $2;
  (*$$)->attrs = *$1;
  delete $1;
}
;

role_no_attr : TROLE TIDENTIFIER TLBRACE role_body TRBRACE {
  (*$4)->name = *$2;
  $$ = $4;
  delete $2;
}
| TROLE TIDENTIFIER TID TINTEGER TLBRACE role_body TRBRACE {
  (*$6)->name = *$2;
  $$ = $6;
  delete $2; delete $4;
}
;

role_body : {
  $$ = new dmpl::Role(new dmpl::BaseRole());
}
| role_body var_block {
  (*$1)->addVarBlock(*$2);
  $$ = $1;
  delete $2;
}
| role_body record_block {
  (*$1)->addRecord(*$2);
  $$ = $1;
  delete $2;
}
| role_body procedure {
  (*$1)->addFunction(*$2);
  $$ = $1;
  delete $2;
}
| role_body specification {
  (*$1)->addSpecification(*$2);
  $$ = $1;
  delete $2;
}
;

var_block : node_var_init TSEMICOLON { $$ = $1; }
| TOVERRIDE node_var_init TSEMICOLON {
  $$ = $2;
  for(dmpl::Var &v : *$$) v->isOverride = true;
}
;

record_block : record { $$ = $1; }
| TOVERRIDE record {
  $$ = $2;
  (*$$)->isOverride = true;
}
;

/** declaring and initializing local and global variables */
node_var_init : TGLOBAL var_init {
  BOOST_FOREACH(dmpl::Var &v, *$2) v->scope = dmpl::Variable::GLOBAL;
  $$ = $2;
}
| TLOCAL var_init {
  BOOST_FOREACH(dmpl::Var &v, *$2) v->scope = dmpl::Variable::LOCAL;
  $$ = $2;
}
;

/** record definition */
record : TRECORD TIDENTIFIER TLBRACE node_var_init_list TRBRACE {
  $$ = new dmpl::Record(new dmpl::RecordBase(*$2, *$4));
  BOOST_FOREACH(const dmpl::Var &v,*$4) v->record = *$2;
  delete $2; delete $4;
}
| TRECORD TIDENTIFIER TLBRACE node_var_init_list TRBRACE TEQUAL fn_body {
  $$ = new dmpl::Record(new dmpl::RecordBase(*$2, *$4, *$7, dmpl::Func()));
  BOOST_FOREACH(const dmpl::Var &v,*$4) v->record = *$2;
  delete $2; delete $4; delete $7;
}
| TRECORD TIDENTIFIER TLBRACE node_var_init_list TRBRACE TBWNOT fn_body {
  $$ = new dmpl::Record(new dmpl::RecordBase(*$2, *$4, dmpl::Func(), *$7));
  BOOST_FOREACH(const dmpl::Var &v,*$4) v->record = *$2;
  delete $2; delete $4; delete $7;
}
| TRECORD TIDENTIFIER TLBRACE node_var_init_list TRBRACE TEQUAL fn_body TBWNOT fn_body {
  $$ = new dmpl::Record(new dmpl::RecordBase(*$2, *$4, *$7, *$9));
  BOOST_FOREACH(const dmpl::Var &v,*$4) v->record = *$2;
  delete $2; delete $4; delete $7; delete $9;
}
;

/** list of variable initializations */
node_var_init_list : node_var_init TSEMICOLON { $$ = $1; }
| node_var_init_list node_var_init TSEMICOLON {
  $$ = $1;
  $$->insert($$->end(), $2->begin(), $2->end());
  delete $2;
}
;

/** declaring and initializing variables */
var_init : type var_asgn_list {
  $$ = new dmpl::VarList();
  BOOST_FOREACH(const dmpl::Var &v,*$2) {
    dmpl::Type t = std::make_shared<dmpl::BaseType>(**$1);
    t->dims = v->type->dims;
    dmpl::Var newVar = std::make_shared<dmpl::Var::element_type>(*v);
    newVar->type = t; //dmpl::Type(t);
    $$->push_back(newVar);
  }
  delete $1; delete $2;
}
;

/** list of assignments to variables */
var_asgn_list : var {
  $$ = new dmpl::VarList(); $$->push_back(*$1); delete $1;
}
| TINPUT var {
  (*$2)->isInput = true;
  $$ = new dmpl::VarList(); $$->push_back(*$2); delete $2;
}
| var_asgn {
  $$ = new dmpl::VarList(); $$->push_back(*$1); delete $1;
}
| var_asgn_list TCOMMA var { $$ = $1; $$->push_back(*$3); delete $3; }
| var_asgn_list TCOMMA TINPUT var {
  (*$4)->isInput = true;
  $$ = $1; $$->push_back(*$4); delete $4;
}
| var_asgn_list TCOMMA var_asgn { $$ = $1; $$->push_back(*$3); delete $3; }
;

/** variable assignment */
var_asgn : var TEQUAL expr {
  $$ = $1;
  dmpl::LvalExpr *lhs = new dmpl::LvalExpr((*$1)->name);
  dmpl::Stmt asgn(new dmpl::AsgnStmt(dmpl::Expr(lhs),*$3));
  (*$$)->initFunc = dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  (*$$)->initFunc->body.push_back(asgn);
  delete $3;
}
| var TEQUAL fn_body {
  $$ = $1;
  (*$$)->initFunc = *$3;
  delete $3;
}
| TINPUT var TBWNOT expr {
  $$ = $2;
  (*$$)->isInput = true;
  dmpl::Stmt ret(new dmpl::RetStmt(*$4));
  (*$$)->initFunc = dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  (*$$)->initFunc->body.push_back(ret);
  delete $4;
}
| TINPUT var TBWNOT fn_body {
  $$ = $2;
  (*$$)->isInput = true;
  (*$$)->initFunc = *$4;
  delete $4;
}
;

/** variable */
var : TIDENTIFIER { $$ = new dmpl::Var(std::make_shared<dmpl::Var::element_type>(*$1)); delete $1; }
| TIDENTIFIER dimensions {
  $$ = new dmpl::Var(std::make_shared<dmpl::Var::element_type>(*$1,*$2)); 
  delete $1; delete $2;
}

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

fn_type : type { $$ = $1; }
;

simp_type : TBOOL { $$ = new dmpl::Type(dmpl::boolType()); }
| TINT { $$ = new dmpl::Type(dmpl::intType()); }
| TDOUBLE_TYPE { $$ = new dmpl::Type(dmpl::doubleType()); }
| TVOID { $$ = new dmpl::Type(dmpl::voidType()); }
| TCHAR { $$ = new dmpl::Type(dmpl::charType()); }
;

procedure : proc_no_attr { $$ = $1; }
| TOVERRIDE proc_no_attr { $$ = $2; }
| attr_list proc_no_attr {
  $$ = $2;
  (*$$)->attrs = *$1;
  delete $1;
}
| attr_list TOVERRIDE proc_no_attr {
  $$ = $3;
  (*$$)->attrs = *$1;
  delete $1;
}
;

proc_no_attr : fn_prototype fn_body {
  $$ = $1;
  (*$$)->mergeWith(*$2, false);
  delete $2;
}
| fn_prototype TSEMICOLON {
  $$ = $1;
  (*$$)->isPrototype = true;
}
;

fn_body : TLBRACE var_init_list stmt_list TRBRACE {
  /** create and add function to the node */
  $$ = new dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  /** set scope of temporary variables */
  BOOST_FOREACH(dmpl::Var &v,*$2) v->scope = dmpl::Variable::TEMP;
  (*$$)->setTemps(*$2);
  (*$$)->body = *$3;
  delete $2; delete $3;
}
;

fn_decors : TPURE { $$ = new std::list<int>{$1}; }
| TEXTERN { $$ = new std::list<int>{$1}; }
| TEXTERN TPURE { $$ = new std::list<int>{$1,$2}; }
;

fn_prototype : fn_prototype_no_decors { $$ = $1; }
| fn_decors fn_prototype_no_decors {
  $$ = $2;
  apply_fn_decors(*$$, *$1);
  delete $1;
}
;

fn_prototype_no_decors : fn_type TIDENTIFIER TLPAREN param_list TRPAREN {
  $$ = new dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  (*$$)->retType = *$1;
  (*$$)->name = *$2;
  /** set scope of parameter variables */
  BOOST_FOREACH(dmpl::Var &v,*$4) v->scope = dmpl::Variable::PARAM;
  (*$$)->setParams(*$4);
  delete $1; delete $2; delete $4;
}
| TIDENTIFIER TLPAREN TRPAREN {
  $$ = new dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  (*$$)->name = *$1;
  delete $1;
}
| TTHREAD TIDENTIFIER {
  $$ = new dmpl::Func(std::make_shared<dmpl::Func::element_type>());
  (*$$)->name = *$2;
  (*$$)->retType = dmpl::Type(dmpl::threadType());
  delete $2;
}
;

attr_list : attr TSEMICOLON {
  $$ = new dmpl::Attributes();
  (*$$)[$1->name] = *$1;
  delete $1;
}
| attr TSEMICOLON attr_list {
  $$ = $3;
  (*$$)[$1->name] = *$1;
  delete $1;
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

attr_param_list : expr {
  $$ = new dmpl::ExprList(); $$->push_back(*$1);
  delete $1;
}
| arg_list TCOMMA expr {
  $$ = $1;
  $$->push_back(*$3);
  delete $3;
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

var_init_list : { $$ = new dmpl::VarList(); }
| var_init_list var_init TSEMICOLON {
  $$ = $1; $$->insert($$->end(),$2->begin(),$2->end());
  delete $2;
}
;

stmt_list : { $$ = new dmpl::StmtList(); }
| stmt_list stmt { $$ = $1; $$->push_back(*$2); delete $2; }
;

cond_stmt : cond_stmt_no_attr {
  $$ = $1;
}
| attr_list cond_stmt_no_attr {
  $$ = $2;
  (*$$)->attrs = *$1;
  delete $1;
}
;

cond_stmt_no_attr : TIF TLPAREN expr TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$3, *$5));
  delete $3; delete $5; printStmt(*$$);
}
| TIF TLPAREN expr TRPAREN stmt TELSE stmt {
  $$ = new dmpl::Stmt(new dmpl::CondStmt(*$3, *$5, *$7));
  delete $3; delete $5; delete $7; printStmt(*$$);
}
;

stmt : TLBRACE stmt_list TRBRACE { $$ = new dmpl::Stmt(new dmpl::BlockStmt(*$2)); delete $2; }
| lval TEQUAL expr TSEMICOLON { 
  $$ = new dmpl::Stmt(new dmpl::AsgnStmt(dmpl::Expr($1),*$3));
  delete $3;
}
| TWHILE TLPAREN expr TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::WhileStmt(*$3,*$5));
  delete $3; delete $5;
}
| TFOR TLPAREN for_init TSEMICOLON for_test TSEMICOLON for_update TRPAREN stmt {
  $$ = new dmpl::Stmt(new dmpl::ForStmt(*$3,*$5,*$7,*$9));
  delete $3; delete $5; delete $7; delete $9;
}
| cond_stmt {
  $$ = $1;
}
| TBREAK TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::BreakStmt()); }
| TCONTINUE TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::ContStmt()); }
| TRETURN expr TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::RetStmt(*$2)); delete $2; }
| TRETURN TSEMICOLON { $$ = new dmpl::Stmt(new dmpl::RetVoidStmt()); }
| call_expr TSEMICOLON {
  $$ = new dmpl::Stmt(new dmpl::CallStmt(*$1));
  delete $1;
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
| TID { 
  $$ = new dmpl::Expr(new dmpl::LvalExpr("id"));
  printExpr(*$$);
}
| TINTEGER { 
  $$ = new dmpl::Expr(new dmpl::IntExpr(*$1)); 
  delete $1; printExpr(*$$); 
}
| TDOUBLE {
  if (*$1 == "NAN") $$ = new dmpl::Expr(new dmpl::DoubleExpr(*$1)); 
  else $$ = new dmpl::Expr(new dmpl::DoubleExpr(*$1));
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
| call_expr { $$ = $1; }
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

call_expr : TIDENTIFIER TLPAREN arg_list TRPAREN { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1)),*$3));
  delete $1; delete $3; printExpr(*$$);
}
| TIDENTIFIER TDCOLON TIDENTIFIER TLPAREN arg_list TRPAREN { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1, *$3)),*$5));
  delete $1; delete $3; delete $5; printExpr(*$$);
}
| TIDENTIFIER TLPAREN arg_list TRPAREN TAT expr { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1, *$6)),*$3));
  delete $1; delete $3; delete $6; printExpr(*$$);
}
| TIDENTIFIER TDCOLON TIDENTIFIER TLPAREN arg_list TRPAREN TAT expr { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(dmpl::Expr(new dmpl::LvalExpr(*$1, *$3, *$8)),*$5));
  delete $1; delete $3; delete $5; delete $8; printExpr(*$$);
}
| TIDENTIFIER TLPAREN arg_list TRPAREN TATTRIBUTE { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(
    dmpl::Expr(new dmpl::LvalExpr(*$1, dmpl::Expr(new dmpl::LvalExpr($5->substr(1))))),*$3));
  delete $1; delete $3; delete $5; printExpr(*$$);
}
| TIDENTIFIER TDCOLON TIDENTIFIER TLPAREN arg_list TRPAREN TATTRIBUTE { 
  $$ = new dmpl::Expr(new dmpl::CallExpr(
    dmpl::Expr(new dmpl::LvalExpr(*$1, *$3, dmpl::Expr(new dmpl::LvalExpr($7->substr(1))))),*$5));
  delete $1; delete $3; delete $5; delete $7; printExpr(*$$);
}
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
