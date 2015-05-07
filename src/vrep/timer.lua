state = simGetSimulationState()
if did_init == nil then
  mission_duration = 0.0 + simGetStringParameter(sim_stringparam_app_arg1)
  log_name = simGetStringParameter(sim_stringparam_app_arg2)
  log_file = io.open(log_name,"w")
  log_file:write("STARTED\n")
  log_file:flush()
  did_init = true
end
if state == sim_simulation_advancing_running then
  if logged_running == nil then
    log_file:write("RUNNING\n")
    log_file:flush()
    logged_running = true
  end
  sim_time = simGetSimulationTime()
  time_left = mission_duration - sim_time
  simAddStatusbarMessage(time_left)
  if time_left <= 0 then
    log_file:write("COMPLETE\n")
    log_file:close()
    simStopSimulation()
  end
end
