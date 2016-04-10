/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

#ifndef _DMPL_SYMBOL_
#define _DMPL_SYMBOL_

/**
 * @file Variable.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DMPL model of computation.
 **/

#include <exception>
#include <map>
#include <set>
#include <string>
#include <bitset>
#include <deque>
#include "Type.h"
#include "Attribute.h"
#include <memory>

namespace dmpl
{
  /*******************************************************************/
  //-- forward declarations and typedefs
  /*******************************************************************/

  typedef size_t NodeId;
  
  class Variable;
  typedef std::shared_ptr<Variable> Var;
  typedef std::list <Var> VarList;
  typedef std::set <Var> VarSet;
  typedef std::list <Variable> VariablesList;
  typedef std::map <std::string, Var> Vars;
  typedef std::map <std::string, Variable> Variables;

  class Function;
  typedef std::shared_ptr<Function> Func;
  typedef std::map <std::string, Func> Funcs;
  typedef std::list <Func> FuncList;
  typedef std::set <Func> FuncSet;

  class Statement;
  typedef std::shared_ptr<Statement> Stmt;

  class Specification;
  typedef std::shared_ptr<Specification> Spec;
  typedef std::list <Spec> SpecList;
  typedef std::map<std::string,Spec> Specs;

  class RecordBase;
  typedef std::shared_ptr<RecordBase> Record;
  typedef std::list<Record> RecordList;
  typedef std::set<Record> RecordSet;
  typedef std::map<std::string,Record> Records;

  class BaseNode;
  typedef std::shared_ptr<BaseNode> Node;

  class BaseRole;
  typedef std::shared_ptr<BaseRole> Role;
  typedef std::map<std::string,Role> Roles;
  
  /*******************************************************************/
  //-- check is a string is a platform API symbol. right now we have
  //-- hard code platform API symbols. we need to make this more
  //-- flexible later on.
  /*******************************************************************/
  bool isPlatformSymbol(const std::string &s);

  /*******************************************************************/
  //-- names of variables to indicate mission exit, and exit code 
  /*******************************************************************/
  const std::string missionExitStatusName("MISSION_EXIT_STATUS");
  const std::string missionExitCodeName("MISSION_EXIT_CODE");
  
  /*******************************************************************/
  //-- helpful templates
  /*******************************************************************/
  struct virtual_enable_shared_from_this_base:
   std::enable_shared_from_this<virtual_enable_shared_from_this_base> {
   virtual ~virtual_enable_shared_from_this_base() {}
  };
  
  template<typename T>
  struct virtual_enable_shared_from_this:
  virtual virtual_enable_shared_from_this_base {
     std::shared_ptr<T> shared_from_this() {
        return std::dynamic_pointer_cast<T>(
           virtual_enable_shared_from_this_base::shared_from_this());
     }
  };

  namespace
  {
    //-- we use three bits to represent attributes of a symbolc access
    const size_t symacc_size = 3;
    typedef std::bitset<symacc_size> sa_bitset;
  }

  /*******************************************************************/
  //-- a class representing a symbol access
  /*******************************************************************/
  class SymbolAccess : public sa_bitset
  {
  public:
    //-- the three attributes of a symbol access. they equal indices
    //-- in the bit array where the attribute's value is stored.
    enum SymbolAccessType {
      WRITE = 0, REMOTE, EXPECT
    };

    //-- default constructor -- sets all attributes to OFF
    SymbolAccess() : sa_bitset() {}

    //-- constructor with initial values of attributes
    SymbolAccess(bool write = 0, bool remote = 0, bool expect = 0)
      : sa_bitset((write << WRITE) | (remote << REMOTE) | (expect << EXPECT)) {}

    //-- get value and reference to WRITE attribute
    bool write() const { return (*this)[WRITE]; }
    reference write() { return (*this)[WRITE]; }

    //-- get value and reference to REMOTE attribute
    bool remote() const { return (*this)[REMOTE]; }
    reference remote() { return (*this)[REMOTE]; }

    //-- get value and reference to EXPECT attribute
    bool expect() const { return (*this)[EXPECT]; }
    reference expect() { return (*this)[EXPECT]; }
  };

