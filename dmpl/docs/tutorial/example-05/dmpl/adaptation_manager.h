/**
 * Interface with the adaptation manager.
 */

//-- an empty adaptation manager stub. this will be ultimately
//-- replaced by Gabe's implementation.
int adaptation_manager
(
 int current_formation,
 int changing, //-- whether in process of changing to other formation
 double change_progress, //-- progress in changing to other formation
 //-- next 2 hazards
 double hazard1,
 double hazard2,    
 double hazard3,    
 double hazard4,    
 double hazard5,    
 //-- next 2 coverages
 double cover1,
 double cover2,
 double cover3,
 double cover4,
 double cover5,
 double loose_speed, //-- speed of loose formation
 double tight_speed, //-- speed of tight formation
 double loose_power, //-- power needed in loose formation
 double tight_power, //-- power needed in tight formation
 double energy //-- amount of energy left
)
{
}

/*********************************************************************/
//end of file
/*********************************************************************/
