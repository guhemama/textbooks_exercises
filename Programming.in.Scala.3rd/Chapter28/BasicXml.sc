abstract class CCTherm {
  val description: String
  val yearMade: Int
  val dateObtained: String
  val bookPrice: Int // in US cents
  val purchasePrice: Int // in US cents
  val condition: Int // 1 to 10
  override def toString = description

  // To convert instances of this class to XML, simply add a toXML method
  // that uses XML literals and brace escapes.
  def toXML =
    <cctherm>
    <description>{description}</description>
    <yearMade>{yearMade}</yearMade>
    <dateObtained>{dateObtained}</dateObtained>
    <bookPrice>{bookPrice}</bookPrice>
    <purchasePrice>{purchasePrice}</purchasePrice>
    <condition>{condition}</condition>
    </cctherm>

  // You can parse back a CCTherm instance by using the following code:
  def fromXML(node: scala.xml.Node): CCTherm =
    new CCTherm {
      val description = (node \ "description").text
      val yearMade = (node \ "yearMade").text.toInt
      val dateObtained = (node \ "dateObtained").text
      val bookPrice = (node \ "bookPrice").text.toInt
      val purchasePrice = (node \ "purchasePrice").text.toInt
      val condition = (node \ "condition").text.toInt
    }
}

val therm = new CCTherm {
  val description = "hot dog #5"
  val yearMade = 1952
  val dateObtained = "March 14, 2006"
  val bookPrice = 2199
  val purchasePrice = 500
  val condition = 9
}

println(therm.toXML)
println(therm.toXML \ "bookPrice")        // <bookPrice>2199</bookPrice>
println((therm.toXML \ "bookPrice").text) // 2199