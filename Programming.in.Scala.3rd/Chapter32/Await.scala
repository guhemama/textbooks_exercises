import scala.concurrent.Await
import scala.concurrent.duration._

val fut = Future { Thread.sleep(10000); 21 + 21 }
val x = Await.result(fut, 15.seconds) // blocks