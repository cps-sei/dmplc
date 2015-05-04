#!/bin/bash

dmplc -s -n 2 -r 10 example-05.dmpl example-05.sched.dmpl -o example-05.c --DX 5 --DY 5

cbmc example-05.c
