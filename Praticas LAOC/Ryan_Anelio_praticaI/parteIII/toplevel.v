module toplevel(SW,KEY,LEDR,LEDG,HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7);
	
 input [17:0]SW;
 output [17:0]LEDR;
 output [7:0]LEDG;
 input [3:0]KEY;
 output [0:6] HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7;
 wire [2:0]q;

 cache(KEY[0],//clock
		SW[17], //clk 
		SW[8:4],//address
		SW[16],//wren
		LEDR[10],//hit
		LEDR[11],//valido
		LEDR[12],//LRU
		LEDR[13],//dirty
		SW[2:0],//data
		q);
		
		
	//Mostrando dados de entrada endereço	
	decodificador_c h_address(SW[8],HEX7[0:6]);
	decodificador_c h2_address(SW[7:4],HEX6[0:6]);
	
	//Entrada do valor
	decodificador_c h_data(SW[2:0],HEX4[0:6]);
	decodificador_c h2_data(4'b0000,HEX5[0:6]);
	
	//Mostrando saida
	decodificador_c h_q(q[2:0],HEX0[0:6]);
	decodificador_c h2_q(4'b0000,HEX1[0:6]);
	
	assign LEDR[8:0] = SW[8:0];
	assign LEDR[17:16] = SW[17:16];
	
	assign LEDG[3:0] = KEY[3:0];
 
 
endmodule

