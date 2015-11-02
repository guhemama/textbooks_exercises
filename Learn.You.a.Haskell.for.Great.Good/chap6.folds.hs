-- Sum implementation with foldl
sum' :: (Num a) => [a] -> a
sum' xs = foldl (\acc x -> acc + x) 0 xs

-- If we take into account that functions are curried, we can write this
-- implementation ever more succinctly (because of partial application)
sum'' :: (Num a) => [a] -> a
sum'' = foldl (+) 0