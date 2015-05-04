#ifndef _MADARA_STORAGE_MANAGER_HPP
#define _MADARA_STORAGE_MANAGER_HPP

#include <utility>
#include <memory>
#include <string>
#include <vector>
#include <climits>
#include <cassert>
#include <sstream>
#include <typeinfo>
#include <exception>
#include <madara/knowledge_engine/Thread_Safe_Context.h>
#include <madara/knowledge_engine/Thread_Safe_Context.h>
#include <madara/knowledge_engine/Knowledge_Update_Settings.h>
#include "knowledge_cast.hpp"
#include "ArrayReference.hpp"

#if __cplusplus >= 201103L
#include <array>

#define USE_RVAL_REF
#define USE_VAR_TMPL
#define USE_STD_ARRAY
#define USE_UNIQUE_PTR
#define USE_EMPLACE
#define USE_USING_TYPE
#define USE_STATIC_ASSERT
#endif

namespace Madara
{

namespace Knowledge_Engine
{

namespace Containers
{

namespace StorageManager
{

template <typename T>
struct get_sm_info
{
  typedef __INTERNAL__::Stateless<T> sm_type;
  typedef T data_type;
};

}

}
}
}
#endif
