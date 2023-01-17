module g(clock, alu_reg, g_in, g_reg);
	input clock, g_in;
	input [15:0] alu_reg;
	output reg [15:0] g_reg;
	
	always@(posedge clock) begin
		if(g_in)
			g_reg <= alu_reg;
	end

endmodule
	