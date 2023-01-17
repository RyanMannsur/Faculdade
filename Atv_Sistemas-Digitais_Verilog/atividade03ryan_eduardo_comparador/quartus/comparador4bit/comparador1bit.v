module comparador1bit(enable,A,B,maior,menor,igual);

	input A,B,enable;
	output maior,menor,igual;
	assign maior = A & ~B & enable;
	assign menor = ~A & B & enable;
	assign igual = (~A & ~B & enable) | (A & B & enable);
	
endmodule
