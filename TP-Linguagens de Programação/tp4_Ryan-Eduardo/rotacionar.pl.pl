primeiro([],0).
primeiro([X|[]],X).
primeiro([X|_], X).
removerPri([_|[]],[]).
removerPri([_|L],L).
concatenar([],L,L).
concatenar([X|L1],L2,[X|L3]) :- concatenar(L1,L2,L3).


rotacionar([],[]).
rotacionar(L1,L2) :- primeiro(L1,N), removerPri(L1,L3), concatenar(L3,[N],L2) .
