import scala.io.Source
import scala.collection.mutable.Map

val source = Source.fromFile("words.txt", "UTF-8")
val lineIterator = source.getLines
val wordCount = Map[String, Int]()

for (l <- lineIterator) {
  wordCount(l) = 1 + wordCount.getOrElse(l, 0)
}

println(wordCount)