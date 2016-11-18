val hex = 0x5
println(hex) // Scala always prints numbers in base 10 => 5

val hex2 = 0x00FF
println(hex2) // Base10 => 255

val dec1 = 31
println(dec1)

val dec2 = 255
println(dec2)

// Symbol literals
def updateRecordByName(r: Symbol, value: Any) = {
  println(value)
}

updateRecordByName('favoriteAlbum, "OK Computer")