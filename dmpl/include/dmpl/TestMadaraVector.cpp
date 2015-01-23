#include <string>
#include <boost/foreach.hpp>
#include <madara/knowledge_engine/containers/Integer.h>
#include "Array.hpp"

using Madara::Knowledge_Engine::Containers::Array;
using Madara::Knowledge_Engine::Containers::Container;

int main()
{
  Madara::Knowledge_Engine::Knowledge_Base kbase;
  Madara::Knowledge_Engine::Containers::Array<int, 5, 6, 7, 8, 9> v(kbase.get_context(), "vec");
  std::cout << v[1][2][3][4][5] << std::endl;
  Madara::Knowledge_Engine::Containers::Array<int, 5, 6, 7> vec(kbase.get_context(), "vec");
  //auto r1 = vec[1];
  //auto r2 = vec[1][2];
  int r2 = vec[3][1][1];
  std::cout << r2 << "  " << sizeof(r2) << std::endl;
  Madara::Knowledge_Engine::Containers::Container<int> r3 = vec[4][2][3];
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
  std::cout << vec.dims << " " << vec.dim << " " << vec.subarray_type::dim << " " << vec.subarray_type::subarray_type::dim << std::endl;
  std::cout << "Lookup: " << vec.dim0 << " " << vec.dim1 << " " << vec.dim2 << " " << vec.dim9 << std::endl;

#ifdef USE_STD_ARRAY
  decltype(vec)::array_type array;
  vec.get_local_array(array);
  std::cout << "Local Array: " << array[1][2][3] << std::endl;
  array[1][2][3] += 1;
  vec.set_existing_from_array(array);

  decltype(vec)::ref_array_type exref_array;
  vec.get_existing_reference_array(exref_array);
  std::cout << "Existing Reference Array: " << exref_array[1][2][3].valid() << std::endl;
  std::cout << "Existing Reference Array: " << exref_array[1][2][1].valid() << std::endl;

  vec.get_existing_reference_array(exref_array);
  std::cout << "Existing Reference Array: " << exref_array[1][2][3].valid() << std::endl;
  std::cout << "Existing Reference Array: " << exref_array[1][2][1].valid() << std::endl;

  vec.set_from_array(array);

  vec.get_existing_reference_array(exref_array);
  std::cout << "Existing Reference Array: " << exref_array[1][2][3].valid() << std::endl;
  std::cout << "Existing Reference Array: " << exref_array[1][2][1].valid() << std::endl;

  decltype(vec)::ref_array_type ref_array;
  vec.get_reference_array(ref_array);
  std::cout << "Reference Array: " << ref_array[1][2][3] << std::endl;
  std::cout << "Reference Array: " << ref_array[1][2][3].get_name() << std::endl;
  ref_array[1][2][3] += 1;
  std::cout << "Reference Array: " << ref_array[1][2][3] << std::endl;
  std::cout << "Base Array: " << vec[1][2][3] << std::endl;

  decltype(vec)::cache_array_type carray;
  vec.get_cache_array(carray);
  std::cout << "Cached Array: " << carray[1][2][3] << std::endl;
  carray[1][2][3] += 1;
  std::cout << "Cached Array: " << carray[1][2][3] << std::endl;
  std::cout << "Base Array before push: " << vec[1][2][3] << std::endl;
  vec.push_cache_array(carray);
  std::cout << "Base Array after push: " << vec[1][2][3] << std::endl;
  vec[1][2][3] += 1;
  carray[1][2][3] = 42;
  std::cout << "Base Array before pull: " << vec[1][2][3] << std::endl;
  std::cout << "Cached Array before pull: " << carray[1][2][3] << std::endl;
  vec.pull_cache_array(carray);
  std::cout << "Cached Array after pull: " << carray[1][2][3] << std::endl;
  carray[1][2][3] = 13;
  vec[1][2][3] += 1;
  std::cout << "Cached Array before pull_keep_local: " << carray[1][2][3] << std::endl;
  vec.pull_cache_array_keep_local(carray);
  std::cout << "Cached Array after pull_keep_local: " << carray[1][2][3] << std::endl;


#endif

  Madara::Knowledge_Engine::Containers::Array<Madara::Knowledge_Record, 8, 4, 3> kvec(kbase.get_context(), "kvec");
  kvec[1][1][1] = (long int)5;
  std::cout << kvec[1][1][1].get().to_integer() << std::endl;

  Madara::Knowledge_Engine::Containers::Array<int, 6, 7> sub_vec(vec[1]);
  std::cout << sub_vec[2][3] << std::endl;
  Madara::Knowledge_Engine::Containers::Array<int, 7> sub_sub_vec(sub_vec[2]);
  std::cout << sub_sub_vec[4] << std::endl;

#ifdef USE_VAR_TMPL
  Array<int, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15> big_array(kbase.get_context(), "big_array");
  Container<int> e = big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14];
  e = 123;
  std::cout << e << "  " << big_array[0][1][2][3][4][5][6][7][8][9][10][11][12][13][14] << std::endl;
#endif

  return 0;
}
