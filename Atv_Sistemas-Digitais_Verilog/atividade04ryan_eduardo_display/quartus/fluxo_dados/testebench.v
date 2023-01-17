module testebench_decodificador();

	reg A, B, C, D;
	wire a,b,c,d,e,f,g;
	
	decodificador_fd dut (A, B, C, D, a,b,c,d,e,f,g);
	
	initial
		begin
			repeat(5)
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
			end
endmodule


					