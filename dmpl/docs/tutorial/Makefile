all: tutorial-02 dart dart9

tutorial-02: tutorial-02.cpp
	  g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o tutorial-02 tutorial-02.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

tutorial-02.cpp: tutorial-02.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
		dmplc -n 2 -g -o tutorial-02.cpp tutorial-02-conf.dmpl tutorial-02.dmpl

dart: dart.cpp
	  g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o dart dart.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

dart.cpp: dart.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
		dmplc -n 5 -g -o dart.cpp dart.dmpl

dart9: dart9.cpp
	  g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o dart9 dart9.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

dart9.cpp: dart9.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
		dmplc -n 9 -g -o dart9.cpp dart9.dmpl

clean:
		rm tutorial-02.cpp
		rm tutorial-02
		rm dart.cpp
		rm dart
		rm dart9.cpp
		rm dart9
