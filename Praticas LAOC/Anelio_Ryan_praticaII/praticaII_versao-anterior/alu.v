module alu(reg_a, buswires, opcode, reg_alu);

	input [15:0] reg_a, buswires;
	input [1:0]opcode;
	output reg [15:0] reg_alu;

	always@(opcode) begin
		case(opcode)
			2'b00: reg_alu <= reg_a + buswires;
			2'b01: reg_alu <= reg_a - buswires;
			2'b10: reg_alu <= reg_a & buswires;
		endcase
	end
endmodule
