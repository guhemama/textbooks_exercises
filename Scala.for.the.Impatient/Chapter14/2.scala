def swap(p: (Int, Int)): (Int, Int) = p match {
  case (x, y) => (y, x)
}

println(swap(1, 2))