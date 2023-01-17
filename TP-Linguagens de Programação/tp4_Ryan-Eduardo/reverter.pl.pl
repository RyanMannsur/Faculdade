reverter([],[]).
reverter([X|XF],L) :-  reverter(XF,L2), concatenar(L2,[X],L).
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).
