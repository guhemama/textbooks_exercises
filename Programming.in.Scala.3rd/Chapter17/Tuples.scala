// This a method that finds the longest word in a
// collection and also returns its index
def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if (words(i).length > word.length) {
    word = words(i)
    idx = i
  }
  (word, idx)
}

val longest = longestWord("The quick brown fox".split(" "))
println(longest) // (String, Int) = ("quick", 1)