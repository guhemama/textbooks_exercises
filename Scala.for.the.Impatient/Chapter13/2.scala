import scala.collection.immutable.Map
import scala.collection.immutable.SortedSet

def indexes(str: String): Map[Char, SortedSet[Int]] = {
  str.indices.foldLeft(Map[Char, SortedSet[Int]]()) {
    (m, i) => m + (str(i) -> (m.getOrElse(str(i), SortedSet[Int]()) + i))
  }
}

println(indexes("Mississipi"))