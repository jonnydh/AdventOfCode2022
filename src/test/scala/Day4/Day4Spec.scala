package Day4
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class Day4Spec extends AnyWordSpec {
  "Day4" when {
    "findFullOverlaps of a file with 2 ranges on each line" should {
      "return the number of lines in which one range overlaps the other fully" in {
        Day4.countFullOverlaps(Source.fromFile("src/main/scala/Day4/testInput.txt")) mustBe 2
      }
    }

    "findAnyOverlaps of a file with 2 ranges on each line" should {
      "return the number of lines in which oen range overlaps the other" in {
        Day4.countAnyOverlaps(Source.fromFile("src/main/scala/Day4/testInput.txt")) mustBe 4

      }
    }
  }




}

