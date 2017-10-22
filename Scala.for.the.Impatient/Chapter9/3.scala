import scala.io.Source

val filename = "lorem.txt"
val lines = Source.fromFile(filename).getLines.toList
val wordsNaive = lines.map(_.split("""\s""").filter(_.trim.length >= 12)).flatten
val wordsRegex = """\w{12,}""".r.findAllIn(lines.mkString)

println(wordsNaive.mkString(", "))
println(wordsRegex.mkString(", "))