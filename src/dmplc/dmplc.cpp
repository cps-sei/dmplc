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


#include <string.h>
#include <stdlib.h>
#include <iostream>
#include <fstream>
#include <string>
#include "DmplBuilder.hpp"
#include "dmpl/gams/GAMS_Builder.hpp"
#include "dmpl/gams/Analyzer_Builder.hpp"
#include "SyncSeqDbl.hpp"
#include "SyncSeqDblInd.hpp"

/*********************************************************************/
//options
/*********************************************************************/

//-- wrap in anonymous namespace to avoid name clashes
namespace
{
  //-- dmplc version
  const std::string version("0.2");
  
  //-- names of files to parse
  std::list<std::string> file_names;
  
  //-- output file name. empty means stdout.
  std::string out_file;
  
  //-- name of target thunk to dump from the DMPL file.
  std::string madara_target ("GNU_CPP");

  //-- parse and print the DMPL file
  bool do_print = false;
  
  //-- sequentialize for verification via bounded model checking
  bool do_seq = false;
  
  //-- sequential for checking inductive invariants for bounded model
  //-- checking
  bool do_seq_ind = false;
  
  //-- number of rounds to sequentialize for (-1 means infinity)
  int round_num = -1;
  
  //-- the list of descriptors for roles to verify against. a role
  //-- desciptor is X:Y:n where X is the name of the node, Y is the name
  //-- of a role inside it, and n is the number of such roles. node id's
  //-- will be assigned in the order in which the roles are specified.
  std::list<std::string> roleDescs;
  
  //-- generate code against the GAMS platform
  bool do_gams = false;
  
  //-- generate code to check and log "expect" statements
  bool do_expect = false;
  
  //-- generate "expect" log analyzer
  bool do_analyzer = false;
  
  //-- print debug messages
  bool debug = false;
  
  //-- name of the require property to verify
  std::string reqProp; 
  
  //-- the type of thread scheduler to use
  dmpl::SchedType schedType = dmpl::NON_RT;
  
  //-- constant definitions supplied via command line
  std::map<std::string, std::string> const_def;
}

/*********************************************************************/
//function declarations
/*********************************************************************/
void parse_options (int argc, char **argv);
void usage (char *cmd);
void addProcesses(dmpl::Program &program);

/*********************************************************************/
//the main function
/*********************************************************************/
int main (int argc, char **argv)
{
  //-- print version and command line options
  std::cout << "DMPLC Version " << version << '\n';
  std::list<std::string> cmdLine;
  for(int i = 0;i < argc;++i) cmdLine.push_back(argv[i]);
  std::cout << "Command line:";
  for(const std::string &c : cmdLine) std::cout << ' ' << c;
  std::cout << '\n';

  //-- parse arguments
  parse_options (argc, argv);

  //create the program and fill in the processes
  dmpl::DmplBuilder builder (version, cmdLine, file_names, const_def, debug);
  builder.run ();
  addProcesses(builder.program);

  //print the program
  if (do_print)
  {
    if (out_file.empty ())
    {
      builder.printProgram (std::cout);
    }
    else
    {
      std::ofstream os (out_file.c_str ());
      builder.printProgram (os);
      os.close ();
    }
  }
  
  //right now, we're just using a realize flag to indicate madara
  //generation
  if (do_gams)
  {
    //create a madara builder instance of the dmpl builder parse
    dmpl::CodeGenerator *gams_builder
      = new dmpl::gams::GAMS_Builder (builder, madara_target, schedType, do_expect);

    //build the generated code
    gams_builder->build ();

    //print the generated code
    if (out_file.empty ())
      gams_builder->print (std::cout);
    else
    {
      std::ofstream os (out_file.c_str ());
      gams_builder->print (os);
      os.close ();
    }

    //cleanup
    delete gams_builder;
  }
  else if(do_analyzer)
  {
    //create a madara builder instance of the dmpl builder parse
    dmpl::gams::Analyzer_Builder *ana_builder = new dmpl::gams::Analyzer_Builder (builder, madara_target);

    //build the generated code
    ana_builder->build ();

    //print the generated code
    if (out_file.empty ())
      ana_builder->print (std::cout);
    else {
      std::ofstream os (out_file.c_str ());
      ana_builder->print (os);
      os.close ();
    }

    //cleanup
    delete ana_builder;
  }

  //sequentialize and print result
  if (do_seq)
  {
    //the C program produced by sequentialization
    dmpl::CProgram cprog;
    
    dmpl::SyncSeqDbl syncSeqDbl (builder, reqProp, round_num);
    syncSeqDbl.run ();
    cprog = syncSeqDbl.cprog;
    
    if (out_file.empty ())
      cprog.print (std::cout, 0);
    else {
        std::ofstream os (out_file.c_str ());
        cprog.print (os, 0);
        os.close ();
      }
  }

  //sequentialize for inductive check and print result
  if (do_seq_ind)
  {
    //the C program produced by sequentialization
    dmpl::CProgram cprog;
    
    dmpl::SyncSeqDblInd syncSeqDblInd (builder, reqProp, round_num);
    syncSeqDblInd.run ();
    cprog = syncSeqDblInd.cprog;
    
    if (out_file.empty ())
      cprog.print (std::cout, 0);
    else {
        std::ofstream os (out_file.c_str ());
        cprog.print (os, 0);
        os.close ();
      }
  }

  //all done
  return 0;
}

