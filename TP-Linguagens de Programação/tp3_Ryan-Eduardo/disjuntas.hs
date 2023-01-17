disjuntas :: [Int] -> [Int] -> Bool
disjuntas [] [] = True
disjuntas [] x = True
disjuntas x [] = True
disjuntas (a:x) y | (existe a (x++y) /= True) = disjuntas x y
		  | (existe a (x++y) == True) = False

existe :: Int -> [Int] -> Bool
existe n [] = False
existe n (a:x) | (a /= n) = existe n x
	      | otherwise = True 