package Day5

import scala.io.{BufferedSource, Source}

object Day5 extends App {

  def part1(file: BufferedSource) = {
    val parts = file.mkString.split("\n\n")
    val instructionsPerLine = parseInstructions(parts(1))
    val columnsAndCrates = parseColumnsAndCrates(parts(0))

    extractResult(performMoves(instructionsPerLine, columnsAndCrates))
  }

  def extractResult(finalStacks: Map[Int, Seq[String]]): String =
    finalStacks
      .mapValues(_.last)
      .toSeq
      .sortBy(_._1)
      .map(_._2)
      .map(s => s(1)).mkString

  def performMoves(moves: Seq[Seq[String]], colsAndCrates: Map[Int, Seq[String]]):  Map[Int, Seq[String]] = {
    moves.headOption match {
      case None       => colsAndCrates
      case Some(m)    => performMoves(moves.tail, move(colsAndCrates, m(0).toInt, m(1).toInt, m(2).toInt))
    }
  }

  def move(colsAndCrates: Map[Int, Seq[String]], amount: Int, from: Int, to: Int): Map[Int, Seq[String]]= {
    val toMove = colsAndCrates(from).takeRight(amount).reverse     //Remove `.reverse` for part 2
    colsAndCrates.map{
      case (k,v) if (k == to)   => (k, v ++ toMove)
      case (k,v) if (k == from) => (k, v.dropRight(amount))
      case (k,v)                => (k,v)
    }
  }

  def parseInstructions(instruc: String): Seq[Seq[String]] =
    instruc
      .split("\n")
      .map(_.split((" ")).toSeq.filter(_.toDoubleOption.nonEmpty))
      .toSeq

  def parseColumnsAndCrates(str: String): Map[Int, Seq[String]] = {
      val cratesAsRows = str.split("\n").map(row => row.sliding(3, 4).toSeq).reverse.toSeq
      val columns = cratesAsRows.head.map(_.replaceAll("\\s", "").toInt)
      columns.map(num => num -> cratesAsRows.tail.flatMap(row => row.lift(num - 1)).filterNot(_.equals("   "))).toMap
  }

  println(part1(Source.fromFile("src/main/scala/Day5/input.txt")))

}
