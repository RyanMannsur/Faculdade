module decodificador_fd(A,B,C,D,a,b,c,d,e,f,g);

	input A, B, C, D;
	output a,b,c,d,e,f,g;
	
	assign a = (~A&~B&~D) | (~A&C) | (~A&B&D) | (A&~B&~C);
	assign b = (~A&~B) | (~A&~C&~D) | (~B&~C) | (~A&C&D);
	assign c = (~B&~C) | (~A&D) | (~A&B);
	assign d = (~B&~C&~D) | (~A&~B&C) | (~A&C&~D) | (~A&B&~C&D);
	assign e = (~B&~C&~D) | (~A&C&~D);
	assign f = (~A&~C&~D) | (~A&B&~C) | (~A&B&~D) | (A&~B&~C);
	assign g = (~A&~B&C) | (~A&B&~C) | (~A&B&~D) | (A&~B&~C);
	
endmodule
