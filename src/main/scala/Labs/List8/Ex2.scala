package Labs.List8

object Ex2 {
  enum Size:
      case Small, Medium, Large;

  enum CrustSize:
    case italian, standard, pan, calzone

  enum PizzaTypes:
    case Margherita, Pepperoni, Vegetarian, Hawaiian

  enum Toppings:
    case Cheese, Pepperoni, Olives, Mushrooms, Onions, Ham, Pineapple, Chicken, Bacon

  class Pizza(var crustSize: CrustSize, var crustType: String) {
    var toppings = Set[Toppings]()
    def this(crustSize: CrustSize) {
      this(crustSize, "Thin")
    }
    def this(crustType: String) {
      this(CrustSize.standard, crustType)
    }
    def this() {
      this(CrustSize.standard, "Thin")
    }
    override def toString: String = s"A $crustSize inch pizza with a $crustType crust"
  }

}
