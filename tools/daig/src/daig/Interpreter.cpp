#include <iostream>
#include <sstream>

#include "Interpreter.h"
#include "Program.h"
#include "madara/utility/Utility.h"
#include "madara/utility/Log_Macros.h"

// constructor
daig::Interpreter::Interpreter ()
{
}

// destructor
daig::Interpreter::~Interpreter ()
{
}

// method for checking if a character is a valid operator
bool
daig::Interpreter::is_operator (char input)
{
  return input == '+' 
    || input == '-' 
    || input == '*' 
    || input == '/' || input == '%';
}

// method for checking if a character is a number
bool
daig::Interpreter::is_number (char input)
{
  return input >= '0' && input <= '9';
}

// method for checking if a character is a number
bool
daig::Interpreter::is_string_literal (char input)
{
  return input == '"' || input == '\'';
}

// method for checking if a character is a candidate
// for a part of a variable name
bool
daig::Interpreter::is_alphanumeric (char input)
{
  return (input >= 'a' && input <= 'z') 
    || (input >= 'A' && input <= 'Z') 
    || (input == '_') 
    || (input >= '0' && input <= '9') || input == '.' 
    ;
}

// method for checking if input is whitespace
bool
daig::Interpreter::is_whitespace (char input)
{
  return input == ' ' || input == '\t' || input == '\r' || input == '\n';
}

unsigned int
daig::Interpreter::churn_input (const std::string & input,
  unsigned int position,
  bool (*func) (char))
{
  while (position < input.size () && func (input[position]))
    ++position;

  return position;
}

unsigned int
daig::Interpreter::churn_input_until (const std::string & input,
  unsigned int position,
  char ender)
{
  while (position < input.size () && input[position] != ender)
    ++position;

  return position;
}

unsigned int
daig::Interpreter::churn_input_until (const std::string & input,
  unsigned int position,
  const std::string & enders)
{
  while (position < input.size ()
    && enders.find (input[position]) == enders.npos)
    ++position;

  return position;
}

unsigned int
daig::Interpreter::churn_input_until (const std::string & input,
        unsigned int position, bool (*func) (char))
{
  while (position < input.size ()
    && !func (input[position]))
    ++position;

  return position;
}

unsigned int
daig::Interpreter::find_closer (const std::string & input,
  unsigned int position)
{
  unsigned int close_pos = input.size ();

  if (position < input.size ())
  {
    int num_opens = 1;
    std::string enders = "()";

    if (input[position] == '{')
    {
      enders = "{}";
    }
    
    close_pos = position + 1;

    while (close_pos < input.size () && num_opens > 0)
    {
      close_pos = churn_input_until (input, close_pos, enders);
      if (close_pos < input.size ())
      {
        if (enders[0] == input[close_pos])
        {
          ++num_opens;
          
          MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
            "INTERPRETER: Found %c. num_opens = %d\n",
            enders[0], num_opens));
        }
        else
        {
          --num_opens;

          MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
            "INTERPRETER: Found %c. num_opens = %d\n",
            enders[1], num_opens));
        }

        if (num_opens > 0)
          ++close_pos;
      }
      else
      {
        std::cerr << "TEMPLATE ERROR: Could not find matching " << enders[1] <<
          " in " << input.substr (position, input.size () - position - 1) <<
          "\n";
        exit (-1);
      }
    }
  }

  if (close_pos < input.size ())
  {
    MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
      "INTERPRETER: Found closer which resulted in:\n %s\n",
      input.substr (position, close_pos - position).c_str ()));
  }

  return close_pos;
}

unsigned int
daig::Interpreter::tokenize_arguments (const std::string & input,
        unsigned int position, Tokens & tokens, bool allow_optional)
{
  // \(\s*(\s*token\s*(,\s*token\s*)*)?\)
  
  MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
    "INTERPRETER: Tokenizing arguments...n"));

  // churn past whitespace

  MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
    "INTERPRETER: Churning whitespace...n"));

  unsigned int last_pos = churn_input (input, position, is_whitespace);
  
  MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
    "INTERPRETER: Checking for parenthesis...n"));

  if (last_pos < input.size () && input[last_pos] == '(')
  {
    ++last_pos;
    unsigned int function_start = last_pos;

    std::string enders ("(),");  
    unsigned int num_opens = 1, token_start;
    last_pos = token_start = churn_input (input, last_pos, is_whitespace);
    
    while (last_pos < input.size ())
    {
      if (input[last_pos] == ',' && num_opens == 1)
      {
        /**
         * only create a token if we have one parentheses open. Otherwise, the
         * comma belongs to an internal parenthesis
         **/
        tokens.push_back (
          new Token (input.substr (token_start, last_pos - token_start)));
        last_pos = token_start = churn_input (
          input, last_pos + 1, is_whitespace);
      }
      else if (input[last_pos] == '(')
      {
        ++num_opens;
      }
      else if (input[last_pos] == ')')
      {
        --num_opens;
        if (num_opens == 0)
        {
          // we have reached the end of the argument list
          if (token_start != last_pos)
            tokens.push_back (
              new Token (input.substr (token_start, last_pos - token_start)));
          break;
        }
      }

      last_pos = churn_input_until (input, last_pos + 1, enders);
    }

    ++last_pos;
  }

  return last_pos;
}

