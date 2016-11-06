# Processes have resource limits, which are imposed by the kernel.

# Ruby maximum allowed file descriptors
p Process.getrlimit(:NOFILE) # [soft limit, hard limit]

# Bumping the soft limit
Process.setrlimit(:NOFILE, 4096)
p Process.getrlimit(:NOFILE)

# Exceeding the limit will raise an exception
Process.setrlimit(:NOFILE, 1)
File.open('/dev/null')