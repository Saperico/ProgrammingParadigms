package Labs.List7

import scala.annotation.tailrec

object Ex3 {
  def generateOddNumbers(k:Int , n: Int): List[Int] = {
    if(n<=0) List()
    @tailrec def helper(k: Int, n: Int, acc: List[Int]): List[Int] = {
      if (n == 0) acc
      else if (k % 2 == 0) helper(k + 1, n, acc)
      else helper(k + 2, n - 1, acc :+ k)
    }
    helper(k, n, List())
  }

  def generateOddNumbersImperative(k: Int, n: Int): Array[Int] = {
    if(n<=0) Array[Int](0)
    val arr = new Array[Int](n)
    var i = 0
    var j = k
    if(j % 2 == 0) j += 1
    while (i < n) {
      arr(i) = j
      j += 2
      i += 1
    }
    arr
  }

  def main(args: Array[String]): Unit = {
    println(generateOddNumbers(3, 5)) // => List(3, 5, 7, 9, 11)
    println(generateOddNumbers(4, 5)) // => List(5, 7, 9, 11, 13)
    println(generateOddNumbersImperative(3, 5).mkString(", ")) // => 3, 5, 7, 9, 11
    println(generateOddNumbersImperative(4, 5).mkString(", ")) // => 5, 7, 9, 11, 13
  }

}
