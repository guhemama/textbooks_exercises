def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
  inputs.map(i => (i, fun(i))).reduceLeft((a, b) => if (a._2 > b._2) a else b)._1
}

assert(largest(x => 10 * x - x * x, 1 to 10) == 5)