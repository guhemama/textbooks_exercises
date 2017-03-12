# Chapter 2 - First Steps in Scala

`val` is used to define a variable that can't be reassigned, and `var` is used to define a variable that can be reassigned.

Function definitions start with `def`.The function's name is followed by a comma-separated list of parameters in parentheses. A type annotation must follow every function parameter, preceded by a colon, because the Scala compiler does not infer function parameter types.

Sometimes the Scala compiler will require you to specify the result type of a function. If the function is recursive, for example, you must explicitly specify the function's result type.

A result type of `Unit` indicates the function returns no interesting value.

# Chapter 3 - Next Steps in Scala

## Arrays

In Scala, you can instantiate objects, or class instances, using new . When
you instantiate an object in Scala, you can parameterize it with values and
types. Parameterization means "configuring" an instance when you create it.
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

For an immutable sequence of objects that share the same type you can use Scala's List class.

```scala
val oneTwoThree = List(1, 2, 3)
```

When you call a method on a list that might seem by its name to imply the list will mutate, it instead creates and returns a new list with the new value. For example, List has a method named `:::` for list concatenation. Here's how you use it:

```scala
val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")
```

Perhaps the most common operator you'll use with lists is ‘ :: ', which is pronounced "cons." Cons prepends a new element to the beginning of an existing list and returns the resulting list.

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

If you want a mutable set, you'll need to use an import:

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


# Chapter 4 - Classes and Objects

A class is a blueprint for objects. Once you define a class, you can create objects from the class blueprint with the keyword new . For example, given the class definition:

```scala
class ChecksumAccumulator {
// class definition goes here
}

// You can create ChecksumAccumulator objects with:
new ChecksumAccumulator
```

Inside a class definition, you place fields and methods, which are collectively called members. Fields, which you define with either `val` or `var`, are variables that refer to objects. Methods, which you define with def , contain executable code.

Private fields can only be accessed by methods defined in the same class, all the code that can update the state will be localized to the class.

```scala
class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte): Unit = sum += b
    def checksum(): Int = ~ (sum & 0xFF) + 1
}
```

It is often better to explicitly provide the result types of public methods declared in a class even when the compiler would infer it for you.

## Singleton objects

A singleton object definition looks like a class definition, except instead of the keyword class you use the keyword object.

When a singleton object shares the same name with a class, it is called that class's companion object. You must define both the class and its _companion object_ in the same source file. The class is called the _companion class_ of the singleton object. A class and its companion object can access each other's private members.

Defining a singleton object doesn't define a type (at the Scala level of
abstraction). Rather, the type named ChecksumAccumulator is defined by the singleton object's companion class. However, singleton objects extend a superclass and can mix in traits.

A singleton object that does not share the same name with a companion
class is called a _standalone object_. You can use standalone objects for many purposes, including collecting related utility methods together or defining an entry point to a Scala application.

## A Scala application

To run a Scala program, you must supply the name of a standalone singleton object with a main method that takes one parameter, an Array[String], and has a result type of Unit . Any standalone object with a main method of the proper signature can be used as the entry point into an application.

```scala
// In file Summer.scala
import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) = {
    for (arg <- args)
      println(arg + ": " + calculate(arg))
  }
}
```

## The App trait

Scala provides a trait, scala.App , that can save you some finger typing. To use the trait, you first write " extends App " after the name of your singleton object. Then instead of writing a main method, you place the code you would have put in the main method directly between the curly braces of the singleton object. You can access command-line arguments via an array of strings named args . That's it. You can compile and run this application just like any other.

```scala
import ChecksumAccumulator.calculate

object FallWinterSpringSummer extends App {
  for (season <- List("fall", "winter", "spring"))
    println(season + ": " + calculate(season))
}
```


# Chapter 5 - Basic Types and Operations

## Basic types

Other than `String`, which resides in package `java.lang`, all of the types
shown below are members of package `scala`:

- Byte
- Short
- Int
- Long
- Char
- String
- Float
- Double
- Boolean

All of the basic types listed above can be written with literals. A literal is a way to write a constant value directly in code.

Integer literals for the types Int, Long, Short, and Byte come in two forms: decimal and hexadecimal.

Floating point literals are made up of decimal digits, optionally containing a decimal point, and optionally followed by an E or e and an exponent.

