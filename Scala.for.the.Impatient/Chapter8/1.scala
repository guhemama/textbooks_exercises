object Ex1 extends App {
  class BankAccount(initialBalance: Double) {
    protected var balance = initialBalance
    def currentBalance = balance
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
    def getBalance = balance
  }

  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
    def charge {balance -= 1}

    override def deposit(amount: Double) = {
      charge
      super.deposit(amount)
    }

    override def withdraw(amount: Double) = {
      charge
      super.withdraw(amount)
    }
  }

  val acc = new CheckingAccount(100)
  println(acc.deposit(10), 109)
  println(acc.withdraw(30), 78)
}