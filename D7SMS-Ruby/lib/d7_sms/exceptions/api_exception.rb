# d7_sms
#
# https://d7networks.com ).

module D7Sms
  # Class for exceptions when there is a network error, status code error, etc.
  class APIException < StandardError
    attr_reader :context, :response_code

    # The constructor.
    # @param [String] The reason for raising an exception.
    # @param [HttpContext] The HttpContext of the API call.
    def initialize(reason, context)
      super(reason)
      @context = context
      @response_code = context.response.status_code
    end
  end
end
