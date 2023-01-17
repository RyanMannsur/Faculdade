conta([],0).
conta([_|[]],1).
conta([_|L],C) :- conta(L,Z), C is Z+1.
somaElem([X|[]],X).
somaElem([X|L],Y) :- somaElem(L,Z), Y is Z+X.
medio([],0.0).
medio([X|[]],X).
medio(X,M) :-  somaElem(X,S), conta(X,C), M is S/C.
