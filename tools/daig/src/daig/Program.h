#ifndef _DAIG_PROGRAM_H_
#define _DAIG_PROGRAM_H_

/**
 * @file Program.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG Program container.
 **/

#include <list>
#include <map>
#include <string>
#include "Model_Of_Computation.h"
#include "Variable.h"
#include "Function.h"
#include "Node.h"

namespace daig
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
     * Prints variable information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);
    
    /**
     *
     **/

    /**
     * Model of computation for the program
     **/
    Model_Of_Computation moc;

    /**
     * A map of variable names to variables
     **/
    Variables variables;
    
    /**
     * A map of function names to function definitions
     **/
    Functions functions;

    /**
     * Node definitions
     **/
    Node_Types node_types;

    /**
     * The actual nodes
     **/
    Nodes nodes;

    //the list of processes
    std::list<Process> processes;
  };
}

#endif // _DAIG_PROGRAM_H_
