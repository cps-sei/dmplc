#include <string>
#include <boost/foreach.hpp>
#include <madara/knowledge_engine/containers/Integer.h>
#include "StaticArray.hpp"

using Madara::Knowledge_Engine::Containers::StaticArray;
using Madara::Knowledge_Engine::Containers::Reference;
using Madara::Knowledge_Engine::Containers::CachedReference;
using Madara::Knowledge_Engine::Containers::VAR_LEN;
using Madara::Knowledge_Engine::Containers::StorageManager::Lazy;

#define LOG(expr) \
  std::cout << #expr << " == " << (expr) << std::endl

int main()
{
  Madara::Knowledge_Engine::Knowledge_Base kbase;
  Madara::Knowledge_Engine::Containers::StaticArray<int, 5, 6, 7, 8, 9> v(kbase.get_context(), "vec");
  std::cout << v[1][2][3][4][5] << std::endl;
  Madara::Knowledge_Engine::Containers::StaticArray<int, 5, 6, 7> vec(kbase.get_context(), "vec");
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
  StaticArray<int, 5, 6, 7>::array_type array;
#endif
  vec.get_into(array);
  std::cout << "Local StaticArray: " << array[1][2][3] << std::endl;
  array[1][2][3] += 1;
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;
  //vec.set_from(array);
  vec.update_from(array);
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;

#ifdef USE_USING_TYPE
  decltype(vec)::get_vector_type<Reference<int> > ref_vector;
#else
  StaticArray<int, 5, 6, 7>::get_vector_type_compat<Reference<int> >::type ref_vector;
#endif
  vec.get_into(ref_vector);
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3].get_name() << std::endl;
  ref_vector[1][2][3] += 1;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;

#ifdef USE_USING_TYPE
  decltype(vec)::get_vector_type<CachedReference<int> > carray;
#else
  StaticArray<int, 5, 6, 7>::get_vector_type_compat<CachedReference<int> >::type carray;
#endif
  vec.get_into(carray);
  std::cout << "Cached StaticArray: " << carray[1][2][3] << std::endl;
  carray[1][2][3] += 1;
  std::cout << "Cached StaticArray: " << carray[1][2][3] << std::endl;
  std::cout << "Base StaticArray before push: " << vec[1][2][3] << std::endl;
  vec.push_all(carray);
  std::cout << "Base StaticArray after push: " << vec[1][2][3] << std::endl;
  vec[1][2][3] += 1;
  carray[1][2][3] = 42;
  std::cout << "Base StaticArray before pull: " << vec[1][2][3] << std::endl;
  std::cout << "Cached StaticArray before pull: " << carray[1][2][3] << std::endl;
  vec.pull_all(carray);
  std::cout << "Cached StaticArray after pull: " << carray[1][2][3] << std::endl;
  carray[1][2][3] = 13;
  vec[1][2][3] += 1;
  std::cout << "Cached StaticArray before pull_keep_local: " << carray[1][2][3] << std::endl;
  vec.pull_all_keep_local(carray);
  std::cout << "Cached StaticArray after pull_keep_local: " << carray[1][2][3] << std::endl;

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

  Madara::Knowledge_Engine::Containers::StaticArray<Madara::Knowledge_Record, 8, 4, 3> kvec(kbase.get_context(), "kvec");
  kvec[1][1][1] = (long int)5;
  std::cout << kvec[1][1][1].get().to_integer() << std::endl;

  Madara::Knowledge_Engine::Containers::StaticArray<int, 6, 7> sub_vec(vec[1]);
  std::cout << sub_vec[2][3] << std::endl;
  Madara::Knowledge_Engine::Containers::StaticArray<int, 7> sub_sub_vec(sub_vec[2]);
  std::cout << sub_sub_vec[4] << std::endl;

#ifdef USE_VAR_TMPL
  StaticArray<int, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15> big_array(kbase.get_context(), "big_array");
  Reference<int> e = big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14];
  e = 123;
  std::cout << e << "  " << big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14] << std::endl;
#endif

  StaticArray<int, 6, VAR_LEN> var_arr(kbase, "variable_array", 0, 20);
  StaticArray<int, 6, VAR_LEN>::vector_type var_arr_vec;
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
  StaticArray<int, 6, 30> resized_arr(var_arr);
  std::cout << "resized_arr[1][25] == " << resized_arr[1][25] << std::endl;
#endif

  StaticArray<int, 6, VAR_LEN, VAR_LEN> var_arr2(kbase, "variable_array");
  StaticArray<int, 6, VAR_LEN, VAR_LEN, VAR_LEN> var_arr3(kbase, "variable_array");
#ifdef USE_VAR_TMPL
  LOG(sizeof(big_array));
#endif
  LOG(sizeof(vec));
  LOG(sizeof(var_arr));
  LOG(sizeof(var_arr2));
  LOG(sizeof(std::vector<int>));
  LOG(sizeof(var_arr3));
  LOG(sizeof(unsigned int));
  LOG(sizeof(Madara::Knowledge_Engine::Containers::__INTERNAL__::size_manager<0, 5>));
  LOG(sizeof(Madara::Knowledge_Engine::Containers::__INTERNAL__::size_manager<0, VAR_LEN>));

#ifdef USE_VAR_TMPL
  LOG(vec.get_size());
#else
  LOG(vec.get_size<0>());
#endif
  LOG(vec.get_size<1>());
  LOG(vec.get_size<2>());
  LOG(vec.can_resize<0>());
  LOG(var_arr.get_size<1>());
  LOG(var_arr.can_resize<1>());

  LOG(vec.get_multiplier<0>());
  LOG(vec.get_multiplier<1>());
  LOG(vec.get_multiplier<2>());

  LOG(var_arr2.get_multiplier<0>());
  LOG(var_arr2.get_multiplier<1>());
  LOG(var_arr2.get_multiplier<2>());
  var_arr2.resize<1>(3);
  var_arr2.resize<2>(5);
  LOG(var_arr2.get_multiplier<0>());
  LOG(var_arr2.get_multiplier<1>());
  LOG(var_arr2.get_multiplier<2>());

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

  return 0;
}
