palindromo :: [Int] -> Bool
palindromo [] = True
palindromo [n] = True
palindromo x = compara x [a|a<-inverte x]


compara :: [Int] -> [Int] -> Bool
compara [] [] = True
compara [] n = False
compara n [] = False
compara (a:x) (b:y) | (a == b) = compara x y
		    | otherwise = False

inverte :: [Int] -> [Int]
inverte [] = []
inverte [n] = [n]
inverte (a:x) = inverte x ++ [a]