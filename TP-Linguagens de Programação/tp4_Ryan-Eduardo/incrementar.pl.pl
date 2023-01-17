incrementar([],[]).
incrementar([X|L],LI) :- Y is X+1, incrementar(L,L2), concatenar([Y],L2,LI).
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).
