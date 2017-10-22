def sum(lst: List[Option[Int]]): Int = lst.map(_.getOrElse(0)).sum

println(sum(List(Some(1), None, Some(3))))