```scala
val big = 1.2345
val bigger = 1.2345e2 // => 123.45
```


Character literals are composed of any Unicode character between single quotes, such as:

```scala
val a = 'A'
a: Char = A
```

In addition to providing an explicit character between the single quotes, you`can identify a character using its Unicode code point. To do so, write \u followed by four hex digits with the code point.

A string literal is composed of characters surrounded by double quotes.

```scala
val hello = "hello"
hello: String = hello
```

Scala includes a special syntax for raw strings. You start and end a raw string with three double quotation marks in a row ( """ ). The interior of a raw string may contain any characters whatsoever, including newlines, quotation marks, and special characters, except of course three quotes in a row.

```scala
println("""|Welcome to Ultamix 3000.
           |Type "HELP" for help.""".stripMargin)
```

A symbol literal is written `'ident`, where ident can be any alphanumeric identifier.

The Boolean type has two literals, `true` and `false`.

## String interpolation

Scala includes a flexible mechanism for string interpolation, which allows you to embed expressions within string literals. Its most common use case is to provide a concise and readable alternative to string concatenation. Here's an example:

```scala
val name = "reader"
println(s"Hello, $name!")
```

The expression, `s"Hello, $name!"` is a processed string literal. Because the letter s immediately precedes the open quote, Scala will use the _s string interpolator_ to process the literal.

You can place any expression after a dollar sign ($) in a processed string
literal. If the expression includes non-identifier characters, you must place it in curly braces, with the open curly brace immediately following the dollar sign.

```scala
s"The answer is ${6 * 7}."
res0: String = The answer is 42.
```

Scala provides two other string interpolators by default: `raw` and `f`. The raw string interpolator behaves like `s`, except it does not recognize character literal escape sequences.

The `f` string interpolator allows you to attach printf-style formatting instructions to embedded expressions.

```scala
f"${math.Pi}%.5f"
res1: String = 3.14159
```

## Operators are methods

Scala provides a rich set of operators for its basic types. These operators are actually just a nice syntax for ordinary method calls. For example, 1 + 2 really means the same thing as 1.+(2). In other words, class Int contains a method named + that takes an Int and returns an Int result. This + method is invoked when you add two Ints.

## Arithmetic operations

You can invoke arithmetic methods via infix operator notation for addition +, subtraction -, multiplication *, division /, and remainder % on any numeric type.

## Relational and logical operations

You can compare numeric types with relational methods greater than >, less than <, greater than or equal to >=, and less than or equal to <=, which yield a Boolean result. In addition, you can use the unary ! operator (the unary_! method) to invert a Boolean value.

Logical methods, logical-and (&& and &) and logical-or (|| and |), take Boolean operands in infix notation and yield a Boolean result. The && and || operations short-circuit as in Java.

# Bitwise operations

Scala enables you to perform operations on individual bits of integer types with several bitwise methods. The bitwise methods are: bitwise-and &, bitwise-or |, and bitwise-xor ^. Scala integer types also offer three shift methods: shift left <<, shift right >>, and unsigned shift right >>>.

## Object equality

If you want to compare two objects for equality, you can use either `==` or its inverse `!=`.


# Chapter 6 - Functional Objects

## Checking preconditions

In the case of an immutable object, you should ensure the data is valid when the object is constructed.

A precondition is a constraint on values passed into a method or constructor, a requirement which callers must fulfill.

```scala
class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n + "/" + d
}
```

The `require` method takes one boolean parameter. If the passed value is true, require will return normally. Otherwise, require will prevent the object from being constructed by throwing an `IllegalArgumentException`.

## Auxiliary constructors

Sometimes you need multiple constructors in a class. In Scala, constructors other than the primary constructor are called _auxiliary constructors_.

Auxiliary constructors in Scala start with `def this(...)`. In Scala, every auxiliary constructor must invoke another constructor of the same class as its first action.

```scala
class Rational(n: Int, d: Int) {
  require(d != 0)

  def this(n: Int) = this(n, 1)
}
```

## Identifiers in Scala

Scala follows Java's convention of using camel-case 5 identifiers, such as toString and HashSet. Although underscores are legal in identifiers, they are not used that often in Scala programs. Camel-case names of fields, method parameters, local variables, and functions should start with a lower case letter. Camel-case names of classes and traits should start with an upper case letter, for example: BigInt, List, and UnbalancedTreeMap.

