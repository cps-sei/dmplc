#ifndef _MADARA_CONTAINER_HPP
#define _MADARA_CONTAINER_HPP

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

#if __cplusplus >= 201103L
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

template<typename T>
struct identity
{
  typedef T type;
};

template<typename T, typename Impl>
class basic_container
{
private:
  Knowledge_Base *kbase;
public:
  basic_container() {}
  basic_container(Knowledge_Base &kb)
    : kbase(&kb), settings() {}

  basic_container(Knowledge_Base &kb, const Knowledge_Update_Settings &settings)
    : kbase(&kb), settings(settings) {}
public:
  Knowledge_Update_Settings settings;

  std::string get_name() const
  {
    return static_cast<const Impl*>(this)->get_name();
  }

  bool valid() const
  {
    return kbase != NULL;
  }

  Knowledge_Base &get_kbase() const
  {
    return *kbase;
  }

  Knowledge_Update_Settings &get_settings()
  {
    return settings;
  }

  const Knowledge_Update_Settings &get_settings() const
  {
    return settings;
  }

  Knowledge_Record get_knowledge_record() const {
    return static_cast<const Impl*>(this)->get_knowledge_record();
  }

  T get() const
  {
    return static_cast<const Impl*>(this)->get();
    //return knowledge_cast<T>(get_knowledge_record());
  }

  operator T() const {
    return get();
  }

  bool exists() const
  {
    return get_kbase().exists(get_name(), get_settings());
  }

  Knowledge_Record::Integer get_integer() const
  {
    return get_knowledge_record().to_integer();
  }

  double get_double() const
  {
    return get_knowledge_record().to_double();
  }

  std::string get_string() const
  {
    return get_knowledge_record().get_string();
  }

  template<typename R>
  R get_as() const
  {
    return knowledge_cast<R>(get_knowledge_record());
  }

  basic_container &operator=(const T& in)
  {
    return set(in);
  }

  basic_container &operator+=(const T& in)
  {
    return set((*this) + in);
  }

  basic_container &operator-=(const T& in)
  {
    return set((*this) - in);
  }

  basic_container &operator*=(const T& in)
  {
    return set((*this) * in);
  }

  basic_container &operator/=(const T& in)
  {
    return set((*this) / in);
  }

  basic_container &operator%=(const T& in)
  {
    return set((*this) % in);
  }

  basic_container &operator|=(const T& in)
  {
    return set((*this) | in);
  }

  basic_container &operator&=(const T& in)
  {
    return set((*this) & in);
  }

  basic_container &operator^=(const T& in)
  {
    return set((*this) ^ in);
  }

  template<typename I>
  basic_container &operator<<=(const I& in)
  {
    return set((*this) << in);
  }

  template<typename I>
  basic_container &operator>>=(const I& in)
  {
    return set((*this) << in);
  }

  basic_container &set(const T& in)
  {
    return set(in, this->settings);
  }

  basic_container &set(const T& in, const Knowledge_Update_Settings &settings)
  {
    return static_cast<Impl*>(this)->set(in, settings);
  }

  basic_container &set_knowledge_record(const Knowledge_Record &in)
  {
    return set_knowledge_record(in, this->settings);
  }

  basic_container &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    return static_cast<Impl*>(this)->set_knowledge_record(in, settings);
  }

  template<typename I>
  I bind()
  {
    return I(this->get_name(), this->get_kbase(), this->settings);
  }

  template<typename I>
  I bind(const Knowledge_Update_Settings &settings)
  {
    return I(this->get_name(), this->get_kbase(), settings);
  }
};

}

template<typename T>
class CachedContainer : public __INTERNAL__::basic_container<T, CachedContainer<T> >
{
protected:
  typedef __INTERNAL__::basic_container<T, CachedContainer<T> > Base;

  std::string name;
  T data;
  bool dirty;
public:
  CachedContainer<T>() {}
  CachedContainer<T>(Knowledge_Base &kb, const std::string &name)
    : Base(kb), name(name), data(kb.exists(name) ? knowledge_cast<T>(kb.get(name)) : T()), dirty(false) {}

  CachedContainer<T>(Knowledge_Base &kb, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(kb, settings), name(name),
      data(kb.exists(name, settings) ? knowledge_cast<T>(kb.get(name, settings)) : T()), dirty(false) {}

  CachedContainer<T>(const CachedContainer<T> &o)
    : Base(o.get_kbase(), o.settings), name(o.name), data(o.data), dirty(false) { }

  template<typename Impl>
  CachedContainer<T>(const __INTERNAL__::basic_container<T, Impl> &o)
    : Base(o.get_kbase(), o.get_settings()), name(o.get_name()),
      data(this->get_kbase().exists(this->get_name(), this->get_settings()) ?
        knowledge_cast<T>(this->get_kbase().get(this->get_name(), this->get_settings())) : T()), dirty(false) {
   // std::cerr << "Converting to Container type from " << typeid(Impl).name() << std::endl;
  }

  std::string get_name() const
  {
    return name;
  }
  
  Knowledge_Record get_knowledge_record() const {
    return knowledge_cast(data);
  }

  T get() const
  {
    return data;
  }

  CachedContainer &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    return set(knowledge_cast<T>(in), settings);
  }

  CachedContainer &set(const T& in, const Knowledge_Update_Settings &settings)
  {
    if(in != data)
    {
      dirty = true;
      data = in;
    }
    return *this;
  }

  bool is_dirty()
  {
    return dirty;
  }

  void push()
  {
    if(dirty)
    {
      this->get_kbase().get_context().set(name, knowledge_cast(data), this->get_settings());
      //std::cerr << "Pushing " << data << " to " << name << std::endl;
      dirty = false;
    }
  }

  void pull()
  {
    data = this->get_kbase().get_context().get(name, this->get_settings());
    dirty = false;
  }

  using Base::operator=;
  using Base::set;
  using Base::set_knowledge_record;
};

template<typename T>
class Container : public __INTERNAL__::basic_container<T, Container<T> >
{
protected:
  typedef __INTERNAL__::basic_container<T, Container<T> > Base;

  Variable_Reference var_ref;

public:
  Container<T>() {}
  Container<T>(Knowledge_Base &kb, const std::string &name)
    : Base(kb), var_ref(kb.get_ref(name)) {}

  Container<T>(Knowledge_Base &kb, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(kb, settings), var_ref(kb.get_ref(name, settings)) {}

  Container<T>(const Container<T> &o) : Base(o.get_kbase(), o.settings), var_ref(o.var_ref) { }

  template<typename Impl>
  Container<T>(const __INTERNAL__::basic_container<T, Impl> &o)
    : Base(o.get_kbase(), o.get_settings()), var_ref(o.get_kbase().get_ref(o.get_name()))
  {
   // std::cerr << "Converting to Container type from " << typeid(Impl).name() << std::endl;
  }

  std::string get_name() const
  {
    return std::string(const_cast<Container*>(this)->var_ref.get_name());
  }

  Knowledge_Record get_knowledge_record() const {
    return this->get_kbase().get(var_ref, this->get_settings());
  }

  T get() const
  {
    return knowledge_cast<T>(get_knowledge_record());
  }

  Container &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    this->get_kbase().get_context().set(var_ref, in, settings);
    return *this;
  }

  Container &set(const T& in, const Knowledge_Update_Settings &settings)
  {
    return set_knowledge_record(knowledge_cast(in), settings);
  }

  using Base::operator=;
  using Base::set;
  using Base::set_knowledge_record;
};


}
}
}

#endif
