class Bag
  class Node
    attr_accessor :item, :next

    def initialize(item)
      @item = item
    end
  end

  attr_accessor :head, :tail, :size

  def initialize
    @size = 0
  end

  def add(item)
    node = Node.new(item)

    if @size == 0
      @head = node
      @tail = node
    else
      @tail.next = node
      @tail = node
    end

    @size += 1
  end

  def empty?
    @size == 0
  end

  def get_one
    if @size == 1
      item = @head.item
      @head, @tail = nil, nil
    else
      item = @head.item
      @head = @head.next
    end

    @size -= 1
    item
  end
end

b = Bag.new
b.add("oi")
b.add("tchau")
b.add("carade pau")

while !b.empty?
  puts b.get_one
end