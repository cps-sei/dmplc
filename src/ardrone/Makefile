LIB=libdmpl-ardrone.a
CSRC=ardrone_testing_tool.c Navdata/navdata.c Video/video_stage.c
COBJ=$(CSRC:.c=.o)
CPPSRC=PlatformARDrone.cpp
CPPOBJ=$(CPPSRC:.cpp=.o)

INC=-D_MOBILE -DRECORD_ENCODED_VIDEO -DGNU_LINUX -pthread -I/usr/include/gtk-2.0 -I/usr/lib/x86_64-linux-gnu/gtk-2.0/include -I/usr/include/atk-1.0 -I/usr/include/cairo -I/usr/include/gdk-pixbuf-2.0 -I/usr/include/pango-1.0 -I/usr/include/gio-unix-2.0/ -I/usr/include/freetype2 -I/usr/include/glib-2.0 -I/usr/lib/x86_64-linux-gnu/glib-2.0/include -I/usr/include/pixman-1 -I/usr/include/libpng12 -I/usr/include/harfbuzz -Wall -Wall -O3 -DCOMPIL_MODE_PROD -DNDEBUG -D__linux__ -D__LINUX__ -DTARGET_CPU_ARM=0 -DTARGET_CPU_X86=1 -DUSE_WIFI -DUSE_VLIB -DUSE_LINUX -DFFMPEG_SUPPORT -DUSE_VIDEO_TCP -I$(ARDRONE_ROOT)/Examples/Linux/sdk_demo/Build/../Sources -I$(ARDRONE_ROOT)/Examples/Linux/sdk_demo/Build/../../../../ARDroneLib/Soft/Common -I$(ARDRONE_ROOT)/Examples/Linux/sdk_demo/Build/../../../../ARDroneLib/Soft/Lib -I$(ARDRONE_ROOT)/ARDroneLib/FFMPEG/Includes -I$(ARDRONE_ROOT)/ARDroneLib/VLIB/.. -I$(ARDRONE_ROOT)/ARDroneLib/VLIB/P263 -I$(ARDRONE_ROOT)/ARDroneLib/VLIB/Platform/x86 -I$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/include -I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK -I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Com -I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Os/linux -I$(ARDRONE_ROOT)/ARDroneLib/VP_SDK/VP_Com/linux

LIBS=-L$(ARDRONE_ROOT)/Examples/Linux/sdk_demo/Build/../../Build/Release -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4/install/lib -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/sdk_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4 -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/ffmpeg_static_PROD_MODE_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4 -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/vlib_PROD_MODE_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4 -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/ardrone_lib_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4 -L$(ARDRONE_ROOT)/ARDroneLib/Soft/Build/targets_versions/vision_lib_PROD_MODE_vlib_Linux_3.13.0-85-generic_GNU_Linux_usrbingcc_4.8.4 -lpc_ardrone -lgtk-x11-2.0 -lrt -lsdk -lswscale -lavformat -lavcodec -lavutil -lvlib -lpthread -lpc_ardrone -lgtk-x11-2.0 -lrt -Wl,--warn-common -O3

all : PlatformARDrone

PlatformARDrone : $(CPPOBJ) $(COBJ)
	g++ -o $@ $(CPPOBJ) $(INC) $(COBJ) $(LIBS)

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
