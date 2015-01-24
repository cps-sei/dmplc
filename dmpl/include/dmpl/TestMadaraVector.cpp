#include <string>
#include <boost/foreach.hpp>
#include <madara/knowledge_engine/containers/Integer.h>
#include "StaticArray.hpp"

using Madara::Knowledge_Engine::Containers::StaticArray;
using Madara::Knowledge_Engine::Containers::Reference;
using Madara::Knowledge_Engine::Containers::CachedReference;

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
  std::cout << vec.dims << " " << vec.dim << " " << vec.subarray_type::dim << " " << vec.subarray_type::subarray_type::dim << std::endl;
  std::cout << "Lookup: " << vec.dim0 << " " << vec.dim1 << " " << vec.dim2 << " " << vec.dim9 << std::endl;

#ifdef USE_STD_ARRAY
  decltype(vec)::array_type<int> array;
#else
  StaticArray<int, 5, 6, 7>::vector_type<int>::type array;
#endif
  vec.get_into(array);
  std::cout << "Local StaticArray: " << array[1][2][3] << std::endl;
  array[1][2][3] += 1;
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;
  //vec.set_from(array);
  vec.update_from(array);
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;

#ifdef USE_EMPLACE
  decltype(vec)::vector_type<Reference<int> > ref_vector;
  vec.get_into(ref_vector);
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3].get_name() << std::endl;
  ref_vector[1][2][3] += 1;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;
#else
  StaticArray<int, 5, 6, 7>::vector_type<Reference<int> >::type ref_vector;
  vec.get_into(ref_vector);
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3].get_name() << std::endl;
  ref_vector[1][2][3] += 1;
  std::cout << "Reference StaticArray: " << ref_vector[1][2][3] << std::endl;
  std::cout << "Base StaticArray: " << vec[1][2][3] << std::endl;
#endif

#ifdef USE_USING_TYPE
  decltype(vec)::vector_type<CachedReference<int> > carray;
#else
  StaticArray<int, 5, 6, 7>::vector_type<CachedReference<int> >::type carray;
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
  std::cout << "Cached StaticArray after pull_keep_local: " << carray[2][2][3] << std::endl;

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

  return 0;
}
