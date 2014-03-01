//a class for sequentializing DAIG into a C program

#ifndef __MADARA_SYNC_BUILDER_H__
#define __MADARA_SYNC_BUILDER_H__

#include <iostream>
#include <sstream>
#include "daslc/DaigBuilder.hpp"

namespace daig
{
  namespace madara
  {
    /*******************************************************************/
    // Synchronous program builder for MADARA
    /*******************************************************************/
    class Sync_Builder
    {
    public:
      /**
       * Constructor
       * @param  builder   the source for building a program
       **/
      Sync_Builder (DaigBuilder & builder);

      /**
       * Builds the underlying character stream that can then be printed
       **/
      void build (void);
      
      /**
       * Builds the header includes
       **/
      void build_header_includes (void);

      /**
       * Builds the common global MADARA generated variables
       **/
      void build_common_global_variables (void);
      
      /**
       * Builds the program's MADARA generated variables
       **/
      void build_program_variables (void);
      
      /**
       * Builds the program's MADARA generated variables
       **/
      void build_program_variable (const Variable & var);
      
      /**
       * Builds the program's MADARA generated variable bindings in main
       **/
      void build_program_variables_bindings (void);
      
      /**
       * Builds a MADARA generated variable binding in main
       **/
      void build_program_variable_binding (const Variable & var);

      /**
       * Builds the arguments parser
       **/
      void build_parse_args (void);
      
      /**
       * Builds all function declarations to prevent undefined references
       **/
      void build_functions_declarations (void);
      
      /**
       * Builds a function for refreshing modification flag on globals
       **/
      void build_refresh_modify_globals (void);
      
      /**
       * Builds a refresh statement for modification on a global
       **/
      void build_refresh_modify_global (const Variable & var);

      /**
       * Builds a function
       * @param  function  a defined function in the parsed program
       **/
      void build_function_declaration (daig::Function & function);

      /**
       * Builds the main function
       **/
      void build_main_function (void);

      /**
       * Builds the section of main that defines MADARA callable functions
       **/
      void build_main_define_functions (void);
      
      /**
       * Builds a function definition for MADARA
       * @param  function  a defined function in the parsed program
       **/
      void build_main_define_function (daig::Function & function);

      /**
       * Builds all functions
       **/
      void build_functions (void);

      /**
       * Builds a function
       * @param  function  a defined function in the parsed program
       **/
      void build_function (daig::Function & function);
      
      /**
       * Builds the main logic loop for execution of ROUND
       **/
      void build_main_logic (void);

      /**
       * Clears the underlying buffer
       **/
      void clear_buffer (void);

      /**
       * Prints the MADARA program to a stream
       * @param  os  the stream to print to
       **/
      void print (std::ostream & os);
    private:
      
      /// the result of the DASL parsing function
      DaigBuilder & builder_;

      /// character buffer for holding results of build
      std::stringstream buffer_;
    };
  } // namespace madara
} //namespace daig

#endif //__MADARA_SYNC_H__
