package Day2

import scala.io.{BufferedSource, Source}

object Day2 extends App{
  lazy val moveValue = Map("X" -> 1, "Y" -> 2, "Z" -> 3)

  def rockPaperScissors(file: BufferedSource): Int =
    file.getLines().toSeq.foldLeft(0)((acc, cur) =>
      acc + getScorePerRound(cur.split(" ")(0), cur.split(" ")(1))
    )

  def getScorePerRound(oppMove: String, yourMove: String): Int = {
    val getRoundResult: Map[String, Map[String, Int]] =
      Map(
        "A" -> Map("X" -> 3, "Y" -> 6, "Z" -> 0),
        "B" -> Map("Y" -> 3, "X" -> 0, "Z" -> 6),
        "C" -> Map("Z" -> 3, "X" -> 6, "Y" -> 0)
      )
    moveValue(yourMove) + getRoundResult(oppMove)(yourMove)
  }

  def rockPaperScissors2(file: BufferedSource): Int =
    file.getLines().toSeq.foldLeft(0)((acc, cur) =>
      acc + getScorePerRound2(cur.split(" ")(0), cur.split(" ")(1))
    )

  def getScorePerRound2(oppMove: String, desiredRes: String): Int = {
    val desiredScore = Map("X" -> 0, "Y" -> 3, "Z" -> 6)
    val chooseMove: Map[Int, Map[String, String]] =
      Map(
        0 -> Map("A" -> "Z", "B" -> "X", "C" -> "Y"),
        3 -> Map("A" -> "X", "B" -> "Y", "C" -> "Z"),
        6 -> Map("A" -> "Y", "B" -> "Z", "C" -> "X")
      )

    val desScore = desiredScore(desiredRes)
    val moveVal = moveValue(chooseMove(desiredScore(desiredRes))(oppMove))

    desScore + moveVal
  }

  println(rockPaperScissors(Source.fromFile("src/main/scala/Day2/input.txt")))
  println(rockPaperScissors2(Source.fromFile("src/main/scala/Day2/input.txt")))
}


