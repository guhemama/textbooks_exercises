maximum' :: (Ord a) => [a] -> a
maximum' []  = error "Maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
  | x > maxTail = x
  | otherwise   = maxTail
  where maxTail = maximum' xs

maximum'' :: (Ord a) => [a] -> a
maximum'' []  = error "Maximum of empty list"
maximum'' [x] = x
maximum'' (x:xs) = max x (maximum'' xs)


-- Creates a list of things that have an ordering (Ord)
replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
    | n <= 0    = []
    | otherwise = x:replicate' (n-1) x

-- It takes in account two edge conditions: taking 0 elements and taking
-- elements from an empty list
take' :: (Num i, Ord i) => i -> [a] -> [a]
take' n _
    | n <= 0   = []
take' _ []     = []
take' n (x:xs) = x : take' (n-1) xs

-- Zip takes two lists and zips them together. It has two edge conditions
-- because it takes two lists as parameters
zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y) : zip' xs ys

-- Checks if a list contains an element.
-- If the head is empty, the list does not contain the element.
-- If the head does not match the element, keep seaching for it on the tail, recursively.
elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
    | a == x    = True
    | otherwise = a `elem'` xs

-- Quicksort - pretty concise!
quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    let smallerSorted = quicksort [a | a <- xs, a <= x]
        biggerSorted = quicksort [a | a <- xs, a > x]
    in  smallerSorted ++ [x] ++ biggerSorted