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
#include <madara/knowledge_engine/Thread_Safe_Context.h>
#include <madara/knowledge_engine/Thread_Safe_Context.h>
#include <madara/knowledge_engine/Knowledge_Update_Settings.h>
#include "knowledge_cast.hpp"
#include "Reference.hpp"

#if __cplusplus >= 201103L
#include <array>

#define USE_RVAL_REF
#define USE_VAR_TMPL
#define USE_STD_ARRAY
#define USE_EMPLACE
#define USE_USING_TYPE
#endif

namespace Madara
{

namespace Knowledge_Engine
{
namespace Containers
{

namespace __INTERNAL__
{

class StaticArray_Base;

template<typename T, typename R = typename T::value_type>
class array_reference : protected array_reference<typename T::subarray_type, R>
{
public:
  typedef array_reference<T, R> index_as_type;
  typedef array_reference<typename T::subarray_type, R> sub_type;
  typedef typename sub_type::index_as_type indexed_type;

  friend class StaticArray_Base;
  friend class identity<T>::type;
  friend class identity<array_reference<typename T::subarray_type, R> >::type;
  friend class identity<array_reference<StaticArray_Base, R> >::type;

  /**
   * C++11 support is highly recommended for multi-dimensional arrays;
   * without it, each index operation creates pointless copies of array_reference
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
    T ret(this->get_context(), this->get_name(), this->get_settings());
    //std::cerr << "cast to array" << std::endl;
    return ret;
  }

protected:
  array_reference(StaticArray_Base &v)
    : array_reference<typename T::subarray_type, R>(v) {}

public:
  /*
   * Do not use these methods; treat as protected
   */
#ifdef USE_RVAL_REF
  array_reference __get(unsigned int i) &;
  array_reference &&__get(unsigned int i) &&;
#else
  array_reference __get(unsigned int i);
#endif
};

class StaticArray_Base
{
public:
  const static unsigned int dims = 0;
protected:
  typedef StaticArray_Base forwarded_type;

protected:
  const static unsigned int dim = 0;
  const static unsigned int dim0 = 0;
  typedef StaticArray_Base subarray_type;
  typedef StaticArray_Base sub0;

  Thread_Safe_Context &context;
  std::string name;

