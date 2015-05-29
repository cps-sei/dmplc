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

/**
 * Interface with the adaptation manager.
 */

#include <stdlib.h>

//-- an default adaptation manager stub. this will be ultimately
//-- replaced by Gabe's implementation. right now, it randomly returns
//-- 0 or 1 with equal probability.
int adaptation_manager_random
(
 int current_formation, //-- 0 loose, 1 tight
 int changing, //-- whether in process of changing to other formation
 double change_progress, //-- progress in changing to other formation (remaining time)
 //-- next n hazards (for the next n segments in the path)
 double hazard1,
 double hazard2,
 double hazard3,
 double hazard4,
 double hazard5,
 //-- variance of the next n hazards predictions
 double variance1,
 double variance2,
 double variance3,
 double variance4,
 double variance5,
 double loose_speed, //-- speed of loose formation
 double tight_speed, //-- speed of tight formation
 double segment_length, //-- length of a segment in the path
 int remaining_segments, //-- number of segments remaining in the path
 double remaining_flight_time //-- how much flight time the formation has left
)
{
  if(!changing && (random() % 4 == 0)) return 1 - current_formation;
  else return current_formation;
}

/*********************************************************************/
//end of file
/*********************************************************************/
