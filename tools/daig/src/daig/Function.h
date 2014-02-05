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

    ///the return type of the function
    Type retType;

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
    std::list<Stmt> body;

    //constructors
    Function() {}
    Function(const Type &rt,const std::string &n,const std::list<Variable> &p,
             const std::list<Variable> &t,const std::list<Stmt> &b)
      : retType(rt),name(n),body(b)
    {
      BOOST_FOREACH(const Variable &v,p) params[v.name] = v;
      BOOST_FOREACH(const Variable &v,t) temps[v.name] = v;
    }
    
    /**
     * Prints function information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);
  };

  typedef std::map <std::string, Function> Functions;
}

#endif // _DAIG_FUNCTION_H_
