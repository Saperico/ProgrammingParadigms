package Labs.List2

import scala.annotation.tailrec
import scala.collection.immutable.Nil

object Ex3 {

  def sumLists(list1 : List[Int], list2: List[Int]) : List[Int] = {
    (list1, list2) match {
      case (Nil, Nil) => Nil
      case (Nil, _) => list2
      case (_, Nil) => list1
      case (h1 :: t1, h2 :: t2) => (h1 + h2) :: sumLists(t1, t2)
    }
  }

  def sumListsTailRecursion(list1 : List[Int], list2: List[Int]) : List[Int] = {
    sumListsTailRecursionHelper(list1, list2, Nil)
  }

  @tailrec
  def sumListsTailRecursionHelper(list1: List[Int], list2: List[Int], acc: List[Int]): List[Int] = {
    (list1, list2) match {
      case (Nil, Nil) => acc
      case (Nil, _) => acc ::: list2
      case (_, Nil) => acc ::: list1
      case (h1 :: t1, h2 :: t2) => sumListsTailRecursionHelper(t1, t2, acc ::: List(h1 + h2))
    }
  }

  def main(args: Array[String]): Unit = {
    var list1 = List(5,4,3,2)
    var list2 = List(1,2,3,4,5,6)
    println(sumLists(list1, list2)) //result: List(6, 6, 6, 6, 5, 6)
    println(sumListsTailRecursion(list1, list2))//result: List(6, 6, 6, 6, 5, 6)
    list1 = List(1,1,1,1,1,15)
    list2 = List(2,0,3,4,6)
    println(sumLists(list1, list2)) //result: List(3, 1, 4, 5, 7, 15)
    println(sumListsTailRecursion(list1, list2)) //result: List(3, 1, 4, 5, 7, 15)
  }
}
