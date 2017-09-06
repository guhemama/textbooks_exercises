class Time(private val hours: Int, private val minutes: Int) {
  def before(other: Time): Boolean = {
    if (this.hours < other.hours) {
      true
    } else if (this.hours == other.hours) {
      if (this.minutes < other.minutes) {
        true
      } else {
        false
      }
    } else {
      false
    }
  }
}

val t1 = new Time(10, 40)
val t2 = new Time(11, 30)

println(t1.before(t2))
println(t2.before(t1))