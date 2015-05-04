/**
 * Copyright (c) 2014 Carnegie Mellon University. All Rights Reserved.

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

 * DM-0001023
**/

#ifndef _DMPL_SYMBOL_
#define _DMPL_SYMBOL_

/**
 * @file Variable.h
 * @author James Edmondson <jedmondson@gmail.com>
 *
 * This file contains a class definition for the DMPL model of computation.
 **/

#include <map>
#include <set>
#include <string>
#include <bitset>
#include <deque>
//#include "SelfRef.h"
//#include "Function.h"
#include "Type.h"


namespace dmpl
{
  class Variable;
  typedef boost::shared_ptr<Variable> Var;
  typedef std::list <Var> VarList;
  typedef std::list <Variable> VariablesList;
  typedef std::map <std::string, Var> Vars;
  typedef std::map <std::string, Variable> Variables;

  class Function;
  typedef boost::shared_ptr<Function> Func;
  typedef std::list <Func> FuncList;

  class Statement;
  typedef boost::shared_ptr<Statement> Stmt;
  class CondStmt;
  typedef boost::shared_ptr<CondStmt> CStmt;

  template<class I> class AsInt
  {
  public:
    I asInt() const
    {
      return reinterpret_cast<const I &>(*this);
    }

    I &asInt()
    {
      return reinterpret_cast<I &>(*this);
    }

    AsInt() { }

    AsInt(I i)
    {
      asInt() = i;
    }

    AsInt(const AsInt<I> &o)
    {
      asInt() = o.asInt();
    }
  };

  namespace
  {
    const size_t symacc_size = 3;
    typedef std::bitset<symacc_size> sa_bitset;
  }

  class SymbolAccess : public sa_bitset
  {
  public:
    enum SymbolAccessType {
      WRITE = 0, REMOTE, EXPECT
    };

    SymbolAccess() : sa_bitset() {}

    SymbolAccess(bool write = 0, bool remote = 0, bool expect = 0)
      : sa_bitset((write << WRITE) | (remote << REMOTE) | (expect << EXPECT)) {}

    bool write() const { return (*this)[WRITE]; }
    reference write() { return (*this)[WRITE]; }

    bool remote() const { return (*this)[REMOTE]; }
    reference remote() { return (*this)[REMOTE]; }

    bool expect() const { return (*this)[EXPECT]; }
    reference expect() { return (*this)[EXPECT]; }
  };

  namespace
  {
    const size_t symuse_size = 1 << symacc_size;
    typedef std::bitset<symuse_size> su_bitset;
  }

  class SymbolUseInfo : public su_bitset
  {
  public:
    SymbolUseInfo() : su_bitset() {}
    SymbolUseInfo(unsigned long i) : su_bitset(i) {}

    bool operator[](const SymbolAccess &sa) const
    {
      return su_bitset::operator[](sa.to_ulong());
    }

    reference operator[](const SymbolAccess &sa)
    {
      return su_bitset::operator[](sa.to_ulong());
    }

    SymbolUseInfo &set(const SymbolAccess &sa, bool val = true)
    {
      su_bitset::set(sa.to_ulong(), val);
      return *this;
    }

    SymbolUseInfo &reset(const SymbolAccess &sa)
    {
      su_bitset::reset(sa.to_ulong());
      return *this;
    }

    SymbolUseInfo &flip(const SymbolAccess &sa)
    {
      su_bitset::flip(sa.to_ulong());
      return *this;
    }

    bool operator()(bool write = false, bool remote = false, bool expect = false) const
    {
      return (*this)[SymbolAccess(write, remote, expect)];
    }

    reference operator()(bool write = false, bool remote = false, bool expect = false)
    {
      return (*this)[SymbolAccess(write, remote, expect)];
    }
  public:

    static const unsigned long write_mask =
          1 << ((1 << SymbolAccess::WRITE)) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    static const unsigned long remote_mask =
          1 << ((1 << SymbolAccess::REMOTE)) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    static const unsigned long expect_mask =
          1 << ((1 << SymbolAccess::EXPECT)) |
          1 << ((1 << SymbolAccess::EXPECT | 1 << SymbolAccess::REMOTE )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::EXPECT )) |
          1 << ((1 << SymbolAccess::WRITE | 1 << SymbolAccess::REMOTE | 1 << SymbolAccess::EXPECT )) ;

    SymbolUseInfo anyWrite()
    {
      return SymbolUseInfo(to_ulong() & write_mask);
    }

    SymbolUseInfo anyRemote()
    {
      return SymbolUseInfo(to_ulong() & remote_mask);
    }

