package Day3

import scala.io.{BufferedSource, Source}

object Day3 extends App {
  lazy val chars: Map[Char, Int] =
    ('a' to 'z').zipWithIndex.map{case (c, i) => (c, i+1) }.toMap ++
      ('A' to 'Z').zipWithIndex.map{case (c, i) => (c, i+27) }.toMap


  def part1(rucksacks: BufferedSource): Int =
    rucksacks.getLines().map(rs => findCommonItemScore(rs.splitAt(rs.length/2))).sum

  def findCommonItemScore(comps: (String, String)): Int = {
    chars(comps._1.toSet.intersect(comps._2.toSet).head)
  }

  def part2(rucksacks: BufferedSource): Int =
    rucksacks.getLines().map(_.toSet).sliding(3, 3).map(grp => findCommonItemScore2(grp)).sum

  def findCommonItemScore2(group: Seq[Set[Char]]): Int =
    chars(group.head.intersect(group(1)).intersect(group(2)).head)

  println(s"Part 1: " + part1(Source.fromFile("src/main/scala/Day3/input.txt")))
  println(s"Part 2: " + part2(Source.fromFile("src/main/scala/Day3/input.txt")))
}
