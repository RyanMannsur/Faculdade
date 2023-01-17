module somador_1bit(A, B, Te, S, Ts);

	input A, B, Te;
	output S, Ts;
	assign S = A ^ B ^ Te;
	assign Ts = (A & B) | (A & Te) | (B & Te);
	
endmodule