LIB=libdmpl-ardrone.a
CSRC=ardrone_testing_tool.c Navdata/navdata.c Video/video_stage.c
COBJ=$(CSRC:.c=.o)
CPPSRC=PlatformARDrone.cpp
CPPOBJ=$(CPPSRC:.cpp=.o)
INC=-I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Lib
INC+=-I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Os/linux -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Common
INC+=-I$(ARDRONE_ROOT)/ARDroneLib

LIBS=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/ardrone_lib_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libpc_ardrone.a
LIBS+=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/vlib_PROD_MODE_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libvlib.a
LIBS+=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/sdk_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libsdk.a
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
