#ifndef _DAIG_TYPE_H_
#define _DAIG_TYPE_H_

/**
 * @file Expression.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for an expression.
 **/

#include <stdio.h>
#include <list>
#include <vector>
#include <boost/shared_ptr.hpp>
#include <boost/foreach.hpp>

namespace daig
{
  //forward declaration
  class BaseType;

  //share pointer to a base type -- this is the type we will
  //mostly use
  typedef boost::shared_ptr<BaseType> Type;

  //a list of types
  typedef std::list <Type> TypeList;

  /**
    * @class BaseType
    * @brief A base type
    */
  class BaseType
  {
  public:
    int qual; //qual = 0 means no qualifier
    int type; //the actual type -- void, char, int, bool etc.
    std::list<int> dims; //dimensions -- empty means non-array type

    //constructors
    BaseType() : qual(0),type(-1) {}
    BaseType(int t) : qual(0),type(t) {}
    BaseType(const std::list<int> &d) : qual(0),type(-1),dims(d) {}

    std::string toString() const;
    void setQual(int q) { qual = q; }
    void setDims(const std::list<int> &d) { dims = d; }
  };
}

#endif // _DAIG_TYPE_H_
