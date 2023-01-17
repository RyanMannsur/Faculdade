somaImpares :: [Int] -> Int
somaImpares [] = 0
somaImpares (a:x) | (a `mod` 2 == 0 ) = somaImpares x
somaImpares (a:x) = a+somaImpares x