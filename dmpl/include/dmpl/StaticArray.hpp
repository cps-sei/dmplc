#ifndef _MADARA_ARRAY_HPP
#define _MADARA_ARRAY_HPP

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
#include "Reference.hpp"

#if __cplusplus >= 201103L
#include <array>

#define USE_RVAL_REF
#define USE_VAR_TMPL
#define USE_STD_ARRAY
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

static const unsigned int VAR_LEN = UINT_MAX;

namespace StorageManager
{

namespace __INTERNAL__
{

template<typename T>
class Stateless;

}

template<typename T>
struct get_sm_info;

}


namespace __INTERNAL__
{

template <unsigned Size, unsigned int Dim>
class size_manager
{
protected:
  static const unsigned int dim = Dim;
  static const unsigned int size = Size;
  size_manager() {}
  size_manager(unsigned int s) { resize(s); }
  void throw_error(unsigned int newSize)
  {
    std::ostringstream err;
    err << "Tried to resize dimension with static size " << size << " to size " << newSize << std::endl;
    throw std::range_error(err.str());
  }
public:
  unsigned int get_size() const { return size; }
  bool can_resize() const { return false; }
  void resize(unsigned int newSize) {
    if(newSize != 0 && newSize != size)
      throw_error(newSize);
  }
  bool check_bounds(unsigned int i) const
  {
    return i >= 0 && i < size;
  }
};

template <unsigned int Dim>
struct size_manager<VAR_LEN, Dim>
{
protected:
  static const unsigned int dim = Dim;
  unsigned int size;
  size_manager() : size(VAR_LEN) {}
  size_manager(unsigned int s) : size(s > 0 ? s : VAR_LEN) {}
public:
  unsigned int get_size() const { return size; }
  bool can_resize() const { return true; }
  void resize(unsigned int new_size) {
    if(new_size > 0)
      size = new_size;
  }
  bool check_bounds(unsigned int i) const
  {
    return i >= 0 && i < size;
  }
};

class StaticArray_Base;

template<typename T, typename R = typename T::value_type,
   typename S = StorageManager::__INTERNAL__::Stateless<R> >
class array_reference
  : protected array_reference<typename T::subarray_type, R, S>,
    protected size_manager<T::static_size, T::dims>,
    protected S::template RefDimensionMixin<T>
{
protected:
  typedef size_manager<T::static_size, T::dims> size_mgr;
  typedef S storage_mgr;
  typedef typename S::template RefDimensionMixin<T> storage_mixin;
public:
  typedef array_reference<T, R, S> index_as_type;
  typedef array_reference<typename T::subarray_type, R, S> sub_type;
  typedef typename sub_type::index_as_type indexed_type;

  friend class StaticArray_Base;
  friend class identity<T>::type;
  friend class identity<array_reference<typename T::subarray_type, R, S> >::type;
  friend class identity<array_reference<StaticArray_Base, R, S> >::type;

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
  array_reference(T &v)
    : array_reference<typename T::subarray_type, R, S>(v),
      size_mgr(v.template get_size_manager<0>()),
      storage_mixin() {}

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
  const static unsigned int static_size = 0;
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

  /// Note: any references generated from this StaticArray will keep old name
  const std::string &set_name(const std::string &n) { return name = n; }

  Thread_Safe_Context &get_context() const { return context; }

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

template<class R, typename S>
class array_reference<StaticArray_Base, R, S>
  : public basic_reference<R, array_reference<StaticArray_Base, R> >,
    protected size_manager<1, 0>,
    protected S::template RefBaseMixin<StaticArray_Base>
{
protected:
  typedef basic_reference<R, array_reference<StaticArray_Base, R> > container_type;
  typedef size_manager<1, 0> size_mgr;
  typedef S storage_mgr;
  typedef typename S::template RefBaseMixin<StaticArray_Base> storage_mixin;

  storage_mixin &get_storage_mixin()
  {
    return static_cast<storage_mixin &>(*this);
  }

  const storage_mixin &get_storage_mixin() const
  {
    return static_cast<const storage_mixin &>(*this);
  }
public:
  array_reference(StaticArray_Base &v)
    : container_type(v.get_context(), v.settings),
      storage_mixin(v)
  { }

  array_reference(const array_reference<StaticArray_Base, R, S> &o)
    : container_type(o.get_context(), o.settings),
      storage_mixin(o.get_storage_mixin())
  {
    //std::cerr << "Copying: " << o.name_str->str() << " to " << name_str->str() << std::endl;
  }

#ifdef USE_RVAL_REF
  array_reference(array_reference &&o)
    : container_type(o.get_context(), o.settings),
      storage_mixin(std::move(o.get_storage_mixin()))
  {
    //std::cerr << "array_reference move ctor called" << std::endl;
  }
#endif

  typedef array_reference<StaticArray_Base, R, S> index_as_type;

  using container_type::operator=;

  const R &operator=(const array_reference &o)
  {
    return set(o);
  }

  std::string get_name() const
  {
    return get_storage_mixin().get_name();
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
    get_storage_mixin().append_index(i);
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

template<typename T, typename R, typename D>
inline array_reference<T, R, D> array_reference<T, R, D>::__get(unsigned int i)
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
template<typename T, typename R, typename D>
inline array_reference<T, R, D> &&array_reference<T, R, D>::__get(unsigned int i) &&
{
  this->__append_index(i);
  //std::cerr << "index rvalue: " << this->get_name() << std::endl;
  return std::move(*this);
}
#endif

void throw_range_error(std::string name, int i, int max)
{
  std::ostringstream err;
  err << "Index " << i << " of " << name << " out of bounds (required: 0 <= index < " << max << ")";
  throw std::range_error(err.str());
}

template<typename T, typename R, typename D>
inline typename array_reference<T, R, D>::indexed_type array_reference<T, R, D>::operator[](unsigned int i)
#ifdef USE_RVAL_REF
 &
#endif
{
  if(!size_mgr::check_bounds(i))
    throw_range_error(this->get_name(), i, size_mgr::get_size());
  //std::cerr << "index op lvalue: " << this->get_name() << std::endl;
  return static_cast<typename array_reference<T, R>::sub_type &>(*this).__get(i);
}

#ifdef USE_RVAL_REF
template<typename T, typename R, typename D>
inline typename array_reference<T, R, D>::indexed_type &&array_reference<T, R, D>::operator[](unsigned int i) &&
{
  if(!size_mgr::check_bounds(i))
    throw_range_error(this->get_name(), i, size_mgr::get_size());
  //std::cerr << "index op rvalue: " << this->get_name() << std::endl;
  return static_cast<typename array_reference<T, R>::sub_type &&>(*this).__get(i);
}
#endif

} // end __INTERNAL__


#ifdef USE_VAR_TMPL
template <typename T, unsigned int d0 = 0, unsigned int ...dN>
class StaticArray
  : public StaticArray<T, dN...>,
    protected __INTERNAL__::size_manager<d0, StaticArray<T, dN...>::dims + 1>,
    protected StorageManager::get_sm_info<T>::sm_type::template DimensionMixin<StaticArray<T, dN...> >
#else

template <typename T, unsigned int d0, unsigned int d1 = 0, unsigned int d2 = 0, unsigned int d3 = 0,
                      unsigned int d4 = 0, unsigned int d5 = 0, unsigned int d6 = 0, unsigned int d7 = 0,
                      unsigned int d8 = 0, unsigned int d9 = 0>
class StaticArray
  : public StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0>,
    protected __INTERNAL__::size_manager<d0, StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0>::dims + 1>,
    protected StorageManager::get_sm_info<T>::sm_type::template DimensionMixin<StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0> >
#endif
{
protected:
#ifdef USE_VAR_TMPL
  typedef StaticArray<T, dN...> raw_subarray_type;
#else
  typedef StaticArray<T, d1, d2, d3, d4, d5, d6, d7, d8, d9, 0> raw_subarray_type;
#endif
public:
  typedef StorageManager::get_sm_info<T> sm_info;
  typedef typename sm_info::sm_type sm_type;
  typedef typename sm_info::data_type value_type;
  typedef typename raw_subarray_type::forwarded_type subarray_type;
#ifdef USE_VAR_TMPL
  typedef StaticArray<T, d0, dN...> this_type;
#else
  typedef StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9> this_type;
#endif
  typedef __INTERNAL__::array_reference<this_type> reference_type;
public:
  const static unsigned int static_size = d0;
  const static unsigned int dims = raw_subarray_type::dims + 1;

  typedef __INTERNAL__::size_manager<static_size, dims> size_mgr;

  template<unsigned int dimension, bool dummy = true>
  struct get_dimension_type
  {
    typedef typename raw_subarray_type::template get_dimension_type<dimension - 1, dummy>::type type;
  };

  template<bool dummy>
  struct get_dimension_type<0, dummy>
  {
    typedef this_type type;
  };

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  typename get_dimension_type<dimension>::type &get_dimension()
  {
    return static_cast<typename get_dimension_type<dimension>::type &>(*this);
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  const typename get_dimension_type<dimension>::type &get_dimension() const
  {
    return static_cast<const typename get_dimension_type<dimension>::type &>(*this);
  }

protected:
  template<unsigned int dimension, bool dummy = true>
  struct get_next_dimension_type
  {
    typedef typename raw_subarray_type::template get_dimension_type<dimension - 1, dummy>::type type;
  };

  template<bool dummy>
  struct get_next_dimension_type<0, dummy>
  {
    typedef raw_subarray_type type;
  };

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  const typename get_next_dimension_type<dimension>::type &get_next_dimension() const
  {
    return static_cast<const typename get_next_dimension_type<dimension>::type &>(*this);
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  const typename get_dimension_type<dimension>::type::size_mgr &get_size_manager() const
  {
    return static_cast<const typename get_dimension_type<dimension>::type::size_mgr &>(*this);
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  typename get_dimension_type<dimension>::type::size_mgr &get_size_manager()
  {
    return static_cast<typename get_dimension_type<dimension>::type::size_mgr &>(*this);
  }

public:
  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  unsigned int get_size() const
  {
    return get_size_manager<dimension>().get_size();
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  void resize(unsigned int new_size)
  {
    get_size_manager<dimension>().resize(new_size);
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  bool can_resize() const
  {
    return get_size_manager<dimension>().can_resize();
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  bool check_bounds(unsigned int i) const
  {
    return get_size_manager<dimension>().check_bounds(i);
  }

  template<unsigned int dimension
#ifdef USE_VAR_TMPL
  =0
#endif
  >
  unsigned int get_multiplier() const
  {
    //std::cerr << "get_multiplier  dims == " << dims << "  size == " << get_size<0>() << std::endl;
    const unsigned int num_dims = get_dimension<dimension>().dims;
    if(num_dims <= 1)
      return 1;
    unsigned int s = get_next_dimension<dimension>().get_size<dimension>();
    if(num_dims == 2)
      return s;
    if(s == VAR_LEN)
      return VAR_LEN;
    return s * static_cast<const typename get_next_dimension_type<dimension>::type*>(this)->get_multiplier<dimension>();
  }

public:
#ifdef USE_USING_TYPE
  template<class E = value_type>
  using get_vector_type = std::vector<typename raw_subarray_type::template get_vector_type<E> >;
  typedef get_vector_type<> vector_type;
#endif
  template<class E = value_type>
  struct get_vector_type_compat
  {
    typedef std::vector<typename raw_subarray_type::template get_vector_type_compat<E>::type > type;
  };
#ifndef USE_USING_TYPE
  typedef typename get_vector_type_compat<>::type vector_type;
#endif

#if defined(USE_STD_ARRAY) && defined(USE_USING_TYPE)
  template<class E = value_type>
  using get_array_type = std::array<typename raw_subarray_type::template
    get_array_type<E>, static_size == VAR_LEN ? 1 : static_size>;

  typedef get_array_type<> array_type;
#else
  template<class E = value_type>
  struct get_array_type
  {
    typedef typename raw_subarray_type::template
      get_array_type<E>::type type[static_size == VAR_LEN ? 1 : static_size];
  };
  typedef typename get_array_type<>::type array_type;
#endif

private:
  void check_var_len(const char *fname)
  {
    if(static_size == VAR_LEN && get_size<0>() == VAR_LEN)
      throw std::range_error(std::string(fname) + "() called on StaticArray with unbounded VAR_LEN dimension");
  }

public:
  template<class E>
  void get_into(E &out)
  {
    check_var_len("get_into");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::get_into(out[i], (*this)[i]);
    }
  }

  template<class E>
  void get_into(std::vector<E> &out)
  {
    check_var_len("get_into");
    out.clear();
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::get_into(out, (*this)[i]);
    }
  }

  template<class E>
  void set_from(const E &in)
  {
    check_var_len("set_from");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::set_from(in[i], (*this)[i]);
    }
  }

  template<class E>
  void update_from(const E &in)
  {
    check_var_len("update_from");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::update_from(in[i], (*this)[i]);
    }
  }

  template<class E>
  void push_all(E &in)
  {
    check_var_len("push_all");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::push_all(in[i]);
    }
  }

  template<class E>
  void pull_all(E &in)
  {
    check_var_len("pull_all");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::pull_all(in[i]);
    }
  }

  template<class E>
  void pull_all_keep_local(E &in)
  {
    check_var_len("pull_all_keep_local");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::pull_all_keep_local(in[i]);
    }
  }

protected:
  template<class E>
  void get_into(E &out, reference_type ref)
  {
    check_var_len("get_into");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::get_into(out[i], ref[i]);
    }
  }

  template<class E>
  void get_into(std::vector<E> &out, reference_type ref)
  {
    check_var_len("get_into");
#ifdef USE_EMPLACE
    out.emplace_back();
#else
    out.push_back(E());
#endif
    E &self = out.back();
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::get_into(self, ref[i]);
    }
  }