## Method overloading

Scala's process of overloaded method resolution is very similar to Java's. In every case, the chosen overloaded version is the one that best matches the static types of the arguments. Sometimes there is no unique best matching version; in that case the compiler will give you an "ambiguous reference" error.


## Implicit conversions

```scala
implicit def intToRational(x: Int) = new Rational(x)
```

This defines a conversion method from `Int` to `Rational`. The `implicit` modifier in front of the method tells the compiler to apply it automatically in a number of situations.


# Chapter 7 - Built-in Control Structures

Scala has only a handful of built-in control structures. The only control structures are `if , while , for , try , match` , and function calls. Almost all of Scala's control structures result in some value.

## For expressions

Scala's `for` expression is a Swiss army knife of iteration. It lets you combine a few simple ingredients in different ways to express a wide variety of iterations.

Iterate over a collection:

```scala
// The Java code returns an array
val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere)
  println(file)

// Ranges
for (i <- 1 to 4)
  println("Iteration " + i)

for (i <- 1 until 4)
  println("Iteration " + i)
```

`for` expressions can also be used to filter collections. You can use many filters at the same time.

```scala
val filesHere = (new java.io.File(".")).listFiles
for (file <- filesHere if file.getName.endsWith(".scala"))
  println(file)

for {
  file <- filesHere
  if file.isFile
  if file.getName.endsWith(".scala")
} println(file)
```

While all of the examples so far have operated on the iterated values and then forgotten them, you can also generate a value to remember for each iteration. To do so, you prefix the body of the for expression by the keyword `yield`.

```scala
def scalaFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file
```

## Exception handling with try expressions

Scala's exceptions behave just like in many other languages. Instead of returning a value in the normal way, a method can terminate by throwing an exception. The method's caller can either catch and handle that exception, or it can itself simply terminate, in which case the exception propagates to the caller's caller. The exception propagates in this way, unwinding the call stack, until a method handles it or there are no more methods left.

Throwing an exception in Scala looks the same as in Java. You create an exception object and then throw it with the throw keyword:

```scala
throw new IllegalArgumentException
```

You catch exceptions using the syntax shown below. The syntax for catch clauses was chosen for its consistency with an important part of Scala: pattern matching.

You can wrap an expression with a finally clause if you want to cause some code to execute no matter how the expression terminates.

```scala
import java.io.FileReader
import java.io.FileNotFoundException
import java.io.IOException

try {
  val f = new FileReader("input.txt")
// Use and close file
} catch {
  case ex: FileNotFoundException => // Handle missing file
  case ex: IOException => // Handle other I/O error
} finally {
  file.close() // Be sure to close the file
}
```

## Match expressions

Scala's match expression lets you select from a number of alternatives, just like switch statements in other languages. In general a match expression lets you select using arbitrary patterns. The default case is specified with an underscore ( _ ), a wildcard symbol frequently used in Scala as a placeholder for a completely unknown value. `match` expressions return a value.

```scala
val firstArg = if (args.length > 0) args(0) else ""

val friend =
  firstArg match {
    case "salt" => println("pepper")
    case "chips" => println("salsa")
    case "eggs" => println("bacon")
    case _ => println("huh?")
  }
```

## Living without `break` and `continue`

The simplest approach is to replace every `continue` by an if and every `break` by a boolean variable.


# Chapter 8 - Functions and Closures

## First-class functions

Scala has _first-class functions_. Not only can you define functions and call them, but you can write down functions as unnamed _literals_ and then pass them around as _values_.

Example of a function literal that adds one to a number:
```scala
(x: Int) => x + 1
```

The => designates that this function converts the thing on the left (any nteger x) to the thing on the right ( x + 1 ). So, this is a function mapping any integer x to x + 1.

Function values are objects, so you can store them in variables if you like. They are functions, too, so you can invoke them using the usual parentheses function-call notation. Here is an example of both activities:

```scala
val increase = (x: Int) => x + 1
increase(10) // Int = 11
```

## Short forms of function literals

Scala provides a number of ways to leave out redundant information and write function literals more briefly. One way to make a function literal more brief is to leave off the parameter types. A second way to remove useless characters is to leave out parentheses around a parameter whose type is inferred.

