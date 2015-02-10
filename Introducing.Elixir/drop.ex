defmodule Drop do
  def fall_velocity(distance) do
    :math.sqrt(2 * 9.8 * distance)
  end

  # Public function
  def mps_to_mph(mps) do
    2.23 * mps
  end

  # Private function
  defp mps_to_kpg(mps) do
    3.6 * mps
  end
end
