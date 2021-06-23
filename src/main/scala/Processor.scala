import java.nio.file.Paths

import scala.io.Source

object Processor extends App {
  def process(fileName: String) {
    val fileSource = Source.fromFile(Paths.get("src\\main\\scala\\" + fileName).toFile)
    val lines: Seq[String] = fileSource.getLines().toSeq


    val opString = lines.map {
      line =>
        line.split(" ").map {
          word =>
            val firstChar = word.charAt(0)
            if (firstChar.isLower) word.replace(firstChar, firstChar.toUpper) else firstChar
        }.mkString(" ")
    }

    println(opString)
  }

  process("test1.txt")
}
