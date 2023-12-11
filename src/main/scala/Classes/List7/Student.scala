package Classes.List7

object Student {
  class Student(val name: String, val age: Int, val grade: Double) {
    override def toString: String = s"Student($name, $age, $grade)"
  }
  def main(args: Array[String]): Unit = {
    val students = List(
      new Student("John", 18, 1),
      new Student("Mary", 17, 2),
      new Student("Bob", 19, 3),
      new Student("Alice", 20, 4),
      new Student("Peter", 21, 5)
    )
    println(students)
    println(students.filter(_.grade > 3))
  }

}
