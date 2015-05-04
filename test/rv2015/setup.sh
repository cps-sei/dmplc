#!/bin/bash

#VREP
(cd $PKGROOT && ./install-vrep.sh)

#GAMS
(cd $PKGROOT/gams && make vrep=1)