void
daig::Interpreter::handle_node (
  const std::string & input,
  Node & node)
{
  unsigned int position = 0, last_pos = 0; 
  while (position < input.size ())
  {
    // check for alphanumeric sequences
    if (is_alphanumeric (input[position]))
    {
      // churn until end of token
      unsigned int last_pos = churn_input (input, position, is_alphanumeric);

      std::string token = input.substr (position, last_pos - position);
      std::string token_copy (token);

      // make an uppercase copy
      Madara::Utility::upper (token_copy);
      
      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Found token %s in node.\n", token.c_str ()));

      if (token == "CONST")
      {
        Tokens arguments;
        last_pos = tokenize_arguments (input, last_pos, arguments);
    
        MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
          "INTERPRETER: Found %d arguments in CONST.n", arguments.size ()));

        //std::cerr << "CONST arguments are : ";
        //for (unsigned int i = 0; i < arguments.size (); ++i)
        //{
        //  std::cerr << arguments[i]->to_string ();

        //  if (i != arguments.size () - 1)
        //    std::cerr << ", ";
        //}
        //std::cerr << "\n";

        Variable var;
        var.classifiers = Variable::CONST_VAR;
        var.name = arguments[0]->to_string ();
        var.value = arguments[1]->to_string ();

        node.variables[var.name] = var;
      }
      else if (token == "PRIVATE" || token == "PUBLIC" || token == "GLOBAL")
      {
        MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
          "INTERPRETER: Found %s variable.n", token.c_str ()));

        Tokens arguments;
        last_pos = tokenize_arguments (input, last_pos, arguments);
    
        MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
          "INTERPRETER: Found %d arguments.n", arguments.size ()));

        //std::cout << token << " arguments are : ";
        //for (unsigned int i = 0; i < arguments.size (); ++i)
        //{
        //  std::cerr << arguments[i]->to_string ();

        //  if (i != arguments.size () - 1)
        //    std::cerr << ", ";
        //}
        //std::cerr << "\n";
    
        Variable var;

        if (token == "PRIVATE")
          var.scope = Variable::PRIVATE;
        else
          var.scope = Variable::GLOBAL;

        if (arguments.size () > 0)
        {
          std::string arg1 = arguments[0]->to_string ();
          unsigned int pos = churn_input_until (arg1, 0, is_whitespace);

          if (pos < arg1.size ())
          {
            std::string type = arg1.substr (0, pos);
            Madara::Utility::upper (type);

            var.set_type (type);

            unsigned int var_start = arg1.rfind (' ');
            if (var_start != arg1.npos)
            {
              ++var_start;
              var.name = arg1.substr (var_start, arg1.size () - var_start);
              node.variables[var.name] = var;
         
              MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
                "INTERPRETER: Added %s %s to node.n",
                token.c_str (), var.name.c_str ()));
            }
          }
          else
          {
            var.name = arg1;
            node.variables[var.name] = var;

            MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
              "INTERPRETER: Added %s %s to node.n",
              token.c_str (), var.name.c_str ()));
          }

          for (unsigned cur_var = 1; cur_var < arguments.size (); ++cur_var)
          {
            var.name = arguments[cur_var]->to_string ();
            node.variables[var.name] = var;

            MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
              "INTERPRETER: Added %s %s to node.n",
              token.c_str (), var.name.c_str ()));
          }
        }
        else
        {
          std::cerr << "ERROR: Could not construct " << token 
            << " variable. No arguments.\n";
          exit (-1);
        }
      }
      else
      {
        Tokens arguments;
        last_pos = tokenize_arguments (input, last_pos, arguments, true);
    
        unsigned int brace = last_pos = churn_input_until (input, last_pos, "{");
        unsigned int closing_brace = find_closer (input, brace);

        if (closing_brace < input.size ())
        {
          Function function;
          function.name = token;
          function.args = arguments;
          function.body = input.substr (brace + 1, closing_brace - brace - 1);
          node.functions[token] = function;
          MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
            "INTERPRETER: Added %s function to node.n",
            function.name.c_str ()));
        }
        else
        {
          MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
            "INTERPRETER: %s function could not be added "
            "to node (no closing brace).n",
            token.c_str ()));
        }

        last_pos = closing_brace + 1;
      }
      position = last_pos;
    }

    // check for one line comments
    else if (input[position] == '/' && 
      position + 1 < input.size () && input[position+1] == '/')
    {
      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Skipping line of comments.n"));

      position = churn_input_until (input, position, '\n');
      ++position;
    }
    else
      ++position;
  }
}

