//a class for parsing mcda files and constructing its DAIG
//representation

#ifndef __DAIG_BUILDER_HPP__
#define __DAIG_BUILDER_HPP__

#include <string>
#include <map>
#include "daig/Program.h"

namespace daig {
  class DaigBuilder
  {
  public:
    daig::Program program;
  
    std::string fileName;
    bool debug;
  
  public:
    DaigBuilder() : debug(0) {}
    DaigBuilder(const std::string &fn,const bool d)
      : fileName(fn),debug(d) {}
    void run();
    void printProgram(std::ostream &os);
  };
} //namespace daig

#endif //__DAIG_BUILDER_HPP__
