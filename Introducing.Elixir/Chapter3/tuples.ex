defmodule Drop do
  def fall_velocity({:earth, distance}) when distance >= 0 do
    :math.sqrt(2 * 9.8 * distance)
  end
end

tuple = {:earth, 20}

IO.puts Drop.fall_velocity(tuple)