#include <iostream>
#include <boost/foreach.hpp>
#include "StmtVisitor.h"

/*********************************************************************/
//top level dispatch method
/*********************************************************************/
void daig::StmtVisitor::visit(const daig::Stmt &stmt)
{
  if(AtomicStmt *st = dynamic_cast<AtomicStmt*>(&*stmt)) {
    enterAtomic(*st);
    visit(st->data);
    exitAtomic(*st);
  } else if(PrivateStmt *st = dynamic_cast<PrivateStmt*>(&*stmt)) {
    enterPrivate(*st);
    visit(st->data);
    exitPrivate(*st);
  } else if(BlockStmt *st = dynamic_cast<BlockStmt*>(&*stmt)) {
    enterBlock(*st);
    BOOST_FOREACH(Stmt &s,st->args) visit(s);
    exitBlock(*st);
  } else if(AsgnStmt *st = dynamic_cast<AsgnStmt*>(&*stmt)) {
    enterAsgn(*st);
    exitAsgn(*st);
  } else if(ITStmt *st = dynamic_cast<ITStmt*>(&*stmt)) {
    enterIT(*st);
    visit(st->tbranch);
    exitIT(*st);
  } else if(ITEStmt *st = dynamic_cast<ITEStmt*>(&*stmt)) {
    enterITE(*st);
    visit(st->tbranch);
    visit(st->ebranch);
    exitITE(*st);
  } else if(ForStmt *st = dynamic_cast<ForStmt*>(&*stmt)) {
    enterFor(*st);
    BOOST_FOREACH(Stmt &s,st->init) visit(s);
    BOOST_FOREACH(Stmt &s,st->update) visit(s);
    visit(st->body);
    exitFor(*st);
  } else if(WhileStmt *st = dynamic_cast<WhileStmt*>(&*stmt)) {
    enterWhile(*st);
    visit(st->body);
    exitWhile(*st);
  } else if(BreakStmt *st = dynamic_cast<BreakStmt*>(&*stmt)) {
    enterBreak(*st);
    exitBreak(*st);
  } else if(ContStmt *st = dynamic_cast<ContStmt*>(&*stmt)) {
    enterCont(*st);
    exitCont(*st);
  } else if(RetStmt *st = dynamic_cast<RetStmt*>(&*stmt)) {
    enterRet(*st);
    exitRet(*st);
  } else if(RetVoidStmt *st = dynamic_cast<RetVoidStmt*>(&*stmt)) {
    enterRetVoid(*st);
    exitRetVoid(*st);
  } else if(CallStmt *st = dynamic_cast<CallStmt*>(&*stmt)) {
    enterCall(*st);
    exitCall(*st);
  } else if(FANStmt *st = dynamic_cast<FANStmt*>(&*stmt)) {
    enterFAN(*st);
    visit(st->data);
    exitFAN(*st);
  } else if(FADNPStmt *st = dynamic_cast<FADNPStmt*>(&*stmt)) {
    enterFADNP(*st);
    visit(st->data);
    exitFADNP(*st);
  } else if(FAOStmt *st = dynamic_cast<FAOStmt*>(&*stmt)) {
    enterFAO(*st);
    visit(st->data);
    exitFAO(*st);
  } else if(FAOLStmt *st = dynamic_cast<FAOLStmt*>(&*stmt)) {
    enterFAOL(*st);
    visit(st->data);
    exitFAOL(*st);
  } else if(FAOHStmt *st = dynamic_cast<FAOHStmt*>(&*stmt)) {
    enterFAOH(*st);
    visit(st->data);
    exitFAOH(*st);
  } else assert(0 && "ERROR : visiting unknown statement!");
}

/*********************************************************************/
//end of file
/*********************************************************************/
