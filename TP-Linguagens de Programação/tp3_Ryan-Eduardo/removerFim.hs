removerFim :: Int -> [Int] -> [Int]
removerFim 0 x = x
removerFim n [] = []
removerFim n x = removerFim (n-1) (removerUltimo x)

removerUltimo :: [Int] -> [Int]
removerUltimo [] = []
removerUltimo [n] = []
removerUltimo (a:x) = [a] ++ removerUltimo x