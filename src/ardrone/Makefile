LIB=libdmpl-ardrone.a
CSRC=ardrone_testing_tool.c Navdata/navdata.c Video/video_stage.c
COBJ=$(CSRC:.c=.o)
CPPSRC=PlatformARDrone.cpp
CPPOBJ=$(CPPSRC:.cpp=.o)
INC=-I. -I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Lib
INC+=-I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Os/linux -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Common
INC+=-I$(ARDRONE_ROOT)/ARDroneLib

LIBS=$(shell find $(ARDRONE_ROOT)/ARDroneLib -name libpc_ardrone.a)
LIBS+=$(shell find $(ARDRONE_ROOT)/ARDroneLib -name libvlib.a)
LIBS+=$(shell find $(ARDRONE_ROOT)/ARDroneLib -name libsdk.a)
LIBS+=-pthread

all : PlatformARDrone

PlatformARDrone : $(CPPOBJ) $(LIB)
	g++ -o $@ $(CPPOBJ) $(INC) -L. -ldmpl-ardrone $(LIBS)

$(LIB) : $(COBJ)
	ar rc $@ $(COBJ)

%.o : %.c
	gcc $(INC) -c -o $@ $<

%.o : %.cpp
	g++ $(INC) -c -o $@ $<

%.d : %.c
	gcc -MM -MG -MT $(@:.d=.o) -o $@ $(INC) $<

%.d : %.cpp
	g++ -MM -MG -MT $(@:.d=.o) -o $@ $(INC) $<

clean :
	rm -f $(LIB) $(COBJ) $(CPPOBJ) $(CSRC:.c=.d) $(CPPSRC:.cpp=.d) PlatformARDrone

-include $(CSRC:.c=.d) $(CPPSRC:.cpp=.d)
