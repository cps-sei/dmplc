#ifndef _DAIG_MODEL_OF_COMPUTATION_H_
#define _DAIG_MODEL_OF_COMPUTATION_H_

/**
 * @file Model_Of_Computation.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DAIG model of computation.
 **/

#include <string>

namespace daig
{
  /**
    * @class Model_Of_Computation
    * @brief Contains information about the model of computation
    */
  class Model_Of_Computation
  {
  public:

    enum Types
    {
      SYNC,
      ASYNC,
      PARTIAL
    };

    /**
     * Constructor
     **/
    Model_Of_Computation ();

    /**
     * Sets the type based on a string
     * @param  str_type    string identifier of type.
     *                     SYNC, ASYNC, or PARTIAL
     **/
    void set_type (const std::string & str_type);

    /**
     * Returns the stringified version of the type
     * @return  SYNC, ASYNC, or PARTIAL
     **/
    std::string to_string_type (void);

    /**
     * Holds the type of model of computation
     **/
    int type;
  };
}


#endif // _DAIG_MODEL_OF_COMPUTATION_H_
