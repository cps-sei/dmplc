#include <iostream>
#include <unistd.h>

#include "PlatformARDrone.hpp"

int main(int argc,char **argv)
{
  GRID_INIT();
  std::cout << "sleeping for 5 seconds ...\n";
  sleep(5);
  GRID_REMOVE();
}
