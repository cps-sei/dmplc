SRC=dmpl-scanner.cpp dmpl-parser.cpp DmplBuilder.cpp CopyVisitor.cpp \
SyncSeqDbl.cpp ArrayElim.cpp \
../dmpl/Expression.cpp ../dmpl/Function.cpp \
../dmpl/Node.cpp ../dmpl/Program.cpp \
../dmpl/Variable.cpp ../dmpl/Statement.cpp ../dmpl/Type.cpp \
../dmpl/CProgram.cpp ../dmpl/Visitor.cpp \
../dmpl/gams/Sync_Builder.cpp \
../dmpl/gams/Function_Visitor.cpp

OBJ=$(SRC:.cpp=.o)
INC=-I$(ACE_ROOT) -I$(MADARA_ROOT)/include -I..
LIB=$(MADARA_ROOT)/libMADARA.so
CFLAGS=-g -O0 -fno-inline
CXX=g++

all : dmplc

dmplc : dmpl-parser.hpp dmplc.cpp $(OBJ)
	$(CXX) $(CFLAGS) -o $@ $(INC) dmplc.cpp $(OBJ) $(LIB)

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
stack.hh position.hh location.hh $(OBJ) $(SRC:.cpp=.d)

-include $(SRC:.cpp=.d)

