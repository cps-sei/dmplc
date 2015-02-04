#ifndef _MADARA_STATELESS_HPP
#define _MADARA_STATELESS_HPP

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
#include "StorageManager.hpp"

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

using namespace ::Madara::Knowledge_Engine::Containers::__INTERNAL__;

namespace __INTERNAL__
{

template <unsigned int Size, unsigned int Dim>
class SizeManager
{
protected:
  static const unsigned int dim = Dim;
  static const unsigned int size = Size;
  SizeManager() {}
  SizeManager(unsigned int s) { resize(s); }
  void throw_error(unsigned int newSize)
  {
    std::ostringstream err;
    err << "Tried to resize dimension with static size " << size << " to size " << newSize << std::endl;
    throw std::range_error(err.str());
  }
public:
  unsigned int get_size() const { return size; }
  const unsigned int &get_size_ref() const { static unsigned int ref_size = Size; return ref_size; }
  unsigned int get_num_dims() const { return dim; }
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
struct SizeManager<VAR_LEN, Dim>
{
protected:
  static const unsigned int dim = Dim;
  unsigned int size;
  SizeManager() : size(VAR_LEN) {}
  SizeManager(unsigned int s) : size(s > 0 ? s : VAR_LEN) {}
public:
  unsigned int get_size() const { return size; }
  const unsigned int &get_size_ref() const { return size; }
  unsigned int get_num_dims() const { return dim; }
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

template <unsigned int Size, unsigned int Dim>
struct SizeManagerReference : protected SizeManager<Size, Dim>
{
public:
  SizeManager<Size, Dim> &get_size_manager()
  {
    return static_cast<SizeManager<Size, Dim>&>(*this);
  }
  const SizeManager<Size, Dim> &get_size_manager() const
  {
    return static_cast<const SizeManager<Size, Dim>&>(*this);
  }
  SizeManagerReference(SizeManager<Size, Dim> &sm) {}
};

template<unsigned int Dim>
struct SizeManagerReference<VAR_LEN, Dim>
{
protected:
  SizeManager<VAR_LEN, Dim> &size_manager;
public:
  SizeManager<VAR_LEN, Dim> &get_size_manager() { return size_manager; }
  const SizeManager<VAR_LEN, Dim> &get_size_manager() const { return size_manager; }
  SizeManagerReference(SizeManager<VAR_LEN, Dim> &sm) : size_manager(sm) {}
};

template <typename T>
struct Stateless
{
  typedef Stateless<T> this_type;
  typedef T data_type;

  template <typename X>
  class RefDimensionMixin;

  template <typename X>
  class RefBaseMixin;

  template<typename A, unsigned int Size, unsigned int Dims>
  class DimensionMixin : protected SizeManager<Size, Dims>
  {
  protected:
    typedef SizeManager<Size, Dims> size_mgr;

    size_mgr &get_size_mgr()
    {
      return static_cast<size_mgr &>(*this);
    }

    const size_mgr &get_size_mgr() const
    {
      return static_cast<const size_mgr &>(*this);
    }
  public:
    typedef A array_type;
    typedef T data_type;

    template <typename X>
    friend class StaticArrayReference;

    friend class identity<A>::type;

    template <typename X>
    friend class StaticArray_0;

    template <typename X>
    friend class RefDimensionMixin;

    template <typename X>
    friend class RefBaseMixin;

    DimensionMixin(A &a, unsigned int i0 = 0)
      : size_mgr(i0) { }

    bool check_bounds(unsigned int i) const
    {
      return this->get_size_mgr().check_bounds(i);
    }

    unsigned int get_size() const
    {
      return this->get_size_mgr().get_size();
    }

    unsigned int get_num_dims() const
    {
      return this->get_size_mgr().get_num_dims();
    }

    bool can_resize() const
    {
      return this->get_size_mgr().can_resize();
    }

    void resize(unsigned int i)
    {
      return this->get_size_mgr().resize(i);
    }
  };

  template<typename A>
  class BaseMixin :
      protected SizeManager<1, 0>
  {
  protected:
    typedef SizeManager<1, 0> size_mgr;

    size_mgr &get_size_mgr()
    {
      return static_cast<size_mgr &>(*this);
    }

    const size_mgr &get_size_mgr() const
    {
      return static_cast<const size_mgr &>(*this);
    }

  public:
    template <typename X>
    friend class StaticArrayReference;

    friend class identity<A>::type;

    template <typename X>
    friend class StaticArray_0;

    template <typename X>
    friend class RefDimensionMixin;

    template <typename X>
    friend class RefBaseMixin;

    BaseMixin(A &a)
    {
    }

    unsigned int get_size() const
    {
      return 1;
    }

    unsigned int get_num_dims() const
    {
      return 0;
    }

    bool can_resize() const
    {
      return false;
    }
  };

