#!/bin/bash

DEBUG=1

function usage {
    echo "Usage : $0 file.mission output.log"
}

#get inputs
MISSION="$1"

if [ "$#" != "2" ]; then
    usage
    exit 1
fi

. $MISSION

function cleanup {
    echo "Cleaning up ..."

    #kill nodes and VREP
    killall $BIN vrep vrep.sh
    
    #restore the VREP system/settings.dat
    cp $SDF.saved.mcda-vrep $SDF
    
    #all done
    exit 0
}

trap "cleanup" SIGINT SIGTERM SIGHUP

INIT_PORT="19905"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

MAPFILE=$SCDIR/dart-${MAPNAME}.ttt

if [ ! -e "$MAPFILE" ]; then
    echo "Map file $MAPFILE does not exist!!"
    exit 1
fi

#compile tutorial 2

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

dmplc -e -n $NODENUM --DX $GRIDSIZE --DY $GRIDSIZE --DTopY $TopY --DBottomY $BottomY --DLeftX $LeftX --DRightX $RightX -g -o ${BIN}.cpp $DMPL
CFLAGS="-g -Og -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT -I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include"
LIBS="$MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
g++ $CFLAGS -o $BIN ${BIN}.cpp $LIBS

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
GDB=""
[ "$DEBUG" -ne 0 ] && GDB="gdb -ex=r --args"
for x in `seq 1 $NODENUM`; do
echo $x
args_var=ARGS_$x
args="$(eval echo \$$args_var)"
$GDB $BIN -e $OUTDIR/expect${x}.log --platform vrep::::0.2 --id $x $args &> $OUTDIR/node${x}.out &
done
$GDB $BIN -e $OUTDIR/expect0.log --platform vrep::::0.2 --id 0 $ARGS_0 &> $OUTDIR/node0.out &

printf "press enter terminate the simulation ..."
read X
cleanup
