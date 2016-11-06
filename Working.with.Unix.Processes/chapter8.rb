# Processes have arguments, accessible from a variable called ARGV (argument vector).
p ARGV

# ARGV is an array and accepts its methods
puts ARGV.include?('--help')