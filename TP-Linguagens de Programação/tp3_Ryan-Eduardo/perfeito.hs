perfeito :: Int -> Bool
perfeito 0 = False
perfeito 1 = True
perfeito n | (soma [i | i<-[1..n-1], n`mod`i == 0] == n) = True
	   | otherwise = False 

soma :: [Int] -> Int
soma [] = 0
soma (a:x) = a + soma x