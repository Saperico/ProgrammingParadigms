package Labs.List8

object Ex1 {

  sealed class complexNumber(val real: Double, val imaginary: Double) {
    //def this(real: Double, imaginary: Double) = this(real, imaginary)//todo
    def +(that: complexNumber) = new complexNumber(real + that.real, imaginary + that.imaginary)
    def -(that: complexNumber) = new complexNumber(real - that.real, imaginary - that.imaginary)
    def *(that: complexNumber) = new complexNumber(real * that.real - imaginary * that.imaginary, real * that.imaginary + imaginary * that.real)
    def /(that: complexNumber) = new complexNumber((real * that.real + imaginary * that.imaginary) / (that.real * that.real + that.imaginary * that.imaginary), (imaginary * that.real - real * that.imaginary) / (that.real * that.real + that.imaginary * that.imaginary))
    def conjugation() = new complexNumber(real, -imaginary)

    override def equals(obj: Any): Boolean = {
      obj match {
        case that: complexNumber => real == that.real && imaginary == that.imaginary
        case _ => false
      }
    }

    override def toString = real + " + " + imaginary + "i"
  }
  def main(args: Array[String]): Unit = {
    val a = new complexNumber(1, -5) // 1 - 5i
    val b = new complexNumber(3, 4) // 3 + 4i
    println(a + b) // 4.0 - 1.0i
    println(a - b)// -2.0 - 9.0i
    println(a * b) // 23.0 - 11.0i
    println(a / b) // -0.68 - 0.76i
    println(a == b) // false
    println(a == new complexNumber(1, -5)) // true
    println(a.conjugation()) // 1 + 5i
  }
}
