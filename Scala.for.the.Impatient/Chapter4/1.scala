val gizmos: Map[String, Double] = Map("Mumbo" -> 10, "Jumbo" -> 15, "Thinga" -> 18, "Majig" -> 22)

val discountedGizmos = for ((gizmo, price) <- gizmos) yield (gizmo, price * 0.9)

println(gizmos)
println(discountedGizmos)