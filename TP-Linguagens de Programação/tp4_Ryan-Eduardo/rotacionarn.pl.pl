primeiro([],0).
primeiro([X|[]],X).
primeiro([X|_], X).
removerPri([_|[]],[]).
removerPri([_|L],L).
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).


rotacionarn(_,[],[]).
rotacionarn(0,L,L).
rotacionarn(N,L1,L2) :- primeiro(L1,P), removerPri(L1,L3), concatenar(L3,[P],LM),
                        N2 is N-1, rotacionarn(N2,LM,L2).
