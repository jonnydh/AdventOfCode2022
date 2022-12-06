package Day6

import scala.io.{BufferedSource, Source}

object Day6 extends App {

  def findFirstPosAfterUniqueSequence(msg: String, size: Int): Int = msg
    .sliding(size)
    .toSeq
    .zipWithIndex
    .filter{case (chunk, _) => chunk.toSet.size == size }
    .head._2 + size

  def parseFile(): String =
    Source.fromFile("src/main/scala/Day6/input.txt").getLines().mkString

  println(findFirstPosAfterUniqueSequence(parseFile(), 4))
  println(findFirstPosAfterUniqueSequence(parseFile(), 14))
}
