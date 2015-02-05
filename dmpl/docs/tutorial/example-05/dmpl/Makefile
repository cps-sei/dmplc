CFLAGS=-g -O3 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi \
	-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -I$(DMPL_ROOT)/include
LIBS=$(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so \
	$(GAMS_ROOT)/lib/libGAMS.so -lpthread
DMPL=example-05.dmpl
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

example-05.cpp: example-05.dmpl example-05.sched.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -e -n 5 --DX $(GRIDSIZE) --DY $(GRIDSIZE) --DTopY $(TopY) --DBottomY $(BottomY) --DLeftX $(LeftX) --DRightX $(RightX) -g -o $@ $< example-05.sched.dmpl

clean:
	rm -f $(EXE) $(SRC)
