package Labs.List4

object Ex3 {
  //Write a function that generates the Gray code for a given k
  //    example: gray(3) gives the result List(000, 001, 011, 010, 110, 111, 101, 100)
  def gray(k: Int): List[String] = {
    if(k<=0) return List()
    if (k == 1) return List("0", "1")
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
    println(gray(3))
  }
}
