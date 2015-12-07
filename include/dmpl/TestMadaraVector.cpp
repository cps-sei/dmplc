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

#include <string>
#include <boost/foreach.hpp>
#include <boost/lexical_cast.hpp>
#include <madara/knowledge/containers/Integer.h>
#include <madara/knowledge/containers/IntegerVector.h>

#include "ArrayReference.hpp"
#include "Reference.hpp"
#include "CachedReference.hpp"
#include "LazyStorage.hpp"
#include "ProactiveStorage.hpp"
#include <ctime>

using madara::knowledge::KnowledgeRecord;
using madara::knowledge::knowledge_cast;
using madara::knowledge::containers::ArrayReference;
#ifdef USE_CPP11
using madara::knowledge::containers::array_reference_cast;
#endif
using madara::knowledge::containers::Reference;
using madara::knowledge::containers::CachedReference;
using madara::knowledge::containers::IntegerVector;
using madara::knowledge::containers::VAR_LEN;
using madara::knowledge::containers::StorageManager::Lazy;
using madara::knowledge::containers::StorageManager::Proactive;

static unsigned int OK_count = 0;
static unsigned int FAIL_count = 0;

#define LOG(expr) \
  std::cerr << #expr << " == " << (expr) << std::endl

#define TEST(expr, expect) \
  do {\
    std::string v = boost::lexical_cast<std::string>(expr); \
    int ok = (v == #expect); \
    std::cerr << #expr << " ?= " << expect << "  " << (ok ? "OK" : "FAILED! got " + v + " instead" ) << std::endl; \
    (ok ? OK_count : FAIL_count)++; \
  } while(0)

/*
void perf_test()
{
  clock_t vector_N_start = clock();
  {
    madara::knowledge::KnowledgeBase kbase;
    Vector_N v("array", kbase);
    for(int i = 0; i < 100; ++i)
    {
      for(int j = 0; j < 100; ++j)
      {
        for(int k = 0; k < 100; ++k)
        {
          Vector_N::Index index;
          index.push_back(i);
          index.push_back(j);
          index.push_back(k);
          v.set(index, (long int)(i + j + k));
        }
      }
    }
  }
  clock_t vector_N_end = clock();
  LOG(vector_N_end - vector_N_start);

  clock_t staticArray_start = clock();
  {
    madara::knowledge::KnowledgeBase kbase;
    ArrayReference<int, 100, 100, 100> a(kbase, "array");
    for(int i = 0; i < 100; ++i)
    {
      for(int j = 0; j < 100; ++j)
      {
        for(int k = 0; k < 100; ++k)
        {
          a[i][j][k] = i + j + k;
        }
      }
    }
  }
  clock_t staticArray_end = clock();
  LOG(staticArray_end - staticArray_start);

  clock_t intVec_start = clock(), intVec_init;
  {
    madara::knowledge::KnowledgeBase kbase;
    IntegerVector v("array", kbase, 1000000);
    intVec_init = clock();
    for(int i = 0; i < 1000000; ++i)
    {
      v.set(i, i);
    }
  }
  clock_t intVec_end = clock();
  LOG(intVec_init - intVec_start);
  LOG(intVec_end - intVec_start);

  clock_t lazyArray_start = clock();
  {
    madara::knowledge::KnowledgeBase kbase;
    ArrayReference<Lazy<int, Reference<int> >, 1000000> a(kbase, "array");
    for(int i = 0; i < 1000000; ++i)
    {
      a[i] = i;
    }
  }
  clock_t lazyArray_end = clock();
  LOG(lazyArray_end - lazyArray_start);

  clock_t proactiveArray_start = clock(), proactiveArray_init;
  {
    madara::knowledge::KnowledgeBase kbase;
    ArrayReference<Proactive<int, Reference<int> >, 1000000> a(kbase, "array");
    a[0];
    proactiveArray_init = clock();
    for(int i = 0; i < 1000000; ++i)
    {
      a[i] = i;
    }
  }
  clock_t proactiveArray_end = clock();
  LOG(proactiveArray_init - proactiveArray_start);
  LOG(proactiveArray_end - proactiveArray_start);
}
*/

void takes_krec(KnowledgeRecord foo)
{
}

#ifdef USE_CPP11
template<class R>
void print_asdf(R &&r)
{
  std::cout<<"Asdf: " <<std::forward<R>(r).get()<<std::endl;
}
#endif

int main()
{
  madara::knowledge::KnowledgeBase kbase;
  madara::knowledge::containers::ArrayReference<int, 5, 6, 7, 8, 9> v(kbase.get_context(), "vec");
  std::cerr << v[1][2][3][4][5] << std::endl;
  madara::knowledge::containers::ArrayReference<int, 5, 6, 7> vec(kbase.get_context(), "vec");
  //auto r1 = vec[1];
  //auto r2 = vec[1][2];
  int r2 = vec[3][1][1];
  vec[1][1][1] = vec[1][1][1];
  std::cerr << r2 << "  " << sizeof(r2) << std::endl;
  madara::knowledge::containers::Reference<int> r3 = vec[4][2][3];
  std::cerr << r3 << "  " << sizeof(r3) << std::endl;
  r3 = 18;
  std::cerr << r3 << "  " << sizeof(r3) << std::endl;
  std::cerr << vec[4][2][3] << std::endl;
  //std::cerr << &vec[1][2][3].get_context() << std::endl;
  std::cerr << vec[1][2][3].get_name() << std::endl;
  std::cerr << sizeof(vec) << "  " << sizeof(vec[1][3][2]) << "  " << sizeof(KnowledgeRecord) << std::endl;
  vec[1][2][3] = 42;
  vec[1][2][3] <<= 1;
  vec[1][2][4] = 32.7;
  vec[1][2][4] *= 2;
  std::cerr << vec[1][2][3] << std::endl;
  std::cerr << vec[1][2][4] + 10 << std::endl;
  BOOST_FOREACH(int i, vec.get_static_sizes())
  {
    std::cerr << i << " ";
  }
  BOOST_FOREACH(int i, vec.get_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl;
  //std::cerr << vec.rank << " " << vec.dim << " " << vec.subarray_type::dim << " " << vec.subarray_type::subarray_type::dim << std::endl;
  //std::cerr << "Lookup: " << vec.dim0 << " " << vec.dim1 << " " << vec.dim2 << " " << vec.dim9 << std::endl;

  vec[1][2][0] = 123;
  vec[1][2][2] = vec[1][2][0];
  std::cerr << "After copying assigment: " << vec[1][2][2] << std::endl;
  Reference<int> test = vec[1][3][0];
  vec[1][3][0] = 135;
  std::cerr << "test container: " << test << " == " << vec[1][3][0] << std::endl;
  std::cerr << "test temp: " << (int)Reference<int>(vec[1][3][0]) << " == " << vec[1][3][0] << std::endl;
  test = vec[1][2][0];
  std::cerr << "test container: " << test << " == " << vec[1][3][0] << std::endl;
  test = CachedReference<int>(kbase, "testing");
  std::cerr << "test attempted overwrite: " << test << " == " << vec[1][3][0] << std::endl;

  vec[4][2][0] = vec[4][2][1] = vec[4][2][1] = 1234;
  std::cerr << "test chained assign: " << vec[4][2][0] << " == " << vec[4][2][1] << " == 1234" << std::endl;
  vec[4][2][1] += 1;
  std::cerr << "test chained assign: " << vec[4][2][0] << " != " << vec[4][2][1] << " == 1235" << std::endl;

  madara::knowledge::containers::ArrayReference<KnowledgeRecord, 8, 4, 3> kvec(kbase.get_context(), "kvec");
  kvec[1][1][1] = (long int)5;
  std::cerr << kvec[1][1][1].get().to_integer() << std::endl;

  madara::knowledge::containers::ArrayReference<int, 6, 7> sub_vec(vec[1]);
  std::cerr << sub_vec[2][3] << std::endl;
  madara::knowledge::containers::ArrayReference<int, 7> sub_sub_vec(sub_vec[2]);
  std::cerr << sub_sub_vec[4] << std::endl;

#ifdef USE_VAR_TMPL
  ArrayReference<int, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15> big_array(kbase.get_context(), "big_array");
  Reference<int> e = big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14];
  e = 123;
  std::cerr << e << "  " << big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14] << std::endl;
#endif

  ArrayReference<int, 6, VAR_LEN> var_arr(kbase, "variable_array", 0, 20);
  var_arr.resize<1>(30);
  var_arr[1][25] = 55;
  LOG(var_arr[1][25]);
  var_arr[0].resize(35);

  ArrayReference<Lazy<int>, 6, VAR_LEN> lvar_arr(kbase, "variable_array", 0, 20);
  lvar_arr[0].resize(30);

  ArrayReference<Proactive<int>, 6, VAR_LEN> pvar_arr(kbase, "variable_array", 0, 20);
  pvar_arr[0].resize(30);

#ifdef USE_VAR_TMPL
  ArrayReference<int, 6, 30> resized_arr(var_arr);
  std::cerr << "resized_arr[1][25] == " << resized_arr[1][25] << std::endl;
#endif

  ArrayReference< ::madara::knowledge::containers::StorageManager::detail::Stateless<int>, 6, VAR_LEN, VAR_LEN> var_arr2(kbase, "variable_array");
  ArrayReference<int, 6, VAR_LEN, VAR_LEN, VAR_LEN> var_arr3(kbase, "variable_array");
#ifdef USE_VAR_TMPL
  LOG(sizeof(big_array));
#endif
  LOG(sizeof(vec));
  LOG(sizeof(var_arr));
  LOG(sizeof(var_arr2));
  LOG(sizeof(std::vector<int>));
  LOG(sizeof(var_arr3));
  LOG(sizeof(unsigned int));

  TEST(vec.size(), 5);
  TEST(vec.size<1>(), 6);
  TEST(vec.size<2>(), 7);
  LOG(vec.resizable());
  LOG(var_arr.size<1>());
  LOG(var_arr.resizable<1>());
  var_arr2[1][1][1] = 456;

  try
  {
    var_arr[10][35] = 12343;
  }
  catch(std::range_error err)
  {
    std::cerr << err.what() << std::endl;
  }
  try
  {
    var_arr[1][35] = 12343;
  }
  catch(std::range_error err)
  {
    std::cerr << err.what() << std::endl;
  }
  var_arr.resize<1>(40);
  LOG(var_arr[1][35] = 12343);

  ArrayReference<Lazy<int>, 3, 4, 5> lazy_array(kbase, "lazy_array");
  LOG(lazy_array.rank());
  LOG(lazy_array.rank<1>());
  LOG(lazy_array.rank<2>());
  LOG(lazy_array[1][2][3].get_name());
  LOG(lazy_array[0][0][0].get_name());
  LOG(lazy_array[1][2][3] = 32);
  LOG(lazy_array[1][2][3]);

  ArrayReference<Lazy<int, Reference>, 3> lazy_array_1D(kbase, "lazy_array");
  lazy_array_1D[2] = 678;
  LOG(lazy_array_1D[0].get_name());

  ArrayReference<int, 10> uncached_array(kbase, "cached_array");
  uncached_array[0] = 5;
  LOG(uncached_array[0]);
  ArrayReference<Proactive<int, CachedReference>, 10> cached_array(kbase, "cached_array");
  LOG(cached_array[0]);
  LOG(cached_array[0].get_name());
  LOG(cached_array[1].get_name());
  LOG(cached_array[2].get_name());
  LOG(uncached_array[0].get_name());
  LOG(uncached_array[1].get_name());
  LOG(uncached_array[2].get_name());
  CachedReference<int> cached_ref = cached_array[0];
  LOG(cached_ref.get_name());
  LOG(cached_ref);
  cached_ref.pull();
  LOG(cached_ref);
  uncached_array[1] = 10;
  LOG(uncached_array[0]);
  LOG(cached_array[1]);
#ifdef USE_TYPE_TRAITS
  //cached_array.for_each<&CachedReference<int>::pull>();
#else
  cached_array[1].pull();
#endif
  LOG(cached_array[1]);

  takes_krec(knowledge_cast(uncached_array[0]));

  Reference<int> foo(kbase, "foo");
  CachedReference<int> cache_foo(kbase, "foo");

  LOG(kbase.get("foo").to_integer());
  foo = 42;
  LOG(kbase.get("foo").to_integer());
  LOG(foo);
  LOG(cache_foo);
  cache_foo.pull();
  LOG(cache_foo);
  cache_foo = 24;
  LOG(cache_foo);
  LOG(foo);
  cache_foo.push();
  LOG(foo);

  ArrayReference<int, 2, 2, 2> mul(kbase, "mul");
  ArrayReference<Proactive<int, CachedReference>, 2, 2, 2> cmul(kbase, "mul");
  ArrayReference<int, 2, 2, VAR_LEN> vmul(kbase, "mul", 0, 0, 2);
  ArrayReference<int, 2, VAR_LEN, VAR_LEN> vmul2(kbase, "mul", 0, 2, 2);
  ArrayReference<int, VAR_LEN, VAR_LEN, VAR_LEN> vmul3(kbase, "mul", 2, 2, 2);

  LOG(sizeof(mul));
  LOG(sizeof(cmul));
  LOG(sizeof(vmul));
  LOG(sizeof(vmul2));
  LOG(sizeof(vmul3));
#ifdef USE_TYPE_TRAITS
  set(mul[0][0], 40);
  set(cmul[0][0], 24);
  LOG(mul[0][0][1]);
  set(mul[0][0][1], 41);
  ++mul[0][0][1];
  LOG(mul[0][0][1]);
  LOG(cmul[0][0][1]);
  push(cmul[0]);
  LOG(mul[0][0][1]);
  set(mul, 55);
  LOG(mul[0][0][1]);
  LOG(cmul[0][0][1]);
  pull(cmul);
  LOG(cmul[0][0][1]);
  auto cmul_001 = cmul[0][0][1];
  set(mul, 88);
  LOG(cmul_001);
  cmul_001.pull();
  LOG(cmul_001);
  LOG(cmul[0][0][1]);
  LOG(get(cmul[0][0][1]));
  LOG(sizeof(cmul_001));

  //pull(mul); // uncomment to test compile error
#endif

  mul[0][0][1] = 12;
  ++mul[0][0][1];
  mul[0][0][1]++;
  LOG(cmul[0][0][1]);
  ++cmul[0][0][1];
  cmul[0][0][1]++;
  LOG(cmul[0][0][1]);
  ArrayReference<int, 2> submul(mul[0][0]);
  LOG(mul[0][0][1]);
  LOG(submul[1]);

  std::cerr << "mul static_sizes: ";
  BOOST_FOREACH(unsigned int i, mul.get_static_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl << "mul sizes: ";
  BOOST_FOREACH(unsigned int i, mul.get_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl;

  std::cerr << "vmul static_sizes: ";
  BOOST_FOREACH(unsigned int i, vmul.get_static_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl << "vmul sizes: ";
  BOOST_FOREACH(unsigned int i, vmul.get_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl;

#ifdef USE_CPP11
  std::cerr << "vmul static_sizes dims 1 & 2: ";
  auto sarr = vmul.get_static_sizes<1, 2>();
  for(auto i : sarr)
    std::cerr << i << " ";
  std::cerr << std::endl;
  std::cerr << "vmul sizes dims 1 & 2: ";
  auto sarr2 = vmul.get_sizes<1, 2>();
  for(auto i : sarr2)
    std::cerr << i << " ";
  std::cerr << std::endl;
#endif
  // uncomment to test dimension-out-of-bounds errors
#ifdef USE_CPP11
  //auto sarr3 = vmul.get_sizes<1, 2, 4, 5>();
  print_lines(mul);

  int sum = 0;
  mul.for_each([&sum](decltype(mul)::for_each_type r)
    {sum+=r.get();});
  mul[0][0].for_each(print_asdf<decltype(mul)::for_each_type>);
  LOG(sum);

  //Following 3 should be equivalent:
  //ArrayReference<std::string, 2, 2, 2> smul(mul);
  //decltype(mul)::as_type<std::string> smul(mul);
  auto smul(array_reference_cast<std::string>(mul));

  smul.for_each([](decltype(smul)::for_each_type r)
    { std::cout << (std::string("!!!") + r) << std::endl; });

  auto small_mul(array_reference_cast<1, 1, 2>(mul));
  print_lines(small_mul);

  auto small_smul(array_reference_cast<std::string, 1, 1, 2>(smul));

  small_smul.for_each([](decltype(small_smul)::for_each_type r)
    { std::cout << (r + std::string("!!!")) << std::endl; });

  auto sub_mul_ident(array_reference_cast<2, 2>(mul[0]));
  print_lines(sub_mul_ident);

  auto sub_mul(array_reference_cast<1, 2>(mul[0]));
  print_lines(sub_mul);

  auto vmul_copy(vmul3);
  vmul_copy.resize(1, 2, 2);
  print_lines(vmul_copy);
  LOG(vmul_copy[0][0][1] + vmul_copy[0][0][0]);
#else
  ArrayReference<int, VAR_LEN, VAR_LEN, VAR_LEN> vmul_copy(vmul3);
  vmul_copy.resize(3, 3);
  std::cerr << "vmul_copy sizes: ";
  BOOST_FOREACH(int i, vmul_copy.get_sizes())
  {
    std::cerr << i << " ";
  }
  std::cerr << std::endl;
  LOG(vmul_copy[0][0][1] + vmul_copy[0][0][0]);
#endif

  mul[0][1][1] = vmul_copy[0][1][1];
  Reference<int> a(mul[0][1][1]);
  Reference<int> b(vmul_copy[0][1][1]);
  LOG(a == b);
  LOG(a + b);
  //vmul.size<5>();
  //vmul.size<-1>();

  ArrayReference<Proactive<KnowledgeRecord, Reference>, 5> crarr(kbase, "crarr");


  LOG(OK_count);
  LOG(FAIL_count);

  //perf_test();

  return 0;
}
