package Labs.List4

object Ex1 {
  //Write the function decoding the list of pairs -
  // the number of occurrences of a given element, element - to the list of these elements.
  def decode(list: List[(Int, String)]): List[String] = {
    list.flatMap(x => List.fill(x._1)(x._2))
  }

}
