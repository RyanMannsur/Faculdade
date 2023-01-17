somaParciais :: [Int] -> [Int]
somaParciais [] = []
somaParciais (a:x) = [a] ++ somaParciais [b | b <- soma a x]

soma :: Int -> [Int] -> [Int]
soma n [] = []
soma n (a:x) = [n+a] ++ x