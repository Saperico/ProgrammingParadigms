package Labs.List7

import scala.annotation.tailrec

object Ex1Scala {
  def split[A](list: List[A]): (List[A], List[A]) = {
    @tailrec def splitRec[A](list: List[A], odd: List[A], even: List[A]): (List[A], List[A]) = {
      list match {
        case Nil => (odd.reverse, even.reverse)
        case head :: tail =>
          tail match {
            case Nil => splitRec(Nil, head :: odd, even)
            case _ => splitRec(tail.tail, head :: odd, tail.head :: even)
          }
      }
    }
    splitRec(list, Nil, Nil)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6)
    val (odd, even) = split(list)
    println(odd)//List(1, 3, 5)
    println(even)//List(2, 4, 6)
    val list2 = List(5, 6, 3, 2, 1)
    val (odd2, even2) = split(list2)
    println(odd2)//List(5, 3, 1)
    println(even2)//List(6, 2)
  }
}
