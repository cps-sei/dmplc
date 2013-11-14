#include <pthread.h>

/** 3x3 grid */
#define init_x1 0
#define init_y1 1
#define init_x2 0
#define init_y2 2

#define dest_x1 2
#define dest_y1 1
#define dest_x2 2
#define dest_y2 2

typedef unsigned char crdtype;

crdtype x1 = 0,y1 = 0,x2 = 0,y2 = 0;

void lock_node(crdtype x,crdtype y)
{
}

void lock_edge(crdtype from_x, crdtype from_y, crdtype to_x,crdtype to_x)
{
}

void release_node(crdtype x,crdtype y)
{
}

void release_edge(crdtype from_x, crdtype from_y, crdtype to_x,crdtype to_x)
{
}

void *node1(void *arg)
{
  crdtype curr_x = x1,curr_y = y1;
  crdtype next_x = 0,next_y = 0;
  crdtype i = 0;

  for(i = 0;i < 2;++i) {
    next_x = curr_x + 1;
    next_y = curr_y;
    lock_edge (curr_x, curr_y, next_x, next_y);
    lock_node (next_x, next_y);
    // asynchronous semantics, return only gaurantees that agent is off x, y (not at next_x, next_y)
    //move_edge (x1, y1, next_x, next_y);  
    x1 = next_x;
    y1 = next_y;
    assert(x1 != x2 || y1 != y2);
    release_node (curr_x, curr_y);
    release_edge (curr_x, curr_y, next_x, next_y);
    curr_x = next_x;
    curr_y = next_y;
  }
  return NULL;
}

void *node2(void *arg)
{
  crdtype curr_x = x2,curr_y = y2;
  crdtype next_x = 0,next_y = 0;
  crdtype i = 0;

  for(i = 0;i < 2;++i) {
    next_x = curr_x + 1;
    next_y = curr_y;
    lock_edge (curr_x, curr_y, next_x, next_y);
    lock_node (next_x, next_y);
    // asynchronous semantics, return only gaurantees that agent is off x, y (not at next_x, next_y)
    //move_edge (x2, y2, next_x, next_y);  
    x2 = next_x;
    y2 = next_y;
    release_node (curr_x, curr_y);
    release_edge (curr_x, curr_y, next_x, next_y);
    curr_x = next_x;
    curr_y = next_y;
  }

  return NULL;
}

void main()
{
  x1 = init_x1;
  y1 = init_y1;
  lock_node (x1, y1);
  x2 = init_x2;
  y2 = init_y2;
  lock_node (x2, y2);

  pthread_t t1,t2;
  pthread_create(&t1,NULL,node1,NULL);
  pthread_create(&t2,NULL,node2,NULL);
}
