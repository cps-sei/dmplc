
#include <iostream>
#include <fstream>
#include <string>
#include <vector>

#include "madara\utility\Utility.h"
#include "daig\Interpreter.h"
#include "daig\Program.h"

int main (int argc, char **argv)
{
  std::string input;
  

  if (argc > 1)
  {
    if (Madara::Utility::file_exists (argv[1]))
    {
      std::cout << "Reading file " << argv[1] << "...\n";
      input = Madara::Utility::file_to_string (argv[1]);
    }
    else
    {
      std::cerr << "ERROR: " << argv[1] << "file does not exist.\n";
      return 2;
    }
  }
  else
  {
    std::cerr << "Error: Must provide file for reading\n";
    return 1;
  }
  
  daig::Interpreter interpreter;
  daig::Program program = interpreter.interpret (input);

  std::cout << "Finished parsing " << argv[1] << "...\nRESULTS:\n\n";

  program.print (0);

  return 0;
}