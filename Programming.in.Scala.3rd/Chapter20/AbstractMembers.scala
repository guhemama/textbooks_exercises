// This trait defines an abstract type, method, val and var
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

// This class gives concrete definitions for the abstract members of the trait
class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}

val c = new Concrete
println(c.transform("foobar"))
println(c.initial)
println(c.current)