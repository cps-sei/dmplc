all: test test-c98

test: TestMadaraVector.cpp StaticArray.hpp Reference.hpp knowledge_cast.hpp
	g++ -pedantic -Wall -std=c++11 -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test-c98: TestMadaraVector.cpp StaticArray.hpp Reference.hpp knowledge_cast.hpp
	g++ -pedantic -Wall -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test-c98 $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test_release: TestMadaraVector.cpp StaticArray.hpp Reference.hpp knowledge_cast.hpp
	g++ -pedantic -Wall -std=c++11 TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test_release $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test_release-c98: TestMadaraVector.cpp StaticArray.hpp Reference.hpp knowledge_cast.hpp
	g++ -pedantic -Wall TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test_release-c98 $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

clean:
	rm test test-c98
