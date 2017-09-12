object Cards extends Enumeration {
  type CardSuite = Value
  val Spade = Value("♠")
  val Heart = Value("♥")
  val Diamond = Value("♦")
  val Club = Value("♣")

  def isRed(card: CardSuite) = card == Heart || card == Diamond
}

println(Cards.isRed(Cards.Spade))
println(Cards.isRed(Cards.Heart))
println(Cards.isRed(Cards.Diamond))
println(Cards.isRed(Cards.Club))