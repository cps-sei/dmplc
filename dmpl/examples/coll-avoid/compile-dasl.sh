#!/bin/bash

dmplc --nodes $2 --madara --out $1.cpp $1.dmpl
g++ -I$ACE_ROOT -I$MADARA_ROOT/include -o $1 $1.cpp $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so

