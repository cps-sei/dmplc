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

#ifndef _DMPL_SPECIFICATION_HPP_
#define _DMPL_SPECIFICATION_HPP_

/**
 * @file Specification.hpp
 * @author Sagar Chaki <chaki@sei.cmu.edu>
 *
 * This file contains a class definition for specifications
 **/

#include <stdio.h>
#include <list>
#include <memory>
#include "Symbol.h"

namespace dmpl
{
  /**
    * @class Specification
    * @brief An abstract base class for all specifications
    */
  class Specification : public SymbolUser, public HasAttributes
  {
  public:
    //-- name of the specification
    std::string name;

    Specification(const std::string &n) : name(n) {}
    
    virtual std::string toString() const = 0;
    virtual void print (std::ostream &os,unsigned int indent) const = 0;
    std::string getName() const { return name; }
  };

  //an expect specification
  class ExpectSpec : public Specification
  {
  public:
    //-- name of function that evaluates the property
    std::string func;

    ExpectSpec(const std::string &n,const std::string &f)
      : Specification(n), func(f) {}
  };

  //an at_end expect specification
  class AtEndSpec : public ExpectSpec
  {
  public:
    AtEndSpec(const std::string &n, const std::string &f) : ExpectSpec(n,f) {}

    std::string toString() const
    {
      return std::string("expect ") + name + " : at_end => " + func;
    }
    
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "expect " << name << " : at_end => " << func << ";\n";
    }
  };

  //an at_least expect specification
  class AtLeastSpec : public ExpectSpec
  {
  public:
    //-- at least threshold. the property holds on an execution if
    //-- func evaluates to true on at least this fraction of the time
    std::string threshold;

    AtLeastSpec(const std::string &n, const std::string &f, const std::string &t)
      : ExpectSpec(n,f), threshold(t) {}

    std::string toString() const
    {
      return std::string("expect ") + name + " : at_least " + threshold + " => " + func;
    }

    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "expect " << name << " : at_least " << threshold
         << " => " << func << ";\n";
    }
  };

  //a require specification
  class RequireSpec : public Specification
  {
  public:
    //-- the target synchronous thread
    std::string thread;

    //-- the function evaluating target property
    std::string func;
    
    RequireSpec(const std::string &n, const std::string &t, const std::string &f)
      : Specification(n), thread(t), func(f) {}

    std::string toString() const
    {
      return std::string("require ") + name + " : " + thread + " => " + func;
    }
    
    void print (std::ostream &os,unsigned int indent) const
    {
      std::string spacer (indent, ' ');
      os << spacer << "require " << name << " : " << thread << " => " << func << ";\n";
    }
  };
}

#endif // _DMPL_SPECIFICATION_HPP_
