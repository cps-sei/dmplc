#ifndef _MADARA_ARRAY_HPP
#define _MADARA_ARRAY_HPP

#include <utility>
#include <memory>
#include <string>
#include <vector>
#include <climits>
#include <sstream>
#include <typeinfo>
#include <exception>
#include <madara/knowledge_engine/Knowledge_Base.h>
#include <madara/knowledge_engine/Thread_Safe_Context.h>
#include <madara/knowledge_engine/Knowledge_Update_Settings.h>
#include "knowledge_cast.hpp"
#include "Container.hpp"

#if __cplusplus >= 201103L
#include <array>

#define USE_RVAL_REF
#define USE_VAR_TMPL
#define USE_STD_ARRAY
#endif

namespace Madara
{

namespace Knowledge_Engine
{
namespace Containers
{

namespace __INTERNAL__
{

class Array_Base;

template<typename T, typename R = typename T::value_type>
class reference : protected reference<typename T::subarray_type, R>
{
public:
  typedef reference<T, R> index_as_type;
  typedef reference<typename T::subarray_type, R> sub_type;
  typedef typename sub_type::index_as_type indexed_type;

  friend class Array_Base;
  friend class identity<T>::type;
  friend class identity<reference<typename T::subarray_type, R> >::type;
  friend class identity<reference<Array_Base, R> >::type;

  /**
   * C++11 support is highly recommended for multi-dimensional arrays;
   * without it, each index operation creates pointless copies of reference
   * object
   */
#ifdef USE_RVAL_REF
  indexed_type operator[](unsigned int i) &;

  indexed_type &&operator[](unsigned int i) &&;
#else
  indexed_type operator[](unsigned int i);
#endif

  operator T() const
  {
    T ret(this->get_kbase(), this->get_name(), this->get_settings());
    //std::cerr << "cast to array" << std::endl;
    return ret;
  }

protected:
  reference(Array_Base &v)
    : reference<typename T::subarray_type, R>(v) {}

public:
  /*
   * Do not use these methods; treat as protected
   */
#ifdef USE_RVAL_REF
  reference __get(unsigned int i) &;
  reference &&__get(unsigned int i) &&;
#else
  reference __get(unsigned int i);
#endif
};

class Array_Base
{
public:
  const static unsigned int dims = 0;
protected:
  typedef Array_Base forwarded_type;

protected:
  const static unsigned int dim = 0;
  const static unsigned int dim0 = 0;
  typedef Array_Base subarray_type;
  typedef Array_Base sub0;

  Knowledge_Base &kbase;
  std::string name;

  Array_Base(Knowledge_Base &kb, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    kbase(kb), name(varName), settings(settings) {}
public:
  Knowledge_Update_Settings settings;

  const std::string &get_name() const { return name; }

  /// Note: any containers generated from this Array will keep old name
  const std::string &set_name(const std::string &n) { return name = n; }

  Knowledge_Base &get_kbase() { return kbase; }

  Knowledge_Update_Settings &get_settings()
  {
    return settings;
  }

  const Knowledge_Update_Settings &get_settings() const
  {
    return settings;
  }

protected:
  void get_dims(std::vector<int> &out) const {}
};

template<class R>
class reference<Array_Base, R> : public basic_container<R, reference<Array_Base, R> >
{
protected:
  typedef basic_container<R, reference<Array_Base, R> > container_type;
#ifdef USE_RVAL_REF
  std::unique_ptr<std::ostringstream> name_str;
#else
  std::auto_ptr<std::ostringstream> name_str;
#endif

public:
  reference<Array_Base, R>(Array_Base &v) : container_type(v.get_kbase(), v.settings), name_str(new std::ostringstream())
  {
    *name_str << v.get_name();
  }

  reference<Array_Base, R>(const reference<Array_Base, R> &o)
    : container_type(o.get_kbase(), o.settings), name_str(new std::ostringstream())
  {
    *name_str << o.name_str->str();
    //std::cerr << "Copying: " << o.name_str->str() << " to " << name_str->str() << std::endl;
  }

#ifdef USE_RVAL_REF
  reference(reference &&o)
    : container_type(o.get_kbase(), o.settings), name_str(std::move(o.name_str))
  {
    //std::cerr << "reference move ctor called" << std::endl;
  }
#endif

  typedef reference<Array_Base, R> index_as_type;

  using container_type::operator=;

  std::string get_name() const
  {
    return name_str->str();
  }

  Knowledge_Record get_knowledge_record() const {
    return this->get_kbase().get(this->get_name(), this->get_settings());
  }

  R get() const
  {
    return knowledge_cast<R>(get_knowledge_record());
  }

