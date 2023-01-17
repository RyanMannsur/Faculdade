module somador_4bits(numero1, numero2, resultado);
	
	input [3:0]numero1, numero2;
	output [4:0]resultado;
	
	wire [3:0]S, Ts;
	
	somador_1bit somador1(numero1[0], numero2[0], 0, S[0], Ts[0]);
	somador_1bit somador2(numero1[1], numero2[1], Ts[0], S[1], Ts[1]);
	somador_1bit somador3(numero1[2], numero2[2], Ts[1], S[2], Ts[2]);
	somador_1bit somador4(numero1[3], numero2[3], Ts[2], S[3], Ts[3]);
	
	assign resultado = {Ts[3],S[3],S[2],S[1],S[0]};
	
endmodule
