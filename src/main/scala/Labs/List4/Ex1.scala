package Labs.List4

object Ex1 {
  //Write the function decoding the list of pairs -
  // the number of occurrences of a given element, element - to the list of these elements.
  def decode(list: List[(Int, String)]): List[String] = {
    def helper(list: List[(Int, String)], acc: List[String]): List[String] = {
      list match {
        case Nil => acc
        case head :: tail => {
          val (number, element) = head
          helper(tail, acc ::: List.fill(number)(element))
        }
      }
    }
    helper(list, List())
  }
  def main(args: Array[String]): Unit = {
    val list = List((4, "a"), (1, "b"), (2, "c"), (2, "a"), (1, "d"), (4, "e"))
    println(decode(list))
  }

}