    SymbolUseInfo anyExpect()
    {
      return SymbolUseInfo(to_ulong() & expect_mask);
    }

    SymbolUseInfo anyNonExpect()
    {
      return SymbolUseInfo(to_ulong() & ~expect_mask);
    }
  };

  class SymbolUser;
  typedef boost::shared_ptr<SymbolUser> SymUser;
  typedef std::vector<SymUser> SymUserList;
  typedef std::set<SymUser> SymUserSet;

  class Symbol
  {
  public:
    static const int LOCAL = 501;
    static const int GLOBAL = 502;
    static const int PARAM = 503;
    static const int TEMP = 504;
    static const int SELF_ID = 505;
    static const int INDEP_ID = 506;

    SymbolUseInfo usage_summary;
    SymUserSet users;

    virtual std::string getName() const = 0;
    virtual const Type &getType() = 0;
    virtual int getScope() { return LOCAL; }

    virtual bool canRead() { return true; }
    virtual bool canWrite() { return true; }
  };

  typedef boost::shared_ptr<Symbol> SymBase;

  class Sym : public SymBase
  {
  public:
    Func asFunc();
    Var asVar();

    Sym() : SymBase() {}
    Sym(const SymBase &o) : SymBase(o) {}

    void use(const SymUser &suser, bool isWrite, bool isRemote, bool isExpect);
  };

  typedef std::list <Sym> SymList;
  typedef std::map <std::string, Sym> Syms;

  class SymbolBinder
  {
  public:
    virtual Sym findSym(const std::string &name) const = 0;
  };

  typedef boost::shared_ptr<SymbolBinder> SymBinder;
  
  class SymbolUse
  {
  public:
    SymbolUse() {}
    SymbolUse(const Sym &s) : sym(s) {}

    SymbolUseInfo info;
    Sym sym;
  };

  typedef std::vector<SymbolUse> UsedSymbols;

  namespace
  {
    const size_t symsum_size = symuse_size * 2;
    typedef std::bitset<symsum_size> ss_bitset;
  }

  class SymbolUseSummary : public ss_bitset
  {
  public:
    SymbolUseSummary() : ss_bitset() {}
    SymbolUseSummary(unsigned long i) : ss_bitset(i) {}

    SymbolUseInfo local() const
    {
      return SymbolUseInfo(to_ulong() & ( (1 << symuse_size) - 1 ));
    }

    SymbolUseInfo global() const
    {
      return SymbolUseInfo(to_ulong() >> symuse_size);
    }

    using ss_bitset::operator|=;

    class sub_ref
    {
    protected:
      SymbolUseSummary &sum;
      unsigned short offset;

      sub_ref(SymbolUseSummary &s, unsigned short i) : sum(s), offset(i * symuse_size) {}
    public:
      friend class SymbolUseSummary;

      operator SymbolUseInfo()
      {
        return SymbolUseInfo((sum.to_ulong() >> offset) & ((1 << symuse_size) - 1));
      }

      SymbolUseInfo get()
      {
        return (SymbolUseInfo)(*this);
      }

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

    sub_ref local()
    {
      return sub_ref(*this, 0);
    }

    sub_ref global()
    {
      return sub_ref(*this, 1);
    }

    SymbolUseSummary operator|(const SymbolUse &o) const
    {
      return SymbolUseSummary(*this) |= o;
    }

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

  class Node;

  class SymbolUser
  {
  public:
    SymbolUseSummary summary;
    UsedSymbols allUsedSymbols;

    class Context
    {
    public:
      Node *node;
      CStmt clause;
      Func thread;
      Func curFunc;
      bool isLHS;
      std::deque<const SymbolBinder*> binders;

      Sym findSym(const std::string &name);

      void addBinder(const SymbolBinder *binder)
      {
        binders.push_front(binder);
      }

      bool inExpect();
    };
  
    virtual bool recordUse() { return false; }

    virtual SymUserList getParents(Context &con) { return SymUserList(); }
    virtual Context useSymbols(const SymUser &self, Context con);

    static void analyzeSymbolUsage(Node &n);

    SymbolUse *findSymbol(const Sym &s)
    {
      BOOST_FOREACH(SymbolUse &c, allUsedSymbols)
      {
        if(c.sym == s)
          return &c;
      }
      return NULL;
    }

    friend class Sym;
  protected:
    static void analyzeSymbolUsage(const SymUser &cur, Context con);

    static void inherit(const SymUser &me, const SymUser &o);

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
  };
}


#endif // _DMPL_SYMBOL_
