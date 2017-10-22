import scala.io.Source

val filename = "floating_lorem.txt"
val tokens = Source.fromFile(filename).getLines.toList.map(_.split("\\s")).flatten

tokens.filter(token => !token.matches("\\d+.\\d+.?")).map(println)