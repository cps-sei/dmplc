#!/bin/bash

printf "testing example-01 : "
dmplc -n 3 --DX 10 --DY 10 --DTopY 2.25 --DBottomY -2.25 --DLeftX -2.25 --DRightX 2.25 -g -o example-01.cpp example-01.dmpl &> /dev/null
diff example-01.cpp example-01.cpp.saved &> /dev/null
if [ "$?" == "0" ]; then echo "SUCCESS"; else echo "FAILURE"; fi

