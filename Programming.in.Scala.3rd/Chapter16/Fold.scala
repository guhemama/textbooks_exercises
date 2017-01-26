val words: List[String] = List("o", "rato", "roeu", "a", "roupa")

// Joins the words, adding an space before them (left fold)
val phrase = ("" /: words) (_ + " " + _)
println(phrase) // " o rato roeu a roupa"


// Joins the words, adding an space after them (right fold)
val phrase2 = (words :\ "") (_ + " " + _)
println(phrase2) // "o rato roeu a roupa "

