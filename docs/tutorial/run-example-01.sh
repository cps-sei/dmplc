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
    killall $NODECMD vrep vrep.sh

    #restore the VREP system/settings.dat
    cp $SDF.saved.mcda-vrep $SDF

    #all done
    exit 0
}

trap "cleanup" SIGINT SIGTERM SIGHUP

INIT_PORT="19905"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

function usage {
    echo "Usage : $0 <node-num> <out-dir> <node-1-args> ... <node-N-args>"
    echo "        where N = node-num"
}

#get the number of nodes
NODENUM=$1
#echo $NODENUM

if [ "$#" != $(expr $NODENUM \* 5 + 2) ]; then
    usage
    exit 1
fi

#get the output directory
shift 1
OUTDIR="$1"
#echo $OUTDIR
shift 1

#create the output directory and get its realpath
rm -fr $OUTDIR; mkdir $OUTDIR
OUTDIR=$(realpath $OUTDIR)

#compile and get the node executable
#rm -f example-01.cpp example-01 && make example-01
make example-01
NODECMD="./example-01"

#get the node arguments
declare -a NODEARGS
for i in `seq 1 $NODENUM`; do
    NODEARGS[${i}]="${NODEARGS[${i}]} --id $1"
    shift 1
    NODEARGS[${i}]="${NODEARGS[${i}]} --var_x $1"
    shift 1
    NODEARGS[${i}]="${NODEARGS[${i}]} --var_y $1"
    shift 1
    NODEARGS[${i}]="${NODEARGS[${i}]} --var_xf $1"
    shift 1
    NODEARGS[${i}]="${NODEARGS[${i}]} --var_yf $1"
    shift 1
    #echo ${NODEARGS[${i}]}
done

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
(cd $VREP_ROOT ; ./vrep.sh $SCDIR/dart-small.ttt &> $OUTDIR/vrep.out &)
sleep 5

#restore old VREP remoteApiConnections.txt file
mv $RAC.saved.mcda-vrep $RAC

#start the nodes
PORT=$INIT_PORT
for i in `seq 1 $NODENUM`; do
    echo "starting node $i .. output is in $OUTDIR/node-$i.out"
    ($NODECMD --platform vrep::::0.2 ${NODEARGS[${i}]} &> $OUTDIR/node-$i.out &)
    PORT=$(expr $PORT + 1)
done
#(gdb --args $NODECMD --platform vrep::::0.2 ${NODEARGS[1]})

printf "press enter terminate the simulation ..."
read X

cleanup
