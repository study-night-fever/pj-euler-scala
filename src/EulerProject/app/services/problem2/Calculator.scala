package services.problem2

import javax.inject.{Inject, Singleton}

import scala.annotation.tailrec

@Singleton
class Calculator @Inject()(fibonacci: Fibonacci) {
  def calculate(input: Input): Output = {
    ExecutedOutput(
      listFibonacciNumbers(input.value).filter(_ % 2 == 0)
    )
  }

  def listFibonacciNumbers(maxValue: Int): Seq[Int] = {
    _search(n = 1, maxValue, result = Seq())
  }

  @tailrec
  final def _search(n: Int, maxValue: Int, result: Seq[Int]): Seq[Int] = {
    val value = fibonacci.get(n)
    if (value > maxValue) {
      return result
    }
    _search(n + 1, maxValue, result ++ Seq(value))
  }
}
