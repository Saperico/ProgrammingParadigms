package Labs.List3

import scala.annotation.tailrec

object Ex2 {
  def countOddNumbers(list: List[Int]) : Int = {
    list match{
      case head :: tail => {
        if(head%2!=0)
          1 + countOddNumbers(tail)
        else  countOddNumbers(tail)
      }
      case Nil => 0
    }
  }

  def countOddNumbers2(list: List[Int]) : Int = {
    @tailrec def helper(list : List[Int], count : Int): Int = {
      list match{
        case Nil => count
        case head :: tail =>{
          if (head % 2 != 0)
            helper(tail,count+1)
          else
            helper(tail,count)
        }
      }
    }
    helper(list,0)
  }

  def main(args: Array[String]): Unit = {
    val list = List(1,2,3,4,5,6,7,8,9)
    println(countOddNumbers(list)) // -> 5
    println(countOddNumbers2(list))// -> 5
    val list2 = List(2,4,6,8)
    println(countOddNumbers(list2))// -> 0
    println(countOddNumbers2(list2))// -> 0
  }

}
