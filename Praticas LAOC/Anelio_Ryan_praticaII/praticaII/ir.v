module ir(din,ir_in, clock, reg_ir, reg_rx, reg_ry); //ir_in run.
	
	input [15:0] din;
	input ir_in, clock;
	output reg [15:0] reg_ir;
	output reg [2:0] reg_rx, reg_ry;

	always@(posedge clock) begin
		if(ir_in)
			reg_ir <= din[7:0];
			reg_rx <= din[10:8];
			reg_ry <= din[2:0];
	end
	
endmodule
