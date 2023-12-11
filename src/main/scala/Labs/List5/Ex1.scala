package Labs.List5

object Ex1 {

  sealed trait Tree
  case class Branch(value: String, left: Tree, right: Tree) extends Tree
  case object Leaf extends Tree

  def find(text: String, tree: Tree): List[String] = {
    tree match {
      case Leaf => List()
      case Branch(value, left, right) => {
        if (value.indexOf(text) != -1) {
          value :: find(text, left) ::: find(text, right)
        } else {
          find(text, left) ::: find(text, right)
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(find("Tes", Branch("Test",Branch("Testtt", Leaf, Leaf),
      Branch("estt", Leaf, Branch("SuperTes", Leaf, Leaf)))))//List(Test, Testtt, SuperTes)
  }
}
