module fsm(clock,ir, run, resetn, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
					r7_in, pc_inc, pc_in, select, a_in, g_in, addr_in, dout_in, ula, wren, done);
					
	input [15:0]ir;
	output reg[3:0]select;
	input run, resetn, clock;
	output reg done, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
			r7_in, pc_inc, pc_in, a_in, g_in, addr_in, dout_in, wren;
	output reg [1:0]ula;
	
	reg [2:0] Tstate;
	
	initial begin
		Tstate = 3'b000;
	end
	parameter T0 = 3'b000, T1 = 3'b001, T2 = 3'b010, T3 = 3'b011, T4 = 3'b100, T5 = 3'b101;		
	
	always@(posedge clock) begin
		wren <= 1'b0;
		if(done) begin
			ir_in <= 1'b0;
			r0_in <= 1'b0;
			r1_in <= 1'b0;
			r2_in <= 1'b0;
			r3_in <= 1'b0;
			r4_in <= 1'b0;
			r5_in <= 1'b0;
			r6_in <= 1'b0;
			r7_in <= 1'b0;
			pc_inc <= 1'b0;
			pc_in <= 1'b0;
			a_in <= 1'b0;
			g_in <= 1'b0;
			addr_in <= 1'b0;
			dout_in <= 1'b0;
			done <= 1'b0;
		end
		case(Tstate)
			T0: if(run) begin
					select <= 4'b1000; //select count
					addr_in <= 1'b1;
					pc_inc <= 1'b1;
					Tstate = T1;
					
				end
	
			T1: if(run) Tstate = T2;
			
			T2: if(run) begin
					ir_in <= 1'b1;
					Tstate = T3;
				end
			
			T3: if(run) begin
					case(ir[15:13])
						3'b000: begin//mv 
							if(~(ir[12])) begin
								select <= 4'b1100; //escolho ry 000 0 010 00000 0000
								done <= 1'b1;
							end
							else begin
								select <= 4'b0000; //escolho ir
								done <= 1'b1;
							end
							done <= 1'b1;
							case (ir[11:9]) //escrevo em rx
								3'b000: r0_in <= 1'b1;
								3'b001: r1_in <= 1'b1;
								3'b010: r2_in <= 1'b1;
								3'b011: r3_in <= 1'b1;
								3'b100: r4_in <= 1'b1;
								3'b101: r5_in <= 1'b1;
								3'b110: r6_in <= 1'b1;
							endcase
						end
						3'b001: begin//mvt
							select <= 4'b0000; //escolho ir
							done <= 1'b1;
							case (ir[11:9]) //escrevo em rx
									3'b000: r0_in <= 1'b1;
									3'b001: r1_in <= 1'b1;
									3'b010: r2_in <= 1'b1;
									3'b011: r3_in <= 1'b1;
									3'b100: r4_in <= 1'b1;
									3'b101: r5_in <= 1'b1;
									3'b110: r6_in <= 1'b1;
							endcase
							end
							3'b010: begin//add
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							3'b011: begin//sub
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							3'b100: begin//and
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							3'b101: begin//ld
								select <= 4'b1100; //escolho ry
								addr_in <= 1'b1;
								end
							3'b110: begin //st
								select <= 4'b1100; //escolho ry
								addr_in <= 1'b1;
								end
							endcase
							Tstate = T4;
						end
					T4: if(run) begin
							case(ir[15:13])
								3'b010: begin//add
									if(~(ir[12])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 2'b00; //soma
									end
								3'b011: begin//sub
									if(~(ir[12])) begin 
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 2'b01; //sub
									end
								3'b100: begin//and
									if(~(ir[12])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 2'b10; //add
									end
								3'b110: begin//st
									select <= 4'b1011; //escolho rx
									dout_in <= 1'b1;
									done <= 1'b1;
									wren <= 1'b1; //liga escrita na memoria
									end
								endcase
								Tstate = T5;
							end
						T5: if(run) begin
								Tstate = T0;
								case(ir[15:13])
								3'b010: begin//add
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[11:9]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
							3'b011: begin//sub
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[11:9]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
								3'b100: begin//and
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[11:9]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
								3'b101: begin//ld 
									select <= 4'b0111; //escolho r6
									done <= 1'b1;
									wren <= 1'b0; //desligo escrita na memoria
									case (ir[11:9]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
								endcase
							end
						endcase
					end
		endmodule
	