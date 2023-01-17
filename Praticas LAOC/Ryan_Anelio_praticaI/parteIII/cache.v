module cache(clock, clk, address, wren, hit, valido, LRU, dirty, data, q);

	input clock, wren, clk;  //clock grava os dados. clk é ligado para ler o endereco em 2 ciclos. Wren define a escrita
	output reg hit, valido, LRU, dirty;
	input [4:0]address; //endereco recebido
	input [2:0] data; //data é o valor dado para escrever, e memr é o valor lido da memoria.
	output reg [2:0] q; //q é a saida e memw é o que grava na memoria que usarei futuramente.

	/*Memoria
		[2:0] q.
		[5:3] tag.
		  6   dirty
		  7   LRU
		  8   Valido
	*/	
	
	reg [8:0] memoria [7:0]; //Tamanho 8, com 9 bits cada.
	reg [2:0] memw; //valor que escrevo na memoria principal
	wire [2:0] memr; //valor lido da memoria principal
	reg wback; //ativo quando ocorrer write back
	reg [4:0] endereco; //endereco usado na memoria principal
	
	initial begin
		$readmemb("C:/Users/ryane/OneDrive/Documentos/quartus/teste3/teste2/mem_file.mem", memoria); //inicializo a L1
		wback <= 1'b0;	
   end
	
	integer index; //usado na cache
	
	
	//Ler ou escreve na memoria
	ramlpm mem_principal(
	endereco[4:0],
	clock,
	memw,
	wback,
	memr);
	
	always @(posedge clock) begin
		
		index = address[1:0] << 1; //deslocando para pegar de 2 em 2
		
		if(clk) begin //se ta ligado a leitura de endereco
			endereco[4] <= 1'b0;
			endereco [3:0] <= address[3:0];
			wback <= 1'b0;
		end
		
		else
		if(wren) begin
			if(memoria[index][8] && (address[4:2] == memoria[index][5:3])) begin //hit na escrita 1ª via
				hit <= 1'b1;
				
				endereco [1:0] <= address[1:0];
				endereco [3:2] <=  memoria[index][4:3]; //endereco de escrita
				
				//LRU
				memoria[index][7] <= 1'b1;
				LRU <= 1'b1;
				memoria[index+1][7] <= 1'b0;
				
				//valido
				memoria[index][8] <= 1'b1;
				valido <= 1'b1;
				
				//dirty
				if(memoria[index][6]) begin//se o dirty ja for 1
					memw <= memoria[index][2:0]; //esccreve na memoria principal
					wback <= 1'b1;
				end
				else
					wback <= 1'b0;
				
				memoria[index][6] <= 1'b1;
				dirty <= 1'b1;
				
				memoria[index][2:0] = data; //escreve na L1
				q <= memoria[index][2:0]; //le da L1
				
			end
			
			//hit na escrita 2ª via
			else if(memoria[index+1][8] && (address[4:2] == memoria[index+1][5:3])) begin
				hit <= 1'b1;
				
				endereco [1:0] <= address[1:0];
				endereco [3:2] <=  memoria[index+1][4:3];
				
				//LRU
				memoria[index+1][7] <= 1'b1;
				LRU <= 1'b1;
				memoria[index][7] <= 1'b0;
				
				//valido
				memoria[index+1][8] <= 1'b1;
				valido <= 1'b1;
				
				//dirty
				if(memoria[index+1][6]) begin//se o dirty ja for 1
					memw <= memoria[index+1][2:0]; //escreve na memoria principal
					wback <= 1'b1;
				end
				else
					wback <= 1'b0;
					
				memoria[index+1][6] <= 1'b1;
				dirty <= 1'b1; 
				
				memoria[index+1][2:0] = data; //escreve na L1
				q <= memoria[index+1][2:0]; //le da L1
			end
			
			else // se a tag não bater
					if(~(memoria[index][7])) begin //se LRU da 1ª via for 0
						hit <= 1'b0;
							
						endereco [1:0] <= address[1:0];
						endereco [3:2] <=  memoria[index][4:3]; //endereco de escrita
					
						//LRU
						memoria[index][7] <= 1'b1;
						LRU <= 1'b1;
						memoria[index+1][7] <= 1'b0;
					
						//valido
						memoria[index][8] <= 1'b1;
						valido <= 1'b1;
					
						//dirty
						if(memoria[index][6]) begin//se o dirty ja for 1
							memw <= memoria[index][2:0]; //esccreve na memoria principal
							wback <= 1'b1;	
						end
						else
							wback <= 1'b0;
						
						memoria[index][6] <= 1'b1;
						dirty <= 1'b1; //escreve na L1
							
						memoria[index][2:0] = data;
						memoria[index][5:3] <= address[4:2];
						q <= memoria[index][2:0]; //le da L1
					end
						
						else if(~(memoria[index+1][7])) begin //se LRU da 2ª via for 0
							hit <= 1'b0;
							
							endereco [1:0] <= address[1:0];
							endereco [3:2] <=  memoria[index+1][4:3];
							
							//LRU
							memoria[index+1][7] <= 1'b1;
							LRU <= 1'b1;
							memoria[index][7] <= 1'b0;
							
							//valido
							memoria[index+1][8] <= 1'b1;
							valido <= 1'b1;
							
							//dirty
							if(memoria[index+1][6]) begin//se o dirty ja for 1
								memw <= memoria[index+1][2:0]; //escreve na memoria principal
								wback <= 1'b1;
							end
							else
								wback <= 1'b0;
								
							memoria[index+1][6] <= 1'b1;
							dirty <= 1'b1;
							
							memoria[index+1][2:0] = data; //escreve na L1
							memoria[index+1][5:3] <= address[4:2];
							q <= memoria[index+1][2:0]; //le da L1
						end
				end
				//Leitura
				else if(~(wren)) begin
					if(memoria[index][8] && (address[4:2] == memoria[index][5:3])) begin //hit na leitura 1ª via
						hit <= 1'b1;
						
						q <= memoria[index][2:0]; //le da L1
						
						//LRU
						memoria[index][7] <= 1'b1;
						LRU <= 1'b1;
						memoria[index+1][7] <= 1'b0;
						
						//valido
						memoria[index][8] <= 1'b1;
						valido <= 1'b1;
						memoria[index][5:3] <= address[4:2];
				end
					else if(memoria[index+1][8] && (address[4:2] == memoria[index+1][5:3])) begin //hit na leitura 2ª via
							hit <= 1'b1;
							
							q <= memoria[index+1][2:0]; //le da L1
							
							//LRU
							memoria[index+1][7] <= 1'b1;
							LRU <= 1'b1;
							memoria[index][7] <= 1'b0;
							
							//valido
							memoria[index+1][8] <= 1'b1;
							valido <= 1'b1;
							memoria[index+1][5:3] <= address[4:2];
				end 
				 // se a tag não bater
					else if(~(memoria[index][7])) begin //se LRU da 1ª via for 0
							hit <= 1'b0;
							
							endereco [1:0] <= address[1:0];
							endereco [3:2] <=  memoria[index][4:3];
				
							//LRU
							memoria[index][7] <= 1'b1;
							LRU <= 1'b1;
							memoria[index+1][7] <= 1'b0;
							
							//valido
							memoria[index][8] <= 1'b1;
							valido <= 1'b1;
							
							//busca na memoria
							q <=  memr;
							
							//dirty
							if(memoria[index][6]) begin//se o dirty ja for 1
								memw <= memoria[index][2:0]; //escreve na memoria principal
								wback <= 1'b1;
							end
							else
								wback <= 1'b0;
								
							memoria[index][6] <= 1'b0;
							dirty <= 1'b0; //escreve na L1
							
							memoria[index][2:0] <= memr; //escrevo a posição em L1
							memoria[index][5:3] <= address[4:2];
						end
						else if(~(memoria[index+1][7])) begin //se LRU da 2ª via for 0
							hit <= 1'b0;
							
							endereco [1:0] <= address[1:0];
							endereco [3:2] <=  memoria[index+1][4:3];
				
							//LRU
							memoria[index+1][7] <= 1'b1;
							LRU <= 1'b1;
							memoria[index][7] <= 1'b0;
							
							//valido
							memoria[index+1][8] <= 1'b1;
							valido <= 1'b1;
							
							//busca na memoria
							q <=  memr;
							
							//dirty
							if(memoria[index+1][6]) begin//se o dirty ja for 1
								memw <= memoria[index+1][2:0]; //escreve na memoria principal
								wback <= 1'b1;
							end
							else
								wback <= 1'b0;
								
							memoria[index+1][6] <= 1'b0;
							dirty <= 1'b0; //escreve na L1
							
							memoria[index+1][2:0] <= memr; //escrevo em L1
							memoria[index+1][5:3] <= address[4:2];
				end
		end
	end
	
endmodule

