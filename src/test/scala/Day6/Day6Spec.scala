package Day6

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper


class Day6Spec extends AnyWordSpec{
  "Day 6" when {
    "findStartOfPacket" should {
      "find the index + 1 of the character AFTER the first sequence of 4 unique chars" in {
        Day6.findFirstPosAfterUniqueSequence("bvwbjplbgvbhsrlpgdmjqwftvncz", 4) mustBe 5
        Day6.findFirstPosAfterUniqueSequence("nppdvjthqldpwncqszvftbrmjlhg", 4) mustBe 6
        Day6.findFirstPosAfterUniqueSequence("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg", 4) mustBe 10
        Day6.findFirstPosAfterUniqueSequence("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw", 4) mustBe 11
      }
    }
  }

}
