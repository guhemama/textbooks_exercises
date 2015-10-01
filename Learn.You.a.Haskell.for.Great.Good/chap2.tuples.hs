-- Create a tuple
tuple = (1, 2, 'b')

-- Create a pair (also a tuple)
tPair = (1, 2)

-- Create a list of tuples
tList = [('a', 1), ('b', 2)]

-- Get the first component of a pair
tFirst = fst (3, 8) -- 3

-- Get the second component of a pair
tSecond = snd ("Wow", False) -- False

-- Produce a list of pairs from two lists
tZip = zip [1, 2, 3] [4, 5, 6] -- [(1,4),(2,5),(3,6)]