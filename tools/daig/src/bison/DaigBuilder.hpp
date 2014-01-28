//a class for parsing mcda files and constructing its DAIG
//representation

#ifndef __DAIG_BUILDER_HPP__
#define __DAIG_BUILDER_HPP__

#include <string>
#include <map>
#include "Program.h"

class DaigBuilder
{
private:
  daig::Program program;
  std::map<std::string,std::string> constDef;
  
  std::string fileName;
  bool debug;
  
public:
  DaigBuilder() : debug(0) {}
  DaigBuilder(const std::string &fn,const bool d)
    : fileName(fn),debug(d) {}
  void run();
};

#endif //__DAIG_BUILDER_HPP__
