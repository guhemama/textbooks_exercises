-- Gets your Body Mass Index and tells you off
bmiTell :: (RealFloat a) => a -> String
bmiTell bmi
  | bmi <  18.6 = "You're underweight."
  | bmi <= 25.0 = "You're normal."
  | bmi <= 30.0 = "You're fat."
  | otherwise = "You are very fat."

bmi :: (RealFloat a) => a -> a -> a
bmi weigth height = weigth / height ^ 2

-- Custom max function using guards
max' :: (Ord a) => a -> a -> a
max' a b
  | a > b     = a
  | otherwise = b

-- Custom compare function using guards
compare' :: (Ord a) => a -> a -> Ordering
a `compare'` b
  | a > b     = GT
  | a == b    = EQ
  | otherwise = LT