```scala
someNumbers.filter((x: Int) => x > 0)
someNumbers.filter((x) => x > 0) // becomes this
someNumbers.filter(x => x > 0) // which becomes this
```

## Placeholder syntax

To make a function literal even more concise, you can use underscores as placeholders for one or more parameters, so long as each parameter appears only one time within the function literal.

```scala
someNumbers.filter(x => x > 0)
someNumbers.filter(_ > 0) // becomes this
```

## Partially applied functions

You can also replace an entire parameter list with an underscore. For example, rather than writing `println(_)`, you could write `println _`.

## Special function call forms

### Repeated parameters

Scala allows you to indicate that the last parameter to a function may be repeated. This allows clients to pass variable length argument lists to the function. To denote a repeated parameter, place an asterisk after the type of the parameter.

```scala
def echo(args: String*) =
  for (arg <- args) println(arg)

echo()
echo("one") // one
echo("hello", "world!") // "hello"\n"world!"
```

Defined this way, `echo` can be called wiht zero to many String arguments. Inside the function, the type of the repeated parameter is an Array of the declared type of the parameter. Thus, the type of args inside the `echò`function, which is declared as type String* is actually Array[String].

### Named arguments

Named arguments allow you to pass arguments to a function in a different order. The syntax is simply that each argument is preceded by a parameter name and an equals sign.

```scala
def speed(distance: Float, time: Float): Float = distance / time

speed(distance = 100, time = 10) // Float = 10.0
speed(time = 10, distance = 100) // Float = 10.0
```

### Default parameter values

Scala lets you specify default values for function parameters. The argument for such a parameter can optionally be omitted from a function call, in which case the corresponding argument will be filled in with the default.

```scala
def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = " + System.currentTimeMillis())
```

## Tail recursion

Functions which call themselves as their last action, are called _tail recursive_. The Scala compiler detects tail recursion and replaces it with a jump back to the beginning of the function, after updating the function parameters with the new values.

The moral is that you should not shy away from using recursive algorithms to solve your problem. Often, a recursive solution is more elegant and concise than a loop-based one. If the solution is tail recursive, there won't be any runtime overhead to be paid.

The use of tail recursion in Scala is fairly limited because the JVM instruction set makes implementing more advanced forms of tail recursion very difficult. Scala only optimizes directly recursive calls back to the same function making the call. If the recursion is indirect, no optimization is possible.


# Chapter 9 - Control abstraction

## Currying

To understand how to make control abstractions that feel more like language extensions, you first need to understand the functional programming technique called _currying_. A curried function is applied to multiple argument lists, instead of just one.

```scala
def plainOldSum(x: Int, y: Int) = x + y
plainOldSum(1, 2) // Int = 3

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2) // Int = 3
```

Int the curried form, instead of one list of two Int parameters, you apply this function to two lists of one Int parameter each.

What's happening here is that when you invoke curriedSum , you actually get two traditional function invocations back to back. The first function invocation takes a single Int parameter named x, and returns a function value for the second function. This second function takes the Int parameter y.

## Writing new control structures

In languages with first-class functions, you can effectively make new control structures even though the syntax of the language is fixed. All you need to do is create methods that take functions as arguments.

Any time you find a control pattern repeated in multiple parts of your code, you should think about implementing it as a new control structure.

```scala
def withPrintWriter(file: File)(op: PrintWriter => Unit) = {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

val file = new File("date.txt")
withPrintWriter(file) { writer =>
  writer.println(new java.util.Date)
}
```

In any method invocation in Scala in which you're passing in exactly one argument, you can opt to use curly braces to surround the argument instead of parentheses - which may look better.

## By-name parameters

What if you want to implement something more like _if_ or _while_, where there is no value to pass into the code between the curly braces? To help with such situations, Scala provides by-name parameters.

To make a by-name parameter, you give the parameter a type starting with _=>_ instead of _() =>_. Now you can leave out the empty parameter in the property you want to assert.

```scala
def byNameAssert(predicate: => Boolean) =
  if (assertionsEnabled && !predicate)
    throw new AssertionError

byNameAssert(5 > 3)
```



# Chapter 10 - Composition and inheritance

