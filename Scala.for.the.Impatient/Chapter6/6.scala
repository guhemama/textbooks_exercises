object Cards extends Enumeration {
  type CardSuite = Value
  val Spade = Value("♠")
  val Heart = Value("♥")
  val Diamond = Value("♦")
  val Club = Value("♣")
}

println(Cards.Spade)
println(Cards.Heart)
println(Cards.Diamond)
println(Cards.Club)