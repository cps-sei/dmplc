tutorial-02: tutorial-02.cpp
	  g++ -I$(DART_ROOT)/dasl/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o tutorial-02 tutorial-02.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

tutorial-02.cpp: tutorial-02.dasl $(DART_ROOT)/dasl/src/daslc/daslc
		daslc -n 2 -g -o tutorial-02.cpp tutorial-02-conf.dasl tutorial-02.dasl
