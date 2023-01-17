ultimo([],0).
ultimo([X|[]],X).
ultimo([_|L], Y) :- ultimo(L,Y).
