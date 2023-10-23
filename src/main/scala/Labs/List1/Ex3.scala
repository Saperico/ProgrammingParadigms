package Labs.List1

object Ex3 {
  def a(m: Int, n:Int): Int = {
    (m, n) match {
      case (0, _) => n+1
      case (_, 0) => a(m-1, 1)
      case _ => a(m-1, a(m, n-1))
    }
  }

  def main(args: Array[String]):Unit = {
    println(a(2, 3));
    println(a(3, 3));
    println(a(2, 4))
  }
}
