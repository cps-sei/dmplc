#ifndef _DAIG_PROGRAM_H_
#define _DAIG_PROGRAM_H_

/**
 * @file Program.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG Program container.
 **/

#include <map>
#include <string>
#include "Model_Of_Computation.h"
#include "Variable.h"
#include "Function.h"

namespace daig
{
  /**
    * @class Program
    * @brief Encapsulates a program definition
    */
  class Program
  {
  public:
    /**
     * Number of processes in the program
     **/
    int processes;
    
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
  };
}

#endif // _DAIG_PROGRAM_H_