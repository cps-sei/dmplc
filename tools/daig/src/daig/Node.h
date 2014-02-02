#ifndef _DAIG_NODE_H_
#define _DAIG_NODE_H_

/**
 * @file Node.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains the definition of a node/process.
 **/

#include <vector>
#include <map>
#include <string>
#include "Function.h"
#include "Variable.h"

namespace daig
{
  /**
    * @class Node
    * @brief Represents a process in a distributed program
    */
  class Node
  {
  public:    
    /**
     * The node name
     **/
    std::string name;

    ///the node arguments
    std::list<std::string> args;

    /**
     * list of global variables
     **/
    Variables globVars;

    ///list of local variables
    Variables locVars;
    
    /**
     * A map of function names to function definitions
     **/
    Functions functions;

    ///constructors
    Node() {}

    ///clear the node -- reset it to an empty node
    void clear()
    {
      name.clear(); args.clear(); 
      globVars.clear(); locVars.clear();
      functions.clear();
    }

    ///add a global variable
    void addGlobalVar(const std::list<Variable> &vl)
    {
      BOOST_FOREACH(const Variable &v,vl) {
        assert(globVars.count(v.name) == 0 && "ERROR: global variable redeclared!!");
        globVars[v.name] = v;
        globVars[v.name].scope = Variable::GLOBAL;
      }
    }

    ///add a local variable
    void addLocalVar(const std::list<Variable> &vl)
    {
      BOOST_FOREACH(const Variable &v,vl) {
        assert(locVars.count(v.name) == 0 && "ERROR: loc variable redeclared!!");
        locVars[v.name] = v;
        locVars[v.name].scope = Variable::LOCAL;
      }
    }

    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);
  };


  /**
   * A mapping of node types to node definitions
   **/
  typedef std::map <std::string, Node> Nodes;
}

#endif // _DAIG_NODE_H_
