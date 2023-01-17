nelementos([],0).
nelementos([_|[]],1).
nelementos([_|L],Y) :- nelementos(L,Z), Y is Z+1.