  namespace
  {
    //-- for each 2^symacc_size possible types of symbol access, we
    //-- use a bit to record if the synbol was accessed that way.
    const size_t symuse_size = 1 << symacc_size;
    typedef std::bitset<symuse_size> su_bitset;
  }

  /*******************************************************************/
  //-- a class representing a symbol usage. for each possible symbol 
  /*******************************************************************/
  class SymbolUseInfo : public su_bitset
  {
  public:
    //-- default constructor
    SymbolUseInfo() : su_bitset() {}

    //-- constructor with an initial value
    SymbolUseInfo(unsigned long i) : su_bitset(i) {}

    //-- const reader of a specific symbol access
    bool operator[](const SymbolAccess &sa) const
    {
      return su_bitset::operator[](sa.to_ulong());
    }

    //-- non-const reader of a specific symbol access
    reference operator[](const SymbolAccess &sa)
    {
      return su_bitset::operator[](sa.to_ulong());
    }

    //-- set a symbol access flag
    SymbolUseInfo &set(const SymbolAccess &sa, bool val = true)
    {
      su_bitset::set(sa.to_ulong(), val);
      return *this;
    }

    //-- reset all symbol access flags
    SymbolUseInfo &reset(const SymbolAccess &sa)
    {
      su_bitset::reset(sa.to_ulong());
      return *this;
    }

    //-- flip a symbol access flag
    SymbolUseInfo &flip(const SymbolAccess &sa)
    {
      su_bitset::flip(sa.to_ulong());
      return *this;
    }

    //-- const reader given the attributes of a symbol access
    bool operator()(bool write = false, bool remote = false, bool expect = false) const
    {
      return (*this)[SymbolAccess(write, remote, expect)];
    }

    //-- non-const reader given the attributes of a symbol access
    reference operator()(bool write = false, bool remote = false, bool expect = false)
    {
      return (*this)[SymbolAccess(write, remote, expect)];
    }

    //-- convert to bool
    explicit operator bool () const { return to_ulong(); }
    
