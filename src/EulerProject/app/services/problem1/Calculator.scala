package services.problem1

import javax.inject.Singleton

@Singleton
class Calculator {
  def calculate(input: Input): Output = {
    ExecutedOutput(
      (1 until input.value)
        .filter(i => i % 3 == 0 || i % 5 == 0)
        .toList
    )
  }
}
