case class Point1(x: Int, y: Int)

// is the same as
class Point2(x: Int, y: Int)
object Point2 {
  def apply(x: Int, y: Int): Point2 = new Point(x, y)
}

println(Point1(3, 4))
println(Point2(3, 4))