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


//a class for sequentializing DMPL into a C program -- this version
//uses two copies of the global variables, but does not copy between
//them. instead it uses them alternatively. it supports unbounded
//verification by checking whether the safety property to be verified
//is inductive across each round of execution.

#ifndef __SYNC_SEQ_DBL_IND_HPP__
#define __SYNC_SEQ_DBL_IND_HPP__

#include "SyncSeqDbl.hpp"

namespace dmpl {

  //forward declaration
  class SyncSeqDblInd;

  //new namespace to avoid name collisions
  namespace syncseqdblind {

    /*****************************************************************/
    //a visitor that transforms at the global level
    /*****************************************************************/
    struct GlobalTransformer : public syncseqdbl::GlobalTransformer
    {
      //constructors
      GlobalTransformer(SyncSeqDbl &ss,dmpl::Program &p,const Func &fn)
        : syncseqdbl::GlobalTransformer(ss,p,true,fn) {}
    };

    /*****************************************************************/
    //a visitor that transforms at the node level
    /*****************************************************************/
    struct NodeTransformer : public syncseqdbl::NodeTransformer
    {
      NodeTransformer(SyncSeqDbl &ss,Program &p,const Process &pr,bool f,const Func &fn)
        : syncseqdbl::NodeTransformer(ss,p,pr,f,fn) {}
    };

  } //namespace syncseqdblind

  /*******************************************************************/
  //sequentializer for synchronous
  /*******************************************************************/
  class SyncSeqDblInd : public SyncSeqDbl
  {
  public:
    SyncSeqDblInd(DmplBuilder &b, const std::string &p, int r);

    void callRoundFuncs(StmtList &body);
    void createMainFunc();
    void createAssume();
    void createHavoc();
    void createNodeFuncs();
    void run();
  };
} //namespace dmpl

#endif //__SYNC_SEQ_DBL_IND_HPP__