/*********************************************************************/
//parse command line options and populate global variables
/*********************************************************************/
void parse_options (int argc, char **argv)
{
  for (int i = 1; i < argc; ++i)
  {
    std::string arg1 (argv[i]);

    if (arg1 == "-d" || arg1 == "--debug")
    {
      debug = true;
    }
    else if (arg1 == "-h" || arg1 == "--help")
    {
      usage (argv[0]);
    }
    else if (arg1 == "-o" || arg1 == "--out")
    {
      if (i + 1 < argc)
      {
        out_file = argv[i + 1];
      }
      else
      {
        std::cerr << "ERROR: output file (-o|--out) must have file name\n";
        usage (argv[0]);
      }
      ++i;
    }
    else if (arg1 == "-p" || arg1 == "--print")
    {
      do_print = true;
    }
    else if (arg1 == "--roles")
    {
      if (i + 1 < argc)
      {
        roleDescs.push_back(argv[i + 1]);
      }
      else
      {
        std::cerr << "ERROR: role desciptors (--roles) must have value (e.g. --roles uav:Uav:3)\n";
        usage (argv[0]);
      }
      ++i;
    }
    else if (arg1 == "-rp" || arg1 == "--reqProp")
    {
      if (i + 1 < argc) reqProp = argv[i+1]; 
      else
      {
        std::cerr << "ERROR: require property (-rp|--reqProp) must have value (e.g. -rp NoCollision)\n";
        usage (argv[0]);
      }
      ++i;
    }
    else if (arg1 == "-a" || arg1 == "--analyzer")
    {
      do_analyzer = true;
    }
    else if (arg1 == "-g" || arg1 == "--gams")
    {
      do_gams = true;
    }
    else if (arg1 == "-e" || arg1 == "--expect")
    {
      do_expect = true;
    }
    else if (arg1 == "-cg" || arg1 == "--cube-grid")
    {
      if (i + 1 < argc)
      {
        const_def["X"] = argv[i + 1];
        const_def["Y"] = argv[i + 1];
        const_def["Z"] = argv[i + 1];
      }
      else
      {
        std::cerr << "ERROR: Cube Grid Size (-cg|--cube-grid) must have a value!!\n";
        usage (argv[0]);
      }
      ++i;
    }
    else if (arg1 == "-t" || arg1 == "--target" || arg1 == "--platform")
    {
      if (i + 1 < argc)
      {
        madara_target = argv[i + 1];
      }
      else
      {
        std::cerr << "ERROR: Target platform (-t|--target|--platform) must have a ";
        std::cerr << " target (e.g. -t WIN_CPP)\n";
        usage (argv[0]);
      }
      ++i;
    }
#if MZSRM==1
    else if (arg1 == "-mz" || arg1 == "--mzsrm")
    {
      schedType = dmpl::MZSRM;
    }
#endif
    else if (arg1 == "-s" || arg1 == "--seq")
    {
      do_seq = true;
    }
    else if (arg1 == "-si" || arg1 == "--seq-ind")
    {
      do_seq_ind = true;
    }
    else if (arg1 == "-r" || arg1 == "--rounds")
    {
      if (i + 1 < argc)
      {
        std::stringstream buffer (argv[i + 1]);
        buffer >> round_num;
      }
      else
      {
        std::cerr << "ERROR: Number of rounds (-r|--rounds) must have a ";
        std::cerr << " number of rounds (e.g. -r 5)\n";
        usage (argv[0]);
      }
      ++i;
    }
    else if (arg1.substr (0,3) == "--D")
    {
      //extract constant and value from constant=value
      std::string var_name = arg1.substr (3);
      
      if (i + 1 < argc && var_name.size () > 0)
      {
        std::string value;
        std::stringstream buffer (argv[i + 1]);
        buffer >> value;
        const_def[var_name] = value;
      }
      else
      {
        std::cerr << "ERROR: Constant value (via --D) must have a ";
        std::cerr << " name and a value (e.g. --Dmy_const 5)\n";
        usage (argv[0]);
      }
      ++i;

    }
    else if (arg1.c_str()[0] == '-') usage(argv[0]);
    else
    {
      file_names.push_back(std::string (argv[i]));
    }
  }

  //-- sanity checks
  if (file_names.empty ()) {
    std::cerr << "ERROR: no DMPL file names specified!!\n";
    usage (argv[0]);
  }

  //-- X, Y and Z must be defined
  for(const std::string &d : { "X", "Y", "Z" }) {
    if(const_def.find(d) == const_def.end()) {
      std::cerr << "ERROR: no " << d << " dimension specified!!\n";
      usage (argv[0]);
    }
  }
}

