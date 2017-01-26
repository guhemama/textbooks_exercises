val numbers = List(1, -3, 4, 2, 6)
val numbers2 = numbers sortWith (_ < _)
println(numbers, numbers2)
// List(-3, 1, 2, 4, 6)

val words = List("the", "quick", "brown", "fox")
val words2 = words sortWith (_.length > _.length)
println(words, words2)
// List(quick, brown, the, fox)