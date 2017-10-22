import java.io.PrintWriter
import scala.math.pow

val out = new PrintWriter("pow.txt")

(1 to 20).map(pow(2, _)).foreach(v => out.println(f"${v.toInt}%7d   " + 1 / v))

out.close