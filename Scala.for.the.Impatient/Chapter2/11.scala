import java.time.LocalDate

implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
  def date(args: Any*): LocalDate = {
    if (args.length < 3) throw new Exception(s"The date interpolator requires 3 args, ${args.length} supplied.")

     LocalDate.of(args(0).toString.toInt, args(1).toString.toInt, args(2).toString.toInt)
  }
}

val year = 2017
val month = 8
val day = 22

val newDate = date"$year-$month-$day"

println(newDate)