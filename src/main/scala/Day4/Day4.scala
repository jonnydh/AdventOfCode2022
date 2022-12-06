package Day4

import scala.io.{BufferedSource, Source}

object Day4 extends App{

  def countFullOverlaps(pairs: BufferedSource): Int = parseToRange(pairs)
      .count(line => line.head.intersect(line.last) == line.head || line.head.intersect(line.last) == line.last)

  def countAnyOverlaps(pairs: BufferedSource): Int = parseToRange(pairs)
    .count(line => line.head.intersect(line.last).nonEmpty)

  def parseToRange(input: BufferedSource): Iterator[Array[Range.Inclusive]] =
    input.getLines().map(_.split(",").map(s => s.split("-")(0).toInt to s.split("-")(1).toInt))

  println(s"Part 1: " + countFullOverlaps(Source.fromFile("src/main/Scala/Day4/input.txt")))
  println(s"Part 2: " + countAnyOverlaps(Source.fromFile("src/main/Scala/Day4/input.txt")))

}

