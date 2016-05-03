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
    std::cout << "trying to take off ...\n";
    int x = DRONE_TAKEOFF();
    if(x == -1) throw std::runtime_error("ERROR: could not take off!!");
    if(x == 1) break;
    sleep(1);
  }
  
  for(;;) {
    std::cout << "trying to fly ...\n";
    int x = DRONE_FLYING();
    if(x == -1) throw std::runtime_error("ERROR: could not fly!!");
    if(x == 1) break;
    sleep(1);
  }

  for(;;) {
    std::cout << "trying to orient ...\n";
    int x = DRONE_ORIENT();
    if(x == -1) throw std::runtime_error("ERROR: could not orient!!");
    if(x == 1) break;
    sleep(1);
  }

  std::cout << "hovering ...\n";
  sleep(5);

  for(;;) {
    std::cout << "trying to land ...\n";
    int x = DRONE_LAND();
    if(x == -1) throw std::runtime_error("ERROR: could not land!!");
    if(x == 1) break;
    sleep(1);
  }

  GRID_REMOVE();
}
