#include <iostream>
#include <unistd.h>

#include "PlatformARDrone.hpp"

int main(int argc,char **argv)
{
  GRID_INIT();
  GRID_PLACE(0,0,0);
  GRID_TAKEOFF();
  sleep(15);
  GRID_LAND();
  GRID_REMOVE();
}
