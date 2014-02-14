DAIG=../daig/Expression.cpp ../daig/Function.cpp \
../daig/Model_Of_Computation.cpp ../daig/Node.cpp ../daig/Program.cpp \
../daig/Variable.cpp ../daig/Statement.cpp ../daig/Type.cpp
DAIG_HDRS=$(patsubst %.cpp,%.h,$(DAIG))
SRC=daig-scanner.cpp daig-parser.cpp DaigBuilder.cpp SyncSeq.cpp
HDR=DaigBuilder.hpp SyncSeq.hpp
INC=-I/home/chaki/stuff/madara/ace/ACE_wrappers \
-I/home/chaki/stuff/madara/madara/include -I../daig
LIB=/home/chaki/stuff/madara/madara/libMADARA.so

all : daslc

daslc : daslc.cpp $(SRC) $(HDR) $(DAIG) $(DAIG_HDRS)
	g++ -o $@ $(INC) daslc.cpp $(SRC) $(DAIG) $(LIB)

daig-scanner.cpp : daig-scanner.ll
	flex -o daig-scanner.cpp daig-scanner.ll

daig-parser.cpp : daig-parser.yy
	bison -d -o daig-parser.cpp daig-parser.yy

clean :
	rm -f daslc daig-scanner.cpp daig-parser.cpp daig-parser.hpp stack.hh position.hh location.hh
