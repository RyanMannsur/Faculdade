module comparador4bit(A,B,igual,maior,menor);

	input wire [3:0]A;
	input wire [3:0]B;
	output igual, maior, menor;
	wire [3:0]aux_igual;
	wire [3:0]aux_maior;
	wire [3:0]aux_menor;
	
	comparador1bit bloco1(1,A[3],B[3],aux_maior[0],aux_menor[0],aux_igual[0]);
	comparador1bit bloco2(aux_igual[0],A[2],B[2],aux_maior[1],aux_menor[1],aux_igual[1]);
	comparador1bit bloco3(aux_igual[1],A[1],B[1],aux_maior[2],aux_menor[2],aux_igual[2]);
	comparador1bit bloco4(aux_igual[2],A[3],B[3],aux_maior[3],aux_menor[3],aux_igual[3]);
	
	assign igual = aux_igual[3];
	assign maior = |aux_maior;
	assign menor = |aux_menor;
	
endmodule
