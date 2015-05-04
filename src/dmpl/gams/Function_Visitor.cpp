/**
 * Copyright (c) 2014 Carnegie Mellon University. All Rights Reserved.

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

 * DM-0001023
**/

#include "Function_Visitor.hpp"
#include <dmplc/dmpl-parser.hpp>
#include "boost/foreach.hpp"


dmpl::madara::Function_Visitor::Function_Visitor (
  const Func & function, const Node & node,
  DmplBuilder & builder, std::stringstream & buffer, bool do_vrep, bool do_analyzer)
  : function_ (function), statement_(Stmt()), node_ (node),
    builder_ (builder), buffer_ (buffer), do_vrep_(do_vrep), do_analyzer_(do_analyzer),
    indentation_ (2), assignment_ (0)
{

}

dmpl::madara::Function_Visitor::Function_Visitor (
  const Stmt & statement, const Node & node,
  DmplBuilder & builder, std::stringstream & buffer, bool do_vrep, bool do_analyzer)
  : function_ (Func()), statement_(statement), node_ (node),
    builder_ (builder), buffer_ (buffer), do_vrep_(do_vrep), do_analyzer_(do_analyzer),
    indentation_ (2), assignment_ (0)
{

}


bool
dmpl::madara::Function_Visitor::enterInt (IntExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitInt (IntExpr & expression)
{
  buffer_ << "Integer (";
  buffer_ << expression.data;
  buffer_ << ")";
}


bool
dmpl::madara::Function_Visitor::enterDouble (DoubleExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitDouble (DoubleExpr & expression)
{
  if (expression.is_special_data)
  {
    buffer_ << expression.special_data;
  }
  else
  {
    buffer_ << expression.data;
  }
}


bool
dmpl::madara::Function_Visitor::enterLval (LvalExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitLval (LvalExpr & expression)
{
  Sym symbol = expression.sym;
  Var var = boost::dynamic_pointer_cast<Variable>(symbol);
  if (symbol == NULL)
  {
    buffer_ << expression.var;
  }
  else if (var != NULL && id_map_.find (var) != id_map_.end ())
  {
    buffer_ << id_map_[var];
  }
  else
  {
    int indices = expression.indices.size();
    bool atNode = expression.node != NULL;
    bool isAnalyzerLocal = do_analyzer_ && var->getScope() == Variable::LOCAL;
    bool isGlobal = var->getScope() == Variable::GLOBAL;
    if(atNode || isGlobal || isAnalyzerLocal)
      indices++;
    buffer_ << symbol->getName();
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
        buffer_ << node_.idVar->getName();
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
#if 0
  else
  {
    // if this is substitution variable, do the substitution
    if (id_map_.find (expression.var) != id_map_.end ())
      buffer_ << id_map_[expression.var];

    // otherwise, we need to determine if this is a MADARA container or not
    else
    {
      /*if (function_ && function_->temps.count (expression.var) == 0 &&
          function_->params.count (expression.var) == 0 &&
          builder_.program.constDef.count (expression.var) == 0)
      {
        buffer_ << "*";
      }*/
      buffer_ << expression.var;
    }
  }
#endif
}


bool
dmpl::madara::Function_Visitor::enterComp (CompExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitComp (CompExpr & expression)
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


bool
dmpl::madara::Function_Visitor::enterCall (CallExpr & expression)
{
  return false;
}



void
dmpl::madara::Function_Visitor::exitCall (CallExpr & expression)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  LvalExpr &lval = expression.func->requireLval ();
  if(!do_analyzer_ && lval.node != NULL)
  {
    std::cerr << "Error: using @ operator on function calls not supported in this output mode" << std::endl;
    exit(1);
  }
  std::string func_name = lval.var;
  Sym sym = lval.sym;
  Func func = boost::dynamic_pointer_cast<Function>(sym);

  if (sym != NULL && func == NULL)
  {
    std::cerr << "Error: " << func_name << " is not a function" << std::endl;
    exit(1);
  }

  //if (do_vrep_ && func_name == "MOVE_TO") func_name = "VREP_MOVE_TO";

  //dmpl::Functions & externs = builder_.program.externalFuncs;

  //bool isExtern = (externs.find (func_name) != externs.end ());
  Funcs::const_iterator nodeFunc = node_.funcs.find (func_name);
  Funcs::const_iterator progFunc = builder_.program.funcs.find (func_name);
  bool isNodeFunc = nodeFunc != node_.funcs.end();
  bool isProgFunc = progFunc != builder_.program.funcs.end() && progFunc->second->isExtern == false;

  if (expression.ignore_return)
    buffer_ << "(void) ";

  buffer_ << "(";

  if(function_ && function_->isPure && func && !func->isPure)
  {
    std::cerr << "Error: cannot call non-PURE function \"" << func_name << "\" from PURE function \"" << function_->getName() << "\"" << std::endl;
    exit(1);
  }

  if (func != NULL && !func->isExtern)
  {
    if(lval.node != NULL)
    {
      std::cerr << "Error: @ operator on function calls only supported for EXTERN functions" << std::endl;
      exit(1);
    }
    if(inExpect() && !func->isPure)
    {
      std::cerr << "Error: calling non-PURE function \"" << func_name << "\" from expect clause" << std::endl;
      exit(1);
    }
    //const Func &func = (isNodeFunc ? nodeFunc->second : progFunc->second);
    /*if (assignment_)
    {
      // complete the assignment and redo it later;
      buffer_ << "0;\n";
    }*/

    if (isNodeFunc)
    {
      buffer_ << node_.name << "_";
    }

    buffer_ << func_name << " (\n";

    buffer_ << sub_spacer << "     ";

    BOOST_FOREACH (Expr & expr, expression.args)
    {
      buffer_ << "__chain_set(";
    }

    buffer_ << "__strip_const(engine::Function_Arguments(" << expression.args.size() << "))";
    /*if (data->args.size () > 0)
    {
      buffer_ << " (";
      buffer_ << data->args.size ();
      buffer_ << ")";
    }*/

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

    /*
    if (assignment_)
    {
      buffer_ << sub_spacer;

      LvalExpr * lhs  = dynamic_cast<LvalExpr*>(assignment_->lhs.get ());

      if (lhs)
      {
        if (lhs->indices.size () == 0)
        {
          bool is_private = false;
          if (privatize_ &&
              node_.globVars.find (lhs->var) != node_.globVars.end ())
          {
            is_private = true;
            buffer_ << spacer;
            buffer_ << "// treat global variable change as a local update\n";
            buffer_ << spacer;
            buffer_ << "engine::Knowledge_Update_Settings old_update_settings (\n";
            buffer_ << sub_spacer;
            buffer_ << lhs->var;
            buffer_ << ".set_settings (private_update));\n";
          }

          buffer_ << spacer;
          buffer_ << lhs->var;
          buffer_ << " = ";

        }
      }
    }
    else
    {
      buffer_ << sub_spacer;
    }
    */

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
              << ".\" + to_string(" << node_.idVar->getName() << ")), (";
      visit(expression.args.front());
      buffer_ << "))";
    }
    else if(do_analyzer_ && expression.args.size() == 0)
    {
      buffer_ << "EXTERN_" << func_name << "[";
      if(lval.node == NULL)
        buffer_ << node_.idVar->getName();
      else
        visit(lval.node);
      buffer_ << "]";
    }
    else
    {
      if (func_name == "ASSUME")
        buffer_ << "assert";
      else
      {
        if (inExpect())
        {
          if(!func)
          {
            std::cerr << "Error: cannot call undefined function from expect (unknown if PURE)" << std::endl;
            exit(1);
          }
          else if(!func->isPure)
          {
            std::cerr << "Error: calling non-PURE function \"" << func_name << "\" from expect clause" << std::endl;
            exit(1);
          }
        }
        if (function_->isPure)
        {
          if(!func)
          {
            std::cerr << "Error: cannot call undefined function from pure funtion " << function_->getName() << std::endl;
            exit(1);
          }
        }
        buffer_ << func_name;
      }

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


bool
dmpl::madara::Function_Visitor::enterEXO (EXOExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitEXO (EXOExpr & expression)
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


bool
dmpl::madara::Function_Visitor::enterEXH (EXHExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitEXH (EXHExpr & expression)
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


bool
dmpl::madara::Function_Visitor::enterEXL (EXLExpr & expression)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitEXL (EXLExpr & expression)
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


bool
dmpl::madara::Function_Visitor::enterPrivate (PrivateStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitPrivate (PrivateStmt & statement)
{
  throw std::runtime_error("PRIVATE not supported");
  /*
  std::string spacer (indentation_, ' ');

  buffer_ << "\n" << spacer << "// Enabling PRIVATE-only modifications\n\n";

  privatize_ = true;

  visit (statement.data);

  privatize_ = false;

  buffer_ << spacer << "// Disabling PRIVATE-only modifications\n\n";
  */
}


bool
dmpl::madara::Function_Visitor::enterBlock (BlockStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitBlock (BlockStmt & statement)
{
  std::string spacer (indentation_, ' ');

  //transform the body of safety
  BOOST_FOREACH (const Stmt & i, statement.data)
  {
    visit (i);
  }
}


bool
dmpl::madara::Function_Visitor::enterAsgn (AsgnStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitAsgn (AsgnStmt & statement)
{
  std::string spacer (indentation_, ' '), sub_spacer (indentation_ + 2, ' ');

  // keep track of assignment;
  assignment_ = &statement;

  boost::shared_ptr<LvalExpr> lhs  = boost::dynamic_pointer_cast<LvalExpr>(statement.lhs);
  
  if (lhs)
  {
    int indices = lhs->indices.size();
    bool isAnalyzerLocal = do_analyzer_ && lhs->sym && lhs->sym->getScope() == Variable::LOCAL;
    bool isGlobal = lhs->sym != NULL && (lhs->sym->getScope() == Variable::GLOBAL || isAnalyzerLocal);
    if(isGlobal)
      indices++;
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
    //buffer_ << "/* Assign " << lhs->toString() << "  atNode: " << lhs->node << "  " << lhs->node.get() << "  " << indices << " */";
    if (indices == 0)
    {
      /*
      bool is_private = false;
      if (privatize_ &&
          node_.globVars.find (lhs->var) != node_.globVars.end ())
      {
        is_private = true;
        buffer_ << spacer;
        buffer_ << "// treat global variable change as a local update\n";
        buffer_ << spacer;
        buffer_ << "engine::Knowledge_Update_Settings old_update_settings (\n";
        buffer_ << sub_spacer;
        buffer_ << lhs->var;
        buffer_ << ".set_settings (private_update));\n";
      }
      */

      buffer_ << spacer;
      buffer_ << lhs->var;
      buffer_ << " = ";
      visit (statement.rhs);

      buffer_ << ";\n";

      /*
      if (is_private)
      {
        buffer_ << spacer;
        buffer_ << "// revert global variable update settings\n";
        buffer_ << spacer;
        buffer_ << lhs->var;
        buffer_ << ".set_settings (old_update_settings);\n\n";
      }
      */
    }
    else
    {
      if (indices >= 1)
      {
        buffer_ << lhs->var;


        // iterate over each index
        if(isGlobal)
        {
          buffer_ << "[";
          buffer_ << node_.idVar->getName();
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

        /*
        if (privatize_)
          buffer_ << ", private_update";
        */
      }
    }
  }

  // assignment over
  assignment_ = 0;
}


bool
dmpl::madara::Function_Visitor::enterCond (CondStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitCond (CondStmt & statement)
{
  dmpl::Expr & expression = statement.cond;

  std::string spacer (indentation_, ' ');

  if(statement.kind == "if")
  {
    buffer_ << spacer << "if ";
    if(statement.name != "")
    {
      buffer_ << "/* " << statement.name << " */ ";
    }
    buffer_ << "(";

    visit (statement.cond);

    buffer_ << ")\n";

    indentation_ += 2;
    
    buffer_ << spacer << "{\n";
    
    if(statement.tbranch)
    {
      visit (statement.tbranch);
    }
    else
    {
      buffer_ << spacer << "  { /* Do Nothing */ }\n";
    }

    buffer_ << spacer << "}\n";

    if(statement.ebranch)
    {
      buffer_ << spacer << "else\n";
      buffer_ << spacer << "{\n";
      
      visit (statement.ebranch);

      buffer_ << spacer << "}\n";
    }
  }
  else
  {
    buffer_ << spacer << "/* Ommited " << statement.kind << " statement. */" << std::endl;
    std::cerr << "Warning: " << statement.kind << " not supported by this output mode; ignored." << std::endl;
  }

  indentation_ -= 2;
}

bool
dmpl::madara::Function_Visitor::enterFor (ForStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFor (ForStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "for ";
  if(statement.name != "")
  {
    buffer_ << "/* " << statement.name << " */ ";
  }
  buffer_ << "(";
  
  BOOST_FOREACH (const Stmt & init, statement.init)
  {
    visit (init);
  }

  //buffer_ << "; ";

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


bool
dmpl::madara::Function_Visitor::enterWhile (WhileStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitWhile (WhileStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "while ";
  if(statement.name != "")
  {
    buffer_ << "/* " << statement.name << " */ ";
  }
  buffer_ << "(";
  
  visit (statement.cond);
  
  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  visit (statement.body);

  buffer_ << spacer << "}\n";
  indentation_ -= 2;
}


bool
dmpl::madara::Function_Visitor::enterBreak (BreakStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitBreak (BreakStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "break;\n";
}


bool
dmpl::madara::Function_Visitor::enterCont (ContStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitCont (ContStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "continue;\n";
}


bool
dmpl::madara::Function_Visitor::enterRet (RetStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitRet (RetStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "// retType->type == " << function_->retType->type << std::endl;
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


bool
dmpl::madara::Function_Visitor::enterRetVoid (RetVoidStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitRetVoid (RetVoidStmt & statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "return Integer(0);\n";
}


bool
dmpl::madara::Function_Visitor::enterCall (CallStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitCall (CallStmt & statement)
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

    #if 0
    std::string func_name = data->func->toString ();

    //if (do_vrep_ && func_name == "MOVE_TO") func_name = "VREP_MOVE_TO";

    dmpl::Functions & externs = builder_.program.externalFuncs;

    bool isExtern = (externs.find (func_name) != externs.end ());
    bool isNodeFunc = (node_.funcs.find (func_name) != node_.funcs.end ());
    bool isProgFunc = (builder_.program.funcs.find (func_name) != builder_.program.funcs.end ());

    if (isNodeFunc || isProgFunc)
    {
      /*if (assignment_)
      {
        // complete the assignment and redo it later;
        buffer_ << "0;\n";
      }*/

      if (node_.funcs.find (func_name) != node_.funcs.end ())
      {
        buffer_ << node_.name << "_";
      }

      buffer_ << func_name << " (\n";

      buffer_ << sub_spacer << "     ";

      BOOST_FOREACH (Expr & expr, data->args)
      {
        buffer_ << "__chain_push_back(";
      }

      buffer_ << "__strip_const(engine::Function_Arguments())";
      /*if (data->args.size () > 0)
      {
        buffer_ << " (";
        buffer_ << data->args.size ();
        buffer_ << ")";
      }*/

      buffer_ << "\n";

      unsigned int i = 0;
      BOOST_FOREACH (Expr & expr, data->args)
      {
        buffer_ << sub_spacer << "       ";
        buffer_ << ", ";
        //buffer_ << "args [" << i << "] = ";

        visit (expr);

        buffer_ << ")\n";
        ++i;
      }

      /*
      if (assignment_)
      {
        buffer_ << sub_spacer;

        LvalExpr * lhs  = dynamic_cast<LvalExpr*>(assignment_->lhs.get ());
  
        if (lhs)
        {
          if (lhs->indices.size () == 0)
          {
            bool is_private = false;
            if (privatize_ &&
                node_.globVars.find (lhs->var) != node_.globVars.end ())
            {
              is_private = true;
              buffer_ << spacer;
              buffer_ << "// treat global variable change as a local update\n";
              buffer_ << spacer;
              buffer_ << "engine::Knowledge_Update_Settings old_update_settings (\n";
              buffer_ << sub_spacer;
              buffer_ << lhs->var;
              buffer_ << ".set_settings (private_update));\n";
            }

            buffer_ << spacer;
            buffer_ << lhs->var;
            buffer_ << " = ";

          }
        }
      }
      else
      {
        buffer_ << sub_spacer;
      }
      */

      buffer_ << sub_spacer << "    , vars);\n";
    }
    else
    {
      if (func_name == "ASSUME")
        buffer_ << "assert";
      else
        buffer_ << func_name;

      buffer_ << " (";
    
      bool started = false;
      BOOST_FOREACH (Expr & expr, data->args)
      {
        if (started)
          buffer_ << ", ";

        visit (expr);

        if (!started)
          started = true;
      }

      buffer_ << ");\n";
    }
    #endif
  }
}


bool
dmpl::madara::Function_Visitor::enterFAN (FANStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFAN (FANStmt & statement)
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

  if (function_ && function_->temps.find (statement.id) == function_->temps.end ())
  {
    i_added = true;
    function_->temps [statement.id] = Var (new Variable(statement.id));
  }
  
  visit (statement.data);

  if (function_ && i_added)
    function_->temps.erase (statement.id);

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}


bool
dmpl::madara::Function_Visitor::enterFADNP (FADNPStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFADNP (FADNPStmt & statement)
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

  if (function_ && function_->temps.find (statement.id1) == function_->temps.end ())
  {
    id1_added = true;
    function_->temps [statement.id1] = Var(new Variable (statement.id1));
  }
  
  if (function_ && function_->temps.find (statement.id2) == function_->temps.end ())
  {
    id2_added = true;
    function_->temps [statement.id2] = Var(new Variable (statement.id2));
  }
  
  visit (statement.data);

  if (function_ && id1_added)
    function_->temps.erase (statement.id1);
  
  if (function_ && id2_added)
    function_->temps.erase (statement.id2);
  
  buffer_ << spacer_2 << "}\n";
  
  buffer_ << spacer << "}\n\n";

  indentation_ -= 4;
}


bool
dmpl::madara::Function_Visitor::enterFAO (FAOStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFAO (FAOStmt & statement)
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

  if (function_ && function_->temps.find (statement.id) == function_->temps.end ())
  {
    i_added = true;
    function_->temps [statement.id] = Var(new Variable (statement.id));
  }
  
  buffer_ << spacer_2 << "if (" << statement.id << " == id)\n";
  buffer_ << spacer_3 << "continue;\n\n";
  
  visit (statement.data);

  if (function_ && i_added)
    function_->temps.erase (statement.id);

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}


bool
dmpl::madara::Function_Visitor::enterFAOL (FAOLStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFAOL (FAOLStmt & statement)
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

  if (function_ && function_->temps.find (statement.id) == function_->temps.end ())
  {
    i_added = true;
    function_->temps [statement.id] = Var(new Variable (statement.id));
  }
  
  visit (statement.data);

  if (function_ && i_added)
    function_->temps.erase (statement.id);

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}


bool
dmpl::madara::Function_Visitor::enterFAOH (FAOHStmt & statement)
{
  return false;
}


void
dmpl::madara::Function_Visitor::exitFAOH (FAOHStmt & statement)
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

  if (function_ && function_->temps.find (statement.id) == function_->temps.end ())
  {
    i_added = true;
    function_->temps [statement.id] = Var(new Variable (statement.id));
  }
  
  visit (statement.data);

  if (function_ && i_added)
    function_->temps.erase (statement.id);

  buffer_ << spacer << "}\n\n";
  indentation_ -= 2;
}
