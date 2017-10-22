class Point(val x: Double, val y: Double) {
  override def toString = s"x:${x} y:${y}"
}
class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y) {
  override def toString = s"${label} => ${super.toString}"
}

val p1 = new LabeledPoint("Center", 0, 0)
println(p1)