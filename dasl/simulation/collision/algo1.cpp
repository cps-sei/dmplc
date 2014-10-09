#include "madara/knowledge_engine/Knowledge_Base.h"

#include <stdlib.h>
#include "coordination.h"
#include "assert.h"
#include <stdio.h>
#include <string.h>

#ifndef WIN32
    #include <pthread.h>
#endif

/* Grid size */
#define NUM_ROWS 3
#define NUM_COLS 3

/** Gridlocked course. */
int init1[2] = {0,1};
int dest1[2] = {0,2};
int init2[2] = {0,2};
int dest2[2] = {0,1};

/** Nonlocked course. 
int init1[2] = {0,0};
int dest1[2] = {0,2};
int init2[2] = {1,0};
int dest2[2] = {1,2};*/


//#define init_x1 0
//#define init_y1 1
//#define init_x2 0
//#define init_y2 2

//#define dest_x1 0
//#define dest_y1 2
//#define dest_x2 0
//#define dest_y2 0

crdtype drone1_x = 0;
crdtype drone1_y = 0;
crdtype drone2_x = 0;
crdtype drone2_y = 0;

void* drone1(void* arg)
{
    crdtype curr_x = drone1_x, curr_y = drone1_y;
    crdtype next_x = 0,next_y = 0;
    crdtype i = 0;

    moveTo(-1, -1);
    lock_node (curr_x, curr_y);
    moveTo(curr_x, curr_y);
    showGrid(NUM_ROWS, NUM_COLS);
    //return NULL;

    for(i = 0;i < 2;++i) 
    {
        // Define our next position, and get a lock for it.
        next_x = curr_x;
        next_y = curr_y + 1;
        //lock_edge (curr_x, curr_y, next_x, next_y);
        lock_node (next_x, next_y);

        // Asynchronous semantics, return only guarantees that agent is off x, y (not at next_x, next_y)
        // move_edge (drone1_x, drone1_y, next_x, next_y);  

        // "Move" and release the resources, checking that we have not collided.
        drone1_x = next_x;
        drone1_y = next_y;
        assert(drone1_x != drone2_x || drone1_y != drone2_y);
        release_node (curr_x, curr_y);
        //release_edge (curr_x, curr_y, next_x, next_y);

        // Update our current location.
        curr_x = next_x;
        curr_y = next_y;
        moveTo(curr_x, next_y);

        showGrid(NUM_ROWS, NUM_COLS);
    }
    return NULL;
}

void* drone2(void* arg)
{
    crdtype curr_x = drone2_x, curr_y = drone2_y;
    crdtype next_x = 0,next_y = 0;
    crdtype i = 0;

    moveTo(-1, -1);
    lock_node (curr_x, curr_y);
    moveTo(curr_x, curr_y);
    showGrid(NUM_ROWS, NUM_COLS);
    //return NULL;

    for(i = 0;i < 2;++i) 
    {
        // Define our next position, and get a lock for it.
        next_x = curr_x;
        next_y = curr_y - 1;
        //lock_edge (curr_x, curr_y, next_x, next_y);
        lock_node (next_x, next_y);

        // Asynchronous semantics, return only guarantees that agent is off x, y (not at next_x, next_y).
        //move_edge (drone2_x, drone2_y, next_x, next_y);

        // "Move" and release the resources.
        drone2_x = next_x;
        drone2_y = next_y;
        assert(drone1_x != drone2_x || drone1_y != drone2_y);
        release_node (curr_x, curr_y);
        //release_edge (curr_x, curr_y, next_x, next_y);

        // Update our current location.
        curr_x = next_x;
        curr_y = next_y;
        moveTo(curr_x, next_y);

        showGrid(NUM_ROWS, NUM_COLS);
    }
    return NULL;
}

int main(int argc, char** argv)
{
    int id;

    id = 0;
    if(argc > 1)
    {
        id = atoi(argv[1]);
    }

    int numDrones = 2;
    int numRows = 3;
    int numCols = 3;
    setup_kb(id, numDrones, numRows, numCols);

    drone1_x = init1[0];
    drone1_y = init1[1];
    drone2_x = init2[0];
    drone2_y = init2[1];

    //pthread_t t1,t2;
    //pthread_create(&t1,NULL,drone1,NULL);
    //pthread_create(&t2,NULL,drone2,NULL);

    if(id == 0)
    {
        drone1(NULL);
    }
    if(id == 1)
    {
        drone2(NULL);
    }

    return 0;
}
