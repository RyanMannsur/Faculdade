/*module testbench;

	reg clock,reset,preset;
	wire [3:0]Q;
	
	parameter stop_timer 1000;
	
	contador_4bit dut(clock,reset,preset,Q);
	
	initial # stop_timer;
	
	initial
		begin
			repeat(2)
				clock*/