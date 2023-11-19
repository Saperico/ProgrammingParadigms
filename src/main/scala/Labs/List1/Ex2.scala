package Labs.List1

object Ex2 {

  def fun(a:Int, b:Int): Int = {
    b match {
      case 0 => return a;
      case _ => fun (b, a % b)
    }
  }

  def main(args: Array[String]): Unit = {
      println(fun(2,3))//expected 1, got 1
      println(fun(8,12))//expected 4, got 4
      println(fun(-10,50))//expected 10 or -10, got -10
    //it's a function for the greatest common divisor
  }
}
