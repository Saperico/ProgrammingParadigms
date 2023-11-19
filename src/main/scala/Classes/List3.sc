import scala.annotation.tailrec
//. Create a method reversing a list:
//a) regular recursion,
//b) tail recursion.
//2. Create a method that merges two lists in such a way that elements of both lists
//alternate, e.g. for lists [1, 2, 3] and [4, 5, 6] result is [1, 4, 2, 5, 3, 6]. If one of the lists
//has mor elements than the other add rest of them to the end of the result.
//3. Write function which split list to two lists:
//a) first include only odd numbers
//b) second include only even numbers
//4. Define the replaceNth function which replace the n-th element of the list by given
//value. replaceNth: [A](xs: List[A], n: Int, x: A)List[A]
//Remember to do not use standard library functions here.
//5. Explain how to implement a tail-recursive function to process elements of a large list
//(e.g., filtering or mapping operations) without running into stack overflow.
//6. Create a tail-recursive function to remove consecutive duplicates in a list.
//7. Write a tail-recursive function to zip two lists into a list of pairs. (given lists have
//same size)

@tailrec
def reverseListRec[A](list: List[A], acc: List[A]): List[A] = {
  list match {
    case Nil => acc
    case head :: tail => reverseListRec(tail, head :: acc)
  }
}
def reverseList[A](list: List[A]): List[A] = {
  reverseListRec(list, Nil)
}

val list = List(1, 2, 3, 4, 5)
println(reverseList(list))

def reverseListWithoutTailRec[A](list: List[A]): List[A] = {
  list match {
    case Nil => Nil
    case head :: tail => reverseListWithoutTailRec(tail) ::: List(head)
  }
}

println(reverseListWithoutTailRec(list))

def mergeLists[A](list1: List[A], list2: List[A]): List[A] = {
  (list1, list2) match {
    case (Nil, Nil) => Nil
    case (Nil, head :: tail) => head :: tail
    case (head :: tail, Nil) => head :: tail
    case (head1 :: tail1, head2 :: tail2) => head1 :: head2 :: mergeLists(tail1, tail2)
  }
}

val list1 = List(1, 2, 3)
val list2 = List(4, 5, 6)
println(mergeLists(list1, list2))

//3. Write function which split list to two lists:
//a) first include only odd numbers
//b) second include only even numbers

def splitListEvenOdd(list : List[Int]) : (List[Int], List[Int]) = {
  list match {
    case Nil => (Nil, Nil)
    case head :: tail => {
      val (even, odd) = splitListEvenOdd(tail)
      if (head % 2 == 0) (head :: even, odd)
      else (even, head :: odd)
    }
  }
}

val list3 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
println(splitListEvenOdd(list3))

//4. Define the replaceNth function which replace the n-th element of the list by given
//value. replaceNth: [A](xs: List[A], n: Int, x: A)List[A]
//Remember to do not use standard library functions here.

def replaceNth[A](list : List[A], n: Int, x: A):List[A] ={
  if(n > list.length) {
    return list
  }
  def replaceNthHelper[A](list: List[A], n: Int, x: A, acc: List[A]): List[A] = {
    n match {
      case 0 => acc ::: x :: list.tail
      case _ => replaceNthHelper(list.tail, n - 1, x, acc ::: List(list.head))
    }
  }
  replaceNthHelper(list, n, x, Nil)
}

val list4 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
println(replaceNth(list4, 3, 10))

//6. Create a tail-recursive function to remove consecutive duplicates in a list.

def removeConsecutiveDuplicates[A](list: List[A]): List[A] = {
  if(list.isEmpty) return list
  def removeHelper[A](list: List[A], acc: List[A], lastElement: A) : List[A] = {
    list match{
      case Nil => acc
      case head :: tail => {
        if(head == lastElement) removeHelper(tail, acc, head)
        else removeHelper(tail, acc ::: List(head), head)
      }
    }
  }
  list.head::removeHelper(list.tail, Nil, list.head)
}

val list6 = List(1, 1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 6)
println(removeConsecutiveDuplicates(list6))

