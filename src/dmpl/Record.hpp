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

#ifndef _DMPL_RECORD_HPP_
#define _DMPL_RECORD_HPP_

/**
 * @file Record.hpp
 * @author Sagar Chaki <chaki@sei.cmu.edu>
 *
 * This file contains a class definition for records
 **/

#include <stdio.h>
#include <list>
#include <memory>
#include "Symbol.h"

namespace dmpl
{
  /**
    * @class RceordBase
    * @brief An abstract base class for records
    */
  class RecordBase : public Symbol, public SymbolUser
  {
  public:
    //-- name of the record
    std::string name;

    //-- the type. this is always a record type
    Type type;

    //-- list of variables in the record
    VarList vars;

    /**
     * Is the record overriding another
     **/
    bool isOverride;

    //-- initializer, if any
    Func initFunc;

    //-- assume function, if any
    Func assumeFunc;
    
    //-- constructors
    RecordBase(const std::string &n,const VarList &v)
      : name(n), type(recordType()), vars(v), isOverride(false) {}
    RecordBase(const std::string &n,const VarList &v,const Func &ifn, const Func &afn)
      : name(n), type(recordType()), vars(v), isOverride(false), initFunc(ifn), assumeFunc(afn) {}

    //-- equality operator. compares name and variables.
    bool operator == (const RecordBase &rhs) const;

    //-- return the type
    virtual const Type &getType() { return type; }
    
    void print (std::ostream &os,unsigned int indent) const;
    std::string getName() const { return name; }

    //-- return a string representation. just the name.
    std::string toString() const { return "record : " + name; }
  };
}

#endif // _DMPL_RECORD_HPP_
