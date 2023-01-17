distintos :: [Int] -> Bool
distintos [] = True
distintos [n] = True
distintos (a:x) | (existe a x /= True) = distintos x
		| (existe a x /= False) = False 

existe :: Int -> [Int] -> Bool
existe n [] = False
existe n (a:x) | (a /= n) = existe n x
	      | otherwise = True