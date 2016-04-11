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

#ifndef _DMPL_VARIABLE_
#define _DMPL_VARIABLE_

/**
 * @file Variable.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DMPL model of computation.
 **/

#include <map>
#include <string>
#include <exception>
#include <memory>
#include "Type.h"
#include "Symbol.h"

namespace dmpl
{
  class Expression;
  typedef std::shared_ptr<Expression> Expr;

  /**
    * @class Variable
    * @brief A variable
    */
  class Variable : public Symbol
  {
  public:

    /**
     * The variable name
     **/
    std::string name;

    virtual std::string getName() const { return name; }
    
    /**
     * The variable type
     **/
    Type type;

    virtual const Type &getType() { return type; }
    
    /**
     * The variable scope
     **/
    int scope;

    /**
     * Is the variable an input ?
     **/
    bool isInput;

    /**
     * Is the variable overriding another
     **/
    bool isOverride;

    /**
     * The function initializing the variable
     **/
    Func initFunc;
    
    /**
     * The name of the record to which this variable belongs
     **/
    std::string record;
    
    virtual int getScope() { return scope; }

    Func owner;

    FuncList readers;
    FuncList writers;

    //constructors
    Variable() : scope(0), isInput(false), isOverride(false) {}
    Variable(const std::string &n);
    Variable(const std::string &n,const Type &t);
    Variable(const std::string &n,const Dims &d);

    //equality operator. compares name, scope and type.
    bool operator == (const Variable &rhs) const
    {
      if(this == &rhs) return true;
      return (name == rhs.name && scope == rhs.scope && *type == *(rhs.type));
    }
    
    //convert to string
    std::string toString() const;

    /**
     * Prints variable information
     * @param  indent  spaces to indent printout
     **/
    void print (std::ostream &os,unsigned int indent);

    /**
     * Prints variable with initialization, if any
     * @param  indent  spaces to indent printout
     **/
    void printInit (std::ostream &os,unsigned int indent);

    /**
     * Prints variable in C syntax (e.g., no input keyword)
     * @param indent spaces to indent printout
     **/
    void printC (std::ostream &os,unsigned int indent);

    ///return a copy but instantiate dimension #N with nodeNum
    Var instDim(size_t nodeNum) const;

    ///return a copy but change name to name+ext
    Var instName(std::string ext) const;

    ///return a copy with one less dimension
    Var decrDim() const;

    ///return a copy with one more dimension (added at front)
    Var incrDim(int d) const;

    ///return the initial expression for the variable. this assumes
    ///that the variable was initialized via direct assignment and not
    ///a constructor. the return value is the RHS of the first
    ///statement in the body of the constructor.
    Expr initExpr() const;

    ///return the expression constraining the value of the variable
    ///(assuming it is an input), i.e., the return value of the single
    ///return statement in the body of the initializer function.
    Expr assumeExpr() const;

    ///check sanity of constructor
    void checkConstructorSanity(const Node &node, const Role &role) const;

    ///return the scope as a string
    std::string scopeStr() const
    {
      if(scope == Variable::LOCAL) return "local";
      if(scope == Variable::GLOBAL) return "global";
      if(scope == Variable::GROUP) return "group";
      throw std::runtime_error("ERROR: variable " + name + " has illegal scope " +
                               std::to_string(scope) + "!!");
    }
  };

  inline Var Symbol::asVar()
  {
    return std::dynamic_pointer_cast<Var::element_type>(shared_from_this());
  }
}



#endif // _DMPL_VARIABLE_
