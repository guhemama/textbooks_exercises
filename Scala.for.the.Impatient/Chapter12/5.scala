def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
  inputs.map(fun(_)).reduceLeft(_ max _)
}

assert(largest(x => 10 * x - x * x, 1 to 10) == 25)