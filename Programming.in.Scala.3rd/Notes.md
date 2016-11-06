# Chapter 2 - First Steps in Scala

`val` is used to define a variable that can't be reassigned, and `var` is used to define a variable that can be reassigned.

Function definitions start with `def`.The function’s name is followed by a comma-separated list of parameters in parentheses. A type annotation must follow every function parameter, preceded by a colon, because the Scala compiler does not infer function parameter types.

Sometimes the Scala compiler will require you to specify the result type of a function. If the function is recursive, for example, you must explicitly specify the function’s result type.

A result type of `Unit` indicates the function returns no interesting value.

# Chapter 3 - Next Steps in Scala

## Arrays

In Scala, you can instantiate objects, or class instances, using new . When
you instantiate an object in Scala, you can parameterize it with values and
types. Parameterization means “configuring” an instance when you create it.
You parameterize an instance with types by specifying one or more types
in square brackets.

```scala
val big = new java.math.BigInteger("12345")

val greetStrings = new Array[String](3)
greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for (i <- 0 to 2)
    print(greetStrings(i))
```

Arrays in Scala are accessed by placing the index inside parentheses, not square brackets as in Java - it's actually transformed in a method call behind the scene (`arr.apply(i)`).

This block is semantically equivalent to the previous one:

```scala
val greetStrings = new Array[String](3)

greetStrings.update(0, "Hello")
greetStrings.update(1, ", ")
greetStrings.update(2, "world!\n")

for (i <- 0.to(2))
    print(greetStrings.apply(i))
```


Arrays can also be initialized this way:

```scala
val numNames = Array("zero", "one", "two")
```

## Lists

For an immutable sequence of objects that share the same type you can use Scala’s List class.

```scala
val oneTwoThree = List(1, 2, 3)
```

When you call a method on a list that might seem by its name to imply the list will mutate, it instead creates and returns a new list with the new value. For example, List has a method named `:::` for list concatenation. Here’s how you use it:

```scala
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")
```

Perhaps the most common operator you’ll use with lists is ‘ :: ’, which is pronounced “cons.” Cons prepends a new element to the beginning of an existing list and returns the resulting list.

```scala
val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree) // List(1,2,3)

val oneTwoThree = 1 :: 2 :: 3 :: Nil // List(1,2,3)
```

## Tuples

Like lists, tuples are immutable, but unlike lists, tuples can contain different types of elements. Tuples are very useful, for example, if you need to return multiple objects from a method. Once you have a tuple instantiated, you can access its elements individually with a dot, underscore, and the one-based index of the element.

```scala
val pair = (99, "Luftballons")
println(pair._1) // 99
println(pair._2) // Luftballons
```

# Sets and Maps

Scala also provides mutable and immutable alternatives for sets and maps, but uses the same simple names for both versions. For sets and maps, Scala models mutability in the class hierarchy.

```scala
var jetSet = Set("Boeing", "Airbus")
jetSet += "Lear"
println(jetSet.contains("Cessna")) // false
```

`jetSet += "Lear"` is a shortcode for `jetSet = jetSet + "Lear"`, because the set this immutable (by default, Scala uses `scala.collection.immutable.Set`).

If you want a mutable set, you’ll need to use an import:

```scala
import scala.collection.mutable
val movieSet = mutable.Set("Hitch", "Poltergeist")
movieSet += "Shrek"
println(movieSet)
```

As with sets, Scala provides mutable and immutable versions of `Map`, using a class hierarchy.

You can create and initialize maps using factory methods similar to those used for arrays, lists, and sets.

```scala
import scala.collection.mutable

val treasureMap = mutable.Map[Int, String]()

treasureMap += (1 -> "Go to island.")
treasureMap += (2 -> "Find big X on ground.")
treasureMap += (3 -> "Dig.")

println(treasureMap(2)) // "Find big X on ground."
```

When you say `1 -> "Go to island."`, you are actually calling a method named `->` on an integer with the value 1, passing in a string with the value "Go to island." This `->` method, which you can invoke on **any** object in a Scala program, returns a two-element tuple containing the key and value.

```scala
val t = 1 -> 'Foo bar'
// t: (Int, Char) = (1, 'b')
```