class Person(fullname: String) {
  val (firstName, lastName) = fullname.split(" ") match {
    case Array(a: String, b: String, _*) => (a, b)
    case _ => ("", "")
  }
}

val p = new Person("Bob Doe")
println(p.firstName, p.lastName)