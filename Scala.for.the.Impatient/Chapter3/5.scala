def average(arr: Array[Double]): Double = {
  arr.fold(0.00) { _ + _ } / arr.length
}

println(average(Array(2, 4)))
println(average(Array(2, 3, 7, 5)))