package services.problem9

import javax.inject.Singleton

@Singleton
case class Calculator() {

  def calculate(sum: Int): Seq[Output] = {
    val outputs = {
      for {
        c <- Math.ceil(sum / 3).toInt to (sum - 3)
        b <- Math.ceil((sum - c) / 2).toInt until (sum - c)
        a <- 1 to sum - c - b
        if a < b && b < c && a < c && a + b + c == sum && isPythagoras(a, b, c)
      } yield Output(a, b, c)
    }

    if (outputs.isEmpty) Seq.empty[Output] else outputs
  }

  /**
   * 3辺がピタゴラスの定理を満たすかどうか
   */
  def isPythagoras(a: Int, b: Int, c: Int): Boolean =
    Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)

}
