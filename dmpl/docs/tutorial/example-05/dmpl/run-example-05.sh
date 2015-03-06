#!/bin/bash

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
./example-05 --platform vrep::::0.2 --id 1 --var_x $((IX+2)) --var_y $((IY+2)) &> $OUTDIR/node1.out &
./example-05 --platform vrep::::0.2 --id 2 --var_x $((IX-2)) --var_y $((IY+2)) &> $OUTDIR/node2.out &
./example-05 --platform vrep::::0.2 --id 3 --var_x $((IX-2)) --var_y $((IY-2)) &> $OUTDIR/node3.out &
./example-05 --platform vrep::::0.2 --id 4 --var_x $((IX+2)) --var_y $((IY-2)) &> $OUTDIR/node4.out &
./example-05 --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY &> $OUTDIR/node0.out &

printf "press enter terminate the simulation ..."
read X
cleanup
