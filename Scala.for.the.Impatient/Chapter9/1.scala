import scala.io.Source

val filename = "lorem.txt"
val lines = Source.fromFile(filename).getLines
val reversedLines = lines.toList.reverse

println(reversedLines.mkString("\n"))