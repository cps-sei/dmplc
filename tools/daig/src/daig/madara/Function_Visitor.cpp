#include "Function_Visitor.hpp"
#include "boost/foreach.hpp"


daig::madara::Function_Visitor::Function_Visitor (
  Function & function, Node & node, 
  DaigBuilder & builder, std::stringstream & buffer)
  : function_ (function), node_ (node), 
    builder_ (builder), buffer_ (buffer), indentation_ (2)
{

}


bool
daig::madara::Function_Visitor::enterInt (IntExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitInt (IntExpr & expression)
{
  buffer_ << expression.data;
}


bool
daig::madara::Function_Visitor::enterLval (LvalExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitLval (LvalExpr & expression)
{
  if (expression.indices.size () > 0)
  {
    buffer_ << expression.var;

    if (expression.indices.size () > 1)
      buffer_ << "(";
    else
      buffer_ << "[";

    bool started = false;
    BOOST_FOREACH (Expr & expr, expression.indices)
    {
      if (started)
        buffer_ << ", ";

      visit (expr);
    }

    if (expression.indices.size () > 1)
      buffer_ << ")";
    else
      buffer_ << "]";


    if (function_.temps.find (expression.var) == function_.temps.end ())
    {
      buffer_ << ".to_integer ()";
    }
  }
  else
  {
    if (function_.temps.find (expression.var) == function_.temps.end ())
    {
      buffer_ << "*";
    }
    buffer_ << expression.var;
  }
}


bool
daig::madara::Function_Visitor::enterComp (CompExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitComp (CompExpr & expression)
{
  ExprList::iterator arg = expression.args.begin ();

  if (expression.args.size () == 2)
    visit (*arg);

  buffer_ << " " << expression.opToString () << " ";

  ++arg;

  visit (*arg);
}


bool
daig::madara::Function_Visitor::enterCall (CallExpr & expression)
{
  return false;
}



void
daig::madara::Function_Visitor::exitCall (CallExpr & expression)
{
  buffer_ << expression.func->toString ();
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


bool
daig::madara::Function_Visitor::enterEXO (EXOExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitEXO (EXOExpr & expression)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling exists other block.\n";
}


bool
daig::madara::Function_Visitor::enterEXH (EXHExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitEXH (EXHExpr & expression)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling exists higher block.\n";
}


bool
daig::madara::Function_Visitor::enterEXL (EXLExpr & expression)
{
  return false;
}


void
daig::madara::Function_Visitor::exitEXL (EXLExpr & expression)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling exists lower block.\n";
}



bool
daig::madara::Function_Visitor::enterAtomic (AtomicStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitAtomic (AtomicStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling atomic block.\n";
}


bool
daig::madara::Function_Visitor::enterPrivate (PrivateStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitPrivate (PrivateStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling private.\n";
}


bool
daig::madara::Function_Visitor::enterBlock (BlockStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitBlock (BlockStmt &statement)
{
  std::string spacer (indentation_, ' ');

  //transform the body of safety
  BOOST_FOREACH (const Stmt & i, statement.data)
  {
    visit (i);
  }
}


bool
daig::madara::Function_Visitor::enterAsgn (AsgnStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitAsgn (AsgnStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer;

  LvalExpr *lhs  = dynamic_cast<LvalExpr*>(statement.lhs.get ());
  
  if (lhs)
  {
    if (lhs->indices.size () == 0)
    {
      buffer_ << lhs->var;
      buffer_ << " = ";
      visit (statement.rhs);

      buffer_ << ";\n";
    }
    else if (lhs->indices.size () == 1)
    {
      
      buffer_ << lhs->var;
      buffer_ << ".set (";
      visit (*(lhs->indices.begin ()));
      buffer_ << ", ";
      visit (statement.rhs);
      buffer_ << ");\n";
    }
    else
    {
      buffer_ << "{\n";

      std::string sub_spacer (indentation_ + 2, ' ');

      buffer_ << sub_spacer;
      buffer_ << "containers::Array_N::Index index (" << lhs->indices.size ();
      buffer_ << ");\n";
      


      int i = 0;
      BOOST_FOREACH (Expr & expression, lhs->indices)
      {
        buffer_ << sub_spacer << "index[";
        buffer_ << i;
        buffer_ << "] = ";
        visit (expression);
        buffer_ << ";\n";
        ++i;
      }
      
      buffer_ << sub_spacer << lhs->var;
      buffer_ << ".set (index, ";
      visit (statement.rhs);
      buffer_ << ");\n";
      buffer_ << spacer << "}\n";
    }
  }
}


bool
daig::madara::Function_Visitor::enterIT (ITStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitIT (ITStmt &statement)
{
  daig::Expr & expression = statement.cond;

  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "if (";

  visit (statement.cond);

  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  visit (statement.tbranch);

  buffer_ << spacer << "}\n";
  indentation_ -= 2;
}


bool
daig::madara::Function_Visitor::enterITE (ITEStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitITE (ITEStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "if (";

  visit (statement.cond);

  buffer_ << ")\n";

  indentation_ += 2;
  
  buffer_ << spacer << "{\n";
  
  visit (statement.tbranch);

  buffer_ << spacer << "}\n";

  buffer_ << spacer << "else\n";
  buffer_ << spacer << "{\n";
  
  visit (statement.ebranch);

  buffer_ << spacer << "}\n";

  indentation_ -= 2;
}


bool
daig::madara::Function_Visitor::enterFor (ForStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFor (ForStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for statement block.\n";
}


bool
daig::madara::Function_Visitor::enterWhile (WhileStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitWhile (WhileStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling while statement block.\n";
}


bool
daig::madara::Function_Visitor::enterBreak (BreakStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitBreak (BreakStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling break statement.\n";
}


bool
daig::madara::Function_Visitor::enterCont (ContStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitCont (ContStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling continue statement.\n";
}


bool
daig::madara::Function_Visitor::enterRet (RetStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitRet (RetStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling return statement.\n";
}


bool
daig::madara::Function_Visitor::enterRetVoid (RetVoidStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitRetVoid (RetVoidStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "return result;\n";
}


bool
daig::madara::Function_Visitor::enterCall (CallStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitCall (CallStmt &statement)
{
  std::string spacer (indentation_, ' ');

  CallExpr * data  = dynamic_cast<CallExpr*>(statement.data.get ());
  
  if (data)
  {
    buffer_ << spacer << data->func->toString ();
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
}


bool
daig::madara::Function_Visitor::enterFAN (FANStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFAN (FANStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for all node statement.\n";
}


bool
daig::madara::Function_Visitor::enterFADNP (FADNPStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFADNP (FADNPStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for all node statement.\n";
}


bool
daig::madara::Function_Visitor::enterFAO (FAOStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFAO (FAOStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for all other node statement.\n";
}


bool
daig::madara::Function_Visitor::enterFAOL (FAOLStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFAOL (FAOLStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for all other lower node statement.\n";
}


bool
daig::madara::Function_Visitor::enterFAOH (FAOHStmt &statement)
{
  return false;
}


void
daig::madara::Function_Visitor::exitFAOH (FAOHStmt &statement)
{
  std::string spacer (indentation_, ' ');

  buffer_ << spacer << "Handling for all other higher node statement.\n";
}
