package Labs.List6

object Ex2 {
  //Let assume there is a tree with integer values. Write a function that returns a pair of minimal and maximal values of the binary tree nodes' values.
  //
  //example call: maxmin(Branch(2,Branch(3, Leaf, Leaf), Branch(4, Leaf, Branch(5, Leaf, Leaf))))
  //
  //result: List[Int] = (2, 5)
  sealed trait Tree
  case class Branch(value: Int, left: Tree, right: Tree) extends Tree
  case object Leaf extends Tree

  def maxmin(tree: Tree): (Int, Int) = {
    def maxminHelper(tree: Tree, minValue: Int, maxValue: Int): (Int, Int) = tree match {
      case Branch(value, left, right) => {
        val newMin = value min minValue
        val newMax = value max maxValue
        val leftResult = maxminHelper(left, newMin, newMax)
        val rightResult = maxminHelper(right, newMin, newMax)
        ((leftResult._1 min rightResult._1), (leftResult._2 max rightResult._2))
      }
      case Leaf => (minValue, maxValue)
    }
    maxminHelper(tree, Int.MaxValue, Int.MinValue)
  }

  def main(args: Array[String]): Unit = {
    val tree = Branch(2, Branch(3, Leaf, Leaf), Branch(4, Leaf, Branch(5, Leaf, Leaf)))
    println(maxmin(tree)) //gives (2, 5)
  }
}
