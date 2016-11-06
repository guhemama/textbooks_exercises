defmodule Drop do
  def fall_velocity(:earth, distance) when distance >= 0 do
    :math.sqrt(2 * 9.8 * distance)
  end
end

IO.puts Drop.fall_velocity(:earth, 10)
# Outputs 14

IO.puts Drop.fall_velocity(:earth, -10)
# FunctionClauseError (no matching function)