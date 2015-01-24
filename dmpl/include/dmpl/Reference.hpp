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
#define USE_CPP11
#define USE_RVAL_REF
#define USE_VAR_TMPL
#define USE_STD_ARRAY
#define USE_DELETE_MEMBER
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
class basic_reference
{
protected:
  Thread_Safe_Context &context;

  basic_reference(Knowledge_Base &kbase)
    : context(kbase.get_context()), settings() {}

  basic_reference(Thread_Safe_Context &con)
    : context(con), settings() {}

  basic_reference(Thread_Safe_Context &con, const Knowledge_Update_Settings &settings)
    : context(con), settings(settings) {}

  basic_reference(Knowledge_Base &kbase, const Knowledge_Update_Settings &settings)
    : context(kbase.get_context()), settings(settings) {}
public:
  Knowledge_Update_Settings settings;

  std::string get_name() const
  {
    return static_cast<const Impl*>(this)->get_name();
  }

  Thread_Safe_Context &get_context() const
  {
    return context;
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

  void mark_modified()
  {
    static_cast<const Impl*>(this)->mark_modified();
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

  const T &operator=(const basic_reference &in)
  {
    return set(in.get());
  }

  template<class E>
  const T &operator=(const basic_reference<T, E> &in)
  {
    return this->set(in.get());
  }

  const T &operator=(const T& in)
  {
    return set(in);
  }

  const T &operator+=(const T& in)
  {
    return set((*this) + in);
  }

  const T &operator-=(const T& in)
  {
    return set((*this) - in);
  }

  const T &operator*=(const T& in)
  {
    return set((*this) * in);
  }

  const T &operator/=(const T& in)
  {
    return set((*this) / in);
  }

  const T &operator%=(const T& in)
  {
    return set((*this) % in);
  }

  const T &operator|=(const T& in)
  {
    return set((*this) | in);
  }

  const T &operator&=(const T& in)
  {
    return set((*this) & in);
  }

  const T &operator^=(const T& in)
  {
    return set((*this) ^ in);
  }

  template<typename I>
  const T &operator<<=(const I& in)
  {
    return set((*this) << in);
  }

  template<typename I>
  const T &operator>>=(const I& in)
  {
    return set((*this) << in);
  }

  const T &set(const T& in)
  {
    return set(in, this->settings);
  }

  const T &set(const T& in, const Knowledge_Update_Settings &settings)
  {
    return static_cast<Impl*>(this)->set(in, settings);
  }

  const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in)
  {
    return set_knowledge_record(in, this->settings);
  }

  const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    return static_cast<Impl*>(this)->set_knowledge_record(in, settings);
  }
};

}

template<typename T>
class CachedReference : public __INTERNAL__::basic_reference<T, CachedReference<T> >
{
protected:
  typedef __INTERNAL__::basic_reference<T, CachedReference<T> > Base;

#ifdef USE_CPP11
  const std::string name;
#else
  // to support putting CachedReference in a vector, pre-C++11, must be assignable
  std::string name;
#endif
  bool exist:1;
  bool dirty:1;
  bool create:1;
  Variable_Reference var_ref;
  T data;
public:

  CachedReference<T>(Thread_Safe_Context &con, const std::string &name)
    : Base(con), name(name), exist(con.exists(name)), dirty(false), create(false),
      var_ref(exist ? con.get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(con.get(name)) : T()) {}

  CachedReference<T>(Knowledge_Base &kbase, const std::string &name)
    : Base(kbase), name(name), exist(this->get_context().exists(name)), dirty(false), create(false),
      var_ref(exist ? this->get_context().get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(this->get_context().get(name)) : T()) {}

