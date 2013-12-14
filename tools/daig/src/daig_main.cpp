
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
    input = Madara::Utility::file_to_string (argv[1]);
  }
  else
  {
    std::cerr << "Error: Must provide file for reading\n";
    return 1;
  }
  
  daig::Interpreter interpreter;
  daig::Program program = interpreter.interpret (input);

  std::cout << "Finished parsing... RESULTS:\n\n";
  std::cout << "Program::moc: " << program.moc.to_string_type () << "\n";
  std::cout << "Program::processes: " << program.processes << "\n";
  std::cout << "Program::variables:\n";

  for (daig::Variables::iterator i = program.variables.begin ();
       i != program.variables.end (); ++i)
  {
    i->second.print (2);
  }
  
  std::cout << "Program::functions:\n";

  for (daig::Functions::iterator i = program.functions.begin ();
       i != program.functions.end (); ++i)
  {
    i->second.print (2);
  }

  return 0;
}