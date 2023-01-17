module b(opecode,reg_alu, btrue);

	input [1:0] opecode;
	input [15:0] reg_alu;
	output reg btrue;
	
	always@(opecode, reg_alu) begin
		case(opecode)
			2'b00:
				btrue <= 1'b1;
			2'b01: 
				if(reg_alu == 16'b0000000000000000)
					btrue <= 1'b1;
				else
					btrue <= 1'b0;
			2'b00:
				if(~(reg_alu == 16'b0000000000000000))
					btrue <= 1'b1;
				else
					btrue <= 1'b0;
			default: btrue <= 1'b0;
			endcase
		end
	endmodule
	