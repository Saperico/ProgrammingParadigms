package Classes.List7

object Shape {
  abstract class Shape {
    def area(): Double
  }

  class Circle(val radius: Double) extends Shape {
    override def area(): Double = Math.PI * radius * radius
  }

  class Rectangle(val width: Double, val height: Double) extends Shape {
    override def area(): Double = width * height
  }

  class Triangle(val width: Double, val height: Double) extends Shape {
    override def area(): Double = width * height / 2
  }

  def main(args: Array[String]): Unit = {
    val shapes = List(new Circle(1), new Rectangle(2, 3), new Triangle(2, 3))
    for (shape <- shapes) {
      println(shape.area())
    }
  }
}
