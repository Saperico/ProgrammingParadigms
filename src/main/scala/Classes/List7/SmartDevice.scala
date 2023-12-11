package Classes.List7

object SmartDevice {
  trait SmartDevice {
    def turnOn() : Unit
    def turnOff() : Unit
  }
  class SmartLight extends SmartDevice {
    var light = false

    override def turnOn(): Unit = {
      light = true
    }
    def turnOff(): Unit = {
      light = false
    }
  }

  class SmartThermometer extends SmartDevice {
    var temperature = 0.0

    override def turnOn(): Unit = {
      temperature = 37.0
    }
    def turnOff(): Unit = {
      temperature = 0.0
    }
  }

}
