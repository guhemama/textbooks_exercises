def sort(arr)
  return arr if arr.length < 2

  middle = arr.length / 2

  left  = sort arr[0..(middle - 1)]
  right = sort arr[middle..-1]

  merge left, right
end

def merge(left, right)
  result = []

  while left.any? || right.any?
    result <<
      if left.empty?
        right.shift
      elsif right.empty?
        left.shift
      elsif left[0] > right[0]
        right.shift
      else
        left.shift
      end
  end

  result
end


input = 20.downto(1).to_a.shuffle
p input
p sort input