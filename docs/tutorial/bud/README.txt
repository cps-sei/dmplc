Here we are exploring a series of scenarios of increasing complexity
as envisioned by Bud.

bud-example-01-3D: An example with 3 nodes moving in 3D. Each node
starts (and stays) at a height equal to its own id. This eliminates
collisions, without any collision avoidance protocol needed.

bud-example-02: Similar to bud-example-01-3D but nodes can start at
any height, but then do not change their heights, instead using the
collision avoidance protocol (generalized to 3D). we have also
verified the correctness of the 3D collision avoidance protocol
successfully.

bud-example-03: Similar to bud-example-02 but the functionality of
locking the next cell, and moving to the next cell has been split off
into separate threads. This means that locking and moving can happen
in parallel which leads to much faster movement.

bud-example-04: Similar to bud-example-02 but nodes change height as
needed to avoid collisions.

bud-example-05: Fives nodes moving in leader-follower formation along
a pre-determined plan. This is identical to example-02 in that nodes
do not change heights, but different in that states NEXT and REQUEST
have been merged, and states WAITING and MOVE have been merged.

bud-example-06: Same as bud-example-05, but use concurrent locking and
movement.

bud-example-07: Similar to bud-example-04 but nodes change height as
needed to avoid collisions, as well as a set of static obstacles with
known heights.

bud-example-08: Same as bud-example-03 but the path-planning is
"zig-zag" (i.e., try to keep the distance to the final location along
the X and Y axes as close to each other as possible) rather than
"right-down" (i.e., first get to the same X coordinate as the final
location, and then move to the final location).

bud-example-09: Same as bud-example-07 but the path-planning is
"zig-zag" (i.e., try to keep the distance to the final location along
the X and Y axes as close to each other as possible) rather than
"right-down" (i.e., first get to the same X coordinate as the final
location, and then move to the final location).

bud-example-10: Similar to bud-example-07 but the obstacle positions
are not known statically. They are computed at runtime by using a
sensor.

bud-example-11: Similar to bud-example-10 but the obstacle detection
is done by a separate asynchronous thread instead of being part of the
collision avoidance thread.

bud-example-12: Similar to bud-example-11 but some obstacles are
adversarial, indicated by their red color. All obstacles are still
static.
