package Day3

import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class Day3Spec extends AnyWordSpec{

  "findCommonItem" when {
    "given a list of items across both compartments" should {
      "find the item common to both compartments and return its score" in {
          Day3.findCommonItemScore("vJrwpWtwJgWr", "hcsFMMfFFhFp") mustBe 16
          Day3.findCommonItemScore("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL") mustBe 38
        }
      }
    }

  "part1" when {
    "given a file containing an item list on each line" should {
      "return the total sum of common item scores" in {
        Day3.part1(Source.fromFile("src/main/scala/Day3/testinput.txt")) mustBe 157
      }
    }
  }

  "part2" when {
    "given a file containing each backpack on a new line" should {
      "return the total score of the common badge in each group" in {
        Day3.part2(Source.fromFile("src/main/scala/Day3/testinput.txt")) mustBe 70
      }
    }
  }

}
