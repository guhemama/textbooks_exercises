case class Book(title: String, authors: String*)

val books: List[Book] =
  List(
    Book(
      "Structure and Interpretation of Computer Programs",
      "Abelson, Harold", "Sussman, Gerald J."
    ),
    Book(
      "Principles of Compiler Design",
      "Aho, Alfred", "Ullman, Jeffrey"
    ),
    Book(
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book(
      "Elements of ML Programming",
      "Ullman, Jeffrey"
    ),
    Book(
      "The Java Language Specification", "Gosling, James",
      "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
    )
  )

// To find the titles of all books whose author’s last name is “Gosling”:
for (b <- books; a <- b.authors if a startsWith "Gosling")
  yield b.title

// T find the titles of all books that have the string “Program” in their title:
for (b <- books if (b.title indexOf "Program") >= 0)
  yield b.title

