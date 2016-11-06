-- Functions can take functions as parameters and also return functions.
-- This function takes a function and then applies it twice to something!
-- The parenthesis in the signature indicates it's a function.
applyTwice :: (a -> a) -> a -> a
applyTwice f x = f (f x)

-- zipWith takes a function and two lists as parameters and then joins the two lists
-- by applying the function between corresponding elements.
--   ghci> zipWith' (+) [4,2,5,6] [2,6,2,3]
--   [6,8,7,9]
zipWith' :: (a -> b -> c) -> [a] -> [b] -> [c]
zipWith' _ [] _ = []
zipWith' _ _ [] = []
zipWith' f (x:xs) (y:ys) = f x y : zipWith' f xs ys

-- map takes a function and a list and applies that function to every element in
-- the list, producing a new list.
map' :: (a -> b) -> [a] -> [b]
map' _ [] = []
map' f (x:xs) = f x : map' f xs

-- filter is a function that takes a predicate (a predicate is a function that
-- tells whether something is true or not, so in our case, a function that
-- returns a boolean value) and a list and then returns the list of elements
-- that satisfy the predicate.
filter' :: (a -> Bool) -> [a] -> [a]
filter' _ [] = []
filter' p (x:xs)
    | p x       = x : filter' p xs
    | otherwise = filter p xs

-- Find the largest number under 100,000 that's divisible by 3829
largestDivisible :: (Integral a) => a
largestDivisible = head (filter p [100000,99999..])
    where p x = x `mod` 3829 == 0