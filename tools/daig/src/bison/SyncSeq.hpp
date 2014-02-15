//a class for sequentializing DAIG into a C program

#ifndef __SYNC_SEQ_HPP__
#define __SYNC_SEQ_HPP__

#include <iostream>
#include "DaigBuilder.hpp"

namespace daig {
  class SyncSeq
  {
  public:
    DaigBuilder &builder;

    SyncSeq(DaigBuilder &b) : builder(b) {}
    void run();
    void printProgram(std::ostream &os);
  };
} //namespace daig

#endif //__SYNC_SEQ_HPP__
