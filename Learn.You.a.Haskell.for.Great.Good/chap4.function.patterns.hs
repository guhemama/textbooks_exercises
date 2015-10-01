-- Recursive factorial
-- Constraint: input and output are Integrals
factorial :: (Integral a) => a -> a
factorial 0 = 1
factorial n = n * factorial (n - 1)

-- First element of a triple
first :: (a, b, c) -> a
first (x, _, _) = x

-- Second element of a triple
second :: (a, b, c) -> b
second (_, y, _) = y

-- Third element of a triple
third :: (a, b, c) -> c
third (_, _, z) = z

-- Get the head of a list
head' :: [a] -> a
head' [] = error "Can't call head on an empty list, dummy! lol"
head' (x:_) = x -- uses the alternate list syntax x:y:z:[]

-- Tells some of the first list elements in english form
tell :: (Show a) => [a] -> String
tell [] = "The list is empty"
-- alternative: tell [x]
tell (x:[]) = "The list has one element: " ++ show x
-- alternative: tell [x,y]
tell (x:y:[]) = "The list has two elements: " ++ show x ++ " and " ++ show y
tell (x:y:_) = "This list is long. The first two elements are: " ++ show x ++ " and " ++ show y

-- Recursive length function
length' :: (Num b) => [a] -> b
length' [] = 0
length' (_:xs) = 1 + length' xs

-- Sum of a list
sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs) = x + sum' xs