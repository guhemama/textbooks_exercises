-- Creates a new function with one arg
doubleMe x = x + x

doubleUs x y = doubleMe x + doubleMe y

-- The if clause is an expression, and will return a value
-- The else clause is mandatory
doubleSmallNumber x = if x > 100
                        then x
                        else x * 2