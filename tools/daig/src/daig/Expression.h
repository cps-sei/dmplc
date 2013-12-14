#ifndef _DAIG_EXPRESSION_H_
#define _DAIG_EXPRESSION_H_

/**
 * @file Expression.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for an expression.
 **/

#include <vector>
#include "Token.h"

namespace daig
{
  /**
    * @class Expression
    * @brief A composition of tokens
    */
  class Expression
  {
  public:
    /**
     * the contents of the expression
     **/
    Tokens tokens;
  };

  typedef std::vector <Expression> Expressions;
}

#endif // _DAIG_EXPRESSION_H_