  reference &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    this->get_kbase().get_context().set(this->get_name(), in, settings);
    return *this;
  }

  reference &set(const R& in, const Knowledge_Update_Settings &settings)
  {
    return set_knowledge_record(knowledge_cast(in), settings);
  }

  using container_type::set;
  using container_type::set_knowledge_record;

protected:
  void __append_index(unsigned int i)
  {
    *name_str << "." << i;
  }

  friend class Array_Base;
public:
  index_as_type __get(unsigned int i)
#ifdef USE_RVAL_REF
  &
#endif
  {
    //std::cerr << "container index lvalue: " << this->get_name() << "." << i << std::endl;
    index_as_type ret(*this);
    ret.__append_index(i);
    return ret;
  }

#ifdef USE_RVAL_REF
  index_as_type &&__get(unsigned int i) &&
  {
    this->__append_index(i);
    //std::cerr << "container index rvalue: " << this->get_name() << std::endl;
    return std::move(*this);
  }
#endif
};

template<typename T, typename R>
inline reference<T, R> reference<T, R>::__get(unsigned int i)
#ifdef USE_RVAL_REF
&
#endif
{
  reference<T, R> ret(*this);
  ret.__append_index(i);
  //std::cerr << "index lvalue: " << ret.get_name() << std::endl;
  return ret;
}

#ifdef USE_RVAL_REF
template<typename T, typename R>
inline reference<T, R> &&reference<T, R>::__get(unsigned int i) &&
{
  this->__append_index(i);
  //std::cerr << "index rvalue: " << this->get_name() << std::endl;
  return std::move(*this);
}
#endif

template<typename T, typename R>
inline typename reference<T, R>::indexed_type reference<T, R>::operator[](unsigned int i)
#ifdef USE_RVAL_REF
 &
#endif
{
  if(!(i < T::dim && i >= 0))
    throw std::range_error("index out of bounds");
  //std::cerr << "index op lvalue: " << this->get_name() << std::endl;
  return static_cast<typename reference<T, R>::sub_type &>(*this).__get(i);
}

#ifdef USE_RVAL_REF
template<typename T, typename R>
inline typename reference<T, R>::indexed_type &&reference<T, R>::operator[](unsigned int i) &&
{
  if(!(i < T::dim && i >= 0))
    throw std::range_error("index out of bounds");
  //std::cerr << "index op rvalue: " << this->get_name() << std::endl;
  return static_cast<typename reference<T, R>::sub_type &&>(*this).__get(i);
}
#endif

}



#ifdef USE_VAR_TMPL
template <typename T, unsigned int d0=0, unsigned int ...dN>
class Array : public Array<T, dN...>
#else
template <typename T, unsigned int d0, unsigned int d1 = 0, unsigned int d2 = 0, unsigned int d3 = 0,
                      unsigned int d4 = 0, unsigned int d5 = 0, unsigned int d6 = 0, unsigned int d7 = 0,
                      unsigned int d8 = 0, unsigned int d9 = 0>
class Array : public Array<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0>
#endif
{
protected:
#ifdef USE_VAR_TMPL
  typedef Array<T, dN...> raw_subarray_type;
#else
  typedef Array<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0> raw_subarray_type;
#endif
public:
  typedef T value_type;
  typedef typename raw_subarray_type::forwarded_type subarray_type;
#ifdef USE_VAR_TMPL
  typedef Array<T, d0, dN...> this_type;
#else
  typedef Array<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9> this_type;
#endif
  typedef __INTERNAL__::reference<this_type> reference_type;
  const static unsigned int dim = d0;
  const static unsigned int dims = raw_subarray_type::dims + 1;

  typedef this_type sub0;
  const static unsigned int dim0 = sub0::dim;

#define GEN_SUB_DIM(cur, prev) \
  typedef typename sub##prev ::subarray_type sub##cur; \
  const static unsigned int dim##cur = sub##cur::dim;
                
  GEN_SUB_DIM(1, 0)
  GEN_SUB_DIM(2, 1)
  GEN_SUB_DIM(3, 2)
  GEN_SUB_DIM(4, 3)
  GEN_SUB_DIM(5, 4)
  GEN_SUB_DIM(6, 5)
  GEN_SUB_DIM(7, 6)
  GEN_SUB_DIM(8, 7)
  GEN_SUB_DIM(9, 8)

#undef GEN_SUB_DIM

#ifdef USE_STD_ARRAY
public:
  typedef std::array<typename raw_subarray_type::array_type, dim> array_type;
  typedef std::array<typename raw_subarray_type::cache_array_type, dim> cache_array_type;
  typedef std::array<typename raw_subarray_type::ref_array_type, dim> ref_array_type;

  void get_local_array(array_type &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_local_array(out[i], (*this)[i]);
    }
  }

