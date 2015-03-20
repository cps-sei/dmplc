#!/usr/bin/python3

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
