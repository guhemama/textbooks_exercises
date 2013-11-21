require 'awesome_print'

class QuickUnion
  attr_accessor :id, :count

  def initialize(n)
    @id = Array.new(n) { |idx| idx }
    @count = n
  end

  def find(p)
    while p != @id[p]
      p = @id[p]
    end

    p
  end

  def connected?(p, q)
    @id[p] == @id[q]
  end

  def union(p, q)
    i = find(p)
    j = find(q)

    if i == j
      return
    end

    @id[i] = j

    @count -= 1
  end
end