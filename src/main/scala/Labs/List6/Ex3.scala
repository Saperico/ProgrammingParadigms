package Labs.List6

object Ex3 {
  //Write a function that replicates items in a lazy list based on a second lazy list
  //
  //    specifying the number of times items are to be duplicated.
  //    Write the function in functional style Scala using LazyList.
  //
  //    example: multiplicate( LazyList(1, 2, 3),LazyList (0, 3, 1, 4)) gives the result LazyList(2, 2, 2, 3)
  def multiplicate(l1: LazyList[Int], l2: LazyList[Int]): LazyList[Int] = {
    l1.zip(l2).flatMap{case (x, y) => LazyList.fill(y)(x)}
  }

  def main(args: Array[String]): Unit = {
    val l1 = LazyList(1, 2, 3)
    val l2 = LazyList(0, 3, 1, 4)
    println(multiplicate(l1, l2).toList)////List(2, 2, 2, 3)
    println(multiplicate(infiniteList(1), infiniteList(1)).take(10).toList)//List(1, 2, 2, 3, 3, 3, 4, 4, 4, 4)
  }
  def infiniteList(n: Int): LazyList[Int] = {
    LazyList.cons(n, infiniteList(n + 1))
  }
}
