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

#include "GAMSVisitor.hpp"
#include <dmplc/dmpl-parser.hpp>
#include "boost/foreach.hpp"

/*********************************************************************/
dmpl::madara::GAMSVisitor::GAMSVisitor (
  const Func & function, const Node & node, const Func & thread,
  DmplBuilder & builder, std::stringstream & buffer, bool do_vrep, bool do_analyzer)
  : function_ (function), node_ (node), thread_ (thread),
    builder_ (builder), buffer_ (buffer), do_vrep_(do_vrep), do_analyzer_(do_analyzer),
    indentation_ (2), assignment_ (0)
{

}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterInt (IntExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitInt (IntExpr & expression)
{
  buffer_ << "Integer (";
  buffer_ << expression.data;
  buffer_ << ")";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterDouble (DoubleExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitDouble (DoubleExpr & expression)
{
  buffer_ << expression.data;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterLval (LvalExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitLval (LvalExpr & expression)
{
  Sym symbol = expression.sym;
  Var var = std::dynamic_pointer_cast<Variable>(symbol);

  //-- no symbol, probably something external
  if (symbol == NULL)
  {
    buffer_ << expression.var;
  }
  //-- id variable
  else if (var != NULL && id_map_.find (var) != id_map_.end ())
  {
    buffer_ << id_map_[var];
  }
  //-- regular variable
  else
  {
    //-- sanity check. we must have a legal variable.
    if(var == NULL)
      throw std::runtime_error("ERROR: function " + function_->name + " in node " +
                               node_->name + " uses out-of-scope variable " +
                               symbol->getName() + "!!");
    
    int indices = expression.indices.size();
    bool atNode = expression.node != NULL;
    bool isLocal = var->getScope() == Variable::LOCAL;
    bool isAnalyzerLocal = do_analyzer_ && isLocal;
    bool isGlobal = var->getScope() == Variable::GLOBAL;
    if(atNode || isGlobal || isAnalyzerLocal)
      indices++;
    if(thread_ && (isGlobal || isLocal))
      buffer_ << "thread" << thread_->threadID << "_";
    buffer_ << symbol->getName();

    //-- array variable
    if (indices > 0)
    {
      // iterate over each index
      if(atNode)
      {
        buffer_ << "[";
        visit (expression.node);
        buffer_ << "]";
      }
      else if(isGlobal || isAnalyzerLocal)
      {
        buffer_ << "[";
        buffer_ << node_->idVar->getName();
        buffer_ << "]";
      }
      BOOST_FOREACH (Expr & expr, expression.indices)
      {
        buffer_ << "[";
        visit (expr);
        buffer_ << "]";
      }
    }
  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterComp (CompExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitComp (CompExpr & expression)
{
  //-- this is the only NULLARY expression
  if(expression.op == TNODENUM) {
    buffer_ << builder_.program.processes.size ();
    return;
  }

  //-- unary expression
  ExprList::iterator arg = expression.args.begin ();
  if(expression.args.size() == 1) {
    buffer_ << "(" << expression.opToString ();
    visit(*arg);
    buffer_ << ")";
    return;
  }

  //-- binary expression
  if(expression.args.size() == 2) {
    buffer_ << "(";
    visit(*arg);
    buffer_ << " " << expression.opToString () << " ";
    ++arg; visit(*arg);
    buffer_ << ")";
    return;
  }

  //-- trinary expression
  buffer_ << "(";
  visit(*arg);
  buffer_ << " ? ";
  ++arg; visit(*arg);
  buffer_ << " : ";
  ++arg; visit(*arg);
  buffer_ << ")";
  return;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterCall (CallExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitCall (CallExpr & expression)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  LvalExpr &lval = expression.func->requireLval ();
  if(!do_analyzer_ && lval.node != NULL)
  {
    std::cerr << "ERROR: using @ operator on function calls not supported in this output mode\n";
    exit(1);
  }
  std::string func_name = lval.var;
  Sym sym = lval.sym;
  Func func = std::dynamic_pointer_cast<Function>(sym);

  if (sym != NULL && func == NULL)
  {
    std::cerr << "Error: " << func_name << " is not a function" << std::endl;
    exit(1);
  }

  Funcs::const_iterator nodeFunc = node_->funcs.find (func_name);
  Funcs::const_iterator progFunc = builder_.program.funcs.find (func_name);
  bool isNodeFunc = nodeFunc != node_->funcs.end();
  bool isProgFunc = progFunc != builder_.program.funcs.end() && progFunc->second->isExtern == false;

  if (expression.ignore_return)
    buffer_ << "(void) ";

  buffer_ << "(";
  
  if (func != NULL && !func->isExtern)
  {
    if(lval.node != NULL)
    {
      std::cerr << "Error: @ operator on function calls only supported for EXTERN functions" << std::endl;
      exit(1);
    }

    if(thread_) buffer_ << "thread" << thread_->threadID << "_";
    else buffer_ << "base_";
    buffer_ << func_name << " (\n";

    buffer_ << sub_spacer << "     ";

    BOOST_FOREACH (Expr & expr, expression.args)
    {
      buffer_ << "__chain_set(";
    }

    buffer_ << "__strip_const(engine::FunctionArguments(" << expression.args.size() << "))";
    buffer_ << "\n";

    unsigned int i = 0;
    BOOST_FOREACH (Expr & expr, expression.args)
    {
      buffer_ << sub_spacer << "       ";
      buffer_ << ", ";
      buffer_ << i << ", knowledge_cast(";

      visit (expr);

      buffer_ << "))\n";
      ++i;
    }

    buffer_ << sub_spacer << "    , vars)";

    if(!expression.ignore_return && func->retType.get() != NULL)
    {
      switch(func->retType->type)
      {
        case TINT:
        case TCHAR:
          buffer_ << ".to_integer()";
          break;
        case TBOOL:
          buffer_ << ".to_integer() == 0 ? false : true";
          break;
        case TDOUBLE_TYPE:
          buffer_ << ".to_double()";
          break;
      }
    }
  }
  else
  {
    if(func_name == "INTEGRATE" && expression.args.size() == 1)
    {
      static int integrate_id = 0;
      buffer_ << "integrate_knowledge((\".INTEGRAL." << integrate_id++
              << ".\" + to_string(" << node_->idVar->getName() << ")), (";
      visit(expression.args.front());
      buffer_ << "))";
    }
    else if(do_analyzer_ && expression.args.size() == 0)
    {
      buffer_ << "EXTERN_" << func_name << "[";
      if(lval.node == NULL)
        buffer_ << node_->idVar->getName();
      else
        visit(lval.node);
      buffer_ << "]";
    }
    else
    {
      if (func_name == "ASSUME")
        buffer_ << "assert";
      else
        buffer_ << func_name;
      
      buffer_ << " (";
    
      bool started = false;
      BOOST_FOREACH (Expr & expr, expression.args)
      {
        if (started)
          buffer_ << ", ";

        visit (expr);
        
        if (!started)
          started = true;
      }

      buffer_ << ")";
    }
  }
  buffer_ << ")";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterEXO (EXOExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitEXO (EXOExpr & expression)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  unsigned int processes = builder_.program.processes.size ();
  
  bool started_i = false;
  for (unsigned int i = 0; i < processes; ++i)
  {
    if (started_i)
    {
      buffer_ << " || \n" << sub_spacer;
    }

    buffer_ << "(";
    buffer_ << "id == " << i << " && (";

    bool started_j = false;
    for (unsigned int j = 0; j < processes; ++j)
    {
      // we want to check others for existence, not ourselves
      if (i == j)
        continue; 

      if (started_j)
        buffer_ << " || ";

      id_map_ [expression.idVar] = j;
      
      visit (expression.arg);

      id_map_.erase (expression.idVar);

      if (!started_j)
        started_j = true;
    }

    buffer_ << "))";

    if (!started_i)
      started_i = true;
  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterEXH (EXHExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitEXH (EXHExpr & expression)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  unsigned int processes = builder_.program.processes.size ();
  
  bool started_i = false;
  for (unsigned int i = 0; i + 1 < processes; ++i)
  {
    if (started_i)
    {
      buffer_ << " || \n" << sub_spacer;
    }

    buffer_ << "(";
    buffer_ << "id == " << i << " && (";

    bool started_j = false;
    for (unsigned int j = i + 1; j < processes; ++j)
    {
      if (started_j)
        buffer_ << " || ";

      id_map_ [expression.idVar] = j;
      
      visit (expression.arg);

      id_map_.erase (expression.idVar);

      if (!started_j)
        started_j = true;
    }

    buffer_ << "))";

    if (!started_i)
      started_i = true;
  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterEXL (EXLExpr & expression)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitEXL (EXLExpr & expression)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  unsigned int processes = builder_.program.processes.size ();
  
  bool started_i = false;
  for (unsigned int i = 1; i < processes; ++i)
  {
    if (started_i)
    {
      buffer_ << " || \n" << sub_spacer;
    }

    buffer_ << "(";
    buffer_ << "id == " << i << " && (";

    bool started_j = false;
    for (unsigned int j = 0; j < i; ++j)
    {
      if (started_j)
        buffer_ << " || ";

      id_map_ [expression.idVar] = j;
      
      visit (expression.arg);

      id_map_.erase (expression.idVar);

      if (!started_j)
        started_j = true;
    }

    buffer_ << "))";

    if (!started_i)
      started_i = true;
  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterPrivate (PrivateStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitPrivate (PrivateStmt & statement)
{
  throw std::runtime_error("PRIVATE not supported");
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterBlock (BlockStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitBlock (BlockStmt & statement)
{
  std::string spacer (indentation_, ' ');

  //transform the body of safety
  BOOST_FOREACH (const Stmt & i, statement.data)
  {
    visit (i);
  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterAsgn (AsgnStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitAsgn (AsgnStmt & statement)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  // keep track of assignment;
  assignment_ = &statement;

  std::shared_ptr<LvalExpr> lhs  = std::dynamic_pointer_cast<LvalExpr>(statement.lhs);
  
  if (lhs)
  {
    int indices = lhs->indices.size();
    bool isLocal = lhs->sym != NULL && (lhs->sym->getScope() == Variable::LOCAL);
    bool isAnalyzerLocal = do_analyzer_ && isLocal;
    bool isGlobal = lhs->sym != NULL && (lhs->sym->getScope() == Variable::GLOBAL || isAnalyzerLocal);

    if(isGlobal) indices++;
    
    if(lhs->node != NULL)
    {
      if(!isGlobal)
      {
        std::cerr << "Error: usage of @ operator with non-GLOBAL variable" << std::endl;
        exit(1);
      }
      else
      {
        std::cerr << "Error: assignment using @ operator not permitted" << std::endl;
        exit(1);
      }
    }

    //-- scalar variable
    if (indices == 0)
    {
      buffer_ << spacer;
      if(thread_ && (isGlobal || isLocal))
        buffer_ << "thread" << thread_->threadID << "_";
      buffer_ << lhs->var;
      buffer_ << " = ";
      visit (statement.rhs);
      buffer_ << ";\n";
    }
    //-- array variable
    else
    {
      if (indices >= 1)
      {
        buffer_ << spacer;
        if(thread_ && (isGlobal || isLocal))
          buffer_ << "thread" << thread_->threadID << "_";
        buffer_ << lhs->var;

        // iterate over each index
        if(isGlobal)
        {
          buffer_ << "[";
          buffer_ << node_->idVar->getName();
          buffer_ << "]";
        }
        BOOST_FOREACH (Expr & expr, lhs->indices)
        {
          buffer_ << "[";
          visit (expr);
          buffer_ << "]";
        }

        buffer_ << " = ";

        visit (statement.rhs);
        buffer_ << ";\n";
      }
    }
  }

  // assignment over
  assignment_ = 0;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterCond (CondStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitCond (CondStmt & statement)
{
  dmpl::Expr & expression = statement.cond;

  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "if (";
  visit (statement.cond);
  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  visit (statement.tbranch);
  buffer_ << spacer << "}\n";

  if(statement.ebranch) {
    buffer_ << spacer << "else\n";
    buffer_ << spacer << "{\n";  
    visit (statement.ebranch);
    buffer_ << spacer << "}\n";
  }

  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFor (ForStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFor (ForStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "for (";
  
  BOOST_FOREACH (const Stmt & init, statement.init)
  {
    visit (init);
  }

  BOOST_FOREACH (const Expr & expr, statement.test)
  {
    visit (expr);
  }
  
  buffer_ << "; ";
  
  BOOST_FOREACH (const Stmt & update, statement.update)
  {
    visit (update);
  }
  
  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  visit (statement.body);

  buffer_ << spacer << "}\n";
  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterWhile (WhileStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitWhile (WhileStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "while (";
  visit (statement.cond);  
  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  visit (statement.body);

  buffer_ << spacer << "}\n";
  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterBreak (BreakStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitBreak (BreakStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "break;\n";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterCont (ContStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitCont (ContStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "continue;\n";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterRet (RetStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitRet (RetStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "return (";
  
  switch(function_->retType->type)
  {
  case TDOUBLE_TYPE:
    buffer_ << "double(";
    break;
  default:
    buffer_ << "Integer(";
    break;
  }

  visit(statement.retVal);
  buffer_ << "));\n";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterRetVoid (RetVoidStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitRetVoid (RetVoidStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "return Integer(0);\n";
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterCall (CallStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitCall (CallStmt & statement)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  CallExpr * data  = dynamic_cast<CallExpr*> (statement.data.get ());
  
  if (data)
  {
    buffer_ << spacer << "{\n";      
    buffer_ << sub_spacer;
    
    data -> ignore_return = true;
    exitCall(*data);

    buffer_ << ";\n";
    buffer_ << spacer << "}\n";

  }
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFAN (FANStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFAN (FANStmt & statement)
{
  std::string spacer (indentation_, ' '), spacer_2 (indentation_ + 2, ' '),
    spacer_3 (indentation_ + 4, ' ');

  buffer_ << spacer;
  buffer_ << "// FORALL_NODES\n";
  buffer_ << spacer;
  buffer_ << "for (";
  buffer_ << "Integer ";
  buffer_ << statement.id;
  buffer_ << " = 0; ";
  buffer_ << statement.id;
  buffer_ << " < processes; ++";
  buffer_ << statement.id;
  buffer_ << ")\n";


  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  bool i_added = false;

  if (function_ && function_->tempSet.find (statement.id) == function_->tempSet.end ())
  {
    i_added = true;
    function_->tempSet [statement.id] = Var (new Variable(statement.id));
    function_->temps.push_back(function_->tempSet [statement.id]);
  }
  
  visit (statement.data);

  if (function_ && i_added) {
    function_->tempSet.erase (statement.id);
    function_->temps.pop_back();
  }
  
  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFADNP (FADNPStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFADNP (FADNPStmt & statement)
{
  std::string spacer (indentation_, ' '), spacer_2 (indentation_ + 2, ' '),
    spacer_3 (indentation_ + 4, ' '), spacer_4 (indentation_ + 6, ' ');

  buffer_ << spacer;
  buffer_ << "// FORALL_DISTINCT_NODE_PAIRS\n";
  buffer_ << spacer;
  buffer_ << "for (";
  buffer_ << "unsigned int ";
  buffer_ << statement.id1;
  buffer_ << " = 0; ";
  buffer_ << statement.id1;
  buffer_ << " < processes; ++";
  buffer_ << statement.id1;
  buffer_ << ")\n";
  
  buffer_ << spacer << "{\n";
  
  buffer_ << spacer_2;
  buffer_ << "for (";
  buffer_ << "unsigned int ";
  buffer_ << statement.id2;
  buffer_ << " = 0; ";
  buffer_ << statement.id2;
  buffer_ << " < processes; ++";
  buffer_ << statement.id2;
  buffer_ << ")\n";
  
  buffer_ << spacer_2 << "{\n";
  
  buffer_ << spacer_3 << "if (" << statement.id1;
  buffer_ << " == ";
  buffer_ << statement.id2;
  buffer_ << ")\n";
  
  buffer_ << spacer_4 << "continue;\n\n";

  indentation_ += 4;
  
  bool id1_added = false, id2_added = false;

  if (function_ && function_->tempSet.find (statement.id1) == function_->tempSet.end ())
  {
    id1_added = true;
    function_->tempSet [statement.id1] = Var(new Variable (statement.id1));
    function_->temps.push_back(function_->tempSet [statement.id1]);
  }
  
  if (function_ && function_->tempSet.find (statement.id2) == function_->tempSet.end ())
  {
    id2_added = true;
    function_->tempSet [statement.id2] = Var(new Variable (statement.id2));
    function_->temps.push_back(function_->tempSet [statement.id2]);
  }
  
  visit (statement.data);

  if (function_ && id2_added) {
    function_->tempSet.erase (statement.id2);
    function_->temps.pop_back();
  }
  
  if (function_ && id1_added) {
    function_->tempSet.erase (statement.id1);
    function_->temps.pop_back();
  }
  
  buffer_ << spacer_2 << "}\n";
  
  buffer_ << spacer << "}\n\n";

  indentation_ -= 4;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFAO (FAOStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFAO (FAOStmt & statement)
{
  std::string spacer (indentation_, ' '), spacer_2 (indentation_ + 2, ' '),
    spacer_3 (indentation_ + 4, ' ');
  
  buffer_ << spacer;
  buffer_ << "// FORALL_OTHER\n";
  buffer_ << spacer;
  buffer_ << "for (";
  buffer_ << "unsigned int ";
  buffer_ << statement.id;
  buffer_ << " = 0; ";
  buffer_ << statement.id;
  buffer_ << " < processes; ++";
  buffer_ << statement.id;
  buffer_ << ")\n";
  
  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  bool i_added = false;

  if (function_ && function_->tempSet.find (statement.id) == function_->tempSet.end ())
  {
    i_added = true;
    function_->tempSet [statement.id] = Var(new Variable (statement.id));
    function_->temps.push_back(function_->tempSet [statement.id]);
  }
  
  buffer_ << spacer_2 << "if (" << statement.id << " == id)\n";
  buffer_ << spacer_3 << "continue;\n\n";
  
  visit (statement.data);

  if (function_ && i_added) {
    function_->tempSet.erase (statement.id);
    function_->temps.pop_back();
  }

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFAOL (FAOLStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFAOL (FAOLStmt & statement)
{
  std::string spacer (indentation_, ' '), spacer_2 (indentation_ + 2, ' '),
    spacer_3 (indentation_ + 4, ' ');
  
  buffer_ << spacer;
  buffer_ << "// FORALL_OTHER_LOWER\n";
  buffer_ << spacer;
  buffer_ << "for (";
  buffer_ << "unsigned int ";
  buffer_ << statement.id;
  buffer_ << " = 0; ";
  buffer_ << statement.id;
  buffer_ << " < id; ++";
  buffer_ << statement.id;
  buffer_ << ")\n";
  
  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  bool i_added = false;

  if (function_ && function_->tempSet.find (statement.id) == function_->tempSet.end ())
  {
    i_added = true;
    function_->tempSet [statement.id] = Var(new Variable (statement.id));
    function_->temps.push_back(function_->tempSet [statement.id]);
  }

  visit (statement.data);

  if (function_ && i_added) {
    function_->tempSet.erase (statement.id);
    function_->temps.pop_back();
  }

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}

/*********************************************************************/
bool
dmpl::madara::GAMSVisitor::enterFAOH (FAOHStmt & statement)
{
  return false;
}

/*********************************************************************/
void
dmpl::madara::GAMSVisitor::exitFAOH (FAOHStmt & statement)
{
  std::string spacer (indentation_, ' '), spacer_2 (indentation_ + 2, ' '),
    spacer_3 (indentation_ + 4, ' ');
  
  buffer_ << spacer;
  buffer_ << "// FORALL_OTHER_HIGHER\n";
  buffer_ << spacer;
  buffer_ << "for (";
  buffer_ << "unsigned int ";
  buffer_ << statement.id;
  buffer_ << " = id + 1; ";
  buffer_ << statement.id;
  buffer_ << " < processes; ++";
  buffer_ << statement.id;
  buffer_ << ")\n";
  
  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  bool i_added = false;

  if (function_ && function_->tempSet.find (statement.id) == function_->tempSet.end ())
  {
    i_added = true;
    function_->tempSet [statement.id] = Var(new Variable (statement.id));
    function_->temps.push_back(function_->tempSet [statement.id]);
  }
  
  visit (statement.data);

  if (function_ && i_added) {
    function_->tempSet.erase (statement.id);
    function_->temps.pop_back();
  }

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}

/*********************************************************************/
//-- end of file
/*********************************************************************/
