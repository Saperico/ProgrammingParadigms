package Classes.List1

object List1 {
  def gcd(a: Int, b: Int): Int = {
    b match {
      case 0 => return a;
      case _ => gcd(b, a % b)
    }
  }

  def sumList(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: tail => head + sumList(tail)
    }
  }

  def generateParentheses(n: Int): List[String] = {
    def parenthesesHelper(n: Int, open: Int, close: Int, str: String): List[String] = {
      if (open == n && close == n) List(str)
      else if (open == n) parenthesesHelper(n, open, close + 1, str + ")")
      else if (open == close) parenthesesHelper(n, open + 1, close, str + "(")
      else parenthesesHelper(n, open + 1, close, str + "(") ::: parenthesesHelper(n, open, close + 1, str + ")")
    }
    parenthesesHelper(n, 0, 0, "")
  }

  def knapsack(values: List[Int], weights: List[Int], capacity: Int): Int = {
    def kspHelper(values: List[Int], weights: List[Int], capacity: Int, index: Int): Int = {
      if (capacity == 0 || index == values.length) 0
      if (weights(index) > capacity) kspHelper(values, weights, capacity, index + 1)
      else Math.max(values(index) +
        kspHelper(values, weights, capacity - weights(index), index + 1),
        kspHelper(values, weights, capacity, index + 1))
    }
    kspHelper(values, weights, capacity, 0)
  }

  def main(args: Array[String]) = {
    val list = List(1, 2, 3, 4, 5)
    println("Sum of list elements: " + sumList(list))
    println("GCD of 2 and 4: " + gcd(2, 4))
    println("Parentheses for 2: " + generateParentheses(2))
  }
}