  template<class E>
  void set_from(const E &in, reference_type ref)
  {
    check_var_len("set_from");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::set_from(in[i], ref[i]);
    }
  }

  template<class E>
  void update_from(const E &in, reference_type ref)
  {
    check_var_len("update_from");
    for(int i = 0; i < get_size<0>(); i++)
    {
      raw_subarray_type::update_from(in[i], ref[i]);
    }
  }

protected:
  typedef this_type forwarded_type;
public:

#ifdef USE_VAR_TMPL
  StaticArray(Thread_Safe_Context &con, const std::string &varName)
    : raw_subarray_type(con, varName) {}

  StaticArray(Thread_Safe_Context &con, const std::string &varName,
      const Knowledge_Update_Settings &settings)
    : raw_subarray_type(con, varName, settings) {}

  template<typename... Args>
  StaticArray(Thread_Safe_Context &con, const std::string &varName,
        const Knowledge_Update_Settings &settings,
        unsigned int default_dim, Args... args)
    : raw_subarray_type(con, varName, args...), size_mgr(default_dim)
  { }

  template<typename... Args>
  StaticArray(Thread_Safe_Context &con, const std::string &varName,
        unsigned int default_dim, Args... args)
    : StaticArray(con, varName, Knowledge_Update_Settings(), default_dim, args...) {}

  template<typename... Args>
  StaticArray(Knowledge_Base &kbase, Args... args)
    : StaticArray(kbase.get_context(), args...) {}

