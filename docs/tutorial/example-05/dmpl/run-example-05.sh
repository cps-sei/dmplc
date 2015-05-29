#!/bin/bash

# Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
# 1. Redistributions of source code must retain the above copyright
# notice, this list of conditions and the following acknowledgments
# and disclaimers.
#
# 2. Redistributions in binary form must reproduce the above
# copyright notice, this list of conditions and the following
# disclaimer in the documentation and/or other materials provided
# with the distribution.
#
# 3. The names "Carnegie Mellon University," "SEI" and/or "Software
# Engineering Institute" shall not be used to endorse or promote
# products derived from this software without prior written
# permission. For written permission, please contact
# permission@sei.cmu.edu.
#
# 4. Products derived from this software may not be called "SEI" nor
# may "SEI" appear in their names without prior written permission of
# permission@sei.cmu.edu.
#
# 5. Redistributions of any form whatsoever must retain the following
# acknowledgment:
#
# This material is based upon work funded and supported by the
# Department of Defense under Contract No. FA8721-05-C-0003 with
# Carnegie Mellon University for the operation of the Software
# Engineering Institute, a federally funded research and development
# center.
#
# Any opinions, findings and conclusions or recommendations expressed
# in this material are those of the author(s) and do not necessarily
# reflect the views of the United States Department of Defense.
#
# NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
# ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
# BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
# EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
# LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
# EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
# MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
# RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
# INFRINGEMENT.
#
# This material has been approved for public release and unlimited
# distribution.
#
# DM-0002494


function cleanup {
    echo "Cleaning up ..."

    #kill nodes and VREP
    killall example-05 vrep vrep.sh
    
    #restore the VREP system/settings.dat
    cp $SDF.saved.mcda-vrep $SDF
    
    #all done
    exit 0
}

trap "cleanup" SIGINT SIGTERM SIGHUP

INIT_PORT="19905"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))/../../

function usage {
    echo "Usage : $0 <out-dir> <map-name> <grid-size> <init-x> <init-y> <final-x> <final-y>"
}

#get inputs
OUTDIR="$1"
MAPNAME="$2"
GRIDSIZE=$3
IX=$4
IY=$5
FX=$6
FY=$7

#get the number of nodes
NODENUM=5
#echo $NODENUM

if [ "$#" != "7" ]; then
    usage
    exit 1
fi

MAPFILE=$SCDIR/dart-${MAPNAME}.ttt

if [ ! -e "$MAPFILE" ]; then
    echo "Map file $MAPFILE does not exist!!"
    exit 1
fi

#compile tutorial 2
rm -f example-05 example-05.cpp

if [ "$MAPNAME" == "small" ]; then
    TopY=2.25
    LeftX=-2.25
    BottomY=-2.25
    RightX=2.25
elif [ "$MAPNAME" == "large" ]; then
    TopY=13
    LeftX=-12.5
    BottomY=-6
    RightX=6.5
fi

make example-05 GRIDSIZE=$GRIDSIZE TopY=$TopY LeftX=$LeftX BottomY=$BottomY RightX=$RightX

#create the output directory and get its realpath
rm -fr $OUTDIR; mkdir $OUTDIR
OUTDIR=$(realpath $OUTDIR)

#save old and create new VREP remoteApiConnections.txt file
RAC=$VREP_ROOT/remoteApiConnections.txt
if [ -e $RAC ]; then
    rm -f $RAC.saved.mcda-vrep
    mv $RAC $RAC.saved.mcda-vrep
fi
touch $RAC
PORT=$INIT_PORT
for i in `seq 1 $NODENUM`; do 
    echo "portIndex${i}_port                 = $PORT" >> $RAC
    echo "portIndex${i}_debug                = false" >> $RAC
    echo "portIndex${i}_syncSimTrigger       = true" >> $RAC
    echo "" >> $RAC
    PORT=$(expr $PORT + 1)
done

#cat $RAC

#save the VREP system/settings.dat
SDF=$VREP_ROOT/system/settings.dat
cp $SDF $SDF.saved.mcda-vrep
#start vrep
echo "starting VREP .. output is in $OUTDIR/vrep.out ..."
(cd $VREP_ROOT ; ./vrep.sh $MAPFILE &> $OUTDIR/vrep.out &)
sleep 5

#restore old VREP remoteApiConnections.txt file
mv $RAC.saved.mcda-vrep $RAC

#start the nodes
./example-05 -e /dev/null --platform vrep::::0.2 --id 1 --var_x $((IX+2)) --var_y $((IY+2)) &> $OUTDIR/node1.out &
./example-05 -e /dev/null --platform vrep::::0.2 --id 2 --var_x $((IX-2)) --var_y $((IY+2)) &> $OUTDIR/node2.out &
./example-05 -e /dev/null --platform vrep::::0.2 --id 3 --var_x $((IX-2)) --var_y $((IY-2)) &> $OUTDIR/node3.out &
./example-05 -e /dev/null --platform vrep::::0.2 --id 4 --var_x $((IX+2)) --var_y $((IY-2)) &> $OUTDIR/node4.out &
./example-05 -e /dev/null --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY &> $OUTDIR/node0.out &

printf "press enter terminate the simulation ..."
read X
cleanup
