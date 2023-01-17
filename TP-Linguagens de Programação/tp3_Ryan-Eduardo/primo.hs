primo :: Int -> Bool
primo 0 = False
primo 1 = True
primo 2 = True
primo n | (primeiroDivisor n 2 /= n)  = False
primo n | (primeiroDivisor n 2 == n)  = True

primeiroDivisor:: Int -> Int -> Int
primeiroDivisor n m | (m==n) = n
primeiroDivisor n m | (n`mod`m == 0) = m
primeiroDivisor n m | (n`mod`m /= 0) = primeiroDivisor n (m+1)