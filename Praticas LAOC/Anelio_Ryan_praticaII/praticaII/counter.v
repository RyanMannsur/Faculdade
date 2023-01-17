module counter(address, pc_inc, pc_in, buswires, r7);
	input pc_inc, pc_in;
	input [15:0] buswires;
	input [4:0] address;
	output reg [15:0] r7;
	
	always@(pc_inc or pc_in) begin
		if(pc_inc) begin
			r7[4:0] <= address+1;
			r7[15:5] <= 11'b00000000000;
		end
		if(pc_in)
			r7 <= buswires;
	end

endmodule
