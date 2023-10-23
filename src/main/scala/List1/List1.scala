package List1

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
    def generateParenthesesHelper(n: Int, open: Int, close: Int, str: String): List[String] = {
      if (open == n && close == n) List(str)
      else if (open == n) generateParenthesesHelper(n, open, close + 1, str + ")")
      else if (open == close) generateParenthesesHelper(n, open + 1, close, str + "(")
      else generateParenthesesHelper(n, open + 1, close, str + "(") ::: generateParenthesesHelper(n, open, close + 1, str + ")")
    }
    generateParenthesesHelper(n, 0, 0, "")
  }

  def knapsack(values: List[Int], weights: List[Int], capacity: Int): Int = {
    def knapsackHelper(values: List[Int], weights: List[Int], capacity: Int, index: Int): Int = {
      if (capacity == 0 || index == values.length) 0
      else if (weights(index) > capacity) knapsackHelper(values, weights, capacity, index + 1)
      else Math.max(values(index) + knapsackHelper(values, weights, capacity - weights(index), index + 1), knapsackHelper(values, weights, capacity, index + 1))
    }
    knapsackHelper(values, weights, capacity, 0)
  }

  def main(args: Array[String]) = {
    val list = List(1, 2, 3, 4, 5)
    println("Sum of list elements: " + sumList(list))
    println("GCD of 2 and 4: " + gcd(2, 4))
    println("Parentheses for 3: " + generateParentheses(5))
  }
}
