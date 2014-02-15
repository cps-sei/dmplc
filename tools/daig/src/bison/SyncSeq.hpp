//a class for sequentializing DAIG into a C program

#ifndef __SYNC_SEQ_HPP__
#define __SYNC_SEQ_HPP__

#include <iostream>
#include "DaigBuilder.hpp"
#include "CProgram.h"

namespace daig {
  class SyncSeq
  {
  public:
    DaigBuilder &builder;
    size_t nodeNum;
    CProgram cprog;

    SyncSeq(DaigBuilder &b,size_t n) : builder(b),nodeNum(n) {}
    void run();
    void printProgram(std::ostream &os);
  };
} //namespace daig

#endif //__SYNC_SEQ_HPP__
