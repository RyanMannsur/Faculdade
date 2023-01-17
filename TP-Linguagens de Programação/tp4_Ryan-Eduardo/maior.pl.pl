maior([],0).
maior([X|[]],X).
maior([X|L],M) :- maior(L,Y), X>=Y, M is X.
maior([X|L],M) :- maior(L,Y), X<Y, M is Y.
