FILES=TestMadaraVector.cpp ArrayReference.hpp Reference.hpp knowledge_cast.hpp StorageManager.hpp LazyStorage.hpp StatelessStorage.hpp ProactiveStorage.hpp
all: test test-c98

release: test_release test_release-c98

test: $(FILES)
	g++ -pedantic -Wall -std=c++11 -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test-c98: $(FILES)
	g++ -pedantic -Wall -g TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test-c98 $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test_release: $(FILES)
	g++ -pedantic -Wall -O3 -std=c++11 TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test_release $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

test_release-c98: $(FILES)
	g++ -pedantic -Wall -O3 TestMadaraVector.cpp -I $(MADARA_ROOT)/include -I $(ACE_ROOT) -o test_release-c98 $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so

clean:
	rm test test-c98 test_release test_release-c98