#else
  StaticArray(Thread_Safe_Context &con, const std::string &varName,
      unsigned int i0 = 0, unsigned int i1 = 0, unsigned int i2 = 0, unsigned int i3 = 0,
      unsigned int i4 = 0, unsigned int i5 = 0, unsigned int i6 = 0, unsigned int i7 = 0,
      unsigned int i8 = 0, unsigned int i9 = 0) :
    raw_subarray_type(con, varName, Knowledge_Update_Settings(),
      i1, i2, i3, i4, i5, i6, i7, i8, i9), size_mgr(i0) { }

  StaticArray(Thread_Safe_Context &con, const std::string &varName,
      const Knowledge_Update_Settings &settings,
      unsigned int i0 = 0, unsigned int i1 = 0, unsigned int i2 = 0, unsigned int i3 = 0,
      unsigned int i4 = 0, unsigned int i5 = 0, unsigned int i6 = 0, unsigned int i7 = 0,
      unsigned int i8 = 0, unsigned int i9 = 0) :
    raw_subarray_type(con, varName, settings,
      i1, i2, i3, i4, i5, i6, i7, i8, i9), size_mgr(i0) { }

  StaticArray(Knowledge_Base &kbase, const std::string &varName,
      unsigned int i0 = 0, unsigned int i1 = 0, unsigned int i2 = 0, unsigned int i3 = 0,
      unsigned int i4 = 0, unsigned int i5 = 0, unsigned int i6 = 0, unsigned int i7 = 0,
      unsigned int i8 = 0, unsigned int i9 = 0) :
    raw_subarray_type(kbase.get_context(), varName, Knowledge_Update_Settings(),
      i1, i2, i3, i4, i5, i6, i7, i8, i9), size_mgr(i0) { }

  StaticArray(Knowledge_Base &kbase, const std::string &varName,
      const Knowledge_Update_Settings &settings,
      unsigned int i0 = 0, unsigned int i1 = 0, unsigned int i2 = 0, unsigned int i3 = 0,
      unsigned int i4 = 0, unsigned int i5 = 0, unsigned int i6 = 0, unsigned int i7 = 0,
      unsigned int i8 = 0, unsigned int i9 = 0) :
    raw_subarray_type(kbase.get_context(), varName, settings,
      i1, i2, i3, i4, i5, i6, i7, i8, i9), size_mgr(i0) { }
