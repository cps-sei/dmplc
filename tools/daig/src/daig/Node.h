#ifndef _DAIG_NODE_H_
#define _DAIG_NODE_H_

/**
 * @file Node.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains the definition of a node/process.
 **/

#include <vector>
#include "Function.h"
#include "Variable.h"
#include "Token.h"

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
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);

    /**
     * A map of variable names to variables
     **/
    Variables variables;
    
    /**
     * A map of function names to function definitions
     **/
    Functions functions;

    /**
     * The arguments to the node
     **/
    Tokens args;
    
    /**
     * The body of the node
     **/
    Token body;
  };

  /**
   * A collection of nodes
   **/
  typedef std::vector <Node> Nodes;
}

#endif // _DAIG_NODE_H_