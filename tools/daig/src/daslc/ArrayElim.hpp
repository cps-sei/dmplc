//a class for sequentializing DAIG into a C program

#ifndef __ARRAY_ELIM_HPP__
#define __ARRAY_ELIM_HPP__

#include <iostream>
#include "DaigBuilder.hpp"
#include "daig/CProgram.h"
#include "daig/Visitor.h"

namespace daig {

  /*******************************************************************/
  //array eliminator
  /*******************************************************************/
  class ArrayElim
  {
  public:
    //the input program with arrays
    CProgram &inProg;

    //the output program without arrays
    CProgram outProg;

    ArrayElim(CProgram &ip);
    void run();
  };
} //namespace daig

#endif //__ARRAY_ELIM_HPP__
