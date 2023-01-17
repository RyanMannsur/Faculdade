module test_bench;

		
	reg run, restn, clock;
	wire [15:0]r0,r1,r2,r3;
	wire done;
	
	
	
	initial begin
		clock = 1'b0;
		run = 1'b1;
		
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		#25 clock = ~clock;
		#25 clock = ~clock; //1
		
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		#25 clock = ~clock;
		#25 clock = ~clock;//1
		
		
	end
	
	processador dut(run,resetn, clock, done,r0,r1,r2,r3);

endmodule
