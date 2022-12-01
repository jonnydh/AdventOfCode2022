package Day1

import scala.io.{BufferedSource, Source}

object Day1 extends App{
  def elfWithMostCalories(file: BufferedSource): Int =
    elfByCalories(file).max

  def elfByCalories(file: BufferedSource): Seq[Int] =
    file.getLines
      .mkString(" ")
      .split("  ")
      .toSeq
      .map(_.split(" ").map(_.toInt).sum)

  def sumOfTopThreeElfs(file: BufferedSource): Int =
    elfByCalories(file)
      .sortWith(_ > _)
      .take(3)
      .sum

  val part1 = Source.fromFile("src/main/scala/Day1/Input.txt")
  println(elfWithMostCalories(part1))

  val part2 = Source.fromFile("src/main/scala/Day1/Input.txt")
  println(sumOfTopThreeElfs(part2))

}
