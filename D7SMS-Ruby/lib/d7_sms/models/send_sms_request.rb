# d7_sms
#
# https://d7networks.com ).

module D7Sms
  # Send SMS Request
  class SendSMSRequest < BaseModel
    # Destination Mobile Number
    # @return [Long]
    attr_accessor :to

    # Sender ID / Number
    # @return [String]
    attr_accessor :from

    # Message Content
    # @return [String]
    attr_accessor :content

    # A mapping from model property names to API property names.
    def self.names
      @_hash = {} if @_hash.nil?
      @_hash['to'] = 'to'
      @_hash['from'] = 'from'
      @_hash['content'] = 'content'
      @_hash
    end

    def initialize(to = nil,
                   from = nil,
                   content = nil)
      @to = to
      @from = from
      @content = content
    end

    # Creates an instance of the object from a hash.
    def self.from_hash(hash)
      return nil unless hash

      # Extract variables from the hash.
      to = hash['to']
      from = hash['from']
      content = hash['content']

      # Create object from extracted values.
      SendSMSRequest.new(to,
                         from,
                         content)
    end
  end
end
