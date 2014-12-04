all: dart dart9 dart9t

dart: dart.cpp
	g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o dart dart.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

dart.cpp: dart.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 5 -g -o dart.cpp dart.dmpl

dart9: dart9.cpp
	g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o dart9 dart9.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

dart9.cpp: dart9.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o dart9.cpp dart9.dmpl

dart9t: dart9t.cpp
	g++ -g -O0 -I$(DMPL_ROOT)/src -I$(VREP_ROOT)/programming/remoteApi -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(GAMS_ROOT)/src -o dart9t dart9t.cpp $(MADARA_ROOT)/libMADARA.so $(ACE_ROOT)/lib/libACE.so $(GAMS_ROOT)/lib/libGAMS.so -lpthread

dart9t.cpp: dart9t.dmpl $(DMPL_ROOT)/src/dmplc/dmplc
	dmplc -n 9 -g -o dart9t.cpp dart9t.dmpl

clean:
	rm -f dart.cpp
	rm -f dart
	rm -f dart9.cpp
	rm -f dart9
	rm -f dart9t.cpp
	rm -f dart9t
