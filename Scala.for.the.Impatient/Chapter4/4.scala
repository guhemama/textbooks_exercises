import scala.io.Source
import scala.collection.immutable.SortedMap

val source = Source.fromFile("words.txt", "UTF-8")
val words = source.getLines.toList
val wordCount = (for(w <- words.distinct) yield (w, words.count(_ == w))).toMap
val sortedWordCount = SortedMap[String, Int]() ++ wordCount
println(sortedWordCount)
