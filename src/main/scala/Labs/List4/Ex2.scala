package Labs.List4

object Ex2 {
  def multiplicate[A](list: List[A], multiplications: List[Int]): List[A] = {
    def multiplicateHelper[A](list: List[A], multiplications: List[Int], index: Int, acc: List[A]): List[A] = {
      if (index == list.length) acc
      else {
        def fill(number: Int, element: A): List[A] = {
          if (number == 0) List()
          else element :: fill(number - 1, element)
        }
        multiplicateHelper(list, multiplications, index + 1, acc ::: fill(multiplications(index), list(index)))
      }
    }
    multiplicateHelper(list, multiplications, 0, List())
  }

  def main(args: Array[String]): Unit = {
    println(multiplicate(List(1, 2, 5), List(2, 3, 2, 4))) //List(1, 1, 2, 2, 2, 5, 5)
    println(multiplicate(List(1, 2, 3), List (0, 3, 1, 4))) //List(2, 2, 2, 3))
  }
}

