#!/bin/bash

IX=$1
IY=$2
FX=$3
FY=$4

trap "killall dart9t;exit 0" SIGINT SIGTERM SIGHUP

./dart9t --platform vrep::::0.2 --id 1 --var_x $((IX+1)) --var_y $((IY+1)) > log1 &
./dart9t --platform vrep::::0.2 --id 2 --var_x $((IX)) --var_y $((IY+1)) > log2 &
./dart9t --platform vrep::::0.2 --id 3 --var_x $((IX-1)) --var_y $((IY+1)) > log3 &
./dart9t --platform vrep::::0.2 --id 4 --var_x $((IX-1)) --var_y $((IY)) > log4 &
./dart9t --platform vrep::::0.2 --id 5 --var_x $((IX-1)) --var_y $((IY-1)) > log5 &
./dart9t --platform vrep::::0.2 --id 6 --var_x $((IX)) --var_y $((IY-1)) > log6 &
./dart9t --platform vrep::::0.2 --id 7 --var_x $((IX+1)) --var_y $((IY-1)) > log7 &
./dart9t --platform vrep::::0.2 --id 8 --var_x $((IX+1)) --var_y $((IY)) > log8 &

./dart9t --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY > log0
