require 'socket'

# Create a new TCP socket
server = Socket.new(:INET, :STREAM)

# Create a C struct to hold the address for listening
addr = Socket.pack_sockaddr_in(4481, '0.0.0.0')

# Bind to it
server.bind(addr)

# Listen (param: listen queue limit)
server.listen(Socket::SOMAXCONN)

# Accept a connection
loop do
  connection, _ = server.accept
  connection.close
end
