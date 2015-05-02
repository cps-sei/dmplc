This software was developed and tested on Xubuntu 14.04. In the
following, lines starting with '$' indicate commands to be entered
into a bash terminal. We assume that this package was unpacked in
$HOME, i.e., the path of this file is $HOME/smc-dart/README.txt.

Note: we have not included the ZSRM scheduler because it is kernel
specific, and could lead to compilation issues on your machine. We
believe the default Linux scheduler will provide similar results for
these examples.

=== Install Packages ===

The following Ubuntu packages are required:

$ sudo apt-get install perl git build-essential subversion libboost-all-dev bison flex realpath tk

=== Set Environment Variables ===

=== Install V-REP ===

$ cd $HOME/smc-dart
$ source ./setenv.sh
$ ./install-vrep.sh

=== Run Aggregator ===

$ cd $HOME/smc-dart
$ source ./setenv.sh
$ cd $PKGROOT/dart-smc
$ ./dart-smc

Select the experiment from the drop-down list.

-- Experiment 1 in the paper is exp1.

-- Experiment 2 in the paper is composed of exp2a, exp2b, exp2c, exp2d,
for the High, Medium, Low, and Poor network qualities, respectively.

=== Run Simulation Client ===

$ cd $HOME/smc-dart
$ source ./setenv.sh
$ cd $DMPL_ROOT/test/rv2015/
$ $PKGROOT/dart-smc/smc-client $IP

Where $IP is the ip address of the aggregator. If this is omitted, it
defaults to localhost.

=== Run Simulation ===

Once all simulation clients have connected, click Run to begin the
experiment. Experiment will stop once target relative error is met for
all properties, or you can stop early with the Stop
button. Experiments can be stopped and resumed later.

Results are stored in .state files in $PKGROOT/dart-smc with name
corresponding to experiment name.  The package includes the .state
files we generated, so new results will add to those by default.  To
produce fresh experimental results, delete these files before
beginning.
