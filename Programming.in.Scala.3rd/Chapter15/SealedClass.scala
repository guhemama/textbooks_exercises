sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

object App {
  // This function will compile but show warnings because Expr is sealed, and
  // the function doesn't handle all possible classes (all classes that extend Expr)
  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
  }
}