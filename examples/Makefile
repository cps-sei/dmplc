GCC=g++ -std=c++0x -I$(ACE_ROOT) -I$(MADARA_ROOT)/include -L$(MADARA_ROOT)/lib
COLL=../simulation/collision
COMM=../simulation/comm
MCAST=$(COMM)/multicast

all : algo1

algo1 : algo1.cpp $(COLL)/madara_coordination.o $(COLL)/coordination.h $(COMM)/kb_setup.o $(MCAST)/comm_multicast.o
	$(GCC) -c -I$(COLL) -I$(COMM) algo1.cpp
	$(GCC) -o $@ algo1.o $(COLL)/madara_coordination.o $(COMM)/kb_setup.o $(MCAST)/comm_multicast.o -lMADARA

$(COLL)/madara_coordination.o : $(COLL)/madara_coordination.cpp $(COLL)/coordination.h
	(cd $(COLL); $(GCC) -c -I../comm madara_coordination.cpp)

$(COMM)/kb_setup.o : $(COMM)/kb_setup.cpp
	(cd $(COMM); $(GCC) -c kb_setup.cpp)

$(MCAST)/comm_multicast.o : $(MCAST)/comm_multicast.cpp
	(cd $(MCAST); $(GCC) -c -I.. comm_multicast.cpp)

clean :
	rm -f algo1 algo1.o $(COLL)/madara_coordination.o $(COMM)/kb_setup.o $(MCAST)/comm_multicast.o
