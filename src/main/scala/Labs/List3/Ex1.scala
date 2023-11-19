package Labs.List3

import scala.annotation.tailrec

object Ex1 {
  
  def splitListEvenOdd(list: List[Int]): (List[Int], List[Int]) = {
    list match {
      case Nil => (Nil, Nil)
      case head :: tail => {
        val (even, odd) = splitListEvenOdd(tail)
        if (head % 2 == 0) (head*head :: even, odd)
        else (even, 3*head :: odd)
      }
    }
  }

  def splitListEvenOdd2(list: List[Int]): (List[Int], List[Int]) = {
    @tailrec def splitListEvenOdd2(list: List[Int], even: List[Int], odd: List[Int]): (List[Int], List[Int]) = {
      list match {
        case Nil => (even, odd)
        case head :: tail => {
          if (head % 2 == 0) splitListEvenOdd2(tail, head*head :: even, odd)
          else splitListEvenOdd2(tail, even, 3*head :: odd)
        }
      }
    }
    val (even,odd) = splitListEvenOdd2(list, Nil, Nil)
    (even.reverse, odd.reverse)
  }

  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5)
    println(splitListEvenOdd(list1))//(List(4, 16),List(3,9,15))
    println(splitListEvenOdd2(list1)) // -||-
    val list2 = List(2, 4, 6, 8, 10)
    println(splitListEvenOdd(list2))//(List(4, 16, 36, 64, 100),List())
    println(splitListEvenOdd2(list2))// -||-
    val list3 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
    println(splitListEvenOdd(list3)) //(List(4, 16, 36, 64),List(3,9,15,21,27))
    println(splitListEvenOdd2(list3))//-||-

  }
}
