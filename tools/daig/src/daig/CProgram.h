#ifndef _DAIG_CPROGRAM_H_
#define _DAIG_CPROGRAM_H_

/**
 * @file CProgram.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG C Program
 * container.
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
  /**
    * @class CProgram
    * @brief Encapsulates a C program definition
    */
  class CProgram
  {
  public:
    /**
     * Prints variable information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);

    ///global variables
    Variables globVars;
    
    /**
     * A map of function names to function definitions
     **/
    Functions funcs;

    ///add a global variable
    void addGlobVar(const Variable &v) { globVars[v.name] = v; }

    ///add a function
    void addFunction(const Function &f) { funcs[f.name] = f; }
  };
}

#endif // _DAIG_CPROGRAM_H_
