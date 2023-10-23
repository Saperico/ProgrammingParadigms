package Labs.List1

object Ex2 {

  def fun(a:Int, b:Int): Int = {
    b match {
      case 0 => return a;
      case _ => fun (b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
      println(fun(2,3))
      println(fun(8,12))
    //function for largest common denominator
  }
}
