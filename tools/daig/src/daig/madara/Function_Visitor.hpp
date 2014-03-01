//a class for sequentializing DAIG into a C program

#ifndef __MADARA_FUNCTION_VISITOR_H__
#define __MADARA_FUNCTION_VISITOR_H__

#include <iostream>
#include <sstream>
#include "daslc/DaigBuilder.hpp"
#include "daig/Visitor.h"

namespace daig
{
  namespace madara
  {
    /*******************************************************************/
    // Visitor for function elements
    /*******************************************************************/
    class Function_Visitor : public Visitor
    {
    public:
      /**
       * Constructor
       * @param  builder   the source for building a program
       * @param  buffer    the buffer being used to create the program text
       **/
      Function_Visitor (DaigBuilder & builder, std::stringstream & buffer);

      virtual bool enterInt(IntExpr &expr);
      virtual void exitInt(IntExpr &expr);
      virtual bool enterLval(LvalExpr &expr);
      virtual void exitLval(LvalExpr &expr);
      virtual bool enterComp(CompExpr &expr);
      virtual void exitComp(CompExpr &expr);
      virtual bool enterCall(CallExpr &expr);
      virtual void exitCall(CallExpr &expr);
      virtual bool enterEXO(EXOExpr &expr);
      virtual void exitEXO(EXOExpr &expr);
      virtual bool enterEXH(EXHExpr &expr);
      virtual void exitEXH(EXHExpr &expr);
      virtual bool enterEXL(EXLExpr &expr);
      virtual void exitEXL(EXLExpr &expr);

      virtual bool enterAtomic(AtomicStmt &stmt);
      virtual void exitAtomic(AtomicStmt &stmt);
      virtual bool enterPrivate(PrivateStmt &stmt);
      virtual void exitPrivate(PrivateStmt &stmt);
      virtual bool enterBlock(BlockStmt &stmt);
      virtual void exitBlock(BlockStmt &stmt);
      virtual bool enterAsgn(AsgnStmt &stmt);
      virtual void exitAsgn(AsgnStmt &stmt);
      virtual bool enterIT(ITStmt &stmt);
      virtual void exitIT(ITStmt &stmt);
      virtual bool enterITE(ITEStmt &stmt);
      virtual void exitITE(ITEStmt &stmt);
      virtual bool enterFor(ForStmt &stmt);
      virtual void exitFor(ForStmt &stmt);
      virtual bool enterWhile(WhileStmt &stmt);
      virtual void exitWhile(WhileStmt &stmt);
      virtual bool enterBreak(BreakStmt &stmt);
      virtual void exitBreak(BreakStmt &stmt);
      virtual bool enterCont(ContStmt &stmt);
      virtual void exitCont(ContStmt &stmt);
      virtual bool enterRet(RetStmt &stmt);
      virtual void exitRet(RetStmt &stmt);
      virtual bool enterRetVoid(RetVoidStmt &stmt);
      virtual void exitRetVoid(RetVoidStmt &stmt);
      virtual bool enterCall(CallStmt &stmt);
      virtual void exitCall(CallStmt &stmt);
      virtual bool enterFAN(FANStmt &stmt);
      virtual void exitFAN(FANStmt &stmt);
      virtual bool enterFADNP(FADNPStmt &stmt);
      virtual void exitFADNP(FADNPStmt &stmt);
      virtual bool enterFAO(FAOStmt &stmt);
      virtual void exitFAO(FAOStmt &stmt);
      virtual bool enterFAOL(FAOLStmt &stmt);
      virtual void exitFAOL(FAOLStmt &stmt);
      virtual bool enterFAOH(FAOHStmt &stmt);
      virtual void exitFAOH(FAOHStmt &stmt);

    private:
      
      /// the result of the DASL parsing function
      DaigBuilder & builder_;

      /// character buffer for holding results of build
      std::stringstream & buffer_;
    };
  } // namespace madara
} //namespace daig

#endif //__MADARA_FUNCTION_VISITOR_H__
