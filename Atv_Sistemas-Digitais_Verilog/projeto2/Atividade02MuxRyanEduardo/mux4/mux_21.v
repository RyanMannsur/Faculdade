module mux_21(I0,I1,sel,saida);

	input I0,I1,sel;
	output saida;
	assign saida = (~sel & I0) | (sel & I1);
	
endmodule
