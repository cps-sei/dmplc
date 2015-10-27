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

#ifndef _DMPL_PROGRAM_H_
#define _DMPL_PROGRAM_H_

/**
 * @file Program.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DMPL Program container.
 **/

#include <list>
#include <map>
#include <string>
#include "Variable.h"
#include "Function.h"
#include "Node.h"
#include "Visitor.h"
#include <iostream>


namespace dmpl
{
  //a process is a node name and a node id
  class Process : public std::pair<std::string,int>
  {
  public:
    Process(const std::string &n,const int id)
      : std::pair<std::string,int>(n,id) {}

    const std::string &getNode() const { return first; }
    int getId() const { return second; }
  };

  /**
    * @class Program
    * @brief Encapsulates a program definition
    */
  class Program
  {
  public:
    /**
     * Default constructor
     **/
    Program () {}
    
    /**
     * Destructor
     **/
    ~Program () {}

    /**
     * Prints variable information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);
    
    ///target thunks
    typedef std::map<std::string,std::string> TargetType;
    TargetType targets;

    //constant definitions
    typedef std::map<std::string,std::string> ConstDef;
    ConstDef constDef;

    /**
     * A map of function names to function definitions
     **/
    Funcs funcs;

    Func findFunc(const std::string& name) const
    {
      Funcs::const_iterator ret = funcs.find(name);
      if(ret != funcs.end())
        return ret->second;
      return Func();
    }

    /**
     * The node definitions
     **/
    Nodes nodes;

    //the list of processes
    std::list<Process> processes;

    ///add a target thunk, or append to an existing one
    void addTarget(const std::string &tgt,const std::string &thk)
    { targets[tgt] += thk; }

    ///add a node to the program. merge with any existing node with
    ///same name.
    void addNode(const Node &node)
    {
      auto it = nodes.find(node->name);

      if(it == nodes.end())
        it = nodes.insert(std::pair<std::string,Node>(node->name,node)).first;
      else
        it->second->mergeWith(node);

      it->second->program = this;
    }

    ///add a function
    void addFunction(const Func &f) { funcs[f->name] = f; }

    ///return true if the argument is the name of a function
    bool isFunction(const std::string &fn) const 
    {
      return funcs.find(fn) != funcs.end(); 
    }

    ///return true if the argument is the name of an external function
    bool isExternalFunction(const std::string &fn) const 
    {
      return isFunction(fn) && funcs.find(fn)->second->isExtern == true;
    }

    ///return true if the argument is the name of a defined top-level DMPL function
    bool isInternalFunction(const std::string &fn) const
    {
      return isFunction(fn) && funcs.find(fn)->second->isExtern == false;
    }

    ///check various sanity conditions on the program
    void sanityCheck();

    ///look for threads, analyze variable usage
    void analyzeThreads();
  };

  //new namespace to avoid name collisions
  namespace program {
    /*****************************************************************/
    //a visitor that checks for various sanity conditions
    /*****************************************************************/
    struct SanityChecker : public Visitor
    {
      //the DASL program being checked
      Program &prog;

      //map from variables to constants for substitution
      std::map<std::string,size_t> idMap;

      //constructors
      SanityChecker(Program &p) : prog(p) {}

      //update substitution mapping
      void addIdMap(const std::string &s,size_t i);
      void delIdMap(const std::string &s);

      //dispatchers
      void exitCall(CallStmt &stmt);
      bool enterFAN(FANStmt &stmt) { return false; }
      void exitFAN(FANStmt &stmt);
      bool enterFADNP(FADNPStmt &stmt) { return false; }
      void exitFADNP(FADNPStmt &stmt);
    };
  } //namespace program
}

#endif // _DMPL_PROGRAM_H_
