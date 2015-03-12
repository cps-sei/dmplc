CFLAGS=-g -Og -std=c++11 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi \
	-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -I$(DMPL_ROOT)/include
LIBS=$(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so \
	$(GAMS_ROOT)/lib/libGAMS.so -lpthread
DMPL=example-01.dmpl example-02.dmpl example-03.dmpl example-04.dmpl
SRC=$(patsubst %.dmpl,%.cpp,$(DMPL))
EXE=$(patsubst %.dmpl,%,$(DMPL))

ifdef MZSRM_ROOT
CFLAGS += -I$(MZSRM_ROOT)/zsrmm
LIBS += $(MZSRM_ROOT)/zsrmm/lib/libzs.a
endif

#default grid size and map coordinates 
GRIDSIZE=10
TopY=2.25
LeftX=-2.25
BottomY=-2.25
RightX=2.25

all: $(EXE) Makefile

%: %.cpp
	g++ $(CFLAGS) -o $@ $< $(LIBS)

example-01.cpp: example-01.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 3 -g -o $@ $<

example-02.cpp: example-02.dmpl example-02-AADL.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -e -n 5 --DX $(GRIDSIZE) --DY $(GRIDSIZE) --DTopY $(TopY) --DBottomY $(BottomY) --DLeftX $(LeftX) --DRightX $(RightX) -g -o $@ $< example-02-AADL.dmpl

example-03.cpp: example-03.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 --DX $(GRIDSIZE) --DY $(GRIDSIZE) --DTopY $(TopY) --DBottomY $(BottomY) --DLeftX $(LeftX) --DRightX $(RightX) -g -o $@ $<

example-04.cpp: example-04.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 --DX $(GRIDSIZE) --DY $(GRIDSIZE) --DTopY $(TopY) --DBottomY $(BottomY) --DLeftX $(LeftX) --DRightX $(RightX) -g -o $@ $<

clean:
	rm -f $(EXE) $(SRC)
