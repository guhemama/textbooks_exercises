-- Make a list from 1 to 20
rBasic = [1..20]

-- Make a list from 2 to 20 with a step of 2
rStep = [2,4..20]

-- Make a reverse list from 20 to 1
rReverse = [20,19..1]

-- Cycles a list into an infinite one (lazy). It must be sliced
rCycleNumbers = take 10 (cycle [1, 2, 3]) -- [1,2,3,1,2,3,1,2,3,1]
rCycleChars = take 11 (cycle "LOL ") -- "LOL LOL LOL"

-- Produce an infinite list with only one element
rRepeat = take 8 (repeat 5) -- [5,5,5,5,5,5,5,5]

-- Creates a list of size N with a single element
rReplicate = replicate 8 5 -- [5,5,5,5,5,5,5,5]