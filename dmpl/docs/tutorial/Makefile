tutorial-02: tutorial-02.cpp
	  g++ -I$(DMPL_ROOT)/dmpl/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o tutorial-02 tutorial-02.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

tutorial-02.cpp: tutorial-02.dmpl $(DMPL_ROOT)/dmpl/src/dmplc/dmplc
		dmplc -n 2 -g -o tutorial-02.cpp tutorial-02-conf.dmpl tutorial-02.dmpl
