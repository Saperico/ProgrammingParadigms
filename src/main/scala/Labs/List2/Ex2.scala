package Labs.List2

object Ex2 {
  def arithmeticSequence(firstNumber : Double, difference: Double, size: Int) : List[Double] = {
    if(size <= 0) {
      println("Size must be greater than 0")
      return List()
    }
    def arithmSequenceHelper(currentNumber: Double, currentSize: Int, acc: List[Double]) : List[Double] = {
      if(currentSize == 0) acc
      else arithmSequenceHelper(currentNumber + difference, currentSize - 1, acc :+ currentNumber)
    }
    arithmSequenceHelper(firstNumber, size, List())
  }

  def main(args: Array[String]): Unit = {
    println(arithmeticSequence(1.1, -2.23, 5)) // result is List(1.1, -1.13, -3.36, -5.59, -7.82)
    println(arithmeticSequence(1,3,4)) // 1,4,7,10
    println(arithmeticSequence(1,3,0)) // empty list
  }
}
