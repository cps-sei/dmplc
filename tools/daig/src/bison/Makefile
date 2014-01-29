DAIG=../daig/Atomic.cpp ../daig/Expression.cpp ../daig/For_All_Higher.cpp \
../daig/For_All_Lower.cpp ../daig/For_All_Other.cpp ../daig/Function.cpp \
../daig/Model_Of_Computation.cpp ../daig/Node.cpp ../daig/Program.cpp \
../daig/Token.cpp ../daig/Variable.cpp
SRC=daig-bison.cpp daig-scanner.cpp daig-parser.cpp DaigBuilder.cpp
INC=-I/home/chaki/stuff/madara/ace/ACE_wrappers \
-I/home/chaki/stuff/madara/madara/include -I../daig
LIB=/home/chaki/stuff/madara/madara/libMADARA.so

all : daig-bison

daig-bison : $(SRC) $(DAIG)
	g++ -o daig-bison $(INC) $(SRC) $(DAIG) $(LIB)

daig-scanner.cpp : daig-scanner.ll
	flex -o daig-scanner.cpp daig-scanner.ll

daig-parser.cpp : daig-parser.yy
	bison -d -o daig-parser.cpp daig-parser.yy

clean :
	rm -f daig-bison daig-scanner.cpp daig-parser.cpp daig-parser.hpp stack.hh position.hh location.hh
