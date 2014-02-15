#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include "DaigBuilder.hpp"
#include "SyncSeq.hpp"

/*********************************************************************/
//options
/*********************************************************************/
std::string fileName,outFileName;
bool debug = false,print=false,seq = false;

/*********************************************************************/
//function declarations
/*********************************************************************/
void usage(char *cmd);
void parseOptions(int argc, char **argv);

/*********************************************************************/
//the main function
/*********************************************************************/
int main(int argc, char **argv)
{
  parseOptions(argc,argv);

  //create the program
  daig::DaigBuilder builder(fileName,debug);
  builder.run();

  //print the program
  if(print) {
    if(outFileName.empty()) builder.printProgram(std::cout);
    else {
      std::ofstream os(outFileName.c_str());
      builder.printProgram(os);
      os.close();
    }
  }

  //sequentialize and print result
  if(seq) {
    std::string moc = builder.program.moc.to_string_type();

    //for synchronous programs
    if(moc == "MOC_SYNC") {
      daig::SyncSeq syncSeq(builder);
      syncSeq.run();
      if(outFileName.empty()) syncSeq.printProgram(std::cout);
      else {
        std::ofstream os(outFileName.c_str());
        syncSeq.printProgram(os);
        os.close();
      }
      return 0;
    }

    //unsuppored model of computation
    std::cerr << "ERROR: cannot sequentialize " << moc << " programs!!\n";
  }

  //all done
  return 0;
}

/*********************************************************************/
//parse command line options and populate global variables
/*********************************************************************/
void parseOptions(int argc, char **argv)
{
  for(int i = 1;i < argc;++i) {
    if(!strcmp(argv[i],"--debug")) debug = true;
    else if(!strcmp(argv[i],"--seq")) seq = true;
    else if(!strcmp(argv[i],"--print")) print = true;
    else if(!strcmp(argv[i],"--out")) {
      if(i < argc - 1) outFileName = std::string(argv[++i]);
      else usage(argv[0]);
    } else fileName = std::string(argv[i]);
  }

  if(fileName.empty()) usage(argv[0]);
}

/*********************************************************************/
//print usage and exit
/*********************************************************************/
void usage(char *cmd)
{
  std::cerr << "ERROR: no input-filename ...\n";
  std::cerr << "Usage : " << cmd << " <options> filename\n";
  std::cerr << "Options :\n\t--debug\n\t--print\n\t"
            << "--seq\n\t--out output-filename\n";
  exit(1);
}

/*********************************************************************/
//end of daslc.cpp
/*********************************************************************/
