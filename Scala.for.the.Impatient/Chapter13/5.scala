def makeString(lst: List[String]): String = {
  lst.reduceLeft(_ + " " + _)
}

println(makeString(List("1", "2", "3")))