-- Use case expressions to pattern match parameters
head' :: [a] -> a
head' xs = case xs of [] -> error "Empty lists have no head!"
                      (x:_) -> x

-- Describe the type of a list
describeList :: [a] -> String
describeList xs = "The list is " ++ case xs of []  -> "empty."
                                               [x] -> "a singleton list."
                                               xs  -> "a longer list."