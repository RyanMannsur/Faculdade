concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).



ordenar([],[]).
ordenar([X|[]], [X]).
ordenar([X,Y|L1],[X|L2]) :- X<Y, concatenar([Y],L1,LM), ordenar(LM,L2).
ordenar([X,Y|L1], L2) :- X>=Y, concatenar([Y],[X],LM), concatenar(LM,L1,LM2),
                         ordenar(LM2,LM3),ordenar(LM3,L2) .

