-- Returns the middle element of a three elements tuple
-- We don't know/care about the elements type, therefore we use a type variable
tupleMiddle :: (a, b, c) -> b
tupleMiddle (x, y, z) = y