/**
 * Copyright (c) 2013 Carnegie Mellon University. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following acknowledgments and disclaimers.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. The names “Carnegie Mellon University,” "SEI” and/or “Software
 *    Engineering Institute" shall not be used to endorse or promote products
 *    derived from this software without prior written permission. For written
 *    permission, please contact permission@sei.cmu.edu.
 * 
 * 4. Products derived from this software may not be called "SEI" nor may "SEI"
 *    appear in their names without prior written permission of
 *    permission@sei.cmu.edu.
 * 
 * 5. Redistributions of any form whatsoever must retain the following
 *    acknowledgment:
 * 
 *      This material is based upon work funded and supported by the Department
 *      of Defense under Contract No. FA8721-05-C-0003 with Carnegie Mellon
 *      University for the operation of the Software Engineering Institute, a
 *      federally funded research and development center. Any opinions,
 *      findings and conclusions or recommendations expressed in this material
 *      are those of the author(s) and do not necessarily reflect the views of
 *      the United States Department of Defense.
 * 
 *      NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING
 *      INSTITUTE MATERIAL IS FURNISHED ON AN “AS-IS” BASIS. CARNEGIE MELLON
 *      UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESSED OR
 *      IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF
 *      FITNESS FOR PURPOSE OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS
 *      OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES
 *      NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT,
 *      TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 *      This material has been approved for public release and unlimited
 *      distribution.
 **/

#ifndef __MADARA_FUNCTION_VISITOR_H__
#define __MADARA_FUNCTION_VISITOR_H__

#include <iostream>
#include <sstream>
#include "daslc/DaigBuilder.hpp"
#include "daig/Visitor.h"
#include "daig/Function.h"
#include "daig/Node.h"

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
      Function_Visitor (Function & function, Node & node, 
        DaigBuilder & builder, std::stringstream & buffer);

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
      
      /// current function
      Function & function_;

      /// current node
      Node & node_;

      /// the result of the DASL parsing function
      DaigBuilder & builder_;

      /// character buffer for holding results of build
      std::stringstream & buffer_;

      /// space indentation
      size_t indentation_;

      /// special identifier map, generally used by daig specific functions
      std::map <std::string, int> id_map_;
    };
  } // namespace madara
} //namespace daig

#endif //__MADARA_FUNCTION_VISITOR_H__
