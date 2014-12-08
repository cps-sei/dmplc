CFLAGS=-g -O3 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi \
	-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src
LIBS=$(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so \
	$(GAMS_ROOT)/lib/libGAMS.so -lpthread

all: tutorial-01 Makefile

%: %.cpp
	g++ $(CFLAGS) -o $@ $< $(LIBS)

%.cpp: %.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 2 -g -o $@ $<

clean:
	rm -f tutorial-01.cpp tutorial-01
