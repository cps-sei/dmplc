#include "Token.h"

daig::Token::Token ()
{

}

daig::Token::Token (const std::string & new_value)
  : value (new_value)
{
}

daig::Token::~Token ()
{
}

std::string
daig::Token::to_string (void)
{
  return value;
}