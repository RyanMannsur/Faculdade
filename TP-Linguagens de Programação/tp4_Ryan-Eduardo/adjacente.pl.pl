adjacente(X,Y,[W,Z|[]]) :- false.
adjacente(X,Y,[X,Y|_]).
adjacente(X,Y,[_|L]) :-  adjacente(X,Y,L).
