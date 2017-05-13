import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

val fut = Future { Thread.sleep(10000); 21 + 21 }

// Returns whether the future has completed or not
fut.isCompleted

// Returns the future value if it has completed, otherwise it returns None
fut.value

// Using a Promise
val pro = Promise[Int]
