#!/bin/bash

dmplc -s -n 2 -r 10 example-06.dmpl example-06.sched.dmpl -o example-06.c --DX 5 --DY 5

cbmc example-06.c
