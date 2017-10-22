// We pass the max function to it
val values = List(1, 2, 3, 4, 5)
println(values.reduceLeft(_ max _))