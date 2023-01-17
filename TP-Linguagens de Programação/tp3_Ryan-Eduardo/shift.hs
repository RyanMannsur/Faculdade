shift :: Int -> [Int] -> [Int]
shift 0 x = x
shift n [] = []
shift n (a:x) = shift (n-1) (x ++ [a])