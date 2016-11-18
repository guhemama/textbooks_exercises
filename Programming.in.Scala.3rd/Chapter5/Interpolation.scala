val name = "reader"
println(s"Hello, $name!")

println(s"The answer is ${6 * 7}.")

// raw string interpolator
println(raw"No\\\\escape!") // prints: No\\\\escape!

// printf-style string interpolator
println(f"Pi is approximately ${math.Pi}%.5f") // prints: 3.14159