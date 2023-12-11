package Classes.List7

object Playable {
  trait Playable {
    def play(): Unit
    def stop(): Unit
    def pause(): Unit
  }
  enum State {
    case Playing, Stopped, Paused
  }
  class MusicPlayer extends Playable {
    var state: State = State.Stopped
    override def play(): Unit = state = State.Playing
    override def stop(): Unit = state = State.Stopped
    override def pause(): Unit = state = State.Paused
  }
  def main(args: Array[String]): Unit = {
    val player = new MusicPlayer
    player.play()
    println(player.state)
    player.pause()
    println(player.state)
    player.stop()
    println(player.state)
  }
}
