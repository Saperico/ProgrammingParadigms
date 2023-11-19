package Labs.List1

object Ex1 {
  def getFractional(n: Double): Double = {
    if(n < 0) return -n + n.toInt;
    return n - n.toInt;
  }

  def main(args: Array[String]): Unit = {
    println(getFractional(3));//expected 0, got 0.0
    println(getFractional(3.14));//expected 0.14, but got 0.14000000000000012 - it's float point error
    println(0.14);
    println(getFractional(-0.1))//expected 0.1
    println(getFractional(21.37))//expected 0.37, but got 0.370000000000001
  }
}
