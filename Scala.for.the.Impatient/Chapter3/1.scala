import scala.util.Random

def randomArr(n: Int): Array[Int] = {
  val arr = new Array[Int](n)
  val random = new Random()

  for (idx <- 0 until n)
    arr(idx) = random.nextInt(n)

  arr
}

println(randomArr(5).mkString(" "))
println(randomArr(10).mkString(" "))