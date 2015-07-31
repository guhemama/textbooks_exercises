def heapsort(arr)
  # Heapify the input array
  heapify = lambda do |arr|
    first = (arr.length - 2) / 2

    while first >= 0 do
      arr = sift_down(arr, first, arr.length - 1)
      first -= 1
    end

    arr
  end

  arr  = heapify.call arr
  last = arr.length - 1

  # Sifts down the array elements, 'fixing it'
  while last > 0 do
    arr[last], arr[0] = arr[0], arr[last]
    last -= 1
    arr = sift_down(arr, 0, last)
  end

  arr
end

def sift_down(arr, first, last)
  root = first

  while root * 2 + 1 <= last do
    elm1 = root * 2 + 1
    elm2  = root

    if arr[elm1] < arr[elm2]
      elm1 = elm2
    end

    if elm2 + 1 <= last && arr[elm1] < arr[elm2 + 1]
      elm1 = elm2 + 1
    end

    if elm1 == root
      break
    else
      arr[root], arr[elm1] = arr[elm1], arr[root]
      root = elm1
    end
  end

  arr
end

puts "[5, 4, 3, 2, 1] was ordered into #{heapsort([5,4,3,2,1]).to_s}"
