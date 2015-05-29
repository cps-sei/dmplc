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
#include <madara/knowledge_engine/containers/Integer.h>
#include <madara/knowledge_engine/containers/Integer_Vector.h>
#include <madara/knowledge_engine/containers/Vector_N.h>
#include "ArrayReference.hpp"
#include <ctime>

using Madara::Knowledge_Record;
using Madara::knowledge_cast;
using Madara::Knowledge_Engine::Containers::ArrayReference;
using Madara::Knowledge_Engine::Containers::Reference;
using Madara::Knowledge_Engine::Containers::CachedReference;
using Madara::Knowledge_Engine::Containers::Vector_N;
using Madara::Knowledge_Engine::Containers::Integer_Vector;
using Madara::Knowledge_Engine::Containers::VAR_LEN;
using Madara::Knowledge_Engine::Containers::StorageManager::Lazy;
using Madara::Knowledge_Engine::Containers::StorageManager::Proactive;

static unsigned int OK_count = 0;
static unsigned int FAIL_count = 0;

#define LOG(expr) \
  std::cout << #expr << " == " << (expr) << std::endl

#define TEST(expr, expect) \
  do {\
    std::string v = boost::lexical_cast<std::string>(expr); \
    int ok = (v == #expect); \
    std::cout << #expr << " ?= " << expect << "  " << (ok ? "OK" : "FAILED! got " + v + " instead" ) << std::endl; \
    (ok ? OK_count : FAIL_count)++; \
  } while(0)

void perf_test()
{
  clock_t vector_N_start = clock();
  {
    Madara::Knowledge_Engine::Knowledge_Base kbase;
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
    Madara::Knowledge_Engine::Knowledge_Base kbase;
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
    Madara::Knowledge_Engine::Knowledge_Base kbase;
    Integer_Vector v("array", kbase, 1000000);
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
    Madara::Knowledge_Engine::Knowledge_Base kbase;
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
    Madara::Knowledge_Engine::Knowledge_Base kbase;
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

void takes_krec(Knowledge_Record foo)
{
}


int main()
{
  Madara::Knowledge_Engine::Knowledge_Base kbase;
  Madara::Knowledge_Engine::Containers::ArrayReference<int, 5, 6, 7, 8, 9> v(kbase.get_context(), "vec");
  std::cout << v[1][2][3][4][5] << std::endl;
  Madara::Knowledge_Engine::Containers::ArrayReference<int, 5, 6, 7> vec(kbase.get_context(), "vec");
  //auto r1 = vec[1];
  //auto r2 = vec[1][2];
  int r2 = vec[3][1][1];
  vec[1][1][1] = vec[1][1][1];
  std::cout << r2 << "  " << sizeof(r2) << std::endl;
  Madara::Knowledge_Engine::Containers::Reference<int> r3 = vec[4][2][3];
  std::cout << r3 << "  " << sizeof(r3) << std::endl;
  r3 = 18;
  std::cout << r3 << "  " << sizeof(r3) << std::endl;
  std::cout << vec[4][2][3] << std::endl;
  //std::cout << &vec[1][2][3].get_context() << std::endl;
  std::cout << vec[1][2][3].get_name() << std::endl;
  std::cout << sizeof(vec) << "  " << sizeof(vec[1][3][2]) << "  " << sizeof(Madara::Knowledge_Record) << std::endl;
  vec[1][2][3] = 42;
  vec[1][2][3] <<= 1;
  vec[1][2][4] = 32.7;
  vec[1][2][4] *= 2;
  std::cout << vec[1][2][3] << std::endl;
  std::cout << vec[1][2][4] + 10 << std::endl;
  BOOST_FOREACH(int i, vec.get_dims())
  {
    std::cout << i << " ";
  }
  std::cout << std::endl;
  //std::cout << vec.dims << " " << vec.dim << " " << vec.subarray_type::dim << " " << vec.subarray_type::subarray_type::dim << std::endl;
  //std::cout << "Lookup: " << vec.dim0 << " " << vec.dim1 << " " << vec.dim2 << " " << vec.dim9 << std::endl;

#ifdef USE_USING_TYPE
  decltype(vec)::array_type array;
#else
  ArrayReference<int, 5, 6, 7>::array_type array;
#endif
  vec.get_into(array);
  std::cout << "Local ArrayReference: " << array[1][2][3] << std::endl;
  array[1][2][3] += 1;
  std::cout << "Base ArrayReference: " << vec[1][2][3] << std::endl;
  //vec.set_from(array);
  vec.update_from(array);
  std::cout << "Base ArrayReference: " << vec[1][2][3] << std::endl;

#ifdef USE_USING_TYPE
  decltype(vec)::get_vector_type<Reference<int> > ref_vector;
#else
  ArrayReference<int, 5, 6, 7>::get_vector_type_compat<Reference<int> >::type ref_vector;
#endif
  vec.get_into(ref_vector);
  std::cout << "Reference ArrayReference: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Reference ArrayReference: " << ref_vector[1][2][3].get_name() << std::endl;
  ref_vector[1][2][3] += 1;
  std::cout << "Reference ArrayReference: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Base ArrayReference: " << vec[1][2][3] << std::endl;

#ifdef USE_USING_TYPE
  decltype(vec)::get_vector_type<CachedReference<int> > carray;
#else
  ArrayReference<int, 5, 6, 7>::get_vector_type_compat<CachedReference<int> >::type carray;
#endif
  vec.get_into(carray);
  std::cout << "Cached ArrayReference: " << carray[1][2][3] << std::endl;
  carray[1][2][3] += 1;
  std::cout << "Cached ArrayReference: " << carray[1][2][3] << std::endl;
  std::cout << "Base ArrayReference before push: " << vec[1][2][3] << std::endl;
  vec.push_all(carray);
  std::cout << "Base ArrayReference after push: " << vec[1][2][3] << std::endl;
  vec[1][2][3] += 1;
  carray[1][2][3] = 42;
  std::cout << "Base ArrayReference before pull: " << vec[1][2][3] << std::endl;
  std::cout << "Cached ArrayReference before pull: " << carray[1][2][3] << std::endl;
  vec.pull_all(carray);
  std::cout << "Cached ArrayReference after pull: " << carray[1][2][3] << std::endl;
  carray[1][2][3] = 13;
  vec[1][2][3] += 1;
  std::cout << "Cached ArrayReference before pull_keep_local: " << carray[1][2][3] << std::endl;
  vec.pull_all_keep_local(carray);
  std::cout << "Cached ArrayReference after pull_keep_local: " << carray[1][2][3] << std::endl;

  vec[1][2][0] = 123;
  vec[1][2][2] = vec[1][2][0];
  std::cout << "After copying assigment: " << vec[1][2][2] << std::endl;
  Reference<int> test = vec[1][3][0];
  vec[1][3][0] = 135;
  std::cout << "test container: " << test << " == " << vec[1][3][0] << std::endl;
  std::cout << "test temp: " << (int)Reference<int>(vec[1][3][0]) << " == " << vec[1][3][0] << std::endl;
  test = vec[1][2][0];
  std::cout << "test container: " << test << " == " << vec[1][3][0] << std::endl;
  test = CachedReference<int>(kbase, "testing");
  std::cout << "test attempted overwrite: " << test << " == " << vec[1][3][0] << std::endl;

  vec[4][2][0] = vec[4][2][1] = vec[4][2][1] = 1234;
  std::cout << "test chained assign: " << vec[4][2][0] << " == " << vec[4][2][1] << " == 1234" << std::endl;
  vec[4][2][1] += 1;
  std::cout << "test chained assign: " << vec[4][2][0] << " != " << vec[4][2][1] << " == 1235" << std::endl;

  Madara::Knowledge_Engine::Containers::ArrayReference<Madara::Knowledge_Record, 8, 4, 3> kvec(kbase.get_context(), "kvec");
  kvec[1][1][1] = (long int)5;
  std::cout << kvec[1][1][1].get().to_integer() << std::endl;

  Madara::Knowledge_Engine::Containers::ArrayReference<int, 6, 7> sub_vec(vec[1]);
  std::cout << sub_vec[2][3] << std::endl;
  Madara::Knowledge_Engine::Containers::ArrayReference<int, 7> sub_sub_vec(sub_vec[2]);
  std::cout << sub_sub_vec[4] << std::endl;

#ifdef USE_VAR_TMPL
  ArrayReference<int, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15> big_array(kbase.get_context(), "big_array");
  Reference<int> e = big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14];
  e = 123;
  std::cout << e << "  " << big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14] << std::endl;
#endif

  ArrayReference<int, 6, VAR_LEN> var_arr(kbase, "variable_array", 0, 20);
  ArrayReference<int, 6, VAR_LEN>::vector_type var_arr_vec;
  try
  {
    var_arr.get_into(var_arr_vec);
    LOG(var_arr_vec.size());
    LOG(var_arr_vec[0].size());
  }
  catch(std::range_error err)
  {
    std::cout << err.what() << std::endl;
  }
  var_arr.resize<1>(30);
  var_arr[1][25] = 55;
  LOG(var_arr[1][25]);

#ifdef USE_VAR_TMPL
  ArrayReference<int, 6, 30> resized_arr(var_arr);
  std::cout << "resized_arr[1][25] == " << resized_arr[1][25] << std::endl;
#endif

  ArrayReference< ::Madara::Knowledge_Engine::Containers::StorageManager::__INTERNAL__::Stateless<int>, 6, VAR_LEN, VAR_LEN> var_arr2(kbase, "variable_array");
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

#ifdef USE_VAR_TMPL
  TEST(vec.get_size(), 5);
#else
  TEST(vec.get_size<0>(), 5);
#endif
  TEST(vec.get_size<1>(), 6);
  TEST(vec.get_size<2>(), 7);
  LOG(vec.can_resize<0>());
  LOG(var_arr.get_size<1>());
  LOG(var_arr.can_resize<1>());
  var_arr2[1][1][1] = 456;

  try
  {
    var_arr[10][35] = 12343;
  }
  catch(std::range_error err)
  {
    std::cout << err.what() << std::endl;
  }
  try
  {
    var_arr[1][35] = 12343;
  }
  catch(std::range_error err)
  {
    std::cout << err.what() << std::endl;
  }
  var_arr.resize<1>(40);
  LOG(var_arr[1][35] = 12343);

  var_arr.get_into(var_arr_vec);
  LOG(var_arr_vec[1][35]);
  LOG(var_arr_vec.size());
  LOG(var_arr_vec[1].size());

  ArrayReference<Lazy<int, Reference<int> >, 3, 4, 5> lazy_array(kbase, "lazy_array");
  LOG(lazy_array.get_dimension<0>().dims);
  LOG(lazy_array.get_dimension<1>().dims);
  LOG(lazy_array.get_dimension<2>().dims);
  LOG(lazy_array.get_multiplier<0>());
  LOG(lazy_array.get_multiplier<1>());
  LOG(lazy_array.get_multiplier<2>());
  LOG(lazy_array[1][2][3].get_name());
  LOG(lazy_array[0][0][0].get_name());
  LOG(lazy_array[1][2][3] = 32);
  LOG(lazy_array[1][2][3]);

  ArrayReference<Lazy<int, Reference<int> >, 3> lazy_array_1D(kbase, "lazy_array");
  lazy_array_1D[2] = 678;
  LOG(lazy_array_1D[0].get_name());

  ArrayReference<int, 10> uncached_array(kbase, "cached_array");
  uncached_array[0] = 5;
  LOG(uncached_array[0]);
  ArrayReference<Proactive<int, CachedReference<int> >, 10> cached_array(kbase, "cached_array");
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
  cached_array[1].pull();
  LOG(cached_array[1]);

  uncached_array.mark_modified();

  takes_krec(knowledge_cast(uncached_array[0]));

  LOG(OK_count);
  LOG(FAIL_count);

  //perf_test();

  return 0;
}