void
daig::Interpreter::handle_expression (
  const std::string & input,
  Tokens & tokens)
{

}

unsigned int
daig::Interpreter::handle_program (
  Program & program,
  const std::string & input,
  unsigned int position)
{
  // churn until end of token
  unsigned int last_pos = churn_input (input, position, is_alphanumeric);

  std::string token = input.substr (position, last_pos - position);
  std::string token_copy (token);

  // make an uppercase copy
  Madara::Utility::upper (token_copy);
  
  MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
    "INTERPRETER: Found token %s in program.\n", token.c_str ()));

  // look for special tokens
  if (token_copy == "MOC")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);

    if (arguments.size () == 1)
      program.moc.set_type (arguments[0]->to_string ());
    else
    {
      std::cerr << "ERROR: MOC must only have 1 argument.\n";
      exit (-1);
    }
  }
  else if (token == "CONST")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);
    
    MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
      "INTERPRETER: Found %d arguments in CONST.\n", arguments.size ()));

    Variable var;
    var.classifiers = Variable::CONST_VAR;
    var.name = arguments[0]->to_string ();
    var.value = arguments[1]->to_string ();

    program.variables[var.name] = var;
  }
  else if (token == "GLOBAL")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);
    
    MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
      "INTERPRETER: Found %d arguments in GLOBAL.\n", arguments.size ()));

    Variable var;

    if (token == "PRIVATE")
      var.scope = Variable::PRIVATE;
    else
      var.scope = Variable::GLOBAL;

    var.name = arguments[1]->to_string ();
    var.value = arguments[0]->to_string ();

    program.variables[var.name] = var;
  }
  else if (token == "PROGRAM")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);
    
    MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
      "INTERPRETER: Found %d arguments in PROGRAM.\n", arguments.size ()));

    if (arguments.size () > 1)
      program.processes = arguments.size ();
    else if (arguments.size () == 1)
    {
      std::stringstream buffer (arguments[0]->to_string ());
      buffer >> program.processes;
    }
    
    MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
      "INTERPRETER: Changed processes to %d.\n", program.processes));
  }
  else if (token == "NODE")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments, true);
    
    unsigned int brace = last_pos = churn_input_until (input, last_pos, "{");
    unsigned int closing_brace = find_closer (input, brace);

    if (closing_brace < input.size ())
    {
      Node node;
      node.args = arguments;
      node.body.value = input.substr (brace + 1, closing_brace - brace - 1);

      handle_node (node.body.value, node);

      program.nodes.push_back (node);
      
      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Added a node to the program.\n", program.processes));
    }
    else
    {
      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Unable to add node to the program. "
        "No closing brace.\n"));
    }

    last_pos = closing_brace + 1;
  }
  else
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments, true);
    
    unsigned int brace = last_pos = churn_input_until (input, last_pos, "{");
    unsigned int closing_brace = find_closer (input, brace);

    if (closing_brace < input.size ())
    {
      Function function;
      function.name = token;
      function.args = arguments;
      function.body = input.substr (brace + 1, closing_brace - brace - 1);
      program.functions[token] = function;

      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Added function %s to program.\n",
        function.name.c_str ()));
    }
    else
    {
      MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
        "INTERPRETER: Unable to add function %s to program. "
        "No closing brace.",
        token.c_str ()));
    }

    last_pos = closing_brace + 1;
  }

  return last_pos;
}

daig::Program
daig::Interpreter::interpret (const std::string & input)
{
  MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
    "INTERPRETER: Interpreting input of size %d.\n",
    input.size ()));

  Program program;
  
  unsigned int i = 0; 
  while (i < input.size ())
  {
    // check for alphanumeric sequences
    if (is_alphanumeric (input[i]))
      i = handle_program (program, input, i);

    // check for one line comments
    else if (input[i] == '/' && i + 1 < input.size () && input[i+1] == '/')
    {
      MADARA_DEBUG (MADARA_LOG_DETAILED_TRACE, (LM_DEBUG,
        "INTERPRETER: Skipping line of comments.\n"));

      i = churn_input_until (input, i, '\n');
      ++i;
    }
    else
      ++i;
  }
  
  MADARA_DEBUG (MADARA_LOG_MINOR_EVENT, (LM_DEBUG,
    "INTERPRETER: Finished interpreting input of size %d.\n",
    input.size ()));

  return program;
}

