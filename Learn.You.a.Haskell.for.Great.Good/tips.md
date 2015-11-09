:t in GHCi returns the expression type.

: cons operator
1:[2,3] => [1,2,3]

++ combine lists
[1,2] ++ [3,4] => [1,2,3,4]
"abc" ++ "def" => "abcdef"

!! get an element out of a list by index
"Hello" !! 1 => "e"


Eq   => typeclass for types that support equality testing.
Ord  => typeclass for types that have an ordering.
Show => presents a value whose type is a member of Show and presents it as a string.
        show 5 = "5" :: String
Read => takes a string and returns a type which is a member of Read. You must tell the compiler what to do.
        read "10" + 2 = 12
        (read "5" :: Double) = 5.0
Enum => typeclass for sequentially ordered types. It also has defined successors (succ) and predecessors (pred).
Num => typeclass for things that act like numbers.
Floating, Integral


`let` bindings are expressions themselves. You can put them almost anywhere and
use them to create functions in a local scope. You can pattern match them
(let (a,b,c) = (1,2,3) in a + b + c) * 100 => 600

Case expressions are expressions, doh!
case expr of pattern -> result
             pattern -> result
             pattern -> result


High order functions: functions that take other functions as parameters and return
functions as return values.

In Haskell, all functions take (officially) only one parameter. The ones that accept
severla parameters are called curried functions.


map: it takes a function and a list and applies that function to every element in the list, producing a new list.
filter: it takes a predicate and a list and then returns the list of elements that satisfy the predicate.


To make a lambda, we write a \ and then we write the parameters, separated by spaces.
After that comes a -> and then the function body. We usually surround them by parentheses,
because otherwise they extend all the way to the right.

Filter all numbers bigger than 15:
  filter (\x -> x > 15) [1..100]


Folds reduce a list to some single value. A fold takes a binary function, a
tarting value and a list to fold up.

  foldl: it folds the list up from the left side.
  foldr: similar to foldl, only the accumulator eats up the values from the right.

Folds can be used to implement any function where you traverse a list once,
element by element, and then return something based on that. Whenever you want
to traverse a list to return something, chances are you want a fold.


$ function: it's a convenience function so that we don't have to write so many
parentheses. Function application with a space is left-associative (so f a b c is the same as ((f a) b) c)),
function application with $ is right-associative.

  sum (map sqrt [1..130])

Is the same as:

  sum $ map sqrt [1..130]


Function composition is done with the **.** function. It is right-associative,
so we can compose many functions at a time. To use functions that take several,
we usually have to partially apply them just so much that each function takes
just one parameter.

In math, we do composition like this:
  (f . g)(x) = f(g(x))

Negate the numbers in a list:
  ghci> map (negate . abs) [1,2,3]
  [-1,-2,-3]


To import a module, use `import Package.Name`
To import only certain functios, use `import Package.Name (fn1, fn2, fn3)`
To import all functions but some, use `import Package.Name hiding (fn1, fn2)`

You can also import modules using their full qualified names `import qualified Data.Map`
To use the `filter` function, we'd call it as `Data.Map.filter`


## Data.List

`intercalate` takes a list of lists and a list. It then inserts that list in between all those lists and then flattens the result.
ghci> intercalate " " ["hey","there","guys"]
"hey there guys"

`foldl'` and `foldl1'` are stricter versions of their respective lazy incarnations.

`concat` flattens a list of lists into just a list of elements.
ghci> concat ["foo","bar","car"]
"foobarcar"
ghci> concat [[3,4,5],[2,3,4],[2,1,1]]
[3,4,5,2,3,4,2,1,1]

`concatMap` is the same as first mapping a function to a list and then concatenating the list with concat.
ghci> concatMap (replicate 4) [1..3]
[1,1,1,1,2,2,2,2,3,3,3,3]

`and` takes a list of boolean values and returns True only if all the values in the list are True.
ghci> and $ map (>4) [5,6,7,8]
True
ghci> and $ map (==4) [4,4,4,3,4]
False

