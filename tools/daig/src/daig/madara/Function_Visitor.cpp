#include "Function_Visitor.hpp"

daig::madara::Function_Visitor::Function_Visitor (
  DaigBuilder & builder, std::stringstream & buffer)
  : builder_ (builder), buffer_ (buffer)
{

}


bool
daig::madara::Function_Visitor::enterInt (IntExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitInt (IntExpr & expression)
{
}


bool
daig::madara::Function_Visitor::enterLval (LvalExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitLval (LvalExpr & expression)
{
  //buffer_ << expression.var;
}


bool
daig::madara::Function_Visitor::enterComp (CompExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitComp (CompExpr & expression)
{
  //buffer_ << " " << expression.opToString () << " ";
}


bool
daig::madara::Function_Visitor::enterCall (CallExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitCall (CallExpr & expression)
{
  //buffer_ << expression.toString ();
}


bool
daig::madara::Function_Visitor::enterEXO (EXOExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitEXO (EXOExpr & expression)
{
  //buffer_ << expression.toString ();
}


bool
daig::madara::Function_Visitor::enterEXH (EXHExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitEXH (EXHExpr & expression)
{
  //buffer_ << expression.toString ();
}


bool
daig::madara::Function_Visitor::enterEXL (EXLExpr & expression)
{
  return true;
}


void
daig::madara::Function_Visitor::exitEXL (EXLExpr & expression)
{
  //buffer_ << expression.toString ();
}



bool
daig::madara::Function_Visitor::enterAtomic (AtomicStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitAtomic (AtomicStmt &statement)
{
  buffer_ << statement.toString ();
}


bool
daig::madara::Function_Visitor::enterPrivate (PrivateStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitPrivate (PrivateStmt &statement)
{
  buffer_ << statement.toString ();
}


bool
daig::madara::Function_Visitor::enterBlock (BlockStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitBlock (BlockStmt &statement)
{
  buffer_ << statement.toString ();
}


bool
daig::madara::Function_Visitor::enterAsgn (AsgnStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitAsgn (AsgnStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterIT (ITStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitIT (ITStmt &statement)
{
  buffer_ << statement.toString ();
}


bool
daig::madara::Function_Visitor::enterITE (ITEStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitITE (ITEStmt &statement)
{
  buffer_ << statement.toString ();
}


bool
daig::madara::Function_Visitor::enterFor (ForStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFor (ForStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterWhile (WhileStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitWhile (WhileStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterBreak (BreakStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitBreak (BreakStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterCont (ContStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitCont (ContStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterRet (RetStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitRet (RetStmt &statement)
{
  buffer_ << "return result;\n";
}


bool
daig::madara::Function_Visitor::enterRetVoid (RetVoidStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitRetVoid (RetVoidStmt &statement)
{
  buffer_ << "return result;\n";
}


bool
daig::madara::Function_Visitor::enterCall (CallStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitCall (CallStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterFAN (FANStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFAN (FANStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterFADNP (FADNPStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFADNP (FADNPStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterFAO (FAOStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFAO (FAOStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterFAOL (FAOLStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFAOL (FAOLStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}


bool
daig::madara::Function_Visitor::enterFAOH (FAOHStmt &statement)
{
  return true;
}


void
daig::madara::Function_Visitor::exitFAOH (FAOHStmt &statement)
{
  buffer_ << statement.toString () << "\n";
}
