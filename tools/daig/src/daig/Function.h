#ifndef _DAIG_FUNCTION_H_
#define _DAIG_FUNCTION_H_

/**
 * @file Function.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for function definitions.
 **/

#include <vector>
#include "Token.h"

#include <map>
#include <string>

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
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);

    /**
     * The name of the function
     **/
    std::string name;

    /**
     * The function arguments
     **/
    Tokens args;
    
    /**
     * The function body
     **/
    Token body;
  };

  typedef std::map <std::string, Function> Functions;
}

#endif // _DAIG_FUNCTION_H_
