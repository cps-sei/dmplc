#include <iostream>
#include <boost/foreach.hpp>
#include "StmtVisitor.h"

/*********************************************************************/
//top level dispatch method
/*********************************************************************/
void daig::StmtVisitor::visit(const daig::Stmt &stmt)
{
  if(AtomicStmt *st = dynamic_cast<AtomicStmt*>(&*stmt)) {
    host = stmt; enterAtomic(*st);
    visit(st->data);
    host = stmt; exitAtomic(*st);
  } else if(PrivateStmt *st = dynamic_cast<PrivateStmt*>(&*stmt)) {
    host = stmt; enterPrivate(*st);
    visit(st->data);
    host = stmt; exitPrivate(*st);
  } else if(BlockStmt *st = dynamic_cast<BlockStmt*>(&*stmt)) {
    host = stmt; enterBlock(*st);
    BOOST_FOREACH(Stmt &s,st->args) visit(s);
    host = stmt; exitBlock(*st);
  } else if(AsgnStmt *st = dynamic_cast<AsgnStmt*>(&*stmt)) {
    host = stmt; enterAsgn(*st);
    host = stmt; exitAsgn(*st);
  } else if(ITStmt *st = dynamic_cast<ITStmt*>(&*stmt)) {
    host = stmt; enterIT(*st);
    visit(st->tbranch);
    host = stmt; exitIT(*st);
  } else if(ITEStmt *st = dynamic_cast<ITEStmt*>(&*stmt)) {
    host = stmt; enterITE(*st);
    visit(st->tbranch);
    visit(st->ebranch);
    host = stmt; exitITE(*st);
  } else if(ForStmt *st = dynamic_cast<ForStmt*>(&*stmt)) {
    host = stmt; enterFor(*st);
    BOOST_FOREACH(Stmt &s,st->init) visit(s);
    BOOST_FOREACH(Stmt &s,st->update) visit(s);
    visit(st->body);
    host = stmt; exitFor(*st);
  } else if(WhileStmt *st = dynamic_cast<WhileStmt*>(&*stmt)) {
    host = stmt; enterWhile(*st);
    visit(st->body);
    host = stmt; exitWhile(*st);
  } else if(BreakStmt *st = dynamic_cast<BreakStmt*>(&*stmt)) {
    host = stmt; enterBreak(*st);
    host = stmt; exitBreak(*st);
  } else if(ContStmt *st = dynamic_cast<ContStmt*>(&*stmt)) {
    host = stmt; enterCont(*st);
    host = stmt; exitCont(*st);
  } else if(RetStmt *st = dynamic_cast<RetStmt*>(&*stmt)) {
    host = stmt; enterRet(*st);
    host = stmt; exitRet(*st);
  } else if(RetVoidStmt *st = dynamic_cast<RetVoidStmt*>(&*stmt)) {
    host = stmt; enterRetVoid(*st);
    host = stmt; exitRetVoid(*st);
  } else if(CallStmt *st = dynamic_cast<CallStmt*>(&*stmt)) {
    host = stmt; enterCall(*st);
    host = stmt; exitCall(*st);
  } else if(FANStmt *st = dynamic_cast<FANStmt*>(&*stmt)) {
    host = stmt; enterFAN(*st);
    visit(st->data);
    host = stmt; exitFAN(*st);
  } else if(FADNPStmt *st = dynamic_cast<FADNPStmt*>(&*stmt)) {
    host = stmt; enterFADNP(*st);
    visit(st->data);
    host = stmt; exitFADNP(*st);
  } else if(FAOStmt *st = dynamic_cast<FAOStmt*>(&*stmt)) {
    host = stmt; enterFAO(*st);
    visit(st->data);
    host = stmt; exitFAO(*st);
  } else if(FAOLStmt *st = dynamic_cast<FAOLStmt*>(&*stmt)) {
    host = stmt; enterFAOL(*st);
    visit(st->data);
    host = stmt; exitFAOL(*st);
  } else if(FAOHStmt *st = dynamic_cast<FAOHStmt*>(&*stmt)) {
    host = stmt; enterFAOH(*st);
    visit(st->data);
    host = stmt; exitFAOH(*st);
  } else assert(0 && "ERROR : visiting unknown statement!");
}

/*********************************************************************/
//end of file
/*********************************************************************/
