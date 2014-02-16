SRC=daig-scanner.cpp daig-parser.cpp DaigBuilder.cpp SyncSeq.cpp \
../daig/Expression.cpp ../daig/Function.cpp \
../daig/Model_Of_Computation.cpp ../daig/Node.cpp ../daig/Program.cpp \
../daig/Variable.cpp ../daig/Statement.cpp ../daig/Type.cpp \
../daig/CProgram.cpp ../daig/StmtVisitor.cpp
OBJ=$(patsubst %.cpp,%.o,$(SRC))
INC=-I/home/chaki/stuff/madara/ace/ACE_wrappers \
-I/home/chaki/stuff/madara/madara/include -I../daig
LIB=/home/chaki/stuff/madara/madara/libMADARA.so

all : daslc

daslc : daslc.cpp daig-parser.hpp $(OBJ)
	g++ -o $@ $(INC) daslc.cpp $(OBJ) $(LIB)

daig-scanner.cpp : daig-scanner.ll
	flex -o daig-scanner.cpp daig-scanner.ll

daig-parser.cpp daig-parser.hpp : daig-parser.yy
	bison -d -o daig-parser.cpp daig-parser.yy

%.o : %.cpp
	g++ -c -o $@ $(INC) $<

%.d : %.cpp
	g++ -MM -MT $(@:%.d=%.o) -o $@ $(INC) $<

clean :
	rm -f daslc daig-scanner.cpp daig-parser.cpp daig-parser.hpp \
stack.hh position.hh location.hh $(OBJ)

-include $(SRC:%.cpp=%.d)

