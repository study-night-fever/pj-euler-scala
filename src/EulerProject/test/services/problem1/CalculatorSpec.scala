package services.problem1

import javax.inject.Inject
import org.specs2.matcher.Scope
import play.api.test._

class CalculatorSpec @Inject()(calculator: Calculator)
  extends PlaySpecification {

  "Problem1" should {
    trait Initialize {
      // do nothing.
    }

    "Multiples of 3 and 5" in new Scope with Initialize {
      val result = calculator.calculate(Input(10))
      result.values() must_== Seq(3, 5, 6, 9)
      result.sum() must_== 23
    }

  }
}
