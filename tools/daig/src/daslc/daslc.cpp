#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include "DaigBuilder.hpp"
#include "daig/madara/SyncBuilder.hpp"
#include "SyncSeq.hpp"

/*********************************************************************/
//options
/*********************************************************************/
std::string fileName,outFileName;
bool debug = false, print=false;
size_t nodeNum = 0;
int roundNum = -1;
bool realize = false;

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
  if(print)
  {
    if(outFileName.empty())
    {
      builder.printProgram(std::cout);
    }
    else
    {
      std::ofstream os(outFileName.c_str());
      builder.printProgram(os);
      os.close();
    }
  }
  
  // right now, we're just using a realize flag to indicate madara generation
  if (realize && !outFileName.empty ())
  {
    // create an output stream from the file name
    std::ofstream os(outFileName.c_str());

    // create a madara builder instance of the daig builder parse
    daig::madara::SyncBuilder madara_builder (builder);
    madara_builder.build ();

    // print the resulting information to the string and close the stream
    madara_builder.print (os);
    os.close();
  }

  //sequentialize and print result
  if(nodeNum)
  {
    std::string moc = builder.program.moc.to_string_type();

    //for synchronous programs
    if(moc == "MOC_SYNC")
    {
      daig::SyncSeq syncSeq(builder,nodeNum,roundNum);
      syncSeq.run();
      if(outFileName.empty())
      {
        syncSeq.printProgram(std::cout);
      }
      else
      {
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
  for(int i = 1; i < argc; ++i)
  {
    if(!strcmp(argv[i],"--debug"))
    {
      debug = true;
    }
    else if(strstr(argv[i],"--seq=") == argv[i])
    {
      nodeNum = atoi(argv[i] + 6);
    }
    else if(!strcmp(argv[i],"--print"))
    {
      print = true;
    }
    else if(strstr(argv[i],"--out=") == argv[i])
    {
      outFileName = std::string(argv[i] + 6);
    }
    else if(strstr(argv[i],"--rounds=") == argv[i])
    {
      roundNum = atoi(argv[i] + 9);
    }
    else if(!strcmp(argv[i],"--realize") || !strcmp (argv[i],"-r"))
    {
      realize = true;
    }
    else
    {
      fileName = std::string(argv[i]);
    }
  }

  if(fileName.empty())
    usage(argv[0]);
}

/*********************************************************************/
//print usage and exit
/*********************************************************************/
void usage(char *cmd)
{
  std::cerr << "ERROR: no input-filename ...\n";
  std::cerr << "Usage : " << cmd << " <options> filename\n";
  std::cerr << "Options :\n\t--debug\n\t--print\n\t"
            << "--seq=node-num\n\t--out=output-filename\n\t"
            << "--rounds=round-num\n"
            << "-r|--realize   create a MADARA program for simulations\n";
  exit(1);
}

/*********************************************************************/
//end of daslc.cpp
/*********************************************************************/
