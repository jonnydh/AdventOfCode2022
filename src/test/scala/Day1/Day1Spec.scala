package Day1

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class Day1Spec extends AnyWordSpec {
  "elfWithMostCalories" when {
    "given a list of calories sublists, seperated by empty lines" should {
      "return the total of the elf with the most calories" in {
        val res = Day1.elfWithMostCalories(Source.fromFile("src/main/scala/Day1/testInput.txt"))
        res mustBe 24000
      }
    }
  }

  "sumOfTopThreeElds" when {
    "given a list of calories sublists, seperated by empty lines" should {
      "return the total of the three elfs with the most calories" in {
        val res = Day1.sumOfTopThreeElfs(Source.fromFile("src/main/scala/Day1/testInput.txt"))
        res mustBe 45000
      }
    }
  }
}
