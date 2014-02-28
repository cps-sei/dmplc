//a class for sequentializing DAIG into a C program

#ifndef __MADARA_SYNC_BUILDER_H__
#define __MADARA_SYNC_BUILDER_H__

#include <iostream>
#include "daslc/DaigBuilder.hpp"

namespace daig
{
  namespace madara
  {
    /*******************************************************************/
    // Synchronous program builder for MADARA
    /*******************************************************************/
    class SyncBuilder
    {
    public:
      /**
       * Constructor
       * @param  builder   the source for building a program
       **/
      SyncBuilder (DaigBuilder & builder);

      /**
       * Builds the underlying character stream that can then be printed
       **/
      void build (void);

      /**
       * Prints the MADARA program to a stream
       * @param  os  the stream to print to
       **/
      void print (std::ostream & os);
    private:
      
      DaigBuilder & builder_;   
    };
  } // namespace madara
} //namespace daig

#endif //__MADARA_SYNC_H__
