module dout(buswires, dout_in, dout_reg); //retorna o valor que guardarei na memoria
	input [15:0] buswires;
	input dout_in;
	output reg [15:0]dout_reg;
	
	always@(dout_in)begin
		if(dout_in)
			dout_reg[15:0] <= buswires;
	end
endmodule
