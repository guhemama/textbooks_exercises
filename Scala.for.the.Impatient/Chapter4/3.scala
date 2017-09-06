import scala.io.Source

val source = Source.fromFile("words.txt", "UTF-8")
val words = source.getLines.toList
val wordCount = (for(w <- words.distinct) yield (w, words.count(_ == w))).toMap

println(wordCount)
