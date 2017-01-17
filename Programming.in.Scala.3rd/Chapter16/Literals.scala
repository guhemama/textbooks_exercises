val fruits = List("Apple", "Pear", "Mango") // List[String]
val numbers = List(1, 2, 3, 4) // List[Int]
val empty = List() // List[Nothing]

// Using the cons operator and Nil to build a list
val fruits2 = "Apple" :: ("Pear" :: ("Mango" :: Nil))

// The cons operator associates to the right, therefore we can drop the parens
val numbers2 = 1 :: 2 :: 3 :: 4 :: Nil