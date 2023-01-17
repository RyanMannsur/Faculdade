module mux_41(I0,I1,I2,I3,selA,selB,saida);

	input I0,I1,I2,I3;
	input selA,selB;
	
	output saida;
	
	wire [2:0]aux_saida;
	
	mux_21 bloco1(I0,I1,selA,aux_saida[0]);
	mux_21 bloco2(I2,I3,selA,aux_saida[1]);
	mux_21 bloco3(aux_saida[0],aux_saida[1],selB,aux_saida[2]);
	
	assign saida = aux_saida[2];
	
endmodule
