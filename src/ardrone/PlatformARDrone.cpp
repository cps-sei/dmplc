#include <iostream>
#include <unistd.h>

#include "PlatformARDrone.hpp"

int main(int argc,char **argv)
{
  GRID_INIT();
  std::cout << "sleeping for 5 seconds ...\n";
  sleep(3);
  GRID_PLACE(0,0,0);
  GRID_TAKEOFF();
  sleep(10);
  GRID_LAND();
  sleep(3);
  GRID_REMOVE();
}
