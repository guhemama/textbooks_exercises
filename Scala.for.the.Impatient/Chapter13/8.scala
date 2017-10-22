def columnize(arr: Array[Int], width: Int = 3): Array[Array[Int]] = {
  arr.grouped(3).toArray
}

println(columnize(Array(1, 2, 3, 4, 5, 6)).deep)