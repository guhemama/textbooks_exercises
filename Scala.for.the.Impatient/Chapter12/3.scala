def factorial(n: Int): Int = (1 to n).reduceLeft(_ * _)

assert(factorial(3) == 6)
assert(factorial(4) == 24)
assert(factorial(1) == 1)