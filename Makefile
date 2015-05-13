ACE_LIB=$(ACE_ROOT)/lib/libACE.so
MADARA_LIB=$(MADARA_ROOT)/lib/libMADARA.so

all : dmplc
	make -C src/vrep

dmplc : $(ACE_LIB) $(MADARA_LIB)
	make -C src/dmplc

clean :
	make -C src/dmplc clean
	make -C src/vrep clean
