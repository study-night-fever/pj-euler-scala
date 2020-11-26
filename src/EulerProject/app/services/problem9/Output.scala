package services.problem9

case class Output(a: Int, b: Int, c: Int) {
  def sum(): Int = a + b + c

  def product(): Int = a * b * c
}
