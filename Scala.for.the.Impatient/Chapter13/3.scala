import scala.collection.mutable.ListBuffer

def removeEven(lst: ListBuffer[Int]): (ListBuffer[Int], ListBuffer[Int]) = {
  val evenList = ListBuffer[Int]()
  lst.indices.reverse.map(i =>
    if (i % 2 == 0) {
      println(lst(1))
      evenList += lst(i)
      lst.remove(i)
    }
  )

  (lst, evenList)
}

val (noEven, yesEven) = removeEven(ListBuffer(1,2,3,4,5,6))
println(noEven)
println(yesEven)