#endif

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
  template<unsigned int dNew0, unsigned int... dNewN>
  StaticArray(const StaticArray<T, dNew0, dNewN...> &o)
    : raw_subarray_type(o) {}
#endif

#ifdef USE_VAR_TMPL
  friend class __INTERNAL__::array_reference<StaticArray<T, d0, dN...>, T>;
#else
  friend class __INTERNAL__::array_reference<StaticArray<T, d0, d1, d2, d3, d4, d5, d6, d7, d8, d9>, T>;
#endif

#ifdef USE_VAR_TMPL
  std::array<int, dims> get_static_dims() const
  {
    return std::array<int, dims>{d0, dN...};
  }
#endif
  std::vector<int> get_dims() const
  {
    std::vector<int> ret;
    get_dims(ret);
    return ret;
  }

protected:
  void get_dims(std::vector<int> &out) const
  {
    out.push_back(get_size<0>());
    subarray_type::get_dims(out);
  }
};

#ifdef USE_VAR_TMPL
template <class T>
class StaticArray<T>
  : public __INTERNAL__::StaticArray_Base,
    protected __INTERNAL__::size_manager<1, 0>,
    protected StorageManager::get_sm_info<T>::sm_type::template BaseMixin<StaticArray<T> >
#else
template <class T>
class StaticArray<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0>
  : public __INTERNAL__::StaticArray_Base,
    protected __INTERNAL__::size_manager<1, 0>,
    protected StorageManager::get_sm_info<T>::sm_type::template BaseMixin<StaticArray<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0> >
