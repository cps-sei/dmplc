DAIG=../daig/Expression.cpp ../daig/Function.cpp \
../daig/Model_Of_Computation.cpp ../daig/Node.cpp ../daig/Program.cpp \
../daig/Variable.cpp ../daig/Statement.cpp ../daig/Type.cpp
DAIG_HDRS=$(patsubst %.cpp,%.h,$(DAIG))
PARSER=daig-scanner.cpp daig-parser.cpp DaigBuilder.cpp
INC=-I/home/chaki/stuff/madara/ace/ACE_wrappers \
-I/home/chaki/stuff/madara/madara/include -I../daig
LIB=/home/chaki/stuff/madara/madara/libMADARA.so

all : daig-bison sync-seq

daig-bison : daig-bison.cpp $(PARSER) $(DAIG) $(DAIG_HDRS)
	g++ -o daig-bison $(INC) daig-bison.cpp $(PARSER) $(DAIG) $(LIB)

sync-seq : sync-seq.cpp $(PARSER) $(DAIG) $(DAIG_HDRS)
	g++ -o daig-bison $(INC) sync-seq.cpp $(PARSER) $(DAIG) $(LIB)

daig-scanner.cpp : daig-scanner.ll
	flex -o daig-scanner.cpp daig-scanner.ll

daig-parser.cpp : daig-parser.yy
	bison -d -o daig-parser.cpp daig-parser.yy

clean :
	rm -f daig-bison daig-scanner.cpp daig-parser.cpp daig-parser.hpp stack.hh position.hh location.hh
