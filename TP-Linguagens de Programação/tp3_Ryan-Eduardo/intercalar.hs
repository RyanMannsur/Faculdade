intercalar :: [Int] -> [Int] -> [Int]
intercalar [] [] = []
intercalar [] x = x
intercalar x [] = x
intercalar x y = sort (x++y)

sort :: [Int] -> [Int]
sort [] = []
sort (a:x) = sort ([b | b <- x, b<=a]) ++ [a] ++ sort ([c | c <- x, c>a])  