#ifndef _DAIG_FUNCTION_H_
#define _DAIG_FUNCTION_H_

/**
 * @file Function.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for function definitions.
 **/

#include <vector>
#include <map>
#include <string>
#include "Variable.h"
#include "Statement.h"

namespace daig
{
  /**
    * @class Function
    * @brief Represents a function definition
    */
  class Function
  {
  public:
    /**
     * The name of the function
     **/
    std::string name;

    /**
     * The function parameters
     **/
    Variables params;
    
    ///function local variables -- we call them temporary variables
    ///since their scope is only the function body
    Variables temps;

    /**
     * The function body
     **/
    Stmt body;
    
    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);
  };

  typedef std::map <std::string, Function> Functions;
}

#endif // _DAIG_FUNCTION_H_
