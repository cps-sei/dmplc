all: test test-c98

test: TestMadaraVector.cpp Array.hpp Container.hpp knowledge_cast.hpp
	g++ -pedantic -Wall -std=c++11 -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test-c98: TestMadaraVector.cpp Array.hpp Container.hpp knowledge_cast.hpp
	g++ -pedantic -Wall -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test-c98 $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

clean:
	rm test test-c98
