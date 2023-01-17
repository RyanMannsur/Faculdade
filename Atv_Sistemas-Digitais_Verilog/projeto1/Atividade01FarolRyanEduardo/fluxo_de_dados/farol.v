module farol(F, C, P, S);
	
	input F, C, P;
	output S;
	
	assign S = (F & ~P) | (F & ~C);
	
endmodule
