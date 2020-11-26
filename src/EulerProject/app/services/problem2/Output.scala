package services.problem2

trait Output {
  def values(): Seq[Int]

  def sum(): Int = values().sum
}

case class ExecutedOutput(values: Seq[Int]) extends Output

case class NoOutput() extends Output {
  override def values(): Seq[Int] = Nil
}
