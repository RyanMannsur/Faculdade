substituir :: Int -> Int -> [Int] -> [Int]
substituir n s [] = []
substituir n s (a:x) | (a /= n) = a : substituir n s x
substituir n s (a:x) = s : substituir n s x