  StaticArray_Base(Thread_Safe_Context &con, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    context(con), name(varName), settings(settings) {}
public:
  Knowledge_Update_Settings settings;

  const std::string &get_name() const { return name; }

  /// Note: any containers generated from this StaticArray will keep old name
  const std::string &set_name(const std::string &n) { return name = n; }

  Thread_Safe_Context &get_context() { return context; }

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
class array_reference<StaticArray_Base, R> : public basic_reference<R, array_reference<StaticArray_Base, R> >
{
protected:
  typedef basic_reference<R, array_reference<StaticArray_Base, R> > container_type;
#ifdef USE_RVAL_REF
  std::unique_ptr<std::ostringstream> name_str;
#else
  std::auto_ptr<std::ostringstream> name_str;
#endif

public:
  array_reference<StaticArray_Base, R>(StaticArray_Base &v) : container_type(v.get_context(), v.settings), name_str(new std::ostringstream())
  {
    *name_str << v.get_name();
  }

  array_reference<StaticArray_Base, R>(const array_reference<StaticArray_Base, R> &o)
    : container_type(o.get_context(), o.settings), name_str(new std::ostringstream())
  {
    *name_str << o.name_str->str();
    //std::cerr << "Copying: " << o.name_str->str() << " to " << name_str->str() << std::endl;
  }

#ifdef USE_RVAL_REF
  array_reference(array_reference &&o)
    : container_type(o.get_context(), o.settings), name_str(std::move(o.name_str))
  {
    //std::cerr << "array_reference move ctor called" << std::endl;
  }
#endif

  typedef array_reference<StaticArray_Base, R> index_as_type;

  using container_type::operator=;

  const R &operator=(const array_reference &o)
  {
    return set(o);
  }

  std::string get_name() const
  {
    return name_str->str();
  }

  void mark_modified()
  {
    this->get_context().mark_modified(
        this->get_context().get_ref(this->get_name(), this->get_settings())
      );
  }

  Knowledge_Record get_knowledge_record() const {
    return this->get_context().get(this->get_name(), this->get_settings());
  }

  R get() const
  {
    return knowledge_cast<R>(get_knowledge_record());
  }

  const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    this->get_context().set(this->get_name(), in, settings);
    return in;
  }

  const R &set(const R& in, const Knowledge_Update_Settings &settings)
  {
    set_knowledge_record(knowledge_cast(in), settings);
    return in;
  }

  using container_type::set;
  using container_type::set_knowledge_record;

protected:
  void __append_index(unsigned int i)
  {
    *name_str << "." << i;
  }

  friend class StaticArray_Base;
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
inline array_reference<T, R> array_reference<T, R>::__get(unsigned int i)
#ifdef USE_RVAL_REF
&
#endif
{
  array_reference<T, R> ret(*this);
  ret.__append_index(i);
  //std::cerr << "index lvalue: " << ret.get_name() << std::endl;
  return ret;
}

#ifdef USE_RVAL_REF
template<typename T, typename R>
inline array_reference<T, R> &&array_reference<T, R>::__get(unsigned int i) &&
{
  this->__append_index(i);
  //std::cerr << "index rvalue: " << this->get_name() << std::endl;
  return std::move(*this);
}
#endif

template<typename T, typename R>
inline typename array_reference<T, R>::indexed_type array_reference<T, R>::operator[](unsigned int i)
#ifdef USE_RVAL_REF
 &
#endif
{
  if(!(i < T::dim && i >= 0))
    throw std::range_error("index out of bounds");
  //std::cerr << "index op lvalue: " << this->get_name() << std::endl;
  return static_cast<typename array_reference<T, R>::sub_type &>(*this).__get(i);
}

#ifdef USE_RVAL_REF
template<typename T, typename R>
inline typename array_reference<T, R>::indexed_type &&array_reference<T, R>::operator[](unsigned int i) &&
{
  if(!(i < T::dim && i >= 0))
    throw std::range_error("index out of bounds");
  //std::cerr << "index op rvalue: " << this->get_name() << std::endl;
  return static_cast<typename array_reference<T, R>::sub_type &&>(*this).__get(i);
}
#endif

}



#ifdef USE_VAR_TMPL
template <typename T, unsigned int d0=0, unsigned int ...dN>
class StaticArray : public StaticArray<T, dN...>
#else
template <typename T, unsigned int d0, unsigned int d1 = 0, unsigned int d2 = 0, unsigned int d3 = 0,
                      unsigned int d4 = 0, unsigned int d5 = 0, unsigned int d6 = 0, unsigned int d7 = 0,
                      unsigned int d8 = 0, unsigned int d9 = 0>
class StaticArray : public StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0>
#endif
{
protected:
#ifdef USE_VAR_TMPL
  typedef StaticArray<T, dN...> raw_subarray_type;
#else
  typedef StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0> raw_subarray_type;
#endif
public:
  typedef T value_type;
  typedef typename raw_subarray_type::forwarded_type subarray_type;
#ifdef USE_VAR_TMPL
  typedef StaticArray<T, d0, dN...> this_type;
#else
  typedef StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9> this_type;
#endif
  typedef __INTERNAL__::array_reference<this_type> reference_type;
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

public:
#ifdef USE_USING_TYPE
  template<class E>
  using vector_type = std::vector<typename raw_subarray_type::template vector_type<E> >;
#else
  template<class E>
  struct vector_type
  {
    typedef std::vector<typename raw_subarray_type::template vector_type<E>::type > type;
  };
#endif

  template<class E>
  void get_into(E &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(out[i], (*this)[i]);
    }
  }

  template<class E>
  void get_into(std::vector<E> &out)
  {
    out.clear();
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(out, (*this)[i]);
    }
  }

  template<class E>
  void set_from(const E &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_from(in[i], (*this)[i]);
    }
  }

  template<class E>
  void update_from(const E &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::update_from(in[i], (*this)[i]);
    }
  }

#if defined(USE_STD_ARRAY) && defined(USE_USING_TYPE)
  template<class E>
  using array_type = std::array<typename raw_subarray_type::template array_type<E>, dim>;
#endif
#if 0

