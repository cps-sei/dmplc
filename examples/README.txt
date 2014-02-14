Read LICENSE.txt for the license. 

sync-coll-avoid.mcda = DASL program for collision avoidance

sync-coll-avoid.c = manually sequentialized version of
sync-coll-avoid.mcda for 2 nodes

First install cbmc v4.6 and plingeling and make sure the binaries
"cbmc" and "plingeling" are on your path.

CBMC webpage: http://www.cprover.org/cbmc
Plingeling webpage: http://fmv.jku.at/lingeling

Then use script ./run.sh to run experiments. To run the experiment
with an AxB grid and R rounds, use the following command line:

./run.sh A B R
