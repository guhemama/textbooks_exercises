import scala.math.abs

case class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)

  override def toString = s"$num/$den"

  def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b== 0) abs(a) else gcd(b, a % b)

  def /(other: Fraction) = Fraction(n * other.d, d * other.n)
  def *(other: Fraction) = Fraction(n * other.n, d * other.d)
  def +(other: Fraction) = Fraction(n * other.d + other.n * d, d * other.d)
  def -(other: Fraction) = Fraction(n * other.d - other.n * d, d * other.d)
}

val f1 = Fraction(1, 2)
val f2 = Fraction(2, 3)

println(f1 - f2, "-1/6")
println(f1 + f2, "7/6")
println(f1 * f2, "1/3")
println(f1 / f2, "3/4")