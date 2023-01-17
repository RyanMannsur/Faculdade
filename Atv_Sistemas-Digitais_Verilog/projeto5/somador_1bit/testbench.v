module testbench();

	reg A, B, Te;
	wire Ts, S;
	
	somador_1bit dut (A, B, Te,S,Ts);
	
	initial
		begin
			repeat(2)
				begin
					A = 0; B = 0; Te = 0; #50
					A = 0; B = 0; Te = 1; #50
					A = 0; B = 1; Te = 0; #50
					A = 0; B = 1; Te = 1; #50
					A = 1; B = 0; Te = 0; #50
					A = 1; B = 0; Te = 1; #50
					A = 1; B = 1; Te = 0; #50
					A = 1; B = 1; Te = 1; #50;
				end
			end
endmodule
