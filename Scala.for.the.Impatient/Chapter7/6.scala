import java.util.{HashMap => JavaHashMap}
import scala.collection.mutable._

object Ex6 extends App {
  val jm = new JavaHashMap[String, String]()
  jm.put("1", "foo")
  jm.put("2", "bar")

  val sm = HashMap[String, String]()
  val it = jm.entrySet().iterator()

  while (it.hasNext()) {
    val pair = it.next()

    sm += (pair.getKey() -> pair.getValue())
  }

  sm.foreach(println)
}