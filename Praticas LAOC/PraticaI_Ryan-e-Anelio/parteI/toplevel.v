module toplevel(SW,KEY,LEDR,LEDG,HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7);
	
 input [17:0]SW;
 output reg [17:0]LEDR;
 output reg [7:0]LEDG;
 input [3:0]KEY;
 output [0:6] HEX0, HEX1, HEX2, HEX3, HEX4, HEX5, HEX6, HEX7;
 wire [7:0]q;
 
 integer i;
 
 always @(SW or KEY)
 begin
	for(i=0;i<12;i = i+1)
		begin
			if(SW[i])
				LEDR[i] <= 1'b1;
		end
		case(KEY)
			4'b0001: LEDG[0] <= 1'b1;
			default: LEDG[0] <= 1'b0;
		 endcase;
 end	
 
	ramlpm ram(
	SW[12:8],//address,
	SW[17],//clock,
	SW[7:0],//data,
	SW[16],//wren,
	q);//q
	
	//Mostrando dados de entrada
	decodificador_c h_address(SW[12],HEX7[0:6]);
	decodificador_c h2_address(SW[11:8],HEX6[0:6]);
	decodificador_c h_data(SW[7:4],HEX5[0:6]);
	decodificador_c h2_data(SW[3:0],HEX4[0:6]);
	
	//Mostrando saida
	decodificador_c h_q(q[7:4],HEX1[0:6]);
	decodificador_c h2_q(q[3:0],HEX0[0:6]);
	
	
	endmodule
