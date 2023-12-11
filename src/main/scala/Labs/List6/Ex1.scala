package Labs.List6

object Ex1 {
  //Define a function that filters items from the lazy list of lazy list. The function is supposed to have two parameters: lazy list of lazy lists and number. Only lazy lists whose length is greater than or equal to the specified value are to remain in the result list.
  //Example: lazyfilter(LazyList(LazyList(1,2,3), LazyList(2,3), LazyList(4.5) ), 3 ) -> LazyList( LazyList(1,2,3))
  def lazyFilter[A](list : LazyList[LazyList[A]], filter : Int):(LazyList[LazyList[A]])= {
    list.filter(_.take(filter).length == filter)
  }

  def main(args: Array[String]): Unit = {
    val list = LazyList(LazyList(1,2,3), LazyList(2,3), LazyList(4,5) )
    println(lazyFilter(list,3).flatten.toList) // gives List(1, 2, 3) as expected
    val list2 = LazyList(LazyList(1),LazyList(1,2),LazyList(1,2,3))
    println(lazyFilter(list2,2).take(1).flatten.toList)// List(1, 2) as expected
    val list3 = LazyList(infiniteList(1), infiniteList(1))
    println(lazyFilter(list3, 10).take(2).toList) // gives 2 infinite lists with first 10 elements computed
  }
  def infiniteList(n: Int): LazyList[Int] = {
    LazyList.cons(n, infiniteList(n + 1))
  }
}
