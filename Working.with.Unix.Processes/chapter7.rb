# Processes have an environment, which is inherited from its parent.
# You can get the env variables from the global ENV
puts ENV['SHELL']

# Set an env variable from Ruby
ENV['MESSAGE'] = 'wing it'
system "echo $MESSAGE"