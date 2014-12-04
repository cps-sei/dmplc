#!/bin/bash

IX=$1
IY=$2
FX=$3
FY=$4

trap "killall dart;exit 0" SIGINT SIGTERM SIGHUP

./dart --platform vrep::::0.2 --id 1 --var_x $((IX+1)) --var_y $((IY+1)) > /dev/null &
./dart --platform vrep::::0.2 --id 2 --var_x $((IX-1)) --var_y $((IY+1)) > /dev/null &
./dart --platform vrep::::0.2 --id 3 --var_x $((IX-1)) --var_y $((IY-1)) > /dev/null &
./dart --platform vrep::::0.2 --id 4 --var_x $((IX+1)) --var_y $((IY-1)) > /dev/null &

./dart --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY
