# Processes can fork - it creates an exact copy of the original process.
# The child process inherits a copy of all the memory in use by the parent
# process. indlucing open file descriptors belonging to it.

# It gets an unique pid
# ppid will be the pid of the parent process

puts "Parent process pid is #{Process.pid}"

if fork
  puts "Entered the if block from #{Process.pid}"
else
  puts "Entered the else block from #{Process.pid}"
end

# Execute block in a fork
fork do
  puts "calculating"
end