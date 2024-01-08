package Labs.List4

object Ex3 {
  def grayCode(k: Int): List[String] = {
    if(k<=0) return List()
    def helper(k: Int, acc: List[String]): List[String] = {
      if (k == 1) acc
      else {
        val reversed = acc.reverse.map(x=> "1" + x)
        helper(k-1, acc.map(x=> "0" + x) ::: reversed)
      }
    }
    helper(k, List("0", "1"))
  }


  def main(args: Array[String]): Unit = {
    println(grayCode(1)) // List(0, 1)
    println(grayCode(2)) // List(00, 01, 11, 10)
    println(grayCode(3)) // List(000, 001, 011, 010, 110, 111, 101, 100)
  }
}
