package Classes.List7

object FitnessActivity {
  //Design an abstract class FitnessActivity with an abstract method performActivity(). Extend it with running and swimming. Implement an interface Trackable with method trackDuration().
  abstract class FitnessActivity {
    def performActivity(time: Int): Unit
  }
  
  sealed trait Trackable {
    var duration: Int = 0
    def trackDuration(): Int
  }
  class Swimming extends FitnessActivity with Trackable {
    override def performActivity(time: Int): Unit = {
      duration = duration + time
      println("Swimming for " + time + " minutes")
    }
    override def trackDuration(): Int = duration
  }
  class Running extends FitnessActivity with Trackable {
    override def performActivity(time: Int): Unit = {
      duration = duration + time
      println("Running for " + time + " minutes")
    }
    override def trackDuration(): Int = duration
  }
  
}
  
