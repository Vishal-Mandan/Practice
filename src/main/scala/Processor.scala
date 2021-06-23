import java.io.PrintWriter
import java.nio.file.Paths

import scala.io.Source

object Processor extends App {

  def process(fileName: String) {
    val fileSource = Source.fromFile(Paths.get("src\\main\\scala\\" + fileName).toFile)
    val lines: Seq[String] = fileSource.getLines().toSeq
    val writer = new PrintWriter("output.txt")


    val opString = lines.map {
      line =>
        val transformedLine = line.split(" ").map {
          word =>
            val firstChar = word.charAt(0)
            if (firstChar.isLower) word.replace(firstChar, firstChar.toUpper) else firstChar
        }.mkString(" ")
        writer.write(transformedLine)
    }

    writer.close()
  }

  //  val outputFile= new File(Paths.get("src\\main\\scala\\output.txt"))

  process("test1.txt")
}
