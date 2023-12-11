package Labs.List7

import scala.annotation.tailrec

object Ex2 {
  def mergeFunctionally(list1: List[Int], list2: List[Int]): List[Int] = {
    @tailrec def helper(list1: List[Int], list2: List[Int], result: List[Int]): List[Int] = {
      if (list1.isEmpty) result.reverse ::: list2
      else if (list2.isEmpty) result.reverse ::: list1
      else helper(list1.tail, list2.tail, list2.head :: list1.head :: result)
    }
    helper(list1, list2, List())
  }

  def mergeImperatively(list1: Array[Int], list2: Array[Int]): Array[Int] = {
    val result = new Array[Int](list1.length + list2.length)
    var shortList = list1
    var longList = list2
    if (list1.length > list2.length) {
      shortList = list2
      longList = list1
    }
    var i = 0
    while (i < shortList.length) {
      result(i * 2) = list1(i)
      result(i * 2 + 1) = list2(i)
      i += 1
    }
    while (i < longList.length) {
      result(i + shortList.length) = longList(i)
      i += 1
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, 4, 5)
    val list2 = List(6, 7, 8, 9, 10)
    println(mergeFunctionally(list1, list2))
    val array1 = Array(1, 2, 3, 4, 5)
    val array2 = Array(6, 7, 8, 9, 10)
    println(mergeImperatively(array1, array2).mkString(", "))
  }

}