  CachedReference<T>(Thread_Safe_Context &con, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(con, settings), name(name), exist(con.exists(name, settings)), dirty(false), create(false),
      var_ref(exist ? con.get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(con.get(name, settings)) : T()) {}

  CachedReference<T>(Knowledge_Base &kbase, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(kbase, settings), name(name),
      exist(this->get_context().exists(name, settings)), dirty(false), create(false),
      var_ref(exist ? this->get_context().get_ref(name) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(this->get_context().get(name, settings)) : T()) {}

  CachedReference<T>(const CachedReference<T> &o)
    : Base(o.get_context(), o.settings), name(o.name), exist(o.exist), dirty(o.dirty),
      create(o.create), var_ref(o.var_ref), data(o.data) { }

  template<typename Impl>
  CachedReference<T>(const __INTERNAL__::basic_reference<T, Impl> &o)
    : Base(o.get_context(), o.get_settings()), name(o.get_name()),
      exist(this->get_context().exists(this->get_name(), this->get_settings())), dirty(false), create(false),
      var_ref(exist ? this->get_context().get_ref(this->get_name(), this->get_settings()) : Variable_Reference()),
      data(exist ? knowledge_cast<T>(this->get_context().get(this->get_name(), this->get_settings())) : T()) {
   // std::cerr << "Converting to CachedReference type from " << typeid(Impl).name() << std::endl;
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

  const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    return set(knowledge_cast<T>(in), settings);
  }

  const T &set(const T& in, const Knowledge_Update_Settings &settings)
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
    return data;
  }

  bool is_dirty()
  {
    return dirty;
  }

  void mark_modified()
  {
    dirty = true;
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
    //std::cerr<<"pull_keep_local @ " << this->get_name() << ": dirty " << dirty << std::endl;
    if(!dirty)
      pull();
  }

  using Base::operator=;
  using Base::set;
  using Base::set_knowledge_record;
};

template<typename T>
class Reference : public __INTERNAL__::basic_reference<T, Reference<T> >
{
protected:
  typedef __INTERNAL__::basic_reference<T, Reference<T> > Base;

#ifdef USE_CPP11
  const Variable_Reference var_ref;
#else
  // to support putting Reference in a vector, pre-C++11, must be assignable
  Variable_Reference var_ref;
#endif

public:
  Reference<T>(const Reference<T> &o) : Base(o.get_context(), o.settings), var_ref(o.var_ref) { }

  Reference<T>(Thread_Safe_Context &con, const std::string &name)
    : Base(con), var_ref(con.get_ref(name)) {}

  Reference<T>(Thread_Safe_Context &con, const std::string &name, const T& def)
    : Base(con), var_ref(con.get_ref(name))
  {
    set(def);
  }

  Reference<T>(Knowledge_Base &kbase, const std::string &name)
    : Base(kbase), var_ref(this->get_context().get_ref(name)) {}

  Reference<T>(Knowledge_Base &kbase, const std::string &name, const T& def)
    : Base(kbase), var_ref(this->get_context().get_ref(name))
  {
    set(def);
  }

  Reference<T>(Thread_Safe_Context &con, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(con, settings), var_ref(con.get_ref(name, settings)) {}

  Reference<T>(Thread_Safe_Context &con, const std::string &name, const T& def, const Knowledge_Update_Settings &settings)
    : Base(con, settings), var_ref(con.get_ref(name, settings))
  {
    set(def);
  }

  Reference<T>(Knowledge_Base &kbase, const std::string &name, const Knowledge_Update_Settings &settings)
    : Base(kbase, settings), var_ref(this->get_context().get_ref(name, settings)) {}

  Reference<T>(Knowledge_Base &kbase, const std::string &name, const T& def, const Knowledge_Update_Settings &settings)
    : Base(kbase, settings), var_ref(this->get_context().get_ref(name, settings))
  {
    set(def);
  }

  template<typename Impl>
  Reference<T>(const __INTERNAL__::basic_reference<T, Impl> &o)
    : Base(o.get_context(), o.get_settings()), var_ref(o.get_context().get_ref(o.get_name()))
  {
   // std::cerr << "Converting to Reference type from " << typeid(Impl).name() << std::endl;
  }

  /*
  const T &operator=(const Reference &in)
  {
    return set(in.get(), this->get_settings());
  }*/

  std::string get_name() const
  {
    // const_cast required to workaround missing const decorator;
    // current implementation is actually const
    return std::string(const_cast<Variable_Reference&>(this->var_ref).get_name());
  }

  void mark_modified()
  {
    this->get_context().mark_modified(var_ref);
  }

  Knowledge_Record get_knowledge_record() const {
    return this->get_context().get(var_ref, this->get_settings());
  }

  T get() const
  {
    return knowledge_cast<T>(get_knowledge_record());
  }

  const Knowledge_Record &set_knowledge_record(const Knowledge_Record &in, const Knowledge_Update_Settings &settings)
  {
    this->get_context().set(var_ref, in, settings);
    return in;
  }

  const T &set(const T& in, const Knowledge_Update_Settings &settings)
  {
    set_knowledge_record(knowledge_cast(in), settings);
    return in;
  }

  using Base::operator=;
  using Base::set;
  using Base::set_knowledge_record;
};


}
}
}

#endif
