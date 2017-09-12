object InchesToCentimeters extends UnitConversion(2.54)

object GallonsToLiters extends UnitConversion(3.78541)

object MilesToKilometers extends UnitConversion(1.60934)

abstract class UnitConversion(val rate: Double) {
  def convert(from: Double): Double = from * rate
}

println(InchesToCentimeters.convert(1))
println(GallonsToLiters.convert(1))
println(MilesToKilometers.convert(1))