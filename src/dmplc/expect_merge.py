#!/usr/bin/python3

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

import csv
import sys
import contextlib as cl
import collections
from heapq import merge

csv_out = csv.writer(sys.stdout)

Datum = collections.namedtuple('Datum', ['time','node','name','val'])

types = {}

def data_iter(f):
    csv_in = csv.DictReader(f)
    for row in csv_in:
        if int(row['Node']) == int(row['At']):
            yield Datum(float(row['Seconds']) + float(row['Micros']) / 1000000.0,
                        int(row['Node']), row['Variable'], row['Value'])

data = None

Frame = collections.namedtuple('Frame', ['min_time','max_time','data'])

frames = []

period = float(sys.argv[1])

with cl.ExitStack() as stack:
    files = [ stack.enter_context(open(s, newline='')) for s in sys.argv[2:] ]
    data = merge(*[data_iter(f) for f in files])
    latest = None
    keys_seen = set()
    for datum in data:
        key = (datum.node, datum.name)
        if latest is not None and not key in keys_seen and datum.time >= latest.min_time and datum.time < latest.max_time:
            latest.data.append(datum)
            keys_seen.add(key)
        else:
            latest = Frame(datum.time, datum.time + period, [datum])
            keys_seen = set(key)
            frames.append(latest)

csv_out.writerow(['Frame','Time','Node','Variable','Value']);
for i, frame in enumerate(frames):
    for datum in frame.data:
        csv_out.writerow([i] + list(datum))
