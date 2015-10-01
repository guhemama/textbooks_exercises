-- Gets your Body Mass Index and tells you off
-- Define local names/function to avoid repetition
bmiTell :: (RealFloat a) => a -> a -> String
bmiTell weight height
  | bmi <= skinny = "You're underweight."
  | bmi <= normal = "You're normal."
  | bmi <= fat    = "You're fat."
  | otherwise     = "You are very fat."
  where bmi = weight / height ^ 2
        skinny = 18.5
        normal = 25.0
        fat    = 30.0

  -- also equals to:
  -- (skinny, normal, fat) = (18.5, 25.0, 30.0)

-- Get the name initials
initials :: String -> String -> String
initials firstname lastname = [f] ++ ", " ++ [l] ++ "."
  where (f:_) = firstname
        (l:_) = lastname

-- Normal implementation using pattern matching
initials' :: String -> String -> String
initials' (f:_) (l:_) = [f] ++ ", " ++ [l] ++ "."