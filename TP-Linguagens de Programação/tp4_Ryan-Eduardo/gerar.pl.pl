gerar(X,X,[X]).
gerar(X,Y,[X|L]) :- Z is X+1, gerar(Z,Y,L).
