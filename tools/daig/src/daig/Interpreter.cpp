#include <iostream>
#include <sstream>

#include "Interpreter.h"
#include "Program.h"
#include "madara/utility/Utility.h"

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
          std::cout << "Found " << enders[0] <<
            ". num_opens = " << num_opens << "\n";
        }
        else
        {
          --num_opens;
          std::cout << "Found " << enders[1] <<
            ". num_opens = " << num_opens << "\n";
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
    std::cout << "  Found closer which resulted in:\n";
    std::cout << input.substr (position, close_pos - position) << "\n";
  }

  return close_pos;
}

unsigned int
daig::Interpreter::tokenize_arguments (const std::string & input,
        unsigned int position, Tokens & tokens, bool allow_optional)
{
  // \(\s*(\s*token\s*(,\s*token\s*)*)?\)
  
  std::cout << "  Tokenizing arguments...\n";
  // churn past whitespace
  std::cout << "    Churning whitespace...\n";
  unsigned int last_pos = churn_input (input, position, is_whitespace);
  
  std::cout << "    Checking for parenthesis...\n";
  if (last_pos < input.size () && input[last_pos] == '(')
  {
    unsigned int args_start = last_pos + 1;
    
    std::cout << "    Churning whitespace...\n";
    // churn past whitespace
    args_start = churn_input (input, args_start, is_whitespace);
    unsigned int arg_start = last_pos = args_start;
  
    std::cout << "    Tokenizing arguments...\n";
    while (last_pos < input.size () && input[last_pos] != ')')
    {
      std::cout << "    Churning input until ','...\n";
      last_pos = churn_input_until (input, arg_start, "(,)");

      // if we have a nested argument list, then find our closer
      if (last_pos < input.size () && input[last_pos] == '(')
      {
        last_pos = find_closer (input, last_pos);
      }

      if (last_pos - arg_start > 0)
      {
        std::string token = input.substr (arg_start, last_pos - arg_start);
        std::cout << "    Found token " << token << " between " 
          << arg_start << " and " << last_pos << "...\n";
        tokens.push_back (new Token (token));
      }
      else
      {
        std::cerr << "TEMPLATE ERROR: Argument list has double commas" <<
                      " at pos[" <<
                      args_start << "-" << last_pos << "]\n";
        exit (-1);
      }
      
      // Increment unless we are the closing parenthesis
      if (input[last_pos] != ')')
      {
        ++last_pos;
      }

      std::cout << "    Churning whitespace...\n";
      last_pos = churn_input (input, last_pos, is_whitespace);
      arg_start = last_pos;
    }
    

    if (last_pos < input.size () && input[last_pos] == ')')
    {
      ++last_pos;
      std::cout << "    Argument list closed\n";
    }
    else
    {
      std::cerr << "TEMPLATE ERROR: Argument list not closed." <<
                    "Check for parentheses next to MOC declaration at pos[" <<
                    args_start << "-" << last_pos << "]\n";
      exit (-1);
    }
  }
  else if (!allow_optional)
  {
    std::cerr << "TEMPLATE ERROR: Argument list must start with parenthesis\n";
    exit (-1);
  }

  return last_pos;
}

unsigned int
daig::Interpreter::handle_alphanumeric (
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

  std::cerr << "Found alphanumeric token " << token << "\n";

  // look for special tokens
  if (token_copy == "MOC")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);

    if (arguments.size () == 1)
      program.moc.set_type (arguments[0]->to_string ());
    else
    {
      std::cerr << "MOC must only have 1 argument.\n";
      exit (-1);
    }
  }
  else if (token == "CONST")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);
    
    std::cerr << "CONST arguments are : ";
    for (unsigned int i = 0; i < arguments.size (); ++i)
    {
      std::cerr << arguments[i]->to_string ();

      if (i != arguments.size () - 1)
        std::cerr << ", ";
    }
    std::cerr << "\n";

    Variable var;
    var.classifiers = Variable::CONST_VAR;
    var.name = arguments[0]->to_string ();
    var.value = arguments[1]->to_string ();

    program.variables[var.name] = var;
  }
  else if (token == "PRIVATE" || token == "PUBLIC" || token == "GLOBAL")
  {
    Tokens arguments;
    last_pos = tokenize_arguments (input, last_pos, arguments);
    
    std::cout << "PRIVATE arguments are : ";
    for (unsigned int i = 0; i < arguments.size (); ++i)
    {
      std::cerr << arguments[i]->to_string ();

      if (i != arguments.size () - 1)
        std::cerr << ", ";
    }
    std::cerr << "\n";
    
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

    if (arguments.size () > 1)
      program.processes = arguments.size ();
    else if (arguments.size () == 1)
    {
      std::stringstream buffer (arguments[0]->to_string ());
      buffer >> program.processes;
    }
    
    std::cout << "  Changed processes to " << program.processes << "\n";
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
      std::cout << "  Added function " << function.name << " to program...\n";
    }
    else
    {
      std::cout << "  Function " << token << " was not added to program...\n";
    }

    last_pos = closing_brace + 1;
  }

  return last_pos;
}

daig::Program
daig::Interpreter::interpret (const std::string & input)
{
  Program program;

  unsigned int i = 0; 
  while (i < input.size ())
  {
    // check for alphanumeric sequences
    if (is_alphanumeric (input[i]))
      i = handle_alphanumeric (program, input, i);

    // check for one line comments
    else if (input[i] == '/' && i + 1 < input.size () && input[i+1] == '/')
    {
      std::cout << "Skipping line of comments...\n";
      i = churn_input_until (input, i, '\n');
      ++i;
    }
    else
      ++i;
  }

  return program;
}

