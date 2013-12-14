#ifndef _DAIG_TOKEN_H_
#define _DAIG_TOKEN_H_

/**
 * @file Token.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for a basic parsing token.
 **/

#include <vector>
#include <string>

namespace daig
{
  /**
    * @class Token
    * @brief Smallest atomic unit of a parsing tree
    */
  class Token
  {
  public:
    /**
     * Default constructor
     **/
    Token ();

    /**
     * Value constructor
     **/
    Token (const std::string & value);

    /**
     * Destructor
     **/
    ~Token ();
    
    /**
     * Returns value as string
     **/
    virtual std::string to_string (void);

    /**
     * The stringified contents of the token
     **/
    std::string value;
  };

  typedef std::vector <Token *> Tokens;
}

#endif // _DAIG_TOKEN_H_
