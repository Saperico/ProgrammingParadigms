package Labs.List2

object Ex1 {
  def XOR(a: Boolean, b: Boolean): Boolean = {
    (a,b) match{
      case (true, true) => false
      case (true, false) => true
      case (false, true) => true
      case (false, false) => false
    }
  }
  def main(args: Array[String]): Unit = {
    println(XOR(true, true)) // gives false
    println(XOR(true, false)) // gives true
    println(XOR(false, true)) // gives true
    println(XOR(false, false)) // gives false
  }
}
