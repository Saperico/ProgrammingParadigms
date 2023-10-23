package List2

object List2 {

  def sumList(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: tail => if (head % 2 == 1) head + sumList(tail) else sumList(tail)
    }
  }

  def connectStrings(listOfString: List[String], separator: String): String = {
    listOfString match {
      case Nil => ""
      case head :: Nil => head
      case head :: tail => head + separator + connectStrings(tail, separator)
    }
  }

  def countOccurrences(list: List[Int], element: Int): Int = {
    list match {
      case Nil => 0
      case head :: tail => if (head == element) 1 + countOccurrences(tail, element) else countOccurrences(tail, element)
    }
  }

  def fibonacci(n: Int): Int = {
    n match {
      case 0 => 0
      case 1 => 1
      case _ => fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  def main(args: Array[String]): Unit = {
    println(sumList(List(1,2,3,4,5,6,7,8,9,10)))
    println(connectStrings(List("a","b","c","d","e","f","g","h","i","j"), " "))
    println(countOccurrences(List(1,2,3,4,5,6,5,8,9,5), 5))
    println(fibonacci(10))
  }

}
