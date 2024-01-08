package Labs.List4

import scala.annotation.tailrec

object Ex1 {
  def decode(list: List[(Int, String)]): List[String] = {
    @tailrec def helper(list: List[(Int, String)], acc: List[String]): List[String] = {
      list match {
        case Nil => acc
        case head :: tail => {
          val (number, element) = head
          def fill(number: Int, element: String): List[String] = {
            if (number == 0) List()
            else element :: fill(number - 1, element)
          }
          helper(tail, acc ::: fill(number, element))
        }
      }
    }
    helper(list, List())
  }

  def decodeWithoutTailRec(list: List[(Int, String)]): List[String] = {
    list match {
      case Nil => List()
      case head :: tail => {
        val (number, element) = head
        def fill(number: Int, element: String): List[String] = {
          if (number == 0) List()
          else element :: fill(number - 1, element)
        }
        fill(number, element) ::: decodeWithoutTailRec(tail)
      }
    }
  }
  def main(args: Array[String]): Unit = {
    val list = List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    println(decode(list))     //List(a, a, a, a, b, c, c, a, a, d, e, e, e, e)
    println(decodeWithoutTailRec(list))  //List(a, a, a, a, b, c, c, a, a, d, e, e, e, e)
  }
}
