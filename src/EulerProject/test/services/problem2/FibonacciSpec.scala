package services.problem2

import javax.inject.Inject
import play.api.test.PlaySpecification

class FibonacciSpec @Inject()(fibonacci: Fibonacci)
  extends PlaySpecification {

  "Fibonacci" should {
    "F(0) = 0" in {
      fibonacci.get(0) must_== 0
    }

    "F(1) = 1" in {
      fibonacci.get(1) must_== 1
    }

    "F(2) = 2" in {
      fibonacci.get(2) must_== 2
    }

    "F(n) = F(n-2) + F(n-1)" in {
      val n = 100
      fibonacci.get(n) must_== fibonacci.get(n - 2) + fibonacci.get(n - 1)
    }
  }
}
