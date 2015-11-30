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

#include <iostream>
#include <stdio.h>
#include <boost/foreach.hpp>
#include "Symbol.h"
#include "Node.h"
#include "Statement.h"
#include "Specification.hpp"

namespace dmpl
{
  /*******************************************************************/
  //-- record the use of a symbol
  /*******************************************************************/
  void Symbol::use(const SymUser &suser = SymUser(), bool isWrite = false,
                   bool isRemote = false, bool isExpect = false)
  {
    //std::cerr << "Using symbol " << (*this)->getName() << " " <<
    //isWrite << " " << isRemote << " " << isExpect << std::endl;
    SymbolAccess sa(isWrite, isRemote, isExpect);
    //std::cerr << "sa: " << sa << std::endl;
    this->usage_summary.set(sa);
    if(suser != NULL)
    {
      SymbolUse &su = suser->findOrAddSymbol(shared_from_this());
      su.info.set(sa);
      //std::cerr << "su: " << su.info << std::endl;

      suser->summary |= su;

      if(suser->recordUse())
        this->users.insert(suser);
    }
  }

  /*******************************************************************/
  //-- inherit usage from another user
  /*******************************************************************/
  void SymbolUser::inherit(const SymUser &o)
  {
    summary |= o->summary;
    BOOST_FOREACH(const SymbolUse &c, o->allUsedSymbols)
    {
      SymbolUse &t = findOrAddSymbol(c.sym);
      t.info |= c.info;

      if(recordUse())
        c.sym->users.insert(shared_from_this());
    }
  }

  /*******************************************************************/
  //-- analyze symbol usage by a function under a context
  /*******************************************************************/
  void SymbolUser::analyzeSymbolUsage(const Func &func, Context con)
  {
    //-- analyze symbol usage
    Sym fsym = Sym(func);
    fsym->use();
    func->useSymbols(con);
  }
  
  /*******************************************************************/
  //-- analyze symbol usage by a node
  /*******************************************************************/
  void SymbolUser::analyzeSymbolUsage(BaseNode &node)
  {
    //-- analyse threads
    for(Func &f : node.threads) {
      analyzeSymbolUsage(f, Context(&node, NULL, Spec(), f, f, false));
      f->computeAccessed();
    }
    
    //-- analyse constructors of local and global variables
    for(const auto &v : node.allVars()) {
      if(v->initFunc != NULL) {
        analyzeSymbolUsage(v->initFunc, Context(&node, NULL, Spec(), Func(), v->initFunc, false));
        v->initFunc->computeAccessed();
      }
    }
    //-- analyse constructors and assumption functions of all records
    for(const auto &rec : node.records) {
      if(rec.second->initFunc != NULL) {
        analyzeSymbolUsage(rec.second->initFunc,
                           Context(&node, NULL, Spec(), Func(), rec.second->initFunc, false));
        rec.second->initFunc->computeAccessed();
      }
      if(rec.second->assumeFunc != NULL) {
        analyzeSymbolUsage(rec.second->assumeFunc,
                           Context(&node, NULL, Spec(), Func(), rec.second->assumeFunc, false));
        rec.second->assumeFunc->computeAccessed();
      }
    }

    //-- analyse roles
    for(const Roles::value_type &r : node.roles) {
      //-- analyse threads
      for(Func &f : r.second->threads) {
        //-- if prototype, inherit from node-level thread
        if(f->isPrototype) {            
          Func nodeFunc = node.findFunc(f->name);
          if(nodeFunc == NULL || !nodeFunc->isThread())
            throw std::runtime_error("ERROR: no thread " + f->name + " in parent node " +
                                     node.name + " of role " + r.second->name +
                                     " to inherit from!!");
          f->inherit(nodeFunc);
        }
        //-- else analyze
        else
          analyzeSymbolUsage(f, Context(&node, r.second.get(), Spec(), f, f, false));
      }

      //-- analyse constructors of local and global variables
      for(const auto &v : r.second->allVars()) {
        if(v->initFunc != NULL) {
          analyzeSymbolUsage(v->initFunc,
                             Context(&node, r.second.get(), Spec(), Func(), v->initFunc, false));
          v->initFunc->computeAccessed();
        }
      }
      
      //-- analyse constructors and assumption functions of all records
      for(const auto &rec : r.second->records) {
        if(rec.second->initFunc != NULL) {
          analyzeSymbolUsage(rec.second->initFunc,
                             Context(&node, r.second.get(), Spec(), Func(), rec.second->initFunc, false));
          rec.second->initFunc->computeAccessed();
        }
        if(rec.second->assumeFunc != NULL) {
          analyzeSymbolUsage(rec.second->assumeFunc,
                             Context(&node, r.second.get(), Spec(), Func(), rec.second->assumeFunc, false));
          rec.second->assumeFunc->computeAccessed();
        }
      }
      
      //-- analyse specifications
      BOOST_FOREACH(const Specs::value_type &s, r.second->specs) {
        Context con(&node, r.second.get(), s.second, Func(), Func(), false);
        s.second->useSymbols(con);
      }

      //-- set accessed of funcs
      for(const Funcs::value_type &f : r.second->funcs) f.second->computeAccessed();
    }

    //-- analyse specifications
    BOOST_FOREACH(const Specs::value_type &s, node.specs)
    {
      Context con(&node, NULL, s.second, Func(), Func(), false);
      s.second->useSymbols(con);
    }

    //-- set accessed of funcs
    for(auto &f : node.funcs) f.second->computeAccessed();
  }

  /*******************************************************************/
  //-- inherit symbol usage from parents
  /*******************************************************************/
  SymbolUser::Context SymbolUser::useSymbols(Context con)
  {
    BOOST_FOREACH(const SymUser &su, getParents(con))
    {
      su->useSymbols(con);
      inherit(su);
    }
    return con;
  }
  
  /*******************************************************************/
  //-- find a symbol given its name
  /*******************************************************************/
  Sym SymbolUser::Context::findSym(const std::string &name)
  {
    //-- first check enclosing scopes
    BOOST_FOREACH(const SymbolBinder *b, binders)
    {
      Sym v = b->findSym(name);
      if(v) return v;
    }
    //-- next check the enclosing function
    if(curFunc)
    {
      Var v = curFunc->findVar(name);
      if(v) return std::static_pointer_cast<Sym::element_type>(v);
    }
    //-- next check the enclosing role
    if(role) {
      Sym s = role->findSym(name);
      if(s) return s;
    }
    //-- finally check the enclosing node
    if(node) return node->findSym(name);
    //-- if all fails, return default symbol
    return Sym();
  }

  /*******************************************************************/
  //-- return true if the context corresponds to an expect clause
  /*******************************************************************/
  bool SymbolUser::Context::inExpect()
  {
    return dynamic_cast<ExpectSpec*>(&*spec) != NULL;
  }
}

/*********************************************************************/
//-- end of Symbol.cpp
/*********************************************************************/
