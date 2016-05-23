
A brief description of examples:
-------------------------------

Prerequisites for remote deployment:
-----------

- Remote deployment devices must have DART installed (see:
https://github.com/cps-sei/dart/wiki/Building-DART-v0.2--(and-later)-Software)

- Remote deployment devices must have a common ipv4 subnet that supports
multicast (wired or WiFi).

- Remote deployment devices must be administrively enabled for password
less, SSH public key authentication.

Capability:
-----------

- Support for heterogeneous local and remote processor architectures
(e.g., arm, x86, x_86_64).

- Auto-remote time synchronization (low quality), remote build, remote mission launch, monitoring and shutdown

Limitation(s):
--------------

to be fixed.

- Assumes current working directory/drivepath is $DMPL_ROOT/docs/tutorial
on deployment device. As such, the following tutorials ./example-05,
./example-06, ./example-07, ./example-08 do not work properly.

- Examples where deployment devices are remote, all remote devices are
assumed to be of the same processor architecture (e.g., arm, x86, x_86_64).

How to:
-------

Invoke dmpl-sim.sh with the -D command line option to specify deployment
mode. In deployment mode, dmpl-sim.sh will look for a .deploy file
based on the name of the .mission file indicated on the command line
(e.g., specifying example-01.mission with -D implies the deployment file
example-01.deploy).

Deployment is performed in the following manner

- Runtime constraints are tested (optional, overridden using -F)

- "Low Quality" time sync among deployment devices is performed (optional,
initiated with -T)

- Subnet routing on each deployment device is tested for multicast messaging

- Mission specification is transfered a deployment device for compilation 

- Mission implementation is replicated across all deployment devices for
installation (optional, overridden using -F)

- Synchronized launch, mission startup, execution, and termination

Example
-------

- create a deployment file (e.g., .deploy)
-- cp example-01.deploy.local example-01.deploy
-- change user id (field 1) to the user id that installed DART
-- change drive path (field 3) to the value of $DART_HOME
-- you should be able to leave ip address as is (field 2)

- dmpl-sim.sh -D example-01.mission

See other examples of .deploy files in the distribution.

Format of the deployment file
-----------------------------

Three variables must be defined:

COMMAND_SUBNET
MISSION_SUBNET
DEVICES

Where

COMMAND_SUBNET is the ipv4 address subnet used to a) deploy (launch,
startup, monitor, and end) the mission and to communicate with the
underlying physics simulator (V-REP).

MISSION_SUBNET is the ipv4 address subnet used by the device nodes
to communicate and coordinate according to the .mission and .dmpl
specification.

DEVICES an array of deployment device specification of size N. Where N
is the number of NODES specificed by the .mission specification. That is,
if the .mission specification calls for 5 nodes, the size of the DEVICES
array must be 5.  A deployment device specification is a ':' separated
list of values with the form:

	pilot:device ipv4 addr:drive path

	where:

	pilot: is the login userid that will pilot the node, this
	  userid has sudo permissions to run /bin/date for the --timeset
	  operation; /sbin/route to set the route for multicast packets

	device ipv4 addr: is the specific ip address for ssh commands
	  on the command subnet to configure and initiate deployment
	  (launch) of the node to start the mission

	drive path: is the drive path on the node where the mission
	  software and plan is to be executed

For example, in the case of example-01.mission, and assuming there are
three remote devices available to deploy the mission to, a deployment
specification for this mission could be:

COMMAND_SUBNET=192.168.2    # vrep, ssh, rsync all run here
MISSION_SUBNET=192.168.100  # msgs between nodes (madara msgs) occur here

DEVICES=( \
  odroid:${COMMAND_SUBNET}.103:/home/odroid/dart \
  odroid:${COMMAND_SUBNET}.105:/home/odroid/dart \
  odroid:${COMMAND_SUBNET}.107:/home/odroid/dart \
)

In example-01.mission there are 3 nodes which take on the role 'uav'. For
the deployment of this example to physical devices (which, for this
example, will act like UAV on physical hardware) 3 ODROID-XU4 (arm-based
processors) are available. Those 3 ODROID-XU4s have the wired ipv4
address of 192.168.2.103, 192.168.2.105, and 192.168.2.107 (respectively).
This address is used as the command address to communicate with the V-REP
physics and environment simulator running at 192.168.2.2 (in this example -
this node is not shown and not part of the device deployment specification
- BUT is assumed to be reachable from the COMMAND_SUBNET).

Each device deployment specifiction is used by dmpl-sim.sh to "fill in the 
blanks" as to what user id to use for mission deployment (in this case the
pilot is the user id on each ODROID-XU4 which is the user 'odroid'), the
ipv4 address it is available for deployment (see in the paragraph above),
and the drive path where the mission code should be deployed to (which is
the DART installation path, /home/odroid/dart).

MISSION_SUBNET is the subnet which messaging occurs between nodes during
mission execution. dmpl-sim.sh (and therefore this device deployment
specification) does not need to know the specific ipv4 device address of
each deployment device on that MISSION_SUBNET.

The following device deployment specification is like the first shown
above, but does not assume there is actual physical devices to deploy to
but can be used to test ths device deployment specification treating
'localhost' as a stand-in for remote devices.  The same deployment steps
are performed as discussed above in 'How to'.

COMMAND_SUBNET=127.0.0  # vrep, ssh, rsync all run here
MISSION_SUBNET=127.0.0  # msgs between nodes (madara msgs) occur here

DEVICES=( \
  localuser:127.0.0.1:/home/sdart/dart \
  localuser:127.0.0.1:/home/sdart/dart \
  localuser:127.0.0.1:/home/sdart/dart \
)
