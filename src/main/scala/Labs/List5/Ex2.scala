package Labs.List5

object Ex2 {
  def odd(k: Int): LazyList[Int] = {
    def oddHelper(k: Int): LazyList[Int] = {
      if (k % 2 == 0) oddHelper(k + 1)
      else LazyList.cons(k, oddHelper(k + 2))
    }
    oddHelper(k)
  }

  def main(args: Array[String]): Unit = {
    println(odd(12).take(5))//LazyList(<not computed>)
    println(odd(-12).take(5).toList)//List(-11,-9, -7, -5, -3)
  }

}
