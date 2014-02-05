#include <assert.h>
#include "Model_Of_Computation.h"
#include "madara/utility/Utility.h"

daig::Model_Of_Computation::Model_Of_Computation ()
  : type (SYNC)
{

}

void
daig::Model_Of_Computation::set_type (const std::string & str_type)
{
  std::string type_copy (str_type);
  Madara::Utility::upper (type_copy);
  if (type_copy == "SYNC")
    type = SYNC;
  else if (type_copy == "ASYNC")
    type = ASYNC;
  else if (type_copy == "PARTIAL")
    type = PARTIAL;
}

std::string
  daig::Model_Of_Computation::to_string_type (void)
{
  if (type == SYNC) return "MOC_SYNC";
  else if (type == ASYNC) return "MOC_ASYNC";
  else if (type == PARTIAL) return "MOC_PSYNC";
  else assert(0 && "ERROR: illegal MOC type");
}
