package Labs.List1

object Ex1 {
  def getFractional(n: Double): Double = {
    return n - n.toInt;
  }

  def main(args: Array[String]): Unit = {
    println(getFractional(3));
    println(getFractional(3.14));
    println(0.14);
  }
}
