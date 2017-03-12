class Queue[T] private (
  private val leading: List[T],
  private val trailing: List[T]
) {
  private def mirror =
    if (leading.isEmpty)
      new Queue(trailing.reverse, Nil)
    else
      this

  def head = mirror.leading.head

  def tail = {
    val q = mirror
    new Queue(q.leading.tail, q.trailing)
  }

  // This method signature is covariant and
  // allows you to append an arbitrary supertype U of the queue element type
  def enqueue[U >: T](x: U) =
    new Queue[U](leading, x :: trailing)
}

object Queue {
  // A factory method that constructs a queue with initial elements 'xs'.
  // T* is the notation for repeated parameters.
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}