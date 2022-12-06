package Day2

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class Day2Spec extends AnyWordSpec {
  "rockPaperScissors" when {
    "given a list of opponentMoves and recommendedMoves" should {
      "return the total score gained if the list is followed fully" in {
        val res = Day2.rockPaperScissors(Source.fromFile("src/main/scala/Day2/testInput.txt"))
        res mustBe 15
      }
    }
  }

  "rockPaperScissors " when {
    "given a list of opponentMoves and recommendedMoves" should {
      "return the total score gained if the list is followed fully" in {
        val res = Day2.rockPaperScissors2(Source.fromFile("src/main/scala/Day2/testInput.txt"))
        res mustBe 12
      }
    }
  }
}