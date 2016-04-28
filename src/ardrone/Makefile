LIB=libdmpl-ardrone.a
OBJS=ardrone_testing_tool.o Navdata/navdata.o Video/video_stage.o
INCDIR=-I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Lib
INCDIR+=-I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Os/linux -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Common
INCDIR+=-I$(ARDRONE_ROOT)/ARDroneLib

LIBS=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/ardrone_lib_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libpc_ardrone.a
LIBS+=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/vlib_PROD_MODE_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libvlib.a
LIBS+=$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/sdk_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/libsdk.a
LIBS+=-pthread

all : ardrone_testing_tool

ardrone_testing_tool : ardrone_testing_tool.cpp $(LIB)
	g++ -o $@ ardrone_testing_tool.cpp $(INCDIR) -L. -ldmpl-ardrone $(LIBS)

$(LIB) : $(OBJS)
	ar rc $@ $(OBJS)

%.o : %.c
	gcc $(INCDIR) -c -o $@ $<

clean :
	rm -f $(LIB) $(OBJS) ardrone_testing_tool
