# The arithmetic expression to be computed
expr = "( 1 + ( ( 2 + 3) * ( 4 * 5 ) ) )"

# Stacks
operands = []
operators = []

# Process the expression
expr.split('').each do |char|
  operands << char.to_i if char =~ /\d/
  operators << char if char =~ /[\*\-\+\/]/

  # Compute last operation on right parenthesis
  if char == ')'
    operator = operators.pop
    operand1 = operands.pop
    operand2 = operands.pop

    operands << operand1.send(operator, operand2)
  end
end

puts operands[0]
