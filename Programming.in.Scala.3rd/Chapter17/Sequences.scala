import scala.collection.mutable.{ArrayBuffer, ListBuffer}

// List - immutable linked-list
val colors = List("red", "blue", "green")
println(colors) // List[String] = List(red, blue, green)

// Array - faster than List, mutable
val fiveInts = new Array[Int](5)
fiveInts(2) = 4 // Array(0, 0, 4, 0, 0)
val fiveToOne = Array(5, 4, 3, 2, 1)

// ListBuffer - faster when you need to append stuff to lists
val buf = new ListBuffer[Int]
buf += 1  // append 1
buf += 2  // append 2
3 +=: buf // prepend 3
val lst = buf.toList // List(3, 1, 2)
println(lst)

// ArrayBuffer - allows adding elements at the beggining and the end of an array.
// The ArrayBuffer will adjust the allocated space automatically as needed.
val arrBuf = new ArrayBuffer[Int]()
arrBuf += 5
arrBuf += 6
val arr = arrBuf.toArray
println(arr) // Array(5, 6)

// StringOps - allows strings to be treated like lists. String is automatically
// converted into StringOps.
// s.exits => StringOps.exists
def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("Robert Frost") // true
hasUpperCase("bob dylan") // false