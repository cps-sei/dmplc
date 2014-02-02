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
    * @brief An abstract base class
    */
  class BaseType
  {
  public:
    virtual std::string toString() const = 0;
  };

  //a simple type
  class SimpType : public BaseType
  {
  public:
    int data;
    SimpType(int d) : data(d) {}
    std::string toString() const;
  };
}

#endif // _DAIG_TYPE_H_
