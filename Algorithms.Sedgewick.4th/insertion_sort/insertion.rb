def insert_sort(arr)
  n = arr.length

  1.upto(n - 1) do |i|
    (i).downto(1) do |j|
      break if arr[j] > arr[j - 1]

      # Swap values
      arr[j], arr[j - 1] = arr[j - 1], arr[j]
    end
  end

  arr
end

p insert_sort [1, 2, 3]
p insert_sort [10, 9, 2, 5, 3, 4]
p insert_sort 100.downto(0).to_a