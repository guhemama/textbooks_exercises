import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.Await
import scala.util.{ Success, Failure }

// Async future
val f1: Future[Double] = Future { math.sqrt(1000000000) }

f1 onComplete {
  case Success(n) => println(s"The result is $n")
  case Failure(t) => println("Error: " + t.getMessage)
}

// Block program until the future returns
val f2: Future[Double] = Future { math.pow(10, 5) }
val n: Double = Await.result(f2, 1 second)
println(s"F2 returned $n")