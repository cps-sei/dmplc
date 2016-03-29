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

#check if we creashed the last time around
if [ -f /tmp/dart-run.sh.$PPID ]; then
    echo ">>> hmmm ... simulation seems to have failed the last time ..."
    echo ">>> let's wait for a bit ..."
    sleep 30
fi

function cleanup()
{
    echo ">>> cleanup does nothing ..."
}

function interrupt()
{
    killall g++ dmpl-sim.sh
    cleanup
    status='"status":'$1
    JSON="{$status}"
    echo $JSON > $OUTPUT
    echo ">>> run script terminated: $JSON"
    exit
}

echo ">>> checking out and compiling dmplc"
DMPL_BRANCH="$(jget -i input.json dmpl_branch)"
lpwd=$PWD
cd $DMPL_ROOT
checkout_dmplc_branch $DMPL_BRANCH
make &
wait
cd $lpwd

echo ">>> setting input variables"
declare -a eargs eavars
for ivar in $(jget -k -i input.json); do
    varn=$(echo $ivar | awk -F'.' '{print $1}')
    node=$(echo $ivar | awk -F'.' '{print $2}')

    if [ "$varn" == "dmpl_branch" ] || [ "$varn" == "dmpl_dir" ]; then
        continue;
    fi

    ival=$(jget -k -i input.json $ivar)

    #if node input
    if [ "x$node" == "x" ]; then
        #echo ">>> ===  $varn=$ival"
        export $varn=$ival
    else
        eargs[$node]="${eargs[$node]} --var_$varn $ival"
        eavars[$node]="EARGS_$node"
        #echo $varn.$node=$ival ${eargs[$node]}
        export ${eavars[$node]}="${eargs[$node]}"
    fi
done

echo ">>> running mission"
DMPL_DIR="$(jget -i input.json dmpl_dir)"
cd $DMPL_ROOT/$DMPL_DIR
/usr/bin/time -p -f "%e" dmpl-sim.sh -r -h -e $TMPF $SCENARIO.mission |& tee $TMPF.simout &
wait
echo "######## return code = $?"
grep -q "Command exited with non-zero status" $TMPF.simout
sim_status=$?
echo ">>> simulation status = $sim_status"
cat $TMPF.analyze; cd $lpwd

#get various times and create stats and supplementary data
rw=1
sw=0.91
tt=$(tail -n1 $TMPF.simout)
stats='"stats":{"totaltime":'$tt',"simtime.rw":'$rw',"simtime.sw":'$sw'}'
supdata='"supdata":{"foo":6,"bar":9,"dart":1}'

#create result depending on whether simulation failed. if simulation
#failed, also record it in a file
if [ "x$sim_status" == "x0" ]; then 
    touch /tmp/dart-run.sh.$PPID
    status='"status":-3'
    JSON="{$status,$stats,$supdata}"
else
    rm -f /tmp/dart-run.sh.$PPID
    status='"status":0'
    preds='"predicates":{'
    count=0
    for pred in $(jget -k -i $PREDICATE tests); do
        pred_name=$(echo $pred | awk -F'.' '{print $1}')
        node_id=$(echo $pred | awk -F'.' '{print $2}')
        pred_val=$(cat $TMPF.analyze | grep "${pred_name},${node_id}" | awk -F',' '{print $4}')
        
        if [ $count == "0" ]; then count=1; else preds+=","; fi
        preds+='"'$pred'":'$pred_val
    done
    preds+='}'
    JSON="{$status,$preds,$stats,$supdata}"
fi

cleanup
echo $JSON > $OUTPUT
echo ">>> run script complete: $JSON"
