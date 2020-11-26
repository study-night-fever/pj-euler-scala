package services.problem2

import javax.inject.Inject
import play.api.test.PlaySpecification

class CalculatorSpec @Inject()(calculator: Calculator)
  extends PlaySpecification {

  "Problem2" should {

    "Even Fibonacci numbers" in {
      def assert(maxValue: Int, expected: Seq[Int]): Boolean = {
        val actual = calculator.calculate(Input(maxValue))
        actual.values() must_== expected.filter(_ % 2 == 0)
        actual.sum() must_== expected.filter(_ % 2 == 0).sum
      }

      assert(1, Seq(1))
      assert(10, Seq(1, 2, 3, 5, 8))
      assert(100, Seq(1, 2, 3, 5, 8, 13, 21, 34, 55, 89))
    }
  }
}
