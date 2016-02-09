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
#include "Role.h"
#include "Visitor.h"
#include <iostream>


namespace dmpl
{
  //a process is a role, and a node id
  class Process
  {
  public:
    Role role;
    int id;

    //-- constructors
    Process(const Role &r, const int i) : role(r), id(i) {}

    //-- get the name of the node
    const std::string &getNode() const { return role->node->name; }
    //-- get the name of the role
    const std::string &getRole() const { return role->name; }
    //-- get the node id
    int getId() const { return id; }

    //-- equality operator
    bool operator == (const Process &rhs) const
    {
      if(this == &rhs) return true;
      return getNode() == rhs.getNode() && getRole() == rhs.getRole() && id == rhs.id;
    }
    
    //-- comparator
    bool operator < (const Process &rhs) const
    {
      if(this == &rhs) return false;
      if(id < rhs.id) return true;
      if(id > rhs.id) return false;
      if(getNode() < rhs.getNode()) return true;
      if(getNode() > rhs.getNode()) return false;
      return (getRole() < rhs.getRole());
    }
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
      if(ret != funcs.end()) return ret->second;
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
      node->program = this;
      
      auto it = nodes.find(node->name);

      if(it == nodes.end())
        it = nodes.insert(std::pair<std::string,Node>(node->name,node)).first;
      else {
        for(auto &r : node->roles) r.second->node = it->second;
        it->second->mergeWith(node);
      }
      
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

    ///add a process with a role and an id. abort if no such role
    ///exists.
    void addProcess(const std::string &nodeName, const std::string &roleName, int nodeId)
    {
      const auto it1 = nodes.find(nodeName);
      if(it1 == nodes.end())
        throw std::runtime_error("ERROR: program has no node called " + nodeName + "!!");

      const auto it2 = it1->second.get()->roles.find(roleName);
      if(it2 == it1->second.get()->roles.end())
        throw std::runtime_error("ERROR: program has no role called " + roleName +
                                 " in node " + nodeName + "!!");

      if(nodeId != processes.size())
        throw std::runtime_error(std::string("ERROR: adding process with node ") + nodeName +
                                 " and role " + roleName + " and id " +
                                 boost::lexical_cast<std::string>(nodeId) +
                                 " when next id should be " +
                                 boost::lexical_cast<std::string>(processes.size()) + "!!");
        
      processes.push_back(Process(it2->second, nodeId));
    }
    
    //-- fill in various details of the program that could not be done
    //-- during parse time
    void complete();

    //-- sanity check a set of functions
    void sanityCheckFuncs(const Funcs &arg);
    
    ///check various sanity conditions on the program. this is prior
    ///to thread and symbol usage analysis.
    void preAnalysisSanityCheck();

    ///look for threads
    void analyzeThreads();

    ///analyze symbol usage
    void analyzeSymbolUsage();

    ///check various sanity conditions on the program. this is after
    ///thread and symbol usage analysis.
    void postAnalysisSanityCheck();

    //-- return the set of processes with given role name
    std::set<Process> procsWithRole(const std::string &roleName) const
    {
      std::set<Process> res;
      for(const Process &p : processes)
        if(p.getRole() == roleName) res.insert(p);
      return res;
    }

    //-- given a process p and a role name r, return the set of
    //-- processes that p could potentially refer to as r
    std::set<Process> getRefProcs(const Process &proc,const std::string &roleName) const
    {
      std::set<Process> res;
      //-- right now, we just collect all processes with name = roleName
      res = procsWithRole(roleName);
      return res;
    }
  };

  //new namespace to avoid name collisions
  namespace program
  {
    /*****************************************************************/
    //a visitor that checks for various sanity conditions
    /*****************************************************************/
    struct SanityChecker : public Visitor
    {
      //the DMPL program, node, role and function being checked
      Program &prog;
      Node node;
      Role role;
      Func func;
      
      //map from variables to constants for substitution
      std::map<std::string,size_t> idMap;

      //constructors
      SanityChecker(Program &p, Func f) : prog(p), node(f->node), role(f->role), func(f) {}

      //update substitution mapping
      void addIdMap(const std::string &s,size_t i);
      void delIdMap(const std::string &s);

      //dispatchers
      void exitLval(LvalExpr &expr);
      void exitAsgn(AsgnStmt &stmt);
      void exitCall(CallStmt &stmt);
      bool enterFAN(FANStmt &stmt) { return false; }
      void exitFAN(FANStmt &stmt);
      bool enterFADNP(FADNPStmt &stmt) { return false; }
      void exitFADNP(FADNPStmt &stmt);
    };
  } //namespace program
}

#endif // _DMPL_PROGRAM_H_