  template<class E>
  void get_into(array_type<E> &out)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(out[i], (*this)[i]);
    }
  }

#endif

  template<class E>
  static void push_all(E &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::push_all(in[i]);
    }
  }

  template<class E>
  static void pull_all(E &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::pull_all(in[i]);
    }
  }

  template<class E>
  static void pull_all_keep_local(E &in)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::pull_all_keep_local(in[i]);
    }
  }

protected:
  template<class E>
  void get_into(E &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(out[i], ref[i]);
    }
  }

  template<class E>
  void get_into(std::vector<E> &out, reference_type ref)
  {
#ifdef USE_EMPLACE
    out.emplace_back();
#else
    out.push_back(E());
#endif
    E &self = out.back();
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(self, ref[i]);
    }
  }

//#ifdef USE_STD_ARRAY
#if 0
  template<class E>
  void get_into(array_type<E> &out, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::get_into(out[i], ref[i]);
    }
  }
#endif

  template<class E>
  void set_from(const E &in, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::set_from(in[i], ref[i]);
    }
  }

  template<class E>
  void update_from(const E &in, reference_type ref)
  {
    for(int i = 0; i < dim; i++)
    {
      raw_subarray_type::update_from(in[i], ref[i]);
    }
  }
public:
#endif
protected:
  typedef this_type forwarded_type;
public:

#ifdef USE_VAR_TMPL
  StaticArray<T, d0, dN...>
#else
  StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9>
#endif
    (Thread_Safe_Context &con, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    raw_subarray_type(con, varName, settings) {}

#ifdef USE_VAR_TMPL
  StaticArray<T, d0, dN...>
#else
  StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9>
#endif
    (Knowledge_Base &kbase, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    raw_subarray_type(kbase.get_context(), varName, settings) {}

  __INTERNAL__::array_reference<subarray_type, T> operator[](unsigned int i)
  {
    reference_type ret(*this);
#ifdef USE_RVAL_REF
    return std::move(std::move(ret)[i]);
#else
    return ret[i];
#endif
  }

#ifdef USE_VAR_TMPL
  friend class __INTERNAL__::array_reference<StaticArray<T, d0, dN...> >;
#else
  friend class __INTERNAL__::array_reference<StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9> >;
#endif

#ifdef USE_EMPLACE
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
class StaticArray<T, 0>
#else
template <class T>
class StaticArray<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0>
#endif
  : public __INTERNAL__::StaticArray_Base
{
public:
  typedef __INTERNAL__::StaticArray_Base subarray_type;
  const static unsigned int dims = 0;
protected:
  typedef __INTERNAL__::array_reference<StaticArray_Base, T> reference_type;

public:
#if defined(USE_STD_ARRAY) && defined(USE_USING_TYPE)
  template<class E >
  using array_type = E;
#endif

#ifdef USE_USING_TYPE
  template<class E>
  using vector_type = E;
#else
  template<class E>
  struct vector_type
  {
    typedef E type;
  };
#endif

  template<class E>
  void get_into(std::vector<E> &out, reference_type v)
  {
#ifdef USE_EMPLACE
    out.emplace_back(v);
#else
    out.push_back(v);
#endif
  }

  void get_into(T &out, reference_type v)
  {
    out = v;
  }

  template<class E>
  static void push_all(E &in)
  {
    in.push();
  }

  template<class E>
  static void pull_all(E &in)
  {
    in.pull();
  }

  template<class E>
  static void pull_all_keep_local(E &in)
  {
    in.pull_keep_local();
  }

  void set_from(const T &in, reference_type v)
  {
    v.set(in);
  }

  void update_from(const T &in, reference_type v)
  {
    if(v.exists())
      v.set(in);
  }

  typedef subarray_type forwarded_type;
public:

#ifdef USE_VAR_TMPL
  StaticArray<T>
#else
  StaticArray<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0>
#endif
    (Thread_Safe_Context &con, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()) :
    subarray_type(con, varName, settings) {}
};

}
}
}
