class QuickFind
  attr_accessor :id, :count

  def initialize(n)
    @id = Array.new(n) { |idx| idx + 1 }
    @count = n
  end

  def find(p)
    @id[p]
  end

  def connected?(p, q)
    @id[p] == @id[q]
  end

  def union(p, q)
    return if connected?(p, q)

    p_id = @id[p]

    @id.each_with_index do |item, idx|
      @id[idx] = @id[q] if @id[idx] == p_id
    end

    @count -= 1
  end
end