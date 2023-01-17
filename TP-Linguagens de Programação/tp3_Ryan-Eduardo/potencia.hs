potencia :: Int -> Int -> Int
potencia 0 p = 0
potencia n 0 = 1
potencia n p = n*potencia n (p-1) 