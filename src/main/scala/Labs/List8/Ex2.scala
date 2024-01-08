package Labs.List8

object Ex2 {
  enum Size:
    case Small, Medium, Large;

  enum CakeType:
    case italian, standard, pan, calzone

  enum PizzaType:
    case Margherita, Pepperoni, Vegetarian, Hawaiian, Funghi

  enum Toppings:
    case Cheese, BlueCheese, Pepperoni, Sausage, Mushrooms, Onion, HotPepper, Pineapple, Ham

  class Pizza(val pizzaSize: Size, val cakeType: CakeType, val pizzaType: PizzaType) {
    if (cakeType == CakeType.calzone && pizzaSize == Size.Large) throw new Exception("Calzone can't be large")
    var toppings = List[Toppings]()
    pizzaType match
      case PizzaType.Margherita => toppings = List(Toppings.Cheese)
      case PizzaType.Pepperoni => toppings = List(Toppings.Cheese, Toppings.Pepperoni)
      case PizzaType.Vegetarian => toppings = List(Toppings.Cheese, Toppings.Mushrooms, Toppings.Onion, Toppings.HotPepper)
      case PizzaType.Hawaiian => toppings = List(Toppings.Cheese, Toppings.Ham, Toppings.Pineapple)
      case PizzaType.Funghi => toppings = List(Toppings.Cheese, Toppings.Mushrooms)

    def addTopping(topping: Toppings) = toppings = topping :: toppings

    def removeTopping(topping: Toppings) = toppings = toppings diff List(topping)

    def calculatePrice(): Double = {
      var price = 0.0
      pizzaSize match
        case Size.Small => price += 10
        case Size.Medium => price += 15
        case Size.Large => price += 20
      cakeType match
        case CakeType.italian => price += 1
        case CakeType.standard => price += 0
        case CakeType.pan => price += 2
        case CakeType.calzone => price += 3
      toppings.foreach {
        case Toppings.Cheese => price += 1
        case Toppings.BlueCheese => price += 2
        case Toppings.Pepperoni => price += 2
        case Toppings.Sausage => price += 2
        case Toppings.Mushrooms => price += 1
        case Toppings.Onion => price += 1
        case Toppings.HotPepper => price += 1
        case Toppings.Pineapple => price += 1.5
        case Toppings.Ham => price += 1
      }
      price
    }
  }
  class PizzaConfigurator(){
    def choosePizzaType(): PizzaType = {
      println("Choose pizza type:")
      PizzaType.values.zipWithIndex.foreach((pizzaType, index) => println(s"${index + 1}. ${pizzaType}"))
      val choice = getNumberFromInput(maxNumber = PizzaType.values.length)
      PizzaType.values(choice - 1)
    }
    def chooseCakeType(): CakeType = {
      println("Choose cake type:")
      CakeType.values.zipWithIndex.foreach((cakeType, index) => println(s"${index + 1}. ${cakeType}"))
      val choice = getNumberFromInput(CakeType.values.length)
      CakeType.values(choice - 1)
    }
    def choosePizzaSize(cakeType: CakeType): Size = {
      println("Choose pizza size:")
      var choice = 0
      if(cakeType == CakeType.calzone){
        println("1. Small")
        println("2. Medium")
        choice = getNumberFromInput(2)
      }
      else {
        Size.values.zipWithIndex.foreach((size, index) => println(s"${index + 1}. ${size}"))
        choice = getNumberFromInput(Size.values.length)
      }
      Size.values(choice - 1)
    }
    def configureToppingsOrEnd(pizza: Pizza): Unit = {
      println("1. Add topping")
      println("2. Remove topping")
      println("3. End")
      val choice = getNumberFromInput(3)
      choice match
        case 1 => addTopping(pizza)
        case 2 => removeTopping(pizza)
        case 3 => getCalculation(pizza)
    }
    def addTopping(pizza: Pizza): Unit = {
      println("Choose topping:")
      Toppings.values.zipWithIndex.foreach((topping, index) => println(s"${index + 1}. ${topping}"))
      val choice = getNumberFromInput(Toppings.values.length)
      pizza.addTopping(Toppings.values(choice - 1))
      configureToppingsOrEnd(pizza)
    }
    def removeTopping(pizza: Pizza): Unit = {
      println("Choose topping:")
      pizza.toppings.zipWithIndex.foreach((topping, index) => println(s"${index + 1}. ${topping}"))
      val choice = getNumberFromInput(pizza.toppings.length)
      pizza.removeTopping(pizza.toppings(choice - 1))
      configureToppingsOrEnd(pizza)
    }
    def getCalculation(pizza: Pizza) =
    {
      println("Your pizza:")
      println("Pizza type: " + pizza.pizzaType)
      println("Cake type: " + pizza.cakeType)
      println("Size: " + pizza.pizzaSize)
      println("Toppings: " + pizza.toppings)
      println("Price: " + pizza.calculatePrice())
    }
    def run(): Unit = {
      val pizzaType = choosePizzaType()
      println("You choose " + pizzaType + " pizza")
      val cakeType = chooseCakeType()
      println("You choose " + cakeType + " cake")
      val pizzaSize = choosePizzaSize(cakeType)
      println("You choose " + pizzaSize + " size")
      val pizza = new Pizza(pizzaSize, cakeType, pizzaType)
      configureToppingsOrEnd(pizza)
    }
    def getNumberFromInput(maxNumber:Int): Int = {
      var choice = scala.io.StdIn.readLine()
      if(!choice.forall(_.isDigit)){
        println("Input must be a number")
        getNumberFromInput(maxNumber)
      }
      else {
        var choiceInt = choice.toInt
        if (choiceInt < 1 || choiceInt > maxNumber) {
          println("Choose number from 1 to " + maxNumber)
          choiceInt = getNumberFromInput(maxNumber)
        }
        choiceInt
      }
    }
  }
  def main(args: Array[String]): Unit = {
    val configurator = new PizzaConfigurator()
    configurator.run()
  }
}
