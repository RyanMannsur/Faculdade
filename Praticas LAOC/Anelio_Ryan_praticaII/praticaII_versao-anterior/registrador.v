module registrador(buswires, clock, r_in, data_r);

	input [15:0] buswires;
	input clock, r_in;
	output reg [15:0] data_r;
	
	always@(posedge clock) begin
		if(r_in)
			data_r <= buswires;
	end
endmodule
