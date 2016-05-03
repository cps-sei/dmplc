#include <iostream>
#include <unistd.h>
#include <stdexcept>

#include "PlatformARDrone.hpp"

int main(int argc,char **argv)
{
  GRID_INIT();

  if(argc == 2 && !strcmp(argv[1],"--reset")) {
    DRONE_RESET();
    return 0;
  }
  
  GRID_PLACE(0,0,0);
  
  for(;;) {
    int x = DRONE_TAKEOFF();
    if(x == -1) throw std::runtime_error("ERROR: could not take off!!");
    if(x == 1) break;
  }

  for(;;) {
    int x = DRONE_ORIENT();
    if(x == -1) throw std::runtime_error("ERROR: could not orient!!");
    if(x == 1) break;
  }

  sleep(15);

  for(;;) {
    int x = DRONE_LAND();
    if(x == -1) throw std::runtime_error("ERROR: could not land!!");
    if(x == 1) break;
  }

  GRID_REMOVE();
}
