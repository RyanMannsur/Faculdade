module test_bench;

/* Primeiro clk entro com address, segundo CLK entro com wren e data, e então faço o clock normal*/ 


	reg clock, wren, clk; 
	wire hit, valido, LRU, dirty;
	reg [4:0]address;
	reg [2:0] data;
	wire [2:0] q; //q é a saida e mem é o que grava na memoria que usarei futuramente.

	/*Memoria
		[2:0] q.
		[5:3] tag.
		  6   dirty
		  7   LRU
		  8   Valido
	*/	
	
	initial begin
		clock = 1'b0;
		clk = 1'b1;
		wren = 1'b0;
		address = 5'b10000;
		data = 3'b101;
		//memr = 3'b111;
	end
	
	initial begin
		#25 clock = ~clock;//1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk; //0
		#25 clock = ~clock; //1
		
		#25 clock = ~clock; clk = ~clk; address = 5'b00001; //0
		#25 clock = ~clock;//1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk; //0
		#25 clock = ~clock; //1
		
		#25 clock = ~clock; clk = ~clk; //0
		#25 clock = ~clock;//1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk; wren = 1'b1; //0
		#25 clock = ~clock; //1
		
		#25 clock = ~clock; clk = ~clk; address = 5'b01001; data = 3'b100; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk; //0
		#25 clock = ~clock;//1
		
		#25 clock = ~clock; clk = ~clk; wren = 1'b0; address = 5'b00101;//0
		#25 clock = ~clock; //1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk;  //memr = 3'b011; //0
		#25 clock = ~clock; //1	
		
		#25 clock = ~clock; clk = ~clk; wren = 1'b1; address = 5'b01101; data = 3'b001;//0
		#25 clock = ~clock; //1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk;  //0
		#25 clock = ~clock; //1
		
		#25 clock = ~clock; clk = ~clk; wren = 1'b0; address = 5'b00001;//0
		#25 clock = ~clock; //1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk;  //0
		#25 clock = ~clock; //1
		
		#25 clock = ~clock; clk = ~clk; address = 5'b01001; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; //0
		#25 clock = ~clock; //1
		#25 clock = ~clock; clk = ~clk; //memr = 3'b011; //0
		#25 clock = ~clock; //1
		
		#50 ;
		
	end
	
		cache dut(clock, clk, address, wren, hit, valido, LRU, dirty, data, q);



endmodule