#endif
{
public:
#ifdef USE_VAR_TMPL
  typedef StaticArray<T> this_type;
#else
  typedef StaticArray<T, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0> this_type;
#endif
  typedef __INTERNAL__::StaticArray_Base subarray_type;
  const static unsigned int dims = 0;

  typedef __INTERNAL__::array_reference<StaticArray_Base, T> reference_type;

public:
#if defined(USE_STD_ARRAY) && defined(USE_USING_TYPE)
  template<class E = T>
  using get_array_type = E;
#else
  template<class E = T>
  struct get_array_type
  {
    typedef E type;
  };
#endif

#ifdef USE_USING_TYPE
  template<class E = T>
  using get_vector_type = E;
#endif
  template<class E = T>
  struct get_vector_type_compat
  {
    typedef E type;
  };

  template<unsigned int dimension, bool dummy = true>
  struct get_dimension_type
  {
    typedef typename get_dimension_type<dimension - 1, dummy>::type type;
  };

  template<bool dummy>
  struct get_dimension_type<0, dummy>
  {
    typedef this_type type;
  };

  typedef __INTERNAL__::size_manager<1,0> size_mgr;

  template<unsigned int i>
  this_type &get_dimension()
  {
    return *this;
  }

  template<unsigned int i>
  const this_type &get_dimension() const
  {
    return *this;
  }

  template<unsigned int i>
  unsigned int get_size() const
  {
    return 1;
  }

  template<unsigned int i>
  unsigned int get_multiplier() const
  {
    return 1;
  }

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
  void push_all(E &in)
  {
    in.push();
  }

  template<class E>
  void pull_all(E &in)
  {
    in.pull();
  }

  template<class E>
  void pull_all_keep_local(E &in)
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

  StaticArray
    (Thread_Safe_Context &con, const std::string &varName = "",
      const Knowledge_Update_Settings &settings = Knowledge_Update_Settings()
#ifndef USE_VAR_TMPL
      , unsigned int i0 = 0, unsigned int i1 = 0, unsigned int i2 = 0, unsigned int i3 = 0,
      unsigned int i4 = 0, unsigned int i5 = 0, unsigned int i6 = 0, unsigned int i7 = 0,
      unsigned int i8 = 0, unsigned int i9 = 0
#endif
      ) : subarray_type(con, varName, settings) {}
};

