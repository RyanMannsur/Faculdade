hamming([],_,0).
hamming([X|L],[X|L2],N) :- hamming(L,L2,N).
hamming([X|L],[Y|L2],N) :- X\==Y, hamming(L,L2,N1), N is N1+1.
