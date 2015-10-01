class LinkedList
  class Node
    attr_accessor :next, :item

    def initialize(item)
      @item = item
    end

    def has_next?
      !@next.nil?
    end

    def to_s
      @item
    end
  end

  attr_accessor :first, :last

  def add_first(item)
    node = Node.new item

    if @first.nil?
      @first = node
      @last  = node
    else
      node.next = @first
      @first = node
    end
  end

  def add_last(item)
    node = Node.new item

    if last.nil?
      @first = node
      @last  = node
    else
      @last.next = node
      @last = node
    end
  end

  def remove
    item = @first.item

    if @first.has_next?
      @first = @first.next
    else
      @first = nil
      @last  = nil
    end

    item
  end

  def each(&block)
    node = @first
    while !node.nil?
      yield node
      node = node.next
    end
  end

  def to_s
    output = ''

    self.each do |node|
      output += "#{node.item} -> "
    end

    output
  end
end

l = LinkedList.new
l.add_first 1
l.add_first 5
l.add_first 20
l.add_last 8
l.add_first 7

puts l

puts l.remove
puts l.remove

puts l

l.each { |n| puts n.item }