linearizar(L1,L2,L3,L4,L) :- concatenar(L1,L2,LF1), concatenar(L3,L4,LF2),
                             concatenar(LF1,LF2,L).
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).

