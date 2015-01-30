# Processes have names - every process on the system has one.
# It can be changed at runtime.

# Name of the current process
puts $PROGRAM_NAME # outputs chapter9.rb

10.downto(1) do |n|
  $PROGRAM_NAME = "Process #{n}"
  puts $PROGRAM_NAME
end

