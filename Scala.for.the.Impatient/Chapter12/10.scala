def unless(cond: => Boolean)(block: => Unit): Unit = {
  if (!cond) block
}

val k: Int = 5

unless (k == 0) {
  println(k)
}