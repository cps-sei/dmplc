CFLAGS=-g -O3 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi \
	-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src
LIBS=$(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so \
	$(GAMS_ROOT)/lib/libGAMS.so -lpthread
DMPL=tutorial-01.dmpl tutorial-02.dmpl tutorial-03.dmpl tutorial-04.dmpl
SRC=$(patsubst %.dmpl,%.cpp,$(DMPL))
EXE=$(patsubst %.dmpl,%,$(DMPL))

all: $(EXE) Makefile

%: %.cpp
	g++ $(CFLAGS) -o $@ $< $(LIBS)

tutorial-01.cpp: tutorial-01.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 2 -g -o $@ $<

tutorial-02.cpp: tutorial-02.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 5 -g -o $@ $<

tutorial-03.cpp: tutorial-03.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o $@ $<

tutorial-04.cpp: tutorial-04.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o $@ $<

clean:
	rm -f $(EXE) $(SRC)
