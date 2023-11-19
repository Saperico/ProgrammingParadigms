package Labs.List4

object Ex2 {
  //Write a function that replicates items in a collection based on a second collection specifying the number of times items are to be duplicated.
  // Pay particular attention to the optimality of computational and memory complexity.
  //    example: multiplicate( List(1, 2, 3),List (0, 3, 1, 4)) gives the result List(2, 2, 2, 3)
  def multiplicate[A](list: List[A], multiplications: List[Int]): List[A] = {
    def multiplicateHelper[A](list: List[A], multiplications: List[Int], index: Int, acc: List[A]): List[A] = {
      if (index == list.length) acc
      else multiplicateHelper(list, multiplications, index + 1, acc ::: List.fill(multiplications(index))(list(index)))
    }
    multiplicateHelper(list, multiplications, 0, List())
  }

  def main(args: Array[String]): Unit = {
    println(multiplicate(List(1, 2, 5), List(2, 3, 2, 4)))
  }
}

