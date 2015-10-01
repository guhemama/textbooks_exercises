def select_sort(arr)
  n = arr.length - 1

  0.upto(n) do |i|
    # Current value
    min = i

    # Find the minimal value
    (i + 1).upto(n) do |j|
      min = j if arr[j] < arr[min]
    end

    # Swap values
    arr[i], arr[min] = arr[min], arr[i]
  end

  arr
end

p select_sort [1, 2, 3]
p select_sort [10, 9, 2, 5, 3, 4]