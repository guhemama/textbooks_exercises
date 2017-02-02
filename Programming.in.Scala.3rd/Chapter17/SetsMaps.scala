import scala.collection.mutable
import scala.collection.immutable.TreeSet

// Using an immutable Set
val set = Set(1, 2, 3)

// Using a mutable Set
val mutSet = mutable.Set(1, 2, 3)

// Sets guarantee an unique copy of each element
val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")
val words = mutable.Set.empty[String]

for (word <- wordsArray)
  words += word.toLowerCase

println(words) // Set(see, run, spot)

// Using an immutable Map
val map = Map('a' -> 1, 'b' -> 2, 'c' -> 3)
// Add new pair, returns new map
val map2 = map + ('d' -> 4)

// Using a mutable Map
val mutMap = mutable.Map('a' -> 1, 'b' -> 2, 'c' -> 3)
// Change a value/add new pair
mutMap('d') = 4

// Sorted Set - TreeSet
val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5) // TreeSet(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

// Sort Map - TreeMap
var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x') // Map(1 -> x, 3 -> x, 4 -> x)