Composition means one class holds a reference to another, using the referenced class to help it fulfill its mission. Inheritance is the superclass/subclass relationship.

## Abstract classes

A class with abstract members must itself be declared abstract, which is done
by writing an abstract modifier in front of the class keyword. A method is abstract if it does not have an implementation (i.e., no equals sign or body).

```scala
abstract class Element {
  def contents: Array[String]
}
```

The abstract modifier signifies that the class may have abstract members that do not have an implementation. As a result, you cannot instantiate an abstract class.

## Extending classes

Just like in Java, you use an extends clause after the class name to express a class extension. Class ArrayElement is defined to extend class Element.

```scala
class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}
```

_Inheritance_ means that all members of the superclass are also members of the subclass, with two exceptions. First, private members of the superclass are not inherited in a subclass. Second, a member of a superclass is not inherited if a member with the same name and parameters is already implemented in the subclass. In that case we say the member of the subclass _overrides_ the member of the superclass.

## Defining parametric fields

You can avoid the code smell by combining the parameter and the field in a single _parametric field_ definition:

```scala
class ArrayElement(
  val contents: Array[String]
) extends Element
```

Note that now the contents parameter is prefixed by `val`. This is a shorthand that defines at the same time a parameter and field with the same name.

## Invoking superclass constructors

To invoke a superclass constructor, you simply place the argument or arguments you want to pass in parentheses following the name of the superclass. Below, the argument is Array(s), where `s` is the string received by LineElement.

```scala
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width = s.length
  override def height = 1
}
```

## Using override modifiers

Scala requires a overried modifier for all members that override a concrete member in a parent class.


# Chapter 12 - Traits

Traits are a fundamental unit of code reuse in Scala. A trait encapsulates method and field definitions, which can then be reused by mixing them into classes. Unlike class inheritance, in which each class must inherit from just one superclass, a class can mix in any number of traits.

A trait definition looks just like a class definition except that it uses the keyword `trait`. A trait also defines a type.

```scala
trait Philosophical {
  def philosophize() = {
    println("I consume memory, therefore I am!")
  }
}
```

Once a trait is defined, it can be mixed in to a class using either the `extends` or `with` keywords.

```scala
class Frog extends Philosophical {
  override def toString = "green"
}
```

Traits can, for example, declare fields and maintain state. In fact, you can do anything in a trait definition that you can do in a class definition, and the syntax looks exactly the same, with only two exceptions.

* A trait cannot have any "class" parameters (i.e., parameters passed to the primary constructor of a class).
* in classes, super calls are statically bound, in traits, they are dynamically bound. The implementation to invoke will be determined anew each time the trait is mixed into a concrete class.

## The Ordered trait

The `Ordered` trait then defines < , > , <= , and >= for you in terms of this one method. Thus, trait Ordered allows you to enrich a class with comparison methods by implementing only one method, `compare`.

```scala
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  // ...
  def compare(that: Rational) =
    (this.numer * that.denom) - (that.numer * this.denom)
}
```

Ordered requires you to specify a type parameter when you mix it in. When you mix in Ordered , you must actually mix in `Ordered[C]`, where `C` is the class whose elements you compare. In this case, `Rational` mixes in `Ordered[Rational]`.

You also need to do is define a `compare` method for comparing two objects. This method should compare the receiver, `this`, with the object passed as an argument to the method. It should return an integer that is zero if the objects are the same, negative if receiver is less than the argument, and positive if the receiver is greater than the argument.


# Chapter 13 - Packages and Imports

## Putting code in packages

Scala code resides in the Java platform's global hierarchy of packages.

```scala
package com.bobsrockets.navigation
class Navigator
```

## Concise access to related code

When code is divided into a package hierarchy, it doesn't just help people browse through the code. It also tells the compiler that code in the same package is related in some way to each other. Scala takes advantage of this relatedness by allowing short, unqualified names when accessing code that is in the same package.

## Imports

In Scala, packages and their members can be imported using import clauses. Imported items can then be accessed by a simple name like `File`, as opposed to requiring a qualified name like `java.io.File`.

```scala
// easy access to Fruit
import bobsdelights.Fruit

// easy access to all members of bobsdelights
import bobsdelights._

// easy access to all members of Fruits
import bobsdelights.Fruits._

package bobsdelights

abstract class Fruit(
  val name: String,
  val color: String
)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)
}
```

