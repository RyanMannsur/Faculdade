module testebench_c();

	reg A, B, C, D;
	wire [7:0]S;
	
	decodificador_c dut (A, B, C, D, S);
	
	initial
		begin
					A = 0; B = 0; C = 0; D = 0; #50
					A = 0; B = 0; C = 0; D = 1; #50
					A = 0; B = 0; C = 1; D = 0; #50
					A = 0; B = 0; C = 1; D = 1; #50
					A = 0; B = 1; C = 0; D = 0; #50
					A = 0; B = 1; C = 0; D = 1; #50
					A = 0; B = 1; C = 1; D = 0; #50
					A = 0; B = 1; C = 1; D = 1; #50
					
					A = 1; B = 0; C = 0; D = 0; #50
					A = 1; B = 0; C = 0; D = 1; #50
					A = 1; B = 0; C = 1; D = 0; #50
					A = 1; B = 0; C = 1; D = 1; #50
					A = 1; B = 1; C = 0; D = 0; #50
					A = 1; B = 1; C = 0; D = 1; #50
					A = 1; B = 1; C = 1; D = 0; #50
					A = 1; B = 1; C = 1; D = 1; #50;
			end
endmodule
