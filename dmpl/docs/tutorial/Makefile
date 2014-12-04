all: tutorial-02

tutorial-02: tutorial-02.cpp
	g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o tutorial-02 tutorial-02.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

tutorial-02.cpp: tutorial-02.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 2 -g -o tutorial-02.cpp tutorial-02.dmpl

clean:
	rm -f tutorial-02.cpp
	rm -f tutorial-02
