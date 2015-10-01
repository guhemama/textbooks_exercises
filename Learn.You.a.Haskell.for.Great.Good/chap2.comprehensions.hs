-- Create a set comprehension
cDouble = [x * 2 | x <- [1..10]]

-- Add a condition to the set
cCondition = [x * 2 | x <- [1..10], x * 2 >= 12]

-- Take the 10 first squares
cSquares = take 10 [x * x | x <- [1..]]

-- Function that says BOOM! on odd numbers smaller than 10, and BANG! otherwise
boomBangs xs = [if x < 10 then "BOOM!" else "BANG!" | x <- xs, odd x]

-- Custom length function, replaces all values for 1 and sums them
length' xs = sum [1| _ <- xs]