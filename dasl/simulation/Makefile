GCC=g++ -std=c++0x

all :
	(cd collision; $(GCC) -c -I../comm algo1.cpp)
	(cd collision; $(GCC) -c -I../comm madara_coordination.cpp)
	(cd comm; $(GCC) -c kb_setup.cpp)
	(cd comm/multicast; $(GCC) -c -I.. comm_multicast.cpp)
	(cd collision; $(GCC) -o algo1 algo1.o madara_coordination.o ../comm/kb_setup.o ../comm/multicast/comm_multicast.o -lMADARA)
