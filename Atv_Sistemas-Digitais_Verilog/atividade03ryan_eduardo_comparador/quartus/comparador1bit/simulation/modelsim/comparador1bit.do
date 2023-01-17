onerror {resume}
quietly WaveActivateNextPane {} 0
add wave -noupdate -radix binary /comparador1bit/enable
add wave -noupdate -radix binary /comparador1bit/A
add wave -noupdate -radix binary /comparador1bit/B
add wave -noupdate -radix binary /comparador1bit/igual
add wave -noupdate -radix binary /comparador1bit/maior
add wave -noupdate -radix binary /comparador1bit/menor
TreeUpdate [SetDefaultTree]
WaveRestoreCursors {{Cursor 1} {0 ps} 0}
quietly wave cursor active 1
configure wave -namecolwidth 150
configure wave -valuecolwidth 100
configure wave -justifyvalue left
configure wave -signalnamewidth 0
configure wave -snapdistance 10
configure wave -datasetprefix 0
configure wave -rowmargin 4
configure wave -childrowmargin 2
configure wave -gridoffset 0
configure wave -gridperiod 1
configure wave -griddelta 40
configure wave -timeline 0
configure wave -timelineunits ns
update
WaveRestoreZoom {0 ps} {1 ns}
view wave 
wave clipboard store
wave create -driver freeze -pattern clock -initialvalue HiZ -period 1000ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/comparador1bit/enable 
wave create -driver freeze -pattern clock -initialvalue HiZ -period 780ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/comparador1bit/A 
wave create -driver freeze -pattern clock -initialvalue HiZ -period 550ps -dutycycle 50 -starttime 0ps -endtime 1000ps sim:/comparador1bit/B 
wave modify -driver freeze -pattern clock -initialvalue HiZ -period 1000ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/comparador1bit/enable 
wave modify -driver freeze -pattern clock -initialvalue HiZ -period 730ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/comparador1bit/A 
wave modify -driver freeze -pattern clock -initialvalue HiZ -period 400ps -dutycycle 50 -starttime 0ps -endtime 1000ps Edit:/comparador1bit/B 
WaveCollapseAll -1
wave clipboard restore
