module farol(F,C,P,S);
	output S;
	input F, C, P;
	reg S;
	
	always @(F,P,C)
		begin
			case({F,P,C})
				3'b100: S = 1;
				3'b101: S = 1;
				3'b110: S = 1;
				
				default: S = 0;
			endcase
	end
endmodule
		