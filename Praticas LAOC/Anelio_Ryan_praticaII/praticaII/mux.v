module mux(r0,r1,r2,r3,r4,r5,r6,r7,rx,ry,reg_ir,g, select, buswires);

	input [3:0] select;
	input [2:0] rx,ry;
	input [15:0] r0,r1,r2,r3,r4,r5,r6,r7,reg_ir,g;
	output reg[15:0] buswires;
	
	always@(select)begin
		case(select)
			4'b0000: buswires <= reg_ir;
			4'b0001: buswires <= r0;
			4'b0010: buswires <= r1;
			4'b0011: buswires <= r2;
			4'b0100: buswires <= r3;
			4'b0101: buswires <= r4;
			4'b0110: buswires <= r5;
			4'b0111: buswires <= r6;
			4'b1000: buswires <= r7;
			4'b1001: buswires <= g;
			//4'b1010: buswires <= din;
			4'b1011: 
				case(rx)
					3'b000: buswires <= r0;
					3'b001: buswires <= r1;
					3'b010: buswires <= r2;
					3'b011: buswires <= r3;
					3'b100: buswires <= r4;
					3'b101: buswires <= r5;
					3'b110: buswires <= r6;
				endcase
			4'b1100:
				case(ry)
					3'b000: buswires <= r0;
					3'b001: buswires <= r1;
					3'b010: buswires <= r2;
					3'b011: buswires <= r3;
					3'b100: buswires <= r4;
					3'b101: buswires <= r5;
					3'b110: buswires <= r6;
				endcase
		endcase
	end

endmodule

	