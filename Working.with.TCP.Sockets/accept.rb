require 'socket'

# Create a new TCP socket
socket = Socket.new(:INET, :STREAM)

# Create a C struct to hold the address for listening
addr = Socket.pack_sockaddr_in(4481, '0.0.0.0')

# Bind to it
socket.bind(addr)

# Listen (param: listen queue limit)
socket.listen(Socket::SOMAXCONN)

# Accept a connection
connection, _ = socket.accept