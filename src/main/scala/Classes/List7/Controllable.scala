package Classes.List7

object Controllable {
  trait Controllable {
    var currentSpeed : Double = 0
    def increaseSpeed(): Unit
    def decreaseSpeed(): Unit
  }
  class Car(maxSpeed : Double) extends Controllable {
    override def increaseSpeed(): Unit = {
      currentSpeed = Math.max(currentSpeed + 2, maxSpeed)
    }
    override def decreaseSpeed(): Unit = {
      currentSpeed = Math.max(currentSpeed - 5, 0)
    }
  }
  class Bike(maxSpeed : Double) extends Controllable {
    override def increaseSpeed(): Unit = {
      currentSpeed = Math.max(currentSpeed + 0.5, maxSpeed)
    }
    override def decreaseSpeed(): Unit = {
      currentSpeed = Math.max(currentSpeed - 3, 0)
    }
  }
}
