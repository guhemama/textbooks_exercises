-- To make a lambda, we write a \ and then we write the parameters, separated by spaces.
-- After that comes a -> and then the function body. We usually surround them by parentheses,
-- because otherwise they extend all the way to the right.
filter (\x -> x > 15) [1..100]