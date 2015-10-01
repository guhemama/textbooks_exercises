-- Defines a simple list
lostNumbers = [4, 8, 15, 16, 23, 42]

-- Strings are characters lists
helloList = ['h', 'e', 'l', 'l', 'o']

stringIsList = helloList == "hello" -- True

-- Append a list to another
newListAppend = [1, 2, 3, 4] ++ [5, 6, 7, 8]
-- [1, 2, 3, 4, 5, 6, 7, 8]

-- Prepend something to a list
newListPrepend = 'A' : " SMALL CAT"

-- Get the nth element of a list
nthElm = "Steve Buscemi" !! 6

-- Get the list head
lHead = head [1, 2, 3, 4] -- 1

-- Get the list tail (chop the head)
lTail = tail [1, 2, 3, 4] -- [2, 3, 4]

-- Get the last element of the list
lLast = last [1, 2, 3, 4] -- 4

-- Get everything except the last element
lInit = init [1, 2, 3, 4] -- [1, 2, 3]

-- Get the list length
lLength = length [1, 2, 3, 4, 5] -- 5

-- Check if a list is empty
lEmptyF = null [1, 2, 3] -- False
lEmptyT = null []        -- True

-- Reverse a list
lReverse = reverse [1, 2, 3] -- [3, 2, 1]

-- Take n elements from the beginning of the list
lTake = take 3 [5, 4, 3, 2, 1] -- [5, 4, 3]

-- Drops the first n elements of the list
lDrop = drop 3 [5, 4, 3, 2, 1] -- [2, 1]

-- Get the biggest element
lMax = maximum [1, 2, 3, 4, 5] -- 5

-- Get the smallest element
lMin = minimum [1, 2, 3, 4, 5] -- 1

-- Sum the elements
lSum = sum [1, 2, 3, 4] -- 10

-- Multiply the elements
lProd = product [1, 2, 3, 4] -- 24

-- Check if an element exists (uses infix notation)
lElem = 4 `elem` [3, 4, 5, 6] -- True