Imports in Scala can appear anywhere, not just at the beginning of a compilation unit. Also, they can refer to arbitrary values.

Imports in Scala can also rename or hide members. This is done with an import selector clause enclosed in braces, which follows the object from which members are imported.

This imports just members `Apple` and `Orange` from object `Fruits`:

```scala
import Fruits.{Apple, Orange}
```

```scala
import Fruits.{Apple => McIntosh, Orange}
```

This imports the two members `Apple` and `Orange` from object `Fruits` and renames the `Apple` object to `McIntosh`,so this object can be accessed with either `Fruits.Apple` or `McIntosh`.

## Package objects

Each package is allowed to have one package object. Any definitions placed in a package object are considered members of the package itself. Any other code in any package can import the method just like it would import a class.

```scala
// In file bobsdelights/package.scala
package object bobsdelights {
  def showFruit(fruit: Fruit) = {
    import fruit._
    println(name + "s are " + color)
  }
}

// In file PrintMenu.scala
package printmenu
import bobsdelights.Fruits
import bobsdelights.showFruit

object PrintMenu {
  def main(args: Array[String]) = {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
```



# Chapter 15 - Case Classes and Pattern Matching

Case classes are Scala's way to allow pattern matching on objects without requiring a large amount of boilerplate.

Classes with the `case` modifier are called case classes. Using the modifier makes the Scala compiler add some syntactic conveniences to your class.

First, it adds a factory method with the name of the class. This means that, for instance, you can write `Var("x")` to construct a Var object, instead of the slightly longer `new Var("x")`.

The second syntactic convenience is that all arguments in the parameter list of a case class implicitly get a `val` prefix, so they are maintained as fields.

Third, the compiler adds "natural" implementations of methods `toString`, `hashCode` , and `equals` to your class.

Finally, the compiler adds a copy method to your class for making modified copies.

Also, this allows Scala to easily implement pattern matching (just like what I saw in Haskell):

```scala
def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e   // Double negation
  case BinOp("+", e, Number(0)) => e // Adding zero
  case BinOp("*", e, Number(1)) => e
  case _ => expr // Multiplying by one
}
```

## Kinds of patterns

* The wildcard pattern `(_)` matches any object whatsoever.
* A constant pattern matches only itself. Any literal may be used as a constant. For example, `5`, `true`, and `"hello"` are all constant patterns.
* A variable pattern matches any object, just like a wildcard. But unlike a
wildcard, Scala binds the variable to whatever the object is.
* Constructors are where pattern matching becomes really powerful. A constructor pattern looks like `BinOp("+", e, Number(0))`.
* You can match against sequence types, like List or Array , just like you
match against case classes. `case List(0, _, _) => println("found it")`. If you want to match against a sequence without specifying how long it can be, you can specify `_*` as the last element of the pattern.
* You can match against tuples too. A pattern like `(a, b, c)` matches an
arbitrary 3-tuple.
* You can use a typed pattern as a convenient replacement for type tests and
type casts. `case s: String => s.length`

## Pattern guards

A pattern guard comes after a pattern and starts with an `if`. The guard can be an arbitrary boolean expression, which typically refers to variables in the pattern. If a pattern guard is present, the match succeeds only if the guard evaluates to `true`.

```scala
def simplifyAdd(e: Expr) = e match {
  case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
  case _ => e
}
```

## Sealed classes

You can enlist the help of the Scala compiler in detecting missing combinations of patterns in a match expression. To do this, the compiler needs to be able to tell which are the possible cases. To do that, you make the superclass of your case classes `sealed`. A sealed class cannot have any new subclasses added except the ones in the same file.

If you write a hierarchy of classes intended to be pattern matched, you should consider sealing them. Simply put the `sealed` keyword in front of the class at the top of the hierarchy.

## The `Option` type

Scala has a standard type named `Option` for optional values - kinda like `null`, but type-safe. Such a value can be of two forms: `Some(x)` , where x is the actual value, or the `None` object, which represents a missing value.


# Chapter 16 - Working with lists

Lists are similar to arrays, but they are immutable. They also have a recursive structure, whereas arrays are flat (because they are use adjacent memory locations). Lists, just like arrays, are homogenous: the elements of a list all have the same type.

