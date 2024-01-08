package Classes.List7


object Animal {
  abstract class Animal {
    def make_sound(): Unit
  }

  class Dog extends Animal {
    override def make_sound(): Unit = println("Woof")
  }

  class Cat extends Animal {
    override def make_sound(): Unit = println("Meow")
  }

  class Bird extends Animal {
    override def make_sound(): Unit = println("Chirp")
  }

  def main(args: Array[String]): Unit = {
    val list = List(new Dog, new Cat, new Bird)
    for (animal <- list) {
      animal.make_sound()
    }
  }
}
