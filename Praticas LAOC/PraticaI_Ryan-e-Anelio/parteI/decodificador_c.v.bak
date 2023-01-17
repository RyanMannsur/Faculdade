module decodificador_c(A,B,C,D,S);

	input A,B,C,D;
	output [7:0]S;
	reg [7:0]S;

	
	always@(*)
		begin 
			case({A,B,C,D})
				4'b0000: S = 7'b1111110;
				4'b0001: S = 7'b0110000;
				4'b0010: S = 7'b1101101;
				4'b0011: S = 7'b1111001;
				4'b0100: S = 7'b0110011;
				4'b0101: S = 7'b1011011;
				4'b0110: S = 7'b1011111;
				4'b0111: S = 7'b1110000;
				4'b1000: S = 7'b1111111;
				4'b1001: S = 7'b1111011;
				
				default: S = 7'b0000000;
			endcase
		end
endmodule
