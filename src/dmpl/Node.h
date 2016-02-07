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

#ifndef _DMPL_NODE_H_
#define _DMPL_NODE_H_

/**
 * @file Node.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains the definition of a node/process.
 **/

#include <vector>
#include <map>
#include <string>
#include <memory>
#include "Function.h"
#include "Variable.h"
#include "Attribute.h"
#include "Role.h"
#include "Specification.hpp"
#include "Record.hpp"

namespace dmpl
{
  //-- forward declarations
  class Program;

  /**
    * @class Node
    * @brief Represents a process in a distributed program
    */
  class BaseNode : public NodeRole
  {
  public:    
    /// Owning Program object
    Program *program;

    ///the node arguments
    std::vector<std::string> args;

    ///map from names to roles
    Roles roles;

    ///id variable (named by the single entry in args).
    Var idVar;

    ///constructors
    BaseNode(bool abst = false) : program(NULL), NodeRole(abst) {}
    BaseNode(const std::string &n, bool abst = false) : program(NULL), NodeRole(n,abst) {}
    BaseNode(const std::string &n, const Attributes& a, bool abst = false)
      : program(NULL), NodeRole(n,a,abst) {}

    //-- return a description of the node
    std::string getDesc() const { return "node " + name; }

    void initArgs()
    {
      if(idVar == NULL && args.size() == 1)
      {
        idVar = std::make_shared<Var::element_type>(args[0], intType());
        idVar->scope = Variable::SELF_ID;
      }
      else
      {
        throw std::runtime_error("Node must have exactly one parameter (its id)");
      }
    }
    
    //-- find variable with given name. return empty variable if no
    //-- such variable found.
    Var findVar(const std::string& name) const
    {
      if(idVar && idVar->name == name) return idVar;

      return NodeRole::findVar(name);
    }
    
    //-- find function with given name. either in this node or at the
    //-- program level.
    Func findFunc(const std::string& name) const;

    ///clear the node -- reset it to an empty node
    void clear()
    {
      NodeRole::clear();
      args.clear(); 
    }

    ///find function with given name. return NULL function if none
    ///exists.
    Func findFunc(const std::string &funcName)
    {
      const auto &it = funcs.find(funcName);
      return it == funcs.end() ? Func() : it->second;
    }
    
    ///add a role
    void addRole(const Role &r)
    {
      auto it = roles.find(r->name);
      if(it == roles.end()) roles.insert(std::make_pair(r->name, r));
      else it->second->mergeWith(r);
    }

    ///merge with another node
    void mergeWith(const Node &on);

    //-- assign ids to threads and do symbol usage analysis
    void analyzeThreads();

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);

    //-- return the function corresponding to the "require"
    //-- specification with given name. return a NULL function if so
    //-- such specification exists
    Func getRequireFunc(const std::string &specName) const
    {
      const auto &it = specs.find(specName);
      if(it == specs.end()) return Func();
      
      RequireSpec *rs = static_cast<RequireSpec*>(it->second.get());
      return rs == NULL ? Func() : rs->func;
    }
  };


  /**
   * A mapping of node types to node definitions
   **/
  typedef std::map <std::string, Node> Nodes;
}

#endif // _DMPL_NODE_H_
