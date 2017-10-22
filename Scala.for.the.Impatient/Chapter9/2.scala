import scala.io.Source
import java.io._

val filename = "tabs.txt"
val lines = Source.fromFile(filename).getLines
val spacedLines = lines.map(_.replace("\t", " "))
val out = new PrintWriter(new File("tabs_out.txt" ))
out.write(spacedLines.mkString("\n"))
out.close
