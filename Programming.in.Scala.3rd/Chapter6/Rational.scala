class Rational(n: Int, d: Int) {
  // A precondition is a constraint on values passed into a method or constructor,
  // a requirement which callers must fulfill
  require(d != 0)

  // Reduce numer and denom by their greatest common denominator
  private val g = gcd(n.abs, d.abs)
  val numer = n / g
  val denom = d / g

  // We override the default toString method to some more meaningful
  override def toString = n + "/" + d

  // Auxiliary constructor: new Rational(5) => new Rational(5, 1)
  def this(n: Int) = this(n, 1)

  def +(that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(
    numer * that.denom - that.numer * denom,
    denom * that.denom
    )

  def -(i: Int): Rational =
    new Rational(numer - i * denom, denom)

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def * (i: Int): Rational =
    new Rational(numer * i, denom)

  def / (that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def / (i: Int): Rational =
    new Rational(numer, denom * i)

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}

val a = new Rational(1, 6)
val b = new Rational(4, 3)
println(s"$a + $b = ${a + b}")
println(s"$a - $b = ${a - b}")
println(s"$a * $b = ${a * b}")
println(s"$a / $b = ${a / b}")
println(s"$a + 1   = ${a + 1}")