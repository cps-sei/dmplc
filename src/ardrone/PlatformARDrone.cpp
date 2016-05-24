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
  sleep(5);

  //while(!DRONE_DETECT_TAG(CAD_TYPE_ORIENTED_COCARDE_BW)) sleep(1);

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
  
  while(!DRONE_FLYING_MODE(FLYING_MODE_FREE_FLIGHT)) sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(5);

  DRONE_MOVE_FWD();
  std::cout << "************ moving forward ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  DRONE_MOVE_BWD();
  std::cout << "************ moving backward ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  DRONE_MOVE_RIGHT();
  std::cout << "************ moving right ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  DRONE_MOVE_LEFT();
  std::cout << "************ moving left ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  DRONE_MOVE_UP();
  std::cout << "************ moving up ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  DRONE_MOVE_DOWN();
  std::cout << "************ moving down ...\n";
  sleep(1);

  while(!DRONE_HOVER()) sleep(1);
  std::cout << "hovering ...\n";
  sleep(1);

  sleep(5);

  // while(!DRONE_FLYING_MODE(FLYING_MODE_HOVER_ON_TOP_OF_ORIENTED_ROUNDEL)) sleep(1);

  while(!DRONE_FLYING_MODE(FLYING_MODE_FREE_FLIGHT)) sleep(1);

  for(;;) {
    std::cout << "trying to land ...\n";
    int x = DRONE_LAND();
    if(x == -1) throw std::runtime_error("ERROR: could not land!!");
    if(x == 1) break;
    sleep(1);
  }

  GRID_REMOVE();
}
