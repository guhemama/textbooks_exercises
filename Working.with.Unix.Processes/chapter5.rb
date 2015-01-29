# Processes have file descriptors, which represent open files.
# On Unix, everything is a file (oh really?); they can also be called resources.
# A running process is aways assigned a file descriptor number, which die when the process dies.

# Print a resource in Ruby (IO class)
passwd = File.open('/etc/passwd')
puts passwd.fileno

# Processes do not share their resources
hosts = File.open('/etc/hosts')
puts hosts.fileno

passwd.close

null = File.open('/dev/null')
puts null.fileno

# The standard Unix streams own the 0, 1, and 2 descriptors
puts STDIN.fileno  # 0
puts STDOUT.fileno # 1
puts STDERR.fileno # 2

