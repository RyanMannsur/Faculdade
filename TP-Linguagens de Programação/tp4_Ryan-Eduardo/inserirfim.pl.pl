inserirfim(N,[],[N]).
inserirfim(N,[X|L],[X|XF]) :- inserirfim(N,L,XF).
