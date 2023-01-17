module addr(buswires, addr_in, reg_addr); //busca posição de memoria
	input [15:0] buswires;
	input addr_in;
	output reg [7:0] reg_addr;
	
	always@(addr_in)begin
		if(addr_in)
			reg_addr <= buswires[7:0];
	end
endmodule
