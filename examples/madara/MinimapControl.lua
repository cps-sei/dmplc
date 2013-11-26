--####################################################################
--# Usage of this software requires acceptance of the SMASH-CMU License,
--# which can be found at the following URL:
--#
--# https://code.google.com/p/smash-cmu/wiki/License
--######################################################################

-- The button ids go from 3 to 102, a total of 100 squares. This gives a
-- resolution of 10x10 cells for the minimap, each cell roughly 1x1 meters.
MIN_CELL_ID = 3
MAX_CELL_ID = 102

MAP_HEIGHT_IN_CELLS = 10
MAP_WIDTH_IN_CELLS = 10

--/////////////////////////////////////////////////////////////////////////////////////////////
-- Method called when the simulation starts.
--/////////////////////////////////////////////////////////////////////////////////////////////
function doInitialSetup()   
    -- Get handles and parameters.
	g_minimpUIHandle = simGetUIHandle('minimapUI')
	g_numberOfDrones = simGetScriptSimulationParameter(sim_handle_main_script,'numberOfDrones')
    
    -- The map info.
    local x1 = simGetScriptSimulationParameter(sim_handle_main_script, 'x1')
    local y1 = simGetScriptSimulationParameter(sim_handle_main_script, 'y1')
    local x2 = simGetScriptSimulationParameter(sim_handle_main_script, 'x2')
    local y2 = simGetScriptSimulationParameter(sim_handle_main_script, 'y2') 
    g_mapWidthInMeters = x2 - x1
    g_mapHeightInMeters = y2 - y1
    
    g_mapOriginX = x2
    g_mapOriginY = y2

    -- Initialize variables to hold the list of cells with people found.
	g_foundCoords = {}
end

--/////////////////////////////////////////////////////////////////////////////////////////////
-- Method called in each step of the simulation.
--/////////////////////////////////////////////////////////////////////////////////////////////
function runMainLogic()   
    -- Clears up the map.
    for i=MIN_CELL_ID,MAX_CELL_ID,1 do
        -- Marks a cell as white.
        simSetUIButtonColor(g_minimpUIHandle, i, {1,1,1}, {1,1,1}, {1,1,1})
        local emptyString = ""
        simSetUIButtonLabel(g_minimpUIHandle, i, emptyString, emptyString)
    end

    -- Show the drones in the map.
    for i=1, g_numberOfDrones, 1 do
		-- Calculate the name of this person.
		quadricopterName = 'Quadricopter#'
		if(i~=1) then
			quadricopterName = quadricopterName .. (i-2)
		end	
        -- Get information about each drone.
        local droneHandle = simGetObjectHandle(quadricopterName)
        local dronePos = simGetObjectPosition(droneHandle, -1)

        -- Calculate the cell corresponding to where the drone currently is, and show it.
        local buttonnumber = positionToCell(dronePos)
        --simAddStatusbarMessage('Button: ' .. buttonnumber)
        if((buttonnumber >= MIN_CELL_ID) and (buttonnumber <= MAX_CELL_ID)) then
            simSetUIButtonColor(g_minimpUIHandle, buttonnumber, {0,0,0}, {0,0,0}, {1,1,1})
            
            -- Show the id of the drone in the map too.
            local droneId = "" .. i - 1
            simSetUIButtonLabel(g_minimpUIHandle, buttonnumber, droneId, droneId)
        end
    end
    
    -- Check if new people have been found.
    local personFoundName = simGetScriptSimulationParameter(sim_handle_main_script, 'personFoundName')
    if(personFoundName ~= "") then
        --simAddStatusbarMessage('New person found: ' .. personFoundName)
        personCoords = getPersonPositionInMeters(personFoundName)
        buttonnumber = positionToCell(personCoords)
		
        -- Store the new found person, if it is not already there.
        if((buttonnumber >= MIN_CELL_ID) and (buttonnumber <= MAX_CELL_ID)) then
            if(g_foundCoords[buttonnumber] == nil) then
                simAddStatusbarMessage('Adding new person to persons found list, in cell: ' .. buttonnumber)
                g_foundCoords[buttonnumber] = true
            end
        end
    end

    -- Marks the people found.
    for foundCell, found in pairs(g_foundCoords) do
        -- Mark as red.
        simSetUIButtonColor(g_minimpUIHandle, foundCell, {1,0,0}, {1,0,0}, {1,1,1})
    end
end

--/////////////////////////////////////////////////////////////////////////////////////////////
-- Returns the position of the source person found as a table with x,y,z.
--/////////////////////////////////////////////////////////////////////////////////////////////
function getPersonPositionInMeters(personFoundName)
	personHandle = simGetObjectHandle(personFoundName)
	local personPosition = simGetObjectPosition(personHandle, -1)
	return personPosition
end

--/////////////////////////////////////////////////////////////////////////////////////////////
-- Turns a cartesian position into a cell number.
--/////////////////////////////////////////////////////////////////////////////////////////////
function positionToCell(position)
    local column = math.floor((g_mapOriginX - position[1])*MAP_WIDTH_IN_CELLS/g_mapWidthInMeters)
    local line = math.floor((g_mapOriginY - position[2])*MAP_HEIGHT_IN_CELLS/g_mapHeightInMeters)
    --simAddStatusbarMessage('Column ' .. column .. ', line ' .. line)

    if(column < 0) then
        column = 0
    end
    if(column > MAP_WIDTH_IN_CELLS - 1) then
        column = MAP_WIDTH_IN_CELLS - 1
    end

    if(line < 0) then
        line = 0
    end
    if(line > MAP_HEIGHT_IN_CELLS - 1) then
        line = MAP_HEIGHT_IN_CELLS - 1
    end
    
    local cell = (line)*10 + column + MIN_CELL_ID
    return cell
    --return math.abs(math.floor(math.abs(math.floor(position[2]))*10 + (8-position[1])*1.25)) + MIN_CELL_ID
end

--/////////////////////////////////////////////////////////////////////////////////////////////
-- Method called when the simulation ends.
--/////////////////////////////////////////////////////////////////////////////////////////////
function doCleanup()
end