List are build from two fundamental building blocks `Nil` and `::` (cons). They can also be used to pattern match lists.

## Operations on lists

All list operations can be expressed in terms of `head`, `tail` and `isEmpty`.

* `:::` concatenates two lists.
* `last` returns the last element of a list.
* `init` returns all elements of a list but the last one.
* `reverse` reverses a list.
* `take` returns the first _n_ elements of a list.
* `drop` returns all elements of a list but the first _n_ ones.
* `splitAt` splits the list at a given index, returning two lists.
* `flatten` takes a list of lists and flattens it out to a single list.
* `zip` takes two lists and forms a list of pairs.
* `unzip` transforms any list of tuples back into a tuple of lists.
* `toString` returns the canonical string representation of a list.
* `mkString` formats the string representation of a list.
* `List.toArray` transforms a list into an array.
* `Array.toList` transforms an array into a list.
* `map` returns the list after applying a function _f_ to it.
* `flatMap` it applies a function _f_ to each list element and returns the concatenation of all function results.
* `foreach` applies a procedure to each list element.
* `filter` filters a list based on a predicate _p_.
* `partition` filters a list based on a predicate _p_ and returns two lists: one with elements where predicate is true, and the other with elements where the predicate is false.
* `find` returns the first element that matches a predicate.
* `takeWhile`
* `dropWhile`
* `span` combines `takeWhile` and `dropWhile`, returning a pair of lists.
* `forall` returns true if all elements of a list satisfy a predicate _p_.
* `exists` returns true if any element of a list satisfy a predicate _p_.

### Folding lists

Another common kind of operation combines the elements of a list with some operator.

`sum(List(a, b, c))` equals `0 + a + b + c`

Which is a special instance of a fold operation:

`def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)`

A _fold left_ operation "(z /: xs) (op)" involves three objects: a start value `z`, a list `xs`, and a binary operation `op`. The result of the fold is `op` applied between successive elements of the list prefixed by `z`.

`(z /: List(a, b, c)) (op)` equals `op(op(op(z, a), b), c)`

The `/:` operator produces left-leaning operation trees (its syntax with the slash rising forward is intended to be a reflection of that). The operator has `:\` as an analog that produces right-leaning trees.

`(List(a, b, c) :\ z) (op)` equals `op(a, op(b, op(c, z)))`

You can also use the `foldLeft` and `foldRight` methods from class `List`.

### Sorting lists

`sortWith` lets a list to be sorted by using a comparison function.

```scala
val l1 = List(1, -3, 4, 2, 6) sortWith (_ < _)
// List(-3, 1, 2, 4, 6)

val l2 = List("the", "quick", "brown", "fox") sortWith (_.length > _.length)
// List(quick, brown, the, fox)
```

## Methods of the `List` object

* `List.range(from, until)` creates a list consisting of a range of numbers.
* `List.fill` creates a list consisting of zero or more copies of the same element.
* `List.tabulate(n)(fn)` creates a list whose elements are computed according
to a supplied function.
* `List.concat` concatenates a number of element lists.


# Chatper 17 - Working with other collections

## Sequences

Sequence types let you work with groups of data lined up in order. Because the elements are ordered, you can ask for the first element, second element, and so on.

* `List`: immutable linked-list.
* `Array`: it allows you to hold a sequence of elements and efficiently access an element at an arbitrary position, either to get or update the element, with a zero-based index.
* `ListBuffer`: it's a mutable object (contained in package `scala.collection.mutable`), which can help you build lists more efficiently when you need to append.
* `ArrayBuffer`: it's like an array, except that you can additionally add and remove elements from the beginning and end of the sequence. The `ArrayBuffer` will adjust the allocated space automatically as needed.
* `StringOps`: strings can be automatically converted into a `StringOps`, which supports many sequence methods.

## Sets and maps

The Scala collections library offers both mutable and immutable versions of sets and maps (by default they're immutable).

### Sets

Defined by class `Set` (either mutable or immutable). The key characteristic of sets is that they will ensure that at most one of each object, as determined by `==`, will be contained in the set at any one time.

### Maps

Defined by class `Map`. Maps let you associate a value with each element of a set.

### Default sets and maps

For most uses, the implementations of mutable and immutable sets and maps provided by the `Set()`, `scala.collection.mutable.Map()` , etc., factories will likely be sufficient. The implementations provided by these factories use a fast lookup algorithm, usually involving a hash table, so they can quickly decide whether or not an object is in the collection.

### Sorted sets and maps

On occasion you may need a set or map whose iterator returns elements in a particular order. You can leverage `SortedSet` and `SortedMap` in these cases.

## Selecting mutable versus immutable collections

For some problems, mutable collections work better, while for others, immutable collections work better. When in doubt, it is better to start with an immutable collection and change it later, if you need to, because immutable collections can be easier to reason about than mutable ones.

## Tuples

A tuple combines a fixed number of items together so that they can be passed around as a whole. A common application of tuples is returning multiple values from a method. To access elements of a tuple, you can use method `_1` to access the first element, `_2` to access the second, and so on.

```scala
val tpl = ("foo", 1)
tpl._1 // "foo"
tpl._2 // 1