    //-- mask for write access
    static const unsigned long write_mask =
          1 << ((1 << SymbolAccess::WRITE)) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    //-- mask for remote access
    static const unsigned long remote_mask =
          1 << ((1 << SymbolAccess::REMOTE)) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    //-- mask for expect access
    static const unsigned long expect_mask =
          1 << ((1 << SymbolAccess::EXPECT)) |
          1 << ((1 << SymbolAccess::EXPECT | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    //-- project on write accesses
    SymbolUseInfo anyWrite() const
    {
      return SymbolUseInfo(to_ulong() & write_mask);
    }

    //-- project on remote accesses
    SymbolUseInfo anyRemote() const
    {
      return SymbolUseInfo(to_ulong() & remote_mask);
    }

    //-- project on expect accesses
    SymbolUseInfo anyExpect() const
    {
      return SymbolUseInfo(to_ulong() & expect_mask);
    }

    //-- project on non-expect accesses
    SymbolUseInfo anyNonExpect() const
    {
      return SymbolUseInfo(to_ulong() & ~expect_mask);
    }

    //-- check any read access
    bool anyRead() const
    {
      return (*this)(0,0,0) || (*this)(0,0,1) || (*this)(0,1,0) || (*this)(0,1,1);
    }
  };

  /*******************************************************************/
  //-- forward declarations and typedefs
  /*******************************************************************/
  class SymbolUser;
  typedef std::shared_ptr<SymbolUser> SymUser;
  typedef std::vector<SymUser> SymUserList;
  typedef std::set<SymUser> SymUserSet;

  class Symbol;
  typedef std::shared_ptr<Symbol> Sym;

  class Namespace;
  typedef std::shared_ptr<Namespace> NSpace;

  /*******************************************************************/
  //-- a class representing a symbol
  /*******************************************************************/
  class Symbol : public HasAttributes, public virtual_enable_shared_from_this<Symbol>
  {
  public:
    //-- default constructor
    Symbol() : HasAttributes(), usage_summary(), users(), owner() {}
    //-- constructor with attributes
    Symbol(const Attributes &a) : HasAttributes(a), usage_summary(), users(), owner() {}

    //-- different symbol scopes
    static const int LOCAL = 501;
    static const int GLOBAL = 502;
    static const int GROUP = 503;
    static const int PARAM = 504;
    static const int TEMP = 505;
    static const int SELF_ID = 506;
    static const int INDEP_ID = 507;

    SymbolUseInfo usage_summary;
    SymUserSet users;
    NSpace owner;

    //-- return name, type and scope
    virtual std::string getName() const = 0;
    virtual const Type &getType() = 0;
    virtual int getScope() { return LOCAL; }

    //-- merge with another symbolc
    virtual void mergeWith(const Symbol &other)
    {
      throw std::runtime_error("Symbol merging not supported for symbol " + getName());
    }

    //-- convert another object to a Symbol
    Sym asSym() { return std::dynamic_pointer_cast<Symbol>(shared_from_this()); }
    //-- convert a sumbol to a function
    Func asFunc();
    //-- convert a symbol to a variable
    Var asVar();

    //-- record the use of a symbol
    virtual void use(const SymUser &suser, bool isWrite, bool isRemote, bool isExpect);
  };

  //-- typdefs for a list of symbols and a map from names to symbols
  typedef std::list <Sym> SymList;
  typedef std::map <std::string, Sym> Syms;

  /*******************************************************************/
  //-- an abstract class representing a map from names to symbols
  /*******************************************************************/
  class SymbolBinder
  {
  public:
    virtual Sym findSym(const std::string &name) const = 0;
  };

  typedef std::shared_ptr<SymbolBinder> SymBinder;
  
  /*******************************************************************/
  //-- a class representing a symbol usage
  /*******************************************************************/
  class SymbolUse
  {
  public:
    SymbolUse() {}
    SymbolUse(const Sym &s) : sym(s) {}

    SymbolUseInfo info;
    Sym sym;
  };

  //-- a vector of symbol usage
  typedef std::vector<SymbolUse> UsedSymbols;

  //-- the summary of a symbol's usage. represents its usage as a
  //-- local and as a global.
  namespace
  {
    const size_t symsum_size = symuse_size * 2;
    typedef std::bitset<symsum_size> ss_bitset;
  }

  /*******************************************************************/
  //-- a class representing the summary of a symbol's usage
  /*******************************************************************/
  class SymbolUseSummary : public ss_bitset
  {
  public:
    //-- default constructor
    SymbolUseSummary() : ss_bitset() {}
    //-- constructor from a value
    SymbolUseSummary(unsigned long i) : ss_bitset(i) {}

    //-- return the usage as a local
    SymbolUseInfo local() const
    {
      return SymbolUseInfo(to_ulong() & ( (1 << symuse_size) - 1 ));
    }

    //-- return the usage as a global
    SymbolUseInfo global() const
    {
      return SymbolUseInfo(to_ulong() >> symuse_size);
    }

    using ss_bitset::operator|=;

    //-- a class representing a reference to a subset of the symbol
    //-- usage. has the full usage plus an on offset denoting the
    //-- start of the offset
    class sub_ref
    {
    protected:
      SymbolUseSummary &sum;
      unsigned short offset;

      //-- constructor. SC: seems like i can be either 0 or 1. why not
      //-- make it a bool?
      sub_ref(SymbolUseSummary &s, unsigned short i) : sum(s), offset(i * symuse_size) {}

    public:
      friend class SymbolUseSummary;

      operator SymbolUseInfo()
      {
        return SymbolUseInfo((sum.to_ulong() >> offset) & ((1 << symuse_size) - 1));
      }

      //-- SC: Do we need this unsafe cast?
      SymbolUseInfo get()
      {
        return (SymbolUseInfo)(*this);
      }

      //-- various operators. SC: I need to understand these (and the
      //-- sub_ref class) better.
      sub_ref &operator=(const SymbolUseInfo &o)
      {
        unsigned long mask = ~(((1 << symuse_size) - 1) << offset);
        sum = (sum.to_ulong() & mask) | (o.to_ulong() << offset);
        return *this;
      }

      sub_ref &operator|=(const SymbolUseInfo &o)
      {
        sum |= SymbolUseSummary(o.to_ulong() << offset);
        return *this;
      }

      sub_ref &operator^=(const SymbolUseInfo &o)
      {
        sum ^= SymbolUseSummary(o.to_ulong() << offset);
        return *this;
      }

      sub_ref &operator&=(const SymbolUseInfo &o)
      {
        unsigned long mask = ~(((1 << symuse_size) - 1) << offset);
        sum &= SymbolUseSummary((o.to_ulong() << offset) | mask);
        return *this;
      }
    };

    //-- return the local usage
    sub_ref local()
    {
      return sub_ref(*this, 0);
    }

    //-- return the global usage
    sub_ref global()
    {
      return sub_ref(*this, 1);
    }

    //-- return the summary obtained by adding a new usage
    SymbolUseSummary operator|(const SymbolUse &o) const
    {
      return SymbolUseSummary(*this) |= o;
    }

    //-- update the summary in place by adding a usage
    SymbolUseSummary &operator|=(const SymbolUse &o)
    {
      switch(o.sym->getScope())
      {
      case Symbol::LOCAL:
        local() |= o.info;
        break;
      case Symbol::GLOBAL:
        global() |= o.info;
        break;
      default:
        break;
      }
      return *this;
    }
  };

  /*******************************************************************/
  //-- a class representing a symbol user
  /*******************************************************************/
  class SymbolUser : public virtual_enable_shared_from_this<SymbolUser>
  {
  public:
    SymbolUseSummary summary;
    UsedSymbols allUsedSymbols;

    //-- a flag to indicate if symbol usage analysis was performed
    bool analyzed;
    
    //-- the context for a symbol user
    class Context
    {
    public:
      BaseNode *node;
      BaseRole *role;
      Spec spec;
      Func curFunc;
      bool isLHS;
      std::deque<const SymbolBinder*> binders;

      //constructors
      Context() : node(0), role(0), isLHS(false) {}
      Context(BaseNode *n, BaseRole *r, const Spec &s, const Func &cf, const bool il)
        : node(n), role(r), spec(s), curFunc(cf), isLHS(il) {}
      
      Sym findSym(const std::string &name);

      void addBinder(const SymbolBinder *binder)
      {
        binders.push_front(binder);
      }

      bool inExpect();
    };

    //-- constructors
    SymbolUser() : analyzed(0) {}
    
    virtual bool recordUse() { return false; }

    //-- method to compute set of parent nodes to process recursively
    //-- during symbol usage analysis
    virtual SymUserList getParents(Context &con) { return SymUserList(); }

    //-- method to compute used symbols
    virtual Context useSymbols(Context con);

    virtual std::string toString() const = 0;

    //-- analyze symbol usage by a function under a context
    static void analyzeSymbolUsage(const Func &func, Context con);

    //-- analyze symbol usage by a node
    static void analyzeSymbolUsage(BaseNode &node);

    //-- return the use of the argument symbol. NULL is not used.
    SymbolUse *findSymbol(const Sym &s)
    {
      BOOST_FOREACH(SymbolUse &c, allUsedSymbols)
        if(c.sym == s) return &c;

      return NULL;
    }

    friend class Symbol;
    
  protected:
    void analyzeSymbolUsage(Context con);

    void inherit(const SymUser &o);

    SymbolUse &findOrAddSymbol(const Sym &s)
    {
      BOOST_FOREACH(SymbolUse &c, allUsedSymbols)
      {
        if(c.sym == s)
          return c;
      }
      allUsedSymbols.push_back(SymbolUse(s));
      return allUsedSymbols.back();
    }

    //-- return a list of all used symbol names
    std::string usedSymStr() const
    {
      std::string res = "(";
      for(const SymbolUse &su : allUsedSymbols) {
        res = res + " " + su.sym->getName();
      }
      return res + ")";
    }
  };
}


#endif // _DMPL_SYMBOL_

/*********************************************************************/
//-- end of Symbol.h
/*********************************************************************/