/*********************************************************************/
//print usage and exit
/*********************************************************************/
void usage (char *cmd)
{
  std::cerr << "Usage : " << cmd << " <options optionval> filename [filename ...]\n";
  std::cerr << "Options :\n";
  std::cerr << "  -d|--debug                 print debugging information\n";
  std::cerr << "  -h|--help                  print help and usage\n";
  std::cerr << "  -o|--out file              output file, default is stdout\n";
  std::cerr << "  -p|--print                 parse and print DASL file\n";
  std::cerr << "  --roles X:Y:n[:X:Y:n...]   list of roles descriptors specified as X:Y:n\n";
  std::cerr << "                             where X=node name, Y=role name, n=number of roles\n";
  std::cerr << "  -rp|--reqProp name         name of require property to verify\n";
  std::cerr << "  -a|--analyzer              generate C++ for expect log analyzer\n";
  std::cerr << "  -g|--gams                  generate C++/GAMS code to run\n";
  std::cerr << "  -e|--expect                check and log 'expect' statements\n";
  std::cerr << "  -cg|--cube-grid s          specify number of cells on each side of a cubic grid\n";
  std::cerr << "  -t|--target|--platform p   specify a target platform\n";
  std::cerr << "                             Available platforms: WIN_CPP, GNU_CPP (default)\n";
#if MZSRM==1
  std::cerr << "  -mz|--mzsrm                generate code that targets MZSRM scheduler\n";
#endif
  std::cerr << "  -s|--seq                   generate sequentialized code to verify\n";
  std::cerr << "  -si|--seq-ind              generate sequentialized code to verify inductiveness\n";
  std::cerr << "  -r|--rounds rounds         number of verification rounds\n";
  std::cerr << "  --D<const_name> value      set a const to a value\n";
  exit (0);
}

/*********************************************************************/
//-- add processes to the program based on role descriptors supplied
//-- via the command line. a role descriptor is of the form
//-- X:Y:n[:X:Y:n...] where X is a node name, Y is a role name, and n
//-- is the number of roles
/*********************************************************************/
void addProcesses(dmpl::Program &program)
{
  program.processes.clear ();
  int nodeId = 0;
  for(const std::string &rd : roleDescs) {
    size_t pos1 = 0, pos2 = 0, pos3 = 0;

    for(;;) {
      pos1 = rd.find(':', pos3);
      if(pos1 == std::string::npos)
        throw std::runtime_error("ERROR: illegal role descriptor " + rd + " : must be X:Y:n!!");
      std::string nodeName = rd.substr(pos3, pos1-pos3);

      pos2 = rd.find(':', ++pos1);
      if(pos2 == std::string::npos)
        throw std::runtime_error("ERROR: illegal role descriptor " + rd + " : must be X:Y:n!!");
      std::string roleName = rd.substr(pos1, pos2-pos1);

      pos3 = rd.find(':', ++pos2);
      int roleNum = atoi(rd.substr(pos2, pos3 == std::string::npos ? pos3 : pos3-pos2).c_str());
      if(roleNum <= 0)
        throw std::runtime_error("ERROR: illegal role descriptor " + rd + " : must be X:Y:n!!");

      for(int i = 0;i < roleNum;++i)
        program.addProcess(nodeName, roleName, nodeId++);

      if(pos3 == std::string::npos) break;
      else ++pos3;
    }
  }

  if(program.processes.empty())
    throw std::runtime_error("ERROR: no roles specified!!");
}

/*********************************************************************/
//end of dmplc.cpp
/*********************************************************************/
