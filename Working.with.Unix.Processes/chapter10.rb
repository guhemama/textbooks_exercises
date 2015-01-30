# Processes have exit codes.
# Every process that exits does so with a numeric exit code (0-255)

# Kernel#exit
exit

# Custom exit code
exit 133

# Invoke block at exit
at_exit { puts 'Exit' }
exit

# Exists with status code 1 (default) and doesn't invoke at_exit
exit!

# Exit a process unsuccessfully
abort "Something went wrong."

# An unhandled exception will also end a process; exit code will be 1
raise 'hell'