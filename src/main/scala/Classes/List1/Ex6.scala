package Classes.List1

object Ex6 {
    object MyObject {
      def method() = {
        val x = 2 * 5
        x + 3
      }
    }

    def main(args: Array[String]): Unit = {
      println(MyObject.method())
      val add = (x: Int, y: Int, z: Int) => x + y + z
      println(add(2, 3, 7))
    }

}
