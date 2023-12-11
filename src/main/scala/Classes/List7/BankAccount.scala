package Classes.List7

object BankAccount {
  class BankAccount(private var _balance: Double) {
    def balance = _balance

    def deposit(amount: Double) = {
      _balance += amount
      _balance
    }

    def withdraw(amount: Double) = {
      if(amount > _balance) throw new Exception("Not enough money")
      _balance -= amount
      _balance
    }
  }
  def main(args: Array[String]): Unit = {
    val account = new BankAccount(1000)
    println(account.balance)
    account.deposit(100)
    println(account.balance)
    account.withdraw(100)
    println(account.balance)
  }
}
