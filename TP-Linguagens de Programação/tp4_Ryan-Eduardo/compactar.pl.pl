contar(X,[Y|_],1) :- X\==Y.
contar(_,[],1).
contar(X,[X|L],C) :- contar(X,L,C1), C is C1+1.
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).
pular(_,[],[]).
pular(0,L,L).
pular(C,[_|L],L2) :- C2 is C-1, pular(C2,L,L2).
compactar([],[]).
compactar([X|L1],L2) :- contar(X,L1,C), C2 is C-1, pular(C2,L1,L3),
                        compactar(L3,L4), concatenar([[C,X]],L4,L2).
