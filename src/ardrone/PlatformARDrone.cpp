#include <iostream>
#include <unistd.h>

#include "PlatformARDrone.hpp"

int main(int argc,char **argv)
{
  GRID_INIT();
  std::cout << "sleeping for X seconds ...\n";
  sleep(1);
  GRID_PLACE(0,0,0);
  GRID_TAKEOFF();
  for (int i = 0; i < 30; i++) {
    doOrient();
    sleep(1);
  }
  //sleep(30);
  GRID_LAND();
  sleep(1);
  GRID_REMOVE();
}
