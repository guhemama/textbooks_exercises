def lteqgt(values: Array[Int], v: Int): (Int, Int, Int) =
  (values.count(_ < v), values.count(_ == v), values.count(_ > v))

println(lteqgt(Array(4,2,1,2,5,9,10), 4))