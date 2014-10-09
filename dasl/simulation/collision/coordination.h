/*********************************************************************
 * coordination.h - An interface defining functions to coordinate
 * throught distributed locks.
 *********************************************************************/

typedef unsigned char crdtype;

void setup_kb(int id, int numberOfAgents, int numberOfRows, int numberOfCols);

void lock_node(crdtype x,crdtype y);

void lock_edge(crdtype from_x, crdtype from_y, crdtype to_x, crdtype to_y);

void release_node(crdtype x,crdtype y);

void release_edge(crdtype from_x, crdtype from_y, crdtype to_x, crdtype to_y);

void moveTo(int x, int y);

void showGrid(int numRows, int numCols);


