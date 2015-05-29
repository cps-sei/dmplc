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


DEBUG=1

function usage {
    echo "Usage : $0 file.mission input.log output.log"
}

#get inputs
MISSION="$1"
INLOG="$2"
OUTLOG="$3"

if [ "$#" == "2" ]; then
  if [ "$MISSION" = "exp1.mission" ]; then
    for at_least in 25 50 62 75 82 90 95; do
      for thresh in 02 05 08 10 15 20 25 30 40 50 60 70 80 90 95; do
        echo 0,COVERAGE_${at_least}_${thresh} >> $INLOG
      done
    done
  else
    echo Node,Predicate > $INLOG
    echo 0,REACHED_END >> $INLOG
  fi
    exit 0
elif [ "$#" -lt "3" ]; then
    usage
    exit 1
fi

shift
shift
shift

#get the directory where this script is located
SCDIR=$(dirname $(realpath $0))

. $MISSION


for file in `which dmplc` $DMPL; do
if [ $file -nt ${BIN}-analyze.cpp ]; then
dmplc -a -n $NODENUM --DX $GRIDSIZE --DY $GRIDSIZE -o ${BIN}-analyze.cpp $DMPL
fi
done
if [ ${BIN}-analyze.cpp -nt ${BIN}-analyze ]; then
CFLAGS="-fno-var-tracking -fno-var-tracking-assignments -std=c++11 -I$DMPL_ROOT/src -I$VREP_ROOT/programming/remoteApi -I$ACE_ROOT -I$MADARA_ROOT/include -I$GAMS_ROOT/src -I$DMPL_ROOT/include"
LIBS="$LIBS $MADARA_ROOT/libMADARA.so $ACE_ROOT/lib/libACE.so $GAMS_ROOT/lib/libGAMS.so -lpthread"
g++ $CFLAGS -o $BIN-analyze ${BIN}-analyze.cpp $LIBS
fi

cat $INLOG | ./$BIN-analyze "$@" > $OUTLOG
