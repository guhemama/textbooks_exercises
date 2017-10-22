import scala.collection.mutable.ArrayBuffer

abstract class Item {
  def price: Double
  def description: String
}

class SimpleItem(val price: Double, val description: String) extends Item

class Bundle extends Item {
  private var items = ArrayBuffer[Item]()

  def price = items.foldLeft(0.0)(_ + _.price)
  def description = items.map(_.description).mkString(", ")

  def addItem(item: Item): Unit = {
    items += item
  }
}

val i1 = new SimpleItem(10.80, "Sugar")
val i2 = new SimpleItem(5.79, "Flour")
val i3 = new SimpleItem(12.30, "Chocolate")

val cakeBundle = new Bundle()
cakeBundle.addItem(i1)
cakeBundle.addItem(i2)
cakeBundle.addItem(i3)

println(cakeBundle.price)
println(cakeBundle.description)