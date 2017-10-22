abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
case class Multiple(mult: Int, items: Item*) extends Item

def price(it: Item): Double = it match {
  case Article(_, p) => p
  case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
  case Multiple(mult, its @ _*) => its.map(price _).sum * mult
}

println(price(Multiple(10, Article("Blackwell Toaster", 29.95))))
println(price(Multiple(10, Bundle("Black Friday", 10, Article("Blackwell Toaster", 29.95), Article("Whiterock Blender", 19.90)))))