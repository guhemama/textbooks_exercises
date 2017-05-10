case class Point(val x: Int, val y: Int) {
  override def hashCode = (x, y).##

  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

val p1 = Point(1, 2)
val p2 = Point(1, 2)
println(p1 == p2)