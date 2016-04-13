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

#ifndef _DMPL_ATTRIBUTE_H_
#define _DMPL_ATTRIBUTE_H_

#include <iostream>
#include <vector>
#include <exception>
#include <map>
#include <string>

namespace dmpl
{
  //forward declaration
  class Expression;

  //share pointer to a base expression -- this is the type we will
  //mostly use
  typedef std::shared_ptr<Expression> Expr;
  typedef std::shared_ptr<Expression const> CExpr;

  //a list of expressions
  typedef std::list <Expr> ExprList;

  /*******************************************************************/
  //-- a class representing an attribute
  /*******************************************************************/
  class Attribute
  {
  public:
    //-- attribute name
    std::string name;
    //-- attribute parameters (if any)
    ExprList paramList;

    //-- default constructor
    Attribute() {}
    //-- constructor with name
    Attribute(const std::string &n) : name(n) {}
    //-- constructor with name and parameters
    Attribute(const std::string &n, const ExprList &p) : name(n),  paramList(p) {}

    //-- return a string representation
    std::string toString() const;

    //-- equality operator
    bool operator == (const Attribute &rhs) const
    {
      return toString() == rhs.toString();
    }
    
    //-- if attribute has a single parameter, return it. otherwise,
    //-- throw an exception.
    Expr requireSingleParam()
    {
      if(paramList.size() != 1)
        throw std::runtime_error("Expected 1 parameter for attribute @" + name + ".");
      return paramList.front();
    }
  };

  /*******************************************************************/
  //-- map from names to attributes
  /*******************************************************************/
  typedef std::map <std::string, Attribute> Attributes;

  /*******************************************************************/
  //-- a base class denoting all classes that have attributes
  /*******************************************************************/
  class HasAttributes
  {
  public:
    Attributes attrs;

    HasAttributes() {}
    HasAttributes(const Attributes &a) : attrs(a) { }

    const Attribute *getAttribute(std::string name) const
    {
      auto it = attrs.find(name);
      if(it == attrs.end()) return NULL;
      return &(it->second);
    }

    const Attribute *getAttribute(std::string name, int expectedArgs) const
    {
      auto it = attrs.find(name);
      if(it == attrs.end()) return NULL;
      if(it->second.paramList.size() != expectedArgs) return NULL;
      return &(it->second);
    }

    const Attribute &requireAttribute(std::string name) const
    {
      const Attribute *ret = getAttribute(name);
      if (ret == NULL)
        throw std::runtime_error("Required attribute @" + name + " not found!!");
      return *ret;
    }

    const Attribute &requireAttribute(std::string name, int expectedArgs) const
    {
      auto it = attrs.find(name);
      if (it == attrs.end())
        throw std::runtime_error("Required attribute @" + name + " not found!!");
      else if (it->second.paramList.size() != expectedArgs)
        throw std::runtime_error("Required attribute @" + name
                                 + " must have " + std::to_string(expectedArgs)
                                 + " arguments; has "
                                 + std::to_string(it->second.paramList.size()));
      else
        return it->second;
    }

    //-- merge attributes from another. check for mismatched parameter
    //-- list. return true on success, and false on failure.
    bool mergeAttributes(const HasAttributes &other)
    {
      for(const auto &a : other.attrs) {
        auto r = attrs.insert(a);
        if(r.second) continue;
        //-- error check
        if(!(*r.first == a)) {
          std::cerr << "ERROR: could not merge attributes " << r.first->second.toString()
                    << " and " << a.second.toString() << '\n';
          return false;
        }
      }
      //-- success
      return true;
    }
    
    //-- copy attributes from another. do not overwrite, but check for
    //-- mismatched parameter list sizes. return true on success, and
    //-- false on failure.
    bool addAttributes(const HasAttributes &other)
    {
      for(const auto &a : other.attrs) {
        auto r = attrs.insert(a);
        if(r.second) continue;
        //-- error check
        if(r.first->second.paramList.size() != a.second.paramList.size()) {
          std::cerr << "ERROR: attributes with mismatched parameter number "
                    << r.first->second.toString()
                    << " and " << a.second.toString() << '\n';
          return false;
        }
      }
      //-- success
      return true;
    }

  };
}

#endif // _DMPL_ATTRIBUTE_H_
