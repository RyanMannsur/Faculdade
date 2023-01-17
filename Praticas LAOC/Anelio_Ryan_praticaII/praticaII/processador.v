module processador(run,resetn, clock, done,r0,r1,r2,r3);
	wire [15:0] din;
	output [15:0]r0,r1,r2,r3;
	reg [15:0] din_i, din_d;
	input clock;
	output done;
	wire [1:0] bope;
	
	//wire [8:0] reg_ir;
	wire [15:0]reg_ir, reg_addr, reg_a, g_reg, dout_reg,reg_alu,r0,r1,r2,r3,r4,r5,r6, r7,buswires;
	wire [3:0]select;
	wire [2:0] reg_rx, reg_ry;
	input run, resetn;
	wire done, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
			r7_in, pc_inc, pc_in, a_in, g_in, addr_in, dout_in, wren, btrue,mvt;
	wire [2:0]ula;
	
	reg [15:0] address;
	reg in_ir;
	wire [15:0] din_ir;
	
	initial begin
		in_ir <= 1'b1;
		address <= 16'b0000000000000000 - 16'b0000000000000001;
	end
	
	romlpm MEM_INSTRUCAO(address[4:0], clock, din_ir);
	
	ramlpm MEM_DADOS(reg_addr, clock, dout_reg, wren, r6);
					
	ir IR(din_ir,in_ir, clock, reg_ir, reg_rx, reg_ry);
	
	fsm Control_FSM(clock,din_ir,btrue ,run, resetn, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
						r7_in, pc_inc, pc_in, select, a_in, g_in, addr_in, dout_in, ula, bope, mvt, wren, done);
	
	mux MUX(r0,r1,r2,r3,r4,r5,r6,address,reg_rx,reg_ry, reg_ir,g_reg, select, buswires);
	
	dout DOUT(buswires, dout_in, dout_reg);
	
	addr ADDR(buswires, addr_in, reg_addr);
	
	a A(clock, buswires,a_in,reg_a);
	
	g G(clock, reg_alu, g_in, g_reg);
	
	alu ALU(reg_a, buswires, ula, reg_alu);
	
	counter COUNTER_R7(address[4:0], pc_inc, pc_in, buswires, r7);
	
	b B(bope,reg_alu, btrue);
	
	registrador R0(buswires, clock, mvt, r0_in, r0);
	registrador R1(buswires, clock, mvt, r1_in, r1);
	registrador R2(buswires, clock, mvt, r2_in, r2);
	registrador R3(buswires, clock, mvt, r3_in, r3);
	registrador R4(buswires, clock, mvt, r4_in, r4);
	registrador R5(buswires, clock, mvt, r5_in, r5);
	//registrador R6(buswires, clock, r6_in, r6);
	
	always@(r7 or ir_in or resetn) begin
		if(resetn) begin //se done tiver aceso, primeiro apaga e dps da done.
			address <= 16'b0000000000000000 - 16'b0000000000000001;
		end
		address <= r7;
		in_ir <= ir_in;
	end
	
endmodule
