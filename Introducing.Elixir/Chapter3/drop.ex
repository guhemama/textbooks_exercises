defmodule Drop do
  def fall_velocity(:earth, distance) do
    :math.sqrt(2 * 9.8 * distance)
  end

  def fall_velocity(:moon, distance) do
    :math.sqrt(2 * 1.6 * distance)
  end
end

IO.puts Drop.fall_velocity(:earth, 10)
IO.puts Drop.fall_velocity(:moon, 10)