`or` is like `and`, only it returns True if any of the boolean values in a list is True.
ghci> or $ map (==4) [2,3,4,5,6,1]
True
ghci> or $ map (>4) [1,2,3]
False

`any` and `all` take a predicate and then check if any or all the elements in a list
satisfy the predicate, respectively. Usually we use these two functions instead
of mapping over a list and then doing nd or or.
ghci> any (==4) [2,3,5,6,1,4]
True

`splitAt` takes a number and a list. It then splits the list at that many elements,
returning the resulting two lists in a tuple.
ghci> splitAt 3 "heyman"
("hey","man")

`takeWhile` is a really useful little function. It takes elements from a list
while the predicate holds and then when an element is encountered that doesn't
satisfy the predicate, it's cut off. It turns out this is very useful.
ghci> takeWhile (>3) [6,5,4,3,2,1,2,3,4,5,4,3,2,1]
[6,5,4]
ghci> takeWhile (/=' ') "This is a sentence"
"This"

`dropWhile` is similar, only it drops all the elements while the predicate is true.

`sort` simply sorts a list. The type of the elements in the list has to be part
of the Ord typeclass.
ghci> sort [8,5,3,2,1,6,4,2]
[1,2,2,3,4,5,6,8]

`inits` and `tails` are like init and tail, only they recursively apply that to a
list until there's nothing left.
ghci> inits "w00t"
["","w","w0","w00","w00t"]
ghci> tails "w00t"
["w00t","00t","0t","t",""]

`find` takes a list and a predicate and returns the first element that satisfies
the predicate. It returns a **Maybe** value.
ghci> find (>4) [1,2,3,4,5,6]
Just 5
ghci> find (>9) [1,2,3,4,5,6]
Nothing

`findIndex` is like find, but it maybe returns the index of the first element that satisfies the predicate.
`findIndices` returns the indices of all elements that satisfy the predicate in the form of a list.

`lines` takes a string and returns every line of that string in a separate list.

`words` and `unwords` are for splitting a line of text into words or joining a
list of words into a text. Very useful.
ghci> words "hey these are the words in this sentence"
["hey","these","are","the","words","in","this","sentence"]

`delete` takes an element and a list and deletes the first occurence of that
element in the list.

`insert` takes an element and a list of elements that can be sorted and inserts
it into the last position where it's still less than or equal to the next element.


## Data.Char

It exports a bunch of predicates over characters. That is, functions that take
a character and tell us whether some assumption about it is true or false.

`isControl`
`isSpace`
`isLower`
`isUpper`
`isAlpha`
`isAlphaNum`
`isPrint`
`isDigit`
`isOctDigit`
`isHexDigit`
`isLetter`
`isMark`
`isNumber`
`isPunctuation`
`isSymbol`
`isSeparator`
`isAscii`
`isLatin1`
`isAsciiUpper`
`isAsciiLower`

`toUpper`
`toLower`
`toTitle`
`digitToInt`

`intToDigit`

`ord`
`chr`
These functions convert characters to their corresponding numbers and vice versa.


## Data.Map
A qualified import is required because of name clashes with Prelude.
`import qualified Data.Map as Map`

`fromList` takes an association list (in the form of a list) and returns
a map with the same associations.
ghci> Map.fromList [("betty","555-2938"),("bonnie","452-2928"),("lucille","205-2928")]
fromList [("betty","555-2938"),("bonnie","452-2928"),("lucille","205-2928")]

`empty` represents an empty map. It takes no arguments, it just returns an empty map.
ghci> Map.empty
fromList []

`insert` takes a key, a value and a map and returns a new map that's just like
the old one, only with the key and value inserted.

`null` checks if a map is empty.

`size` reports the size of a map.

`lookup` works like the Data.List lookup, only it operates on maps. It
returns Just something if it finds something for the key and Nothing if it doesn't.

`member` is a predicate takes a key and a map and reports whether the key is in the map or not.

`map` and `filter` work much like their list equivalents.

`toList` is the inverse of fromList.

`keys` and elems return lists of keys and values respectively.


