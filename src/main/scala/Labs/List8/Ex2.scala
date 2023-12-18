package Labs.List8


//Implement an application that supports the process
//of pizza configuration and its cost calculation.
//Each pizza can be one of three sizes: small, medium, large.
//
//There are four types of cakes: Italian, standard, pan pizza, and calzone.
//
//The price of each cake depends on the size and type.
//If the dough is a calzone, only small and medium-sized pizzas are available.
//It is configurable and is subject to change.
//A pizza can contain many ingredients (but this ingredient list may be changed in the future):
//-cheese
//-blue cheese
//-pepperoni
//-sausage
//-mushrooms
//-onion
//- hot pepper
//By default, each ingredient is supplied in a standard amount, but a large or an extra-large amount can be provided upon customer request.
//The price of each ingredient is individual and depends on the amount of the ingredient.
//There are pre-defined pizza combinations, e.g.
//
//Margherita
//
//Funghi
//
//Vegetariana
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
  def main(args : Array[String]): Unit = {
    val pizza = new Pizza(Size.Small, CakeType.italian, PizzaType.Margherita)
    println(pizza.calculatePrice())
    pizza.addTopping(Toppings.Pepperoni)
    println(pizza.calculatePrice())
  }
}
