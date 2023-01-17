view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue 0 -period 50ps -dutycycle 50 -starttime 0ps -endtime 1500ps sim:/contador_9/clock 
wave create -driver freeze -pattern clock -initialvalue HiZ -period 554ps -dutycycle 95 -starttime 0ps -endtime 1500ps sim:/contador_9/reset 
wave modify -driver freeze -pattern clock -initialvalue 1 -period 554ps -dutycycle 93 -starttime 0ps -endtime 1500ps Edit:/contador_9/reset 
wave modify -driver freeze -pattern clock -initialvalue St1 -period 554ps -dutycycle 97 -starttime 0ps -endtime 1500ps Edit:/contador_9/reset 
wave create -driver freeze -pattern clock -initialvalue 1 -period 603ps -dutycycle 97 -starttime 0ps -endtime 1500ps sim:/contador_9/preset 
WaveCollapseAll -1
wave clipboard restore
