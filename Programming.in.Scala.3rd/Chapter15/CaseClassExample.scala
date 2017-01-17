abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

// The new keyword is not necessary
val v = Var("x")

// Which allows you to easily next the new instances
val op = BinOp("+", Number(1), v)


// You can easily use pattern matching to simplify the code.
// This, in imperative style, would require tons of if's and else's.
def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) => e   // Double negation
  case BinOp("+", e, Number(0)) => e // Adding zero
  case BinOp("*", e, Number(1)) => e
  case _ => expr // Multiplying by one
}