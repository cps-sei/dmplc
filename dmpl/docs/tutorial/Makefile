CFLAGS=-g -O3 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi \
	-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src
LIBS=$(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so \
	$(GAMS_ROOT)/lib/libGAMS.so -lpthread
DMPL=example-01.dmpl example-02.dmpl example-03.dmpl example-04.dmpl
SRC=$(patsubst %.dmpl,%.cpp,$(DMPL))
EXE=$(patsubst %.dmpl,%,$(DMPL))

all: $(EXE) Makefile

%: %.cpp
	g++ $(CFLAGS) -o $@ $< $(LIBS)

example-01.cpp: example-01.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 2 -g -o $@ $<

example-02.cpp: example-02.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 5 --DX $(GRIDSIZE) --DY $(GRIDSIZE) --DTopY $(TopY) --DBottomY $(BottomY) --DLeftX $(LeftX) --DRightX $(RightX) -g -o $@ $<

example-03.cpp: example-03.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o $@ $<

example-04.cpp: example-04.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o $@ $<

clean:
	rm -f $(EXE) $(SRC)
