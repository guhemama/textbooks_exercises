package space.perpetual

package object random {
  var previous: Int = 0
  val a: Int = 1664525
  val b: Int = 1013904223
  val n: Int = 32

  def nextInt(): Int = {
    previous = (previous * a + b) * scala.math.pow(2, n).toInt
    previous
  }

  def nextDouble(): Double = nextInt.toDouble

  def setSeed(seed: Int): Unit = previous = seed
}

object Ex3 extends App {
  println(random.nextInt)
}