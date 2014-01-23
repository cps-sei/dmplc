all : daig-bison

daig-bison : daig-bison.cpp daig-scanner.cpp daig-parser.cpp
	g++ -o daig-bison -I../daig daig-bison.cpp daig-scanner.cpp daig-parser.cpp

daig-scanner.cpp : daig-scanner.ll
	flex -o daig-scanner.cpp daig-scanner.ll

daig-parser.cpp : daig-parser.yy
	bison -d -o daig-parser.cpp daig-parser.yy

clean :
	rm -f daig-bison daig-scanner.cpp daig-parser.cpp daig-parser.hpp stack.hh position.hh location.hh