## Data.Set
Sets are kind of like a cross between lists and maps. All the elements in a set
are unique.
`import qualified Data.Set as Set`

`fromList`
`null`
`size`
`member`
`empty`
`singleton`
`insert`
`delete`
`map`
`filter`
`toList`


# Creating a module
We say that a module exports functions. What that means is that when I import a
module, I can use the functions that it exports.

At the beginning of a module, we specify the module name. If we have a file called
Geometry.hs, then we should name our module Geometry. Then, we specify the functions
that it exports and after that, we can start writing the functions.

  module Geometry
  ( sphereVolume
  , sphereArea
  , cubeVolume
  , cubeArea
  , cuboidArea
  , cuboidVolume
  ) where

To use our module, we just do:

  import Geometry

Geometry.hs has to be in the same folder that the program that's importing it is
in, though. Modules can also be given a hierarchical structures.


# Making Our Own Types and Typeclasses
To define a new type, use the `data` keyword.

  data Bool = False | True
  data Int = -2147483648 | -2147483647 | ... | -1 | 0 | 1 | 2 | ... | 2147483647
  data Shape = Circle Float Float Float | Rectangle Float Float Float Float

The Circle value constructor has three fields, which take floats. The Rectangle
value constructor has four fields which accept floats.

  surface :: Shape -> Float
  surface (Circle _ _ r) = pi * r ^ 2
  surface (Rectangle x1 y1 x2 y2) = (abs $ x2 - x1) * (abs $ y2 - y1)

  ghci> surface $ Circle 10 20 10
  314.15927

Haskell doesn't know how to display our data type as a string (yet). When we try
to print a value out in the prompt, Haskell first runs the show function to get
the string representation of our value and then it prints that out to the terminal.
To make our Shape type part of the Show typeclass, we modify it like this:

  data Shape = Circle Float Float Float | Rectangle Float Float Float Float deriving (Show)

If we wanted to export the functions and types that we defined here in a module, we could start it off like this:

  module Shapes
  ( Point(..)
  , Shape(..)
  , surface
  , nudge
  , baseCircle
  , baseRect
  ) where

By doing Shape(..), we exported all the value constructors for Shape, so that
means that whoever imports our module can make shapes by using the Rectangle and
Circle value constructors. It's the same as writing Shape (Rectangle, Circle).

Another way of defining data types:

  data Person = Person { firstName :: String
                     , lastName :: String
                     , age :: Int
                     , height :: Float
                     , phoneNumber :: String
                     , flavor :: String
                     } deriving (Show)

The main benefit of this is that it creates functions that lookup fields in the
data type. By using record syntax to create this data type, Haskell automatically
made these functions: firstName, lastName, age, height, phoneNumber and flavor.

The [Char] and String types are equivalent and interchangeable. That's implemented
with type synonyms. Type synonyms don't really do anything per se, they're just
about giving some types different names so that they make more sense to someone
reading our code and documentation. Here's how the standard library defines
String as a synonym for [Char].

  type String = [Char]

Typeclasses are like interfaces. A typeclass defines some behavior (like comparing
for equality, comparing for ordering, enumeration) and then types that can behave
in that way are made instances of that typeclass. The behavior of typeclasses
is achieved by defining functions or just type declarations that we then implement.
So when we say that a type is an instance of a typeclass, we mean that we can
use the functions that the typeclass defines with that type.



# Input and output
We glue statements together with the `do` syntax.

  main = do
      putStrLn "Hello, what's your name?"
      name <- getLine
      putStrLn ("Hey " ++ name ++ ", you rock!")

Every I/O action that gets performed has a result encapsulated within it. Except
for the last line, every line in a do block that doesn't bind can also be
written with a bind.

`return ()` make IO actions that don't really do anything except have an
encapsulated result that is thrown away because it's not bound to a name.


## Common IO functions
`putStr`
`putChar`
`print` = `putStrLn . show` (prints anything that is an instance of Show)
`getChar`
`when`
`sequence` (takes a list of IO actions)
`mapM`
`mapM_`
`forever` (repeats the IO action forever)
`forM`


## Files and streams
