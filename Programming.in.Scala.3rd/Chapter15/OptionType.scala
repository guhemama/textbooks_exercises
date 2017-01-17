// Option types are useful when dealing with collections; e.g. to wrap
// a value that may or may not be found in the collection.
val capitals =
  Map("France" -> "Paris", "Japan" -> "Tokyo")

// Type safe function to print string
def show(x: Option[String]) = x match {
  case Some(s) => s
  case None    => "Shoop da whoop"
}

println(show(capitals get "Japan"))    // Some("Tokyo") => Tokyo
println(show(capitals get "Brazil")) // None => "Shoop da whoop"