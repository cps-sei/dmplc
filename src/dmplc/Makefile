MZSRM=0

SRC=dmpl-scanner.cpp dmpl-parser.cpp DmplBuilder.cpp CopyVisitor.cpp \
SyncSeqDbl.cpp SyncSeqDblInd.cpp SyncSeqDblParam.cpp ../dmpl/Attribute.cpp \
../dmpl/Expression.cpp ../dmpl/Function.cpp ../dmpl/Record.cpp \
../dmpl/Node.cpp ../dmpl/Program.cpp ../dmpl/Symbol.cpp \
../dmpl/Variable.cpp ../dmpl/Statement.cpp ../dmpl/Type.cpp \
../dmpl/CProgram.cpp ../dmpl/Visitor.cpp ../dmpl/Role.cpp \
../dmpl/Specification.cpp ../dmpl/gams/GAMSBuilder.cpp \
../dmpl/gams/AnalyzerBuilder.cpp ../dmpl/gams/GAMSVisitors.cpp \
../dmpl/NodeRole.cpp 
# ArrayElim.cpp

OBJ=$(SRC:.cpp=.o)
INC=-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I$(JAVA_ROOT)/include -I..
LIB=
ifeq "$(MZSRM)" "1"
LIB+= $(JAVA_ROOT)/jre/lib/amd64/server/libjvm.so
endif
CFLAGS=-g -Og -fno-inline -DUSE_MZSRM=$(MZSRM) -std=c++11
ifeq "$(STATIC)" "1"
CFLAGS+= -static
endif
CXX=g++
VREP_FILES=remoteApi.so vrep.py vrepConst.py
BITNESS=32Bit
ifeq ($(shell arch),x86_64)
BITNESS=64Bit
endif

all : $(VREP_FILES) dmplc

remoteApi.so :
	cp $(VREP_ROOT)/programming/remoteApiBindings/lib/lib/$(BITNESS)/remoteApi.so .

vrep.py :
	cp $(VREP_ROOT)/programming/remoteApiBindings/python/python/vrep.py .

vrepConst.py :
	cp $(VREP_ROOT)/programming/remoteApiBindings/python/python/vrepConst.py .

dmplc : dmpl-parser.hpp dmplc.cpp $(OBJ)
	$(CXX) $(CFLAGS) -o $@ $(INC) dmplc.cpp $(OBJ) $(LIB)
ifeq "$(STATIC)" "1"
	strip $@
endif

dmpl-scanner.cpp : dmpl-scanner.ll
	flex -o dmpl-scanner.cpp dmpl-scanner.ll

dmpl-parser.cpp dmpl-parser.hpp : dmpl-parser.yy
	bison -d -o dmpl-parser.cpp dmpl-parser.yy

%.o : %.cpp
	$(CXX) $(CFLAGS) -c -o $@ $(INC) $<

%.d : %.cpp
	$(CXX) $(CFLAGS) -MM -MG -MT $(@:.d=.o) -o $@ $(INC) $<

clean :
	rm -f dmplc dmpl-scanner.cpp dmpl-parser.cpp dmpl-parser.hpp \
stack.hh position.hh location.hh $(OBJ) $(SRC:.cpp=.d) $(VREP_FILES)

-include $(SRC:.cpp=.d)

