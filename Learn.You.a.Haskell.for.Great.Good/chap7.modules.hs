import Data.List (nub, sort)
import Data.Array hiding (sort)

-- Count unique items
numUniques :: (Eq a) => [a] -> Int
numUniques = length . nub -- \xs -> length (nub xs)

