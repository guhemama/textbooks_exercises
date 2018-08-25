import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{ Failure, Success }

val future = Future {
  (1 to 1000).filter(math.sqrt(_) % 1 == 0)
}

val str = future.map(_.mkString(","))

str onComplete {
  case Success(x) => println(x)
  case Failure(e) => e.printStackTrace()
}