  void get_cache_array(cache_array_type &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_cache_array(out[i], (*this)[i]);
    }
  }

  static void push_cache_array(cache_array_type &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::push_cache_array(in[i]);
    }
  }

  static void pull_cache_array(cache_array_type &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::pull_cache_array(in[i]);
    }
  }

  static void pull_cache_array_keep_local(cache_array_type &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::pull_cache_array_keep_local(in[i]);
    }
  }

  void set_from_array(const array_type &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_from_array(in[i], (*this)[i]);
    }
  }

  void set_existing_from_array(const array_type &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_existing_from_array(in[i], (*this)[i]);
    }
  }

  void get_reference_array(ref_array_type &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_reference_array(out[i], (*this)[i]);
    }
  }

  void get_existing_reference_array(ref_array_type &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_existing_reference_array(out[i], (*this)[i]);
    }
  }

protected:
  void get_local_array(array_type &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_local_array(out[i], ref[i]);
    }
  }

  void get_cache_array(cache_array_type &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_cache_array(out[i], ref[i]);
    }
  }

  void set_from_array(const array_type &in, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_from_array(in[i], ref[i]);
    }
  }

  void set_existing_from_array(const array_type &in, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_existing_from_array(in[i], ref[i]);
    }
  }

  void get_reference_array(ref_array_type &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_reference_array(out[i], ref[i]);
    }
  }

  void get_existing_reference_array(ref_array_type &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_existing_reference_array(out[i], ref[i]);
    }
  }
public:
#endif
protected:
  typedef this_type forwarded_type;
public:

#ifdef USE_VAR_TMPL
  Array<T, d0, dN...>
#else
  Array<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9>
#endif
    (Knowledge_Base &kb, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    raw_subarray_type(kb, varName, settings) {}

  __INTERNAL__::reference<subarray_type, T> operator[](unsigned int i)
  {
    reference_type ret(*this);
#ifdef USE_RVAL_REF
    return std::move(std::move(ret)[i]);
#else
    return ret[i];
#endif
  }

#ifdef USE_VAR_TMPL
  friend class __INTERNAL__::reference<Array<T, d0, dN...> >;
#else
  friend class __INTERNAL__::reference<Array<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9> >;
#endif

#ifdef USE_STD_ARRAY
  std::array<int, dims> get_dims() const
  {
    return std::array<int, dims>{d0, dN...};
  }
#else
  std::vector<int> get_dims() const
  {
    std::vector<int> ret;
    get_dims(ret);
    return ret;
  }

protected:
  void get_dims(std::vector<int> &out) const
  {
    out.push_back(dim);
    subarray_type::get_dims(out);
  }
#endif
protected:
};

#ifdef USE_VAR_TMPL
template <class T>
class Array<T, 0>
#else
template <class T>
class Array<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0>
#endif
  : public __INTERNAL__::Array_Base
{
public:
  typedef __INTERNAL__::Array_Base subarray_type;
  const static unsigned int dims = 0;
protected:
#ifdef USE_STD_ARRAY
  typedef T array_type;
  typedef Container<T> ref_array_type;
  typedef CachedContainer<T> cache_array_type;
  typedef __INTERNAL__::reference<Array_Base, T> reference_type;

  void get_local_array(T &out, reference_type v)
  {
    out = v.get();
  }

  void get_cache_array(cache_array_type &out, reference_type v)
  {
    out = cache_array_type(v);
  }

  static void push_cache_array(cache_array_type &in)
  {
    in.push();
  }

  static void pull_cache_array(cache_array_type &in)
  {
    in.pull();
  }

  static void pull_cache_array_keep_local(cache_array_type &in)
  {
    in.pull_keep_local();
  }

  void set_from_array(const T &in, reference_type v)
  {
    v.set(in);
  }

  void set_existing_from_array(const T &in, reference_type v)
  {
    if(v.exists())
      v.set(in);
  }

  void get_reference_array(ref_array_type &out, reference_type v)
  {
    out = ref_array_type(v);
  }

  void get_existing_reference_array(ref_array_type &out, reference_type v)
  {
    if(v.exists())
      out = ref_array_type(v);
  }
#endif
  typedef subarray_type forwarded_type;
public:

#ifdef USE_VAR_TMPL
  Array<T>
#else
  Array<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0>
#endif
    (Knowledge_Base &kb, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    subarray_type(kb, varName, settings) {}
};

}
}
}

#endif
