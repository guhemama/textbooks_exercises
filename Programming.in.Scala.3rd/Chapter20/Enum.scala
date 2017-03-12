object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value

  // It can also be written as
  // val Red, Green, Blue = Value
}

import Color._

// Use enum value
val color = Red
println(color)

// Print all colors
Color.values foreach println