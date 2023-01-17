module contador_4bit(clock,reset,preset,Q);
	
	input reset,preset,clock;
	output reg [3:0]Q;
	
	initial
	begin
		Q = 4'b0000;
	end
		
		always @ (negedge clock or negedge reset or negedge preset)
			begin
				if(reset == 1'b0)
				begin
					Q = 4'b0000;
				 end
					
				else if(preset == 1'b0)
				begin
					Q = 4'b1111;
				 end
					
				else
				 begin
					Q = Q + 1;
				  end
			end
endmodule
