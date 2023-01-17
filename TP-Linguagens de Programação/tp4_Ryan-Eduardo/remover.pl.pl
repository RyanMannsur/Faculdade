remover(_,[],[]).
remover(X,[X|L],L2) :- remover(X,L,L2).
remover(X,[Y|L],[Y|L2]) :- X\==Y, remover(X,L,L2).
