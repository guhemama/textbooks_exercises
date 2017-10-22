import scala.io.Source

val filename = "numbers.txt"
val numbers = Source.fromFile(filename).getLines.toList.map(_.toDouble)

println(numbers)