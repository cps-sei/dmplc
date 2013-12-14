

#ifndef _DAIG_INTERPRETER_H_
#define _DAIG_INTERPRETER_H_

/**
 * @file Interpreter.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG interpreter.
 **/

#include <string>
#include <list>
#include <map>
#include "Token.h"

namespace daig
{
    // Forward declaration.
    class Program;

    /**
     * @class Interpreter
     * @brief Parses a MCDA template into a program representation
     */
    class Interpreter
    {
    public:
      /**
       * Constructor
       **/
      Interpreter ();

      /**
       * Destructor
       **/
      virtual ~Interpreter ();

      /**
       * Compiles an expression into an expression tree.
       * @param    input      expression to compile
       * @return   expression tree to evaluate
       **/
      Program interpret (const std::string &input);
      
      /**
       * Checks a character to see if it is a string literal
       * @param    input      char to check
       * @return   true if the input is an operator
       **/
      static bool is_string_literal (char input);

      /**
       * Checks a character to see if it is a mathematical operator
       * @param    input      char to check
       * @return   true if the input is an operator
       **/
      static bool is_operator (char input);

      /**
       * Checks a character to see if it is a number
       * @param    input      char to check
       * @return   true if the input is a number
       **/
      static bool is_number (char input);
      
      /**
       * Checks a character to see if it is alphanumeric
       * @param    input      char to check
       * @return   true if the input is alphanumeric
       **/
      static bool is_alphanumeric (char input);
      
      /**
       * Checks a character to see if it is whitespace
       * @param    input      char to check
       * @return   true if the input is whitespace
       **/
      static bool is_whitespace (char input);
      
      /**
       * Churns through an input string as long as a predicate is true
       * @param    input      input buffer
       * @param    position   the position in the input buffer to start from
       * @param    func       predicate function for checking a char
       * @return   new position in the buffer for parsing
       **/
      static unsigned int churn_input (const std::string & input,
        unsigned int position, bool (*func) (char));
      
      /**
       * Finds a closing parenthesis or brace, depending on the character at
       * the specified position
       * @param    input      input buffer
       * @param    position   the position in the input buffer to start from
       * @return   position of closing element (input.size ()) if failure
       **/
      static unsigned int find_closer (const std::string & input,
        unsigned int position);
      
      /**
       * Churns through an input string as long as a predicate is true
       * @param    input      input buffer
       * @param    position   the position in the input buffer to start from
       * @param    ender      a character that ends the churn
       * @return   new position in the buffer for parsing
       **/
      static unsigned int churn_input_until (const std::string & input,
        unsigned int position, char ender);
      
      /**
       * Churns through an input string as long as a predicate is true
       * @param    input      input buffer
       * @param    position   the position in the input buffer to start from
       * @param    enders     a string of characters that can end the churn
       * @return   new position in the buffer for parsing
       **/
      static unsigned int churn_input_until (const std::string & input,
        unsigned int position, const std::string & enders);
      /**
       * Tokenizes an argument list in parentheses
       * @param    input      input buffer
       * @param    position   the position in the input buffer to start from
       * @param    tokens     arguments to the function
       * @return   new position in the buffer for parsing
       **/
      static unsigned int tokenize_arguments (const std::string & input,
        unsigned int position, Tokens & tokens);

    private:
      /**
       * Handles an alphanumeric starter
       * @param    input      input buffer
       * @param    position   the position in the input buffer
       * @param    program    the current program object for filling
       * @return   new position in the buffer for parsing
       **/
      unsigned int
      handle_alphanumeric (Program & program, const std::string & input,
        unsigned int position);
    };
}

#endif /* _DAIG_INTERPRETER_H_ */
