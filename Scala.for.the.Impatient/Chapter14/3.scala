def swap(arr: Array[Int]): Array[Int] = arr match {
  case Array(x, y, tail @ _*) => Array(y, x) ++ tail
}

println(swap(Array(1, 2, 3)).deep)