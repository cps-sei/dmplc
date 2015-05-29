/**
 * Copyright (c) 2015 Carnegie Mellon University. All Rights Reserved.

 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:

 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following acknowledgments
 * and disclaimers.

 * 2. Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution.

 * 3. The names "Carnegie Mellon University," "SEI" and/or "Software
 * Engineering Institute" shall not be used to endorse or promote
 * products derived from this software without prior written
 * permission. For written permission, please contact
 * permission@sei.cmu.edu.

 * 4. Products derived from this software may not be called "SEI" nor
 * may "SEI" appear in their names without prior written permission of
 * permission@sei.cmu.edu.

 * 5. Redistributions of any form whatsoever must retain the following
 * acknowledgment:

 * This material is based upon work funded and supported by the
 * Department of Defense under Contract No. FA8721-05-C-0003 with
 * Carnegie Mellon University for the operation of the Software
 * Engineering Institute, a federally funded research and development
 * center.

 * Any opinions, findings and conclusions or recommendations expressed
 * in this material are those of the author(s) and do not necessarily
 * reflect the views of the United States Department of Defense.

 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE
 * ENGINEERING INSTITUTE MATERIAL IS FURNISHED ON AN "AS-IS"
 * BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND,
 * EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT
 * LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE
 * MELLON UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH
 * RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT
 * INFRINGEMENT.

 * This material has been approved for public release and unlimited
 * distribution.

 * DM-0002494
**/

#include <stdlib.h>
#include <unistd.h>
#include <iostream>
#include "madara/utility/Utility.h"

#include "DmplVrep.hpp"

int main(int argc,char **argv)
{
  if(argc == 1) {
    std::cout << "ERROR: Usage: " << argv[0] << " port-number\n";
    return 1;
  }
  
  simxInt port = atoi(argv[1]);

  std::cout << "opening connection to VREP\n";
  QuadriRotor the_dv(10,10);
  DmplVrep &dv = the_dv;

  if(dv.connect((simxChar*)"127.0.0.1",port) == -1) {
    std::cerr << "ERROR: could not connect to VREP ...\n";
    return 1;
  }
  std::cout << "connected to VREP successfully ...\n";
  std::cout << "scene has " << dv.getNumObjects() << " objects\n";

  std::cout << "ping time is " << dv.getPingTime() << " ms\n";

  Madara::Utility::sleep(2);

  if(port == 19900) {
    simxInt node1 = dv.createNode();
    std::cout << "created robot 1\n";
    std::cout << "scene now has " << dv.getNumObjects() << " objects\n";
    dv.placeNodeAt(node1,0,0,1);

    //dv.startSim(); sleep(5); dv.pauseSim(); sleep(5);
    //dv.startSim(); sleep(5); dv.stopSim();

    dv.startSim();
    while(dv.moveNodeTo(node1,0,10,1));
    while(dv.moveNodeTo(node1,10,10,1));
    while(dv.moveNodeTo(node1,10,0,1));
    while(dv.moveNodeTo(node1,0,0,1));

    dv.stopSim();
    dv.destroyNode(node1);
  } else {
    simxInt node1 = dv.createNode();
    std::cout << "created robot 1\n";
    std::cout << "scene now has " << dv.getNumObjects() << " objects\n";
    dv.placeNodeAt(node1,10,10,1);

    //dv.destroyNode(node1);
  }

  dv.disconnect();
  return 0;
}
