package services.problem2

import scala.collection.mutable

class Fibonacci {

  def get(n: Int): Int = {
    Fibonacci._cache.getOrElseUpdate(n, _calc(n))
  }

  private def _calc(n: Int): Int = {
    // 問題本文の「By starting with 1 and 2」に従い、一般的なフィボナッチ数の計算と異なる（n=2の時、一般的には1を返す）
    n match {
      case 0 => 0
      case 1 => 1
      case 2 => 2
      case _ => get(n - 2) + get(n - 1)
    }
  }
}

object Fibonacci {
  private val _cache = mutable.Map[Int, Int]()
}
