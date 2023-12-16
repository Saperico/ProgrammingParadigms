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
    val a = new complexNumber(1, 2)
    val b = new complexNumber(3, 4)
    println(a + b)
    println(a - b)
    println(a * b)
    println(a / b)
    println(a == b)
    println(a == new complexNumber(1, 2))
    println(a.conjugation())
  }
}
