/**
 * Interface with the adaptation manager.
 */

//-- an empty adaptation manager stub. this will be ultimately
//-- replaced by Gabe's implementation.
int adaptation_manager
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
}

/*********************************************************************/
//end of file
/*********************************************************************/