  template<typename A>
  class RefDimensionMixin
    : public SizeManagerReference<A::static_size, A::dims>
  {
  protected:
    typedef SizeManagerReference<A::static_size, A::dims> size_mgr_ref;
    typedef SizeManager<A::static_size, A::dims> size_mgr;

    size_mgr &get_size_mgr()
    {
      return static_cast<size_mgr_ref &>(*this).get_size_manager();
    }

    const size_mgr &get_size_mgr() const
    {
      return static_cast<const size_mgr_ref &>(*this).get_size_manager();
    }
  public:
    typedef A array_type;
    typedef typename array_type::reference_type reference_type;
    typedef typename array_type::value_type value_type;

    template <typename X>
    friend class StaticArrayReference;

    friend class identity<A>::type;

    //template <typename X>
    //friend class StaticArray_0;

    reference_type &get_reference()
    {
      return static_cast<reference_type&>(*this);
    }

    const reference_type &get_reference() const
    {
      return static_cast<reference_type&>(*this);
    }

    void append_index(unsigned int i)
    {
      //std::cerr << "dim append_index " << i << std::endl;
      this->get_reference().get_sub_type().append_index(i);
    }

    bool check_bounds(unsigned int i) const
    {
      return this->get_size_mgr().check_bounds(i);
    }

    unsigned int get_size() const
    {
      return this->get_size_mgr().get_size();
    }

    unsigned int get_num_dims() const
    {
      return this->get_size_mgr().get_num_dims();
    }

    bool can_resize() const
    {
      return this->get_size_mgr().can_resize();
    }

    RefDimensionMixin(A& a) : size_mgr_ref(a.template get_storage_mixin<0>().template get_size_mgr()) {}
  };

  template<typename A>
  class RefBaseMixin
    : public BaseReference<T, RefBaseMixin<A> >,
      public SizeManager<1, 0>
  {
  protected:
    typedef BaseReference<T, RefBaseMixin<A> > container_type;
    typedef SizeManager<1, 0> size_mgr;

    size_mgr &get_size_mgr()
    {
      return static_cast<size_mgr &>(*this);
    }

    const size_mgr &get_size_mgr() const
    {
      return static_cast<const size_mgr &>(*this);
    }
  public:
    typedef StaticArrayReference<typename StaticArray_0<typename A::storage_specifier>::type> element_reference_type;
#ifdef USE_RVAL_REF
    typedef element_reference_type &&element_rvalue_type;
#endif

    using container_type::operator=;

    template <typename X>
    friend class StaticArrayReference;

    friend class identity<A>::type;

    friend class identity<typename StaticArray_0<this_type>::type >::type;

  protected:
    element_reference_type dereference()
#ifdef USE_RVAL_REF
    &
#endif
    {
      return static_cast<element_reference_type &>(*this);
    }

#ifdef USE_RVAL_REF
    element_rvalue_type dereference() &&
    {
      return std::move(static_cast<element_reference_type &>(*this));
    }
#endif

  public:
    const T &operator=(const RefBaseMixin &o)
    {
      return set(o); }

    void mark_modified()
    {
      this->get_context().mark_modified(
          this->get_context().get_ref(this->get_name(), this->get_settings())
        );
    }

    Knowledge_Record get_knowledge_record() const {
      return this->get_context().get(this->get_name(), this->get_settings());
    }

    T get() const
    {
      return knowledge_cast<T>(get_knowledge_record());
    }

    const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
    {
      this->get_context().set(this->get_name(), in, settings);
      return in;
    }

    const T &set(const T& in, const Knowledge_Update_Settings &settings)
    {
      set_knowledge_record(knowledge_cast(in), settings);
      return in;
    }

    using container_type::set;
    using container_type::set_knowledge_record;

#ifdef USE_RVAL_REF
    std::unique_ptr<std::ostringstream> name_str;
#else
    std::auto_ptr<std::ostringstream> name_str;
#endif

    RefBaseMixin(const A &a)
      : container_type(a.get_context(), a.get_settings()),
        size_mgr(a.template get_storage_mixin<0>().get_size_mgr()),
        name_str(new std::ostringstream())
    {
      *name_str << a.get_name();
    }

    RefBaseMixin(const RefBaseMixin<A> &o)
      : container_type(o.get_context(), o.get_settings()),
        size_mgr(o.get_size_mgr()),
        name_str(new std::ostringstream())
    {
      *name_str << o.name_str->str();
    }

#ifdef USE_RVAL_REF
    RefBaseMixin(RefBaseMixin<A> &&o)
      : container_type(o.get_context(), o.get_settings()),
        size_mgr(o.get_size_mgr()),
        name_str(std::move(o.name_str)) { }
#endif

    std::string get_name() const
    {
      return name_str->str();
    }

    void append_index(unsigned int i)
    {
      //std::cerr << "base append_index " << i << std::endl;
      *name_str << "." << i;
    }
  };
};

} // End __INTERNAL__

template <typename T>
struct get_sm_info<__INTERNAL__::Stateless<T> >
{
  typedef __INTERNAL__::Stateless<T> sm_type;
  typedef T data_type;
};

}

}
}
}
#endif
