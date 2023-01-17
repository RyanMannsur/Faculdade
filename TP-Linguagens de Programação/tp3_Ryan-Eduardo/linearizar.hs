linearizar :: [[Int]] -> [Int]
linearizar [] = []
linearizar (a:x) = a ++ linearizar x