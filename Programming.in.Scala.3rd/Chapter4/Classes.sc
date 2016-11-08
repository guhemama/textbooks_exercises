class ChecksumAccumulator {
  private var sum = 0
  def add(b: Byte): Unit = sum += b
  def checksum(): Int = ~(sum & 0xFF) + 1
}

val acc = new ChecksumAccumulator
acc.add(1)
acc.add(8)
println(acc.checksum)