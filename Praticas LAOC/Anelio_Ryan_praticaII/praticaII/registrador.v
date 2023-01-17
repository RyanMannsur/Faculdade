module registrador(buswires, clock, mvt, r_in, data_r);

	input [15:0] buswires;
	input clock, mvt, r_in;
	output reg [15:0] data_r;
	
	always@(posedge clock) begin
		if(r_in) begin
			if(mvt) begin
				data_r[15:8] <= buswires[7:0];
				data_r[7:0] <= 8'b00000000;				
			end
			else begin
				data_r <= buswires;
			end
		end
	end
endmodule
