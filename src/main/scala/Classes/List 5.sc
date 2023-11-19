//1. Define a function which for each number k (1…n) converts lazy list to another lazy list
//in which eachelement of input list occurs k times
//lrepeat : [A](k: Int)(lxs: LazyList[A])LazyList[A]

def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] = {
  def lrepeatHelper[A](k: Int)(lxs: LazyList[A], acc: LazyList[A]): LazyList[A] = {
    if (k == 0) acc
    else lrepeatHelper(k-1)(lxs, acc ++ lxs)
  }
  lrepeatHelper(k)(lxs, LazyList())
}

val lrepeatTest = lrepeat(3)(LazyList(1,2,3))
println(lrepeatTest.toList)

//2. Define function which generate Fibonacci Sequence in lazy way
//fib: LazyList[Int]

def fib: LazyList[Int] = {
  def fibHelper(a: Int, b: Int): LazyList[Int] = {
    LazyList.cons(a, fibHelper(b, a+b))
  }
  fibHelper(0, 1)
}

val fibTest = fib.take(10)
println(fibTest.toList)

//3. For lazy binary tree:
//trait lBT[+A]
//case object LEmpty extends lBT[Nothing] case class
//LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A])
//extends lBT[A]
//define function which generate infinity tree which as root has number n (parameter)
//and sub trees: Tree (2*n) and Tree(2*n+1).

trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

def lTree(n: Int): lBT[Int] = {
  LNode(n, () => lTree(2*n), () => lTree(2*n+1))
}

val lTreeTest = lTree(1)
println(lTreeTest)

//Describe null-safety mechanism (you can use Kotlin as example

//Null safety is a set of language features that aim to eliminate the danger of null references in
//our code. Kotlin's type system is aimed to eliminate NullPointerException's from our code.
//The only possible causes of NPE's may be:

//var a: String = "abc" // Regular initialization means non-nullable by default
//a = null // compilation error

//var b: String? = "abc" // can be set to null
//b = null // ok
//print(b)

//5 List min 3 features of Kotlin which not exist in Scala.

  //1. Null safety
  //2. Data classes
  //3. Coroutines
  //4. Extension functions
  //5. Smart casts
  //6. String templates

//6. Describe mechanisms which Scala uses to support lazy evaluation
//Scala uses lazy evaluation to avoid needless computation, and to create data structures
//that would otherwise be impossible, such as infinite lists and trees. Lazy evaluation
//is useful when evaluating an expression is time consuming, or may not terminate.
//Scala supports lazy evaluation with call-by-name parameters and lazy fields.




