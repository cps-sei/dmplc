#ifndef _DAIG_VARIABLE_
#define _DAIG_VARIABLE_

/**
 * @file Variable.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG model of computation.
 **/

#include <map>
#include <string>
#include "Token.h"

namespace daig
{
  /**
    * @class Variable
    * @brief A type of token that holds value
    */
  class Variable : public Token
  {
  public:
    enum Types
    {
      ANY,
      INTEGER,
      INTEGER_ARRAY,
      DOUBLE,
      DOUBLE_ARRAY,
      STRING,
      FILE
    };

    enum Scopes
    {
      PRIVATE,
      GLOBAL
    };

    enum Classifiers
    {
      NONE = 0,
      CONST_VAR = 1
    };

    /**
     * Default constructor
     **/
    Variable ();

    /**
     * Prints variable information
     * @param  indent  spaces to indent printout
     **/
    void print (unsigned int indent);
    
    /**
     * The variable name
     **/
    std::string name;
    
    /**
     * The variable type
     **/
    int type;
    
    /**
     * The variable scope
     **/
    int scope;
    
    /**
     * The variable classifiers (e.g. const)
     **/
    int classifiers;
    
    /**
     * Description of the number of elements (useful for arrays)
     **/
    std::string elements;
  };

  typedef std::map <std::string, Variable> Variables;
}


#endif // _DAIG_VARIABLE_
