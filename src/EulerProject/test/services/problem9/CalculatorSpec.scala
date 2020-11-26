package services.problem9

import javax.inject.Inject
import play.api.test.PlaySpecification

class CalculatorSpec @Inject()(calculator: Calculator)
  extends PlaySpecification {

  "Problem9" should {

    "Find Special Pythagorean triplet." in {
      def assert(sum: Int, expected: Seq[Output]): Boolean = {
        val actual = calculator.calculate(sum)
        actual must_== expected
      }

      assert(sum = 10, Seq())
      assert(sum = 12, Seq(Output(3, 4, 5)))
    }

    "Pythagoras Checker is working." in {
      def assert(a: Int, b: Int, c: Int, expected: Boolean): Boolean = {
        val actual = calculator.isPythagoras(a, b, c)
        actual must_== expected
      }

      assert(a = 3, b = 4, c = 5, expected = true)
      assert(a = 3, b = 4, c = 6, expected = false)
      assert(a = 65, b = 72, c = 97, expected = true)
    }
  }
}
