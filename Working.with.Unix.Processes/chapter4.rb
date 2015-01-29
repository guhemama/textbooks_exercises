# Processes have parents, related to it by its ppid (parent pid).
# It's usually the process that invoked the child processes.
puts Process.ppid