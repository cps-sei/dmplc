#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <string>
#include "DaigBuilder.hpp"

//options
std::string fileName;
bool debug;

void parseOptions(int argc, char **argv);

int main(int argc, char **argv)
{
  parseOptions(argc,argv);

  //create the program
  DaigBuilder db(fileName,debug);
  db.run();

  //all done
  return 0;
}

void parseOptions(int argc, char **argv)
{
  for(int i = 1;i < argc;++i) {
    if(!strcmp(argv[i],"--debug")) debug = true;
    else fileName = std::string(argv[i]);
  }

  if(fileName.empty()) {
    std::cerr << "ERROR: no filename ...\n";
    std::cerr << "Usage : " << argv[0] << " filename [--debug]\n";
    exit(1);
  }
}
