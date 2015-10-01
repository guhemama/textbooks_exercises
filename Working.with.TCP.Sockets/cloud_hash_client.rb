require 'socket'

module CloudHash
  class Client
    class << self
      attr_accessor :host, :port
    end

    def self.get(key)
      request "GET #{key}"
    end

    def self.set(key, value)
      request "SET #{key} #{value}"
    end

    def self.request(string)
      @client = TCPSocket.new(host, port)
      @client.write(string)
      @client.close_write # Send EOF after writing
      @client.read # Wait for server to send EOF
    end
  end
end

CloudHash::Client.host = 'localhost'
CloudHash::Client.port = 4481

p CloudHash::Client.set 'prez', 'obamis'
p CloudHash::Client.get 'prez'
p CloudHash::Client.get  'vp'