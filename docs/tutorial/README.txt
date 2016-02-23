A brief description of examples:
-------------------------------

example-01: A simple example demonstrating the synchronous collision
avoidance algorithm. Three nodes, each starting from some specified
initial location and moving to a specified final location. They use
the collision avoidance protocol.

example-01.bug1 and example-02.bug2: Same as example-01 but with bugs
introduced in the collision avoidance protocol.

example-01-ag: The scenario is the same as example-01 but the nodes
use a version of synchronous collision avoidance (proposed by Arie)
where they share only the locations that are being locked or requested
instead of a 2D "lock" array of all possible cells.

example-01-pipelined: The scenario is the same as example-01 but we
are developing this to motivate and demonstrate applicability of
pipelined ZSRM scheduling.

example-01-ranger: The scenario is the same as example-01 but we are
developing this to explore simultaneous localization and mapping
(SLAM).

example-02: An example demonstrating synchronous collision with
formation. It has five nodes in tight formation -- one (leader) in the
center of a square and the remaining four (followers) at the four
corners. All nodes execute a collision avoidance thread. They also
execute a waypoint thread. The leader's waypoint thread computes the
next waypoint using the same path planning algorithm as in
example-01. The leader also broadcasts its next waypoint to the
followers via shared variables, which is used by each follower to
determine its own next waypoint relative to that of the leader.

example-02.bug1: Same as example-02 but with a bug introduced in the
collision avoidance protocol.

example-03: This is similar to example-02 but has 9 nodes moving in a
loose 3x3 grid formation -- one (leader) in the center of the grid and
the remaining eight (followers) surrounding it on all sides. All nodes
execute a collision avoidance thread. They also execute a waypoint
thread. The leader's waypoint thread computes the next waypoint using
the same path planning algorithm as in example-01. The leader also
broadcasts its next waypoint to the followers via shared variables,
which is used by each follower to determine its own next waypoint
relative to that of the leader.

example-04: This is similar to example-03 but the nodes move in a
tight formation instead. They also use a more aggressive collision
avoidance protocol that relies on relative speeds of the nodes in
addition to locking. Each cell now has four locks (one for each
direction of inward movement) instead of one. When a node starts to
leave a cell, it unlocks (opens the door if you will) in the direction
behind it, allowing other nodes to move in. Note that if the other
node moves in too quickly, a collision could still happen (hence the
assumption about relative speed). Unlike all the previous versions of
collision avoidance, we are unable to verify this protocol correct
using software model checking only.

example-09: This is like example-02 but we have two groups of nodes,
each with one leader and four protectors. The leaders also act as
coordinators. The idea is that each group performs collision avoidance
within itself, while the coordinators ensures that the groups do no
encroach on each other's spaces. This means that no group knows the
exact location of the members of the other group, only the general
area they are in. Through this example, we are trying to explore
"group-based access control (GBAC) of shared variables".

example-10: This is like example-09 but we have three groups instead
of 2, to further demonstrate concepts in GBAC, e.g., how groups can
overlap.

Subdirectories:
--------------

example-05: The self-adaptation example with 5 nodes (node 0 is
leader, others are protectors) moving in formation from an initial
safe region through a hazardous region and into a safe end region. The
mission succeeds if the leader reaches the end point within a
specified mission time, and without getting exposed to some specified
hazard level. The nodes can switch formation (loose <--> tight) to
achieve different tradeoff points between speed and protection:

loose -> fast but low protection
tight -> slow but high protection

The leader executes an adaptation algorithm (implemented by creating
MDPs and solving them using PRISM to compute optimal strategies). All
nodes execute the synchronous collision avoidance algorithm.

example-05b: Same as example-05 but uses an adaptation manager based
on dynamic stochastic programming. This is newer work being done on
proactive self-adaptation.

example-06: TBD

example-07: Scenarios inspired by movable tiles that can attach to
each other via magnets and create structures. See
example-07/dmpl/README.txt for more details.

example-08: Exploring versions of the collision avoidance protocol
where nodes exchange and use timestamps to avoid collisions. This is
more aggressive than the conservative protocol (e.g., in example-01)
but makes assumptions about the maximum and minimum times needed by a
node to enter or leave a cell. These assumptions must be discharged
separately. Also, this protocol cannot be verified by software model
checking alone. The situation is similar to example-04, except that in
the case of example-4, the assumption was about "relative speeds" of
nodes. See example-08/dmpl/README.txt for more details.

bud: Scenarios being developed by Bud. See bud/README.txt for more
details.

safe-tugs: Scenarios based on safe tugs. See safe-tugs/README.txt for
more details.

