#ifndef DMPL_STORAGE_MANAGER_FWD_HPP
#define DMPL_STORAGE_MANAGER_FWD_HPP

namespace Madara
{

namespace KnowledgeEngine
{

namespace Containers
{

namespace StorageManager
{

namespace detail
{
using namespace ::Madara::KnowledgeEngine::Containers::detail;

template<typename T>
class Stateless;

template<typename T>
struct get_sm_info;

template <typename T>
struct get_sm_info
{
  typedef detail::Stateless<T> sm_type;
  typedef T data_type;
  typedef T storage_type;
};
}

}
}
}
}

#endif