// assign each element to a variable
val (word, idx) = tpl
```



# Chapter 19 - Type parametrization

Type parameterization allows you to write generic classes and traits. For example, sets are generic and take a type parameter: they are defined as `Set[T]` . As a result, any particular set instance might be a `Set[String]`, a `Set[Int]` , etc., but it must be a set of something.

## Functional queues

A functional queue is a data structure with three operations:

* `head`: returns the first element of the queue
* `tail`: returns a queue without its first element
* `enqueue`: returns a new queue with a given element appended at the end

Unlike a mutable queue, a functional queue does not change its contents when an element is appended. Instead, a new queue is returned that contains the element.

In Java, you can hide a constructor by making it `private`. In Scala, the primary constructor does not have an explicit definition; it is defined implicitly by the class parameters and body. Nevertheless, it is still possible to hide the primary constructor by adding a `private` modifier in front of the class parameter list:

```scala
class Queue[T] private (
  private val leading: List[T],
  private val trailing: List[T]
)
```

A private constructor can be accessed only from within the class itself and its companion object.

## Variance

The Scala compiler will check any variance annotations you place on type parameters. For example, if you try to declare a type parameter to be covariant (by adding a `+`, e.g. `Queue[+T]`), but that could lead to potential runtime errors, your program won’t compile.

## Covariance

It is safe to assume that a type T is a subtype of a type U if you can substitute a value of type T wherever a value of type U is required. This is called the _Liskov Substitution Principle_.



# Chapter 20 - Abstract members

A member of a class or trait is abstract if the member does not have a complete definition in the class. Abstract members are intended to be implemented in subclasses of the class in which they are declared. But Scala goes beyond that and implements the idea in its full generality: besides methods, you can declare abstract fields and even abstract types as members of classes and traits.

The following trait declares one of each kind of abstract member: an abstract
type (`T`), method (`transform`), `val` (`initial`), and `var` (`current`):

```scala
trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}
```

## Type members

One reason to use a type member is to define a short, descriptive alias for a type whose real name is more verbose, or less obvious in meaning, than the alias. Such type members can help clarify the code of a class or trait. The other main use of type members is to declare abstract types that must be defined in subclasses.

## Abstract `val`s

Abstract `val`s sometimes play a role analogous to superclass parameters: they let you provide details in a subclass that are missing in a superclass. This is particularly important for traits, because traits don’t have a constructor to which you could pass parameters. So the usual notion of parameterizing a trait works via abstract `val`s that are implemented in subclasses.

## Refinement types

When a class inherits from another, the first class is said to be a _nominal_
subtype of the other one. It’s a _nominal_ subtype because each type has a _name_, and the names are explicitly declared to have a subtyping relationship. Scala additionally supports _structural_ subtyping, where you get a subtyping relationship simply because two types have compatible members. To get structural subtyping in Scala, use Scala’s _refinement types_.

In the definition below, the members in the curly braces further specify - or refine, if you will - the types of members from the base class.

```scala
Animal { type SuitableFood = Grass }

class Pasture {
  var animals: List[Animal { type SuitableFood = Grass }] = Nil
  // ...
}
```

## Enumerations

To create a new enumeration, you define an object that extends the class `scala.Enumeration`, as in the following example:



# Chapter 21 - Implicit Conversions and Parameters