require 'socket'

Socket.tcp_server_loop(4481) do |conn|
  puts conn.read
  conn.close
end