module a(clock, buswires,a_in,reg_a);

	input [15:0] buswires;
	input a_in, clock;
	output reg [15:0] reg_a;
	
	always@(posedge clock) begin
		if(a_in)
			reg_a <= buswires;
	end
	
endmodule