namespace StorageManager
{

namespace __INTERNAL__
{

template <typename T>
struct Stateless
{
  typedef T data_type;

  template<typename A>
  class DimensionMixin
  {
  public:
    typedef T data_type;
    typedef typename A::reference_type reference_type;
    typedef typename A::reference_type index_type;
    typedef typename A::reference_type getter_type;

    getter_type sm_get(reference_type ref)
    {
      return ref;
    }
  };

  template<typename A>
  class BaseMixin
  {
  public:
  };

  template<typename A>
  class RefDimensionMixin
  {
  public:
  };

  template<typename A>
  class RefBaseMixin
  {
  public:
#ifdef USE_RVAL_REF
    std::unique_ptr<std::ostringstream> name_str;
#else
    std::auto_ptr<std::ostringstream> name_str;
#endif

    RefBaseMixin(const A &a)
      : name_str(new std::ostringstream())
    {
      *name_str << a.get_name();
    }

    RefBaseMixin(const RefBaseMixin<A> &o)
      : name_str(new std::ostringstream())
    {
      *name_str << o.name_str->str();
    }

#ifdef USE_RVAL_REF
    RefBaseMixin(RefBaseMixin<A> &&o)
      : name_str(std::move(o.name_str)) { }
#endif

    std::string get_name() const
    {
      return name_str->str();
    }

    void append_index(unsigned int i)
    {
      *name_str << "." << i;
    }
  };
};

} // End __INTERNAL__

template <typename T, typename S>
struct Lazy
{
  typedef T data_type;
  typedef S storage_type;

  template<typename A>
  class DimensionMixin
  {
  public:
  };

  template<typename A>
  class BaseMixin
  {
  public:
    typedef T data_type;
    typedef S storage_type;
    typedef storage_type getter_type;
    typedef std::vector<T> vector_type;
    std::vector<unsigned int> stored_dims;
    vector_type stored_data;
  };

  template<typename A>
  class RefDimensionMixin
  {
  public:
  };

  template<typename A>
  class RefBaseMixin
  {
  public:
    const std::string base_name;
    unsigned int offset;

    RefBaseMixin(const A &a)
      : base_name(a.get_name()), offset(0)
    { }

    RefBaseMixin(const RefBaseMixin<A> &o)
      : base_name(o.base_name), offset(o.offset)
    { }

#ifdef USE_RVAL_REF
    RefBaseMixin(RefBaseMixin<A> &&o)
      : base_name(std::move(o.base_name)), offset(o.offset) { }
#endif

    std::string get_name() const
    {
      std::ostringstream ret;
      ret << base_name;
      ret << "." << offset;
      return ret.str();
    }

    void append_index(unsigned int i)
    {
      offset += i;
    }
  };
};

template <typename T, typename S>
struct Proactive
{
  typedef T data_type;
  typedef S storage_type;

  template<typename A>
  class DimensionMixin
  {
  };

  template<typename A>
  class BaseMixin
  {
  public:
    typedef T data_type;
    typedef S storage_type;
    typedef storage_type getter_type;
    typedef std::vector<T> vector_type;
    vector_type stored_data;
  };

  template<typename A>
  class RefDimensionMixin
  {
  public:
  };

  template<typename A>
  class RefBaseMixin
  {
  public:
  };
};

template <typename T>
struct get_sm_info
{
  typedef __INTERNAL__::Stateless<T> sm_type;
  typedef T data_type;
};

template <typename T>
struct get_sm_info<__INTERNAL__::Stateless<T> >
{
  typedef __INTERNAL__::Stateless<T> sm_type;
  typedef T data_type;
};

template <typename T, typename S>
struct get_sm_info<Lazy<T,S> >
{
  typedef Lazy<T,S> sm_type;
  typedef T data_type;
  typedef S storage_type;
};

template <typename T, typename S>
struct get_sm_info<Proactive<T,S> >
{
  typedef Proactive<T,S> sm_type;
  typedef T data_type;
  typedef S storage_type;
};

}

}
}
}
#endif
