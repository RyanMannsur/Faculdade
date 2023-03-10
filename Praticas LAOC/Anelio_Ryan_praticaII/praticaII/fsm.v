module fsm(clock,ir,btrue ,run, resetn, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
					r7_in, pc_inc, pc_in, select, a_in, g_in, addr_in, dout_in, ula, bope, mvt, wren, done);
					
	input [15:0]ir;
	output reg[3:0]select;
	input run, resetn, clock, btrue;
	output reg done, ir_in, r0_in, r1_in, r2_in, r3_in, r4_in, r5_in, r6_in,
			r7_in, pc_inc, pc_in, a_in, g_in, addr_in, dout_in,mvt, wren;
	output reg [1:0] bope;
	output reg [2:0]ula;
	
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
			pc_inc <= 1'b1;
			pc_in <= 1'b0;
			a_in <= 1'b0;
			g_in <= 1'b0;
			addr_in <= 1'b0;
			dout_in <= 1'b0;
			done <= 1'b0;
			bope <= 1'b00;
			mvt <= 1'b0;
			ula <= 3'b000;
			select <= 4'b0000;
			Tstate <= T0;
		end
		if(resetn) begin
			done <= 1'b1;
			Tstate <= T0;
		end
		else
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
					case (ir[15:12])
						4'b0111: bope <= 2'b00;
						4'b1000: bope <= 2'b01;
						4'b1001: bope <= 2'b10;
					endcase
				end
			
			T3: if(run) begin
					case(ir[15:12])
						4'b000: begin//mv 
							if(~(ir[11])) begin
								select <= 4'b1100; //escolho ry 0000 0 010 00000 000
								done <= 1'b1;
							end
							else begin
								select <= 4'b0000; //escolho ir
								done <= 1'b1;
							end
							done <= 1'b1;
							case (ir[10:8]) //escrevo em rx
								3'b000: r0_in <= 1'b1;
								3'b001: r1_in <= 1'b1;
								3'b010: r2_in <= 1'b1;
								3'b011: r3_in <= 1'b1;
								3'b100: r4_in <= 1'b1;
								3'b101: r5_in <= 1'b1;
								3'b110: r6_in <= 1'b1;
							endcase
						end
						4'b0001: begin//mvt
							select <= 4'b0000; //escolho ir
							mvt <= 1'b1;
							done <= 1'b1;
							case (ir[10:8]) //escrevo em rx
									3'b000: r0_in <= 1'b1;
									3'b001: r1_in <= 1'b1;
									3'b010: r2_in <= 1'b1;
									3'b011: r3_in <= 1'b1;
									3'b100: r4_in <= 1'b1;
									3'b101: r5_in <= 1'b1;
									3'b110: r6_in <= 1'b1;
							endcase
							end
							4'b0010: begin//add
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							4'b0011: begin//sub
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							4'b0100: begin//and
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							4'b0101: begin//ld
								select <= 4'b1100; //escolho ry
								addr_in <= 1'b1;
								end
							4'b0110: begin //st
								select <= 4'b1100; //escolho ry
								addr_in <= 1'b1;
								end
							4'b0111: begin //b label
								select <= 4'b1000;// select pc
								a_in <= 1'b1;
								if(~(btrue))
									done <= 1'b1;
							end
							4'b1000: begin // beq label
								select <= 4'b1000;// select pc
								a_in <= 1'b1;
								if(~(btrue))
									done <= 1'b1;
							end
							4'b1001: begin //bne label
								select <= 4'b1000;// select pc
								a_in <= 1'b1;
								if(~(btrue))
									done <= 1'b1;
							end
							4'b1010: begin//sll
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							4'b1011: begin//srl
								select <= 4'b1011; //escolho rx
								a_in <= 1'b1;
								end
							endcase
							Tstate = T4;
						end
					T4: if(run) begin
							case(ir[15:12])
								4'b0010: begin//add
									if(~(ir[11])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 4'b000; //soma
									end
								4'b0011: begin//sub
									if(~(ir[11])) begin 
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 4'b001; //sub
									end
								4'b0100: begin//and
									if(~(ir[11])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 4'b010; //add
									end
								4'b0110: begin//st
									select <= 4'b1011; //escolho rx
									dout_in <= 1'b1;
									done <= 1'b1;
									wren <= 1'b1; //liga escrita na memoria
									end
								4'b0111: begin //b
									select <= 4'b1000;
									g_in <= 1'b1;
								end
								4'b1000: begin //beq
									select <= 4'b1000;
									g_in <= 1'b1;
								end
								4'b1001: begin //bne
									select <= 4'b1000;
									g_in <= 1'b1;
								end
								4'b1010: begin//sll
									if(~(ir[11])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 4'b011; //sll
									end
								4'b1011: begin//srl
									if(~(ir[11])) begin
										select <= 4'b1100; //escolho ry
									end
									else
										select <= 4'b0000; //escolho ir
									g_in <= 1'b1;
									ula <= 4'b100; //srl
									end
								endcase
								Tstate = T5;
							end
						T5: if(run) begin
								Tstate = T0;
								case(ir[15:12])
								4'b0010: begin//add
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[10:8]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
							4'b0011: begin//sub
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[10:8]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
								4'b0100: begin//and
									select <= 4'b1001; //escolho g
									done <= 1'b1;
									case (ir[10:8]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
								4'b0101: begin//ld 
									select <= 4'b0111; //escolho r6
									done <= 1'b1;
									wren <= 1'b0; //desligo escrita na memoria
									case (ir[10:8]) //escrevo
										3'b000: r0_in <= 1'b1;
										3'b001: r1_in <= 1'b1;
										3'b010: r2_in <= 1'b1;
										3'b011: r3_in <= 1'b1;
										3'b100: r4_in <= 1'b1;
										3'b101: r5_in <= 1'b1;
										3'b110: r6_in <= 1'b1;
									endcase
									end
									4'b0111: begin //b
										select <= 4'b1001;
										pc_in <= 1'b1;
										done <= 1'b1;
									end
									4'b1000: begin //beq
										select <= 4'b1001;
										pc_in <= 1'b1;
										done <= 1'b1;
									end
									4'b1001: begin //bne
										select <= 4'b1001;
										pc_in <= 1'b1;
										done <= 1'b1;
									end
									4'b1010: begin //sll
										select <= 4'b1001; //escolho g
										done <= 1'b1;
										case (ir[10:8]) //escrevo
											3'b000: r0_in <= 1'b1;
											3'b001: r1_in <= 1'b1;
											3'b010: r2_in <= 1'b1;
											3'b011: r3_in <= 1'b1;
											3'b100: r4_in <= 1'b1;
											3'b101: r5_in <= 1'b1;
											3'b110: r6_in <= 1'b1;
										endcase
									end
									4'b1011: begin //srl
										select <= 4'b1001; //escolho g
										done <= 1'b1;
										case (ir[10:8]) //escrevo
											3'b000: r0_in <= 1'b1;
											3'b001: r1_in <= 1'b1;
											3'b010: r2_in <= 1'b1;
											3'b011: r3_in <= 1'b1;
											3'b100: r4_in <= 1'b1;
											3'b101: r5_in <= 1'b1;
											3'b110: r6_in <= 1'b1;
										endcase
										Tstate <= T0;
									end
								endcase
							end
						endcase
					end
		endmodule
	