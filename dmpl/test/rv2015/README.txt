This software was developed and tested on 64bit Xubuntu 14.04. In the
following, lines starting with '$' indicate commands to be entered
into a bash terminal. We assume that this package was unpacked in
$HOME, i.e., the path of this file is $HOME/smc-dart/README.txt. We
are assuming you have a single machine on which all experiments will
be done.

Note: we have not included the ZSRM scheduler because it is kernel
specific, and could lead to compilation issues on your machine. We
believe the default Linux scheduler will provide similar results for
these examples.

=== One-Time Setup ===

The following has to be done once on your machine.

1. Install packages

$ sudo apt-get install perl git build-essential subversion libboost-all-dev bison flex realpath tk xvfb openjdk-7-jdk

2. Install PRISM from http://www.prismmodelchecker.org/. We used
version 4.1.beta-2. We recommend you download PRISM source and
compile. Make sure the program "prism" is on your PATH, and runs
without errors.

3. Install V-REP and then compile GAMS.

$ cd $HOME/smc-dart && source ./setenv.sh && ./setup.sh

=== Running Experiments ===

1. Run Aggregator

Open a terminal (Term1) and run the following commands:

$ cd $HOME/smc-dart && source ./setenv.sh && cd $PKGROOT/dart-smc && ./dart-smc

A new Aggregator window (GUI) will pop up. Select the experiment from
the drop-down list. You must select your desired experiment before
starting any simulation clients.

-- Experiment 1 in the paper is exp1.

-- Experiment 2 in the paper is composed of exp2a, exp2b, exp2c, exp2d,
for the High, Medium, Low, and Poor network qualities, respectively.

2. Run Simulation Client

Open another terminal (Term2) and run the following commands:

$ cd $HOME/smc-dart && source ./setenv.sh && cd $DMPL_ROOT/test/rv2015 && $PKGROOT/dart-smc/smc-client

3. Start experiments

Switch back to the GUI. You should see a new client in the pane called
"Connections". Click Run to begin the experiment. The main pane of the
GUI shows each property, and its currently computed probability and
relative error (RE). Experiment will stop once target relative error
is met for all properties, or you can stop early with the Stop
button. Experiments can be stopped and resumed later.

Results are stored in .state files in $PKGROOT/dart-smc with name
corresponding to experiment name. For reference, the .state files we
generated for the paper are in $PKGROOT/dart-smc/paper-states.

NOTE: "Samples" in the GUI shows the number of valid simulation
results. If this value does not increase for a while (5 minutes), then
it means no new valid simulation results are being received by the
Aggregator. Simply restart the client as follows:

a) Switch to the GUI, click Stop.

b) Switch to Term2. Hit Ctrl-C to stop the client and restart it with:

$ $PKGROOT/dart-smc/smc-client

c) Switch back to GUI, and click Run.

The experiment will resume, and previous valid results will be
retained. If you want to restart an experiment from scratch, delete
the corresponding ".state" file.
