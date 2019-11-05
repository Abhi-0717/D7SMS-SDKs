# d7_sms
#
# https://d7networks.com ).

module D7Sms
  # Message Model.
  class Message < BaseModel
    # Destination Number
    # @return [List of String]
    attr_accessor :to

    # Destination Number
    # @return [String]
    attr_accessor :content

    # Destination Number
    # @return [String]
    attr_accessor :from

    # A mapping from model property names to API property names.
    def self.names
      @_hash = {} if @_hash.nil?
      @_hash['to'] = 'to'
      @_hash['content'] = 'content'
      @_hash['from'] = 'from'
      @_hash
    end

    def initialize(to = nil,
                   content = nil,
                   from = nil)
      @to = to
      @content = content
      @from = from
    end

    # Creates an instance of the object from a hash.
    def self.from_hash(hash)
      return nil unless hash

      # Extract variables from the hash.
      to = hash['to']
      content = hash['content']
      from = hash['from']

      # Create object from extracted values.
      Message.new(to,
                  content,
                  from)
    end
  end
end
