val timezones = java.util.TimeZone.getAvailableIDs

val cnt1 = timezones
  .map(_.toString.split("/")(0))
  .groupBy(i => i)
  .mapValues(_.size)

val cnt2 = timezones
  .map(_.toString.split("/")(0))
  .groupBy(i => i)
  .transform((k, v) => v.size)

println(cnt1)
println(cnt2)