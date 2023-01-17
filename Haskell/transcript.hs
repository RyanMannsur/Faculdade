transcript :: [Char] -> [Char]
transcript [] = []
transcript (a:x) | (a == 'G') = "C"++transcript x
		| (a == 'C') = "G"++transcript x
		| (a == 'T') = "A"++transcript x
		| (a == 'A') = "U"++transcript x