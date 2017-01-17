// Anytime you define a val or a var , you can use a pattern instead of a simple identifier.
val tuple = (123, "abc")

// Assign values from tuple
val (number, string) = tuple
println(number) // 123
println(string) // abc

// A sequence of cases (i.e., alternatives) in curly braces can be used anywhere
// a function literal can be used.
val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

withDefault(Some(10)) // 10
withDefault(None)     // 0

// You can also use a pattern in a for expression
val capitals = Map("Japan" -> "Tokyo", "Mexico" -> "Mexico City")
for ((country, city) <- capitals)
  println("The capital of " + country + " is " + city)