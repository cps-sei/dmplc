#!/bin/bash

IX=$1
IY=$2
FX=$3
FY=$4

echo $IX $IY $FX $FY

trap "killall dart9;exit 0" SIGINT SIGTERM SIGHUP

./dart9 --platform vrep::::0.2 --id 1 --var_x $((IX+2)) --var_y $((IY+2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 2 --var_x $((IX)) --var_y $((IY+2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 3 --var_x $((IX-2)) --var_y $((IY+2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 4 --var_x $((IX-2)) --var_y $((IY)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 5 --var_x $((IX-2)) --var_y $((IY-2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 6 --var_x $((IX)) --var_y $((IY-2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 7 --var_x $((IX+2)) --var_y $((IY-2)) > /dev/null &
./dart9 --platform vrep::::0.2 --id 8 --var_x $((IX+2)) --var_y $((IY)) > /dev/null &

./dart9 --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY
