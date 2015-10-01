-- Take a list of characters and return only the elements that are in uppercase
-- For each Char `c` in `str`, check if `c` belongs to the uppercase letters set
removeNonUppercase :: [Char] -> [Char]
removeNonUppercase str = [ c | c <- str, c `elem` ['A'..'Z']]

-- The last declaration is the return type
addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z
