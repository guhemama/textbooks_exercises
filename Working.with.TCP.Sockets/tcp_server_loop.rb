require 'socket'

Socket.tcp_server_loop(4481) do |conn|
  # do stuff...
  conn.close
end