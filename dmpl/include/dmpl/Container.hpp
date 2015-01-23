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
#include <madara/knowledge_engine/Thread_Safe_Context.h>
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
  Thread_Safe_Context *context;
public:
  basic_container() {}
  basic_container(Thread_Safe_Context &con)
    : context(&con), settings() {}

  basic_container(Thread_Safe_Context &con, const Knowledge_Update_Settings &settings)
    : context(&con), settings(settings) {}
public:
  Knowledge_Update_Settings settings;

  std::string get_name() const
  {
    return static_cast<const Impl*>(this)->get_name();
  }

  bool valid() const
  {
    return context != NULL;
  }

  Thread_Safe_Context &get_context() const
  {
    return *context;
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
    return get_context().exists(get_name(), get_settings());
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
};

}

template<typename T>
class CachedContainer : public __INTERNAL__::basic_container<T, CachedContainer<T> >
{
protected:
  typedef __INTERNAL__::basic_container<T, CachedContainer<T> > Base;

  std::string name;
  bool exist:1;
  bool dirty:1;
  bool create:1;
  Variable_Reference var_ref;
  T data;
public:
  CachedContainer<T>() {}
  CachedContainer<T>(Thread_Safe_Context &con, const std::string &name)
    : Base(con), name(name), exist(con.exists(name)), dirty(false), create(false),
      var_ref(exist ? con.get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(con.get(name)) : T()) {}

  CachedContainer<T>(Thread_Safe_Context &con, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(con, settings), name(name), exist(con.exists(name, settings)), dirty(false), create(false),
      var_ref(exist ? con.get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(con.get(name, settings)) : T()) {}

  CachedContainer<T>(const CachedContainer<T> &o)
    : Base(o.get_context(), o.settings), name(o.name), exist(o.exist), dirty(o.dirty),
      create(o.create), var_ref(o.var_ref), data(o.data) { }

  template<typename Impl>
  CachedContainer<T>(const __INTERNAL__::basic_container<T, Impl> &o)
    : Base(o.get_context(), o.get_settings()), name(o.get_name()),
      exist(this->get_context().exists(this->get_name(), this->get_settings())), dirty(false), create(false),
      var_ref(exist ? this->get_context().get_ref(this->get_name(), this->get_settings()) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(this->get_context().get(this->get_name(), this->get_settings())) : T()) {
   // std::cerr << "Converting to CachedContainer type from " << typeid(Impl).name() << std::endl;
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
    if(!exist)
    {
      exist = true;
      create = true;
      dirty = true;
      data = in;
    } else if(in != data)
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

  void ensure_exists()
  {
    if(create)
    {
      var_ref = this->get_context().get_ref(name, this->get_settings());
      create = false;
    }
  }

  void push()
  {
    if(dirty)
    {
      ensure_exists();
      this->get_context().set(var_ref, knowledge_cast(data), this->get_settings());
      //std::cerr << "Pushing " << data << " to " << name << std::endl;
      dirty = false;
    }
  }

  void pull()
  {
    ensure_exists();
    data = knowledge_cast<T>(this->get_context().get(var_ref, this->get_settings()));
    dirty = false;
  }

  void pull_keep_local()
  {
    if(!dirty)
      pull();
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
  Container<T>(Thread_Safe_Context &con, const std::string &name)
    : Base(con), var_ref(con.get_ref(name)) {}

  Container<T>(Thread_Safe_Context &con, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(con, settings), var_ref(con.get_ref(name, settings)) {}

  Container<T>(const Container<T> &o) : Base(o.get_context(), o.settings), var_ref(o.var_ref) { }

  template<typename Impl>
  Container<T>(const __INTERNAL__::basic_container<T, Impl> &o)
    : Base(o.get_context(), o.get_settings()), var_ref(o.get_context().get_ref(o.get_name()))
  {
   // std::cerr << "Converting to Container type from " << typeid(Impl).name() << std::endl;
  }

  std::string get_name() const
  {
    return std::string(const_cast<Container*>(this)->var_ref.get_name());
  }

  Knowledge_Record get_knowledge_record() const {
    return this->get_context().get(var_ref, this->get_settings());
  }

  T get() const
  {
    return knowledge_cast<T>(get_knowledge_record());
  }

  Container &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    this->get_context().set(var_ref, in, settings);
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
