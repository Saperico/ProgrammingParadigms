package Labs.List5

object Ex3 {
  def split[A](list: LazyList[A]): (LazyList[A], LazyList[A]) = {
    list match {
      case LazyList() => (LazyList(), LazyList())
      case LazyList(x) => (LazyList(x), LazyList())
      case x #:: y #:: xs => {
        val (odd, even) = split(xs)
        (x #:: odd, y #:: even)
      }
    }
  }

def main(args: Array[String]): Unit = {
    val list = LazyList(1,11,12,2, 3, 4, 5, 6, 7, 8, 9)
    val (odd, even) = split(list)
    println(odd.toList) //List(1, 3, 5, 7, 9)
    println(even.toList)//List(2, 4, 6, 8)
  }
}
