module alu(reg_a, buswires, opcode, reg_alu);

	input [15:0] reg_a, buswires;
	input [2:0]opcode;
	output reg [15:0] reg_alu;

	always@(opcode, buswires) begin
		case(opcode)
			4'b000: reg_alu <= reg_a + buswires;
			4'b001: reg_alu <= reg_a - buswires;
			4'b010: reg_alu <= reg_a & buswires;
			4'b011: reg_alu <= reg_a << buswires;
			4'b100: reg_alu <= reg_a >> buswires;
		endcase
	end
endmodule
