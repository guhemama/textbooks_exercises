require 'socket'

# Create a new TCP socket
server = TCPServer.new(4481)

Socket.accept_loop(server) do |conn|
  conn.close
end