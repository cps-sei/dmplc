#!/bin/bash -x

INIT_PORT="19905"

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

function usage {
    echo "Usage : $0 <out-dir> <init-x> <init-y> <final-x> <finaly>"
    echo "        where N = node-num"
}

#get inputs
OUTDIR="$1"
IX=$2
IY=$3
FX=$4
FY=$5

#get the number of nodes
NODENUM=$1
#echo $NODENUM

if [ "$#" != "5" ]; then
    usage
    exit 1
fi

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
NODENUM=5
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
(cd $VREP_ROOT ; ./vrep.sh $SCDIR/dart-10x10.ttt &> $OUTDIR/vrep.out &)
sleep 3

#restore old VREP remoteApiConnections.txt file
mv $RAC.saved.mcda-vrep $RAC

#start the nodes
./example-02 --platform vrep::::0.2 --id 1 --var_x $((IX+1)) --var_y $((IY+1)) &> $OUTDIR/node1.out &
./example-02 --platform vrep::::0.2 --id 2 --var_x $((IX-1)) --var_y $((IY+1)) &> $OUTDIR/node2.out &
./example-02 --platform vrep::::0.2 --id 3 --var_x $((IX-1)) --var_y $((IY-1)) &> $OUTDIR/node3.out &
./example-02 --platform vrep::::0.2 --id 4 --var_x $((IX+1)) --var_y $((IY-1)) &> $OUTDIR/node4.out &
./example-02 --platform vrep::::0.2 --id 0 --var_x $IX --var_y $IY --var_xt $FX --var_yt $FY &> $OUTDIR/node0.out &

printf "press enter terminate the simulation ..."
read X

#kill nodes and VREP
killall example-02 vrep vrep.sh

#restore the VREP system/settings.dat
cp $SDF.saved.mcda-vrep $SDF

#all done
exit 0
